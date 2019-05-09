package com.jinkuangkj.open.controller;

import java.io.File;
import java.net.URLEncoder;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.binarywang.utils.qrcode.QrcodeUtils;
import com.github.binarywang.wxpay.bean.order.WxPayMpOrderResult;
import com.github.binarywang.wxpay.bean.request.WxPayUnifiedOrderRequest;
import com.github.binarywang.wxpay.constant.WxPayConstants.TradeType;
import com.github.binarywang.wxpay.exception.WxPayException;
import com.github.binarywang.wxpay.service.WxPayService;
import com.github.pagehelper.PageInfo;
import com.jinkuangkj.open.config.exp.BusinessException;
import com.jinkuangkj.open.config.open.OpenConfig;
import com.jinkuangkj.open.mapper.ContactDao;
import com.jinkuangkj.open.model.ActOrder;
import com.jinkuangkj.open.model.ActUser;
import com.jinkuangkj.open.model.Activity;
import com.jinkuangkj.open.model.Contact;
import com.jinkuangkj.open.model.result.OrderResult;
import com.jinkuangkj.open.service.ActOrderService;
import com.jinkuangkj.open.service.ActUserService;
import com.jinkuangkj.open.service.ActivityService;
import com.jinkuangkj.open.util.AmountUtils;
import com.jinkuangkj.open.util.URLUtil;

import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.bean.WxJsapiSignature;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.WxMpSubscribeMsgService;
import me.chanjar.weixin.mp.api.impl.WxMpSubscribeMsgServiceImpl;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
import me.chanjar.weixin.mp.bean.subscribe.WxMpSubscribeMessage;




@Slf4j
@Controller
@RequestMapping("/open")
public class OpenController extends AbstractController{
	
	
	@Autowired
    private WxMpService wxMpService;
	@Autowired
	private OpenConfig openConfig;
	@Autowired
	private ActivityService activityService;
	@Autowired
	private ActUserService actUserService;
	@Autowired
	private ActOrderService actOrderService;
	@Autowired
	private WxPayService wxPayService;
	@Autowired
	private ContactDao contactDao;
	
	/**
	 * 授权页面
	 * @param actId
	 * @param shareId
	 * @return
	 */
    @GetMapping("/authorize")
    public String authorize(@RequestParam("actId") Integer actId,@RequestParam(required=false) String shareId){
    	Activity activity = activityService.get(actId);
    	if(null==activity) {
    		throw new BusinessException("未找到该活动, 请在后台设置活动");
    	}
    	String url = openConfig.getMpBaseUrl()+"/open/userInfo";
    	String returnUrl= openConfig.getMpBaseUrl() + "/open/act?actId="+actId;
    	if(StringUtils.isNotBlank(shareId)) {
    		returnUrl = returnUrl +"&shareId="+shareId;
    	}
        String redirectURL = wxMpService.oauth2buildAuthorizationUrl(url, WxConsts.OAuth2Scope.SNSAPI_USERINFO, URLEncoder.encode(returnUrl));
        return "redirect:" + redirectURL;
    }
 
    /**
     * 注册用户页面
     * @param code
     * @param returnUrl
     * @return
     * @throws Exception
     */
    @GetMapping("/userInfo")
    public String userInfo(@RequestParam("code") String code,
                         @RequestParam("state") String returnUrl) throws Exception {
    	ActUser user = null;
        WxMpOAuth2AccessToken wxMpOAuth2AccessToken;
        String actId = URLUtil.getParamByUrl(returnUrl, "actId");
        String shareId = URLUtil.getParamByUrl(returnUrl, "shareId");
        try {
            wxMpOAuth2AccessToken = wxMpService.oauth2getAccessToken(code);
            WxMpUser info = wxMpService.oauth2getUserInfo(wxMpOAuth2AccessToken, null);
            //用户注册
            log.info("【微信网页获取参数】actId={},shareId={}", actId,shareId);
            user = actUserService.register(info,Integer.valueOf(actId),shareId,wxMpOAuth2AccessToken.getAccessToken());
        } catch (WxErrorException e) {
            log.error("【微信网页授权】{}", e);
            throw new Exception(e.getError().getErrorMsg());
        }
        String url =  openConfig.getMpBaseUrl()+"/open/act?actId="+actId+"&userId="+user.getId();
        return "redirect:"+ url;
    }
    
    
    /**
     * 活动主页
     * @param userId
     * @param actId
     * @param shareId
     * @param model
     * @return
     */
    @GetMapping("/act")
    public String getAct(@RequestParam String actId,@RequestParam Integer userId, Model model) {
    		//页面加权限分享功能
    		try {
    			String url =  openConfig.getMpBaseUrl()+"/open/act?actId="+actId+"&userId="+userId;
    			WxJsapiSignature sign = wxMpService.createJsapiSignature(url);
    			model.addAttribute("sign", sign);
	    	} catch (WxErrorException e) {
	    		log.error("签名异常:{}",e);
	    	}
    	
	    	Integer aid = Integer.valueOf(actId);
	    	//个人信息
	    	ActUser user = actUserService.getUserById(userId);
	    	//活动信息
	    	Activity activity = activityService.get(aid);
	    	//获取人员参数列表
	    	List<ActUser> userList = actUserService.getList(aid);
	    	//支付成功个数
	    	Integer count = actOrderService.countByStatus(aid);
	    	//获取支付成功集合
	    	List<OrderResult> orderList = actOrderService.getListOrder(aid,1, 10);
	    	//获取分享排名
	    	List<ActUser> rankList = actUserService.getListRanking(aid);
	    	
	    	//分享链接请求地址
	    	String shareUrl = openConfig.getMpBaseUrl() + "/open/share?actId="+actId+"&userId="+userId;
	    	
	    	model.addAttribute("user", user);
	    	model.addAttribute("act", activity);
	    	model.addAttribute("userList", userList);
	    	model.addAttribute("count", count);
	    	model.addAttribute("orderList", orderList);
	    	model.addAttribute("rankList", rankList);
	    	model.addAttribute("shareUrl", shareUrl);
    	
    	return "open/index";
    }
    
    /**
     * 创建订单
     * @param model
     * @param userId
     * @param actId
     * @param name
     * @param iphone
     * @return
     * @throws WxPayException
     */
    @PostMapping("/order")
    public String order(Model model,@RequestParam Integer userId,@RequestParam Integer actId,
    		@RequestParam String name,@RequestParam String iphone) throws WxPayException {
    	
    	ActUser user = actUserService.getUserById(userId);
    	ActOrder order = actOrderService.createOrder(userId, actId, name, iphone);
    	
    	String tradeNo = order.getTradeNo();
    	WxPayUnifiedOrderRequest request = WxPayUnifiedOrderRequest.newBuilder()
    			.body(order.getActName())
    			.outTradeNo(tradeNo)
    			.openid(user.getOpenid())
    			.totalFee(AmountUtils.getPayAmount(order.getAmount()))
    			.spbillCreateIp("127.0.0.1")
    			.notifyUrl(getNotifyUrl(tradeNo))
    			.tradeType(TradeType.JSAPI)
    			.build();
    	
    	WxPayMpOrderResult result = wxPayService.createOrder(request);
    	
    	log.info("交易数据:{}",result);
    	model.addAttribute("result", result);
    	model.addAttribute("order", order);
    	return "open/payment/pay";
    }
    
    
    private String getNotifyUrl(String tradeNo) {
    	return openConfig.getMpBaseUrl() +"/open/notifying/" + tradeNo;
    }
    
    
    /**
     * 回调接口
     * @param tradeNo
     * @param request
     * @param response
     * @throws WxPayException 
     */
    @ResponseBody
    @RequestMapping("/notifying/{tradeNo}")
    public String notifying(@PathVariable("tradeNo") String tradeNo, HttpServletRequest request, HttpServletResponse response) throws WxPayException {
    	log.info("回调流水:{}",tradeNo);
    	String xmlData = super.getRequestBody(request);
    	actOrderService.activateNotify(tradeNo, xmlData);
    	response.setHeader(HTTP_CONTENT_TYPE, HTTP_CHARSET_UTF8);
    	return returnSuccess();
    }
    

    
    
    @GetMapping("/share")
    public String getShare(Model model,@RequestParam Integer userId,@RequestParam Integer actId){
    	Activity activity = activityService.get(actId);
    	ActUser user = actUserService.getUserById(userId);
    	if(null==activity) {
    		throw new BusinessException("未找到该活动");
    	}
    	if(null==user) {
    		throw new BusinessException("用户不存在");
    	}
    	
    	String shareUrl = openConfig.getMpBaseUrl() + "/open/authorize?actId="+actId +"&shareId="+userId;
    	String base64String = Base64.encodeBase64String(QrcodeUtils.createQrcode(shareUrl,null));
        String url = "data:image/jpg;base64,"+base64String;
        log.info("分享url地址:{}",shareUrl);
        model.addAttribute("url", url);
        model.addAttribute("act", activity);
        
        return "open/share";
    }
    
    @GetMapping("/company/{userId}")
    public String company(Model model,@PathVariable("userId") Integer userId) {
    	model.addAttribute("userId", userId);
    	return  "open/contact/create";
    }
    @PostMapping("company")
    public String savecompany(Contact contact) {
    	contact.setCreateTime(new Date());
    	contactDao.insertSelective(contact);
    	return  "open/contact/success";
    }
    
    @GetMapping("/sub")
    public String subscribe() {
    	String authUrl = openConfig.getMpBaseUrl()+"/open/auth";
    	WxMpSubscribeMsgService service = new WxMpSubscribeMsgServiceImpl(wxMpService);
    	String reserved = String.valueOf(System.currentTimeMillis());
    	String subscribeMsgAuthorizationUrl = service.subscribeMsgAuthorizationUrl(authUrl, 1001, reserved);
    	
    	log.info("url:{}",subscribeMsgAuthorizationUrl);
    	return "redirect:"+ subscribeMsgAuthorizationUrl;
    }
    
    @GetMapping("/auth")
    public String auth(@RequestParam String openid,@RequestParam String template_id, @RequestParam String action, @RequestParam String scene) throws WxErrorException {
    	log.info("接收消息-openid:{},action:{},scene:{}",openid,action,scene);
    	if("confirm".equals(action)) {
    		WxMpSubscribeMsgService service = new WxMpSubscribeMsgServiceImpl(wxMpService);
    		WxMpSubscribeMessage message = WxMpSubscribeMessage.builder().toUser(openid).contentValue("订单支付成功").scene(scene).title("支付消息").build();
    		service.sendSubscribeMessage(message);
    	}
    	return "open/payment/success";
    }
    

}

package com.jinkuangkj.open.controller;

import java.net.URLEncoder;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jinkuangkj.open.config.exp.BusinessException;
import com.jinkuangkj.open.config.open.OpenConfig;
import com.jinkuangkj.open.mapper.ActUserDao;
import com.jinkuangkj.open.model.ActOrder;
import com.jinkuangkj.open.model.ActUser;
import com.jinkuangkj.open.model.Activity;
import com.jinkuangkj.open.service.ActOrderService;
import com.jinkuangkj.open.service.ActUserService;
import com.jinkuangkj.open.service.ActivityService;

import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.WxMpUserService;
import me.chanjar.weixin.mp.api.impl.WxMpUserServiceImpl;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import me.chanjar.weixin.mp.bean.result.WxMpUser;




@Slf4j
@Controller
@RequestMapping("/open")
public class OpenController {
	
	
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
 
    @GetMapping("/authorize")
    public String authorize(@RequestParam("actId") Integer actId,@RequestParam(required=false) String shareId){
    	Activity activity = activityService.get(actId);
    	if(null==activity) {
    		throw new BusinessException("未找到该活动, 请在后台设置活动");
    	}
    	String url = openConfig.getMpBaseUrl()+"/open/userInfo";
    	String returnUrl= openConfig.getMpBaseUrl() + activity.getUrl() + "?actId="+actId;
    	if(StringUtils.isNotBlank(shareId)) {
    		returnUrl = returnUrl +"&shareId="+shareId;
    	}
        String redirectURL = wxMpService.oauth2buildAuthorizationUrl(url, WxConsts.OAuth2Scope.SNSAPI_USERINFO, URLEncoder.encode(returnUrl));
        log.info("【微信网页授权】获取code,redirectURL={}", redirectURL);
        return "redirect:" + redirectURL;
    }
 
    @GetMapping("/userInfo")
    public String userInfo(@RequestParam("code") String code,
                         @RequestParam("state") String returnUrl) throws Exception {
        log.info("【微信网页授权】code={}", code);
        log.info("【微信网页授权】state={}", returnUrl);
        WxMpOAuth2AccessToken wxMpOAuth2AccessToken;
        try {
            wxMpOAuth2AccessToken = wxMpService.oauth2getAccessToken(code);
        } catch (WxErrorException e) {
            log.error("【微信网页授权】{}", e);
            throw new Exception(e.getError().getErrorMsg());
        }
        String openId = wxMpOAuth2AccessToken.getOpenId();
        
        //注册用户信息
        String url = returnUrl +"&openId=" + openId;
        log.info("【微信网页授权】redirect url={}", url);
    
        return "redirect:"+ url;
    }
    
    
    @GetMapping("/act")
    public String getAct(@RequestParam String openId, @RequestParam String actId, 
    		@RequestParam(required=false) String shareId,Model model) {
    	//用户注册
    	ActUser register = actUserService.register(Integer.valueOf(actId), openId, shareId);
    	log.info("用户信息:{}",register);
    	
    	//活动信息
    	Activity activity = activityService.get(Integer.valueOf(actId));
    	//获取人员参数列表
    	List<ActUser> list = actUserService.getList(Integer.valueOf(actId));
    	
    	model.addAttribute("user", register);
    	model.addAttribute("act", activity);
    	model.addAttribute("userList", list);
    	
    	
    	return "open/index";
    }
    
    @PostMapping("/order")
    public String order(Model model,@RequestParam Integer userId,@RequestParam Integer actId,
    		@RequestParam String name,@RequestParam String iphone) {
    	ActOrder order = actOrderService.createOrder(userId, actId, name, iphone);
    	model.addAttribute("order", order);
    	return "open/payment/pay";
    }

}

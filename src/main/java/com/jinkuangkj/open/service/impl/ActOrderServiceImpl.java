package com.jinkuangkj.open.service.impl;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.time.DateParser;
import org.apache.commons.lang3.time.FastDateFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.binarywang.wxpay.bean.notify.WxPayOrderNotifyResult;
import com.github.binarywang.wxpay.exception.WxPayException;
import com.github.binarywang.wxpay.service.WxPayService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.base.Strings;
import com.jinkuangkj.open.config.exp.BusinessException;
import com.jinkuangkj.open.constant.OrderStatus;
import com.jinkuangkj.open.mapper.ActOrderDao;
import com.jinkuangkj.open.mapper.ActivityDao;
import com.jinkuangkj.open.model.ActOrder;
import com.jinkuangkj.open.model.ActUser;
import com.jinkuangkj.open.model.Activity;
import com.jinkuangkj.open.model.result.OrderResult;
import com.jinkuangkj.open.service.ActOrderService;
import com.jinkuangkj.open.service.ActUserService;
import com.jinkuangkj.open.util.PageUtil;
import com.jinkuangkj.open.util.PrimaryGenerater;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ActOrderServiceImpl implements ActOrderService{
	
	@Autowired
	ActOrderDao actOrderDao;
	@Autowired
	ActUserService actUserService;
	@Autowired
	ActivityDao activityDao;
	@Autowired
	private WxPayService wxPayService;
	
	protected static final DateParser NOTIFY_DATE_PARSER = FastDateFormat.getInstance("yyyyMMddHHmmss");
	

	@Override
	public ActOrder createOrder(Integer userId, Integer actId, String name, String iphone) {
		
		Activity activity = activityDao.selectById(actId);
		ActOrder actOrder = new ActOrder();
		actOrder.setActId(actId);
		actOrder.setName(name);
		actOrder.setIphone(iphone);
		actOrder.setMerchant(activity.getMerchant());
		actOrder.setActName(activity.getName());
		actOrder.setCreateTime(new Date());
		actOrder.setUserId(userId);
		actOrder.setStatus(OrderStatus.PENDING.getValue());
		actOrder.setTradeNo(PrimaryGenerater.getOrderNo());
		actOrder.setAmount(activity.getAmount());
		actOrderDao.insertSelective(actOrder);
		
		return actOrder;
	}

	@Override
	public void activateNotify(String tradeNo, String xml) throws WxPayException {
		
		ActOrder order = actOrderDao.selectByTradeNo(tradeNo);
		if(null==order) {
			throw new BusinessException("未找到该流水");
		}
		Activity activity = activityDao.selectById(order.getActId());
		if(null==activity) {
			throw new BusinessException("未找到该活动");
		}
		
		//支付密等处理
		if(order.getStatus().equals(OrderStatus.SUCCESS.getValue())) {
			return ;
		}
		
		//解析报文
		WxPayOrderNotifyResult result = wxPayService.parseOrderNotifyResult(xml);
		order.setOutTradeNo(result.getTransactionId());
		order.setMerchantId(result.getMchId());
		order.setStatus(OrderStatus.SUCCESS.getValue());
        Date finishTime = new Date();
        String finishTimeStr = result.getTimeEnd();
        if (!Strings.isNullOrEmpty(finishTimeStr)) {
            try {
				finishTime = NOTIFY_DATE_PARSER.parse(finishTimeStr);
			} catch (ParseException e) {
				log.error("解析时间错误:{}",e);
			}
        }
        order.setFinishTime(finishTime);
        actOrderDao.updateSelective(order);
        
        //添加收入
        ActUser user = actUserService.getUserById(order.getUserId());
        if(null != user.getShareUserId()) {
        	actUserService.addIncome(user.getShareUserId(), activity.getShareAmount(),order.getUserId());
        }
	}

	@Override
	public PageInfo<OrderResult> getList(Integer actId,Integer pageNo, Integer pageSize) {
		
		PageHelper.startPage(pageNo, pageSize);
		List<OrderResult> order = actOrderDao.getListOrder(actId);
		PageInfo<OrderResult> orderList = new PageInfo<OrderResult>(order);
		PageUtil.toPagination(orderList);
		
		return orderList;
	}

	@Override
	public List<OrderResult> getListOrder(Integer actId,Integer pageNo, Integer pageSize) {
		PageInfo<OrderResult> list = getList(actId,pageNo,pageSize);
		for (OrderResult result : list.getList()) {
			String iphone = result.getIphone().replaceAll("(\\d{3})\\d{4}(\\d{4})","$1****$2");
			result.setIphone(iphone);
		}
		return list.getList();
	}

	@Override
	public Integer countByStatus(Integer actId) {
		return actOrderDao.countByStatus(actId);
	}

	@Override
	public List<OrderResult> getListOrderByAdmin() {
		return actOrderDao.getListOrder(null);
	}

}

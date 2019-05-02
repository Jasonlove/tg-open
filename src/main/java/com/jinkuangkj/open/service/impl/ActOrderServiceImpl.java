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
import com.jinkuangkj.open.model.Activity;
import com.jinkuangkj.open.model.result.OrderResult;
import com.jinkuangkj.open.service.ActOrderService;
import com.jinkuangkj.open.util.PageUtil;
import com.jinkuangkj.open.util.PrimaryGenerater;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ActOrderServiceImpl implements ActOrderService{
	
	@Autowired
	ActOrderDao actOrderDao;
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
		actOrder.setName(iphone);
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
	public void doNotify(String tradeNo, String xml) throws WxPayException {
		
		ActOrder order = actOrderDao.selectByTradeNo(tradeNo);
		if(null==order) {
			throw new BusinessException("未找到该流水");
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
	}

	@Override
	public PageInfo<OrderResult> getList(Integer pageNo, Integer pageSize) {
		
		PageHelper.startPage(pageNo, pageSize);
		List<OrderResult> order = actOrderDao.getListOrder();
		PageInfo<OrderResult> orderList = new PageInfo<OrderResult>(order);
		PageUtil.toPagination(orderList);
		
		return orderList;
	}

	@Override
	public List<OrderResult> getOrderList(Integer pageNo, Integer pageSize) {
		PageInfo<OrderResult> list = getList(pageNo,pageSize);
		for (OrderResult result : list.getList()) {
			String iphone = result.getIphone().replaceAll("(\\d{3})\\d{4}(\\d{4})","$1****$2");
			result.setIphone(iphone);
		}
		return list.getList();
	}
		

}

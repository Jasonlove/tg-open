package com.jinkuangkj.open.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jinkuangkj.open.constant.OrderStatus;
import com.jinkuangkj.open.mapper.ActOrderDao;
import com.jinkuangkj.open.mapper.ActivityDao;
import com.jinkuangkj.open.model.ActOrder;
import com.jinkuangkj.open.model.Activity;
import com.jinkuangkj.open.service.ActOrderService;
import com.jinkuangkj.open.util.PrimaryGenerater;

@Service
public class ActOrderServiceImpl implements ActOrderService{
	
	@Autowired
	ActOrderDao actOrderDao;
	@Autowired
	ActivityDao activityDao;

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
	

	
	

}

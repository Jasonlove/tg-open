package com.jinkuangkj.open.service;

import com.github.binarywang.wxpay.exception.WxPayException;
import com.jinkuangkj.open.model.ActOrder;

public interface ActOrderService {
	
	
	ActOrder createOrder(Integer userId,Integer actId,String name,String iphone);
	
	void doNotify(String tradeNo,String xml)throws WxPayException;
	

}

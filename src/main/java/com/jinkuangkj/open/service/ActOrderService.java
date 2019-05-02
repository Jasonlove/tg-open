package com.jinkuangkj.open.service;

import com.github.binarywang.wxpay.exception.WxPayException;
import com.github.pagehelper.PageInfo;
import com.jinkuangkj.open.model.ActOrder;
import com.jinkuangkj.open.model.result.OrderResult;

public interface ActOrderService {
	
	
	ActOrder createOrder(Integer userId,Integer actId,String name,String iphone);
	
	void doNotify(String tradeNo,String xml)throws WxPayException;
	
	PageInfo<OrderResult> getList();

}

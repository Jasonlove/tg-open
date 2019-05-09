package com.jinkuangkj.open.service;

import java.util.List;

import com.github.binarywang.wxpay.exception.WxPayException;
import com.github.pagehelper.PageInfo;
import com.jinkuangkj.open.model.ActOrder;
import com.jinkuangkj.open.model.result.OrderResult;

public interface ActOrderService {
	
	
	ActOrder createOrder(Integer userId,Integer actId,String name,String iphone);
	
	void activateNotify(String tradeNo,String xml)throws WxPayException;
	
	PageInfo<OrderResult> getList(Integer actId,Integer pageNo, Integer pageSize);
	
	List<OrderResult> getListOrder(Integer actId,Integer pageNo, Integer pageSize);
	
	List<OrderResult> getListOrderByAdmin();

	Integer countByStatus(Integer actId);
}

package com.jinkuangkj.open.service;

import com.jinkuangkj.open.model.ActOrder;

public interface ActOrderService {
	
	
	ActOrder createOrder(Integer userId,Integer actId,String name,String iphone);

}

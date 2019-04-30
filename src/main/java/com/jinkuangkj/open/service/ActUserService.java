package com.jinkuangkj.open.service;

import com.jinkuangkj.open.model.ActUser;

public interface ActUserService {
	
	ActUser register(Integer actId, String openId,String shareId);

}

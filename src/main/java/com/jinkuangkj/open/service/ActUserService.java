package com.jinkuangkj.open.service;

import java.util.List;

import com.jinkuangkj.open.model.ActUser;

public interface ActUserService {
	
	ActUser register(Integer actId, String openId,String shareId);
	
	
	List<ActUser> getList(Integer actId);

}

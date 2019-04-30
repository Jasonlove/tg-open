package com.jinkuangkj.open.service;

import java.util.List;

import com.jinkuangkj.open.model.ActUser;

import me.chanjar.weixin.mp.bean.result.WxMpUser;

public interface ActUserService {
	
	ActUser register(WxMpUser info,Integer actId,String shareId);
	
	ActUser getUserById(Integer id);
	
	List<ActUser> getList(Integer actId);

}

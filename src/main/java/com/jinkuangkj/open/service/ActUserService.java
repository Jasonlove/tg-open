package com.jinkuangkj.open.service;

import java.util.List;

import com.jinkuangkj.open.model.ActUser;

import me.chanjar.weixin.mp.bean.result.WxMpUser;

public interface ActUserService {
	
	ActUser register(WxMpUser info,Integer actId,String shareId,String token);
	
	ActUser getUserById(Integer id);
	
	ActUser getUserByOpenIdAndActId(String openId, Integer actId);
	
	List<ActUser> getList(Integer actId);
	
	List<ActUser> getListRanking();
	
	void addIncome(Integer userId,Double income);
}

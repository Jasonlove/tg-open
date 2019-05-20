package com.jinkuangkj.open.service;

import java.util.Map;

import com.jinkuangkj.open.config.exp.LoginException;

public interface AdminService {
	
	/**
	 * 用户登录
	 * @param userName
	 * @param password
	 */
    Map<String,Object> login(String userName, String password)throws LoginException;

}

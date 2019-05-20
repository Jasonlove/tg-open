package com.jinkuangkj.open.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jinkuangkj.open.config.exp.LoginException;
import com.jinkuangkj.open.mapper.AdminDao;
import com.jinkuangkj.open.model.Admin;
import com.jinkuangkj.open.model.result.Menu;
import com.jinkuangkj.open.service.AdminService;
import com.jinkuangkj.open.service.RoleService;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminDao adminDao;
	@Autowired
	RoleService roleService;
	
	@Override
	public Map<String,Object> login(String userName, String password) throws LoginException {
		
		Admin logAdmin = adminDao.getUserByPassword(userName,password);
		
		if(logAdmin == null) {
	       throw new LoginException("用户名密码错误");
		}
		
		Menu menu = roleService.getMenu(logAdmin.getRoleId());
		
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("user", logAdmin);
		map.put("menu", menu);
		return map;
	}

}

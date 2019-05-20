package com.jinkuangkj.open.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jinkuangkj.open.constant.MenuType;
import com.jinkuangkj.open.mapper.AuthDao;
import com.jinkuangkj.open.model.Auth;
import com.jinkuangkj.open.model.result.Menu;
import com.jinkuangkj.open.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService{
	
	@Autowired
	AuthDao authDao;

	@Override
	public Menu getMenu(Integer roleId) {
		
		Menu menu = new Menu();
		List<Auth> list = authDao.listByRoleId(roleId);
		for (Auth auth : list) {
			MenuType type = MenuType.from(auth.getType());
			switch (type) {
			case ACT:
				menu.getActList().add(auth);
				break;
			case ORDER:
				menu.getOrderList().add(auth);
				break;
			case TRANSFER:
				menu.getTranList().add(auth);
				break;
			case CONTACT:
				menu.getContList().add(auth);
				break;
			case ADMINUSER:
				menu.getAdminList().add(auth);
				break;
			default:
				break;
			}
		}
		return menu;
	}

}

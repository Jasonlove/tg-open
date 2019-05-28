package com.jinkuangkj.open.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jinkuangkj.open.mapper.AdminDao;
import com.jinkuangkj.open.model.Admin;
import com.jinkuangkj.open.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired AdminDao adminDao;

	@Override
	public List<Admin> getList() {
		return adminDao.getList();
	}

	@Override
	public void saveAdmin(Admin admin) {
		if(null == admin.getId() ) {
			admin.setCreateTime(new Date());
			adminDao.insertSelective(admin);
		}else {
			adminDao.updateSelective(admin);
		}
	}

	@Override
	public Admin getAdmin(Integer adminId) {
		return adminDao.selectById(adminId);
	}

}

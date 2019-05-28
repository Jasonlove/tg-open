package com.jinkuangkj.open.service;

import java.util.List;

import com.jinkuangkj.open.model.Admin;

public interface AdminService {
	
	List<Admin> getList();
	
	void saveAdmin(Admin admin);
	
	Admin getAdmin(Integer adminId);
}

package com.jinkuangkj.open.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jinkuangkj.open.mapper.ContactDao;
import com.jinkuangkj.open.model.Contact;
import com.jinkuangkj.open.service.ContactService;

@Service
public class ContactServiceImpl implements ContactService{

	@Autowired
	ContactDao contactDao;
	
	@Override
	public List<Contact> getList() {
		return contactDao.getList();
	}

}

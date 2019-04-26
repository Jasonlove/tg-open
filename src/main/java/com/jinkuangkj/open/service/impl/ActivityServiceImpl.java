package com.jinkuangkj.open.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jinkuangkj.open.mapper.ActivityDao;
import com.jinkuangkj.open.model.Activity;
import com.jinkuangkj.open.service.ActivityService;

@Service
public class ActivityServiceImpl implements ActivityService {

	@Autowired
	ActivityDao activityDao;
	
	@Override
	public void saveActivity(Activity activity) {
		activityDao.insertSelective(activity);
	}
	
	
}

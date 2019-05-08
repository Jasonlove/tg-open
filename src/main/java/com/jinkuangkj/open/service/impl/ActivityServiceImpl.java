package com.jinkuangkj.open.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jinkuangkj.open.config.open.OpenConfig;
import com.jinkuangkj.open.mapper.ActivityDao;
import com.jinkuangkj.open.model.Activity;
import com.jinkuangkj.open.service.ActivityService;

@Service
public class ActivityServiceImpl implements ActivityService {

	@Autowired
	ActivityDao activityDao;
	
	@Autowired
	private OpenConfig openConfig;
	
	@Override
	public void saveActivity(Activity activity) {
		if(null != activity.getId()) {
			activityDao.updateSelective(activity);
		}else {
			activity.setCreateTime(new Date());
			activityDao.insertSelective(activity);
			String actUrl = openConfig.getMpBaseUrl() + "/open/authorize?actId="+activity.getId();
			activity.setActUrl(actUrl);
			activityDao.updateSelective(activity);
		}
	}
	
	@Override
	public List<Activity> getList() {
		return activityDao.getList();
	}

	@Override
	public Activity get(Integer actId) {
		return activityDao.selectById(actId);
	}
	
}

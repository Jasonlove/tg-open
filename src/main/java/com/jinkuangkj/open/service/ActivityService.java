package com.jinkuangkj.open.service;

import java.util.List;

import com.jinkuangkj.open.model.Activity;

public interface ActivityService {
	
	void saveActivity(Activity activity);
	
	Activity get(Integer actId);
	
	List<Activity> getList();
	

}

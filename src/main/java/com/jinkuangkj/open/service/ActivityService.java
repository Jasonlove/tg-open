package com.jinkuangkj.open.service;

import java.util.List;

import com.jinkuangkj.open.model.Activity;

public interface ActivityService {
	
	
	List<Activity> getList();
	
	void saveActivity(Activity activity);

}

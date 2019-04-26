package com.jinkuangkj.open.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jinkuangkj.open.mapper.ActUserDao;
import com.jinkuangkj.open.model.ActUser;
import com.jinkuangkj.open.model.Activity;
import com.jinkuangkj.open.service.ActivityService;

@RestController
@RequestMapping("test")
public class TestController {
	
	
	@Autowired
	ActivityService activityService;
	
	@PostMapping("activity")
	public void getTest() {
		
		Activity activity = new Activity();
		activity.setCreateTime(new Date());
		activityService.saveActivity(activity);
	
	}

}

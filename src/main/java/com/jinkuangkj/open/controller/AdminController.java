package com.jinkuangkj.open.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jinkuangkj.open.model.Activity;
import com.jinkuangkj.open.service.ActivityService;

@Controller
@RequestMapping("admin")
public class AdminController {
	
	
	@Autowired
	ActivityService activityService;
	
	
	@GetMapping("/index")
	public String index() {
		return "index";
	}
	
	
	@PostMapping("activity")
	public void getTest() {
		
		Activity activity = new Activity();
		activity.setCreateTime(new Date());
		activityService.saveActivity(activity);
	
	}

}

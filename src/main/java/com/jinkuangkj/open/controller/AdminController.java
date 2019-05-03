package com.jinkuangkj.open.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jinkuangkj.open.model.Activity;
import com.jinkuangkj.open.service.ActivityService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("admin")
public class AdminController {
	
	
	@Autowired
	ActivityService activityService;
	
	
	@GetMapping("/index")
	public String index() {
		return "admin/index";
	}
	
	
	@GetMapping("/activity/index")
	public String activity(Model model) {
		List<Activity> list = activityService.getList();
		model.addAttribute("actList", list);
		return "admin/activity/index";
	}
	
	@PostMapping("/activity/save")
	public String saveActivity(Activity activity) {
		activityService.saveActivity(activity);
		return "redirect:/admin/activity/index";
	}
	
	
}

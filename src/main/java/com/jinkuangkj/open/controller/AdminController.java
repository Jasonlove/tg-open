package com.jinkuangkj.open.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jinkuangkj.open.model.Activity;
import com.jinkuangkj.open.model.Transfer;
import com.jinkuangkj.open.model.result.OrderResult;
import com.jinkuangkj.open.model.result.TransferResult;
import com.jinkuangkj.open.service.ActOrderService;
import com.jinkuangkj.open.service.ActivityService;
import com.jinkuangkj.open.service.TransferService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("admin")
public class AdminController {
	
	
	@Autowired
	ActivityService activityService;
	@Autowired
	ActOrderService actOrderService;
	@Autowired
	TransferService transferService;
	
	
	@GetMapping("/index")
	public String index() {
		return "admin/index";
	}
	
	@GetMapping("/activity/index")
	public String activityList(Model model) {
		List<Activity> list = activityService.getList();
		model.addAttribute("actList", list);
		return "admin/activity/index";
	}
	
	@GetMapping("/order/index")
	public String orderList(Model model) {
		List<OrderResult> list = actOrderService.getListOrderByAdmin();
		model.addAttribute("orderList", list);
		return "admin/order/index";
	}
	
	@GetMapping("/transfer/index")
	public String transferList(Model model) {
		List<TransferResult> list = transferService.getList();
		model.addAttribute("transferList", list);
		return "admin/transfer/index";
	}
	
	@GetMapping("/contact/index")
	public String contactList(Model model) {
		List<TransferResult> list = transferService.getList();
		model.addAttribute("transferList", list);
		return "admin/contact/index";
	}
	
	@PostMapping("/activity/save")
	public String saveActivity(Activity activity) {
		activityService.saveActivity(activity);
		return "redirect:/admin/activity/index";
	}
	
	@ResponseBody
	@GetMapping("/activity/get")
	public Activity getActivity(@RequestParam Integer actId) {
		return activityService.get(actId);
	}
	
	
}

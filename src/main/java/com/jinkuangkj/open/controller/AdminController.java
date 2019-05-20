package com.jinkuangkj.open.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.jinkuangkj.open.config.exp.LoginException;
import com.jinkuangkj.open.mapper.AdminDao;
import com.jinkuangkj.open.model.Activity;
import com.jinkuangkj.open.model.Admin;
import com.jinkuangkj.open.model.Contact;
import com.jinkuangkj.open.model.Transfer;
import com.jinkuangkj.open.model.result.Menu;
import com.jinkuangkj.open.model.result.OrderResult;
import com.jinkuangkj.open.model.result.TransferResult;
import com.jinkuangkj.open.service.ActOrderService;
import com.jinkuangkj.open.service.ActivityService;
import com.jinkuangkj.open.service.AdminService;
import com.jinkuangkj.open.service.ContactService;
import com.jinkuangkj.open.service.RoleService;
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
	@Autowired
	ContactService contactService;
	@Autowired
	AdminService adminService;
	@Autowired
	HttpSession session;
	@Autowired
	AdminDao adminDao;
	@Autowired
	RoleService roleService;
	
	@GetMapping("/login")
	public String login() {
		return "admin/login";
	}
		
	@PostMapping("/login")
	public String login(@RequestParam("username")String userName,@RequestParam("password")String password) {

		Admin logAdmin = adminDao.getUserByPassword(userName,password);
		if(logAdmin == null) {
			//异常返回登录页面
			return "redirect:/admin/login";
		}
		Menu menu = roleService.getMenu(logAdmin.getRoleId());
		session.setAttribute("admin", logAdmin);
		session.setAttribute("menu", menu);
		
		return "admin/index";
	}
	
	@GetMapping("/index")
	public String index() {
		Object account = session.getAttribute("admin");
		if(account == null) {
			return "redirect:/admin/login";
		}
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
		 List<Contact> list = contactService.getList();
		model.addAttribute("contactList", list);
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

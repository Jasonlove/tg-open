package com.jinkuangkj.open.config;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.jinkuangkj.open.mapper.AuthDao;
import com.jinkuangkj.open.model.Admin;
import com.jinkuangkj.open.model.Auth;
import com.jinkuangkj.open.model.result.Menu;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class AuthInterceptor implements HandlerInterceptor{
	
	
	@Autowired
	AuthDao authDao;
	

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String uri = request.getRequestURI();
		log.info("权限拦截器拦截-请求地址:{}",uri);
		HttpSession session = request.getSession();
		Admin  account = (Admin) session.getAttribute("admin");
		if(account == null) {
			response.sendRedirect(request.getContextPath()+"/openAdmin/login");
			return false;
		}
		boolean flag = false;
		List<Auth> list = authDao.listByRoleId(account.getRoleId());
		for (Auth auth : list) {
			if(uri.contains(auth.getUrl())) {
				flag = true;
				break;
			}
		}
		if(!flag) {
			response.sendRedirect(request.getContextPath()+"/openAdmin/login");
			return false;
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

}

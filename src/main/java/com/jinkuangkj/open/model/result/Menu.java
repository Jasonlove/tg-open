package com.jinkuangkj.open.model.result;

import java.util.ArrayList;
import java.util.List;

import com.jinkuangkj.open.model.Auth;

public class Menu {
	
	/**
	 * 活动列表
	 */
	private List<Auth>  actList = new ArrayList<Auth>();
	/**
	 * 订单列表
	 */
	private List<Auth>  orderList = new ArrayList<Auth>();
	/**
	 * 转账列表
	 */
	private List<Auth>  tranList = new ArrayList<Auth>();
	/**
	 * 联系人列表
	 */
	private List<Auth>  contList = new ArrayList<Auth>();
	/**
	 * 账户列表
	 */
	private List<Auth>  adminList = new ArrayList<Auth>();
	
	
	public List<Auth> getActList() {
		return actList;
	}
	public void setActList(List<Auth> actList) {
		this.actList = actList;
	}
	public List<Auth> getOrderList() {
		return orderList;
	}
	public void setOrderList(List<Auth> orderList) {
		this.orderList = orderList;
	}
	public List<Auth> getTranList() {
		return tranList;
	}
	public void setTranList(List<Auth> tranList) {
		this.tranList = tranList;
	}
	public List<Auth> getContList() {
		return contList;
	}
	public void setContList(List<Auth> contList) {
		this.contList = contList;
	}
	public List<Auth> getAdminList() {
		return adminList;
	}
	public void setAdminList(List<Auth> adminList) {
		this.adminList = adminList;
	}

}

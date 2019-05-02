package com.jinkuangkj.open.model.result;

import java.util.Date;

public class OrderResult {
	
	
	
	public OrderResult() {
	}
	
	
	public OrderResult(Integer userId, String nickname, String headimgurl, String name, String iphone, String tradeNo,
			Date finishTime, Double amount) {
		super();
		this.userId = userId;
		this.nickname = nickname;
		this.headimgurl = headimgurl;
		this.name = name;
		this.iphone = iphone;
		this.tradeNo = tradeNo;
		this.finishTime = finishTime;
		this.amount = amount;
	}



	private Integer userId;
	private String nickname;
    private String headimgurl;
    
    private String name;
    private String iphone;
    
    private String tradeNo;
    private Date finishTime;
    private Double amount;
    
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getHeadimgurl() {
		return headimgurl;
	}
	public void setHeadimgurl(String headimgurl) {
		this.headimgurl = headimgurl;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIphone() {
		return iphone;
	}
	public void setIphone(String iphone) {
		this.iphone = iphone;
	}
	public String getTradeNo() {
		return tradeNo;
	}
	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
	}
	public Date getFinishTime() {
		return finishTime;
	}
	public void setFinishTime(Date finishTime) {
		this.finishTime = finishTime;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
}

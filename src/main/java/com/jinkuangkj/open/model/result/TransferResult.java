package com.jinkuangkj.open.model.result;

import java.util.Date;

public class TransferResult {
	
	private String openid;
    private String nickname;
    private String headimgurl;
	
    private String actName;
    private String merchant;
    
	private Integer userId;
	private Integer actId;
    private String transferNo;
    private Double amount;
    /**
     * 发红包状态
     */
    private String status;
    private String resultCode;
    private String resultMessage;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 商户id
     */
    private String merchantId;
    
    
	public TransferResult() {
	}
	
	public TransferResult(String openid, String nickname, String headimgurl,String actName,String merchant, Integer userId,Integer actId, String transferNo,
			Double amount, String status, String resultCode, String resultMessage, Date createTime, String merchantId) {
		super();
		this.openid = openid;
		this.nickname = nickname;
		this.headimgurl = headimgurl;
		this.actName = actName;
		this.merchant = merchant;
		this.userId = userId;
		this.actId = actId;
		this.transferNo = transferNo;
		this.amount = amount;
		this.status = status;
		this.resultCode = resultCode;
		this.resultMessage = resultMessage;
		this.createTime = createTime;
		this.merchantId = merchantId;
	}




	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
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
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getTransferNo() {
		return transferNo;
	}
	public void setTransferNo(String transferNo) {
		this.transferNo = transferNo;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getResultCode() {
		return resultCode;
	}
	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}
	public String getResultMessage() {
		return resultMessage;
	}
	public void setResultMessage(String resultMessage) {
		this.resultMessage = resultMessage;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getMerchantId() {
		return merchantId;
	}
	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}
	public Integer getActId() {
		return actId;
	}
	public void setActId(Integer actId) {
		this.actId = actId;
	}
	public String getActName() {
		return actName;
	}
	public void setActName(String actName) {
		this.actName = actName;
	}
	public String getMerchant() {
		return merchant;
	}
	public void setMerchant(String merchant) {
		this.merchant = merchant;
	}
	
	

}

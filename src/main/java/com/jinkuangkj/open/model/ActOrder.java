/*
 * @des @TODO 
 * @name ActOrder.java
 * @author Jason-pc
 * @date 2019-04-30 12:48:39
 */
package com.jinkuangkj.open.model;

import java.util.Date;

/*
 * @des @TODO 
 * @name 
 * @author Jason-pc
 * @date 2019-04-30 12:48:39
 */
public class ActOrder {
    /**
     * 自增主键
     */
    private Integer id;
    /**
     * 活动id
     */
    private Integer actId;
    private Integer userId;
    /**
     * 活动名称
     */
    private String actName;
    /**
     * 商家名称
     */
    private String merchant;
    /**
     * 姓名
     */
    private String name;
    private String iphone;
    private Double amount;
    /**
     * 支付流水号
     */
    private String tradeNo;
    /**
     * 微信
     */
    private String outTradeNo;
    /**
     * success,
     */
    private String status;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 完成时间
     */
    private Date finishTime;
    /**
     * 商家id
     */
    private String merchantId;

    public ActOrder(Integer id, Integer actId, Integer userId, String actName, String merchant, String name, String iphone, Double amount, String tradeNo, String outTradeNo, String status, Date createTime, Date finishTime, String merchantId) {
        this.id = id;
        this.actId = actId;
        this.userId = userId;
        this.actName = actName;
        this.merchant = merchant;
        this.name = name;
        this.iphone = iphone;
        this.amount = amount;
        this.tradeNo = tradeNo;
        this.outTradeNo = outTradeNo;
        this.status = status;
        this.createTime = createTime;
        this.finishTime = finishTime;
        this.merchantId = merchantId;
    }
    public ActOrder() {
        super();
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getActId() {
        return actId;
    }
    public void setActId(Integer actId) {
        this.actId = actId;
    }
    public Integer getUserId() {
        return userId;
    }
    public void setUserId(Integer userId) {
        this.userId = userId;
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
    public Double getAmount() {
        return amount;
    }
    public void setAmount(Double amount) {
        this.amount = amount;
    }
    public String getTradeNo() {
        return tradeNo;
    }
    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }
    public String getOutTradeNo() {
        return outTradeNo;
    }
    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public Date getCreateTime() {
        return createTime;
    }
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    public Date getFinishTime() {
        return finishTime;
    }
    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }
    public String getMerchantId() {
        return merchantId;
    }
    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", actId=").append(actId);
        sb.append(", userId=").append(userId);
        sb.append(", actName=").append(actName);
        sb.append(", merchant=").append(merchant);
        sb.append(", name=").append(name);
        sb.append(", iphone=").append(iphone);
        sb.append(", amount=").append(amount);
        sb.append(", tradeNo=").append(tradeNo);
        sb.append(", outTradeNo=").append(outTradeNo);
        sb.append(", status=").append(status);
        sb.append(", createTime=").append(createTime);
        sb.append(", finishTime=").append(finishTime);
        sb.append(", merchantId=").append(merchantId);
        sb.append("]");
        return sb.toString();
    }
}
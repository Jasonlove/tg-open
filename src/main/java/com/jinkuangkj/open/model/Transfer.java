/*
 * @des @TODO 
 * @name Transfer.java
 * @author Jason-pc
 * @date 2019-05-17 10:13:24
 */
package com.jinkuangkj.open.model;

import java.util.Date;

/*
 * @des @TODO 
 * @name 
 * @author Jason-pc
 * @date 2019-05-17 10:13:24
 */
public class Transfer {
    private Integer id;
    /**
     * 用户id
     */
    private Integer userId;
    /**
     * 活动id
     */
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
    /**
     * 分享人用户id
     */
    private Integer shareUid;

    public Transfer(Integer id, Integer userId, Integer actId, String transferNo, Double amount, String status, String resultCode, String resultMessage, Date createTime, String merchantId, Integer shareUid) {
        this.id = id;
        this.userId = userId;
        this.actId = actId;
        this.transferNo = transferNo;
        this.amount = amount;
        this.status = status;
        this.resultCode = resultCode;
        this.resultMessage = resultMessage;
        this.createTime = createTime;
        this.merchantId = merchantId;
        this.shareUid = shareUid;
    }
    public Transfer() {
        super();
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getUserId() {
        return userId;
    }
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public Integer getActId() {
        return actId;
    }
    public void setActId(Integer actId) {
        this.actId = actId;
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
    public Integer getShareUid() {
        return shareUid;
    }
    public void setShareUid(Integer shareUid) {
        this.shareUid = shareUid;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", actId=").append(actId);
        sb.append(", transferNo=").append(transferNo);
        sb.append(", amount=").append(amount);
        sb.append(", status=").append(status);
        sb.append(", resultCode=").append(resultCode);
        sb.append(", resultMessage=").append(resultMessage);
        sb.append(", createTime=").append(createTime);
        sb.append(", merchantId=").append(merchantId);
        sb.append(", shareUid=").append(shareUid);
        sb.append("]");
        return sb.toString();
    }
}
/*
 * @des @TODO 
 * @name ActOrder.java
 * @author Jason-pc
 * @date 2019-04-26 14:20:35
 */
package com.jinkuangkj.open.model;

import java.math.BigDecimal;
import java.util.Date;

/*
 * @des @TODO 
 * @name 
 * @author Jason-pc
 * @date 2019-04-26 14:20:35
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
    /**
     * 姓名
     */
    private String name;
    private String iphone;
    /**
     * 公众号用户id
     */
    private String openid;
    private BigDecimal amount;
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

    public ActOrder(Integer id, Integer actId, String name, String iphone, String openid, BigDecimal amount, String tradeNo, String outTradeNo, String status, Date createTime, Date finishTime) {
        this.id = id;
        this.actId = actId;
        this.name = name;
        this.iphone = iphone;
        this.openid = openid;
        this.amount = amount;
        this.tradeNo = tradeNo;
        this.outTradeNo = outTradeNo;
        this.status = status;
        this.createTime = createTime;
        this.finishTime = finishTime;
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
    public String getOpenid() {
        return openid;
    }
    public void setOpenid(String openid) {
        this.openid = openid;
    }
    public BigDecimal getAmount() {
        return amount;
    }
    public void setAmount(BigDecimal amount) {
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
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", actId=").append(actId);
        sb.append(", name=").append(name);
        sb.append(", iphone=").append(iphone);
        sb.append(", openid=").append(openid);
        sb.append(", amount=").append(amount);
        sb.append(", tradeNo=").append(tradeNo);
        sb.append(", outTradeNo=").append(outTradeNo);
        sb.append(", status=").append(status);
        sb.append(", createTime=").append(createTime);
        sb.append(", finishTime=").append(finishTime);
        sb.append("]");
        return sb.toString();
    }
}
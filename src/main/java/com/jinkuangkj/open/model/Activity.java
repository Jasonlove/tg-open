/*
 * @des @TODO 
 * @name Activity.java
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
public class Activity {
    private Integer id;
    /**
     * 活动名称
     */
    private String name;
    /**
     * 活动时间
     */
    private Date startTime;
    /**
     * 截止时间
     */
    private Date endTime;
    /**
     * 活动页面地址
     */
    private String url;
    /**
     * 报名金额
     */
    private BigDecimal amount;
    /**
     * 分享金额
     */
    private BigDecimal shareAmount;
    /**
     * 活动参与个数
     */
    private Integer joinCount;
    private Date createTime;

    public Activity(Integer id, String name, Date startTime, Date endTime, String url, BigDecimal amount, BigDecimal shareAmount, Integer joinCount, Date createTime) {
        this.id = id;
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
        this.url = url;
        this.amount = amount;
        this.shareAmount = shareAmount;
        this.joinCount = joinCount;
        this.createTime = createTime;
    }
    public Activity() {
        super();
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Date getStartTime() {
        return startTime;
    }
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }
    public Date getEndTime() {
        return endTime;
    }
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public BigDecimal getAmount() {
        return amount;
    }
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
    public BigDecimal getShareAmount() {
        return shareAmount;
    }
    public void setShareAmount(BigDecimal shareAmount) {
        this.shareAmount = shareAmount;
    }
    public Integer getJoinCount() {
        return joinCount;
    }
    public void setJoinCount(Integer joinCount) {
        this.joinCount = joinCount;
    }
    public Date getCreateTime() {
        return createTime;
    }
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", startTime=").append(startTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", url=").append(url);
        sb.append(", amount=").append(amount);
        sb.append(", shareAmount=").append(shareAmount);
        sb.append(", joinCount=").append(joinCount);
        sb.append(", createTime=").append(createTime);
        sb.append("]");
        return sb.toString();
    }
}
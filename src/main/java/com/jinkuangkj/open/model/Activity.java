/*
 * @des @TODO 
 * @name Activity.java
 * @author Jason-pc
 * @date 2019-05-08 10:39:47
 */
package com.jinkuangkj.open.model;

import java.util.Date;

/*
 * @des @TODO 
 * @name 
 * @author Jason-pc
 * @date 2019-05-08 10:39:47
 */
public class Activity {
    private Integer id;
    /**
     * 活动名称
     */
    private String name;
    /**
     * 商家名称
     */
    private String merchant;
    /**
     * 活动时间
     */
    private Date startTime;
    /**
     * 截止时间
     */
    private Date endTime;
    /**
     * 报名金额
     */
    private Double amount;
    /**
     * 分享金额
     */
    private Double shareAmount;
    /**
     * 活动限制名额
     */
    private Integer limitCount;
    /**
     * 活动参与个数
     */
    private Integer joinCount;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 首部图片
     */
    private String firstImg;
    /**
     * 商品信息
     */
    private String infoImg;
    /**
     * 尾部图片
     */
    private String footImg;
    /**
     * 分享也url地址
     */
    private String shareImg;
    /**
     * 推荐信息文字
     */
    private String techInfo;
    /**
     * 生成url地址
     */
    private String actUrl;

    public Activity(Integer id, String name, String merchant, Date startTime, Date endTime, Double amount, Double shareAmount, Integer limitCount, Integer joinCount, Date createTime, String firstImg, String infoImg, String footImg, String shareImg, String techInfo, String actUrl) {
        this.id = id;
        this.name = name;
        this.merchant = merchant;
        this.startTime = startTime;
        this.endTime = endTime;
        this.amount = amount;
        this.shareAmount = shareAmount;
        this.limitCount = limitCount;
        this.joinCount = joinCount;
        this.createTime = createTime;
        this.firstImg = firstImg;
        this.infoImg = infoImg;
        this.footImg = footImg;
        this.shareImg = shareImg;
        this.techInfo = techInfo;
        this.actUrl = actUrl;
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
    public String getMerchant() {
        return merchant;
    }
    public void setMerchant(String merchant) {
        this.merchant = merchant;
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
    public Double getAmount() {
        return amount;
    }
    public void setAmount(Double amount) {
        this.amount = amount;
    }
    public Double getShareAmount() {
        return shareAmount;
    }
    public void setShareAmount(Double shareAmount) {
        this.shareAmount = shareAmount;
    }
    public Integer getLimitCount() {
        return limitCount;
    }
    public void setLimitCount(Integer limitCount) {
        this.limitCount = limitCount;
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
    public String getFirstImg() {
        return firstImg;
    }
    public void setFirstImg(String firstImg) {
        this.firstImg = firstImg;
    }
    public String getInfoImg() {
        return infoImg;
    }
    public void setInfoImg(String infoImg) {
        this.infoImg = infoImg;
    }
    public String getFootImg() {
        return footImg;
    }
    public void setFootImg(String footImg) {
        this.footImg = footImg;
    }
    public String getShareImg() {
        return shareImg;
    }
    public void setShareImg(String shareImg) {
        this.shareImg = shareImg;
    }
    public String getTechInfo() {
        return techInfo;
    }
    public void setTechInfo(String techInfo) {
        this.techInfo = techInfo;
    }
    public String getActUrl() {
        return actUrl;
    }
    public void setActUrl(String actUrl) {
        this.actUrl = actUrl;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", merchant=").append(merchant);
        sb.append(", startTime=").append(startTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", amount=").append(amount);
        sb.append(", shareAmount=").append(shareAmount);
        sb.append(", limitCount=").append(limitCount);
        sb.append(", joinCount=").append(joinCount);
        sb.append(", createTime=").append(createTime);
        sb.append(", firstImg=").append(firstImg);
        sb.append(", infoImg=").append(infoImg);
        sb.append(", footImg=").append(footImg);
        sb.append(", shareImg=").append(shareImg);
        sb.append(", techInfo=").append(techInfo);
        sb.append(", actUrl=").append(actUrl);
        sb.append("]");
        return sb.toString();
    }
}
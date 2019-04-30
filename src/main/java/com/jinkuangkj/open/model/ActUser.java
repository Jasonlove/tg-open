/*
 * @des @TODO 
 * @name ActUser.java
 * @author Jason-pc
 * @date 2019-04-30 08:57:59
 */
package com.jinkuangkj.open.model;

/*
 * @des @TODO 
 * @name 
 * @author Jason-pc
 * @date 2019-04-30 08:57:59
 */
public class ActUser {
    private Integer id;
    /**
     * 用户id
     */
    private String openid;
    private String nickname;
    private String headimgurl;
    private Integer actId;
    /**
     * 活动分享人id
     */
    private Integer shareUserId;
    private Double shareIncome;

    public ActUser(Integer id, String openid, String nickname, String headimgurl, Integer actId, Integer shareUserId, Double shareIncome) {
        this.id = id;
        this.openid = openid;
        this.nickname = nickname;
        this.headimgurl = headimgurl;
        this.actId = actId;
        this.shareUserId = shareUserId;
        this.shareIncome = shareIncome;
    }
    public ActUser() {
        super();
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
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
    public Integer getActId() {
        return actId;
    }
    public void setActId(Integer actId) {
        this.actId = actId;
    }
    public Integer getShareUserId() {
        return shareUserId;
    }
    public void setShareUserId(Integer shareUserId) {
        this.shareUserId = shareUserId;
    }
    public Double getShareIncome() {
        return shareIncome;
    }
    public void setShareIncome(Double shareIncome) {
        this.shareIncome = shareIncome;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", openid=").append(openid);
        sb.append(", nickname=").append(nickname);
        sb.append(", headimgurl=").append(headimgurl);
        sb.append(", actId=").append(actId);
        sb.append(", shareUserId=").append(shareUserId);
        sb.append(", shareIncome=").append(shareIncome);
        sb.append("]");
        return sb.toString();
    }
}
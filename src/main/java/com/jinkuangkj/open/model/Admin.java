/*
 * @des @TODO 
 * @name Admin.java
 * @author Jason-pc
 * @date 2019-05-10 16:47:17
 */
package com.jinkuangkj.open.model;

import java.util.Date;

/*
 * @des @TODO 
 * @name 
 * @author Jason-pc
 * @date 2019-05-10 16:47:17
 */
public class Admin {
    private Integer id;
    /**
     * 用户名密码
     */
    private String username;
    private String password;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 登陆时间
     */
    private Date loginTime;
    /**
     * 角色id
     */
    private Integer roleId;

    public Admin(Integer id, String username, String password, Date createTime, Date loginTime, Integer roleId) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.createTime = createTime;
        this.loginTime = loginTime;
        this.roleId = roleId;
    }
    public Admin() {
        super();
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public Date getCreateTime() {
        return createTime;
    }
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    public Date getLoginTime() {
        return loginTime;
    }
    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }
    public Integer getRoleId() {
        return roleId;
    }
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", username=").append(username);
        sb.append(", password=").append(password);
        sb.append(", createTime=").append(createTime);
        sb.append(", loginTime=").append(loginTime);
        sb.append(", roleId=").append(roleId);
        sb.append("]");
        return sb.toString();
    }
}
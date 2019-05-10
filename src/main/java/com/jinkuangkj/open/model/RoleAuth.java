/*
 * @des @TODO 
 * @name RoleAuth.java
 * @author Jason-pc
 * @date 2019-05-10 16:47:17
 */
package com.jinkuangkj.open.model;

/*
 * @des @TODO 
 * @name 
 * @author Jason-pc
 * @date 2019-05-10 16:47:17
 */
public class RoleAuth {
    private Integer id;
    /**
     * 角色id
     */
    private Integer roleId;
    /**
     * 权限id
     */
    private Integer authId;

    public RoleAuth(Integer id, Integer roleId, Integer authId) {
        this.id = id;
        this.roleId = roleId;
        this.authId = authId;
    }
    public RoleAuth() {
        super();
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getRoleId() {
        return roleId;
    }
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
    public Integer getAuthId() {
        return authId;
    }
    public void setAuthId(Integer authId) {
        this.authId = authId;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", roleId=").append(roleId);
        sb.append(", authId=").append(authId);
        sb.append("]");
        return sb.toString();
    }
}
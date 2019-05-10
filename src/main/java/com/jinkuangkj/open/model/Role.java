/*
 * @des @TODO 
 * @name Role.java
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
public class Role {
    /**
     * 角色id
     */
    private Integer id;
    /**
     * 角色名称
     */
    private String name;
    /**
     * 描述
     */
    private String desc;

    public Role(Integer id, String name, String desc) {
        this.id = id;
        this.name = name;
        this.desc = desc;
    }
    public Role() {
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
    public String getDesc() {
        return desc;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", desc=").append(desc);
        sb.append("]");
        return sb.toString();
    }
}
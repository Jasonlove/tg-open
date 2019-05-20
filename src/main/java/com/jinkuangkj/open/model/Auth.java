/*
 * @des @TODO 
 * @name Auth.java
 * @author Jason-pc
 * @date 2019-05-20 14:28:38
 */
package com.jinkuangkj.open.model;

/*
 * @des @TODO 
 * @name 
 * @author Jason-pc
 * @date 2019-05-20 14:28:38
 */
public class Auth {
    private Integer id;
    /**
     * 1.活动，2.订单，3.转账，4.联系人
     */
    private String type;
    /**
     * 权限名称
     */
    private String name;
    /**
     * 权限描述
     */
    private String desc;
    /**
     * 项目路径
     */
    private String url;

    public Auth(Integer id, String type, String name, String desc, String url) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.desc = desc;
        this.url = url;
    }
    public Auth() {
        super();
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
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
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", type=").append(type);
        sb.append(", name=").append(name);
        sb.append(", desc=").append(desc);
        sb.append(", url=").append(url);
        sb.append("]");
        return sb.toString();
    }
}
/*
 * @des @TODO 
 * @name Contact.java
 * @author Jason-pc
 * @date 2019-05-08 10:39:47
 */
package com.jinkuangkj.open.model;

/*
 * @des @TODO 
 * @name 
 * @author Jason-pc
 * @date 2019-05-08 10:39:47
 */
public class Contact {
    /**
     * 联系信息
     */
    private Integer id;
    private Integer userId;
    /**
     * 联系人
     */
    private String name;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 公司名称
     */
    private String company;

    public Contact(Integer id, Integer userId, String name, String phone, String company) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.phone = phone;
        this.company = company;
    }
    public Contact() {
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
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getCompany() {
        return company;
    }
    public void setCompany(String company) {
        this.company = company;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", name=").append(name);
        sb.append(", phone=").append(phone);
        sb.append(", company=").append(company);
        sb.append("]");
        return sb.toString();
    }
}
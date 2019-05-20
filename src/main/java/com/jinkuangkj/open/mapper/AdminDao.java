/*
 * @des @TODO 
 * @name AdminDao.java
 * @author Jason-pc
 * @date 2019-05-10 16:47:17
 */
package com.jinkuangkj.open.mapper;

import com.jinkuangkj.open.model.Admin;

public interface AdminDao {
    int deleteById(Integer id);

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectById(Integer id);

    int updateSelective(Admin record);

    int updateById(Admin record);
    
    Admin getUserByPassword(String username,String password);
}
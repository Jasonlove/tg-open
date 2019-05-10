/*
 * @des @TODO 
 * @name RoleAuthDao.java
 * @author Jason-pc
 * @date 2019-05-10 16:47:17
 */
package com.jinkuangkj.open.mapper;

import com.jinkuangkj.open.model.RoleAuth;

public interface RoleAuthDao {
    int deleteById(Integer id);

    int insert(RoleAuth record);

    int insertSelective(RoleAuth record);

    RoleAuth selectById(Integer id);

    int updateSelective(RoleAuth record);

    int updateById(RoleAuth record);
}
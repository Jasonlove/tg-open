/*
 * @des @TODO 
 * @name RoleDao.java
 * @author Jason-pc
 * @date 2019-05-10 16:47:17
 */
package com.jinkuangkj.open.mapper;

import com.jinkuangkj.open.model.Role;

public interface RoleDao {
    int deleteById(Integer id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectById(Integer id);

    int updateSelective(Role record);

    int updateById(Role record);
}
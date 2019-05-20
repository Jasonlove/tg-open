/*
 * @des @TODO 
 * @name AuthDao.java
 * @author Jason-pc
 * @date 2019-05-10 16:47:17
 */
package com.jinkuangkj.open.mapper;

import java.util.List;

import com.jinkuangkj.open.model.Auth;

public interface AuthDao {
    int deleteById(Integer id);

    int insert(Auth record);

    int insertSelective(Auth record);

    Auth selectById(Integer id);

    int updateSelective(Auth record);

    int updateById(Auth record);
    
    List<Auth> listByRoleId(Integer roleId);
}
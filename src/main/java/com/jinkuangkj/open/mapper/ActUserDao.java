/*
 * @des @TODO 
 * @name ActUserDao.java
 * @author Jason-pc
 * @date 2019-04-26 14:20:35
 */
package com.jinkuangkj.open.mapper;

import java.util.List;
import java.util.Map;

import com.jinkuangkj.open.model.ActUser;

public interface ActUserDao {
    int deleteById(Integer id);

    int insert(ActUser record);

    int insertSelective(ActUser record);

    ActUser selectById(Integer id);

    int updateSelective(ActUser record);

    int updateById(ActUser record);
    
    ActUser selectUser(ActUser user);
    
    List<ActUser> getListByActId(Integer actId);
    
    List<ActUser> getListRanking(Integer actId);
}
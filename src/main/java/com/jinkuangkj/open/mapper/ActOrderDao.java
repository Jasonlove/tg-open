/*
 * @des @TODO 
 * @name ActOrderDao.java
 * @author Jason-pc
 * @date 2019-04-26 14:20:35
 */
package com.jinkuangkj.open.mapper;

import com.jinkuangkj.open.model.ActOrder;

public interface ActOrderDao {
    int deleteById(Integer id);

    int insert(ActOrder record);

    int insertSelective(ActOrder record);

    ActOrder selectById(Integer id);

    int updateSelective(ActOrder record);

    int updateById(ActOrder record);
}
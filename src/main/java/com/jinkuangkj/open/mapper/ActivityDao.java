/*
 * @des @TODO 
 * @name ActivityDao.java
 * @author Jason-pc
 * @date 2019-04-26 14:20:35
 */
package com.jinkuangkj.open.mapper;

import com.jinkuangkj.open.model.Activity;

public interface ActivityDao {
    int deleteById(Integer id);

    int insert(Activity record);

    int insertSelective(Activity record);

    Activity selectById(Integer id);

    int updateSelective(Activity record);

    int updateById(Activity record);
}
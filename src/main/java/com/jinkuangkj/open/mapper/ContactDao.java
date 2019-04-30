/*
 * @des @TODO 
 * @name ContactDao.java
 * @author Jason-pc
 * @date 2019-04-30 08:57:59
 */
package com.jinkuangkj.open.mapper;

import com.jinkuangkj.open.model.Contact;

public interface ContactDao {
    int deleteById(Integer id);

    int insert(Contact record);

    int insertSelective(Contact record);

    Contact selectById(Integer id);

    int updateSelective(Contact record);

    int updateById(Contact record);
}
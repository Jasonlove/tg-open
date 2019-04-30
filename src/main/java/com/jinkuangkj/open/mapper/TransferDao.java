/*
 * @des @TODO 
 * @name TransferDao.java
 * @author Jason-pc
 * @date 2019-04-30 08:57:59
 */
package com.jinkuangkj.open.mapper;

import com.jinkuangkj.open.model.Transfer;

public interface TransferDao {
    int deleteById(Integer id);

    int insert(Transfer record);

    int insertSelective(Transfer record);

    Transfer selectById(Integer id);

    int updateSelective(Transfer record);

    int updateById(Transfer record);
}
package com.jinkuangkj.open.excel.model;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 导出数据标记
 * @Title: 描述
 * @author: 肖佳佳 
 * @date: 2019-06-03 16:57
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExportTransfer extends BaseRowModel {
	@ExcelProperty(value = "活动名称",index = 0)
    private String actName;
	/**
	 * 写字楼名称
	 */
    @ExcelProperty(value = "用户昵称",index = 1)
    private String nickname;

    /**
     * 经度
     */
    @ExcelProperty(value = "分享金额",index = 2)
    private String amount;

    /**
     * 纬度
     */
    @ExcelProperty(value = "转账编号",index = 3)
    private String transferNo;
    
    /**
     * 等级
     */
    @ExcelProperty(value = "创建时间",index = 4)
    private String createTime;
    
   
}

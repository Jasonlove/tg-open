package com.jinkuangkj.open.excel;


import java.util.ArrayList;
import java.util.List;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

/**
 * 
 * @Title: 描述
 * @author: 肖佳佳 
 * @date: 2019-05-28 13:29
 */
public class ExcelListener<E>  extends AnalysisEventListener<E> {

    //可以通过实例获取该值
    private List<E> datas = new ArrayList<>();

    /**
     * 通过 AnalysisContext 对象还可以获取当前 sheet，当前行等数据
     */
    @Override
    public void invoke(E object, AnalysisContext context) {
        //数据存储到list，供批量处理，或后续自己业务逻辑处理。
        datas.add(object);
    }
    
    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
    }

    public List<E> getDatas() {
        return datas;
    }

    public void setDatas(List<E> datas) {
        this.datas = datas;
    }
}
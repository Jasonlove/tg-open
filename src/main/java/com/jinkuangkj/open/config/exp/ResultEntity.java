package com.jinkuangkj.open.config.exp;

import java.io.Serializable;
import java.util.HashMap;

@SuppressWarnings("unchecked")
public class ResultEntity<T> implements Serializable{
	
	
	private static final long serialVersionUID = -8442348611678831800L;
	private Integer code = 500;	
	private String desc;
	private T modelData;
	

	public ResultEntity() {
		
	}
	
	public ResultEntity(Integer code, String desc) {
		this.code = code;
		this.desc = desc;
		this.modelData = (T) new HashMap<>();
	}
	
	public ResultEntity(ExceptionCode exp) {
		this.code = exp.getCode();
		this.desc = exp.getDescription();
		this.modelData = (T) new HashMap<>();
	}
	
	public ResultEntity(Integer code, String desc, T modelData) {
		this.code = code;
		this.desc = desc;
		this.modelData = modelData;
	}
	
	public ResultEntity(T modelData) {
		this.code = ExceptionCode.OK.getCode();
		this.desc = ExceptionCode.OK.getDescription();
		this.modelData = modelData;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public T getModelData() {
		return modelData;
	}

	public void setModelData(T modelData) {
		this.modelData = modelData;
	}
	

}



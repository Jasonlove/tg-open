package com.jinkuangkj.open.config.exp;

public enum ExceptionCode {
	
	
	OK(200, "OK");

	private Integer code;
	private String description;
	
	private ExceptionCode(Integer code,String description) {
		this.code = code;
		this.description = description;
	}
	
	public Integer getCode() {
		return code;
	}
	public String getDescription() {
		return description;
	}
	
}

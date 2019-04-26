package com.jinkuangkj.open.config.exp;

public class BusinessException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1102716743851499599L;
	
	private Integer expCode; //操作异常
	
	private String desc;     //操作异常描述
	
	public BusinessException(String message) {
		super(message);
	}

	public BusinessException(String message, Throwable e) {
		super(message, e);
	}

	public BusinessException(ExceptionCode code) {
		super(code.getDescription());
		this.expCode = code.getCode();
		this.desc = code.getDescription();
	}

	public Integer getExpCode() {
		return expCode;
	}

	public void setExpCode(Integer expCode) {
		this.expCode = expCode;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	


}

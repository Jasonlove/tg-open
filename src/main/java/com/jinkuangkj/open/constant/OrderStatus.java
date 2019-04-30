package com.jinkuangkj.open.constant;

public enum OrderStatus {
	
	PENDING("pending"), SUCCESS("success");
	
	private String value;
	
	private OrderStatus(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	

}

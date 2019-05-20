package com.jinkuangkj.open.constant;

import org.apache.commons.lang3.StringUtils;

public enum MenuType {

	ACT("1"), ORDER("2"), TRANSFER("3"), CONTACT("4"), ADMINUSER("5");

	private String value;

	private MenuType(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public static MenuType from(String type) {
		for (MenuType prs : MenuType.values()) {
			if (StringUtils.equals(prs.getValue(), type)) {
				return prs;
			}
		}
		return null;
	}

}

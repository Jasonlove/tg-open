package com.jinkuangkj.open.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;

import lombok.extern.slf4j.Slf4j;


@Slf4j
public abstract class AbstractController {

	/**
	 * http headers content-type
	 */
	protected  static final String HTTP_CONTENT_TYPE = "content-type";

	/**
	 * http content-type text/html; charset=utf-8
	 */
	protected static final String HTTP_CHARSET_UTF8 = "text/html; charset=utf-8";


	protected String returnSuccess() {
		return "<xml><return_code><![CDATA[SUCCESS]]></return_code><return_msg><![CDATA[OK]]></return_msg></xml>";
	}
	    
    protected String getRequestBody(HttpServletRequest request) {
		String dataStr=null;
		int length = request.getContentLength();
		byte[] origin = new byte[length];
		try {
			IOUtils.readFully(request.getInputStream(), origin);
			dataStr = new String(origin,"UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return dataStr;

	}
}

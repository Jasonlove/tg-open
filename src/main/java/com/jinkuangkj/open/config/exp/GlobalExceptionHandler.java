package com.jinkuangkj.open.config.exp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;



@ControllerAdvice
@SuppressWarnings("rawtypes")
public class GlobalExceptionHandler {
	
	
	private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	
	
	//全局异常
	@ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResultEntity exceptionHandler(HttpServletRequest req,HttpServletResponse response, Exception e) throws Exception {
		log.error("异常日志", e);
		responseHandler(response, HttpStatus.INTERNAL_SERVER_ERROR);
		return buildErrorInfo(HttpStatus.INTERNAL_SERVER_ERROR.value(), "服务器内部异常", req);
    }
	
	
	//系统请求参数异常
	@ExceptionHandler(value = MissingServletRequestParameterException.class)
    @ResponseBody
    public ResultEntity missingServletRequestParameterExceptionHandler(HttpServletRequest req,HttpServletResponse response, MissingServletRequestParameterException e) throws Exception {
		log.error("异常日志", e);
		responseHandler(response, HttpStatus.BAD_REQUEST);
		return buildErrorInfo(HttpStatus.BAD_REQUEST.value(), e.getMessage(), req);
    }
	
	
	//全局业务异常
	@ExceptionHandler(value = BusinessException.class)
    @ResponseBody
    public ResultEntity businessExceptionHandler(HttpServletRequest req,HttpServletResponse response, BusinessException e) throws Exception {
		//log.error("异常日志", e);
		return buildErrorInfo(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage(), req);
    }
	
	
	//类型
	@ExceptionHandler(value = HttpMediaTypeNotAcceptableException.class)
    @ResponseBody
    public void HttpMediaTypeNotAcceptableExceptionHandler(HttpServletRequest req,HttpServletResponse response, BusinessException e) throws Exception {
		//log.error("异常日志", e);
    }
	

	private void responseHandler(HttpServletResponse response,HttpStatus status){
		if(response != null)
			response.setStatus(status.value());
	}
	
	private ResultEntity buildErrorInfo(Integer code,String message,HttpServletRequest req){
		ResultEntity info = new ResultEntity(code,message);
		return info;
	}
	

}

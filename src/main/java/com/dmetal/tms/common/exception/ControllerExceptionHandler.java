package com.dmetal.tms.common.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dmetal.tms.common.web.JsonResult;

/**此注解用于表示此类为全局的异常处理类*/
@ControllerAdvice
public class ControllerExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public JsonResult handleException(Exception e) {
		//...
		System.out.println("exception");
		return new JsonResult(e);
	}
	
	@ExceptionHandler(RuntimeException.class)
	@ResponseBody
	public JsonResult handleException(RuntimeException e) {
		//...
		System.out.println("runtime exception");
		return new JsonResult(e);
	}
}

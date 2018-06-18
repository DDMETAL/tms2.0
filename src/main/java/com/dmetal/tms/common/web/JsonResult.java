package com.dmetal.tms.common.web;

/**通过此对象封装控制层返回的JSON结果
 * 便于对控制层返回数据进行统一格式化管理*/
public class JsonResult {
	public static final int SUCCESS=1;
	public static final int ERROR=0;
	/**状态信息*/
	private int state;
	/**信息(给用户的提示)*/
	private String message;
	
	/**具体业务数据*/
	private Object data;

	public JsonResult() {
		this.state=SUCCESS;
		this.message="ok";
	}
	public JsonResult(Object data) {
		this();
		this.data=data;
	}
	public JsonResult(Throwable e) {
		this.state=ERROR;
		this.message=e.getMessage();
	}
	public int getState() {
		return state;
	}
	public String getMessage() {
		return message;
	}
	public Object getData() {
		return data;
	}
	
	
	
}

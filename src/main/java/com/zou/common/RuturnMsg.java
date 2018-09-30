package com.zou.common;

public enum RuturnMsg {

	/*
	 * 报错
	 */
    FAILED("90000001", "系统错误"),
    
    /**
     * 成功
     */
    SUCCESS("00000000", "success"),
    /**
     * 失败
     */
    ERROR("90000000", "操作失败"),
    /**
     * 用户名或密码错误
     */
    INVALID_USERNAME_PASSWORD("10000003", "用户名或密码错误"),
    
    /**
     * 用户没有添加、删除评论或回复的权限
     */
    USER_NO_AUTHORITY("10000013","该用户没有权限");
	

    public String result;
    public String msg;
    
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
    
	RuturnMsg(String result, String msg){
		this.result=result;
		this.msg=msg;
	}
}

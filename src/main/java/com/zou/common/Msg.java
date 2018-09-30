package com.zou.common;

public class Msg<T> {

	/*错误码*/
    private Integer code;
 
    /*提示信息 */
    private String msg;
 
    /*具体内容*/
    private  T data;
    
    private int total;

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

    
}

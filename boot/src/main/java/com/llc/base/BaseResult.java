/**
 * 
 */
/**
 * @author Administrator
 *
 */
package com.llc.base;

public class BaseResult<T> {

	private String code;
	private String msg;
	private T obj;

	

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public T getObj() {
		return obj;
	}

	public void setObj(T obj) {
		this.obj = obj;
	}

}
package com.llc.base;

public class BaseResult <T>{
	private Integer code;
	private String msg;
	private T obj;
	
	
	public BaseResult(){
	
	}
	public BaseResult(Integer code,String msg,T obj){
		this.code=code;
		this.msg=msg;
		this.obj=obj;
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
	public T getObj() {
		return obj;
	}
	public void setObj(T obj) {
		this.obj = obj;
	}
	
	
	
}

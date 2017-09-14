package com.kxll.base;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="返回结果")
public class BaseResult <T>{
	@ApiModelProperty(value="返回状态码")
	private String code;
	@ApiModelProperty(value="返回状态说明")
	private String msg;
	@ApiModelProperty(value="返回值")
	private T obj;
	
	public  BaseResult<T> success(T t){
		BaseResult <T> br=new BaseResult <T>();
		br.setCode("0000");
		br.setMsg("成功");
		br.setObj(t);
		return br;
		
	}
	public BaseResult<T> failure(T t){
		BaseResult <T> br=new BaseResult <T>();
		br.setCode("1111");
		br.setMsg("失败");
		br.setObj(t);
		return br;
		
	}
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

/**
 * 
 */
/**
 * @author Administrator
 *
 */
package com.llc.base;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="返回参数")
public class BaseResult<T> {

	@ApiModelProperty(value="返回编码")
	private String code;
	@ApiModelProperty(value="返回信息")
	private String msg;
	@ApiModelProperty(value="返回对象")
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
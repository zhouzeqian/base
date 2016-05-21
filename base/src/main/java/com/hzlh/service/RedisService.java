package com.hzlh.service;

import com.hzlh.base.ResultBase;

public interface RedisService {

	
	
	public ResultBase<String> setValue(String key,String value);
	
	public ResultBase<String> getValue(String key);
	
	public ResultBase<Long> del(String key);
	
	public ResultBase<Object> setObj(String key,Object obj);
	
	public ResultBase<Object> getObj(String key);
	
}

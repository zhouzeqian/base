package com.hzlh.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.SerializationUtils;

import com.hzlh.base.ResultBase;
import com.hzlh.base.SystemDefined;
import com.hzlh.redis.RedisClientTemplate;
import com.hzlh.service.RedisService;
@Service
@Transactional
public class RedisServiceImpl implements RedisService{

	@Resource 
	private RedisClientTemplate redisClientTemplate;
	@Override
	public ResultBase<String> setValue(String key, String value) {
		ResultBase<String> rb= new ResultBase<String>();
		rb.setCode(SystemDefined.ResultCode.SUCCESS);
		rb.setMsg("设置数据成功！");
		rb.setObj(this.redisClientTemplate.set(key, value));
		return rb;
	}

	@Override
	public ResultBase<String> getValue(String key) {
		ResultBase<String> rb=new ResultBase<String>();
		rb.setObj(this.redisClientTemplate.get(key));
		rb.setCode(SystemDefined.ResultCode.SUCCESS);
		rb.setMsg("获取数据成功！");
		return rb;
	}

	@Override
	public ResultBase<Long> del(String key) {
		ResultBase<Long> rb=new ResultBase<Long>();
		rb.setObj(this.redisClientTemplate.del(key));
		rb.setCode(SystemDefined.ResultCode.SUCCESS);
		rb.setMsg("删除数据成功！");
		return rb;
	}

	@Override
	public ResultBase<Object> setObj(String key, Object obj) {
		ResultBase<Object> rb= new ResultBase<Object>();
		rb.setCode(SystemDefined.ResultCode.SUCCESS);
		rb.setMsg("设置数据成功！");
		rb.setObj(this.redisClientTemplate.set(key.getBytes(),SerializationUtils.serialize(obj)));
		return rb;
	}

	@Override
	public ResultBase<Object> getObj(String key) {
		ResultBase<Object> rb=new ResultBase<Object>();
		rb.setObj(SerializationUtils.deserialize(this.redisClientTemplate.get(key.getBytes())));
		rb.setCode(SystemDefined.ResultCode.SUCCESS);
		rb.setMsg("获取数据成功！");
		return rb;
	}

	
}

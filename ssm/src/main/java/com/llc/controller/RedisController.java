package com.llc.controller;

import javax.annotation.Resource;

import org.apache.commons.lang3.SerializationUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.llc.base.BaseResult;
import com.llc.redis.RedisClientTemplate;

@RestController
@RequestMapping("redis")
public class RedisController {
	@Resource
	RedisClientTemplate redisClient;

	@RequestMapping("add")
	public BaseResult<String> add(String key, String value) {
		return new BaseResult<String>(1, "添加成功", redisClient.set(key, value));

	}

	@RequestMapping("get")
	public BaseResult<Object> get(String key) {
		return new BaseResult<Object>(1, "获取成功", SerializationUtils.deserialize(redisClient.get(key.getBytes())));

	}

	@RequestMapping("delete")
	public BaseResult<Long> delete(String key) {
		return new BaseResult<Long>(1, "删除成功", redisClient.del(key));

	}
}

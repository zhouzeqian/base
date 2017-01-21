package com.llc.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.llc.base.BaseResult;
import com.llc.entity.User;
import com.llc.redis.RedisUtil;
import com.llc.repository.UserRepository;

@RestController
@RequestMapping("redis")
public class RedisController {
	@Resource
	RedisUtil redisUtil;
	@Resource
	private UserRepository userRepository;
	 
	
	@RequestMapping("add")
	public BaseResult<Boolean> add(Long id){
		BaseResult<Boolean> br=new BaseResult<Boolean>();
		br.setCode("SUCCESS");
		br.setMsg("缓存新增成功");
		br.setObj(redisUtil.set(id.toString(), userRepository.findOne(id)));
		return br;
	}
	
	@RequestMapping("get")
	public BaseResult<User> get(String key){
		BaseResult<User> br=new BaseResult<User>();
		br.setCode("SUCCESS");
		br.setMsg("缓存获取成功");
		br.setObj((User) redisUtil.get(key));
		return br;
	}
	
	@RequestMapping("delete")
	public BaseResult<Boolean> delete(String key){
		BaseResult<Boolean> br=new BaseResult<Boolean>();
		br.setCode("SUCCESS");
		br.setMsg("缓存删除成功");
		redisUtil.remove(key);
		return br;
	}
	
	@RequestMapping("update")
	public BaseResult<String> update(){
		BaseResult<String> br=new BaseResult<String>();
		return br;
	}
}

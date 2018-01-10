package com.llc.service;

import org.springframework.stereotype.Component;
import com.llc.entity.Message;
@Component
public class MyHystrix implements FeignService{

	@Override
	public Message getMsg(Message msg) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String home(String name) {
		// TODO Auto-generated method stub
		return "注册中心service-client服务不存在或者未启动";
	}

}

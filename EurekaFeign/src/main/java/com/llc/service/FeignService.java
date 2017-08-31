package com.llc.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.llc.entity.Message;

@FeignClient(value = "service-client")
public interface FeignService {
	@RequestMapping(value = "/test/getMsg", method = RequestMethod.GET)
	public Message getMsg(@RequestBody Message msg);

	@RequestMapping("/test/hi")
	public String home(@RequestParam("name") String name);
}

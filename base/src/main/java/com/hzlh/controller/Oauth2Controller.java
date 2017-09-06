package com.hzlh.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import com.hzlh.base.ResultBase;
import com.hzlh.util.HttpUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("oauth2")
@Api(description = "oauth2获取令牌和刷新令牌")
public class Oauth2Controller {
	Logger log = LoggerFactory.getLogger(this.getClass());

	@RequestMapping(value = "getToken", method = RequestMethod.POST)
	@ApiOperation(value = "获取token", notes = "获取token")
	public ResultBase<JSONObject> getToken(HttpServletRequest request,
			@ApiParam(name = "username", value = "用户名", required = true) @RequestParam(value = "username") String username,
			@ApiParam(name = "password", value = "密码", required = true) @RequestParam(value = "password", required = true) String password) {
		ResultBase<JSONObject> rb = new ResultBase<JSONObject>();
		rb.setCode(true);
		rb.setMsg("获取token成功");
		Map<String, String> maps = Maps.newHashMap();
		maps.put("client_id", "mobile-client");
		maps.put("client_secret", "mobile");
		maps.put("grant_type", "password");
		maps.put("scope", "read");
		maps.put("username", username);
		maps.put("password", password);
		String result = HttpUtils.getInstance().sendHttpPost(
				"http://" + request.getServerName() + ":" + request.getServerPort() + "/base/oauth/token", maps);
		rb.setObj(JSON.parseObject(result));
		return rb;
	}

	@RequestMapping(value = "refreshToken", method = RequestMethod.POST)
	@ApiOperation(value = "刷新token", notes = "刷新token")
	public ResultBase<JSONObject> refreshToken(HttpServletRequest request,
			@ApiParam(name = "refresh_token", value = "刷新token", required = true) @RequestParam(value = "refresh_token") String refresh_token) {
		ResultBase<JSONObject> rb = new ResultBase<JSONObject>();
		rb.setCode(true);
		rb.setMsg("刷新token成功");
		Map<String, String> maps = Maps.newHashMap();
		maps.put("client_id", "mobile-client");
		maps.put("client_secret", "mobile");
		maps.put("grant_type", "refresh_token");
		maps.put("scope", "read");
		maps.put("refresh_token", refresh_token);
		String result = HttpUtils.getInstance().sendHttpPost(
				"http://" + request.getServerName() + ":" + request.getServerPort() + "/base/oauth/token", maps);
		rb.setObj(JSON.parseObject(result));
		return rb;
	}

}

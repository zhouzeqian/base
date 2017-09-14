package com.kxll.base;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import com.alibaba.fastjson.JSON;

public class BaseExceptionResolver extends SimpleMappingExceptionResolver {
	public static final Log log = LogFactory.getLog(BaseExceptionResolver.class);

	@Override
	protected ModelAndView doResolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		// TODO Auto-generated method stub

		HandlerMethod mathod = (HandlerMethod) handler;
		ResponseBody body = mathod.getMethodAnnotation(ResponseBody.class);
		if (body == null) {
			return super.doResolveException(request, response, handler, ex);
		}
		ModelAndView mv = new ModelAndView();
		// 设置状态码
		response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		// 设置ContentType
		response.setContentType(MediaType.APPLICATION_JSON_VALUE);
		// 避免乱码
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Cache-Control", "no-cache, must-revalidate");
		BaseResult<String> br=new BaseResult<String>();
		try {
			response.getWriter().write(JSON.toJSONString(br));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return mv;
	}

}

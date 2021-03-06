package com.kxll.base;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.support.spring.FastJsonJsonView;

/**
 * 系统默认异常处理
 * @author Administrator
 *
 */
public class DefaultExceptionHandler implements HandlerExceptionResolver {

	private static Logger log = LoggerFactory.getLogger(DefaultExceptionHandler.class);
	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		ModelAndView mv = new ModelAndView();
		/* 使用FastJson提供的FastJsonJsonView视图返回，不需要捕获异常 */
		FastJsonJsonView view = new FastJsonJsonView();
		Map<String, Object> attributes = new HashMap<String, Object>();
		attributes.put("statusCode", "300");
		attributes.put("message", "系统出错了！");
		view.setAttributesMap(attributes);
		mv.setView(view);
		log.info("异常:" + ex.toString(), ex);
		return mv;
	}

}

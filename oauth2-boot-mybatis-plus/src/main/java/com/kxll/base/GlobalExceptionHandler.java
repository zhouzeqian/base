package com.kxll.base;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;

import javax.servlet.http.HttpServletRequest;

@Order(Ordered.HIGHEST_PRECEDENCE)
@RestControllerAdvice
//全局异常处理类
public class GlobalExceptionHandler extends ExceptionHandlerExceptionResolver {
    Logger log=LoggerFactory.getLogger(this.getClass());
    @ExceptionHandler(value = Exception.class)
    public JSONObject exception(HttpServletRequest request, Exception e){
        JSONObject jo=new JSONObject();
        jo.put("errorCode",500);
        jo.put("errorMsg","系统异常");
        log.info(e.toString());
        return jo;
    }
}

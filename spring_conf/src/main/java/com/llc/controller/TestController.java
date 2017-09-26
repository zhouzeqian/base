package com.llc.controller;

import com.google.common.collect.Maps;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("test")
public class TestController {
    @RequestMapping("/hello")
    public Map<String, Object> hello() {
        Map<String,Object> map= Maps.newHashMap();
        map.put("province","浙江省");
        map.put("city","杭州市");
        map.put("area","西湖区");
        return map;
    }
}

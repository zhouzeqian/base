package com.kxll.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.kxll.base.BasePage;
import com.kxll.entity.PinganNotifyRecords;
import com.kxll.service.FreeMakerService;

@Controller
@RequestMapping("fm")
public class FreeMarkerController {
	Logger log = LoggerFactory.getLogger(this.getClass());
	@Resource
	FreeMakerService freeMakerService;

	@RequestMapping("test")
	public ModelAndView test() {
		ModelAndView mav = new ModelAndView();
		Map<String, Object> map = Maps.newHashMap();
		map.put("name", "开心连连");
		map.put("time", new Date());
		List<String> list = Lists.newArrayList();
		list.add("星期一");
		list.add("星期二");
		list.add("星期三");
		list.add("星期四");
		list.add("星期五");
		list.add("星期六");
		list.add("星期日");
		map.put("list", list);
		mav.addObject("kxll", map);
		mav.setViewName("test");
		return mav;
	}

	@RequestMapping("page")
	@ResponseBody
	public BasePage<PinganNotifyRecords> page(String ordNo,Integer status, Integer businessType, Integer iDisplayStart,
			Integer iDisplayLength) {

		if (iDisplayStart == null)
			iDisplayStart = 0;
		if (iDisplayLength == null)
			iDisplayLength = 10;
		return new BasePage<PinganNotifyRecords>(
				freeMakerService.find(ordNo,status,iDisplayStart / iDisplayLength + 1, iDisplayLength));

	}
}

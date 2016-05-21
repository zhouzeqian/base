package com.hzlh.service.impl;

import java.util.Calendar;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hzlh.base.ResultBase;
import com.hzlh.base.SystemDefined;
import com.hzlh.service.DubboService;
@Service
@Transactional
public class DubboServiceImpl implements DubboService{

	public ResultBase<Calendar> getNow() {
		// TODO Auto-generated method stub
		ResultBase<Calendar> rb=new ResultBase<Calendar>();
		rb.setCode(SystemDefined.ResultCode.SUCCESS);
		rb.setMsg("当前时间");
		rb.setObj(Calendar.getInstance());
		return rb;
	}


}

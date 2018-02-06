package com.kxll.service.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import com.kxll.entity.PinganNotifyRecords;
import com.kxll.mapper.PinganNotifyRecordsMapper;
import com.kxll.service.FreeMakerService;

@Service
public class FreeMakerServiceImpl implements FreeMakerService {
	@Resource
	PinganNotifyRecordsMapper pinganNotifyRecordsMapper;

	@Override
	public PageInfo<PinganNotifyRecords> find(String ordNo,Integer status,Integer pageNum, Integer pageSize) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum, pageSize);
		Map<String,Object> map=Maps.newHashMap();
		map.put("ordNo", ordNo);
		map.put("status", status);
		return new PageInfo<PinganNotifyRecords>(pinganNotifyRecordsMapper.find(map));
		
	}

}

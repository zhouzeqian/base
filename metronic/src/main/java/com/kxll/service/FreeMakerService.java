package com.kxll.service;

import com.github.pagehelper.PageInfo;
import com.kxll.entity.PinganNotifyRecords;

public interface FreeMakerService {

	PageInfo<PinganNotifyRecords> find(String ordNo,Integer status,Integer pageNum,Integer pageSize);
}

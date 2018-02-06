package com.kxll.mapper;

import java.util.List;
import java.util.Map;

import com.kxll.entity.PinganNotifyRecords;

public interface PinganNotifyRecordsMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PinganNotifyRecords record);

    int insertSelective(PinganNotifyRecords record);

    PinganNotifyRecords selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PinganNotifyRecords record);

    int updateByPrimaryKey(PinganNotifyRecords record);
    
    List<PinganNotifyRecords> find(Map<String,Object> map);
}
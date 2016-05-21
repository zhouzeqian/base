package com.hzlh.dao;

import java.util.List;

import com.hzlh.entity.OauthClientDetails;

public interface OauthClientDetailsMapper {
    int deleteByPrimaryKey(String clientId);

    int insert(OauthClientDetails record);

    int insertSelective(OauthClientDetails record);

    OauthClientDetails selectByPrimaryKey(String clientId);

    int updateByPrimaryKeySelective(OauthClientDetails record);

    int updateByPrimaryKey(OauthClientDetails record);
    
    List<OauthClientDetails> selectAll();
}
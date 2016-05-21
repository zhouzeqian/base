/**
 * @author Freeman.Zhao
 * @date 2015年8月21日	
 */
package com.hzlh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hzlh.dao.OauthClientDetailsMapper;
import com.hzlh.entity.OauthClientDetails;
import com.hzlh.service.OauthService;

/**
 * @author Freeman.Zhao
 *
 */
@Service("oauthService")
@Transactional
public class OauthServiceImpl implements OauthService {

	@Autowired
	private OauthClientDetailsMapper oauthClientDetailsMapper;

	/* 
	 * 
	 */
	@Override
	public OauthClientDetails loadOauthClientDetails(String clientId) {
		
		return oauthClientDetailsMapper.selectByPrimaryKey(clientId);
	}

	/* 
	 * 
	 */
	@Override
	public List<OauthClientDetails> loadAllOauthClientDetails() {
		
		return oauthClientDetailsMapper.selectAll();
	}

	/* 
	 *
	 */
	@Override
	public void archiveOauthClientDetails(String clientId) {
		
		
	}

	

	/* 
	 * 
	 */
	@Override
	public void registerClientDetails(OauthClientDetails ocd) {
		
		oauthClientDetailsMapper.insert(ocd);
	}

	

}

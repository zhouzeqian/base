/**
 * @author Freeman.Zhao
 * @date 2015年8月21日	
 */
package com.hzlh.service;

import java.util.List;

import com.hzlh.entity.OauthClientDetails;

/**
 * @author Freeman.Zhao
 *
 */
public interface OauthService {

    OauthClientDetails loadOauthClientDetails(String clientId);

    List<OauthClientDetails> loadAllOauthClientDetails();

    void archiveOauthClientDetails(String clientId);

    void registerClientDetails(OauthClientDetails ocd);
}

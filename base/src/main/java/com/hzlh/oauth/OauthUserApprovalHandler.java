package com.hzlh.oauth;

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.AuthorizationRequest;
import org.springframework.security.oauth2.provider.approval.TokenStoreUserApprovalHandler;

import com.hzlh.entity.OauthClientDetails;
import com.hzlh.service.OauthService;

/**
 * @author Shengzhao Li
 */
public class OauthUserApprovalHandler extends TokenStoreUserApprovalHandler {

    private OauthService oauthService;

    public OauthUserApprovalHandler() {
    }


    public boolean isApproved(AuthorizationRequest authorizationRequest, Authentication userAuthentication) {
        if (super.isApproved(authorizationRequest, userAuthentication)) {
            return true;
        }
        if (!userAuthentication.isAuthenticated()) {
            return false;
        }

        OauthClientDetails clientDetails = oauthService.loadOauthClientDetails(authorizationRequest.getClientId());
        return clientDetails != null && clientDetails.getTrusted();

    }

    public void setOauthService(OauthService oauthService) {
        this.oauthService = oauthService;
    }
}

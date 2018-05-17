package com.kxll.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author zzq
 * @since 2018-05-14
 */
@TableName("oauth_access_token")
public class OauthAccessToken implements Serializable {

    private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableField(value="create_time")
	private Date createTime;

	/**
	 * 
	 */
	@TableField(value="token_id")
	private String tokenId;

	/**
	 * 
	 */
	private byte[] token;

	/**
	 * 
	 */
	@TableField(value="authentication_id")
	private String authenticationId;

	/**
	 * 
	 */
	@TableField(value="user_name")
	private String userName;

	/**
	 * 
	 */
	@TableField(value="client_id")
	private String clientId;

	/**
	 * 
	 */
	private byte[] authentication;

	/**
	 * 
	 */
	@TableField(value="refresh_token")
	private String refreshToken;



	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getTokenId() {
		return tokenId;
	}

	public void setTokenId(String tokenId) {
		this.tokenId = tokenId;
	}

	public byte[] getToken() {
		return token;
	}

	public void setToken(byte[] token) {
		this.token = token;
	}

	public String getAuthenticationId() {
		return authenticationId;
	}

	public void setAuthenticationId(String authenticationId) {
		this.authenticationId = authenticationId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public byte[] getAuthentication() {
		return authentication;
	}

	public void setAuthentication(byte[] authentication) {
		this.authentication = authentication;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

}

package com.hzlh.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.hzlh.enums.Privilege;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value="用户表")
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","operations","roles","menus"})
public class User implements Serializable {
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ApiModelProperty("ID")
	private Long id;
	@ApiModelProperty("唯一码")
    private String guid=UUID.randomUUID().toString().replaceAll("-", "");
	@ApiModelProperty("创建时间")
    private Date createTime;
	@ApiModelProperty("是否激活")
    private Boolean archived;
	@ApiModelProperty("邮箱")
    private String email;
	@ApiModelProperty("密码")
    private String password;
	@ApiModelProperty("手机号")
    private String phone;
	@ApiModelProperty("用户名")
    private String username;
	@ApiModelProperty("是否是默认用户")
    private Boolean defaultUser=false;
	@ApiModelProperty("最后登录时间")
    private Date lastLoginTime;
	@ApiModelProperty("权限")
    private List<Privilege> privileges = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid == null ? null : guid.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Boolean getArchived() {
        return archived;
    }

    public void setArchived(Boolean archived) {
        this.archived = archived;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public boolean defaultUser() {
        return defaultUser;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

	public List<Privilege> privileges() {
		return privileges;
	}



	
    
}
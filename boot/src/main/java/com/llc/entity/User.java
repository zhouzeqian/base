package com.llc.entity;

import java.io.Serializable;
import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.UUID;

/**
 * The persistent class for the user_ database table.
 * 
 */
@Entity
@Table(name = "user_")
@ApiModel(description="用户信息")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique = true, nullable = false)
	@ApiModelProperty(value="ID")
	private Long id;
	@ApiModelProperty(value="是否存档")
	private Integer archived;
	@ApiModelProperty(value="创建时间")
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss",iso=ISO.DATE_TIME)
	@Column(name = "create_time")
	private Date createTime;

	@Column(name = "default_user")
	@ApiModelProperty(value="默认用户 ")
	private Integer defaultUser;

	@Column(length = 255)
	@ApiModelProperty(value="邮件")
	private String email;

	@Column(nullable = false, length = 255)
	@ApiModelProperty(value="UUID")
	private String guid=UUID.randomUUID().toString().replaceAll("-", "");

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_login_time")
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss",iso=ISO.DATE_TIME)
	@ApiModelProperty(value="最后登录时间")
	private Date lastLoginTime;

	@Column(nullable = false, length = 255)
	@ApiModelProperty(value="密码")
	private String password;

	@Column(length = 11)
	@ApiModelProperty(value="手机号")
	private String phone;

	@Column(nullable = false, length = 255)
	@ApiModelProperty(value="用户名")
	private String username;

	public User() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getArchived() {
		return archived;
	}

	public void setArchived(Integer archived) {
		this.archived = archived;
	}

	public Integer getDefaultUser() {
		return defaultUser;
	}

	public void setDefaultUser(Integer defaultUser) {
		this.defaultUser = defaultUser;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGuid() {
		return this.guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	public Date getLastLoginTime() {
		return this.lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
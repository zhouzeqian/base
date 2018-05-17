package com.kxll.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author zzq
 * @since 2018-05-14
 */
@TableName("user_privilege")
public class UserPrivilege implements Serializable {

    private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableField(value="user_id")
	private Integer userId;

	/**
	 * 
	 */
	private String privilege;



	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getPrivilege() {
		return privilege;
	}

	public void setPrivilege(String privilege) {
		this.privilege = privilege;
	}

}

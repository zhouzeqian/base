package com.kxll.entity;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
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
public class Message implements Serializable {

    private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId(type = IdType.AUTO)
	private Integer id;

	/**
	 * 发送人ID
	 */
	@TableField(value="from_id")
	private Integer fromId;

	/**
	 * 发送人姓名
	 */
	@TableField(value="from_name")
	private String fromName;

	/**
	 * 接收人ID
	 */
	@TableField(value="to_id")
	private Integer toId;

	/**
	 * 接收人姓名
	 */
	@TableField(value="to_name")
	private String toName;

	/**
	 * 消息内容
	 */
	@TableField(value="msg_content")
	private String msgContent;

	/**
	 * 发送时间
	 */
	@TableField(value="send_time")
	private Date sendTime;

	/**
	 * 消息类型
	 */
	@TableField(value="msg_type")
	private Integer msgType;



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getFromId() {
		return fromId;
	}

	public void setFromId(Integer fromId) {
		this.fromId = fromId;
	}

	public String getFromName() {
		return fromName;
	}

	public void setFromName(String fromName) {
		this.fromName = fromName;
	}

	public Integer getToId() {
		return toId;
	}

	public void setToId(Integer toId) {
		this.toId = toId;
	}

	public String getToName() {
		return toName;
	}

	public void setToName(String toName) {
		this.toName = toName;
	}

	public String getMsgContent() {
		return msgContent;
	}

	public void setMsgContent(String msgContent) {
		this.msgContent = msgContent;
	}

	public Date getSendTime() {
		return sendTime;
	}

	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}

	public Integer getMsgType() {
		return msgType;
	}

	public void setMsgType(Integer msgType) {
		this.msgType = msgType;
	}

}

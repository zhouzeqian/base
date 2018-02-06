package com.kxll.entity;

import java.util.Date;

public class PinganNotifyRecords {
	private Long id;

	private String ordId;

	private String ordNo;

	private Integer status;

	private String amount;

	private String payTime;

	private String tradeType;

	private String openId;

	private Date createTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOrdId() {
		return ordId;
	}

	public void setOrdId(String ordId) {
		this.ordId = ordId == null ? null : ordId.trim();
	}

	public String getOrdNo() {
		return ordNo;
	}

	public void setOrdNo(String ordNo) {
		this.ordNo = ordNo == null ? null : ordNo.trim();
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getPayTime() {
		return payTime;
	}

	public void setPayTime(String payTime) {
		this.payTime = payTime == null ? null : payTime.trim();
	}

	public String getTradeType() {
		return tradeType;
	}

	public void setTradeType(String tradeType) {
		this.tradeType = tradeType == null ? null : tradeType.trim();
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId == null ? null : openId.trim();
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
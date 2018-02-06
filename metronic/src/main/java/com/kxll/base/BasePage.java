package com.kxll.base;

import java.util.List;

import com.github.pagehelper.PageInfo;

public class BasePage<T> {

	private Integer iDisplayStart;//开始页
	private Integer iDisplayLength;//分页显示长度
	private Long iTotalRecords;//总数
	private Long iTotalDisplayRecords;//总数
	private List<T> aaData;//数据源
	
	public BasePage(){
		
	}
	
	public  BasePage(PageInfo<T> pi) {
		this.iDisplayStart=pi.getStartRow();
		this.iDisplayLength=pi.getPageSize();
		this.iTotalRecords=pi.getTotal();
		this.iTotalDisplayRecords=pi.getTotal();
		this.aaData=pi.getList();
	}

	public Integer getiDisplayStart() {
		return iDisplayStart;
	}

	public void setiDisplayStart(Integer iDisplayStart) {
		this.iDisplayStart = iDisplayStart;
	}

	public Integer getiDisplayLength() {
		return iDisplayLength;
	}

	public void setiDisplayLength(Integer iDisplayLength) {
		this.iDisplayLength = iDisplayLength;
	}

	public Long getiTotalRecords() {
		return iTotalRecords;
	}

	public void setiTotalRecords(Long iTotalRecords) {
		this.iTotalRecords = iTotalRecords;
	}

	public Long getiTotalDisplayRecords() {
		return iTotalDisplayRecords;
	}

	public void setiTotalDisplayRecords(Long iTotalDisplayRecords) {
		this.iTotalDisplayRecords = iTotalDisplayRecords;
	}

	public List<T> getAaData() {
		return aaData;
	}

	public void setAaData(List<T> aaData) {
		this.aaData = aaData;
	}
	
	
}

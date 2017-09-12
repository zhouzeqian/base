package com.llc.test;

import java.io.Serializable;
import java.util.List;

public class Menu implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String name;
	private Integer type;
	List<Menu> menu;
	
	
	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public Integer getType() {
		return type;
	}



	public void setType(Integer type) {
		this.type = type;
	}



	public List<Menu> getMenu() {
		return menu;
	}



	public void setMenu(List<Menu> menu) {
		this.menu = menu;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}

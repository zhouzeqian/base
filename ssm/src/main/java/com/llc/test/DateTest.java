package com.llc.test;

import java.util.List;
import java.util.UUID;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;

public class DateTest {

	static void indefinite(String... strs) {
		for (String str : strs)
			System.out.print(str + "  ");

		System.out.println();
	}

	public static void main(String[] args) {
	
		Menu m=new Menu();
		m.setId(UUID.randomUUID().toString());
		m.setName("qqqqqq");
		m.setType(1);
		
		List<Menu> list=Lists.newArrayList();
		Menu M=new Menu();
		M.setId(UUID.randomUUID().toString());
		M.setName("wwwwww");
		M.setType(2);
		list.add(M);
		m.setMenu(list);
		System.out.println(JSON.toJSON(m));
	}

}

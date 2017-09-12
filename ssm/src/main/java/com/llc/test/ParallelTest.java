package com.llc.test;

import java.util.TreeMap;

import org.apache.commons.codec.digest.DigestUtils;

import com.google.common.collect.Maps;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ParallelTest {

	public static void main(String[] args) {
		// 门店open_id
		String open_id = "e262f405e0e3e5ebc13efb44f250aca0";
		// 门店open_key
		String open_key = "1b0628cc8dad7d1fe59a84687867da92";
		TreeMap<String, String> map = Maps.newTreeMap();
		//map.put("ord_no", "91492501843692442760");
		map.put("out_no", "201704181550438916");
		map.put("status", "4");
		map.put("randstr", null);
		map.put("timestamp", "1492502623");
		map.put("open_key", open_key);
		map.put("open_id", open_id);
		StringBuffer sb = new StringBuffer();
		for (String key : map.keySet())
			sb.append(key + "=" + map.get(key) + "&");

		sb.deleteCharAt(sb.length()-1);
		System.out.println(sb);
		System.out.println(DigestUtils.md5Hex(DigestUtils.sha1Hex(sb.toString())));
		Gson gson=new GsonBuilder().serializeNulls().create();
		System.out.println(gson.toJson(map));
	}

}

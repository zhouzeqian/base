package com.llc.test;

import java.io.BufferedReader;
import java.io.File;
import java.nio.charset.Charset;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.io.Files;
import com.llc.util.ImageUtil;

public class URResultTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = Files.newReader(new File("C:/Users/Administrator/Desktop/udResult.json"),
				Charset.forName("UTF-8"));
		String str;
		StringBuffer sb = new StringBuffer();
		while ((str = br.readLine()) != null) {
			sb.append(str);
		}

		JSONObject jo = JSON.parseObject(sb.toString());
		System.out.println(jo);
		for (String key : jo.keySet()) {
			System.out.println(key);
		}
		ImageUtil.decodeBase64ToImage(jo.getString("photo_get"), "C:/Users/Administrator/Desktop/", "photo_get.jpg");
	}

}

package com.kxll.test;

import java.io.File;
import java.util.Date;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.util.Zip4jConstants;

public class SameTest {

	public static void main(String[] args) throws ZipException {
		Map<String,Object> map=Maps.newHashMap();
		map.put("name", "开心连连");
		map.put("time", new Date());
		
		System.out.println(JSONObject.parseObject(JSON.toJSONString(map)).getTimestamp("time"));

		ZipFile zf=new ZipFile("D:/llpt.zip");
		ZipParameters zp=new ZipParameters();
		 //设置压缩方法
        zp.setCompressionMethod(Zip4jConstants.COMP_DEFLATE);

        zp.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_NORMAL);

        //设置压缩文件加密
        zp.setEncryptFiles(true);

        //设置加密方法
        zp.setEncryptionMethod(Zip4jConstants.ENC_METHOD_AES);

        //设置aes加密强度
        zp.setAesKeyStrength(Zip4jConstants.AES_STRENGTH_256);
		zp.setPassword("123456");
		zf.createZipFileFromFolder(new File("D:/llpt"), zp,true,65536);
	}

}

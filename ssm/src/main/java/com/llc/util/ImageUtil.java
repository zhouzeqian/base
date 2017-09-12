package com.llc.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.codec.binary.Base64;

import com.google.common.io.Files;

public class ImageUtil {
	/**
	 * 将Base64位编码的图片进行解码，并保存到指定目录
	 * 
	 * @param base64
	 *            base64编码的图片信息
	 * @return
	 * @throws Exception
	 */
	public static void decodeBase64ToImage(String base64, String path,
			String imgName) throws Exception {

		File file = new File(path + imgName);
		if (!file.exists())
			file.getParentFile().mkdirs();
		byte[] decoderBytes = Base64.decodeBase64(base64);
		Files.write(decoderBytes,file);

	}

	public static String GetImageStr(String imgFile) {// 将图片文件转化为字节数组字符串，并对其进行Base64编码处理

		InputStream in = null;
		byte[] data = null;
		// 读取图片字节数组
		try {
			in = new FileInputStream(imgFile);
			data = new byte[in.available()];
			in.read(data);
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 对字节数组Base64编码

		return Base64.encodeBase64String(data);// 返回Base64编码过的字节数组字符串
	}

	public static void main(String[] args) {
		try {
			String base64String=GetImageStr("E:\\WallPaper\\唯美植物\\唯美植物[ITianKong.Net] (02).jpg");
			System.out.println(base64String);
			decodeBase64ToImage(base64String,"D:/","base64.jpg");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

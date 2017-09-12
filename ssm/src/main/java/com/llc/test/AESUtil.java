package com.llc.test;

import java.math.BigInteger;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class AESUtil {
	/**
	 * 加密
	 * 
	 * @param String
	 *            src 加密字符串
	 * @param String
	 *            key 密钥
	 * @return 加密后的字符串
	 */
	public static String Encrypt(String src, String key) throws Exception {
		// 判断密钥是否为空
		if (key == null) {
			System.out.print("密钥不能为空");
			return null;
		}

		// 密钥补位
		int plus = 16 - key.length();
		byte[] data = key.getBytes("utf-8");
		byte[] raw = new byte[16];
		byte[] plusbyte = { 0x00, 0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07, 0x08, 0x09, 0x0a, 0x0b, 0x0c, 0x0d, 0x0e,
				0x0f };
		for (int i = 0; i < 16; i++) {
			if (data.length > i)
				raw[i] = data[i];
			else
				raw[i] = plusbyte[plus];
		}

		SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
		Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding"); // 算法/模式/补码方式
		cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
		byte[] encrypted = cipher.doFinal(src.getBytes("utf-8"));

		// return new Base64().encodeToString(encrypted);//base64
		return binary(encrypted, 16); // 十六进制
	}

	/**
	 * 解密
	 * 
	 * @param String
	 *            src 解密字符串
	 * @param String
	 *            key 密钥
	 * @return 解密后的字符串
	 */
	public static String Decrypt(String src, String key) throws Exception {
		try {
			// 判断Key是否正确
			if (key == null) {
				System.out.print("Key为空null");
				return null;
			}

			// 密钥补位
			int plus = 16 - key.length();
			byte[] data = key.getBytes("utf-8");
			byte[] raw = new byte[16];
			byte[] plusbyte = { 0x00, 0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07, 0x08, 0x09, 0x0a, 0x0b, 0x0c, 0x0d,
					0x0e, 0x0f };
			for (int i = 0; i < 16; i++) {
				if (data.length > i)
					raw[i] = data[i];
				else
					raw[i] = plusbyte[plus];
			}

			SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			cipher.init(Cipher.DECRYPT_MODE, skeySpec);

			// byte[] encrypted1 = new Base64().decode(src);//base64
			byte[] encrypted1 = toByteArray(src);// 十六进制

			try {
				byte[] original = cipher.doFinal(encrypted1);
				String originalString = new String(original, "utf-8");
				return originalString;
			} catch (Exception e) {
				System.out.println(e.toString());
				return null;
			}
		} catch (Exception ex) {
			System.out.println(ex.toString());
			return null;
		}
	}

	/**
	 * 将byte[]转为各种进制的字符串
	 * 
	 * @param bytes
	 *            byte[]
	 * @param radix
	 *            可以转换进制的范围，从Character.MIN_RADIX到Character.MAX_RADIX，超出范围后变为10进制
	 * @return 转换后的字符串
	 */
	public static String binary(byte[] bytes, int radix) {
		return new BigInteger(1, bytes).toString(radix); // 这里的1代表正数
	}

	/**
	 * 16进制的字符串表示转成字节数组
	 * 
	 * @param hexString
	 *            16进制格式的字符串
	 * @return 转换后的字节数组
	 **/
	public static byte[] toByteArray(String hexString) {
		if (hexString.isEmpty())
			throw new IllegalArgumentException("this hexString must not be empty");

		hexString = hexString.toLowerCase();
		final byte[] byteArray = new byte[hexString.length() / 2];
		int k = 0;
		for (int i = 0; i < byteArray.length; i++) {// 因为是16进制，最多只会占用4位，转换成字节需要两个16进制的字符，高位在先
			byte high = (byte) (Character.digit(hexString.charAt(k), 16) & 0xff);
			byte low = (byte) (Character.digit(hexString.charAt(k + 1), 16) & 0xff);
			byteArray[i] = (byte) (high << 4 | low);
			k += 2;
		}
		return byteArray;
	}

	public static void main(String[] args) throws Exception {
		// 密钥
		String key = "1b0628cc8dad7d1fe59a84687867da92";
		// 需要加密的字符串
		String src = "出版社";

		System.out.println(src);

		// 加密
		String enString = Encrypt(src, key);
		System.out.println("加密后的字串是：" + enString);
		String data="BA0CAFCE3B1EFF943D6169A45B64BDE7A6BDD7E60B1E1F44CCBCD9A01628FAB1D39667EDED4C3BFE1CD6D45D365431A4E496D27C52920D2EE88A34BA0AE5856ECBE5A4C8661B79573276C3853AEAACCDC9AF00F35A84AA636BD42CC770E1DE123B9ECB97C85AA49C035FBDB2497CFF4DB23915E061E208FD83584320862DC38002B48250683874360738992E530E41362ED00D04CCB6C71D825307B3E804A28D874563890C3E3F32357AF67FB96C89D610B4EF5F0AD58E5EF849E74FD93DF2FCD2CE0088264F9D6EC72E82F0C408BFA4FFD5928672A3E21A0F2E66C5A8F29BB469E0FDE8E1F8E5E6E9615D90958DF5DCF4938FAF172DF1D6767D5F93080B424E30AA26D199A1FE2842228AD4B787A9AFA377EF0EC18EDDC96E629D368E72710DDFA591814900BB5AF9DB2FBF3099359570EBF2FD5C4C31E81B817E4488A77B5D3ED7F13B5E37253DA9A864F52219292561C09A949563142DF0DDF3FAC79129A750631D5B4E1376E805B5112431DE41BBF5603B69CEA017AE178AEE82602C4621CC920216C92ACC20D8E25E904DA84C94669300987E63849430DD79A58EDF64414A0154CD6F479672828DB94DAC95F1EE2C51742B1540B359A8BA3E12AC7B587243DFB71D64DDA627137B9BD3F9F99EB23308655AE395AE0A2E933F37B324D11F38C1CFB5A1B42D87409CF0496A846A3BEF469FF3255711BD43945FA4556C97780A4462E326A580047D5AD20AC38A4471BDD9DC8CB7E54E7AF55147A58C6410B0474D55A19231EFE094BA79257D90450AF8B3EA994C836DFBEA0CDD64445683E447E01F0101EDB190934B8C2C6C8026901055CD80813145A34AB99C5ECF682A0F258583F1ADF683E20CB721E579BF8DF5B9BE330FB01430CF2DDDAF8BD0003C18552E6B9EC363CCA6E534F36CE8293F8D2C35002BEEE1F760C23DC61DD80C9F5815B8AB7672A32F886978D2B51BADCFF2A2DF4FB71A0FCA5B370C2F39EB8B78442ABCE57EF94CA8301911BF434A413450EBED765D46B1801CE65E771A2B1D979055704C1763C7D0E1AE9E223EAB2EA140";
		
		// 解密
		String DeString = Decrypt(data, key);
		System.out.println("解密后的字串是：" + DeString);
	}
}

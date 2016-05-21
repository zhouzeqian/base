package com.hzlh.util;
import java.util.Collection;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class CollectionUtil {

	
	public static <E> boolean isNotEmptyCollection(Collection<E> obj){
		return null != obj && !obj.isEmpty();
	}
	
	public static <K,V>  boolean isNotEmptyMap(Map<K,V> obj){
		return null != obj && !obj.isEmpty();
	}
	
	public static boolean isNotEmptyString(String string){
		return null != string && string.length() >0 && !"".equals(string)  && !string.equalsIgnoreCase("null") ;
	}
	
	public static boolean isNotEmptyArray(Object[] array){
		return null != array && array.length >0;
	}
	
	public static boolean stringsEquals(String str1,String str2){
		
		if(!isNotEmptyString(str1) && !isNotEmptyString(str2))return true;
		
		if(isNotEmptyString(str1))return str1.equalsIgnoreCase(str2);
		
		return false;
		
	}
	
	// 判断email格式是否正确
	public static boolean isEmail(String email) {
		String str = "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";
		Pattern p = Pattern.compile(str);
		Matcher m = p.matcher(email);

		return m.matches();
	}
	/*public static String formatIp(String source){
		if(12 != source.length())return source;
		StringBuilder builder = new StringBuilder();
		String firstPlace = source.substring(0, 3);
		String secondPlace = source.substring(3,6);
		String thirdPlace = source.substring(6,9);
		String fourthPlace = source.substring(9,12);
		
		firstPlace = deleteZero(firstPlace);
		secondPlace = deleteZero(secondPlace);
		thirdPlace = deleteZero(thirdPlace);
		fourthPlace = deleteZero(fourthPlace);
		builder.append(firstPlace).append(Constants.POINT).append(secondPlace)
				.append(Constants.POINT).append(thirdPlace)
				.append(Constants.POINT).append(fourthPlace);
		return builder.toString();
	}
	
	private static String deleteZero(String source){
		if(source.startsWith(Constants.FLAG_0)){
			source=source.substring(0,1);
			if(source.startsWith(Constants.FLAG_0))source=source.substring(0,1);
		}
		return source;
	}*/
}
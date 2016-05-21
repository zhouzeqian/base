package com.hzlh.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class GsonUtil {

	public static Gson getGson() {
		GsonBuilder gb = new GsonBuilder().serializeNulls();
		gb.registerTypeAdapter(String.class, new StringConverter())
				.setDateFormat("yyyy-MM-dd HH:mm:ss");
		Gson gson = gb.create();
		return gson;
	}

	public static <T> String toJson(T t) {
		return getGson().toJson(t,new TypeToken<T>() {}.getType());
	}


}

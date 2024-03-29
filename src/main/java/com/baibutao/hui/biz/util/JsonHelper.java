package com.baibutao.hui.biz.util;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import wint.lang.utils.StringUtil;

public class JsonHelper {

	
	public static JSONObject getJsonObject(Object obj) {
		if (obj == null || !(obj instanceof String)) {
			return null;
		}
		String content = (String) obj;
		if (StringUtil.isBlank(content)) {
			return null;
		}
		try {
			JSONObject json = new JSONObject(content);
			return json;
		} catch (JSONException e) {
			return null;
		}
	}
	
	public static JSONArray getJsonArray(Object obj) {
		if (obj == null || !(obj instanceof String)) {
			return null;
		}
		
		String content = (String) obj;

		if (StringUtil.isBlank(content)) {
			return null;
		}
		try {
			JSONArray json = new JSONArray(content);
			return json;
		} catch (JSONException e) {
			return null;
		}
	}
	
	
	public static JSONArray getJsonArray(JSONObject json, String name) {
		if (json == null || name == null) {
			return null;
		}
		if (!json.has(name)) {
			return null;
		}
		try {
			return json.getJSONArray(name);
		} catch (JSONException e) {
			return null;
		}
	}
	
	public static JSONObject getJSONObject(JSONObject json, String name) {
		if (json == null || name == null) {
			return null;
		}
		if (!json.has(name)) {
			return null;
		}
		try {
			return json.getJSONObject(name);
		} catch (JSONException e) {
			return null;
		}
	}

	public static String getString(JSONObject json, String name, String defaultValue) {
		if (json == null || name == null) {
			return defaultValue;
		}
		if (!json.has(name)) {
			return defaultValue;
		}
		try {
			return json.getString(name);
		} catch (JSONException e) {
			return defaultValue;
		}
	}

	public static int getInt(JSONObject json, String name, int defaultValue) {
		if (json == null || name == null) {
			return defaultValue;
		}
		if (!json.has(name)) {
			return defaultValue;
		}
		try {
			return json.getInt(name);
		} catch (JSONException e) {
			return defaultValue;
		}
	}

	public static long getLong(JSONObject json, String name, long defaultValue) {
		if (json == null || name == null) {
			return defaultValue;
		}
		if (!json.has(name)) {
			return defaultValue;
		}
		try {
			return json.getLong(name);
		} catch (JSONException e) {
			return defaultValue;
		}
	}

	public static double getDouble(JSONObject json, String name, double defaultValue) {
		if (json == null || name == null) {
			return defaultValue;
		}
		if (!json.has(name)) {
			return defaultValue;
		}
		try {
			return json.getDouble(name);
		} catch (JSONException e) {
			return defaultValue;
		}
	}
	
	public static boolean getBoolean(JSONObject json, String name, boolean defaultValue) {
		if (json == null || name == null) {
			return defaultValue;
		}
		if (!json.has(name)) {
			return defaultValue;
		}
		try {
			return json.getBoolean(name);
		} catch (JSONException e) {
			return defaultValue;
		}
	}
	

}

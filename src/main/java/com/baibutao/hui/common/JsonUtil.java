
package com.baibutao.hui.common;

import java.io.StringWriter;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONWriter;

import wint.lang.magic.Property;
import wint.lang.magic.Transformer;
import wint.lang.magic.reflect.ReflectMagicObject;
import wint.lang.utils.CollectionUtil;
import wint.lang.utils.StringUtil;
import wint.lang.utils.Tuple;

import com.baibutao.hui.biz.util.Constant;

/**
 * @author niepeng
 *
 * @date 2012-9-13 下午10:41:36
 */
public class JsonUtil {
	
	public static <T> String mfields(final String fields, List<T> items) {
		StringBuilder sb = new StringBuilder();
		sb.append('[');
		Transformer<T, String> transformer = new Transformer<T, String>() {
			public String transform(Object object) {
				if (object == null) {
					return StringUtil.EMPTY;
				}
				return fields(fields, object, false);
			}
		};
		sb.append(CollectionUtil.join(items, ",", transformer));
		sb.append(']');
		return sb.toString();
	}
	
	public static String map2Json(Map<String, Object> map) throws JSONException {
		StringWriter stringWriter = new StringWriter();
		JSONWriter jsonWriter = new JSONWriter(stringWriter);
		jsonWriter.object();
		for (Map.Entry<String, Object> mapEntry : map.entrySet()) {
			jsonWriter.key(mapEntry.getKey());
			jsonWriter.value(mapEntry.getValue());
		}
		jsonWriter.endObject();
		return stringWriter.toString();
	}
	
	public static String getVersionJson(Map<String, Object> map) throws JSONException {
		return "{\"code\":0,\"data\":" + map2Json(map) + "}";
	}
	
	public static Tuple<Integer, String> parseVersionJson(String jsonStr) throws JSONException {
		JSONObject json = new JSONObject(jsonStr);
		JSONObject dataJson = new JSONObject(json.getString("data"));
		int lastversion = dataJson.getInt(Constant.KeyValue.LAST_VERSION);
		String downurl = dataJson.getString(Constant.KeyValue.DOWN_URL);
		return new Tuple<Integer, String>(lastversion, downurl);
	}
	
	public static <T> String mfieldsHasSub(final String fields, List<T> items) {
		StringBuilder sb = new StringBuilder();
		sb.append('[');
		Transformer<T, String> transformer = new Transformer<T, String>() {
			@Override
			public String transform(Object object) {
				if (object == null) {
					return StringUtil.EMPTY;
				}
				return fields(fields, object, true);
			}
		};
		sb.append(CollectionUtil.join(items, ",", transformer));
		sb.append(']');
		return sb.toString();
	}
	
	public static String fields(String fields,  Object item) {
		StringBuilder sb = new StringBuilder();
		List<String> propertyNames = StringUtil.splitTrim(fields, ",");
//		fieldsImpl(propertyNames, item, sb, null);
		fieldsImpl(propertyNames, item, sb, false);
		return sb.toString();
	}
	
	
	
	
	public static String fields(String fields,  Object item, boolean hasSub) {
		StringBuilder sb = new StringBuilder();
		List<String> propertyNames = StringUtil.splitTrim(fields, ",");
//		fieldsImpl(propertyNames, item, sb, null);
		fieldsImpl(propertyNames, item, sb, hasSub);
		return sb.toString();
	}
	
	private static void fieldsImpl(List<String> propertyNames, Object item, StringBuilder sb, boolean hasSub) {
		ReflectMagicObject ref = new ReflectMagicObject(item);
		Map<String, Property> properties = CollectionUtils.newHashMap();
		for(String field : propertyNames) {
			int pointSplitIndex = field.indexOf(".");
			if( pointSplitIndex> 0) {
				String objName = field.substring(0,pointSplitIndex);
				String objAttributeName = field.substring(pointSplitIndex + 1);
				Property property = ref.getMagicClass().getProperty(objName);
				properties.put(objAttributeName, property);
			} else {
				Property property = ref.getMagicClass().getProperty(field);
				properties.put(field, property);
			}
			
		}
		try {
			sb.append(toJson(properties, item));
		} catch (JSONException e) {
			throw new RuntimeException(e);
		}
		
	}

	private static String toJson(Map<String, Property> properties, Object item)
			throws JSONException {
		StringWriter stringWriter = new StringWriter();
		JSONWriter jsonWriter = new JSONWriter(stringWriter);
		jsonWriter.object();
		for (Map.Entry<String, Property> propertyEntry : properties.entrySet()) {
			String fieldName = propertyEntry.getKey();
			Property property = propertyEntry.getValue();
			jsonWriter.key(fieldName);
			Object value = property.getValue(item);
			if (value instanceof Date) {
				jsonWriter.value(DateUtil.format((Date) value, DateUtil.DEFAULT_DATE_FMT));
			} else {
				if (value == null) {
					jsonWriter.value(StringUtil.EMPTY);
				} /* else if(value instanceof ItemDO) {
					jsonWriter.value(getObjctAttributeValue(value, fieldName));
				} */else {
					jsonWriter.value(value);
				}
			}
		}
		jsonWriter.endObject();
		return stringWriter.toString();
	}
	
	private static Object getObjctAttributeValue(Object object, String attribute) {
		ReflectMagicObject ref = new ReflectMagicObject(object);
		Property property = ref.getMagicClass().getProperty(attribute);
		if (property != null) {
			Object attributeValue = property.getValue(object);
			if (attributeValue instanceof Date) {
				return DateUtil.format((Date) attributeValue, DateUtil.DEFAULT_DATE_FMT);
			}
			return attributeValue;
		}
		return StringUtil.EMPTY;
	}
	

	public static void main(String[] args) {
		
//		
	}
}

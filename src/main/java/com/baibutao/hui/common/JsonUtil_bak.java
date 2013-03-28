package com.baibutao.hui.common;
///**
// * 
// */
//package com.baibutao.hui.common;
//
//import java.util.List;
//
//import com.baibutao.hui.common.mirror.ObjectMirror;
//
//import wint.lang.utils.StringUtil;
//
///**
// * @author niepeng
// *
// * @date 2012-9-13 下午10:21:54
// */
//public class JsonUtil {
//
//private static final String DATE_FMT = "yyyy-MM-dd HH:mm:ss";
//	
//	/**
//	 * 格式化输出
//	 * format("price,description,phone")
//	 * @param format field1,field2,field3,...
//	 * @param items
//	 * @return
//	 */
//	public static String fields(String fieldList, Object item) {
//		StringBuilder sb = new StringBuilder();
//		List<String> propertyNames = StringUtil.splitTrim(fieldList, ",");
//		fieldsImpl(propertyNames, item, sb, null);
//		return sb.toString();
//	}
//	
//	public static Map<String, Object> makeExtMap(String json) {
//		Map<String, Object> ret = CollectionUtil.newHashMap();
//		try {
//			JSONObject jsonObject = new JSONObject(json);
//			String[] names = JSONObject.getNames(jsonObject);
//			for (String name : names) {
//				String value = jsonObject.getString(name);
//				ret.put(name, value);
//			}
//		} catch (JSONException e) {
//			throw new RuntimeException(e);
//		}
//		return ret;
//	}
//	
//	public static String fieldsExtJson(String fieldList, Object item, String extJson) {
//		return fieldsExt(fieldList, item, makeExtMap(extJson));
//	}
//	
//	public static String fieldsExt(String fieldList, Object item, Map<String, Object> extProperties) {
//		StringBuilder sb = new StringBuilder();
//		List<String> propertyNames = StringUtil.splitTrim(fieldList, ",");
//		fieldsImpl(propertyNames, item, sb, extProperties);
//		return sb.toString();
//	}
//	
//	public static String fieldsAll(Object item) {
//		ObjectMirror itemMirror = new ObjectMirror(item);
//		ClassMirror clazz = itemMirror.getClassMirror();
//		if (clazz.isPrimary() || clazz.isPrimaryWrapper()) {
//			return StringUtil.toString(item);
//		}
//		Map<String, Property> properties = clazz.getProperties();
//		StringBuilder sb = new StringBuilder();
//		fieldsImpl(properties.keySet(), item, sb, null);
//		return sb.toString();
//	}
//	
//	private static void fieldsImpl(Collection<String> propertyNames, Object item, StringBuilder sb, Map<String, Object> extProperties) {
//		ObjectMirror itemMirror = new ObjectMirror(item);
//		ClassMirror clazz = itemMirror.getClassMirror();
//		if (clazz.isPrimary() || clazz.isPrimaryWrapper()) {
//			sb.append(item);
//			return;
//		}
//		
//		Map<String, Property> properties = CollectionUtil.newHashMap();
//		for (String field :propertyNames) {
//			Property property = clazz.getProperty(field);
//			properties.put(field, property);
//		}
//		
//		try {
//			sb.append(toJson(properties, item, extProperties));
//		} catch (JSONException e) {
//			throw new RuntimeException(e);
//		}
//	}
//	
//	private static String toJson(Map<String, Property> properties, Object item, Map<String, Object> extProperties) throws JSONException {
//		StringWriter stringWriter = new StringWriter();
//		JSONWriter jsonWriter = new JSONWriter(stringWriter);
//		jsonWriter.object();
//		for (Map.Entry<String, Property> propertyEntry : properties.entrySet()) {
//			String fieldName = propertyEntry.getKey();
//			Property property = propertyEntry.getValue();
//			jsonWriter.key(fieldName);
//			Object value = property.get(item);
//			if (value instanceof Date) {
//				jsonWriter.value(DateUtil.formatDate((Date)value, DATE_FMT));
//			} else {
//				if (value == null) {
//					jsonWriter.value(StringUtil.EMPTY);
//				} else {
//					jsonWriter.value(value);
//				}
//			}
//			
//		}
//		if (!CollectionUtil.isEmpty(extProperties)) {
//			for (Map.Entry<String, Object> entry : extProperties.entrySet()) {
//				String key = entry.getKey();
//				Object value = entry.getValue();
//				jsonWriter.key(key);
//				if (value instanceof Date) {
//					jsonWriter.value(DateUtil.formatDate((Date)value, DATE_FMT));
//				} else {
//					if (value == null) {
//						jsonWriter.value(StringUtil.EMPTY);
//					} else {
//						jsonWriter.value(value);
//					}
//				}
//			}
//		}
//		jsonWriter.endObject();
//		return stringWriter.toString();
//	}
//	
//	public static <T> String mfields(String fieldList, Collection<T> items) {
//		StringBuilder sb = new StringBuilder();
//		sb.append('[');
//		sb.append(CollectionUtil.join(items, ",", new ObjectFieldTransformer<T>(fieldList)));
//		sb.append(']');
//		return sb.toString();
//	}
//	
//	private static class ObjectFieldTransformer<T> implements Transformer<T> {
//
//		private String fieldList;
//		
//		
//		public ObjectFieldTransformer(String fieldList) {
//			super();
//			this.fieldList = fieldList;
//		}
//
//		@Override
//		public String transform(T obj) {
//			return fields(fieldList, obj);
//		}
//		
//	}
//}

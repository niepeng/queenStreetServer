/**
 * 
 */
package com.baibutao.hui.common;

/**
 * @author niepeng
 *
 * @date 2012-9-12 上午1:50:26
 */
public class StringsUtil {
	
	public static final String EMPTY = "";
	
	public static final String DEFAULT_SPLIT = ",";

	public static String merge(String[] strArray, String split) {
		if (strArray == null || strArray.length == 0) {
			return EMPTY;
		}
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < strArray.length; i++) {
			result.append(strArray[i]);
			if (i + 1 != strArray.length) {
				result.append(split);
			}
		}
		return result.toString();
	}
	
	public static String merge(String[] strArray) {
		return merge(strArray, DEFAULT_SPLIT);
	}
}

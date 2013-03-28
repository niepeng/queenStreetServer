/**
 * 
 */
package com.baibutao.hui.common;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.TreeMap;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

import wint.lang.utils.CollectionUtil;

/**
 * @author niepeng
 *
 * @date 2012-9-4 下午5:36:07
 */
public class CollectionUtils extends CollectionUtil {
	public static <K, V> HashMap<K, V> newHashMap() {
		return new HashMap<K, V>();
	}

	public static <K, V> ConcurrentHashMap<K, V> newConcurrentHashMap() {
		return new ConcurrentHashMap<K, V>();
	}

	public static <K, V> TreeMap<K, V> newTreeMap() {
		return new TreeMap<K, V>();
	}

	public static <E> ArrayList<E> newArrayList() {
		return new ArrayList<E>();
	}

	public static <E> HashSet<E> newHashSet() {
		return new HashSet<E>();
	}

	public static <E> Vector<E> newVector() {
		return new Vector<E>();
	}

	public static <E> ArrayList<E> newArrayList(Collection<? extends E> c) {
		return new ArrayList<E>(c);
	}

	public static <E> boolean isEmpty(Collection<E> c) {
		if (c == null || c.isEmpty()) {
			return true;
		}
		return false;
	}

	public static <K, V> String join(Map<K, V> map, String sepKV, String sepEntry) {
		if (map == null) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		boolean first = true;
		for (Map.Entry<K, V> en : map.entrySet()) {
			if (first) {
				first = false;
			} else {
				sb.append(sepEntry);
			}
			sb.append(en.getKey());
			sb.append(sepKV);
			sb.append(en.getValue());
		}
		return sb.toString();
	}
	
	public static String join(String[] array, char split) {
		if (array == null) {
			return null;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < array.length; i++) {
			if (array[i] == null) {
				continue;
			}
			sb.append(array[i]);
			if (i < array.length - 1) {
				sb.append(split);
			}
		}
		String result = sb.toString();
		int size = result.length();
		if(size < 1) {
			return result;
		}
		if (result.charAt(size - 1) == split) {
			return result.substring(0, size - 1);
		}
		return result;
	}
}
package com.baibutao.hui.test.util;

import com.baibutao.hui.common.CollectionUtils;

import junit.framework.TestCase;

public class TestCollectionUtils extends TestCase {
	
	public void testJoin() {
		String[] array = {};
		String result = CollectionUtils.join(array, ',');
		System.out.println(result);
		
		array = new String[]{"a"};
		result = CollectionUtils.join(array, ',');
		System.out.println(result);
		
		array = new String[]{"a","b"};
		result = CollectionUtils.join(array, ',');
		System.out.println(result);
		
		array = new String[]{"a","b","c"};
		result = CollectionUtils.join(array, ',');
		System.out.println(result);
		
		array = new String[]{"a",null,"c"};
		result = CollectionUtils.join(array, ',');
		System.out.println(result);
		
		array = new String[]{"a","c", null};
		result = CollectionUtils.join(array, ',');
		System.out.println(result);
		
		
		
	}

}

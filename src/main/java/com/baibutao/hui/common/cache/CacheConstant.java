package com.baibutao.hui.common.cache;

public interface CacheConstant {

	public static final int NAMESPACE = 1;

	// 分钟
	public static final int MIN = 60;

	// 小时
	public static final int HOUR = 60 * MIN;

	// 一天
	public static final int DAY = 24 * HOUR;

	// 后面跟上类目id，如果为0，代表精选
	public static final String ITEM_LIST_PREFIX = "item_list_";

}

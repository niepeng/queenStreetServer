/**
 * 
 */
package com.baibutao.hui.test.dal;

import junit.framework.TestCase;
import wint.help.tools.ibatis.IbatisGenUtil;

import com.baibutao.hui.biz.dal.dataobject.CatDO;
import com.baibutao.hui.biz.dal.dataobject.ItemDO;
import com.baibutao.hui.biz.dal.dataobject.KeyValueDO;
import com.baibutao.hui.biz.dal.dataobject.UserDO;

/**
 * @author niepeng
 * 
 * @date 2012-8-30 下午7:45:48
 */
public class GenSql extends TestCase {
	
	public void testGenCat() {
		IbatisGenUtil.genCreateTableSqlToConsole("qs_", CatDO.class);
		IbatisGenUtil.genIbatisDaoToConsole("qs_", CatDO.class);
		IbatisGenUtil.genSqlMapToConsole("qs_", CatDO.class);
	}
	
	public void testGenItem() {
		IbatisGenUtil.genCreateTableSqlToConsole("qs_", ItemDO.class);
		IbatisGenUtil.genIbatisDaoToConsole("qs_", ItemDO.class);
		IbatisGenUtil.genSqlMapToConsole("qs_", ItemDO.class);
	}
	
	
	public void testGenKeyValue() {
		IbatisGenUtil.genCreateTableSqlToConsole("qs_", KeyValueDO.class);
		IbatisGenUtil.genIbatisDaoToConsole("qs_", KeyValueDO.class);
		IbatisGenUtil.genSqlMapToConsole("qs_", KeyValueDO.class);
	}
	
	public void testGenUer() {
		IbatisGenUtil.genCreateTableSqlToConsole("qs_", UserDO.class);
		IbatisGenUtil.genIbatisDaoToConsole("qs_", UserDO.class);
		IbatisGenUtil.genSqlMapToConsole("qs_", UserDO.class);
	}
	
	
}

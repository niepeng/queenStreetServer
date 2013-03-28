/**
 * 
 */
package com.baibutao.hui.biz.ao;

import com.baibutao.hui.biz.dal.dataobject.KeyValueDO;
import com.baibutao.hui.biz.query.ItemQuery;

import wint.help.biz.result.Result;

/**
 * @author niepeng
 *
 * @date 2012-10-12 下午1:44:37
 */
public interface JsonAO {
	
	Result index(ItemQuery query);
	
	Result detail(long itemId);
	
	Result feedback(KeyValueDO keyValueDO);
	
}

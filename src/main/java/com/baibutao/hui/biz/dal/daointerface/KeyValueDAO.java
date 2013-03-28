package com.baibutao.hui.biz.dal.daointerface;

import com.baibutao.hui.biz.dal.dataobject.KeyValueDO;

public interface KeyValueDAO {

	public long create(KeyValueDO keyValue);

	public void delete(long id);

	public void update(KeyValueDO keyValue);
	
	public KeyValueDO queryByKey(String key);

	public KeyValueDO queryById(long id);
	
}
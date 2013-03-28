package com.baibutao.hui.test.dal;

import junit.framework.Assert;

import com.baibutao.hui.biz.dal.daointerface.KeyValueDAO;
import com.baibutao.hui.biz.dal.dataobject.KeyValueDO;
import com.baibutao.hui.biz.dal.dataobject.enums.KeyValueTypeEnum;
import com.baibutao.hui.biz.util.Constant;
import com.baibutao.hui.test.BaseHui;

public class TestKeyValueDAO extends BaseHui {
	
	private KeyValueDAO keyValueDAO;
	
	
	public void testCreate() {
		KeyValueDO keyValueDO = new KeyValueDO();
		keyValueDO.setKeyName(Constant.KeyValue.AIMA_VERSION_KEY);
		keyValueDO.setValue("v");
		keyValueDO.setType(KeyValueTypeEnum.VERSION_UPDATE.getId());
		
		long id = keyValueDAO.create(keyValueDO);
		Assert.assertTrue(id > 0L);
	}
	
	public void testUpdate() {
		KeyValueDO keyValueDO = new KeyValueDO();
		keyValueDO.setKeyName(Constant.KeyValue.AIMA_VERSION_KEY);
		keyValueDO.setValue("v");
		keyValueDO.setType(KeyValueTypeEnum.VERSION_UPDATE.getId());
		
		long id = keyValueDAO.create(keyValueDO);
		keyValueDO.setId(id);
		keyValueDO.setValue("ff");
		
		keyValueDAO.update(keyValueDO);
		
	}
	
	public void testDelete() {
		KeyValueDO keyValueDO = new KeyValueDO();
		keyValueDO.setKeyName(Constant.KeyValue.AIMA_VERSION_KEY);
		keyValueDO.setValue("v");
		keyValueDO.setType(KeyValueTypeEnum.VERSION_UPDATE.getId());
		
		long id = keyValueDAO.create(keyValueDO);
		
		keyValueDAO.delete(id);
	}
	
	public void testQueryById() {
		KeyValueDO keyValueDO = new KeyValueDO();
		keyValueDO.setKeyName(Constant.KeyValue.AIMA_VERSION_KEY);
		keyValueDO.setValue("v");
		keyValueDO.setType(KeyValueTypeEnum.VERSION_UPDATE.getId());
		
		long id = keyValueDAO.create(keyValueDO);
		KeyValueDO fromDB = keyValueDAO.queryById(id);
		Assert.assertTrue(fromDB != null);
		Assert.assertEquals(keyValueDO.getValue(), fromDB.getValue());
		
	}

	public void setKeyValueDAO(KeyValueDAO keyValueDAO) {
		this.keyValueDAO = keyValueDAO;
	}
	
	
}

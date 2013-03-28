package com.baibutao.hui.test.dal;

import java.util.List;

import junit.framework.Assert;

import com.baibutao.hui.biz.dal.daointerface.ItemDAO;
import com.baibutao.hui.biz.dal.dataobject.ItemDO;
import com.baibutao.hui.biz.query.ItemQuery;
import com.baibutao.hui.test.BaseHui;

public class TestItem extends BaseHui {

	private ItemDAO itemDAO;
	
	public void testCreate() {
		ItemDO itemDO = new ItemDO();
		itemDO.setCatId(1L);
		itemDO.setShowTitle("show title");
		
		
		long id = itemDAO.create(itemDO);
		Assert.assertTrue(id > 0);
	}
	
	public void testQuery() {
		ItemQuery query = new ItemQuery();
		query.setCatId(1L);
		query.setNeedCount(true);
		
		ItemDO itemDO = new ItemDO();
		itemDO.setCatId(1L);
		itemDO.setShowTitle("show title1");
		itemDAO.create(itemDO);
		
		itemDO.setCatId(1L);
		itemDO.setShowTitle("show title2");
		itemDAO.create(itemDO);
		
		List<ItemDO> list = itemDAO.query(query);
		Assert.assertTrue(list != null && list.size() > 0);
		Assert.assertTrue(query.getTotalResultCount() > 0);
		
		
	}
	

	public void setItemDAO(ItemDAO itemDAO) {
		this.itemDAO = itemDAO;
	}
	
}

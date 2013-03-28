/**
 * 
 */
package com.baibutao.hui.test.dal;

import java.util.List;

import junit.framework.Assert;

import com.baibutao.hui.biz.dal.daointerface.CatDAO;
import com.baibutao.hui.biz.dal.dataobject.CatDO;
import com.baibutao.hui.test.BaseHui;

/**
 * @author niepeng
 * 
 * @date 2012-10-15 下午12:17:59
 */
public class TestCat extends BaseHui {

	private CatDAO catDAO;

	public void testCreate() {
		CatDO catDO = new CatDO();
		catDO.setName("cat1");
		long id = catDAO.create(catDO);

		Assert.assertTrue(id > 0);
	}

	public void testQueryById() {
		CatDO catDO = new CatDO();
		catDO.setName("cat1");
		long id = catDAO.create(catDO);

		CatDO fromDB = catDAO.queryById(id);
		Assert.assertTrue(fromDB != null);
		Assert.assertEquals(catDO.getName(), fromDB.getName());
	}

	public void testQueryAll() {
		CatDO catDO = new CatDO();
		catDO.setName("cat1");
		catDAO.create(catDO);
		
		List<CatDO> list = catDAO.queryAll();
		Assert.assertTrue(list !=null && list.size() > 0);
	}

	public void testUpdate() {
		CatDO catDO = new CatDO();
		catDO.setName("cat1");
		long id = catDAO.create(catDO);
		
		CatDO newCatDO = new CatDO();
		newCatDO.setId(id);
		newCatDO.setName("newName");
		catDAO.update(newCatDO);
	}

	public void testDelete() {
		CatDO catDO = new CatDO();
		catDO.setName("cat1");
		long id = catDAO.create(catDO);
		catDAO.delete(id);
	}

	public void setCatDAO(CatDAO catDAO) {
		this.catDAO = catDAO;
	}

}

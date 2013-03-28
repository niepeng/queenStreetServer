/**
 * 
 */
package com.baibutao.hui.biz.dal.daointerface;

import java.util.List;

import com.baibutao.hui.biz.dal.dataobject.CatDO;

/**
 * @author niepeng
 *
 * @date 2012-10-15 下午12:09:01
 */
public interface CatDAO {
	
	public long create(CatDO cat);
	
	public CatDO queryById(long id);
	
	public List<CatDO> queryAll();
	
	public void update(CatDO cat);
	
	public void delete(long id);
	
}

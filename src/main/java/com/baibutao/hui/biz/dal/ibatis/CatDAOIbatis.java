/**
 * 
 */
package com.baibutao.hui.biz.dal.ibatis;

import java.util.List;

import com.baibutao.hui.biz.dal.daointerface.CatDAO;
import com.baibutao.hui.biz.dal.dataobject.CatDO;

/**
 * @author niepeng
 *
 * @date 2012-10-15 下午12:13:11
 */
public class CatDAOIbatis extends BaseIbatisDAO implements CatDAO {

	@Override
	public long create(CatDO cat) {
		return (Long)this.getSqlMapClientTemplate().insert("CatDAO.create", cat);
	}

	@Override
	public void delete(long id) {
		this.getSqlMapClientTemplate().update("CatDAO.delete", id);
	}

	@Override
	public void update(CatDO cat) {
		this.getSqlMapClientTemplate().update("CatDAO.update", cat);
	}

	@Override
	public CatDO queryById(long id) {
		return (CatDO)this.getSqlMapClientTemplate().queryForObject("CatDAO.queryById", id);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<CatDO> queryAll() {
		return (List<CatDO>)this.getSqlMapClientTemplate().queryForList("CatDAO.queryAll");
	}
	
}

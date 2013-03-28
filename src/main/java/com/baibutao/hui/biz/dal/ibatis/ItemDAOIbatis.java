package com.baibutao.hui.biz.dal.ibatis;

import java.util.List;

import com.baibutao.hui.biz.dal.daointerface.ItemDAO;
import com.baibutao.hui.biz.dal.dataobject.ItemDO;
import com.baibutao.hui.biz.query.ItemQuery;

public class ItemDAOIbatis extends BaseIbatisDAO implements ItemDAO {
	
	@Override
	public long create(ItemDO item) {
		return (Long)this.getSqlMapClientTemplate().insert("ItemDAO.create", item);
	}

	@Override
	public void delete(long id) {
		this.getSqlMapClientTemplate().update("ItemDAO.delete", id);
	}

	@Override
	public void update(ItemDO item) {
		this.getSqlMapClientTemplate().update("ItemDAO.update", item);
	}

	@Override
	public ItemDO queryById(long id) {
		return (ItemDO)this.getSqlMapClientTemplate().queryForObject("ItemDAO.queryById", id);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ItemDO> query(ItemQuery query) {
		if (query == null) {
			return null;
		}
		if (query.isNeedCount()) {
			int totalResultCount = (Integer) this.getSqlMapClientTemplate().queryForObject("ItemDAO.queryByQueryCount", query);
			query.setTotalResultCount(totalResultCount);
		}
		return (List<ItemDO>) this.getSqlMapClientTemplate().queryForList("ItemDAO.queryByQuery", query);
	}
	
}

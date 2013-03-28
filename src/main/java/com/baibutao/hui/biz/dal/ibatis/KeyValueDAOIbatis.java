package com.baibutao.hui.biz.dal.ibatis;

import java.util.List;

import wint.lang.utils.CollectionUtil;

import com.baibutao.hui.biz.dal.daointerface.KeyValueDAO;
import com.baibutao.hui.biz.dal.dataobject.KeyValueDO;

public class KeyValueDAOIbatis extends BaseIbatisDAO implements KeyValueDAO {

	
	public long create(KeyValueDO keyValue) {
		return (Long)this.getSqlMapClientTemplate().insert("KeyValueDAO.create", keyValue);
	}

	public void delete(long id) {
		this.getSqlMapClientTemplate().update("KeyValueDAO.delete", id);
	}

	public void update(KeyValueDO keyValue) {
		this.getSqlMapClientTemplate().update("KeyValueDAO.update", keyValue);
	}

	public KeyValueDO queryById(long id) {
		return (KeyValueDO)this.getSqlMapClientTemplate().queryForObject("KeyValueDAO.queryById", id);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public KeyValueDO queryByKey(String key) {
		List<KeyValueDO> list = this.getSqlMapClientTemplate().queryForList("KeyValueDAO.queryByKey", key);
		if(!CollectionUtil.isEmpty(list)) {
			return list.get(0);
		}
		return null;
	}

	
}

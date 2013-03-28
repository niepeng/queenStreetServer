package com.baibutao.hui.biz.dal.daointerface;

import java.util.List;

import com.baibutao.hui.biz.dal.dataobject.ItemDO;
import com.baibutao.hui.biz.query.ItemQuery;

public interface ItemDAO {

	public long create(ItemDO item);

	public void delete(long id);

	public void update(ItemDO item);

	public ItemDO queryById(long id);
	
	public List<ItemDO> query(ItemQuery query);
	
}

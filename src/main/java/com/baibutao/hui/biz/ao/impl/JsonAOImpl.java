package com.baibutao.hui.biz.ao.impl;

import java.util.List;

import wint.help.biz.result.Result;
import wint.help.biz.result.ResultSupport;
import wint.help.biz.result.StringResultCode;

import com.baibutao.hui.biz.ao.BaseAO;
import com.baibutao.hui.biz.ao.JsonAO;
import com.baibutao.hui.biz.dal.daointerface.ItemDAO;
import com.baibutao.hui.biz.dal.daointerface.KeyValueDAO;
import com.baibutao.hui.biz.dal.dataobject.ItemDO;
import com.baibutao.hui.biz.dal.dataobject.KeyValueDO;
import com.baibutao.hui.biz.query.ItemQuery;

public class JsonAOImpl extends BaseAO implements JsonAO {

	private ItemDAO itemDAO;

	private KeyValueDAO keyValueDAO;

	@Override
	public Result index(ItemQuery query) {
		Result result = new ResultSupport(false);
		try {
			List<ItemDO> list = itemDAO.query(query);
			result.getModels().put("list", list);
			result.getModels().put("query", query);
			result.setSuccess(true);
		} catch (Exception e) {
			log.error("view index error", e);
		}
		return result;
	}

	@Override
	public Result detail(long id) {
		Result result = new ResultSupport(false);
		try {
			ItemDO item = itemDAO.queryById(id);
			if (item == null) {
				result.setResultCode(new StringResultCode("当前商品已经不存在了"));
				return result;
			}
			result.getModels().put("itemDO", item);
			result.setSuccess(true);
		} catch (Exception e) {
			log.error("view detail error", e);
		}
		return result;
	}

	@Override
	public Result feedback(KeyValueDO keyValueDO) {
		Result result = new ResultSupport(false);
		try {
			keyValueDAO.create(keyValueDO);
			result.setSuccess(true);
		} catch (Exception e) {
			log.error("add feedback error", e);
		}
		return result;
	}

	public void setItemDAO(ItemDAO itemDAO) {
		this.itemDAO = itemDAO;
	}

	public void setKeyValueDAO(KeyValueDAO keyValueDAO) {
		this.keyValueDAO = keyValueDAO;
	}

}

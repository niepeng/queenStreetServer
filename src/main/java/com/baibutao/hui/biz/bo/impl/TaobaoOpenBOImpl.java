package com.baibutao.hui.biz.bo.impl;

import java.util.List;

import com.baibutao.hui.biz.bo.TaobaoOpenBO;
import com.baibutao.yun.common.data.UserDO;
import com.baibutao.yun.tao.service.ItemService;
import com.taobao.api.ApiException;
import com.taobao.api.domain.Item;
import com.taobao.api.domain.TaobaokeItem;
import com.taobao.api.domain.TaobaokeShop;

public class TaobaoOpenBOImpl implements TaobaoOpenBO {
	
	private String url;
	
	private String appkey;
	
	private long pid;
	
	private String secret;
	
	private ItemService yunItemService;
	
	private UserDO userDO;

	@Override
	public String getSign(long timesTamp) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Item queryTaoItem(long taoItemId) throws ApiException {
		return yunItemService.queryById(taoItemId, getUserDO());
	}
	

	@Override
	public List<Item> queryTaoItem(List<Long> itemIds) throws ApiException {
		return yunItemService.queryByItemIds(itemIds, getUserDO());
	}
	
	@Override
	public List<Item> queryTaoItem(List<Long> itemIds, String fields) throws ApiException {
		return yunItemService.queryByItemIds(itemIds, getUserDO(), fields);
	}

	@Override
	public List<TaobaokeItem> queryTaobaokeItems(List<Long> itemIds) throws ApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TaobaokeItem queryTaobaokeItem(Long itemId) throws ApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TaobaokeShop getShopPromotionByUserNck(String userNick) throws ApiException {
		// TODO Auto-generated method stub
		return null;
	}
	
	private  UserDO getUserDO() {
		if(userDO == null) {
			userDO = new UserDO();
			userDO.setUrl(url);
			userDO.setAppkey(appkey);
			userDO.setSecret(secret);
			userDO.setPid(pid);
		}
		return userDO;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getAppkey() {
		return appkey;
	}

	public void setAppkey(String appkey) {
		this.appkey = appkey;
	}

	public long getPid() {
		return pid;
	}

	public void setPid(long pid) {
		this.pid = pid;
	}

	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}

	public ItemService getYunItemService() {
		return yunItemService;
	}

	public void setYunItemService(ItemService yunItemService) {
		this.yunItemService = yunItemService;
	}

	public void setUserDO(UserDO userDO) {
		this.userDO = userDO;
	}
	

}

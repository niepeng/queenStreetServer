package com.baibutao.hui.biz.bo;

import java.util.List;

import com.taobao.api.ApiException;
import com.taobao.api.domain.Item;
import com.taobao.api.domain.TaobaokeItem;
import com.taobao.api.domain.TaobaokeShop;

/**
 * @author lsb
 *
 * @date 2012-2-27 下午07:59:33
 */
public interface TaobaoOpenBO {
	
	String getSign(long timesTamp);
	
	Item queryTaoItem(long taoItemId) throws ApiException;
	
	List<Item> queryTaoItem(List<Long> itemIds) throws ApiException;
	
	List<Item> queryTaoItem(List<Long> itemIds, String fields) throws ApiException;
	
	List<TaobaokeItem> queryTaobaokeItems(List<Long> itemIds) throws ApiException;
	
	TaobaokeItem queryTaobaokeItem(Long itemId) throws ApiException;
	
	TaobaokeShop getShopPromotionByUserNck(String userNick) throws ApiException;
}

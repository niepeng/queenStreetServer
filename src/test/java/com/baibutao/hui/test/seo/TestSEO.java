package com.baibutao.hui.test.seo;

import java.util.List;

import com.baibutao.hui.biz.bo.TaobaoOpenBO;
import com.baibutao.hui.common.CollectionUtils;
import com.baibutao.hui.test.BaseHui;
import com.taobao.api.ApiException;
import com.taobao.api.domain.Item;

public class TestSEO extends BaseHui {
	
	private TaobaoOpenBO taobaoOpenBO;
	
	public void testSeoInfo2() {
		List<Long> idList = CollectionUtils.newArrayList();
//		long taoItemId = 12854031576L;
		idList.add(17740827610L);
		idList.add(16088038963L);
		idList.add(15845422152L);
		idList.add(15221641785L);
		idList.add(5595355303L);
		
		String fields = "nick,list_time,delist_time,has_showcase";
		try {
			List<Item> itemList = taobaoOpenBO.queryTaoItem(idList, fields);
			for(int i=0;i<itemList.size();i++) {
				System.out.println(itemList.get(i).getNick());
				System.out.println(itemList.get(i).getListTime());
				System.out.println(itemList.get(i).getDelistTime());
				System.out.println(itemList.get(i).getHasShowcase());
			}
//			System.out.println(item.getTitle());
		} catch (ApiException e) {
			e.printStackTrace();
		}
	}

	public void testSeoInfo() {
		long taoItemId = 12854031576L;
		try {
			Item item = taobaoOpenBO.queryTaoItem(taoItemId);
			System.out.println(item.getTitle());
		} catch (ApiException e) {
			e.printStackTrace();
		}
	}

	public void setTaobaoOpenBO(TaobaoOpenBO taobaoOpenBO) {
		this.taobaoOpenBO = taobaoOpenBO;
	}
	
}


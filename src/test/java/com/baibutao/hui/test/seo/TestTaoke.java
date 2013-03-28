package com.baibutao.hui.test.seo;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import junit.framework.TestCase;
import wint.lang.utils.CollectionUtil;

import com.baibutao.blades.common.util.BladesUtil;
import com.baibutao.hui.biz.util.Md5Util;
import com.baibutao.hui.common.DateUtil;
import com.taobao.api.ApiException;
import com.taobao.api.Constants;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.internal.util.WebUtils;
import com.taobao.api.request.TaobaokeItemsConvertRequest;
import com.taobao.api.response.TaobaokeItemsConvertResponse;

public class TestTaoke extends TestCase {
	String appKey = "12524923";
	String secret = "6550c804c06066fdbc5963e23db3f0b4";
	long pid = 30231809;
	
	
	
	public void testNew() throws IOException {
		String url = "http://gw.api.taobao.com/widget/rest";
		Map<String, String> map = new HashMap<String, String>();
		map.put("app_key", appKey);
		map.put("_t_sys", "args=4");
		map.put("fields", "num_iid,nick,title,detail_url,taobaoke_items,commission_rate,price,click_url,pic_url,commission,volume,seller_credit_score");
		map.put("method", "taobao.taobaoke.widget.items.convert");
		map.put("num_iids", "16603278011");
		map.put("partner_id", "top-sdk-js-20120801");
		long timesTamp = new Date().getTime();
		map.put("timestamp", String.valueOf(timesTamp));
		map.put("sign", getSign(timesTamp));
		
//		map.put("pid", "30231809");
//		map.put("sign_method", "hmac");
//		map.put("format", "json");
		
//		String result = WebUtils.doGet(getUrlByMap(url, map), map);
//		String result = WebUtils.doPost(getUrlByMap(url, map), map, 3000 , 15000);
//		System.out.println(result);
		String content = BladesUtil.getContent(getUrlByMap(url, map), "http://baibutao.com/");
		System.out.println(content);
	}
	
	
	
	/**
	 * theme.tbapi.url=http://gw.api.taobao.com/router/rest
theme.tbapi.appkey=12524923
theme.tbapi.secret=6550c804c06066fdbc5963e23db3f0b4
theme.tbapi.pid=30231809
	 */
	
	
	
	public void testOld() throws ApiException {
		List<Long> itemIds = CollectionUtil.newArrayList();
		itemIds.add(17740827610L);
		itemIds.add(16088038963L);
		itemIds.add(15845422152L);
		itemIds.add(15221641785L);
		itemIds.add(5595355303L);
		
//		TaobaoClient client = new DefaultTaobaoClient("http://gw.api.taobao.com/router/rest", appKey, secret); 
		TaobaoClient client = new DefaultTaobaoClient("http://gw.api.taobao.com/widget/rest", appKey, secret); 

		TaobaokeItemsConvertRequest req = new TaobaokeItemsConvertRequest();
		req.setFields("num_iid,nick,title,detail_url,taobaoke_items,commission_rate,price,click_url,pic_url,commission,volume,seller_credit_score");
		req.setNumIids(CollectionUtil.join(itemIds, ","));
//		req.setNick(nick);
		req.setPid(pid);
		TaobaokeItemsConvertResponse response = client.execute(req);
		System.out.println(response.getBody());
		// {"error_response":{"code":11,"msg":"Insufficient isv permissions","sub_code":"isv.permission-api-package-limit","sub_msg":"scope ids is 289 289 289 378 379 381 382 383 384 386 387"}}


		/*
//		TaobaoClient client = new DefaultTaobaoClient("http://gw.api.taobao.com/router/rest", appKey, secret); 
		TaobaoClient client = new DefaultTaobaoClient("http://gw.api.taobao.com/widget", appKey, secret); 
		TaobaokeItemsConvertRequest req = new TaobaokeItemsConvertRequest();
		req.setFields("num_iid,nick,title,detail_url,taobaoke_items,commission_rate,price,click_url,pic_url,commission,volume,seller_credit_score");
		req.setNumIids(CollectionUtil.join(itemIds, ","));
//		req.setNick(nick);
		req.setPid(pid);
		TaobaokeItemsConvertResponse response = client.execute(req);
		System.out.println(response.getBody());
		List<TaobaokeItem> taobaokeItems = response.getTaobaokeItems();
		System.out.println(taobaokeItems);
		*/
		

//		TaobaoClient client=new DefaultTaobaoClient(url, appkey, secret);
//		TaobaokeItemsConvertRequest req= new TaobaokeItemsConvertRequest();
//		req.setFields("num_iid,nick,title,detail_url,taobaoke_items,commission_rate,price,click_url,pic_url,commission,volume,seller_credit_score");
//		req.setNumIids(CollectionUtil.join(itemIds, ","));
//		req.setNick(nick);
//		TaobaokeItemsConvertResponse response = client.execute(req);
//		List<TaobaokeItem> taobaokeItems = response.getTaobaokeItems();
//		return taobaokeItems;
		
		
	}
	
	
	public void testTao() throws ApiException, IOException {
//		result.getModels().put("timestamp", String.valueOf(timesTamp));
//		result.getModels().put("sign", taobaoOpenBO.getSign(timesTamp));
		
		List<Long> itemIds = CollectionUtil.newArrayList();
		itemIds.add(17740827610L);
		itemIds.add(16088038963L);
		itemIds.add(15845422152L);
		itemIds.add(15221641785L);
		itemIds.add(5595355303L);
		
		String url = "http://gw.api.taobao.com/widget/rest";
		Map<String, String> map = new HashMap<String, String>();
		map.put("method", "taobao.taobaoke.widget.items.convert");
		map.put("num_iids", "17740827610,16088038963");
		map.put("fields", "num_iid,nick,title,detail_url,taobaoke_items,commission_rate,price,click_url,pic_url,commission,volume,seller_credit_score");
		map.put("pid", "30231809");
		long timesTamp = new Date().getTime();
		map.put("timestamp", String.valueOf(timesTamp));
		map.put("sign", getSign(timesTamp));
		map.put("app_key", appKey);
		map.put("sign_method", "hmac");
		map.put("format", "json");
//		map.put("partner_id", "top-sdk-java-20121025");
		
//		String result = WebUtils.doPost(getUrlByMap(url, map), map, 3000, 15000);
		String result = WebUtils.doGet(getUrlByMap(url, map), map);
		System.out.println(result);
		
	}
	
	public void testQuery() throws IOException {
//		String url = "http://gw.api.taobao.com/widget/rest";
		String url = "http://gw.api.taobao.com/router/rest";
		Map<String, String> map = new HashMap<String, String>();
		map.put("method", "taobao.taobaoke.widget.items.convert");
//		map.put("num_iids", "17740827610,16088038963");
//		map.put("fields", "num_iid,nick,title,detail_url,taobaoke_items,commission_rate,price,click_url,pic_url,commission,volume,seller_credit_score");
//		map.put("pid", "30231809");
		long timesTamp = new Date().getTime();
		map.put("timestamp", String.valueOf(timesTamp));
		map.put("sign", getSign(timesTamp));
		map.put("app_key", appKey);
//		map.put("sign_method", "hmac");
//		map.put("format", "json");
		System.out.println(getUrlByMap(url, map));
	}
	
	private String getUrlByMap(String url, Map<String, String> map) throws IOException {
		String query = "?"+ WebUtils.buildQuery(map, Constants.CHARSET_UTF8);
		return url + query;
	}

	public void testSgin() {
		long timesTamp = 1358850639807L;
		Date date = new Date(timesTamp);
		System.out.println(DateUtil.format(date));
		System.out.println(getSign(timesTamp));
		System.out.println("8EDE6D3A53FA87BAD294868B1AABCBDA");
		
	}
	
	public String getSign(long timesTamp) {
		String msg = secret + "app_key" + appKey + "timestamp" + timesTamp + secret;
		return Md5Util.HMAC(msg, secret);
	}
}

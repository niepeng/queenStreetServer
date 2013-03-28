package com.baibutao.hui.test.queenstreet.dataimport;

import java.util.List;

import junit.framework.Assert;

import com.baibutao.hui.biz.util.MeilishuoHelper;
import com.baibutao.hui.test.BaseHui;

public class TestMeilishuo extends BaseHui {
	
	public void testRequest() {
		String meilishuo = "http://www.meilishuo.com";
		
		String name = "卫衣";
		int page = 0;
		int frame = 0;
		List<String> requestList = MeilishuoHelper.getRequestMeilishuoUrl(name, page, frame);
		Assert.assertTrue(requestList != null && requestList.size() > 0);
		
		/**
		 *  http://www.meilishuo.com/share/1033333016?d_r=0.1.1.1
			http://www.meilishuo.com/share/1034253274?d_r=0.1.1.2
			http://www.meilishuo.com/share/521739483?d_r=0.1.1.3
			http://www.meilishuo.com/share/471674135?d_r=0.1.1.4
			http://www.meilishuo.com/share/928442889?d_r=0.1.1.5
			http://www.meilishuo.com/share/926410465?d_r=0.1.1.6
			http://www.meilishuo.com/share/940034064?d_r=0.1.1.7
			http://www.meilishuo.com/share/957811115?d_r=0.1.1.8
			http://www.meilishuo.com/share/863331022?d_r=0.1.1.9
			http://www.meilishuo.com/share/1042215178?d_r=0.1.1.10
			http://www.meilishuo.com/share/1044547638?d_r=0.1.1.11
			http://www.meilishuo.com/share/1063146286?d_r=2.1.1.12
			http://www.meilishuo.com/share/1059769958?d_r=2.1.1.13
			http://www.meilishuo.com/share/1062889209?d_r=2.1.1.14
			http://www.meilishuo.com/share/1033330300?d_r=0.1.1.15
			http://www.meilishuo.com/share/787069865?d_r=2.1.1.16
			http://www.meilishuo.com/share/1036773076?d_r=0.1.1.17
			http://www.meilishuo.com/share/1055554813?d_r=0.1.1.18
			http://www.meilishuo.com/share/1048473601?d_r=0.1.1.19
			http://www.meilishuo.com/share/1033330198?d_r=0.1.1.20
		 */
		for(String url : requestList) {
			System.out.println(meilishuo + url);
		}
	}
	
	public void testGetSecondUrl() {
		String requestUrl = "http://www.meilishuo.com/share/1033333016?d_r=0.1.1.1";
		String secondUrl = MeilishuoHelper.getSecondUrl(requestUrl);
		// http://www.meilishuo.com/u/EDD1rw/1033333016/11111111?frm=out_link
		System.out.println(secondUrl);
		Assert.assertTrue(secondUrl != null);
	}
	
	public void testGetTaoItemId() {
		String requestUrl = "http://www.meilishuo.com/share/1033333016?d_r=0.1.1.1";
		String secondUrl = "http://www.meilishuo.com/u/EDD1rw/1033333016/11111111?frm=out_link";
		long taoItemId = MeilishuoHelper.getTaoItemIdBySecondUrl(secondUrl, requestUrl);
		
	}

}

/**
 * 
 */
package com.baibutao.hui.biz.task.impl;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import com.baibutao.hui.biz.ao.BaseAO;
import com.baibutao.hui.biz.task.DataTask;
import com.baibutao.hui.biz.util.MeilishuoHelper;
import com.baibutao.hui.biz.util.SystemClock;

/**
 * @author niepeng
 *
 * @date 2012-10-12 下午2:35:31
 */
public class DataTaskImpl extends BaseAO implements DataTask {
	
	private String geocoderKey;
	
	private AtomicBoolean runing = new AtomicBoolean(false);

	@Override
	public void autoJobMethod() {
		if(runing.get()) {
			return;
		}
		runing.set(true);
		try {
			log.error("autoJobMethod start ................");
			String name = "卫衣";
//			int page = 0;
//			int frame = 0;
			int num = 0;
			
			for (int page = 0; page < 10; page++) {
				for (int frame = 0; frame < 3; frame++) {
					List<String> list = MeilishuoHelper.getRequestMeilishuoUrl(name, page, frame);
					if (list != null) {
						for (String url : list) {
							num++;
							long taoItemId = MeilishuoHelper.getTaoItemIdByUrl("http://www.meilishuo.com" + url);
							System.out.println("num =" + num +",page="+page +", frame ="+ frame + ", ...." +url + "===> " + taoItemId);
							SystemClock.sleep(3000, 5000);
						}
					}
				}
			}
		} catch(Exception e) {
			
		} finally {
			runing.set(false);
		}
		
		
	}
	
	
	
	@Override
	public void scanOptItemMethod() {}


	public String getGeocoderKey() {
		return geocoderKey;
	}

	public void setGeocoderKey(String geocoderKey) {
		this.geocoderKey = geocoderKey;
	}
	
}

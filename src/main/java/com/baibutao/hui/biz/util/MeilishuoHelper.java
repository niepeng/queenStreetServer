package com.baibutao.hui.biz.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.baibutao.blades.common.util.BladesUtil;
import com.zjuh.sweet.lang.CollectionUtil;

/**
 * 获取美丽说的数据分为3步：
 * 第一：分析美丽说页面，根据请求得到json数据，分析出 requestUrl， （详见方法： getRequestMeilishuoUrl）
 * 第二：根据 requestUrl 得到 secondUrl （详见方法：getSecondUrl）
 * 第三：根据 secondUrl 得到 淘宝商品id  （详见方法：getTaoItemIdBySecondUrl)
 * 
 * @author lsb
 *
 */
public class MeilishuoHelper {
	
	private static Pattern pattern = Pattern.compile("id=(\\d+)");
	
	
	public static List<String> getRequestMeilishuoUrl(String name, int page, int frame) {
		try {
			// String keyword = "毛衣";
			String keywordStr = URLEncoder.encode(name, "UTF-8");

			String url = "http://www.meilishuo.com/aj/getGoods/goods?frame=" + frame + "&page=" + page + "&view=1&word_name=" + keywordStr + "&section=hot&price=all";
			String content = BladesUtil.getContent(url, "http://www.meilishuo.com", "UTF-8");

			// "tInfo": [... ]
			// "totalNum": 7519
			JSONObject json = new JSONObject(content);

			JSONArray array = JsonHelper.getJsonArray(json, "tInfo");
//			int totalNum = JsonHelper.getInt(json, "totalNum", 0);
			if (array == null) {
				return null;
			}

			List<String> requestUrlList = CollectionUtil.newArrayList();
			for (int i = 0, size = array.length(); i < size; i++) {
				JSONObject item = array.getJSONObject(i);
				if (item == null) {
					continue;
				}
				String requestUrl = JsonHelper.getString(item, "url", null);
				if (requestUrl != null) {
					requestUrlList.add(requestUrl);
				}
			}
			return requestUrlList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 根据 requestUrl 得到 淘宝淘宝商品id
	 * 
	 * @param requestUrl
	 * @return
	 */
	public static long getTaoItemIdByUrl(String requestUrl) {
		String secondUrl = getSecondUrl(requestUrl);
		return getTaoItemIdBySecondUrl(secondUrl, requestUrl);
	}
	
	
	/**
	 * 根据：
	 * http://www.meilishuo.com/share/1033333016?d_r=0.1.1.1
	 * 得到：
	 * http://www.meilishuo.com/u/EDD1rw/1033333016/11111111?frm=out_link
	 * @param requestUrl
	 * @return
	 */
	public static String getSecondUrl(String requestUrl) {
		String content = BladesUtil.getContent(requestUrl, "http://www.meilishuo.com/welcome", "UTF-8");
		Document doc = Jsoup.parse(content);
		Elements priceGo = doc.getElementsByClass("price_go");
		if(priceGo != null && priceGo.size() > 0) {
			return priceGo.get(0).attr("href");
		}
		return null;
	}
	
	/**
	 * 根据：
	 * http://www.meilishuo.com/u/EDD1rw/1033333016/11111111?frm=out_link
	 * 得到：
	 * 淘宝商品id：
	 * @param secondUrl
	 * @return
	 */
	public static long getTaoItemIdBySecondUrl(String secondUrl, String requestUrl) {
		String secContent = BladesUtil.getContent(secondUrl, requestUrl, "UTF-8");

		try {
			String content = URLDecoder.decode(secContent, "UTF-8");
			Matcher matcher = pattern.matcher(content);
			if(matcher.find()) {
				return Long.valueOf(matcher.group(1)).longValue();
			}
			
			// 这里兼容查询url是否被decode
			Matcher matcher2 = pattern.matcher(secContent);
			if(matcher2.find()) {
				return Long.valueOf(matcher2.group(1)).longValue();
			}
		} catch (Exception e) {
		}
		return 0L;
	}

}

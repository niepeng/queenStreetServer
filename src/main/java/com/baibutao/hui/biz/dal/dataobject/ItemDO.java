package com.baibutao.hui.biz.dal.dataobject;

import java.io.Serializable;

public class ItemDO extends BaseDO implements Serializable {

	private static final long serialVersionUID = -3110017303547589275L;
	
	private long id;

	/**
	 * 展现标题
	 */
	private String showTitle;
	
	private long catId;
	
	private int price;
	
	/**
	 * 手机链接 淘客
	 */
	private String mobileUrl;
	
	/**
	 * web版本的 淘客链接
	 */
	private String webClickUrl; 
	
	/**
	 * 图片链接
	 */
	private String picUrl;
	
	/**
	 * 淘宝商品id
	 */
	private long taoItemId;
	
	/**
	 * 卖家nick
	 */
	private String sellerNick;
	
	/**
	 * 卖家信用
	 */
	private int sellerCreditScore;
	

	/**
	 * 佣金比例(1234.00代表12.34%)
	 */
	private String commissionRate;

	/**
	 * 淘宝客佣金
	 */
	private String commission;
	
	/**
	 * 淘客佣金数值类型
	 */
	private int commissionNum;
	
	/**
	 * 最近销量
	 */
	private long volume;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getShowTitle() {
		return showTitle;
	}

	public void setShowTitle(String showTitle) {
		this.showTitle = showTitle;
	}

	public long getCatId() {
		return catId;
	}

	public void setCatId(long catId) {
		this.catId = catId;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getMobileUrl() {
		return mobileUrl;
	}

	public void setMobileUrl(String mobileUrl) {
		this.mobileUrl = mobileUrl;
	}

	public String getWebClickUrl() {
		return webClickUrl;
	}

	public void setWebClickUrl(String webClickUrl) {
		this.webClickUrl = webClickUrl;
	}

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public long getTaoItemId() {
		return taoItemId;
	}

	public void setTaoItemId(long taoItemId) {
		this.taoItemId = taoItemId;
	}

	public String getSellerNick() {
		return sellerNick;
	}

	public void setSellerNick(String sellerNick) {
		this.sellerNick = sellerNick;
	}

	public int getSellerCreditScore() {
		return sellerCreditScore;
	}

	public void setSellerCreditScore(int sellerCreditScore) {
		this.sellerCreditScore = sellerCreditScore;
	}

	public String getCommissionRate() {
		return commissionRate;
	}

	public void setCommissionRate(String commissionRate) {
		this.commissionRate = commissionRate;
	}

	public String getCommission() {
		return commission;
	}

	public void setCommission(String commission) {
		this.commission = commission;
	}

	public int getCommissionNum() {
		return commissionNum;
	}

	public void setCommissionNum(int commissionNum) {
		this.commissionNum = commissionNum;
	}

	public long getVolume() {
		return volume;
	}

	public void setVolume(long volume) {
		this.volume = volume;
	}
	
}

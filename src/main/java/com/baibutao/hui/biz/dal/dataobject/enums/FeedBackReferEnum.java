package com.baibutao.hui.biz.dal.dataobject.enums;

public enum FeedBackReferEnum {

	NORMAL(0, "未知"),

	ANDROID(1, "aima android client"),

	IPHONE(2, "aima iphone client");

	
	private final int value;

	private final String meaning;

	private FeedBackReferEnum(int value, String meaning) {
		this.value = value;
		this.meaning = meaning;
	}

	public static FeedBackReferEnum getValue(int argValue) {
		for (FeedBackReferEnum temp : FeedBackReferEnum.values()) {
			if (temp.getValue() == argValue) {
				return temp;
			}
		}
		return FeedBackReferEnum.NORMAL;
	}

	public int getValue() {
		return value;
	}

	public String getMeaning() {
		return meaning;
	}

}


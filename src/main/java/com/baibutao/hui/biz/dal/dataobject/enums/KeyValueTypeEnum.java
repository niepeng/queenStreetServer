package com.baibutao.hui.biz.dal.dataobject.enums;

public enum KeyValueTypeEnum {
	
	VERSION_UPDATE(1, "android_版本升级"),
	VERSION_IPHONE(2,"iPhone版本升级"),
	
	ANDROID_FEEDBACK(10,"android feedback"),
	IPHONE_FEEDBACK(11, "iPhone feedback");
	
	private final int id;
	
	private final String meaning;

	private KeyValueTypeEnum(int id, String meaning) {
		this.id = id;
		this.meaning = meaning;
	}

	public int getId() {
		return id;
	}

	public String getMeaning() {
		return meaning;
	}
}

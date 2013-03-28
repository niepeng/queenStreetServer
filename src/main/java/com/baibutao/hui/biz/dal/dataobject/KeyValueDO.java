package com.baibutao.hui.biz.dal.dataobject;

import java.io.Serializable;

public class KeyValueDO  extends BaseDO implements Serializable {
	
	private static final long serialVersionUID = -1370598434315016861L;

	private long id;
	
	private String keyName;
	
	private String value;
	
	// KeyValueTypeEnum
	private int type;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getKeyName() {
		return keyName;
	}

	public void setKeyName(String keyName) {
		this.keyName = keyName;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
	
}

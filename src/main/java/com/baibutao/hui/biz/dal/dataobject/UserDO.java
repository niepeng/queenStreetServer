package com.baibutao.hui.biz.dal.dataobject;

import java.io.Serializable;

public class UserDO  extends BaseDO implements Serializable {
	
	private static final long serialVersionUID = 4649746551754293278L;

	private long id;
	
	private String userName;


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
}

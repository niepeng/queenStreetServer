package com.baibutao.hui.biz.bean;

import java.io.Serializable;

public class UserBean implements Serializable {

	private static final long serialVersionUID = -4174405268628282711L;

	private String nick;
	
	private String password;
	
	
	
	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}

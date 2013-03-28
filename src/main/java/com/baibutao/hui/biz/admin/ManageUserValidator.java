package com.baibutao.hui.biz.admin;

import java.util.Map;

import com.baibutao.hui.biz.bean.UserBean;
import com.baibutao.hui.common.CollectionUtils;

public class ManageUserValidator {
	private static Map<String, String> users = CollectionUtils.newHashMap();

	static {
		users.put("lsb", "hellolsb");
	}

	public static boolean validate(UserBean userBean) {
		String password = users.get(userBean.getNick());
		if (password == null) {
			return false;
		}
		return password.equals(userBean.getPassword());
	}
}
package com.baibutao.hui.biz.ao;

import wint.help.codec.MD5;
import wint.mvc.flow.FlowData;

import com.baibutao.hui.web.action.BaseAction;

public class BaseAO extends BaseAction {
	

	protected boolean isSignRight(boolean isNeedSgin, String signKey, FlowData flowData) {
		if (!isNeedSgin) {
			return true;
		}
		try {
			long ts = flowData.getParameters().getLong("ts");
			String paramSign = flowData.getParameters().getString("sign").toLowerCase();
			String calcSign = MD5.encrypt(ts + signKey).toLowerCase();
			return calcSign.equals(paramSign);
		} catch (Exception e) {
			log.error("check isSignRight error", e);
			return false;
		}
	}
	
}
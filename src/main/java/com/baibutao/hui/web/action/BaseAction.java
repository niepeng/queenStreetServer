/**
 * 
 */
package com.baibutao.hui.web.action;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import wint.help.biz.result.Result;
import wint.help.biz.result.ResultCode;
import wint.help.biz.result.ResultSupport;
import wint.help.biz.result.results.CommonResultCodes;
import wint.mvc.flow.FlowData;
import wint.mvc.template.Context;

import com.baibutao.hui.common.AdminResultCodes;
import com.baibutao.hui.common.SessionKeys;

/**
 * @author niepeng
 *
 * @date 2012-9-4 下午8:07:00
 */
public class BaseAction {
	
	protected final Logger log = LoggerFactory.getLogger(getClass());
	
	public static final String JSON_TYPE = "application/json;charset=UTF-8";
	
	protected void handleError(Result result, FlowData flowData, Context context) {
		ResultCode resultCode = result.getResultCode();

		if (resultCode == null) {
			resultCode = CommonResultCodes.SYSTEM_ERROR;
		} else if (AdminResultCodes.USER_NOT_LOGIN == resultCode) {
			flowData.redirectTo("adminModule", "login");
			return;
		}
		context.put("resultmessage", resultCode);
	}
	
	protected void handleJsonError(Result result, FlowData flowData, Context context) {
		ResultCode resultCode = result.getResultCode();
		if (resultCode == null) {
			resultCode = CommonResultCodes.SYSTEM_ERROR;
		}
		context.put("code", resultCode.getCode());
		context.put("errorMessage", resultCode.getMessage());
		flowData.forwardTo("/json/error");
	}
	
	
	protected void handleResult(Result result, FlowData flowData, Context context) {
		if(!result.isSuccess()) {
			handleError(result, flowData, context);
			return;
		}
		result2Context(result, context);
	}
	
	protected void handleJsonResult(Result result, FlowData flowData, Context context) {
		flowData.setContentType(JSON_TYPE);
		if(!result.isSuccess()) {
			handleJsonError(result, flowData, context);
			return;
		}
		result2Context(result, context);
	}
	
	
	
	protected void result2Context(Result result, Context context) {
		for (Map.Entry<String, Object> entry : result.getModels().entrySet()) {
			context.put(entry.getKey(), entry.getValue());
		}
	}
	
	
	
	protected String getLoginNick(FlowData flowData) {
		HttpSession session = flowData.getSession();
		return (String) session.getAttribute(SessionKeys.NICK);
	}

	protected boolean isUserLogin(FlowData flowData) {
		return (getLoginNick(flowData) != null);
	}

	protected boolean ensureUserLogin(Result result, FlowData flowData) {
		if (!isUserLogin(flowData)) {
			result.setResultCode(AdminResultCodes.USER_NOT_LOGIN);
			return false;
		}
		return true;
	}
	
	protected Result ensureUserLogin(FlowData flowData) {
		Result result = new ResultSupport(false);
		if (!isUserLogin(flowData)) {
			result.setResultCode(AdminResultCodes.USER_NOT_LOGIN);
			return result;
		}
		result.setSuccess(true);
		return result;
	}
	


	
}

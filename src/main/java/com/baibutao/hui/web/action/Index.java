package com.baibutao.hui.web.action;

import java.util.Date;

import javax.servlet.http.HttpSession;

import wint.mvc.flow.FlowData;
import wint.mvc.template.Context;

public class Index {

	public void execute(FlowData flowData, Context context) {
		context.put("theDate", new Date());
		
		HttpSession session = flowData.getSession();
		Integer count = (Integer)session.getAttribute("count");
		if (count != null) {
			count = count + 1;
		} else {
			count = 1;
		}
		session.setAttribute("count", count);
		context.put("count", count);
		
	}
	
}

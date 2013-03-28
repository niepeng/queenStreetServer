package com.baibutao.hui.web.action.json;

import wint.help.biz.result.Result;
import wint.mvc.flow.FlowData;
import wint.mvc.template.Context;

import com.baibutao.hui.biz.ao.JsonAO;
import com.baibutao.hui.biz.query.ItemQuery;
import com.baibutao.hui.web.action.BaseAction;

public class Item extends BaseAction {
	
	private JsonAO jsonAO;
	
	private static final int PAGE_SIZE = 30;
	
	public void itemList(FlowData flowData, Context context) {
		long catId = flowData.getParameters().getLong("catId");
		int page = flowData.getParameters().getInt("page");
		
		ItemQuery query = new ItemQuery();
		query.setCatId(catId);
		query.setPageNo(page);
		query.setPageSize(PAGE_SIZE);
		
		Result result = jsonAO.index(query);
		handleJsonResult(result, flowData, context);
	}
	
	public void detail(FlowData flowData, Context context) {
		long id = flowData.getParameters().getLong("id");
		Result result = jsonAO.detail(id);
		handleJsonResult(result, flowData, context);
	}
	
	

	public void setJsonAO(JsonAO jsonAO) {
		this.jsonAO = jsonAO;
	}


}

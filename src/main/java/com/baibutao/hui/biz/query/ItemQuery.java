package com.baibutao.hui.biz.query;

import com.zjuh.sweet.query.Query;

public class ItemQuery extends Query{

	private static final long serialVersionUID = -607623211112401533L;
	
	private long catId;
	
	private boolean needCount;
	
	public ItemQuery() {}
	
	
	public ItemQuery(boolean needCount) {
		this.needCount = needCount;
	}

	public boolean isNeedCount() {
		return needCount;
	}

	public void setNeedCount(boolean needCount) {
		this.needCount = needCount;
	}

	public long getCatId() {
		return catId;
	}

	public void setCatId(long catId) {
		this.catId = catId;
	}
	
	
	
}

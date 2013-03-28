/**
 * 
 */
package com.baibutao.hui.biz.dal.dataobject;

import java.util.Date;

/**
 * @author niepeng
 *
 * @date 2012-9-4 上午11:49:17
 */
public class BaseDO {
	
	private Date gmtCreate;
	
	private Date gmtModified;

	public Date getGmtCreate() {
		return gmtCreate;
	}

	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	public Date getGmtModified() {
		return gmtModified;
	}

	public void setGmtModified(Date gmtModified) {
		this.gmtModified = gmtModified;
	}
	
}

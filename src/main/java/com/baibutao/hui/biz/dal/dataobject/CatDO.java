/**
 * 
 */
package com.baibutao.hui.biz.dal.dataobject;

import java.io.Serializable;

import wint.mvc.form.fileupload.UploadFile;

/**
 * @author niepeng
 *
 * @date 2012-10-15 下午12:07:35
 */
public class CatDO extends BaseDO implements Serializable {

	private static final long serialVersionUID = -5006711506963490162L;

	private long id;
	
	private String name;
	
	private String pic;
	
	private String info;
	
	private int sortValue;
	
	// 扩展属性
	private UploadFile uploadFile;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSortValue() {
		return sortValue;
	}

	public void setSortValue(int sortValue) {
		this.sortValue = sortValue;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public UploadFile getUploadFile() {
		return uploadFile;
	}

	public void setUploadFile(UploadFile uploadFile) {
		this.uploadFile = uploadFile;
	}
	
}

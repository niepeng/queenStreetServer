package com.baibutao.hui.test.task;

import com.baibutao.hui.biz.task.DataTask;
import com.baibutao.hui.test.BaseHui;

public class TestDataTask extends BaseHui {

	private DataTask dataTask;

	public void testAuto() {
		dataTask.autoJobMethod();
	}
	
	
	public void setDataTask(DataTask dataTask) {
		this.dataTask = dataTask;
	}
	
}

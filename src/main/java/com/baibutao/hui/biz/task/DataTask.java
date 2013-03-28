/**
 * 
 */
package com.baibutao.hui.biz.task;

/**
 * @author niepeng
 *
 * @date 2012-10-12 下午2:33:30
 */
public interface DataTask {

	public void autoJobMethod();
	
	/**
	 * 定时任务扫描对于活动的处理
	 * 	1. 结束过期的活动
	 */
	public void scanOptItemMethod();
	
}

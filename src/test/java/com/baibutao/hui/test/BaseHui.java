/**
 * 
 */
package com.baibutao.hui.test;

import org.springframework.test.AbstractTransactionalDataSourceSpringContextTests;

/**
 * @author niepeng
 *
 * @date 2012-9-4 上午11:08:48
 */
public class BaseHui extends AbstractTransactionalDataSourceSpringContextTests {
	
	@Override
	protected String[] getConfigLocations() {
		return new String[] {"applicationContext.xml"};
	}

}

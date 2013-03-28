package com.baibutao.hui.test.util;

import java.io.File;

import junit.framework.TestCase;

import com.baibutao.hui.common.ImageUtil;

public class TestImageUtil extends TestCase {

	public void testGenImage() {
		File inputFile = new File("/Volumes/data/tmp/abc.jpg");
		String outputPicName = "/Volumes/data/tmp/smallpic3.jpg";
		double max = 60;
		ImageUtil.zoomPicture(inputFile, outputPicName, max);
	}
}

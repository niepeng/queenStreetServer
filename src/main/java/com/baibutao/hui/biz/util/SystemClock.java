package com.baibutao.hui.biz.util;

public class SystemClock {

	public static void sleep(long times) {
		try {
			Thread.sleep(times);
		} catch (Exception e) {
		}
	}
	
	public static void sleep(long start, long end) {
		try {
			if(start <= 0 || end <= 0) {
				return;
			}
			long times = (long) (Math.random() * (end - start));
			Thread.sleep(times);
		} catch (Exception e) {
		}
	}
}

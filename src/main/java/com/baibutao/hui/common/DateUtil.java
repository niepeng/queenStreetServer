/**
 * 
 */
package com.baibutao.hui.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author niepeng
 *
 * @date 2012-9-5 下午6:46:31
 */
public class DateUtil extends wint.lang.utils.DateUtil{
	
	public static final String DEFAULT_DATE_FMT = "yyyy-MM-dd HH:mm:ss";
	
	
	public static final String DATE_FMT_YMD = "yyyy年MM月dd日";
	
	
	public static final String DATE_FMT_MD_HM = "MM月dd日 HH:mm"; 
	
	public static final String DATE_FMT = "yyyy-MM-dd";
	
	
	public static Date parse(String input) {
		return parse(input, DEFAULT_DATE_FMT);
	}
	
	public static String format(Date date, String fmt) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(fmt);
			return sdf.format(date);
		} catch (Exception e) {
			return null;
		}
	}
	
	public static String format(Date date) {
		return format(date, DEFAULT_DATE_FMT);
	}
	
	public static String formatNoException(Date date) {
		try {
			return format(date);
		} catch (Exception e) {
			return null;
		}
	}
	
	public static Date parse(String input, String fmt) {
		SimpleDateFormat sdf = new SimpleDateFormat(fmt);
		try {
			return sdf.parse(input);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static Date formatCurrentDayMax(Date date) {
		if(date == null) {
			return null;
		}
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.HOUR_OF_DAY, 23);
		c.set(Calendar.MINUTE, 59);
		c.set(Calendar.SECOND, 59);
		return c.getTime();
	}
	
	/**
	 * 
	 * @param date
	 * @param changeValue  正数为增加，负数为减去
	 * @return
	 */
	public static Date changeDay(Date date , int changeValue) {
		if(date == null || changeValue == 0) {
			return date;
		}
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DAY_OF_YEAR, changeValue);
		return c.getTime();
	}
	
	/**
	 * 与当前时间的分钟数
	 */
	public static int getMin(Date date) {
		if(date == null) {
			return 0;
		}
		Date now = new Date();
		if(date.getTime() < now.getTime()) {
			return 0;
		}
		return (int)((date.getTime() -  now.getTime())/(1000.d * 60.d));
	}

}

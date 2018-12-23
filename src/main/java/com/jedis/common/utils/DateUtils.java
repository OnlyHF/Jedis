package com.jedis.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

	private static String pattern = "yyyyMMddhhmmss";
	
	private static String yyyyMMddpattern = "yyyy-MM-dd";
	
	private static String patternStr = "yyyy-MM-dd hh:mm:ss";
	
	/**
	 * 获取当前系统时间
	 * @return yyyy-MM-dd
	 */
	public static String getFormatDateStr() {
		Date date = new Date();
		return getFormatDateByPattern(date, yyyyMMddpattern);
	}
	
	/**
	 * 获取当前系统时间
	 * @return yyyy-MM-dd hh:mm:ss
	 */
	public static String getFormatDateString() {
		Date date = new Date();
		return getFormatDateByPattern(date, patternStr);
	}
	
	/**
	 * 获取当前系统时间
	 * @return yyyyMMddhhmmss
	 */
	public static String getFormatDate() {
		Date date = new Date();
		return getFormatDateByPattern(date, pattern);
	}
	
	/**
	 * 获取指定时间指定格式的系统时间
	 * @param pattern 指定时间格式
	 * @return
	 */
	public static String getFormatDateByPattern(Date date, String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		String dateString = sdf.format(date);
		return dateString;
	}
}

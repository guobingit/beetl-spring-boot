package com.gb.module.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DateUtils extends org.apache.commons.lang3.time.DateUtils {
	private static Logger logger = LoggerFactory.getLogger(DateUtils.class);
	
	/**
	 * 比较两个日期的大小,精确到秒 0表示相等 1表示fDate>oDate -1表示fDate<oDate
	 * 
	 * @param fDate
	 * @param oDate
	 * @return
	 */
	public static int comperDate(Date fDate, Date oDate) {
		try {
			String pattern = "yyyy-MM-dd HH:mm:ss";
			String f = DateFormatUtils.format(fDate, pattern);
			fDate = parseDate(f, new String[] { pattern });
			
			String o = DateFormatUtils.format(oDate, pattern);
			oDate = parseDate(o, new String[] { pattern });
			
		} catch (ParseException e) {
			logger.error("comperDate:", e);
		}
		
		return fDate.compareTo(oDate);
	}
	
	/**
	 * 两个日期相差的月数
	 * 
	 * @param sDate
	 * @param eDate
	 * @return
	 */
	public static int monthDiffer(String sDate, String eDate) {
		int differ = 0;
		try {
			int sy = 0, /* 开始年 */sm = 0, /* 开始月份 */ey = 0, /* 结束年份 */em = 0;/* 结束月份 */
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
			Date date = format.parse(sDate);
			Calendar sCalendar = Calendar.getInstance();
			sCalendar.setTime(date);
			sy = sCalendar.get(Calendar.YEAR);
			sm = sCalendar.get(Calendar.MONTH);
			
			date = format.parse(eDate);
			sCalendar.setTime(date);
			ey = sCalendar.get(Calendar.YEAR);
			em = sCalendar.get(Calendar.MONTH);
			
			differ = (ey - sy) * 12 + (em - sm);
		} catch (Exception e) {
		}
		return differ;
	}
	
	/**
	 * 在sDate日期的基础上加上addMonth个月，返回dateFormat格式的字符串形式
	 * 
	 * @param sDate
	 * @param addMonth
	 * @param dateFormat
	 * @return
	 */
	public static String addMonths(String sDate, int amount, String dateFormat) {
		try {
			SimpleDateFormat format = new SimpleDateFormat(dateFormat);
			Date date = format.parse(sDate);
			Calendar sCalendar = Calendar.getInstance();
			sCalendar.setTime(date);
			sCalendar.add(Calendar.MONTH, amount);
			date = sCalendar.getTime();
			return format.format(date);
		} catch (Exception e) {
			return "";
		}
	}
	
	/**
	 * 将字符串转换为日期
	 * 
	 * @param dateStr 字符串
	 * @param format 参数为日期格式 如：yyyy-MM-dd,
	 * @return
	 */
	public static Date strToDate(String dateStr, String format) {
		try {
			return parseDateStrictly(dateStr, new String[] { format });
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 两个日期的时间差
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static long differ(Date date1, Date date2) {
		return date1.getTime() - date2.getTime();
	}
	
	/**
	 * 计算时间差，精确到分
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static long differDate(Date fDate, Date oDate) {
		try {
			String pattern = "yyyy-MM-dd HH:mm";
			String f = DateFormatUtils.format(fDate, pattern);
			fDate = DateUtils.parseDate(f, new String[] { pattern });
			
			String o = DateFormatUtils.format(oDate, pattern);
			oDate = DateUtils.parseDate(o, new String[] { pattern });
			return fDate.getTime() - oDate.getTime();
		} catch (ParseException e) {
			logger.error("differDate()", e);
		}
		return 0;
	}
	
	/**
	 * 根据指定日期 获取日期相加天数的日期
	 * 
	 * @param date
	 * @param day
	 * @return
	 */
	public static Calendar addDay2Calendar(Date date, int day) {
		return toCalendar(addDays(date, day));
	}
	
	/**
	 * 根据日期获取上一天的日期
	 * 
	 * @param date
	 * @return
	 */
	public static Calendar getYesterdayCalendar(Date date) {
		return toCalendar(addDays(date, -1));
	}
	
	/**
	 * 获取指定日期
	 * 
	 * @param date
	 * @param days
	 * @return
	 */
	public static Calendar getAddDaysCalendar(Date date, int days) {
		return toCalendar(addDays(date, days));
	}
}

package com.techeffic.wechatPay.lib.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * 日期操作工具类
 * 
 * @author k42jc
 *
 */
public class CalendarUtil {
	/** 'msec'-毫秒 's'-秒 'm'-分 'H'-时 'd'-天 'M'-月 'y'-年 */
	public static final String TIME_UNIT_MSEC = "MSEC";
	public static final String TIME_UNIT_SECOND = "SECOND";
	public static final String TIME_UNIT_MINUTE = "MINUTE";
	public static final String TIME_UNIT_HOUR = "HOUR";
	public static final String TIME_UNIT_DAY = "DAY";
	public static final String TIME_UNIT_MONTH = "MONTH";
	public static final String TIME_UNIT_YEAR = "YEAR";

	/**
	 * 计算两日期时间差值 yyyy-MM-dd HH:mm:ss 格式
	 * 
	 * @param dateMax
	 *            较后日期
	 * @param dateMin
	 *            较前日期
	 * @return 时间差值 毫秒
	 */
	public static long dateTimeDValue(Date dateMax, Date dateMin) {
		return dateMax.getTime() - dateMin.getTime();
	}

	/**
	 * 字符串类型转换为日期
	 * 
	 * @param date
	 *            格式为yyyy-MM-dd HH:mm:ss
	 * @return 成功则返回日期 失败则返回null
	 */
	public static Date toDate(String date) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date resultDate = null;
		try {
			resultDate = format.parse(date);
		} catch (ParseException e) {
			return null;
		}
		return resultDate;
	}

	/**
	 * 毫秒转秒/分/时/天/月/年单位
	 * 
	 * @param unit
	 *            单位标识's'-秒 'm'-分 'H'-时 'd'-天 'M'-月 'y'-年
	 * @param msec
	 *            毫秒
	 * @return 转换后的单位值(转月/年以通用标准-30天/365天计算，不能保证精准)
	 *//*
	public static int convertUnit(String unit, long msec) {
		switch (unit) {
		case TIME_UNIT_SECOND:
			return (int) msec / 1000;
		case TIME_UNIT_MINUTE:
			return (int) msec / (1000 * 60);
		case TIME_UNIT_HOUR:
			return (int) msec / (1000 * 60 * 60);
		case TIME_UNIT_DAY:
			return (int) msec / (1000 * 60 * 60 * 24);
		case TIME_UNIT_MONTH:
			return (int) msec / (1000 * 60 * 60 * 24 * 30);
		case TIME_UNIT_YEAR:
			return (int) msec / (1000 * 60 * 60 * 24 * 365);
		default:
			return 0;
		}
	}*/

	/**
	 * 计算start日期+days天后的日期
	 * 
	 * @author xudong_liao
	 * @Time 2016年4月26日下午4:50:08
	 * @param start
	 * @param days
	 * @return
	 */
	public static Date addDate(Date start, int days) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(start);
		calendar.add(Calendar.DAY_OF_MONTH, days);
		return calendar.getTime();
	}

	/**
	 * 获取指定日期指定星期几的日期
	 * 
	 * @author xudong_liao
	 * @Time 2016年4月26日下午5:03:10
	 * @param date
	 *            指定日期
	 * @param firstDayOfWeek
	 *            指定一周开始的星期 如指定周一为一周开始 则firstDayOfWeek=Calendar.Monday
	 * @param week
	 *            Calendar常量 如需获取本周一的日期 week=Calendar.Monday
	 * @return
	 */
	public static Date getWeekDate(Date date, int firstDayOfWeek, int week) {
		Calendar calendar = Calendar.getInstance(Locale.CHINA);
		calendar.setTime(date);
		calendar.setFirstDayOfWeek(firstDayOfWeek);
		calendar.set(Calendar.DAY_OF_WEEK, week);
		return calendar.getTime();
	}

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = getWeekDate(new Date(), Calendar.MONDAY, Calendar.MONDAY);

		System.out.println(sdf.format(date));
		System.out.println(sdf.format(date));

		System.out.println(sdf.format(addDate(date, 6)));

	}
}

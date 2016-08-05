package com.techeffic.wechatPay.lib.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * 日期工具类
 * @author k42jc
 *
 */
public class DateUtil {

    /**
     * 日期格式转换我yyyy-MM-dd HH:mm:ss格式
     * @author xudong_liao
     * @Time 2016年4月27日上午10:21:36
     * @param currentTime
     * @return
     */
    public final static String toDateStr(Date currentTime) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return formatter.format(currentTime);
    }
    
    /**
     * 获取指定日期的零点 即00:00:00
     * @author xudong_liao
     * @Time 2016年4月26日下午6:13:44
     * @param date
     * @return
     */
    public static Date getZeroDate(Date date){
        long zero = date.getTime()/(1000*3600*24)*(1000*3600*24)-TimeZone.getDefault().getRawOffset();
        date.setTime(zero);
        return date;
    }

    /**
     * 获取指定日期的最后一个时间点 即23:59:59.999
     * @author xudong_liao
     * @Time 2016年4月26日下午6:19:33
     * @param date
     * @return
     */
    public static Date getEndDate(Date date){
        long twelve=getZeroDate(date).getTime()+24*60*60*1000-1;
        date.setTime(twelve);
        return date;
    }
    
	/**
	 * 字符串转换为日期
	 * @author xudong_liao
	 * @Time 2016年5月16日上午11:39:27
	 * @param dateStr yyyy-MM-dd格式日期
	 * @return
	 */
	public final static Date toDate(String dateStr){
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return formatter.parse(dateStr);
		} catch (ParseException e) {
			return null;
		}
	}
	
    public static void main(String[] args) {
        System.out.println(getZeroDate(new Date()));
        System.out.println(getEndDate(new Date()));
    }

}

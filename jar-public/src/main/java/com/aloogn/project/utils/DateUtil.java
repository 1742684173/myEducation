package com.aloogn.project.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	private static final Logger logger = LoggerFactory.getLogger(DateUtil.class);
	private static final String _dateFormat = "yyyy-MM-dd";
	public static String DateTimeformat1 = "yyyy-MM-dd HH:mm:ss";

	public static Date getNowTime() {
		return new Date();
	}

	/**
	 * 
	 * @Title: getNowTime @Description: 根据格式获取当前时间 @param formatStr @return
	 * String @throws
	 */
	public static String getNowTime(String formatStr) {
		if (StringUtils.isEmpty(formatStr)) {
			formatStr = _dateFormat;
		}
		Date date = getNowTime();
		return date2Str(date, formatStr);
	}
	/**
	 *  将当前日期转化为标准的yyyyMMddHHmmss
	 * */
	public static String getDateSDF() {
		Date date = new Date();
		DateFormat dateformat = new SimpleDateFormat("yyyyMMddHHmmss");
		return dateformat.format(date);
	}
	public static String getDateSDF(String formatStr) {
		if (StringUtils.isEmpty(formatStr)) {
			formatStr = DateTimeformat1;
		}
		Date date = new Date();
		DateFormat dateformat = new SimpleDateFormat(formatStr);
		return dateformat.format(date);
	}
	/**
	 *  将传入的String类型日期格式转化为标准的yyyyMMddHHmmss
	 * */
	public static String strToDateFormat(String date) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		formatter.setLenient(false);
		Date newDate = formatter.parse(date);
		formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		return formatter.format(newDate);
	}
	/**
	 *  将传入的String类型日期格式转化为常用的yyyy-MM-dd
	 * */
	public static String strToDateFormatCommon(String date) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		formatter.setLenient(false);
		Date newDate = formatter.parse(date);
		formatter = new SimpleDateFormat("yyyy-MM-dd");
		return formatter.format(newDate);
	}
	public static String strToDateFormatCommonNoEmpty(String date) throws ParseException {
		if(StringUtils.isEmpty(date)){
			return "";
		}
		date = date.trim();
		if(date.length() != 14){
			return "";
		}
 
		return strToDateFormatCommon(date);
	}
	public static String strToDateFormatCommon(String date, String formatStr) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		formatter.setLenient(false);
		Date newDate = formatter.parse(date);
		formatter = new SimpleDateFormat(formatStr);
		return formatter.format(newDate);
	}
	/**
	 * 
	 * @Title: strToDateFormat @Description: 根据传入格式格式化日期，如果不传入，默认
	 * yyyy-MM-dd @param date @param formatStr @return @throws ParseException
	 * String @throws
	 */
	public static String strToDateFormat(String date, String formatStr) throws ParseException {
		if (StringUtils.isEmpty(formatStr)) {
			formatStr = _dateFormat;
		}
		SimpleDateFormat formatter = new SimpleDateFormat(formatStr);
		formatter.setLenient(false);
		Date newDate = formatter.parse(date);
		return formatter.format(newDate);
	}

	/**
	 * 
	 * @Title: addDateByDateStrYear @Description: 增加相应年数 @param loopDate @param
	 * betweenYear @return String @throws
	 */
	public static String addDateByDateStrYear(String loopDate, String betweenYear, String format) {
		if (StringUtils.isEmpty(betweenYear)) {// 如果要增加的年数为空，则不进行增加
			return loopDate;
		}
		if (format == null || "".equals(format)) {
			format = _dateFormat;
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(str2Date(loopDate, format));
		calendar.add(Calendar.YEAR, Integer.valueOf(betweenYear));
		return date2Str(calendar.getTime(), format);
	}
	/**
	 * 
	 * @Title: addDateByDateStrDay @Description: 增加相应天数 @param loopDate @param
	 * betweenYear @return String @throws
	 */
	public static String addDateByDateStrDay(String loopDate, String day, String format) {
		if (StringUtils.isEmpty(day)) {// 如果要增加的天数为空，则不进行增加
			return loopDate;
		}
		if (format == null || "".equals(format)) {
			format = _dateFormat;
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(str2Date(loopDate, format));
		calendar.add(Calendar.DAY_OF_MONTH, Integer.valueOf(day));
		return date2Str(calendar.getTime(), format);
	}

	public static String date2Str(Date date, String format) {
		if (format == null || "".equals(format))
			format = _dateFormat;
		if (date == null)
			date = getNowTime();
		DateFormat dateformat = new SimpleDateFormat(format);
		return dateformat.format(date);
	}

	public static Date str2Date(String dateStr, String formatStr) {
		if (formatStr == null || "".equals(formatStr))
			formatStr = _dateFormat;
		if (dateStr == null || "".equals(dateStr))
			dateStr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		DateFormat dateformat = new SimpleDateFormat(formatStr);
		Date date = null;
		try {
			date = dateformat.parse(dateStr);
		} catch (ParseException e) {
			logger.error(e.getMessage(), e);
			System.out.println("!!!!!!!!input \"" + dateStr + "\" is worry! ");
		}
		return date;
	}

	/**
	 * 计算两个日期之间相差的天数
	 * 
	 * @param sStartdate
	 * @param bEnddate
	 * @param dateFormat
	 *            如果比较差值为天，输入yyyy-MM-dd； 如果比较差值其他，请输入正确的值
	 * @return
	 * @throws ParseException
	 */
	public static double daysBetween(Date startdate, Date enddate) throws ParseException {
		long time2 = enddate.getTime();
		long time1 = startdate.getTime();
		long diff = time2 - time1;
		return Double.parseDouble(
				(diff / (1000 * 60 * 60 * 24)) + "." + ((diff % (1000 * 60 * 60 * 24)) / (24 * 60 * 60 * 10)));
	}

	public static double daysBetween(String startdate, String enddate, String dateFormat) throws ParseException {
		return daysBetween(str2Date(startdate, dateFormat), str2Date(enddate, dateFormat));
	}

	public static String nextDayDate(String loopDate, int addOsubNum) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(str2Date(loopDate, null));
		calendar.add(Calendar.DAY_OF_YEAR, addOsubNum);
		return date2Str(calendar.getTime(), null);
	}

	public static Date converDate(String inValue) throws Exception {
		if (inValue == null)
			return null;
		String value = inValue.replaceAll("：", ":");
		if ((value != null) && (value.length() == 28) && (value.indexOf("CST") == 20)) {
			String year = value.substring(24, 28);
			String date = value.substring(8, 10);
			String temp = value.substring(4, 7);
			if (temp.equals("Jan"))
				value = year + "-" + "01" + "-" + date;
			if (temp.equals("Feb"))
				value = year + "-" + "02" + "-" + date;
			if (temp.equals("Mar"))
				value = year + "-" + "03" + "-" + date;
			if (temp.equals("Apr"))
				value = year + "-" + "04" + "-" + date;
			if (temp.equals("May"))
				value = year + "-" + "05" + "-" + date;
			if (temp.equals("Jun"))
				value = year + "-" + "06" + "-" + date;
			if (temp.equals("Jul"))
				value = year + "-" + "07" + "-" + date;
			if (temp.equals("Aug"))
				value = year + "-" + "08" + "-" + date;
			if (temp.equals("Sep"))
				value = year + "-" + "09" + "-" + date;
			if (temp.equals("Oct"))
				value = year + "-" + "10" + "-" + date;
			if (temp.equals("Nov"))
				value = year + "-" + "11" + "-" + date;
			if (temp.equals("Dec"))
				value = year + "-" + "12" + "-" + date;
		}
		if ((value.indexOf("年") > 0) && (value.indexOf("月") > 0) && (value.indexOf("日") > 0) && (value.indexOf("时") > 0)
				&& (value.indexOf("分") > 0) && (value.indexOf("秒") > 0) && (value.indexOf("毫秒") > 0))
			return str2Date(value, "yyyy年MM月dd日 HH时mm分ss秒SSS毫秒");
		if ((value.indexOf("年") > 0) && (value.indexOf("月") > 0) && (value.indexOf("日") > 0) && (value.indexOf("时") > 0)
				&& (value.indexOf("分") > 0) && (value.indexOf("秒") > 0))
			return str2Date(value, "yyyy年MM月dd日 HH时mm分ss秒");
		if ((value.indexOf("/") > 0) && (value.trim().length() == 10))
			return str2Date(value, "yyyy/MM/dd");
		if ((value.indexOf("-") > 0) && (value.trim().length() == 19))
			return str2Date(value, "yyyy-MM-dd HH:mm:ss");
		if ((value.indexOf("-") > 0) && (value.trim().length() == 23))
			return str2Date(value, "yyyy-MM-dd HH:mm:ss.SSS");
		if ((value.indexOf("-") > 0) && (value.trim().length() == 10))
			return str2Date(value, "yyyy-MM-dd");
		if ((value.indexOf(":") > 0) && (value.trim().length() == 8))
			return str2Date(value, "HH:mm:ss");
		if ((value.indexOf(":") > 0) && (value.trim().length() == 12))
			return str2Date(value, "HH:mm:ss.SSS");
		if (value.trim().length() == 14)
			return str2Date(value, "yyyyMMddHHmmss");
		if (value.trim().length() == 17)
			return str2Date(value, "yyyyMMddHHmmssSSS");
		if ((value.indexOf(" ") > 0) && (value.trim().length() == 15))
			return str2Date(value, "yyyyMMdd HHmmss");
		if ((value.indexOf(" ") > 0) && (value.trim().length() == 18))
			return str2Date(value, "yyyyMMdd HHmmssSSS");
		if (value.trim().length() == 8)
			return str2Date(value, "yyyyMMdd");
		if (value.trim().length() == 6)
			return str2Date(value, "HHmmss");
		if (value.trim().length() == 9)
			return str2Date(value, "HHmmssSSS");
		return null;
	}

	/**
	 * @Description: 比较两个时间的分数差
	 * @param sStartdate
	 * @param bEnddate
	 * @param dateFormat
	 * @return
	 * @throws ParseException
	 * @author: zhangzhiguang
	 * @date: 2016-9-5 下午6:05:26
	 */
	public static long compareTime(String sStartdates, String bEnddates, String dateFormat) throws ParseException {
		Date sStartdate = str2Date(sStartdates, dateFormat);
		Date bEnddate = str2Date(bEnddates, dateFormat);
		if (dateFormat == null || "".equals(dateFormat))
			dateFormat = _dateFormat;
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		sStartdate = sdf.parse(sdf.format(sStartdate));
		bEnddate = sdf.parse(sdf.format(bEnddate));
		Calendar cal = Calendar.getInstance();
		cal.setTime(sStartdate);
		long time1 = cal.getTimeInMillis();
		cal.setTime(bEnddate);
		long time2 = cal.getTimeInMillis();
		Long between_days = (time2 - time1) / (1000);
		return between_days;
	}

	public static void main(String[] args) throws ParseException {

		String _sys_time = "20160905180710";
		String signDateShow = strToDateFormatCommon(_sys_time,"yyyy年MM月dd日");
		System.out.println("=============="+signDateShow);
	}
	
	/**
	 * 获取当前系统时间形成：年-月-日 时分秒格式
	 */
	public static String getCurrentTime2() {
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateNowStr = sdf.format(d);
		return dateNowStr;
	}
}

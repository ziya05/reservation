package com.ziya05.reservation.backend.utils;

import static org.mockito.Mockito.RETURNS_DEEP_STUBS;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.ziya05.reservation.backend.bo.DayDetail;

public class ProjectUtils {
	
	public static String getSimpleDate() {
		return getSimpleDate(getToday());
	}
	
	public static String getSimpleDate(Date date) {
		return getSimpleDate(date, "yyyy-MM-dd");
	}
	
	public static String getSimpleDate(Date date, String formatText) {
		SimpleDateFormat format = new SimpleDateFormat(formatText);
		
		return format.format(date);
	}
	
	public static String getSimpleTime() {
		return getSimpleTime(getToday());
	}
	
	public static String getSimpleTime(Date date) {
		SimpleDateFormat format = new SimpleDateFormat("HH:mm");
		
		return format.format(date);
	}
	
	public static String getLaterSimpleDate(int dayCount) {

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
		return format.format(getLaterDate(dayCount));
	}
	
	public static Date getToday() {
		Calendar calendar = Calendar.getInstance();
		return calendar.getTime();
	}
	
	public static Date getDate(String dateString) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return format.parse(dateString);
	}
	
	public static Date getLaterDate(int dayCount) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_YEAR, dayCount);
		
		return calendar.getTime();
	}
	
	public static Date getLaterDate(Date date, int dayCount) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_YEAR, dayCount);
		
		return calendar.getTime();
	}
	
	public static Boolean dateEquals(Date date1, Date date2) {
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");

		return format.format(date1).equals(format.format(date2));
	}
	
	public static List<DayDetail> getDayDetailList(Date beginDate, Date endDate) throws ParseException {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(beginDate);
		
		int dayOfWeek = getDayOfWeek(calendar);
		if (dayOfWeek != 1) {
			calendar.add(Calendar.DAY_OF_YEAR, (dayOfWeek - 1)  * -1); 
		}
		
		List<DayDetail> lst = new ArrayList<DayDetail>();
		
		Date currentDate = calendar.getTime();
		while(currentDate.before(beginDate)) {
			DayDetail detail = getDayDetail(calendar, 0); 
			lst.add(detail);
			
			calendar.add(Calendar.DAY_OF_YEAR, 1);
			currentDate = calendar.getTime();
		}
		
		while(currentDate.before(endDate)) {
			DayDetail detail = getDayDetail(calendar, 1);
			lst.add(detail);
			
			calendar.add(Calendar.DAY_OF_YEAR, 1);
			currentDate = calendar.getTime();
		}
		
		dayOfWeek = getDayOfWeek(calendar);
		if (dayOfWeek != 7) {
			endDate = getLaterDate(endDate, 7 - dayOfWeek + 1);
			
			while (currentDate.before(endDate)) {
				DayDetail detail = getDayDetail(calendar, 2);
				lst.add(detail);
				
				calendar.add(Calendar.DAY_OF_YEAR, 1);
				currentDate = calendar.getTime();
			}
		}
		
		return lst;
	}
	
	public static DayDetail getDayDetail(Calendar calendar, int status) throws ParseException {
		
		DayDetail detail = new DayDetail();
		detail.setDate(calendar.getTime());
		detail.setYear(calendar.get(Calendar.YEAR));
		detail.setMonth(calendar.get(Calendar.MONTH) + 1);
		detail.setDay(calendar.get(Calendar.DAY_OF_MONTH));
		
		int weekOfYear = getWeekOfYear(calendar);
		int dayOfWeek = getDayOfWeek(calendar);

		detail.setWeekOfYear(weekOfYear);
		detail.setDayOfWeek(dayOfWeek);
		
		detail.setStatus(status); 
		
		return detail;
	}
	
	public static int getWeekOfYear(Calendar calendar) throws ParseException {
		if (calendar.getFirstDayOfWeek() == Calendar.SUNDAY) {
			calendar.setFirstDayOfWeek(Calendar.MONDAY);
		}
		
		return calendar.get(Calendar.WEEK_OF_YEAR);
	}
	
	public static int getDayOfWeek(Calendar calendar) {
		if (calendar.getFirstDayOfWeek() == Calendar.SUNDAY) {
			calendar.setFirstDayOfWeek(Calendar.MONDAY);
		}
		
		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
		if (dayOfWeek == Calendar.SUNDAY) {
			dayOfWeek = 7;
		} else {
			dayOfWeek--;
		}
		
		return dayOfWeek;
	}
	
	public static <T1, T2> void copyList(List<T1> sourceLst, 
			List<T2> targetLst,
			Class<T2> t2Class) 
			throws InstantiationException, IllegalAccessException {
		
		for(T1 source : sourceLst) {
			T2 t2 = t2Class.newInstance();
			BeanUtils.copyProperties(source, t2);
			targetLst.add(t2);
		}
	}
	
	public static void main(String[] args) throws ParseException {
		print("2017-12-15", "2018-01-20");
		print("2018-12-15", "2019-01-20");
		print("2019-12-15", "2020-01-20");
		print("2020-12-15", "2021-01-20");
	}
	
	private static void print(String beginDateString, String endDateString) throws ParseException {
		Date beginDate = getDate(beginDateString);
		Date endDate = getDate(endDateString);
		
		List<DayDetail> lst = getDayDetailList(beginDate, endDate);
		int lastWeek = -1;
		for(DayDetail detail : lst) {
			int year = detail.getYear();
			int week = detail.getWeekOfYear();
			if (week != lastWeek) {
				System.out.println();
				System.out.print(String.format("%s -- %s ---> ", year, week));
				lastWeek = week;

			}
			
			System.out.print(String.format("(%02d-%02d)-[%d]-%d  ", 
					detail.getMonth(),
					detail.getDay(),
					detail.getDayOfWeek(),
					detail.getStatus()));
		}
		
		System.out.println();
		System.out.println();
		System.out.println();
	}
}

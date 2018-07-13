package com.ziya05.reservation.backend.vo;

import java.util.List;

public class SimpleInformation {
	
	private int weekOfYear;
	
	private List<DayInformation> items;
	
	public int getWeekOfYear() {
		return weekOfYear;
	}

	public void setWeekOfYear(int weekOfYear) {
		this.weekOfYear = weekOfYear;
	}

	public List<DayInformation> getItems() {
		return items;
	}

	public void setItems(List<DayInformation> items) {
		this.items = items;
	}

	public class DayInformation {
		
		private int dayOfWeek;
		
		private int day;
		
		/**
		 * 状态， 0: 过期， 1: 可约, 2: 未开放, 3: 约满
		 */
		private int status;
		
		private List<DurationInformation> items;
		
		public int getDayOfWeek() {
			return dayOfWeek;
		}

		public void setDayOfWeek(int dayOfWeek) {
			this.dayOfWeek = dayOfWeek;
		}

		public int getDay() {
			return day;
		}

		public void setDay(int day) {
			this.day = day;
		}

		public int getStatus() {
			return status;
		}

		public void setStatus(int status) {
			this.status = status;
		}

		public List<DurationInformation> getItems() {
			return items;
		}

		public void setItems(List<DurationInformation> items) {
			this.items = items;
		}

	}
	
	public class DurationInformation implements Comparable<DurationInformation> {
		
		private String id;
		
		private String beginTime;
		
		private String endTime;

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getBeginTime() {
			return beginTime;
		}

		public void setBeginTime(String beginTime) {
			this.beginTime = beginTime;
		}

		public String getEndTime() {
			return endTime;
		}

		public void setEndTime(String endTime) {
			this.endTime = endTime;
		}

		@Override
		public int compareTo(DurationInformation target) {

			return this.beginTime.compareTo(target.beginTime);
		}
		
	}
}

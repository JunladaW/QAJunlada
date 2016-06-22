package com.rabbitbase.generic;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DatePic {

	public static void main(String[] args) throws ParseException {
		// getDate();
		// getYesterdayDateString();
		System.out.println(addDays(90, "yyyy-MM-dd"));
	}

	public static void selectDate() {

	}

	public static void getDateYear() throws ParseException {

		String date2 = "1987-06-09";
		String date1 = "1995-02-09";

		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date comDate1 = dateFormat.parse(date1);
		Date comDate2 = dateFormat.parse(date2);

		if (comDate1.after(comDate2)) {
			System.out.println("Driver's Youngest Age : " + date1);
		} else {
			System.out.println("Driver's Youngest Age : " + date2);
		}

	}

	public static void getDate() throws ParseException {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -1);
		System.out.println("Yesterday's date = " + cal.getTime());
	}

	public static void getYesterdayDateString() {
		DateFormat dateFormat = new SimpleDateFormat("dd");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -1);
		System.out.println(dateFormat.format(cal.getTime()));
	}

	public static String addDays(int addDays, String dateFormat) {

		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, addDays);
		Date getDays = cal.getTime();
		return getCurrentDate(getDays, dateFormat);

	}

	public static String getCurrentDate(Date getDays, String formatDate) {

		SimpleDateFormat dateFormat = new SimpleDateFormat(formatDate);
		String date = dateFormat.format(getDays);
		return date;
	}

}

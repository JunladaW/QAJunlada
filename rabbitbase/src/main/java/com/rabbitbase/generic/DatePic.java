package com.rabbitbase.generic;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DatePic {

	public static void main(String[] args) throws ParseException {
		getDateYear();
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
}

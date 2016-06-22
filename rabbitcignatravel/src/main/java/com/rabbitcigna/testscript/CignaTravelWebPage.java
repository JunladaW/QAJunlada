package com.rabbitcigna.testscript;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.By;

import com.automation.framework.applib.FunctionsApplib;
import com.automation.framework.beans.TestWareBean;
import com.automation.framework.exception.BusinessException;
import com.automation.framework.util.GenericUtil;
import com.automation.framework.util.Test;
import com.rabbitbase.excelcolumns.XL_GenericSheets;
import com.rabbitbase.generic.Generic_NANA;
import com.rabbitcigna.excelcolumns.XL_CignaTravelWebPage;
import com.rabbitcigna.excelcolumns.XL_WriteToExcel;
import com.rabbitcigna.objectrepository.OR_CignaTravelWebPage;

public class CignaTravelWebPage extends FunctionsApplib {

	private Generic_NANA genericNANA;
	String generatePhoneNumber;
	String getPhoneNumber;
	String dateStartTravel;
	String dateEndTravel;

	public CignaTravelWebPage(TestWareBean testWareBean, Test test) throws BusinessException {
		super(testWareBean, test);
		genericNANA = Generic_NANA.getInstance(testWareBean, test);
	}

	@Override
	protected String getSheetName() {
		return XL_GenericSheets.SHEET_CIGNA_TRAVEL_WEBPAGE;
	}

	public void cignaTravelWeb() throws BusinessException, InterruptedException {

		landingPageSaveNow();
		yourTrip();
		secTravelers();
		Thread.sleep(10000);
		cignaWebPageValidations();
	}

	private void landingPageSaveNow() throws BusinessException, InterruptedException {

		String getSaveOption = test.getData(XL_CignaTravelWebPage.SAVE_NOW);
		if (getSaveOption.equalsIgnoreCase("SaveNow")) {
			test.script(CLICK_BUTTON, OR_CignaTravelWebPage.BTN_SAVE_NOW, "");
		} else if (getSaveOption.equalsIgnoreCase("SelectTravel")) {
			test.script(CLICK_BUTTON, OR_CignaTravelWebPage.BTN_SELECT_TRAVEL, "");
		} else if (getSaveOption.equalsIgnoreCase("SaveNowCenter")) {
			test.script(CLICK_BUTTON, OR_CignaTravelWebPage.BTN_SAVE_NOW_CENTER, "");
		} else if (getSaveOption.equalsIgnoreCase("SelectTravelCenter")) {
			test.script(CLICK_BUTTON, OR_CignaTravelWebPage.BTN_SELECT_TRAVEL_CENTER, "");
		} else if (getSaveOption.equalsIgnoreCase("SaveNowBottom")) {
			test.script(CLICK_BUTTON, OR_CignaTravelWebPage.BTN_SAVE_NOW_BOTTOM, "");
		} else {
			test.script(CLICK_BUTTON, OR_CignaTravelWebPage.BTN_SELECT_TRAVEL_BOTTOM, "");
		}
	}

	private void yourTrip() throws BusinessException, InterruptedException {

		int getDestinationCount = test.getCount(OR_CignaTravelWebPage.TOTAL_TRAVEL_DESTINATION);
		test.reportMessage("Total Destination Countries are " + getDestinationCount, false);

		for (int destination = 1; destination <= getDestinationCount; destination++) {
			String getCountryName = testWareBean.getWebDriver()
					.findElement(By.xpath("//*[@name='country_id']//option[" + destination + "]")).getText().trim();
			if (getCountryName.equalsIgnoreCase("Thailand")) {
				test.reportMessage("Thailand found in Countries List", true);
			}
		}
		test.reportMessage("Thailand not found in Countries List", false);

		test.script(SELECT_LIST, OR_CignaTravelWebPage.WLS_TRAVEL_DESTINATION,
				XL_CignaTravelWebPage.TRAVEL_DESTIONATION);
		dateValidationFrom();
		String getTravelDuration = test.getData(XL_CignaTravelWebPage.TRAVEL_DURATION);
		if (getTravelDuration.equalsIgnoreCase("SameDay")) {
			dateToSameasFrom();
		} else {
			dateTo90Days();
		}
		test.script(CLICK_BUTTON, OR_CignaTravelWebPage.BTN_NEXT_YOUR_TRIP, "");

		genericNANA.writeToExcel(XL_GenericSheets.SHEET_WRITE_TO_EXCEL, XL_WriteToExcel.START_DATE, dateStartTravel);
		genericNANA.writeToExcel(XL_GenericSheets.SHEET_WRITE_TO_EXCEL, XL_WriteToExcel.END_DATE, dateEndTravel);

	}

	private void secTravelers() throws BusinessException, InterruptedException {

		int getTotalNoOfPeople = test.getCount(OR_CignaTravelWebPage.TOTAL_NO_OF_PEOPLE);
		test.reportMessage("Total No. Of People : " + (getTotalNoOfPeople - 1), false);

		test.script(SELECT_LIST, OR_CignaTravelWebPage.WLS_NO_OF_PEOPLE, XL_CignaTravelWebPage.NO_OF_PEOPLE);

		generatePhoneNumber = "080" + GenericUtil.getRandomNumber();
		genericNANA.writeToExcel(XL_GenericSheets.SHEET_WRITE_TO_EXCEL, XL_WriteToExcel.LEADS_PHONE,
				generatePhoneNumber);
		test.script(TYPE, OR_CignaTravelWebPage.TXT_CONTACT_INFO, XL_WriteToExcel.LEADS_PHONE);
		test.script(CLICK_BUTTON, OR_CignaTravelWebPage.BTN_PROCEED_TRAVEL, "");
	}

	private void cignaWebPageValidations() throws BusinessException, InterruptedException {

		String actualCignaDestination = test.getTextFromElement(OR_CignaTravelWebPage.LBL_CIGNA_DESTINATION);
		String expectedDestination = test.getData(XL_CignaTravelWebPage.TRAVEL_DESTIONATION);

		test.comparisonResult(expectedDestination, actualCignaDestination, "Cigna Page - Destination");

		String[] getStartMonth = dateStartTravel.split("-");
		String startMonth = getStartMonth[1];
		String thaiStartMonth = monthInThai(startMonth);
		String expectedTravelStartDate = getStartMonth[2] + " " + thaiStartMonth + " " + getStartMonth[0];
		String actualTravelStartDate = test.getTextFromElement(OR_CignaTravelWebPage.LBL_TRAVEL_START_DATE);

		test.comparisonResult(expectedTravelStartDate, actualTravelStartDate, "Cigna - Travel Start Date");

		String[] getEndMonth = dateEndTravel.split("-");
		String endMonth = getEndMonth[1];
		String thaiEndMonth = monthInThai(endMonth);
		String expectedTravelEndDate = getEndMonth[2] + " " + thaiEndMonth + " " + getEndMonth[0];
		String actualTravelEndDate = test.getTextFromElement(OR_CignaTravelWebPage.LBL_TRAVEL_END_DATE);

		test.comparisonResult(expectedTravelEndDate, actualTravelEndDate, "Cigna - Travel End Date");
	}

	private void dateValidationFrom() throws BusinessException, InterruptedException {
		test.script(CLICK_BUTTON, OR_CignaTravelWebPage.TXT_TRAVEL_DURATION_FROM, "");
		test.script(WAIT_FOR_INVISIBLE, OR_CignaTravelWebPage.BTN_PREV_MONTH, "");
		test.isExists(OR_CignaTravelWebPage.BTN_NEXT_MONTH);

		String yesterdayDate = getDate(-1);
		String[] validateYesterDay = test.replaceXpath(OR_CignaTravelWebPage.LBL_PREV_DATE, yesterdayDate);
		test.isExists(validateYesterDay);

		String dateTomorrow = getDate(1);
		String[] getCurrentDate = test.replaceXpath(OR_CignaTravelWebPage.BTN_DATE_SELECTION, dateTomorrow);
		test.script(CLICK_BUTTON, getCurrentDate, "");
		String getSelectedDate = test.getTextFromElement(OR_CignaTravelWebPage.TXT_TRAVEL_DURATION_FROM);
		test.reportMessage("From Date : " + getSelectedDate, false);
		dateStartTravel = getSelectedDate;
	}

	private void dateToSameasFrom() throws BusinessException, InterruptedException {
		test.script(CLICK_BUTTON, OR_CignaTravelWebPage.TXT_TRAVEL_DURATION_TO, "");
		test.script(WAIT_FOR_INVISIBLE, OR_CignaTravelWebPage.BTN_PREV_MONTH, "");
		test.isExists(OR_CignaTravelWebPage.BTN_NEXT_MONTH);

		String yesterdayDate = getDate(-1);
		String[] validateYesterDay = test.replaceXpath(OR_CignaTravelWebPage.LBL_PREV_DATE, yesterdayDate);
		test.isExists(validateYesterDay);

		String currentDate = getDate(1);
		String[] getCurrentDate = test.replaceXpath(OR_CignaTravelWebPage.BTN_DATE_SELECTION, currentDate);
		test.script(CLICK_BUTTON, getCurrentDate, "");
		String getSelectedDate = test.getTextFromElement(OR_CignaTravelWebPage.TXT_TRAVEL_DURATION_TO);
		test.reportMessage("To Date : " + getSelectedDate, false);
		dateEndTravel = getSelectedDate;
	}

	private void dateTo90Days() throws BusinessException, InterruptedException {

		test.script(CLICK_BUTTON, OR_CignaTravelWebPage.TXT_TRAVEL_DURATION_TO, "");
		test.script(WAIT_FOR_INVISIBLE, OR_CignaTravelWebPage.BTN_PREV_MONTH, "");
		test.isExists(OR_CignaTravelWebPage.BTN_NEXT_MONTH);
		String get90DaysAfter = test.addDays(90, "yyyy-MM-dd");
		String[] splitMonth = get90DaysAfter.split("-");
		String expecteMonthYear = getMonth(splitMonth[1]) + " " + splitMonth[0];
		String[] repalceMonthYearText = { "//html/body/div[4]/div[1]/table/thead/tr[2]" };
		String getMonthYear = test.getTextFromElement(repalceMonthYearText);

		while (!expecteMonthYear.contains(getMonthYear)) {
			getMonthYear = test.getTextFromElement(repalceMonthYearText);
			if (("« " + expecteMonthYear).contains(getMonthYear)
					|| ("« " + expecteMonthYear + " »").contains(getMonthYear)) {
				String[] selectDate = test.replaceXpath(OR_CignaTravelWebPage.BTN_DATE_SELECTION, splitMonth[2]);
				test.script(CLICK_BUTTON, selectDate, "");
				String getSelectedDate = test.getTextFromElement(OR_CignaTravelWebPage.TXT_TRAVEL_DURATION_TO);
				test.reportMessage("To Date : " + getSelectedDate, false);
				dateEndTravel = getSelectedDate;
				break;
			}
			test.script(CLICK_BUTTON, OR_CignaTravelWebPage.BTN_NEXT_MONTH, "");
			test.reportMessage("Month / Year : " + getMonthYear, false);
		}

	}

	private String getDate(int value) {
		DateFormat dateFormat = new SimpleDateFormat("dd");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, value);
		return dateFormat.format(cal.getTime());
	}

	private String monthInThai(String month) throws BusinessException {
		String thaiMonth = "";
		switch (month) {
		case "01":
			thaiMonth = "ม.ค";
			break;
		case "02":
			thaiMonth = "ก.พ";
			break;
		case "03":
			thaiMonth = "มี.ค";
			break;
		case "04":
			thaiMonth = "เม.ย";
			break;
		case "05":
			thaiMonth = "พ.ค";
			break;
		case "06":
			thaiMonth = "มิ.ย";
			break;
		case "07":
			thaiMonth = "ก.ค";
			break;
		case "08":
			thaiMonth = "ส.ค";
			break;
		case "09":
			thaiMonth = "ก.ย.";
			break;
		case "10":
			thaiMonth = "ต.ค";
			break;
		case "11":
			thaiMonth = "พ.ย";
			break;
		case "12":
			thaiMonth = "ธ.ค";
			break;
		default:
			test.reportMessage("Month doesn't match in Thai Language", true);
		}
		return thaiMonth;
	}

	private String getMonth(String strMonth) throws BusinessException {
		String month = "";
		switch (strMonth) {
		case "01":
			month = "January";
			break;
		case "02":
			month = "Feburary";
			break;
		case "03":
			month = "March";
			break;
		case "04":
			month = "April";
			break;
		case "05":
			month = "May";
			break;
		case "06":
			month = "June";
			break;
		case "07":
			month = "July";
			break;
		case "08":
			month = "August";
			break;
		case "09":
			month = "September";
			break;
		case "10":
			month = "October";
			break;
		case "11":
			month = "November";
			break;
		case "12":
			month = "December";
			break;
		default:
			test.reportMessage("Month doesn't match", true);
		}
		return month;
	}

}

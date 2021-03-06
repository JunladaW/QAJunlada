package com.rabbitcigna.testscript;

import com.automation.framework.applib.FunctionsApplib;
import com.automation.framework.beans.TestWareBean;
import com.automation.framework.exception.BusinessException;
import com.automation.framework.util.Test;
import com.rabbitbase.excelcolumns.XL_GenericSheets;
import com.rabbitbase.objectrepository.OR_GenericNANA;
import com.rabbitcigna.excelcolumns.XL_CignaTravelNANA;
import com.rabbitcigna.excelcolumns.XL_CignaTravelWebPage;
import com.rabbitcigna.excelcolumns.XL_WriteToExcel;
import com.rabbitcigna.objectrepository.OR_CignaTravelNANA;

public class CignaTravelNana extends FunctionsApplib {

	public CignaTravelNana(TestWareBean testWareBean, Test test) throws BusinessException {
		super(testWareBean, test);
	}

	@Override
	protected String getSheetName() {
		return XL_GenericSheets.SHEET_CIGNA_TRAVEL_WEBPAGE;
	}

	public void cignaTravelNANA() throws BusinessException, InterruptedException {
		menuSelection();
		validateLeadData();
	}

	public void loginNANA() throws BusinessException, InterruptedException {
		testWareBean.setExecuteURL("http://staging-nana.rabbit.co.th");
		testWareBean.getWebDriver().get(testWareBean.getExecuteURL());
		test.setSheetName(XL_GenericSheets.SHEET_NANA_LOGIN);
		test.script(TYPE, OR_GenericNANA.WED_LOGIN_GMAIL_NANA_EMAIL, XL_GenericSheets.EMAIL, false, 20);
		test.script(CLICK_BUTTON, OR_GenericNANA.BTN_NEXT, "");
		test.script(TYPE, OR_GenericNANA.WED_LOGIN_GMAIL_NANA_PASSWORD, XL_GenericSheets.PASSWORD, false, 20);
		test.script(CLICK_BUTTON, OR_GenericNANA.BTN_SIGNIN, "");
		testWareBean.getWebDriver().get(testWareBean.getExecuteURL());
	}

	private void menuSelection() throws BusinessException, InterruptedException {
		test.script(CLICK_BUTTON, OR_CignaTravelNANA.BTN_LANGUAGE, "", false, 20);
		test.script(CLICK_BUTTON, OR_CignaTravelNANA.BTN_TRAVEL_INSURANCE, "");
		test.script(CLICK_BUTTON, OR_CignaTravelNANA.BTN_TRAVEL_LEADS, "");
	}

	private void validateLeadData() throws BusinessException, InterruptedException {
		test.setSheetName(XL_GenericSheets.SHEET_CIGNA_TRAVEL_WEBPAGE);
		String expectedPhoneNumber = test.getData(2, XL_GenericSheets.SHEET_WRITE_TO_EXCEL,
				XL_WriteToExcel.LEADS_PHONE);
		String expectedCountry = test.getData(XL_CignaTravelWebPage.TRAVEL_DESTIONATION);
		String expectedStartDate = test.getData(2, XL_GenericSheets.SHEET_WRITE_TO_EXCEL, XL_WriteToExcel.START_DATE);
		String expectedEndDate = test.getData(2, XL_GenericSheets.SHEET_WRITE_TO_EXCEL, XL_WriteToExcel.END_DATE);
		String expectedNoOfPersons = test.getData(XL_CignaTravelWebPage.NO_OF_PEOPLE);

		int totalPhoneNumbers = test.getCount(OR_CignaTravelNANA.TOTAL_MOBILE_LIST);

		for (int phone = 2; phone <= totalPhoneNumbers; phone++) {

			String[] replacePhoneNumber = test.replaceXpath(OR_CignaTravelNANA.LBL_MOBILE_NUMBER, phone);
			String actualPhoneNumber = test.getTextFromElement(replacePhoneNumber);

			if (expectedPhoneNumber.equals(actualPhoneNumber)) {

				test.comparisonResult(expectedPhoneNumber, actualPhoneNumber, "Phone Number");

				String[] replaceCountry = test.replaceXpath(OR_CignaTravelNANA.LBL_COUNTRY, phone);
				String actualCountry = test.getTextFromElement(replaceCountry);
				test.comparisonResult(expectedCountry, actualCountry, "Travelling Country");

				String[] replaceStartDate = test.replaceXpath(OR_CignaTravelNANA.LBL_START_DATE, phone);
				String[] splitStartDate = test.getTextFromElement(replaceStartDate).split(" ");
				String actualStartDate = splitStartDate[0];
				test.comparisonResult(expectedStartDate, actualStartDate, "Travel Start Date");

				String[] replaceEndDate = test.replaceXpath(OR_CignaTravelNANA.LBL_END_DATE, phone);
				String[] splitEndDate = test.getTextFromElement(replaceEndDate).split(" ");
				String actualEndDate = splitEndDate[0];
				test.comparisonResult(expectedEndDate, actualEndDate, "Travel End Date");

				String[] replaceNoOfPersons = test.replaceXpath(OR_CignaTravelNANA.LBL_NO_OF_PERSON, phone);
				String actualNoOfPersons = test.getTextFromElement(replaceNoOfPersons);
				test.comparisonResult(expectedNoOfPersons, actualNoOfPersons, "No. Of Persons");

				String[] replaceCreatedDate = test.replaceXpath(OR_CignaTravelNANA.LBL_CREATED_DATE, phone);
				String actualCreatedDate = test.getTextFromElement(replaceCreatedDate);
				test.reportMessage("Travel Created Date : " + actualCreatedDate, false);
				break;
			}
		}
	}

	public void searchCreatedDate() throws BusinessException, InterruptedException {
		test.setSheetName(XL_GenericSheets.SHEET_CIGNA_TRAVEL_NANA);
		menuSelection();
		String getSearchDate = test.getData(XL_CignaTravelNANA.SEARCH);
		if (getSearchDate.equalsIgnoreCase("FutureDay")) {
			test.script(CLICK_BUTTON, OR_CignaTravelNANA.TXT_CREATED_DATE_SEARCH, "");
			String nextDay = test.addDays(1, "yyyy-MM-dd");
			test.scriptDirectValue(CLEAR_TYPE, OR_CignaTravelNANA.TXT_CREATED_DATE_SEARCH,
					XL_CignaTravelNANA.SEARCH_DATE, nextDay, false, 10);
			test.script(CLICK_BUTTON, OR_CignaTravelNANA.BTN_FILTER, "");
			if (test.isExists(OR_CignaTravelNANA.LBL_NO_RECORDS_FOUND)) {
				String expectedCreatedDate = test.getTextFromElement(OR_CignaTravelNANA.TXT_CREATED_DATE_SEARCH);
				test.reportMessage("Search Future Date [" + expectedCreatedDate + "] - No Records Found", false);
			} else {
				test.reportMessage("Search Future Date - Records found", true);
			}

		} else {
			test.script(CLICK_BUTTON, OR_CignaTravelNANA.TXT_CREATED_DATE_SEARCH, "");
			test.script(CLICK_BUTTON, OR_CignaTravelNANA.BTN_FILTER, "");
			Thread.sleep(2000);
			String expectedCreatedDate = test.getTextFromElement(OR_CignaTravelNANA.TXT_CREATED_DATE_SEARCH);
			int totalPhoneNumbers = test.getCount(OR_CignaTravelNANA.TOTAL_MOBILE_LIST);

			for (int createdDate = 2; createdDate <= totalPhoneNumbers; createdDate++) {
				String[] replaceCreatedDate = test.replaceXpath(OR_CignaTravelNANA.LBL_CREATED_DATE, createdDate);
				String[] splitCreatedDate = test.getTextFromElement(replaceCreatedDate).split(" ");
				String actualCreatedDate = splitCreatedDate[0];
				if (!expectedCreatedDate.equals(actualCreatedDate)) {
					test.reportMessage("Created Date Filter is not working fine", true);
				}
			}
			test.reportMessage("Created Date filter is working fine", false);
		}

	}

}

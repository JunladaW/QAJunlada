package com.rabbitmtls.testscript;

import com.automation.framework.applib.FunctionsApplib;
import com.automation.framework.beans.TestWareBean;
import com.automation.framework.exception.BusinessException;
import com.automation.framework.util.Test;
import com.rabbitbase.excelcolumns.XL_GenericSheets;
import com.rabbitbase.objectrepository.OR_GenericNANA;
import com.rabbitmtls.excelcolumns.XL_MTLSNANA;
import com.rabbitmtls.excelcolumns.XL_MTLSWebPage;
import com.rabbitmtls.excelcolumns.XL_WriteToExcel;
import com.rabbitmtls.objectrepository.OR_MTLSNANA;

public class MTLSNANA extends FunctionsApplib {

	String generatePhoneNumber;

	public MTLSNANA(TestWareBean testWareBean, Test test) throws BusinessException {
		super(testWareBean, test);
	}

	@Override
	protected String getSheetName() {
		return XL_GenericSheets.SHEET_MTLS_NANA;
	}

	public void nanaMTLS() throws BusinessException, InterruptedException {
		menuSelection();
		validateData();
	}

	public void loginNANA() throws BusinessException, InterruptedException {
		testWareBean.setExecuteURL("http://test1-nana.rabbit.co.th/");
		testWareBean.getWebDriver().get(testWareBean.getExecuteURL());
		test.setSheetName(XL_GenericSheets.SHEET_NANA_LOGIN);
		test.script(TYPE, OR_GenericNANA.WED_LOGIN_GMAIL_NANA_EMAIL, XL_GenericSheets.EMAIL, false, 20);
		test.script(CLICK_BUTTON, OR_GenericNANA.BTN_NEXT, "");
		test.script(TYPE, OR_GenericNANA.WED_LOGIN_GMAIL_NANA_PASSWORD, XL_GenericSheets.PASSWORD, false, 20);
		test.script(CLICK_BUTTON, OR_GenericNANA.BTN_SIGNIN, "");
		testWareBean.getWebDriver().get(testWareBean.getExecuteURL());
	}

	private void menuSelection() throws BusinessException, InterruptedException {
		test.script(CLICK_BUTTON, OR_MTLSNANA.BTN_LANGUAGE_EN, "");
		test.script(CLICK_BUTTON, OR_MTLSNANA.BTN_MUANG_THAI_LEASING, "");
		test.script(CLICK_BUTTON, OR_MTLSNANA.BTN_MUANG_THAI_LEASING_LEADS, "");
	}

	private void validateData() throws BusinessException, InterruptedException {
		test.script(CLICK_BUTTON, OR_MTLSNANA.BTN_LANGUAGE_TH, "");
		test.setSheetName(XL_GenericSheets.SHEET_MTLS_WEBPAGE);
		String expectedPhoneNumber = test.getData(2, XL_GenericSheets.SHEET_WRITE_TO_EXCEL,
				XL_WriteToExcel.LEADS_PHONE);
		String expectedName = test.getData(XL_MTLSWebPage.NAME);
		String expectedCollateral = test.getData(XL_MTLSWebPage.COLLATERAL_OPTION);
		String expectedLendingAmount = test.getData(XL_MTLSWebPage.LENDING_AMOUNT);
		String expectedProvince = test.getData(XL_MTLSWebPage.PROVINCE);
		String expectedHomeTown = test.getData(XL_MTLSWebPage.IS_HOMETOWN);
		String expectedIncomeRange = test.getData(XL_MTLSWebPage.INCOME);

		int totalPhoneNumbers = test.getCount(OR_MTLSNANA.TOTAL_MOBILE_LIST);

		for (int phone = 2; phone <= totalPhoneNumbers; phone++) {

			String[] replacePhoneNumber = test.replaceXpath(OR_MTLSNANA.LBL_MOBILE_NUMBER, phone);
			String actualPhoneNumber = test.getTextFromElement(replacePhoneNumber);

			if (expectedPhoneNumber.equals(actualPhoneNumber)) {

				test.comparisonResult(expectedPhoneNumber, actualPhoneNumber, "Phone Number");

				String[] replaceName = test.replaceXpath(OR_MTLSNANA.LBL_NAME, phone);
				String actualName = test.getTextFromElement(replaceName);
				test.comparisonResult(expectedName, actualName, "Name");

				String[] replaceCollateral = test.replaceXpath(OR_MTLSNANA.LBL_COLLATERAL, phone);
				String actaulCollateral = test.getTextFromElement(replaceCollateral);
				test.comparisonResult(expectedCollateral, actaulCollateral, "Collateral");

				String[] replaceLendingAmount = test.replaceXpath(OR_MTLSNANA.LBL_LENDING_AMOUNT, phone);
				String actualLendingAmount = test.getTextFromElement(replaceLendingAmount);
				test.comparisonResult(expectedLendingAmount + ".00", actualLendingAmount, "Lending Amount");

				String[] replaceProvince = test.replaceXpath(OR_MTLSNANA.LBL_PROVINCE, phone);
				String actualProvince = test.getTextFromElement(replaceProvince);
				test.comparisonResult(expectedProvince, actualProvince, "Province");

				String[] replaceHomeTown = test.replaceXpath(OR_MTLSNANA.LBL_HOME_TOWN, phone);
				String actualHomeTown = test.getTextFromElement(replaceHomeTown);
				if (expectedHomeTown.equals("Yes")) {
					test.comparisonResult("ใช่", actualHomeTown, "Is Home Town");
				} else {
					test.comparisonResult("ไม่ใช่", actualHomeTown, "Is Home Town");
				}

				String[] replaceIncomeRange = test.replaceXpath(OR_MTLSNANA.LBL_INCOME_RANGE, phone);
				String actualIncomeRange = test.getTextFromElement(replaceIncomeRange);
				test.comparisonResult(expectedIncomeRange, actualIncomeRange, "Income Range");

				String[] replaceCreatedDate = test.replaceXpath(OR_MTLSNANA.LBL_CREATED_DATE, phone);
				String actualCreatedDate = test.getTextFromElement(replaceCreatedDate);
				test.reportMessage("Created Date : " + actualCreatedDate, false);
				break;
			}

		}
	}

	public void searchCreatedDate() throws BusinessException, InterruptedException {
		test.setSheetName(XL_GenericSheets.SHEET_MTLS_NANA);
		menuSelection();
		String getSearchDate = test.getData(XL_MTLSNANA.SEARCH);
		if (getSearchDate.equalsIgnoreCase("FutureDay")) {
			test.script(CLICK_BUTTON, OR_MTLSNANA.TXT_CREATED_DATE_SEARCH, "");
			String nextDay = test.addDays(1, "yyyy-MM-dd");
			test.scriptDirectValue(CLEAR_TYPE, OR_MTLSNANA.TXT_CREATED_DATE_SEARCH, XL_MTLSNANA.SEARCH_DATE, nextDay,
					false, 10);
			test.script(CLICK_BUTTON, OR_MTLSNANA.BTN_FILTER, "");
			if (test.isExists(OR_MTLSNANA.LBL_NO_RECORDS_FOUND)) {
				String expectedCreatedDate = test.getTextFromElement(OR_MTLSNANA.TXT_CREATED_DATE_SEARCH);
				test.reportMessage("Search Future Date [" + expectedCreatedDate + "] - No Records Found", false);
			} else {
				test.reportMessage("Search Future Date - Records found", true);
			}

		} else {
			test.script(CLICK_BUTTON, OR_MTLSNANA.TXT_CREATED_DATE_SEARCH, "");
			test.script(CLICK_BUTTON, OR_MTLSNANA.BTN_FILTER, "");
			Thread.sleep(2000);
			String expectedCreatedDate = test.getTextFromElement(OR_MTLSNANA.TXT_CREATED_DATE_SEARCH);
			int totalPhoneNumbers = test.getCount(OR_MTLSNANA.TOTAL_MOBILE_LIST);

			for (int createdDate = 2; createdDate <= totalPhoneNumbers; createdDate++) {
				String[] replaceCreatedDate = test.replaceXpath(OR_MTLSNANA.LBL_CREATED_DATE, createdDate);
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

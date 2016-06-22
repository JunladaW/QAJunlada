package com.rabbitbase.generic;

import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

import com.automation.framework.applib.FunctionsApplib;
import com.automation.framework.beans.TestWareBean;
import com.automation.framework.exception.BusinessException;
import com.automation.framework.util.Test;
import com.rabbitbase.constants.NANA_Constants;
import com.rabbitbase.excelcolumns.XL_GenericSheets;
import com.rabbitbase.objectrepository.OR_GenericNANA;

public class Generic_NANA extends FunctionsApplib {

	private static Generic_NANA instance;

	public Generic_NANA(TestWareBean testWareBean, Test test) throws BusinessException {
		super(testWareBean, test);
	}

	public static Generic_NANA getInstance(TestWareBean testWareBean, Test test) throws BusinessException {
		return instance == null ? new Generic_NANA(testWareBean, test) : instance;
	}

	@Override
	protected String getSheetName() {
		String getSheetName = testWareBean.getSheetTestDataName();
		return getSheetName;
	}

	public void loginNANA(String menuName) throws BusinessException, InterruptedException {
		test.setSheetName(XL_GenericSheets.SHEET_NANA_LOGIN);
		test.script(TYPE, OR_GenericNANA.WED_LOGIN_GMAIL_NANA_EMAIL, XL_GenericSheets.EMAIL, false, 20);
		test.script(CLICK_BUTTON, OR_GenericNANA.BTN_NEXT, "");
		test.script(TYPE, OR_GenericNANA.WED_LOGIN_GMAIL_NANA_PASSWORD, XL_GenericSheets.PASSWORD, false, 20);
		test.script(CLICK_BUTTON, OR_GenericNANA.BTN_SIGNIN, "");
		testWareBean.getWebDriver().get(testWareBean.getExecuteURL());
		menuNANA(menuName);
	}

	public void reLoginNANA(String menuName) throws BusinessException, InterruptedException {
		testWareBean.getWebDriver().manage().deleteCookieNamed("rabbit_nana");
		testWareBean.getWebDriver().navigate().refresh();
		testWareBean.getWebDriver().get("http://gmail.com");
		test.script(CLICK_BUTTON, OR_GenericNANA.BTN_CLICK_GMAIL_NAME, "", false, 20);
		test.script(CLICK_BUTTON, OR_GenericNANA.BTN_GMAIL_SIGN_OUT, "", false, 20);
		test.script(CLICK_BUTTON, OR_GenericNANA.BTN_GMAIL_SIGNIN_DIFF_ACC, "", false, 20);
		test.script(CLICK_BUTTON, OR_GenericNANA.BTN_GMAIL_ADD_ACCOUNT, "", false, 20);

		loginNANA(menuName);
	}

	public void menuNANA(String menuName) throws BusinessException, InterruptedException {

		String expectedPageTitle = "";
		String actualPageTitle = "";

		test.script(CLICK_BUTTON, OR_GenericNANA.LNK_LANGUAGE_ENGLISH, "", false, 20);
		switch (menuName) {
		case "Leads":
			test.script(CLICK_BUTTON, OR_GenericNANA.BTN_CAR_INSURANCE, "");
			test.script(CLICK_BUTTON, OR_GenericNANA.BTN_LEADS, "");
			expectedPageTitle = NANA_Constants.LEADS;
			actualPageTitle = test.getTextFromElement(OR_GenericNANA.LBL_PAGE_TITLE);
			test.comparisonResult(expectedPageTitle, actualPageTitle, "Page Title");
			break;
		case "Opportunities":
			test.script(CLICK_BUTTON, OR_GenericNANA.BTN_CAR_INSURANCE, "");
			test.script(CLICK_BUTTON, OR_GenericNANA.BTN_OPPORTUNITIES, "");
			expectedPageTitle = NANA_Constants.OPPORTUNITIES;
			actualPageTitle = test.getTextFromElement(OR_GenericNANA.LBL_PAGE_TITLE);
			test.comparisonResult(expectedPageTitle, actualPageTitle, "Page Title");
			break;
		case "Order":
			test.script(CLICK_BUTTON, OR_GenericNANA.BTN_ORDERS, "");
			expectedPageTitle = NANA_Constants.ORDERS;
			actualPageTitle = test.getTextFromElement(OR_GenericNANA.LBL_PAGE_TITLE);
			test.comparisonResult(expectedPageTitle, actualPageTitle, "Page Title");
			break;
		case "Sales_Agent":
			testWareBean.getWebDriver().get("http://staging-nana.rabbit.co.th/sales");
			// test.script(CLICK_BUTTON, OR_GenericNANA.BTN_SALES_AGENT, "");
			break;
		case "Inbound & Helpdesk":
			test.script(CLICK_BUTTON, OR_GenericNANA.BTN_CAR_INSURANCE, "");
			test.script(CLICK_BUTTON, OR_GenericNANA.BTN_INBOUND_HELPDESK, "");
			expectedPageTitle = NANA_Constants.INBOUND_HELPDESK;
			actualPageTitle = test.getTextFromElement(OR_GenericNANA.LBL_PAGE_TITLE);
			test.comparisonResult(expectedPageTitle, actualPageTitle, "Page Title");
			break;
		case "Shipments":
			test.script(CLICK_BUTTON, OR_GenericNANA.BTN_CAR_INSURANCE, "");
			test.script(CLICK_BUTTON, OR_GenericNANA.BTN_SHIPMENTS, "");
			expectedPageTitle = NANA_Constants.SHIPMENTS;
			actualPageTitle = test.getTextFromElement(OR_GenericNANA.LBL_PAGE_TITLE);
			test.comparisonResult(expectedPageTitle, actualPageTitle, "Page Title");
			break;
		case "Data_Entry":
			test.script(CLICK_BUTTON, OR_GenericNANA.BTN_CAR_INSURANCE, "");
			test.script(CLICK_BUTTON, OR_GenericNANA.BTN_DATA_ENTRY, "");
			break;
		case "Listing Packages":
			test.script(CLICK_BUTTON, OR_GenericNANA.BTN_CAR_INSURANCE, "");
			test.script(CLICK_BUTTON, OR_GenericNANA.BTN_INSURANCE_PACKAGES, "");
			expectedPageTitle = NANA_Constants.INSURANCE_PACKAGES;
			actualPageTitle = test.getTextFromElement(OR_GenericNANA.LBL_PAGE_TITLE);
			test.comparisonResult(expectedPageTitle, actualPageTitle, "Page Title");
			break;
		case "Submittable Cases":
			test.script(CLICK_BUTTON, OR_GenericNANA.BTN_CAR_INSURANCE, "");
			test.script(CLICK_BUTTON, OR_GenericNANA.BTN_SUBMITTABLE_CASES, "");
			expectedPageTitle = NANA_Constants.SUBMITTABLE_CASES;
			actualPageTitle = test.getTextFromElement(OR_GenericNANA.LBL_PAGE_TITLE);
			test.comparisonResult(expectedPageTitle, actualPageTitle, "Page Title");
			break;
		case "Accounting":
			// test.script(CLICK_BUTTON, OR_GenericNANA.BTN_CAR_INSURANCE, "");
			test.script(CLICK_BUTTON, OR_GenericNANA.BTN_ACCOUNTING, "");
			expectedPageTitle = NANA_Constants.ACCOUNTING;
			actualPageTitle = test.getTextFromElement(OR_GenericNANA.LBL_PAGE_TITLE);
			test.comparisonResult(expectedPageTitle, actualPageTitle, "Page Title");
			break;
		case "Agent Discounts":
			test.script(CLICK_BUTTON, OR_GenericNANA.BTN_CAR_INSURANCE, "");
			test.script(CLICK_BUTTON, OR_GenericNANA.BTN_AGENT_DISCOUNTS, "");
			break;
		default:
			test.reportMessage("Invalid Menu", true);
		}
	}

	public void writeToExcel(String sheetName, String colName, String value) throws BusinessException {
		test.actionWriteData(value, colName, sheetName, 2, false);
		test.actionWriteData(value, colName + COLUMN_VALIDATE, sheetName, 2, false);
	}

	public void calDOBValidation(String xPath[], String day, String month, String year) throws Exception {

		test.script(CLICK_BUTTON, xPath, "");
		int getYear = Integer.parseInt(year);
		int getAge = validationYear() - getYear;
		if (getAge >= 18) {
			test.isExists(OR_GenericNANA.BTN_YEAR_FUTURE_DISABLED);
			String exceptedTitle = month + " " + year;
			String actualTitle = test.getTextFromElement(OR_GenericNANA.LBL_TITLE_MONTH_YEAR);
			while (exceptedTitle != actualTitle) {
				if (exceptedTitle.equals(actualTitle)) {
					break;
				}
				testWareBean.getWebDriver().findElement(By.xpath(OR_GenericNANA.BTN_PREVIOUS_MONTH[0])).click();

				actualTitle = test.getTextFromElement(OR_GenericNANA.LBL_TITLE_MONTH_YEAR);
			}
			String[] expectedDate = test.replaceXpath(OR_GenericNANA.BTN_SELECT_DATE, day);
			test.script(CLICK_BUTTON, expectedDate, "");
		} else {
			throw new Exception(String.format("Year - %s is less than 18 years old ", year));
		}
	}

	public void calFutureDateValidation(String xPath[]) throws BusinessException, InterruptedException {

		test.script(CLICK_BUTTON, xPath, "");
		test.isExists(OR_GenericNANA.BTN_BACK_DATE_DISABLED);

	}

	private int validationYear() throws BusinessException {

		Calendar date = Calendar.getInstance();
		date.setTime(new Date());
		Format f = new SimpleDateFormat("yyyy");
		int currentYear = Integer.parseInt(f.format(date.getTime()));

		return currentYear;
		// date.add(Calendar.YEAR, -18);
		// String yearBefore18 = f.format(date.getTime());

	}

	public void uploadDocument(String id, String uploadFile) {
		((PhantomJSDriver) testWareBean.getWebDriver())
				.executePhantomJS("var page = this; page.uploadFile('input[id=" + id + "]', '" + uploadFile + "');");
	}

	public String getYoungestDriver(String driver1DOB, String driver2DOB) throws ParseException {

		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date comDate1 = dateFormat.parse(driver1DOB);
		Date comDate2 = dateFormat.parse(driver2DOB);

		if (comDate1.after(comDate2)) {
			return driver1DOB;
		} else {
			return driver2DOB;
		}
	}
}

package com.rabbitnana.testscript;

import org.openqa.selenium.By;

import com.automation.framework.applib.FunctionsApplib;
import com.automation.framework.beans.TestWareBean;
import com.automation.framework.exception.BusinessException;
import com.automation.framework.util.Test;
import com.rabbitbase.constants.NANA_Constants;
import com.rabbitbase.constants.Project_Constants;
import com.rabbitbase.excelcolumns.XL_GenericNANA;
import com.rabbitbase.generic.Generic_NANA;
import com.rabbitnana.excelcolumns.XL_InboundAndHelpdesk;
import com.rabbitnana.excelcolumns.XL_TabInfo;
import com.rabbitnana.excelcolumns.XL_WriteToExcel;
import com.rabbitnana.objectrepository.OR_Dashboard;
import com.rabbitnana.objectrepository.OR_InboundAndHelpdesk;
import com.rabbitnana.objectrepository.OR_TabInfo;

public class InboundAndHelpdesk extends FunctionsApplib {

	private Dashboard dashboard;
	private Generic_NANA genericNANA;
	private String getInsurerName;

	public InboundAndHelpdesk(TestWareBean testWareBean, Test test) throws BusinessException {
		super(testWareBean, test);
		genericNANA = Generic_NANA.getInstance(testWareBean, test);
		dashboard = new Dashboard(testWareBean, test);
	}

	@Override
	protected String getSheetName() {
		return null;
	}

	public void helpdeskAfterCreated() throws BusinessException, InterruptedException {
		test.setSheetName(XL_GenericNANA.SHEET_NANA_INBOUNDHELPDESK);

		testWareBean.getWebDriver().get("http://staging-nana.rabbit.co.th");
		genericNANA.menuNANA(NANA_Constants.INBOUND_HELPDESK);

		searchOrderID();

		validateDashboard();

		validateCustomerInfo();

		validateCarInfo();

		uploadDocs();

		tabPayment();

		readyToSubmit();
	}

	public void noteEventValidationForInsurerPaid() throws BusinessException, InterruptedException {
		testWareBean.getWebDriver().get("http://staging-nana.rabbit.co.th");
		genericNANA.menuNANA(NANA_Constants.INBOUND_HELPDESK);

		searchOrderID();
		test.script(CLICK_BUTTON, OR_Dashboard.BTN_DASHBOARD_TAB_HELPDESK, "");
		String getPaidInsurer = test.getTextFromElement(OR_InboundAndHelpdesk.LBL_PAID_INSURER);
		test.reportMessage("Final status after paid for insurer : " + getPaidInsurer, false);
		noteEventFlags();
	}

	private void searchOrderID() throws BusinessException, InterruptedException {

		String getOrderID = test.getData(2, XL_GenericNANA.SHEET_WRITE_TO_EXCEL, XL_WriteToExcel.LEADS_ORDER_ID);
		test.script(CLEAR_TYPE, OR_InboundAndHelpdesk.TXT_ORDER_ID, XL_WriteToExcel.LEADS_ORDER_ID, getOrderID);
		test.script(CLICK_BUTTON, OR_InboundAndHelpdesk.BTN_FILTER, "");

		clickOnLeadFileBtn();
	}

	private void validateDashboard() throws BusinessException, InterruptedException {
		test.setSheetName(XL_GenericNANA.SHEET_NANA_INBOUNDHELPDESK);
		dashboard.validateHelpDeskDashboard();
	}

	private void validateCustomerInfo() throws BusinessException, InterruptedException {
		test.setSheetName(XL_GenericNANA.SHEET_NANA_CUSTOMERINFO);
		test.isExists(OR_TabInfo.TAB_RED_CUSTOMER_INFO);

		String expectedEmail = test.getData(XL_TabInfo.LEADS_EMAIL);
		String actualEmail = test.getTextFromElement(OR_TabInfo.TXT_LEAD_CUSTOMER_EMAIL);
		test.comparisonResult(expectedEmail, actualEmail, "Customer Email");

		String expectedPhone = test.getData(2, XL_GenericNANA.SHEET_WRITE_TO_EXCEL, XL_WriteToExcel.LEADS_PHONE);
		String actaulPhone = test.getAttributeValue(OR_InboundAndHelpdesk.LBL_LEAD_CUSTOMER_PHONE);
		test.comparisonResult(expectedPhone, actaulPhone, "Customer Phone");

		if (!test.getData(XL_TabInfo.LINE_ID).isEmpty()) {
			String expectedLineID = test.getData(XL_TabInfo.LINE_ID);
			String actaulLineID = test.getTextFromTextBox(OR_InboundAndHelpdesk.TXT_LINE_ID);
			test.comparisonResult(expectedLineID, actaulLineID, "Line ID");
		}

		String expectedFirstName = test.getData(XL_TabInfo.LEADS_FIRST_NAME);
		String actaulFirstName = test.getTextFromTextBox(OR_TabInfo.TXT_LEAD_CUSTOMER_FIRSTNAME);
		test.comparisonResult(expectedFirstName, actaulFirstName, "First Name");

		if (!test.getData(XL_TabInfo.LEADS_LAST_NAME).isEmpty()) {
			String expectedLastName = test.getData(XL_TabInfo.LEADS_LAST_NAME);
			String actualLastName = test.getTextFromTextBox(OR_TabInfo.TXT_LEAD_CUSTOMER_LASTNAME);
			test.comparisonResult(expectedLastName, actualLastName, "Last Name");
		} else {
			String currentTest = testWareBean.getSheetTestDataName();
			test.setSheetName(XL_GenericNANA.SHEET_NANA_INBOUNDHELPDESK);
			test.script(TYPE, OR_TabInfo.TXT_LEAD_CUSTOMER_LASTNAME, XL_InboundAndHelpdesk.LEADS_LAST_NAME);
			test.setSheetName(currentTest);
		}

		test.setSheetName(XL_GenericNANA.SHEET_NANA_INBOUNDHELPDESK);
		String getLBL_NationalID = test.getTextFromElement(OR_InboundAndHelpdesk.LBL_NATIONAL_ID_PASSPORT);
		test.reportMessage("Lable - " + getLBL_NationalID, false);
		test.script(TYPE, OR_InboundAndHelpdesk.TXT_NATIONAL_ID_PASSPORT, XL_InboundAndHelpdesk.NATIONAL_ID_PASSPORT);
		test.script(CLICK_BUTTON, OR_InboundAndHelpdesk.BTN_SAVE_CUSTOMER_INFO, "");
	}

	private void validateCarInfo() throws BusinessException, InterruptedException {

		test.setSheetName(XL_GenericNANA.SHEET_NANA_CAR_INFO);

		test.isExists(OR_InboundAndHelpdesk.LBL_LICENSE_PLATE_MANDATORY);
		test.isExists(OR_InboundAndHelpdesk.LBL_CHASSIS_NUMBER_MANDATORY);
		test.isExists(OR_InboundAndHelpdesk.LBL_VIN_MANDATORY);

		String actualCarYear = test.getTextFromElement(OR_InboundAndHelpdesk.LBL_TXT_CAR_YEAR);
		String expectedCarYear = test.getData(XL_TabInfo.CAR_YEAR);
		test.comparisonResult(expectedCarYear, actualCarYear, "Car Year");

		String actualCarBrand = test.getTextFromElement(OR_InboundAndHelpdesk.LBL_TXT_CAR_BRAND);
		String expectedCarBrand = test.getData(XL_TabInfo.CAR_BRAND);
		test.comparisonResult(expectedCarBrand, actualCarBrand, "Car Brand");

		String actualCarModel = test.getTextFromElement(OR_InboundAndHelpdesk.LBL_TXT_CAR_MODEL);
		String expectedCarModel = test.getData(XL_TabInfo.CAR_MODEL);
		test.comparisonResult(expectedCarModel, actualCarModel, "Car Model");

		String actaulCarSubModel = test.getTextFromElement(OR_InboundAndHelpdesk.LBL_TXT_CAR_SUB_MODEL);
		String expectedCarSubModel = test.getData(XL_TabInfo.CAR_SUB_MODEL);
		test.comparisonResult(expectedCarSubModel, actaulCarSubModel, "Car Sub Model");

		String carType = test.getTextFromElement(OR_InboundAndHelpdesk.IS_PRESENT_CAR_TYPE);
		String numberOfDoors = test.getTextFromElement(OR_InboundAndHelpdesk.IS_PRESENT_NUMBER_OF_DOORS);
		String carEngine = test.getTextFromElement(OR_InboundAndHelpdesk.IS_PRESENT_CAR_ENGINE);

		if (!carType.isEmpty() && !numberOfDoors.isEmpty() && !carEngine.isEmpty()) {
			test.reportMessage("Car Type - " + carType, false);
			test.reportMessage("Number of doors - " + numberOfDoors, false);
			test.reportMessage("Car Engine - " + carEngine, false);
		} else {
			test.reportMessage(
					"Car Type - " + carType + "Number of doors - " + numberOfDoors + "Car Engine - " + carEngine, true);
		}

		if (test.getData(XL_TabInfo.LICENSE_PLATE).isEmpty() || test.getData(XL_TabInfo.CHASSIS_NUMBER).isEmpty()
				|| test.getData(XL_TabInfo.VEHICLE_IDENTIFICATION_NUMBER).isEmpty()) {
			test.isExists(OR_TabInfo.TAB_RED_CAR_INFO);
			String getSheetName = testWareBean.getSheetTestDataName();
			test.setSheetName(XL_GenericNANA.SHEET_NANA_INBOUNDHELPDESK);
			test.script(TYPE, OR_InboundAndHelpdesk.TXT_LICENSE_PLATE, XL_InboundAndHelpdesk.LICENSE_PLATE);
			test.script(TYPE, OR_InboundAndHelpdesk.TXT_CHASSIS_NUMBER, XL_InboundAndHelpdesk.CHASSIS_NUMBER);
			test.script(TYPE, OR_InboundAndHelpdesk.TXT_VEHICLE_IDENTIFICATION_NUMBER,
					XL_InboundAndHelpdesk.VEHICLE_IDENTIFICATION_NUMBER);
			test.setSheetName(getSheetName);
		} else {

			String actaulLicensePlate = test.getTextFromTextBox(OR_InboundAndHelpdesk.TXT_LICENSE_PLATE);
			String expectedLicensePlate = test.getData(XL_TabInfo.LICENSE_PLATE);
			test.comparisonResult(expectedLicensePlate, actaulLicensePlate, "License Plate");

			String actaulChassisNumber = test.getTextFromTextBox(OR_InboundAndHelpdesk.TXT_CHASSIS_NUMBER);
			String expectedChassisNumber = test.getData(XL_TabInfo.CHASSIS_NUMBER);
			test.comparisonResult(expectedChassisNumber, actaulChassisNumber, "Chassis Number");

			String actaulVIN = test.getTextFromTextBox(OR_InboundAndHelpdesk.TXT_VEHICLE_IDENTIFICATION_NUMBER);
			String expectedVIN = test.getData(XL_TabInfo.VEHICLE_IDENTIFICATION_NUMBER);
			test.comparisonResult(expectedVIN, actaulVIN, "Vehicle Identification Number");
		}

		String actualModifications = test.getTextFromElement(OR_InboundAndHelpdesk.LBL_TXT_MODIFICATIONS);
		String expectedModifications = test.getData(XL_TabInfo.IS_MODIFICATION);
		test.comparisonResult(expectedModifications, actualModifications, "Modification");

		if (expectedModifications.equals(Project_Constants.YES)) {
			String getModificationValue = test.getTextFromElement(OR_InboundAndHelpdesk.LBL_MODIFICATION_LIST);
			test.reportMessage("Modifications list : " + getModificationValue, false);
		}

		test.script(CLICK_BUTTON, OR_InboundAndHelpdesk.BTN_SAVE_CAR_INFO, "");
		getInsurerName = test.getTextFromElement(OR_InboundAndHelpdesk.LBL_INSURANCE_PACKAGE_NAME);
	}

	private void uploadDocs() throws BusinessException, InterruptedException {

		String uploadFile = System.getProperty("user.dir") + "/src/main/resources/testdata/renewal_notice-IL.jpg";
		uploadFile = uploadFile.replace("\\", "/");

		test.isExists(OR_InboundAndHelpdesk.DOC_CAR_REGISTRATION);
		test.isExists(OR_InboundAndHelpdesk.DOC_ID_CARD);

		String getLastInsurer = test.getData(testWareBean.getExcelTestDataCurrentRow(),
				XL_GenericNANA.SHEET_NANA_POLICY_INFO, XL_TabInfo.LAST_INSURER);

		String getInsuranceType = test.getData(testWareBean.getExcelTestDataCurrentRow(),
				XL_GenericNANA.SHEET_NANA_QUOTES, XL_TabInfo.INSURANCE_TYPE);

		if ((!getLastInsurer.equals("") && getInsuranceType.equals("Type 1"))
				|| (!getLastInsurer.isEmpty() && getInsuranceType.equals("Type 1"))) {
			test.script(CLICK_BUTTON, OR_InboundAndHelpdesk.BTN_LAST_POLICY_DOCS, "");
			test.isExists(OR_InboundAndHelpdesk.LNK_LAST_POLICY_DOCS_ACTIVE);
			genericNANA.uploadDocument("last-policy-file-0", uploadFile);
		}

		test.script(CLICK_BUTTON, OR_InboundAndHelpdesk.BTN_PAYMENT_DOCUMENTS, "");
		test.isExists(OR_InboundAndHelpdesk.LNK_PAYMENT_DOCS_ACTIVE);
		genericNANA.uploadDocument("payment-documents-file-0", uploadFile);
		Thread.sleep(3000);
		testWareBean.getWebDriver().navigate().refresh();

		String getDriverMain = test.getData(testWareBean.getExcelTestDataCurrentRow(),
				XL_GenericNANA.SHEET_NANA_DRIVER_INFO, XL_TabInfo.IS_CUSTOMER_MAIN_DRIVER);

		String getDriver2 = test.getData(testWareBean.getExcelTestDataCurrentRow(),
				XL_GenericNANA.SHEET_NANA_DRIVER_INFO, XL_TabInfo.IS_FIXED_DRIVER_2);

		if (getDriverMain.equals(Project_Constants.YES) && getInsuranceType.equals("Type 1")) {
			test.script(CLICK_BUTTON, OR_InboundAndHelpdesk.BTN_DRIVING_LICENSE, "");
			test.isExists(OR_InboundAndHelpdesk.LNK_DRIVING_LICENSE_ACTIVE);
			genericNANA.uploadDocument("driving-license-file-0", uploadFile);
			if (getDriver2.equals(Project_Constants.YES)) {
				genericNANA.uploadDocument("driving-license-file-1", uploadFile);
			}
		}

		if (getInsurerName.contains("Muang Thai")) {
			test.script(CLICK_BUTTON, OR_InboundAndHelpdesk.BTN_CAR_PICTURES, "");
			test.isExists(OR_InboundAndHelpdesk.LNK_CAR_PICTURES_ACTIVE);
			genericNANA.uploadDocument("car-pictures-file-4", uploadFile);
			genericNANA.uploadDocument("car-pictures-file-3", uploadFile);
			genericNANA.uploadDocument("car-pictures-file-2", uploadFile);
			genericNANA.uploadDocument("car-pictures-file-1", uploadFile);
			genericNANA.uploadDocument("car-pictures-file-0", uploadFile);
		}
		// test.isExists(OR_TabInfo.TAB_GREEN_DOCS);
	}

	private void clickOnLeadFileBtn() throws BusinessException, InterruptedException {

		int getTotalOrder = test.getCount(OR_InboundAndHelpdesk.TOTAL_ORDER_ID);
		String expectedOrderID = test.getData(2, XL_GenericNANA.SHEET_WRITE_TO_EXCEL, XL_WriteToExcel.LEADS_ORDER_ID);
		String getStatus = "";
		for (int startOrder = 2; startOrder <= getTotalOrder; startOrder++) {
			String[] replaceStatus = test.replaceXpath(OR_InboundAndHelpdesk.LBL_STATUS, startOrder);
			getStatus = test.getTextFromElement(replaceStatus);
			String[] replaceXpath_OrderID = test.replaceXpath(OR_InboundAndHelpdesk.LBL_ORDER_ID, startOrder);
			String getOrderID = test.getTextFromElement(replaceXpath_OrderID);
			if (getOrderID.equals(expectedOrderID)) {
				String replaceXpath_File[] = test.replaceXpath(OR_InboundAndHelpdesk.BTN_LEAD_FILE, startOrder);
				test.reportMessage("Status - " + getStatus, false);
				test.script(CLICK_BUTTON, replaceXpath_File, "");
				break;
			}
		}
	}

	private void tabPayment() throws BusinessException, InterruptedException {

		test.setSheetName(XL_GenericNANA.SHEET_NANA_INBOUNDHELPDESK);

		test.script(CLICK_BUTTON, OR_InboundAndHelpdesk.BTN_PAYMENT_TAB, "");
		testWareBean.getWebDriver().findElement(By.xpath(OR_InboundAndHelpdesk.TXT_CUSTOMER_PAY_DATE[0])).click();
		String getPayDate = test.getTextFromTextBox(OR_InboundAndHelpdesk.TXT_CUSTOMER_PAY_DATE);
		test.reportMessage("Pay Date : " + getPayDate, false);
		test.script(CLICK_BUTTON, OR_InboundAndHelpdesk.BTN_CUSTOMER_PAY_DATE_SAVE, "");
		Thread.sleep(3000);
		test.script(CLICK_BUTTON, OR_InboundAndHelpdesk.BTN_OK_SUCCESS, "");
		test.script(TYPE, OR_InboundAndHelpdesk.TXT_CUSTOMER_PAID_AMOUNT, XL_InboundAndHelpdesk.PAYMENT_AMOUNT);
		test.script(CLICK_BUTTON, OR_InboundAndHelpdesk.BTN_CUSTOMER_PAID_AMOUNT_SAVE, "");
		Thread.sleep(3000);
		test.script(CLICK_BUTTON, OR_InboundAndHelpdesk.BTN_OK_SUCCESS, "");

	}

	private void readyToSubmit() throws BusinessException, InterruptedException {
		test.script(CLICK_BUTTON, OR_Dashboard.BTN_DASHBOARD_TAB_HELPDESK, "");
		test.script(CLICK_BUTTON, OR_InboundAndHelpdesk.BTN_READY_TO_SUBMIT, "");
		test.script(CLICK_BUTTON, OR_InboundAndHelpdesk.BTN_CONFIRM_SUCCESS, "");
		Thread.sleep(2000);
		searchOrderID();
		test.script(CLICK_BUTTON, OR_Dashboard.BTN_DASHBOARD_TAB_HELPDESK, "");
		noteEventFlags();
	}

	private void noteEventFlags() throws BusinessException {

		int getNoteEventFlagCount = test.getCount(OR_Dashboard.LBL_NOTE_EVENT_COUNT);
		test.reportMessage("Total Note Event(s) :" + getNoteEventFlagCount, false);
		if (getNoteEventFlagCount == 1) {
			String getFlagText = test.getTextFromElement(OR_Dashboard.LBL_NOTE_EVENT_SINGLE_FLAG);
			test.reportMessage("Note Event Flag : " + getFlagText, false);
		} else {
			for (int noteEvent = 1; noteEvent <= getNoteEventFlagCount; noteEvent++) {
				String[] replaceNoteEventTag = test.replaceXpath(OR_Dashboard.LBL_NOTE_EVENT_MULTI_FLAG, noteEvent);
				String getFlagText = test.getTextFromElement(replaceNoteEventTag);
				test.reportMessage("Note Event Flag : " + getFlagText, false);
			}
		}
	}

}

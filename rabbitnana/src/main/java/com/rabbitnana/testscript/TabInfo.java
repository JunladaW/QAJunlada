package com.rabbitnana.testscript;

import java.text.ParseException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.automation.framework.applib.FunctionsApplib;
import com.automation.framework.beans.TestWareBean;
import com.automation.framework.exception.BusinessException;
import com.automation.framework.util.Test;
import com.rabbitbase.constants.NANA_Constants;
import com.rabbitbase.constants.Project_Constants;
import com.rabbitbase.excelcolumns.XL_GenericSheets;
import com.rabbitbase.generic.Generic_NANA;
import com.rabbitnana.excelcolumns.XL_TabInfo;
import com.rabbitnana.excelcolumns.XL_WriteToExcel;
import com.rabbitnana.objectrepository.OR_TabInfo;

public class TabInfo extends FunctionsApplib {

	private Generic_NANA genericNANA;
	private Dashboard dashboard;
	private String driver_1_DOB = "";
	private String driver_2_DOB = "";

	public TabInfo(TestWareBean testWareBean, Test test) throws BusinessException {
		super(testWareBean, test);
		genericNANA = Generic_NANA.getInstance(testWareBean, test);
		dashboard = new Dashboard(testWareBean, test);
	}

	@Override
	protected String getSheetName() {
		return null;
	}

	public void fillSalesInfo() throws Exception {

		validateTabLegends();

		validateSectionInfoDisabled();

		tabCustomerInfo();

		dashboard.validateSalesDashboard();

		tabCarInfo();

		tabDriverInfo();

		tabPolicyInfo();

		detailAddress();

		uploadDocuments();

		tabPayments();

		tabQuotes();
	}

	private void validateTabLegends() throws BusinessException {

		test.setSheetName(XL_GenericSheets.SHEET_NANA_CUSTOMERINFO);

		if (test.getData(XL_TabInfo.LEAD_OPPORTUNITY).equals("Lead")) {
			test.isExists(OR_TabInfo.TAB_RED_CUSTOMER_INFO);
			// test.isExists(OR_TabInfo.TAB_HIDDEN_DOCS);
		} else {
			test.isExists(OR_TabInfo.TAB_GREEN_CUSTOMER_INFO);
			test.isExists(OR_TabInfo.TAB_RED_DOCS);
		}

		test.isExists(OR_TabInfo.TAB_RED_CAR_INFO);
		test.isExists(OR_TabInfo.TAB_RED_DRIVER_INFO);
		test.isExists(OR_TabInfo.TAB_RED_POLICY_INFO);
		test.isExists(OR_TabInfo.TAB_RED_ADDRESS);
		test.isExists(OR_TabInfo.TAB_RED_BILLING_ADDRESS);
		// test.isExists(OR_TabInfo.TAB_HIDDEN_SHIPPING_ADDRESS);

	}

	private void validateSectionInfoDisabled() throws BusinessException {

		if (test.getData(XL_TabInfo.LEAD_OPPORTUNITY).equals("Lead")) {
			test.isExists(OR_TabInfo.FIELD_CAR_INFO_DISABLED);
		}
		test.isExists(OR_TabInfo.FIELD_DRIVER_INFO_DISABLED);
		test.isExists(OR_TabInfo.FIELD_POLICY_INFO_DISABLED);
		test.isExists(OR_TabInfo.FIELD_ADDRESS_DISABLED);
		test.isExists(OR_TabInfo.FIELD_SHIPPING_ADDRESS_DISABLED);

	}

	private void tabCustomerInfo() throws BusinessException, InterruptedException {

		test.setSheetName(XL_GenericSheets.SHEET_NANA_CUSTOMERINFO);
		test.isExists(OR_TabInfo.LBL_MANDATORY_EMAIL);
		test.isExists(OR_TabInfo.LBL_MANDATORY_FIRST_NAME);

		String actualCustomerPhone = test.getTextFromElement(OR_TabInfo.LBL_LEAD_CUSTOMER_PHONE);
		String expectedCustomerPhone = test.getData(2, XL_GenericSheets.SHEET_WRITE_TO_EXCEL,
				XL_WriteToExcel.LEADS_PHONE);
		test.comparisonResult(expectedCustomerPhone, actualCustomerPhone, "Customer Phone");
		if (!test.getData(XL_TabInfo.IS_DELETE_SALES).equals(Project_Constants.YES)) {

			if (!test.getData(XL_TabInfo.LINE_ID).isEmpty()) {
				test.script(TYPE, OR_TabInfo.TXT_LINE_ID, XL_TabInfo.LINE_ID);
			}
			if (test.getData(XL_TabInfo.LEAD_OPPORTUNITY).equals("Lead")) {
				test.script(TYPE, OR_TabInfo.TXT_LEAD_CUSTOMER_EMAIL, XL_TabInfo.LEADS_EMAIL);
				test.script(TYPE, OR_TabInfo.TXT_LEAD_CUSTOMER_FIRSTNAME, XL_TabInfo.LEADS_FIRST_NAME);
			}
			if (!test.getData(XL_TabInfo.LEADS_LAST_NAME).isEmpty()) {
				test.script(CLEAR_TYPE, OR_TabInfo.TXT_LEAD_CUSTOMER_LASTNAME, XL_TabInfo.LEADS_LAST_NAME);
			}
			if (test.getData(XL_TabInfo.IS_ORDERFORCOMAPANY).equals(Project_Constants.YES)) {
				test.script(CLICK_BUTTON, OR_TabInfo.RDO_ORDER_FOR_COMPANY_YES, "");
				test.isExists(OR_TabInfo.LBL_MANDATORY_COMPANY);
				test.script(TYPE, OR_TabInfo.TXT_COMPANY, XL_TabInfo.TXT_COMPANT_NAME);
			}
			test.script(CLICK_BUTTON, OR_TabInfo.BTN_CONVERT_TO_OPPORTUNITY, "");
			test.isExists(OR_TabInfo.TAB_GREEN_CUSTOMER_INFO);
		} else {
			test.script(CLICK_BUTTON, OR_TabInfo.BTN_SALES_DELETE, "");
		}
	}

	private void tabCarInfo() throws BusinessException, InterruptedException {
		test.setSheetName(XL_GenericSheets.SHEET_NANA_CAR_INFO);

		test.script(SELECT_LIST, OR_TabInfo.WLS_CAR_YEAR, XL_TabInfo.CAR_YEAR);
		test.script(SELECT_LIST, OR_TabInfo.WLS_CAR_BRAND, XL_TabInfo.CAR_BRAND);
		test.script(SELECT_LIST, OR_TabInfo.WLS_CAR_MODEL, XL_TabInfo.CAR_MODEL);
		test.script(SELECT_LIST, OR_TabInfo.WLS_CAR_SUBMODEL, XL_TabInfo.CAR_SUB_MODEL);

		String carType = test.getTextFromElement(OR_TabInfo.IS_PRESENT_CAR_TYPE);
		String numberOfDoors = test.getTextFromElement(OR_TabInfo.IS_PRESENT_NUMBER_OF_DOORS);
		String carEngine = test.getTextFromElement(OR_TabInfo.IS_PRESENT_CAR_ENGINE);

		if (!carType.isEmpty() && !numberOfDoors.isEmpty() && !carEngine.isEmpty()) {
			test.reportMessage("Car Type - " + carType, false);
			test.reportMessage("Number of doors - " + numberOfDoors, false);
			test.reportMessage("Car Engine - " + carEngine, false);
		} else {
			test.reportMessage(
					"Car Type - " + carType + "Number of doors - " + numberOfDoors + "Car Engine - " + carEngine, true);
		}

		if (!test.getData(XL_TabInfo.LICENSE_PLATE).isEmpty()) {
			test.script(TYPE, OR_TabInfo.TXT_LICENSE_PLATE, XL_TabInfo.LICENSE_PLATE);
		}
		if (!test.getData(XL_TabInfo.CHASSIS_NUMBER).isEmpty()) {
			test.script(TYPE, OR_TabInfo.TXT_CHASSIS_NUMBER, XL_TabInfo.CHASSIS_NUMBER);
		}
		if (!test.getData(XL_TabInfo.VEHICLE_IDENTIFICATION_NUMBER).isEmpty()) {
			test.script(TYPE, OR_TabInfo.TXT_VEHICLE_IDENTIFICATION_NUMBER, XL_TabInfo.VEHICLE_IDENTIFICATION_NUMBER);
		}
		if (test.getData(XL_TabInfo.DRIVING_PURPOSE).equals("Commercial")) {
			test.script(CLICK_BUTTON, OR_TabInfo.RDO_DRIVING_PURPOSE_COMMERCIAL, "");
		}
		if (test.getData(XL_TabInfo.IS_MODIFICATION).equals(Project_Constants.YES)) {
			test.script(CLICK_BUTTON, OR_TabInfo.RDO_MODIFICATIONS_YES, "");
			test.script(SELECT_LIST, OR_TabInfo.WLS_MODIFICATION_VALUE, XL_TabInfo.MODIFICATION_VALUE);
			test.script(TYPE, OR_TabInfo.TXT_MODIFICATION_AMOUNT, XL_TabInfo.MODIFICATION_AMOUNT);
		}
		test.script(CLICK_BUTTON, OR_TabInfo.BTN_CAR_INFO_SAVE, "");
		test.isExists(OR_TabInfo.TAB_GREEN_CAR_INFO);
	}

	private void tabDriverInfo() throws Exception {
		test.setSheetName(XL_GenericSheets.SHEET_NANA_DRIVER_INFO);
		if (!test.getData(XL_TabInfo.DRIVE_PLACE).equals("Thailand")) {
			selectProvinces();
		}
		/* Main Driver Yes */
		if (test.getData(XL_TabInfo.IS_CUSTOMER_MAIN_DRIVER).equals(Project_Constants.YES)) {
			test.script(CLICK_BUTTON, OR_TabInfo.RDO_CUSTOMER_MAIN_DRIVER_YES, "");
			fixedDriver_1();

			/* Fixed Driver 2 */
			if (test.getData(XL_TabInfo.IS_FIXED_DRIVER_2).equals(Project_Constants.YES)) {
				test.script(CLICK_BUTTON, OR_TabInfo.RDO_DRIVER_2_YES, "");
				fixedDriver_2();
			}
		}
		test.script(CLICK_BUTTON, OR_TabInfo.BTN_DRIVER_INFO_SAVE, "");
		test.isExists(OR_TabInfo.TAB_GREEN_DRIVER_INFO);
	}

	private void selectProvinces() throws Exception {

		test.script(CLICK_BUTTON, OR_TabInfo.RDO_DRIVE_SOME_PROVINCES, "");

		String getProvinces = test.getData(testWareBean.getExcelTestDataCurrentRow(),
				XL_GenericSheets.SHEET_NANA_DRIVER_INFO, XL_TabInfo.PROVINCES);
		String[] arrProvinces = getProvinces.split(";");

		test.script(CLICK_BUTTON, OR_TabInfo.BTN_PROVICE_BOX, "");
		int totoalProvinceList = test.getCount(OR_TabInfo.TOTAL_PROVINCE_LIST);
		test.reportMessage("Total Province List : " + totoalProvinceList, false);

		for (int province = 0; province < arrProvinces.length; province++) {
			String[] replaceProvince = test.replaceXpath(OR_TabInfo.UL_SELECT_PROVINCE, arrProvinces[province]);
			test.script(CLICK_BUTTON, replaceProvince, "");
			if (province < arrProvinces.length - 1) {
				test.script(CLICK_BUTTON, OR_TabInfo.BTN_PROVICE_BOX, "");
			}
		}
		int totalSelectedProvince = test.getCount(OR_TabInfo.TOTAL_SELECTED_PROVINCE);
		for (int selectedProvince = 1; selectedProvince < totalSelectedProvince; selectedProvince++) {
			String[] replaceSelectedProvince = test.replaceXpath(OR_TabInfo.TXT_SELECTED_PROVINCE, selectedProvince);
			String actualProvince = test.getTextFromElement(replaceSelectedProvince);
			String expectedProvince = "×" + arrProvinces[selectedProvince - 1];
			if (actualProvince.contains(expectedProvince)) {
				test.comparisonResult(expectedProvince, actualProvince, "Selected Province");
			}
		}
	}

	private void fixedDriver_1() throws Exception {

		String expectedFirstName = test.getTextFromTextBox(OR_TabInfo.TXT_LEAD_CUSTOMER_FIRSTNAME);
		String actualFirstName = test.getTextFromTextBox(OR_TabInfo.TXT_DRIVER_1_FIRST_NAME);
		test.comparisonResult(expectedFirstName, actualFirstName, "First Name automatic populate in Driver info");

		if (!test.getTextFromTextBox(OR_TabInfo.TXT_LEAD_CUSTOMER_LASTNAME).isEmpty()) {
			String expectedLastName = test.getTextFromTextBox(OR_TabInfo.TXT_LEAD_CUSTOMER_LASTNAME);
			String actualLastName = test.getTextFromTextBox(OR_TabInfo.TXT_DRIVER_1_LAST_NAME);
			test.comparisonResult(expectedLastName, actualLastName, "Last Name automatic populate in Driver info");
		} else {
			test.script(CLEAR_TYPE, OR_TabInfo.TXT_DRIVER_1_LAST_NAME, XL_TabInfo.DRIVER_1_LAST_NAME);
		}

		String getDay = test.getData(XL_TabInfo.DRIVER_1_DOB_DAY);
		String getMonth_String = test.getData(XL_TabInfo.DRIVER_1_MONTH_STRING);
		String getMonth_Int = test.getData(XL_TabInfo.DRIVER_1_DOB_MONTH);
		String getYear = test.getData(XL_TabInfo.DRIVER_1_DOB_YEAR);

		genericNANA.calDOBValidation(OR_TabInfo.CAL_DRIVER_1_DOB, getDay, getMonth_String, getYear);

		String expectedDOB_Driver = getYear + "-" + getMonth_Int + "-" + getDay;
		String actualDOB_Driver = test.getTextFromElement(OR_TabInfo.TXT_DRIVER_1_DOB);
		driver_1_DOB = actualDOB_Driver;
		test.comparisonResult(expectedDOB_Driver, actualDOB_Driver, "Driver 1 DOB");

		if (!test.getData(XL_TabInfo.DRIVER_1_NATIONAL_ID).isEmpty()) {
			test.script(TYPE, OR_TabInfo.TXT_DRIVER_1_NATIONALID, XL_TabInfo.DRIVER_1_NATIONAL_ID);
		}
		if (!test.getData(XL_TabInfo.DRIVER_1_LICENSE).isEmpty()) {
			test.script(TYPE, OR_TabInfo.TXT_DRIVER_1_DRIVER_LICENSE, XL_TabInfo.DRIVER_1_LICENSE);
		}

	}

	private void fixedDriver_2() throws Exception {

		if (!test.getData(XL_TabInfo.DRIVER_2_FIRST_NAME).isEmpty()) {
			test.script(TYPE, OR_TabInfo.TXT_DRIVER_2_FIRST_NAME, XL_TabInfo.DRIVER_2_FIRST_NAME);
		}
		if (!test.getData(XL_TabInfo.DRIVER_2_LAST_NAME).isEmpty()) {
			test.script(TYPE, OR_TabInfo.TXT_DRIVER_2_LAST_NAME, XL_TabInfo.DRIVER_2_LAST_NAME);
		}

		String getDay = test.getData(XL_TabInfo.DRIVER_2_DOB_DAY);
		String getMonth_String = test.getData(XL_TabInfo.DRIVER_2_MONTH_STRING);
		String getMonth_Int = test.getData(XL_TabInfo.DRIVER_2_DOB_MONTH);
		String getYear = test.getData(XL_TabInfo.DRIVER_2_DOB_YEAR);

		genericNANA.calDOBValidation(OR_TabInfo.CAL_DRIVER_2_DOB, getDay, getMonth_String, getYear);

		String expectedDOB_Driver = getYear + "-" + getMonth_Int + "-" + getDay;
		String actualDOB_Driver = test.getTextFromElement(OR_TabInfo.TXT_DRIVER_2_DOB);
		driver_2_DOB = actualDOB_Driver;
		test.comparisonResult(expectedDOB_Driver, actualDOB_Driver, "Driver 2 DOB");

		if (!test.getData(XL_TabInfo.DRIVER_2_NATIONAL_ID).isEmpty()) {
			test.script(TYPE, OR_TabInfo.TXT_DRIVER_2_NATIONALID, XL_TabInfo.DRIVER_2_NATIONAL_ID);
		}
		if (!test.getData(XL_TabInfo.DRIVER_2_LICENSE).isEmpty()) {
			test.script(TYPE, OR_TabInfo.TXT_DRIVER_2_DRIVER_LICENSE, XL_TabInfo.DRIVER_2_LICENSE);
		}
	}

	private void tabPolicyInfo() throws Exception {
		test.setSheetName(XL_GenericSheets.SHEET_NANA_POLICY_INFO);
		String getLastInsurerValue = test.getTextFromSelected(OR_TabInfo.WLS_LAST_INSURER);
		if (getLastInsurerValue.equals("None")) {
			test.isExists(OR_TabInfo.TXT_LAST_PRICE_DISABLED);
			test.isExists(OR_TabInfo.TXT_OLD_POLICY_EXPIRY_DISABLED);
		}
		if (!test.getData(XL_TabInfo.LAST_INSURER).isEmpty()) {
			String getLastInsurer = test.getData(XL_TabInfo.LAST_INSURER);
			testWareBean.getWebDriver().findElement(By.xpath(OR_TabInfo.WLS_LAST_INSURER[0])).sendKeys(getLastInsurer);
			test.script(TYPE, OR_TabInfo.TXT_LAST_PRICE, XL_TabInfo.LAST_PRICE);
			String getDate = test.addDays(-2, NANA_Constants.NANA_DATE_FORMAT);
			test.scriptDirectValue(CLEAR_TYPE, OR_TabInfo.TXT_EXPIRY_OLD_POLICY, XL_TabInfo.EXPIRY_OLD_POLICY, getDate,
					false, 10);
		}
		if (test.getData(XL_TabInfo.IS_CLAIMED_LAST_YEAR).equals(Project_Constants.YES)) {
			test.script(CLICK_BUTTON, OR_TabInfo.RDO_CLAIMED_LAST_YEAR_YES, "");
		}

		genericNANA.calFutureDateValidation(OR_TabInfo.BTN_CAL_START_POLICY);
		String getDate = test.addDays(0, NANA_Constants.NANA_DATE_FORMAT);
		test.scriptDirectValue(TYPE, OR_TabInfo.TXT_NEW_POLICY_DATE, XL_TabInfo.NEW_POLICY_DATE, getDate, false, 10);
		test.script(CLICK_BUTTON, OR_TabInfo.BTN_POLICY_INFO_SAVE, "");
		test.isExists(OR_TabInfo.TAB_GREEN_POLICY_INFO);
		test.isExists(OR_TabInfo.BTN_QUOTES_TAB);
	}

	private void detailAddress() throws BusinessException, InterruptedException {
		tabCustomerAddress();
		tabBillingAddress();
		tabShippingAddress();
	}

	private void tabCustomerAddress() throws BusinessException, InterruptedException {

		test.setSheetName(XL_GenericSheets.SHEET_NANA_CUSTOMER_ADDRESS);
		test.script(SELECT_LIST, OR_TabInfo.WLS_CUSTOMER_PROVINCE, XL_TabInfo.ADDRESS_PROVINCE);
		test.script(SELECT_LIST, OR_TabInfo.WLS_CUSTOMER_DISTRICT, XL_TabInfo.ADDRESS_DISTRICT);
		test.script(SELECT_LIST, OR_TabInfo.WLS_CUSTOMER_SUB_DISTRICT, XL_TabInfo.ADDRESS_SUB_DISTRICT);
		test.script(TYPE, OR_TabInfo.WLS_CUSTOMER_ADDRESS_1, XL_TabInfo.ADDRESS_LINE_1);
		if (!test.getData(XL_TabInfo.ADDRESS_LINE_2).isEmpty()) {
			test.script(TYPE, OR_TabInfo.WLS_CUSTOMER_ADDRESS_2, XL_TabInfo.ADDRESS_LINE_2);
		}
		test.isExists(OR_TabInfo.TXT_CUSTOMER_ZIP_CODE);
		test.script(CLICK_BUTTON, OR_TabInfo.BTN_CUSTOMER_ADDRESS_SAVE, "");
		test.isExists(OR_TabInfo.TAB_GREEN_CUSTOMER_INFO);
	}

	private void tabBillingAddress() throws BusinessException, InterruptedException {

		test.setSheetName(XL_GenericSheets.SHEET_NANA_BILLING_ADDRESS);
		if (test.getData(XL_TabInfo.IS_SAME_AS_CUSTOMER_ADDRESS).equals(Project_Constants.NO)) {
			test.script(CLICK_BUTTON, OR_TabInfo.RDO_BILLING_ADDRESS_NO, "");
			test.script(SELECT_LIST, OR_TabInfo.WLS_BILLING_PROVINCE, XL_TabInfo.ADDRESS_PROVINCE);
			test.script(SELECT_LIST, OR_TabInfo.WLS_BILLING_DISTRICT, XL_TabInfo.ADDRESS_DISTRICT);
			test.script(SELECT_LIST, OR_TabInfo.WLS_BILLING_SUB_DISTRICT, XL_TabInfo.ADDRESS_SUB_DISTRICT);
			test.script(TYPE, OR_TabInfo.WLS_BILLING_ADDRESS_1, XL_TabInfo.ADDRESS_LINE_1);
			if (!test.getData(XL_TabInfo.ADDRESS_LINE_2).isEmpty()) {
				test.script(TYPE, OR_TabInfo.WLS_BILLING_ADDRESS_2, XL_TabInfo.ADDRESS_LINE_2);
			}
			test.isExists(OR_TabInfo.TXT_BILLING_ZIP_CODE);
		}
		test.script(CLICK_BUTTON, OR_TabInfo.BTN_BILLING_ADDRESS_SAVE, "");
		test.isExists(OR_TabInfo.TAB_GREEN_BILLING_ADDRESS);

	}

	private void tabShippingAddress() throws BusinessException, InterruptedException {

		test.setSheetName(XL_GenericSheets.SHEET_NANA_SHIPPING_ADDRESS);
		if (test.getData(XL_TabInfo.IS_SAME_AS_SHIPPING_ADDRESS).equals(Project_Constants.NO)) {
			test.script(CLICK_BUTTON, OR_TabInfo.RDO_SHIPPING_ADDRESS_NO, "");
			test.script(SELECT_LIST, OR_TabInfo.WLS_SHIPPING_PROVINCE, XL_TabInfo.ADDRESS_PROVINCE);
			test.script(SELECT_LIST, OR_TabInfo.WLS_SHIPPING_DISTRICT, XL_TabInfo.ADDRESS_DISTRICT);
			test.script(SELECT_LIST, OR_TabInfo.WLS_SHIPPING_SUB_DISTRICT, XL_TabInfo.ADDRESS_SUB_DISTRICT);
			test.script(TYPE, OR_TabInfo.WLS_SHIPPING_ADDRESS_1, XL_TabInfo.ADDRESS_LINE_1);
			if (!test.getData(XL_TabInfo.ADDRESS_LINE_2).isEmpty()) {
				test.script(TYPE, OR_TabInfo.WLS_SHIPPING_ADDRESS_2, XL_TabInfo.ADDRESS_LINE_2);
			}
			test.isExists(OR_TabInfo.TXT_SHIPPING_ZIP_CODE);
			test.script(CLICK_BUTTON, OR_TabInfo.BTN_SHIPPING_ADDRESS_SAVE, "");
			test.isExists(OR_TabInfo.TAB_GREEN_SHIPPING_ADDRESS);
		}
	}

	private void uploadDocuments() throws Exception {

		String uploadFile = System.getProperty("user.dir") + "/src/main/resources/testdata/renewal_notice-IL.jpg";
		uploadFile = uploadFile.replace("\\", "/");

		/* Upload Car Registration Document */
		test.script(CLICK_BUTTON, OR_TabInfo.BTN_CAR_REGISTRATION, "");
		test.isExists(OR_TabInfo.LNK_CAR_REGISTRATION_ACTIVE);
		genericNANA.uploadDocument("car-registration-file-0", uploadFile);

		/* Upload ID Card Document */
		test.script(CLICK_BUTTON, OR_TabInfo.BTN_ID_CARD, "");
		test.isExists(OR_TabInfo.LNK_ID_CARD_ACTIVE);
		genericNANA.uploadDocument("id-card-file-0", uploadFile);

	}

	private void tabQuotes() throws BusinessException, InterruptedException, ParseException {

		test.script(CLICK_BUTTON, OR_TabInfo.BTN_QUOTES_TAB, "");
		test.setSheetName(XL_GenericSheets.SHEET_NANA_QUOTES);
		String getInsuranceType = test.getData(XL_TabInfo.INSURANCE_TYPE);
		String[] replaceInsuranceType = null;
		if (getInsuranceType.equalsIgnoreCase("All")) {
			replaceInsuranceType = test.replaceXpath(OR_TabInfo.RDO_INSURANCE_TYPE, "");
		} else {
			replaceInsuranceType = test.replaceXpath(OR_TabInfo.RDO_INSURANCE_TYPE, getInsuranceType);
		}
		test.script(CLICK_BUTTON, replaceInsuranceType, "");
		test.reportMessage("Insurance Type - " + getInsuranceType, false);

		String getIncludeMandatory = test.getData(XL_TabInfo.INCLUDE_MANDATORY);
		String[] replaceIncludeMandatory = null;
		if (getIncludeMandatory.equals(Project_Constants.YES)) {
			replaceIncludeMandatory = test.replaceXpath(OR_TabInfo.RDO_INCLUDE_MANDATORY, "1");
		} else {
			replaceIncludeMandatory = test.replaceXpath(OR_TabInfo.RDO_INCLUDE_MANDATORY, "0");
		}
		test.script(CLICK_BUTTON, replaceIncludeMandatory, "");
		test.reportMessage("Include Mandatory - " + getIncludeMandatory, false);

		String getRepair = test.getData(XL_TabInfo.REPAIR);
		String[] replaceRepair = null;
		if (getRepair.equalsIgnoreCase("Both")) {
			replaceRepair = test.replaceXpath(OR_TabInfo.RDO_REPAIR, "");
		} else {
			replaceRepair = test.replaceXpath(OR_TabInfo.RDO_REPAIR, getRepair);
		}
		test.script(CLICK_BUTTON, replaceRepair, "");
		test.reportMessage("Repair - " + getRepair, false);

		String getDeductible = test.getData(XL_TabInfo.REPAIR);
		String[] replaceDeductible = null;
		if (getDeductible.equalsIgnoreCase("Both")) {
			replaceDeductible = test.replaceXpath(OR_TabInfo.RDO_DEDUCTIBLE, "");
		} else if (getDeductible.equals(Project_Constants.YES)) {
			replaceDeductible = test.replaceXpath(OR_TabInfo.RDO_DEDUCTIBLE, "1");
		} else {
			replaceDeductible = test.replaceXpath(OR_TabInfo.RDO_DEDUCTIBLE, "0");
		}
		test.script(CLICK_BUTTON, replaceDeductible, "");
		test.reportMessage("Deductible - " + getDeductible, false);

		if (!driver_1_DOB.isEmpty() && !driver_2_DOB.isEmpty()) {
			test.reportMessage("Driver 1 DOB : " + driver_1_DOB, false);
			test.reportMessage("Driver 2 DOB : " + driver_2_DOB, false);
			String expectedYoungestDriver = genericNANA.getYoungestDriver(driver_1_DOB, driver_2_DOB);
			String actualYoungestDriverDOB = test.getTextFromElement(OR_TabInfo.LBL_YOUNGEST_DRIVER_DOB);
			test.comparisonResult(expectedYoungestDriver, actualYoungestDriverDOB, "Youngest Driver");
		} else if (!driver_1_DOB.equals("") || !driver_2_DOB.equals("")) {
			String getYoungestDriverDOB = test.getTextFromElement(OR_TabInfo.LBL_YOUNGEST_DRIVER_DOB);
			test.reportMessage("Youngest Driver's DOB : " + getYoungestDriverDOB, false);
		}

		test.scrollToElement(OR_TabInfo.BTN_SEARCH_QUOTES[0]);

		test.script(CLICK_BUTTON, OR_TabInfo.BTN_SEARCH_QUOTES, "");
		validateQuote();
	}

	private void validateQuote() throws BusinessException, InterruptedException {
		String getInsuranceType = test.getData(XL_TabInfo.INSURANCE_TYPE);
		int getQuotesCount = test.getCount(OR_TabInfo.COUNT_QUOTES_LIST);
		int countToSlideBar = 10;
		String expectedInsuranceType = test.getData(testWareBean.getExcelTestDataCurrentRow(),
				XL_GenericSheets.SHEET_NANA_QUOTES, XL_TabInfo.INSURANCE_TYPE);

		/* Use slide bar when no package found */
		while (getQuotesCount == 0) {
			if (countToSlideBar > 100) {
				test.reportMessage("Quotes matches found empty for Insurance Type - " + getInsuranceType, true);
				break;
			}
			WebElement element = testWareBean.getWebDriver()
					.findElement(By.xpath("//*[@id='desired-coverage-slider']/span"));

			Actions act = new Actions(testWareBean.getWebDriver());
			act.dragAndDropBy(element, countToSlideBar, 0).build().perform();
			act.click().perform();
			countToSlideBar = countToSlideBar + 10;
			test.script(CLICK_BUTTON, OR_TabInfo.BTN_SEARCH_QUOTES, "");
			getQuotesCount = test.getCount(OR_TabInfo.COUNT_QUOTES_LIST);
		}

		/*
		 * Select multiple quotes when more than one quotation found and send
		 * out to customer
		 */
		if (getQuotesCount != 1) {
			int start = 1;
			while (true) {
				String[] attr = { "//*[contains(@id,'package-row-')][" + start + "]/td[1]//*[@name='quote_item']",
						"Package Value" };
				String getAttributePackageValue = test.getAttributeValue(attr);
				testWareBean.getWebDriver().findElement(By.xpath("//*[contains(@id,'package-row-')][" + start
						+ "]/td[1]//*[@id='quote-selection-" + getAttributePackageValue + "']")).click();
				String actualInsuranceType = testWareBean.getWebDriver()
						.findElement(By.xpath("//*[contains(@id,'package-row-')][" + start + "]/td[4]")).getText();
				start++;
				if (start > 3 || getQuotesCount < 2) {
					test.comparisonResult(expectedInsuranceType, actualInsuranceType, "Insurance Type");
					break;
				}
			}
		} else {
			test.script(CLICK_BUTTON, OR_TabInfo.CKB_SINGLE_QUOTATION, "");
			String actualInsuranceType = test.getTextFromElement(OR_TabInfo.LBL_SINGLE_QUOTATION_TYPE);
			test.comparisonResult(expectedInsuranceType, actualInsuranceType, "Insurance Type");
		}

		/* Sending out quotation either TH or EN version */
		String getSendQuotationLanguage = test.getData(XL_TabInfo.SEND_QUOTATION);
		if (getSendQuotationLanguage.equalsIgnoreCase("English")) {
			test.script(CLICK_BUTTON, OR_TabInfo.BTN_SEND_QUOTATION_ENGLISH, "");
		} else {
			test.script(CLICK_BUTTON, OR_TabInfo.BTN_SEND_QUOTATION_THAI, "");
		}
		test.script(CLICK_BUTTON, OR_TabInfo.BTN_SUBMIT_QUOTATION, "");
		if (test.isExists(OR_TabInfo.LBL_QUOTATION_SUCCESS)) {
			String qutoationSentTo = test.getTextFromElement(OR_TabInfo.LBL_QUOTATION_SENT_TO);
			test.reportMessage(qutoationSentTo, false);
		}
		/* To disappear Quotation Success message */
		Thread.sleep(5000);

		/* Checking Gift Vouchers and sending out invoice */

		String isGiftVouchers = test.getData(XL_TabInfo.HAS_GIFT_VOUCHER);
		if (isGiftVouchers.equals(Project_Constants.YES)) {
			if (getQuotesCount == 1) {
				int getPriceValue = Integer.parseInt(test.getTextFromElement(OR_TabInfo.LBL_QUOTE_FINAL_PRICE_SINGLE));
				if (isGiftVouchers.equals(Project_Constants.YES) && getPriceValue > 20000) {
					test.reportMessage("Final Price found less than 20K and Price is " + getPriceValue, true);
				} else {
					test.reportMessage("Quote Final Price : " + getPriceValue, false);
					test.script(CLICK_BUTTON, OR_TabInfo.BTN_QUOTATION_SEND_NOW_SINGLE, "");
				}
			} else {
				int countFinalPrice = test.getCount(OR_TabInfo.TOTAL_FINAL_PRICE_LIST);
				int start = 1;
				while (start <= countFinalPrice) {
					String[] attr = { "//*[contains(@id,'package-row-')][" + start + "]/td[1]//*[@name='quote_item']",
							"Package Value" };
					String getAttributePackageValue = test.getAttributeValue(attr);
					String[] replaceXpathFinalPrice = test.replaceXpath(OR_TabInfo.LBL_QUOTE_FINAL_PRICE,
							getAttributePackageValue);
					int getFinalPriceValue = Integer.parseInt(test.getTextFromElement(replaceXpathFinalPrice));
					if (getFinalPriceValue >= 20000) {
						test.reportMessage("Quote Final Price " + getFinalPriceValue, false);
						String[] replaceXpathBuyNow = test.replaceXpath(OR_TabInfo.BTN_QUOTATION_SEND_NOW,
								getAttributePackageValue);
						test.script(CLICK_BUTTON, replaceXpathBuyNow, "");
						break;
					}
					start++;
				}
			}

			if (test.isExists(OR_TabInfo.LBL_GIFT_POPUP)) {
				String lblGift = test.getTextFromElement(OR_TabInfo.LBL_GIFT_POPUP);
				test.reportMessage("Gift Label : " + lblGift, false);
				String getGiftVoucher = test.getData(XL_TabInfo.CHOOSE_GIFT);
				if (getGiftVoucher.equals("Car DVR + vouchers")) {
					test.script(CLICK_BUTTON, OR_TabInfo.RDO_GIFT_CAR_DVR, "");
				} else if (getGiftVoucher.equals("PTT card + vouchers")) {
					test.script(CLICK_BUTTON, OR_TabInfo.RDO_GIFT_PTT_CARD, "");
				} else {
					test.script(CLICK_BUTTON, OR_TabInfo.RDO_GIFT_VOUCHERS, "");
				}
				test.script(CLICK_BUTTON, OR_TabInfo.BTN_GIFT_SAVE, "");
				test.script(CLICK_BUTTON, OR_TabInfo.BTN_BUY_NOW_OK, "");
			}
		} else {// When no gift and send out invoice
			if (getQuotesCount == 1) {
				int getPriceValue = Integer.parseInt(test.getTextFromElement(OR_TabInfo.LBL_QUOTE_FINAL_PRICE_SINGLE));
				test.reportMessage("Quote Final Price " + getPriceValue, false);
				test.script(CLICK_BUTTON, OR_TabInfo.BTN_QUOTATION_SEND_NOW_SINGLE, "");
				test.script(CLICK_BUTTON, OR_TabInfo.BTN_BUY_NOW_OK, "");
			} else {
				int start = 1;
				while (true) {
					String[] attr = { "//*[contains(@id,'package-row-')][" + start + "]/td[1]//*[@name='quote_item']",
							"Package Value" };
					String getAttributePackageValue = test.getAttributeValue(attr);
					String[] replaceXpathBuyNow = test.replaceXpath(OR_TabInfo.BTN_QUOTATION_SEND_NOW,
							getAttributePackageValue);
					test.script(CLICK_BUTTON, replaceXpathBuyNow, "");
					test.script(CLICK_BUTTON, OR_TabInfo.BTN_BUY_NOW_OK, "");
					Thread.sleep(2000);
					start++;
					if (start > 1) {
						break;
					}
				}
			}
		}
	}

	private void tabPayments() throws BusinessException, InterruptedException {
		test.setSheetName(XL_GenericSheets.SHEET_NANA_PAYMENTS);
		test.script(CLICK_BUTTON, OR_TabInfo.BTN_PAYMENT_TAB, "");
		String getPaymentOptions = test.getData(XL_TabInfo.PAYMENT_OPTIONS);
		String[] replacePaymentOptions = null;
		if (getPaymentOptions.equalsIgnoreCase("Onetime") || getPaymentOptions.equalsIgnoreCase("One-time")) {
			replacePaymentOptions = test.replaceXpath(OR_TabInfo.RDO_PAYMENT_OPTIONS, "onetime");
			test.script(CLICK_BUTTON, replacePaymentOptions, "");
			test.reportMessage("Payment Option - " + getPaymentOptions, false);
			paymentOneTime();
		} else {
			replacePaymentOptions = test.replaceXpath(OR_TabInfo.RDO_PAYMENT_OPTIONS, "installments");
			test.script(CLICK_BUTTON, replacePaymentOptions, "");
			test.reportMessage("Payment Option - " + getPaymentOptions, false);
			paymentInstallment();
		}
	}

	private void paymentOneTime() throws BusinessException, InterruptedException {

		String getPaymentMethod = test.getData(XL_TabInfo.PAYMENT_METHOD);
		String[] replacePaymentMethod = null;
		if (getPaymentMethod.equalsIgnoreCase("Bank Transfer")) {
			replacePaymentMethod = test.replaceXpath(OR_TabInfo.RDO_PAYMENT_METHOD, getPaymentMethod);
		} else if (getPaymentMethod.equalsIgnoreCase("Credit Card (Online)")) {
			replacePaymentMethod = test.replaceXpath(OR_TabInfo.RDO_PAYMENT_METHOD, getPaymentMethod);
		} else if (getPaymentMethod.equalsIgnoreCase("EDC")) {
			replacePaymentMethod = test.replaceXpath(OR_TabInfo.RDO_PAYMENT_METHOD, getPaymentMethod);
		}
		test.script(CLICK_BUTTON, replacePaymentMethod, "");
		test.reportMessage("Payment Method - " + getPaymentMethod, false);

		int getPaymentBankList = test.getCount(OR_TabInfo.TOTAL_BANK_LIST);
		for (int startBank = 1; startBank <= getPaymentBankList; startBank++) {
			String[] replaceBankName = test.replaceXpath(OR_TabInfo.LBL_BANK_NAME, startBank);
			String actualBankName = test.getTextFromElement(replaceBankName);
			String expectedBankName = test.getData(XL_TabInfo.PAYMENT_BANK);
			if (actualBankName.equalsIgnoreCase(expectedBankName)) {
				String[] xpathRDO_BankName = test.replaceXpath(OR_TabInfo.RDO_BANK_NAME, startBank);
				test.script(CLICK_BUTTON, xpathRDO_BankName, "");
				test.reportMessage("Bank Name - " + actualBankName, false);
				break;
			}
		}
		test.script(CLICK_BUTTON, OR_TabInfo.BTN_PAYMENT_SAVE, "");

	}

	private void paymentInstallment() throws BusinessException, InterruptedException {
		int getPaymentBankList = test.getCount(OR_TabInfo.TOTAL_BANK_LIST_INSTALLMENT);
		for (int startBank = 1; startBank <= getPaymentBankList; startBank++) {
			String[] replaceBankName = test.replaceXpath(OR_TabInfo.LBL_BANK_NAME_INSTALLMENT, startBank);
			String actualBankName = test.getTextFromElement(replaceBankName);
			String expectedBankName = test.getData(XL_TabInfo.PAYMENT_BANK);
			if (actualBankName.equalsIgnoreCase(expectedBankName)) {

				String[] replaceRDOBankName = test.replaceXpath(OR_TabInfo.RDO_BANK_NAME_INSTALLMENT, startBank);
				test.script(CLICK_BUTTON, replaceRDOBankName, "");
				test.reportMessage("Bank Name - " + actualBankName, false);
				break;
			}
		}
		test.script(CLICK_BUTTON, OR_TabInfo.RDO_INSTALLMENT_PROVIDERS, "");
		test.script(CLICK_BUTTON, OR_TabInfo.BTN_PAYMENT_SAVE, "");
	}

}

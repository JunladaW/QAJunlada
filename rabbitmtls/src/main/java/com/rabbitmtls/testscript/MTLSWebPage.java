package com.rabbitmtls.testscript;

import com.automation.framework.applib.FunctionsApplib;
import com.automation.framework.beans.TestWareBean;
import com.automation.framework.exception.BusinessException;
import com.automation.framework.util.GenericUtil;
import com.automation.framework.util.Test;
import com.rabbitbase.constants.Project_Constants;
import com.rabbitbase.excelcolumns.XL_GenericSheets;
import com.rabbitbase.generic.Generic_NANA;
import com.rabbitmtls.excelcolumns.XL_MTLSWebPage;
import com.rabbitmtls.excelcolumns.XL_WriteToExcel;
import com.rabbitmtls.objectrepository.OR_MTLSWebPage;

public class MTLSWebPage extends FunctionsApplib {

	String generatePhoneNumber;
	private Generic_NANA generic_NANA;

	public MTLSWebPage(TestWareBean testWareBean, Test test) throws BusinessException {
		super(testWareBean, test);
		generic_NANA = Generic_NANA.getInstance(testWareBean, test);
	}

	@Override
	protected String getSheetName() {
		return XL_GenericSheets.SHEET_MTLS_WEBPAGE;
	}

	public void webMTLS() throws BusinessException, InterruptedException {

		landingPage();
		loadRequirements();
		addressInfo();
		contactInformation();
		pageConfirmation();

	}

	private void landingPage() throws BusinessException, InterruptedException {
		String getSaveOption = test.getData(XL_MTLSWebPage.SAVE_NOW);
		if (getSaveOption.equalsIgnoreCase("SaveNowTop")) {
			test.script(CLICK_BUTTON, OR_MTLSWebPage.BTN_SAVE_NOW_TOP, "");
		} else if (getSaveOption.equalsIgnoreCase("SelectTop")) {
			test.script(CLICK_BUTTON, OR_MTLSWebPage.BTN_TXT_TOP, "");
		} else if (getSaveOption.equalsIgnoreCase("SaveNowCenter")) {
			test.script(CLICK_BUTTON, OR_MTLSWebPage.BTN_SAVE_NOW_CENTER, "");
		} else if (getSaveOption.equalsIgnoreCase("SelectCenter")) {
			test.script(CLICK_BUTTON, OR_MTLSWebPage.BTN_TXT_CENTER, "");
		} else if (getSaveOption.equalsIgnoreCase("SaveNowBottom")) {
			test.script(CLICK_BUTTON, OR_MTLSWebPage.BTN_SAVE_NOW_BOTTOM, "");
		} else {
			test.script(CLICK_BUTTON, OR_MTLSWebPage.BTN_TXT_BOTTOM, "");
		}
	}

	private void loadRequirements() throws BusinessException, InterruptedException {

		String getCollateralOption = test.getData(XL_MTLSWebPage.COLLATERAL_OPTION);
		if (getCollateralOption.equalsIgnoreCase("Car")) {
			test.script(CLICK_BUTTON, OR_MTLSWebPage.RDO_COLLATERAL_CAR, "");
		} else {
			test.script(CLICK_BUTTON, OR_MTLSWebPage.RDO_COLLATERAL_BIKE, "");
		}
		test.script(TYPE, OR_MTLSWebPage.TXT_LENDING_AMOUNT, XL_MTLSWebPage.LENDING_AMOUNT);

		int getTotalIncomeRange = test.getCount(OR_MTLSWebPage.TOTAL_INCOME_RANGE);
		test.reportMessage("Total Income Rages are : " + (getTotalIncomeRange - 1), false);

		for (int incomeRange = 2; incomeRange <= getTotalIncomeRange; incomeRange++) {

			String[] replaceIncomeRange = test.replaceXpath(OR_MTLSWebPage.LBL_INCOME_RANGE, incomeRange);
			String getIncomeRange = test.getTextFromElement(replaceIncomeRange);
			test.reportMessage("Income Range " + (incomeRange - 1) + " : " + getIncomeRange, false);
		}

		test.script(SELECT_LIST, OR_MTLSWebPage.WLS_INCOME, XL_MTLSWebPage.INCOME);
		test.script(CLICK_BUTTON, OR_MTLSWebPage.BTN_NEXT_LOAN_REQUIREMENTS, "");
	}

	private void addressInfo() throws BusinessException, InterruptedException {
		int totalProvinces = test.getCount(OR_MTLSWebPage.TOTAL_PROVINCES);
		test.reportMessage("Total Provinces are : " + (totalProvinces - 1), false);
		test.script(SELECT_LIST, OR_MTLSWebPage.WLS_PROVINCE, XL_MTLSWebPage.PROVINCE);

		String getIsHomeTown = test.getData(XL_MTLSWebPage.IS_HOMETOWN);
		if (getIsHomeTown.equals(Project_Constants.YES)) {
			test.script(CLICK_BUTTON, OR_MTLSWebPage.RDO_IS_HOMETOWN_YES, "");
		} else {
			test.script(CLICK_BUTTON, OR_MTLSWebPage.RDO_IS_HOMETOWN_NO, "");
		}

		test.script(CLICK_BUTTON, OR_MTLSWebPage.BTN_NEXT_ADDRESS, "");
	}

	private void contactInformation() throws BusinessException, InterruptedException {

		test.script(TYPE, OR_MTLSWebPage.TXT_NAME, XL_MTLSWebPage.NAME);

		generatePhoneNumber = "080" + GenericUtil.getRandomNumber();
		generic_NANA.writeToExcel(XL_GenericSheets.SHEET_WRITE_TO_EXCEL, XL_WriteToExcel.LEADS_PHONE,
				generatePhoneNumber);
		test.script(TYPE, OR_MTLSWebPage.TXT_PHONE, XL_WriteToExcel.LEADS_PHONE);
		test.script(CLICK_BUTTON, OR_MTLSWebPage.BTN_NEXT_CONTACT, "");

	}

	private void pageConfirmation() throws BusinessException, InterruptedException {
		test.isExists(OR_MTLSWebPage.LBL_RABBIT_THANK_YOU);
	}

}

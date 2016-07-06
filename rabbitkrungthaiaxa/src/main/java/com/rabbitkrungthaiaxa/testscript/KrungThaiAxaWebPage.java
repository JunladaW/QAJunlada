package com.rabbitkrungthaiaxa.testscript;

import com.automation.framework.applib.FunctionsApplib;
import com.automation.framework.beans.TestWareBean;
import com.automation.framework.exception.BusinessException;
import com.automation.framework.util.GenericUtil;
import com.automation.framework.util.Test;
import com.rabbitbase.excelcolumns.XL_GenericSheets;
import com.rabbitbase.generic.Generic_NANA;
import com.rabbitkrungthaiaxa.excelcolumns.XL_KTAWebPage;
import com.rabbitkrungthaiaxa.excelcolumns.XL_WriteToExcel;
import com.rabbitkrungthaiaxa.objectrepository.OR_KTAWebPage;

public class KrungThaiAxaWebPage extends FunctionsApplib {

	String generatePhoneNumber;
	private Generic_NANA generic_NANA;

	public KrungThaiAxaWebPage(TestWareBean testWareBean, Test test) throws BusinessException {
		super(testWareBean, test);
		generic_NANA = Generic_NANA.getInstance(testWareBean, test);
	}

	@Override
	protected String getSheetName() {
		return XL_GenericSheets.SHEET_MTLS_WEBPAGE;
	}

	public void webKTA() throws BusinessException, InterruptedException {

		landingPage();
		informationCustomer();
		informationContact();
		pageConfirmation();

	}

	private void landingPage() throws BusinessException, InterruptedException {
		String getSaveOption = test.getData(XL_KTAWebPage.SAVE_NOW);
		if (getSaveOption.equalsIgnoreCase("SaveNowTop")) {
			test.script(CLICK_BUTTON, OR_KTAWebPage.BTN_SAVE_NOW_TOP, "");
		} else if (getSaveOption.equalsIgnoreCase("SelectTop")) {
			test.script(CLICK_BUTTON, OR_KTAWebPage.BTN_TXT_TOP, "");
		} else if (getSaveOption.equalsIgnoreCase("SaveNowCenter")) {
			test.script(CLICK_BUTTON, OR_KTAWebPage.BTN_SAVE_NOW_CENTER, "");
		} else if (getSaveOption.equalsIgnoreCase("SelectCenter")) {
			test.script(CLICK_BUTTON, OR_KTAWebPage.BTN_TXT_CENTER, "");
		} else if (getSaveOption.equalsIgnoreCase("SaveNowBottom")) {
			test.script(CLICK_BUTTON, OR_KTAWebPage.BTN_SAVE_NOW_BOTTOM, "");
		} else {
			test.script(CLICK_BUTTON, OR_KTAWebPage.BTN_TXT_BOTTOM, "");
		}
	}

	private void informationCustomer() throws BusinessException, InterruptedException {

		int getAgeList = test.getCount(OR_KTAWebPage.TOTAL_AGE_RANGE);
		test.reportMessage("Total Age List : " + (getAgeList - 1), false);

		for (int startAge = 2; startAge <= getAgeList; startAge++) {
			String[] replaceAge = test.replaceXpath(OR_KTAWebPage.LBL_AGE_RANGE, startAge);
			String getAgeTxt = test.getTextFromElement(replaceAge);
			test.reportMessage("Age Range " + (startAge - 1) + ": " + getAgeTxt, false);
		}
		test.script(SELECT_LIST, OR_KTAWebPage.WLS_AGE_RANGE, XL_KTAWebPage.AGE);
		String getGender = test.getData(XL_KTAWebPage.GENDER);
		if (getGender.equalsIgnoreCase("Male")) {
			test.script(CLICK_BUTTON, OR_KTAWebPage.RDO_GENDER_MALE, "");
		} else {
			test.script(CLICK_BUTTON, OR_KTAWebPage.RDO_GENDER_FEMALE, "");
		}
		// next button
	}

	private void informationContact() throws BusinessException, InterruptedException {
		test.script(TYPE, OR_KTAWebPage.TXT_NAME, XL_KTAWebPage.NAME);

		generatePhoneNumber = "080" + GenericUtil.getRandomNumber();
		generic_NANA.writeToExcel(XL_GenericSheets.SHEET_WRITE_TO_EXCEL, XL_WriteToExcel.LEADS_PHONE,
				generatePhoneNumber);
		test.script(TYPE, OR_KTAWebPage.TXT_PHONE, XL_WriteToExcel.LEADS_PHONE);
		// next
	}

	private void pageConfirmation() throws BusinessException, InterruptedException {
		test.isExists(OR_KTAWebPage.LBL_RABBIT_THANK_YOU);
	}

}

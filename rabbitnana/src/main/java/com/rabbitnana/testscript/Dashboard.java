package com.rabbitnana.testscript;

import com.automation.framework.applib.FunctionsApplib;
import com.automation.framework.beans.TestWareBean;
import com.automation.framework.exception.BusinessException;
import com.automation.framework.util.Test;
import com.rabbitbase.excelcolumns.XL_GenericNANA;
import com.rabbitbase.generic.Generic_NANA;
import com.rabbitnana.excelcolumns.XL_Leads;
import com.rabbitnana.excelcolumns.XL_WriteToExcel;
import com.rabbitnana.objectrepository.OR_Dashboard;
import com.rabbitnana.objectrepository.OR_Leads;

public class Dashboard extends FunctionsApplib {

	private Generic_NANA genericNANA;

	public Dashboard(TestWareBean testWareBean, Test test) throws BusinessException {
		super(testWareBean, test);
		genericNANA = Generic_NANA.getInstance(testWareBean, test);
	}

	@Override
	protected String getSheetName() {
		return null;
	}

	public void validateLeadDashboard() throws BusinessException, InterruptedException {

		if (!test.isPresent(OR_Dashboard.LBL_DASHBOARD_TAB)) {
			clickOnLeadFileBtn();
		}

		test.script(CLICK_BUTTON, OR_Dashboard.LBL_DASHBOARD_TAB, "");
		String actualCustomerPhone = test.getTextFromElement(OR_Dashboard.LBL_DASHBOARD_PHONE);
		String expectedCustomerPhone = test.getData(XL_WriteToExcel.LEADS_PHONE);
		test.comparisonResult(expectedCustomerPhone, actualCustomerPhone, "Dashboard - Customer Phone");

		if (test.getData(XL_Leads.LEAD_OPPORTUNITY).equals("Lead")) {
			String actualOrderID = test.getTextFromElement(OR_Dashboard.LBL_DASHBOARD_ORDER_ID);
			String expectedOrderID = test.getData(XL_WriteToExcel.LEADS_ORDER_ID);
			test.comparisonResult(expectedOrderID, actualOrderID, "Dashboard - Order ID");
		} else {
			String actualOrderID = test.getTextFromElement(OR_Dashboard.LBL_DASHBOARD_ORDER_ID);
			genericNANA.writeToExcel(XL_GenericNANA.SHEET_WRITE_TO_EXCEL, XL_WriteToExcel.LEADS_ORDER_ID,
					actualOrderID);
			test.reportMessage("Order ID : " + actualOrderID, false);
		}

		if (test.isExists(OR_Dashboard.BTN_DASHBOARD_CALL)) {
			test.reportMessage("Call button exist", false);
		}

		if (!test.getData(XL_Leads.NOTE_EVENT).isEmpty()) {
			test.script(TYPE, OR_Dashboard.TXT_NOTE_EVENT, XL_Leads.NOTE_EVENT);
			test.script(CLICK_BUTTON, OR_Dashboard.BTN_SAVE_NOTE_EVENT, "");
		}
		noteEventFlags();
		test.script(CLICK_BUTTON, OR_Dashboard.LBL_DASHBOARD_TAB, "");
	}

	protected void validateSalesDashboard() throws BusinessException, InterruptedException {

		test.script(CLICK_BUTTON, OR_Dashboard.LBL_DASHBOARD_TAB, "");

		if (test.isExists(OR_Dashboard.BTN_DASHBOARD_CALL)) {
			test.reportMessage("Call button exist", false);
		}

		if (!test.getData(XL_Leads.NOTE_EVENT).isEmpty()) {
			test.script(TYPE, OR_Dashboard.TXT_NOTE_EVENT, XL_Leads.NOTE_EVENT);
			test.script(CLICK_BUTTON, OR_Dashboard.BTN_SAVE_NOTE_EVENT, "");
		}
		noteEventFlags();
		test.script(CLICK_BUTTON, OR_Dashboard.LBL_DASHBOARD_TAB, "");
	}

	protected void validateHelpDeskDashboard() throws BusinessException, InterruptedException {

		test.script(CLICK_BUTTON, OR_Dashboard.BTN_DASHBOARD_TAB_HELPDESK, "");

		if (test.isExists(OR_Dashboard.BTN_DASHBOARD_CALL_HELPDESK)) {
			test.reportMessage("Call button exist", false);
		}

		if (!test.getData(XL_Leads.NOTE_EVENT).isEmpty()) {
			test.script(TYPE, OR_Dashboard.TXT_NOTE_EVENT, XL_Leads.NOTE_EVENT);
			test.script(CLICK_BUTTON, OR_Dashboard.BTN_SAVE_NOTE_EVENT, "");
		}
		noteEventFlags();
		test.script(CLICK_BUTTON, OR_Dashboard.BTN_DASHBOARD_TAB_HELPDESK, "");
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

	protected void clickOnLeadFileBtn() throws BusinessException, InterruptedException {

		int getTotalOrder = test.getCount(OR_Leads.TOTAL_ORDER_ID);
		for (int startOrder = 2; startOrder <= getTotalOrder; startOrder++) {
			String replaceXpath_OrderID[] = test.replaceXpath(OR_Leads.LBL_ORDER_ID, startOrder);
			String getOrderID = test.getTextFromElement(replaceXpath_OrderID);
			String expectedOrderID = test.getData(XL_WriteToExcel.LEADS_ORDER_ID);
			if (getOrderID.equals(expectedOrderID)) {
				String replaceXpath_File[] = test.replaceXpath(OR_Leads.BTN_LEAD_FILE, startOrder);
				test.script(CLICK_BUTTON, replaceXpath_File, "");
				break;
			}
		}
	}

}

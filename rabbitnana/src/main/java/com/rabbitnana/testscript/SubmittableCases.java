package com.rabbitnana.testscript;

import com.automation.framework.applib.FunctionsApplib;
import com.automation.framework.beans.TestWareBean;
import com.automation.framework.exception.BusinessException;
import com.automation.framework.util.Test;
import com.rabbitbase.constants.NANA_Constants;
import com.rabbitbase.excelcolumns.XL_GenericSheets;
import com.rabbitbase.generic.Generic_NANA;
import com.rabbitnana.excelcolumns.XL_WriteToExcel;
import com.rabbitnana.objectrepository.OR_Dashboard;
import com.rabbitnana.objectrepository.OR_SubmittableCases;

public class SubmittableCases extends FunctionsApplib {

	private Generic_NANA genericNANA;

	public SubmittableCases(TestWareBean testWareBean, Test test) throws BusinessException {
		super(testWareBean, test);
		genericNANA = Generic_NANA.getInstance(testWareBean, test);
	}

	@Override
	protected String getSheetName() {
		return null;
	}

	public void submittableCases() throws BusinessException, InterruptedException {
		genericNANA.menuNANA(NANA_Constants.SUBMITTABLE_CASES);
		clickOnLeadFileBtn();
		downloadCoverNote();
		clickInsurerAccepted();
	}

	private void clickOnLeadFileBtn() throws BusinessException, InterruptedException {

		int getTotalOrder = test.getCount(OR_SubmittableCases.TOTAL_ORDER_ID);
		String expectedOrderID = test.getData(2, XL_GenericSheets.SHEET_WRITE_TO_EXCEL, XL_WriteToExcel.LEADS_ORDER_ID);

		for (int startOrder = 2; startOrder <= getTotalOrder; startOrder++) {
			String[] replaceXpath_OrderID = test.replaceXpath(OR_SubmittableCases.LBL_ORDER_ID, startOrder);
			String getOrderID = test.getTextFromElement(replaceXpath_OrderID);
			if (getOrderID.equals(expectedOrderID)) {
				String replaceXpath_File[] = test.replaceXpath(OR_SubmittableCases.BTN_LEAD_FILE, startOrder);
				test.script(CLICK_BUTTON, replaceXpath_File, "");
				break;
			}
		}
	}

	private void downloadCoverNote() throws BusinessException, InterruptedException {
		test.script(CLICK_BUTTON, OR_SubmittableCases.BTN_COVER_NOTE, "");
		test.script(CLICK_BUTTON, OR_SubmittableCases.BTN_COVER_NOTE_ACTIVE, "");
		test.script(CLICK_BUTTON, OR_SubmittableCases.BTN_SEND_COVER_NOTE_EN, "");
		test.script(CLICK_BUTTON, OR_SubmittableCases.BTN_COVER_NOTE_SUBMIT, "");
	}

	private void clickInsurerAccepted() throws BusinessException, InterruptedException {
		test.script(CLICK_BUTTON, OR_SubmittableCases.BTN_DASHBOARD_TAB, "");
		noteEventFlags();
		test.isExists(OR_Dashboard.BTN_DASHBOARD_CALL_HELPDESK);
		test.script(CLICK_BUTTON, OR_SubmittableCases.BTN_INSURER_ACCEPTED, "");
		test.script(CLICK_BUTTON, OR_SubmittableCases.BTN_SEND_PRELIMINARY_EN, "");
		test.script(CLICK_BUTTON, OR_SubmittableCases.BTN_SUBMIT_PRELIMINARY_INVOICE, "");
		Thread.sleep(2000);
		String getPreliminarySuccessMessage = test
				.getTextFromElement(OR_SubmittableCases.LBL_PRELIMINARY_SUCCESS_MESSAGE);
		test.reportMessage(getPreliminarySuccessMessage, false);

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
				if (getFlagText.contains("Cover note generated")) {
					test.reportMessage("Note Event Flag : " + getFlagText, false);
					break;
				}
			}
		}
	}

}

package com.rabbitnana.testscript;

import com.automation.framework.applib.FunctionsApplib;
import com.automation.framework.beans.TestWareBean;
import com.automation.framework.exception.BusinessException;
import com.automation.framework.util.Test;
import com.rabbitbase.constants.NANA_Constants;
import com.rabbitbase.excelcolumns.XL_GenericNANA;
import com.rabbitbase.generic.Generic_NANA;
import com.rabbitnana.excelcolumns.XL_WriteToExcel;
import com.rabbitnana.objectrepository.OR_Accouting;

public class Accounting extends FunctionsApplib {

	private Generic_NANA genericNANA;

	public Accounting(TestWareBean testWareBean, Test test) throws BusinessException {
		super(testWareBean, test);
		genericNANA = Generic_NANA.getInstance(testWareBean, test);
	}

	@Override
	protected String getSheetName() {
		return null;
	}

	public void accoutingProcess() throws BusinessException, InterruptedException {
		genericNANA.menuNANA(NANA_Constants.ACCOUNTING);
		accoutingCloseOrder();

	}

	private void accoutingCloseOrder() throws BusinessException, InterruptedException {

		int getTotalOrder = test.getCount(OR_Accouting.TOTAL_ORDER_ID);
		String expectedOrderID = test.getData(2, XL_GenericNANA.SHEET_WRITE_TO_EXCEL, XL_WriteToExcel.LEADS_ORDER_ID);

		for (int startOrder = 2; startOrder <= getTotalOrder; startOrder++) {
			String[] replaceXpath_OrderID = test.replaceXpath(OR_Accouting.LBL_ORDER_ID, startOrder);
			String getOrderID = test.getTextFromElement(replaceXpath_OrderID);
			if (getOrderID.equals(expectedOrderID)) {
				String[] replaceXpath_Checkbox = test.replaceXpath(OR_Accouting.CHB_ORDER_CHECK, startOrder);
				test.script(CLICK_BUTTON, replaceXpath_Checkbox, "");
				test.script(CLICK_BUTTON, OR_Accouting.BTN_CLOSE_ORDER, "");
				test.script(CLICK_BUTTON, OR_Accouting.BTN_CONFIRM_SUCCESS, "");
				break;
			}
		}
	}

}

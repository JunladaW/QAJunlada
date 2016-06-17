package com.rabbitnana.testscript;

import org.openqa.selenium.By;

import com.automation.framework.applib.FunctionsApplib;
import com.automation.framework.beans.TestWareBean;
import com.automation.framework.exception.BusinessException;
import com.automation.framework.util.Test;
import com.rabbitbase.constants.NANA_Constants;
import com.rabbitbase.excelcolumns.XL_GenericNANA;
import com.rabbitbase.generic.Generic_NANA;
import com.rabbitnana.excelcolumns.XL_Shipments;
import com.rabbitnana.excelcolumns.XL_WriteToExcel;
import com.rabbitnana.objectrepository.OR_Shipments;

public class Shipments extends FunctionsApplib {

	private Generic_NANA genericNANA;

	public Shipments(TestWareBean testWareBean, Test test) throws BusinessException {
		super(testWareBean, test);
		genericNANA = Generic_NANA.getInstance(testWareBean, test);
	}

	@Override
	protected String getSheetName() {
		return null;
	}

	public void shipments() throws BusinessException, InterruptedException {
		genericNANA.menuNANA(NANA_Constants.SHIPMENTS);
		sendShipment();

	}

	private void sendShipment() throws BusinessException, InterruptedException {
		test.setSheetName(XL_GenericNANA.SHEET_NANA_SHIPMENTS);
		int getTotalOrder = test.getCount(OR_Shipments.TOTAL_ORDER_ID);
		String expectedOrderID = test.getData(2, XL_GenericNANA.SHEET_WRITE_TO_EXCEL, XL_WriteToExcel.LEADS_ORDER_ID);

		for (int startOrder = 2; startOrder <= getTotalOrder; startOrder++) {
			String[] replaceXpath_OrderID = test.replaceXpath(OR_Shipments.LBL_ORDER_ID, startOrder);
			String getOrderID = test.getTextFromElement(replaceXpath_OrderID);
			if (getOrderID.equals(expectedOrderID)) {
				/*
				 * Get data order id from Form to choose the appropriate
				 * Shipment
				 */
				String[] replaceXpath_DataOrderID = test.replaceXpath(OR_Shipments.LBL_DATA_ORDER_ID, startOrder);
				String getDataOrderID = test.getAttributeValue(replaceXpath_DataOrderID, "data-order-id");

				String[] replaceXpath_TrackingCode = test.replaceXpath(OR_Shipments.TXT_TRACKING_CODE, getDataOrderID);
				test.script(TYPE, replaceXpath_TrackingCode, XL_Shipments.TRACKING_CODE);

				String[] replaceXpath_ShipmentMethod = test.replaceXpath(OR_Shipments.WLS_SHIPMENT_METHOD,
						getDataOrderID);
				testWareBean.getWebDriver().findElement(By.xpath(replaceXpath_ShipmentMethod[0]))
						.sendKeys("Post office");

				String[] replaceXpath_Save = test.replaceXpath(OR_Shipments.BTN_SAVE_SHIPMENT, getDataOrderID);
				test.script(CLICK_BUTTON, replaceXpath_Save, "");
				test.script(CLICK_BUTTON, OR_Shipments.BTN_CONFIRM_SUCCESS, "");
				break;
			}
		}
	}

}

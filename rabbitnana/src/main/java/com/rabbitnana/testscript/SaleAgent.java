package com.rabbitnana.testscript;

import org.openqa.selenium.By;

import com.automation.framework.applib.FunctionsApplib;
import com.automation.framework.beans.TestWareBean;
import com.automation.framework.exception.BusinessException;
import com.automation.framework.util.Test;
import com.rabbitbase.excelcolumns.XL_GenericNANA;
import com.rabbitnana.excelcolumns.XL_SalesAgent;
import com.rabbitnana.excelcolumns.XL_WriteToExcel;
import com.rabbitnana.objectrepository.OR_SalesAgent;

public class SaleAgent extends FunctionsApplib {

	public SaleAgent(TestWareBean testWareBean, Test test) throws BusinessException {
		super(testWareBean, test);
	}

	@Override
	protected String getSheetName() {
		return XL_GenericNANA.SHEET_NANA_SALES;
	}

	public void searchSalesListView() throws BusinessException, InterruptedException {
		int totalLeadsOppo = test.getCount(OR_SalesAgent.TOTAL_LIST);
		test.reportMessage("Total Leads and Opportunities are " + totalLeadsOppo, false);

		String searchBY = test.getData(XL_SalesAgent.SALE_SEARCH_BY);

		if (searchBY.equals("Name") || searchBY.equals("Email")) {

			test.script(CLEAR_TYPE, OR_SalesAgent.WED_SEARCH, XL_SalesAgent.SALE_SEARCH);
			totalLeadsOppo = test.getCount(OR_SalesAgent.TOTAL_LIST_AFTER_SEARCH);
			test.reportMessage("Total Match found " + totalLeadsOppo, false);

			if (totalLeadsOppo != 0) {

				for (int startLeadOppo = 1; startLeadOppo <= totalLeadsOppo; startLeadOppo++) {
					String getAtt = testWareBean.getWebDriver()
							.findElement(By.xpath("//tr[@class='opportunity-row lead-opp-row'][" + startLeadOppo + "]"))
							.getAttribute("data-short-id");
					String getName = testWareBean.getWebDriver()
							.findElement(By
									.xpath("//*[@id='left-content']/div[2]/table/tbody/tr[not(contains(@class,'hidden')) and contains(.,'"
											+ getAtt + "')]/td[3]"))
							.getText();
					test.reportMessage("Customer Name of the Lead -- '" + getName + "'", false);
				}
			} else {
				test.reportMessage("No Matches Found", false);
			}

		} else {
			String getOrderID = test.getData(2, XL_GenericNANA.SHEET_WRITE_TO_EXCEL, XL_WriteToExcel.LEADS_ORDER_ID);
			test.script(CLEAR_TYPE, OR_SalesAgent.WED_SEARCH, XL_WriteToExcel.LEADS_ORDER_ID, getOrderID);
			totalLeadsOppo = test.getCount(OR_SalesAgent.TOTAL_LIST_AFTER_SEARCH);
			test.reportMessage("Total Match found " + totalLeadsOppo, false);

			if (totalLeadsOppo != 0) {
				String getName = test.getTextFromElement(OR_SalesAgent.SEARCH_BY_ORDER_ID);
				test.reportMessage("Order ID is -- '" + getName + "'", false);
				testWareBean.getWebDriver().navigate().refresh();
				test.script(CLICK_BUTTON, OR_SalesAgent.SEARCH_BY_ORDER_ID, "");
			} else {
				test.reportMessage("No Matches Found", false);
			}
		}
	}

}

package com.rabbitnana.testcase.salesagent;

import org.testng.annotations.Test;

import com.automation.framework.exception.BusinessException;
import com.rabbitbase.constants.NANA_Constants;
import com.rabbitbase.generic.BaseClass;
import com.rabbitbase.generic.Generic_NANA;
import com.rabbitnana.testscript.SaleAgent;

public class Search_SalesAgent_0001 extends BaseClass {

	@Override
	protected String getConfigPath() throws BusinessException {
		return "framework";
	}

	@Override
	protected String getTestDataFile() throws BusinessException {
		return "Rabbit_Nana.xls";
	}

	@Test(groups = { "SALES_AGENT" })
	public void login_NANA() throws BusinessException, InterruptedException {
		setExcelRow(2);
		Generic_NANA nanaLogin = new Generic_NANA(testWareBean, test);
		nanaLogin.loginNANA(NANA_Constants.SALES_AGENT);
		executeScript(nanaLogin);
	}

	@Test(dependsOnMethods = { "login_NANA" }, groups = { "SALES_AGENT" })
	public void searchSaleAgent_NameEmail() throws BusinessException, InterruptedException {
		setExcelRow(2);
		SaleAgent search = new SaleAgent(testWareBean, test);
		search.searchSalesListView();
		executeScript(search);
	}

	@Test(dependsOnMethods = { "searchSaleAgent_NameEmail" }, groups = { "SALES_AGENT" })
	public void searchSaleAgent_OrderID() throws BusinessException, InterruptedException {
		setExcelRow(3);
		SaleAgent search = new SaleAgent(testWareBean, test);
		search.searchSalesListView();
		executeScript(search);
	}

	@Test(dependsOnMethods = { "searchSaleAgent_OrderID" }, groups = { "SALES_AGENT" })
	public void searchSaleAgent_OrderID_NotExist() throws BusinessException, InterruptedException {
		setExcelRow(4);
		SaleAgent search = new SaleAgent(testWareBean, test);
		search.searchSalesListView();
		executeScript(search);
	}

	@Test(dependsOnMethods = { "searchSaleAgent_OrderID_NotExist" }, groups = { "SALES_AGENT" })
	public void searchSaleAgent_Email() throws BusinessException, InterruptedException {
		setExcelRow(5);
		SaleAgent search = new SaleAgent(testWareBean, test);
		search.searchSalesListView();
		executeScript(search);
	}

}

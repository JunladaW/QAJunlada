package com.rabbitnana.testcase.inboundandhelpdesk;

import org.testng.annotations.Test;

import com.automation.framework.exception.BusinessException;
import com.rabbitbase.constants.NANA_Constants;
import com.rabbitbase.generic.BaseClass;
import com.rabbitbase.generic.Generic_NANA;
import com.rabbitnana.testscript.SubmittableCases;

public class Search_OrderID_0002 extends BaseClass {

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
		nanaLogin.loginNANA(NANA_Constants.SUBMITTABLE_CASES);
		executeScript(nanaLogin);
	}

	@Test(dependsOnMethods = { "login_NANA" }, groups = { "SALES_AGENT" })
	public void search_OrderID() throws BusinessException, InterruptedException {
		setExcelRow(2);
		SubmittableCases search = new SubmittableCases(testWareBean, test);
		search.submittableCases();
		executeScript(search);
	}

}

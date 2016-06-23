package com.rabbitcigna.testcase.cignatravel;

import org.testng.annotations.Test;

import com.automation.framework.exception.BusinessException;
import com.rabbitbase.generic.BaseClass;
import com.rabbitcigna.testscript.CignaTravelNana;

public class CignaTravel_007_CreatedDateFilter extends BaseClass {

	@Override
	protected String getConfigPath() throws BusinessException {
		return "framework";
	}

	@Override
	protected String getTestDataFile() throws BusinessException {
		return "CignaTravel.xls";
	}

	@Test(groups = { "CIGNA_LEADS" })
	public void loginNANA() throws BusinessException, InterruptedException {
		setExcelRow(2);
		CignaTravelNana cigna = new CignaTravelNana(testWareBean, test);
		cigna.loginNANA();
		executeScript(cigna);
	}

	@Test(dependsOnMethods = { "loginNANA" }, groups = { "CIGNA_LEADS" })
	public void cignaLeadNANA() throws BusinessException, InterruptedException {
		setExcelRow(2);
		CignaTravelNana filterByDate = new CignaTravelNana(testWareBean, test);
		filterByDate.searchCreatedDate();
		executeScript(filterByDate);
	}

}

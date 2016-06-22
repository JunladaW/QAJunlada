package com.rabbitcigna.testcase.cignatravel;

import org.testng.annotations.Test;

import com.automation.framework.exception.BusinessException;
import com.rabbitbase.generic.BaseClass;
import com.rabbitcigna.testscript.CignaTravelNana;
import com.rabbitcigna.testscript.CignaTravelWebPage;

public class CignaTravel_005_Lead_SaveFromBottomButton extends BaseClass {

	@Override
	protected String getConfigPath() throws BusinessException {
		return "framework";
	}

	@Override
	protected String getTestDataFile() throws BusinessException {
		return "CignaTravel.xls";
	}

	@Test(groups = { "CIGNA_LEADS" })
	public void cignaLeadWebpage() throws BusinessException, InterruptedException {
		setExcelRow(6);
		CignaTravelWebPage cigna = new CignaTravelWebPage(testWareBean, test);
		cigna.cignaTravelWeb();
		executeScript(cigna);
	}

	@Test(dependsOnMethods = { "cignaLeadWebpage" }, groups = { "CIGNA_LEADS" })
	public void loginNANA() throws BusinessException, InterruptedException {
		setExcelRow(2);
		CignaTravelNana cigna = new CignaTravelNana(testWareBean, test);
		cigna.loginNANA();
		executeScript(cigna);
	}

	@Test(dependsOnMethods = { "loginNANA" }, groups = { "CIGNA_LEADS" })
	public void cignaLeadNANA() throws BusinessException, InterruptedException {
		setExcelRow(6);
		CignaTravelNana cigna = new CignaTravelNana(testWareBean, test);
		cigna.cignaTravelNANA();
		executeScript(cigna);
	}

}

package com.rabbitkrungthaiaxa.testcase.leads;

import org.testng.annotations.Test;

import com.automation.framework.exception.BusinessException;
import com.rabbitbase.generic.BaseClass;

public class KTA_004_LeadCreation_SaveFromSelectCenter extends BaseClass {

	@Override
	protected String getConfigPath() throws BusinessException {
		return "framework";
	}

	@Override
	protected String getTestDataFile() throws BusinessException {
		return "MTLS.xls";
	}

	@Test(groups = { "MTLS_LEADS" })
	public void cignaLeadWebpage() throws BusinessException, InterruptedException {
		setExcelRow(5);
		/*
		 * MTLSWebPage leadCreation = new MTLSWebPage(testWareBean, test);
		 * leadCreation.webMTLS(); executeScript(leadCreation);
		 */
	}

	@Test(dependsOnMethods = { "cignaLeadWebpage" }, groups = { "MTLS_LEADS" })
	public void loginNANA() throws BusinessException, InterruptedException {
		setExcelRow(2);
		/*
		 * MTLSNANA leadCreation = new MTLSNANA(testWareBean, test);
		 * leadCreation.loginNANA(); executeScript(leadCreation);
		 */
	}

	@Test(dependsOnMethods = { "loginNANA" }, groups = { "MTLS_LEADS" })
	public void leadsMTLSNANA() throws BusinessException, InterruptedException {
		setExcelRow(5);
		/*
		 * MTLSNANA leadCreation = new MTLSNANA(testWareBean, test);
		 * leadCreation.nanaMTLS(); executeScript(leadCreation);
		 */
	}

}

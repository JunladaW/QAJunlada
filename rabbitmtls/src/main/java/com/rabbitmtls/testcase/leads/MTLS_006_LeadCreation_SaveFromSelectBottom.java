package com.rabbitmtls.testcase.leads;

import org.testng.annotations.Test;

import com.automation.framework.exception.BusinessException;
import com.rabbitbase.generic.BaseClass;
import com.rabbitmtls.testscript.MTLSNANA;
import com.rabbitmtls.testscript.MTLSWebPage;

public class MTLS_006_LeadCreation_SaveFromSelectBottom extends BaseClass {

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
		setExcelRow(6);
		MTLSWebPage leadCreation = new MTLSWebPage(testWareBean, test);
		leadCreation.webMTLS();
		executeScript(leadCreation);
	}

	@Test(dependsOnMethods = { "cignaLeadWebpage" }, groups = { "MTLS_LEADS" })
	public void loginNANA() throws BusinessException, InterruptedException {
		setExcelRow(2);
		MTLSNANA leadCreation = new MTLSNANA(testWareBean, test);
		leadCreation.loginNANA();
		executeScript(leadCreation);
	}

	@Test(dependsOnMethods = { "loginNANA" }, groups = { "MTLS_LEADS" })
	public void leadsMTLSNANA() throws BusinessException, InterruptedException {
		setExcelRow(6);
		MTLSNANA leadCreation = new MTLSNANA(testWareBean, test);
		leadCreation.nanaMTLS();
		executeScript(leadCreation);
	}

}

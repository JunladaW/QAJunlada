package com.rabbitkrungthaiaxa.testcase.leads;

import org.testng.annotations.Test;

import com.automation.framework.exception.BusinessException;
import com.rabbitbase.generic.BaseClass;

public class KTA_008_Lead_Filter_CreatedDateWithFuture extends BaseClass {

	@Override
	protected String getConfigPath() throws BusinessException {
		return "framework";
	}

	@Override
	protected String getTestDataFile() throws BusinessException {
		return "MTLS.xls";
	}

	@Test(groups = { "MTLS_LEADS" })
	public void loginNANA() throws BusinessException, InterruptedException {
		setExcelRow(2);
		/*
		 * MTLSNANA leadCreation = new MTLSNANA(testWareBean, test);
		 * leadCreation.loginNANA(); executeScript(leadCreation);
		 */
	}

	@Test(dependsOnMethods = { "loginNANA" }, groups = { "MTLS_LEADS" })
	public void leadsMTLSNANA() throws BusinessException, InterruptedException {
		setExcelRow(3);
		/*
		 * MTLSNANA leadCreation = new MTLSNANA(testWareBean, test);
		 * leadCreation.searchCreatedDate(); executeScript(leadCreation);
		 */
	}

}

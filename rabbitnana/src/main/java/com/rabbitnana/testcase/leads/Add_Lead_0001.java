package com.rabbitnana.testcase.leads;

import org.testng.annotations.Test;

import com.automation.framework.exception.BusinessException;
import com.rabbitbase.constants.NANA_Constants;
import com.rabbitbase.generic.BaseClass;
import com.rabbitbase.generic.Generic_NANA;
import com.rabbitnana.testscript.Leads;

public class Add_Lead_0001 extends BaseClass {

	@Override
	protected String getConfigPath() throws BusinessException {
		return "framework";
	}

	@Override
	protected String getTestDataFile() throws BusinessException {
		return "Rabbit_Nana.xls";
	}

	@Test(groups = { "LEADS" })
	public void login_NANA() throws BusinessException, InterruptedException {
		setExcelRow(2);
		Generic_NANA nanaLogin = new Generic_NANA(testWareBean, test);
		nanaLogin.loginNANA(NANA_Constants.LEADS);
		executeScript(nanaLogin);
	}

	@Test(dependsOnMethods = { "login_NANA" }, groups = { "SALES_AGENT" })
	public void createLead_EN_Language() throws BusinessException, InterruptedException {
		setExcelRow(2);
		Leads createLead = new Leads(testWareBean, test);
		createLead.createLead();
		executeScript(createLead);
	}

	@Test(dependsOnMethods = { "createLead_EN_Language" }, groups = { "SALES_AGENT" })
	public void createLead_TH_Language() throws BusinessException, InterruptedException {
		setExcelRow(3);
		Leads createLead = new Leads(testWareBean, test);
		createLead.createLead();
		executeScript(createLead);
	}

	@Test(dependsOnMethods = { "createLead_TH_Language" }, groups = { "SALES_AGENT" })
	public void createLead_NewSource() throws BusinessException, InterruptedException {
		setExcelRow(4);
		Leads createLead = new Leads(testWareBean, test);
		createLead.createLead();
		executeScript(createLead);
	}

	@Test(dependsOnMethods = { "createLead_NewSource" }, groups = { "SALES_AGENT" })
	public void createLead_CampaignNumber() throws BusinessException, InterruptedException {
		setExcelRow(5);
		Leads createLead = new Leads(testWareBean, test);
		createLead.createLead();
		executeScript(createLead);
	}
}

package com.rabbitnana.testcase.leads;

import org.testng.annotations.Test;

import com.automation.framework.exception.BusinessException;
import com.rabbitbase.constants.NANA_Constants;
import com.rabbitbase.generic.BaseClass;
import com.rabbitbase.generic.Generic_NANA;
import com.rabbitnana.testscript.Leads;


public class Add_Opportunity_0002 extends BaseClass {

	@Override
	protected String getConfigPath() throws BusinessException {
		return "framework";
	}
	
	@Override
	protected String getTestDataFile() throws BusinessException {
		return "Rabbit_Nana.xls";
	}
	
	@Test(groups = {"LEADS"})
	public void login_NANA() throws BusinessException, InterruptedException {
		setExcelRow(2);
		Generic_NANA nanaLogin = new Generic_NANA(testWareBean, test);
		nanaLogin.loginNANA(NANA_Constants.LEADS);
		executeScript(nanaLogin);
	}
	
	@Test(dependsOnMethods={"login_NANA"}, groups = {"SALES_AGENT"})
	public void createOpportunity_ExistingSource() throws BusinessException, InterruptedException {
		setExcelRow(6);
		Leads createOpportunity = new Leads(testWareBean, test);
		createOpportunity.createOpportunity();
		executeScript(createOpportunity);
	}
	
	@Test(dependsOnMethods={"createOpportunity_ExistingSource"}, groups = {"SALES_AGENT"})
	public void createOpportunity_NewSource() throws BusinessException, InterruptedException {
		setExcelRow(7);
		Leads createOpportunity = new Leads(testWareBean, test);
		createOpportunity.createOpportunity();
		executeScript(createOpportunity);
	}
	
	@Test(dependsOnMethods={"createOpportunity_NewSource"}, groups = {"SALES_AGENT"})
	public void createOpportunity_CampaignNumber() throws BusinessException, InterruptedException {
		setExcelRow(8);
		Leads createOpportunity = new Leads(testWareBean, test);
		createOpportunity.createOpportunity();
		executeScript(createOpportunity);
	}

}

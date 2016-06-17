package com.rabbitnana.testcase.inboundandhelpdesk;

import org.testng.annotations.Test;

import com.automation.framework.exception.BusinessException;
import com.rabbitbase.constants.NANA_Constants;
import com.rabbitbase.generic.BaseClass;
import com.rabbitbase.generic.Generic_NANA;
import com.rabbitnana.testscript.Accounting;
import com.rabbitnana.testscript.InboundAndHelpdesk;
import com.rabbitnana.testscript.Leads;
import com.rabbitnana.testscript.SaleAgent;
import com.rabbitnana.testscript.Shipments;
import com.rabbitnana.testscript.SubmittableCases;
import com.rabbitnana.testscript.TabInfo;

public class Sale_AfterBuy_Without_Discount_0002 extends BaseClass {

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
		nanaLogin.loginNANA(NANA_Constants.LEADS);
		executeScript(nanaLogin);
	}

	@Test(dependsOnMethods = { "login_NANA" }, groups = { "SALES_AGENT" })
	public void createLead_AssignToAgent() throws BusinessException, InterruptedException {
		setExcelRow(9);
		Leads createLead = new Leads(testWareBean, test);
		createLead.createLead();
		executeScript(createLead);
	}

	@Test(dependsOnMethods = { "createLead_AssignToAgent" }, groups = { "SALES_AGENT" })
	public void login_SaleAgent() throws BusinessException, InterruptedException {
		setExcelRow(2);
		Generic_NANA nanaLogin = new Generic_NANA(testWareBean, test);
		nanaLogin.reLoginNANA(NANA_Constants.SALES_AGENT);
		executeScript(nanaLogin);
	}

	@Test(dependsOnMethods = { "login_SaleAgent" }, groups = { "SALES_AGENT" })
	public void searchSaleAgent_OrderID() throws BusinessException, InterruptedException {
		setExcelRow(3);
		SaleAgent search = new SaleAgent(testWareBean, test);
		search.searchSalesListView();
		executeScript(search);
	}

	@Test(dependsOnMethods = { "searchSaleAgent_OrderID" }, groups = { "SALES_AGENT" })
	public void fillSaleInfomation() throws Exception {
		setExcelRow(2);
		TabInfo fillSaleInfo = new TabInfo(testWareBean, test);
		fillSaleInfo.fillSalesInfo();
		executeScript(fillSaleInfo);
	}

	@Test(dependsOnMethods = { "fillSaleInfomation" }, groups = { "SALES_AGENT" })
	public void readyToSubmit() throws BusinessException, InterruptedException {
		setExcelRow(2);
		InboundAndHelpdesk readyToSubmit = new InboundAndHelpdesk(testWareBean, test);
		readyToSubmit.helpdeskAfterCreated();
		executeScript(readyToSubmit);
	}

	@Test(dependsOnMethods = { "readyToSubmit" }, groups = { "SALES_AGENT" })
	public void insurerAccepted() throws BusinessException, InterruptedException {
		setExcelRow(2);
		SubmittableCases submitCoverNote = new SubmittableCases(testWareBean, test);
		submitCoverNote.submittableCases();
		executeScript(submitCoverNote);
	}

	@Test(dependsOnMethods = { "insurerAccepted" }, groups = { "SALES_AGENT" })
	public void shipmentProcess() throws BusinessException, InterruptedException {
		setExcelRow(2);
		Shipments shipments = new Shipments(testWareBean, test);
		shipments.shipments();
		executeScript(shipments);
	}

	@Test(dependsOnMethods = { "shipmentProcess" }, groups = { "SALES_AGENT" })
	public void closeOrder_Accounting() throws BusinessException, InterruptedException {
		setExcelRow(2);
		Accounting closeOrder = new Accounting(testWareBean, test);
		closeOrder.accoutingProcess();
		executeScript(closeOrder);
	}

	@Test(dependsOnMethods = { "closeOrder_Accounting" }, groups = { "SALES_AGENT" })
	public void finalProcessForOrder() throws BusinessException, InterruptedException {
		setExcelRow(2);
		InboundAndHelpdesk checkPaidInsurer = new InboundAndHelpdesk(testWareBean, test);
		checkPaidInsurer.noteEventValidationForInsurerPaid();
		executeScript(checkPaidInsurer);
	}

}
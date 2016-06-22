package com.rabbitnana.testscript;

import org.openqa.selenium.By;

import com.automation.framework.applib.FunctionsApplib;
import com.automation.framework.beans.TestWareBean;
import com.automation.framework.exception.BusinessException;
import com.automation.framework.util.GenericUtil;
import com.automation.framework.util.Test;
import com.rabbitbase.constants.NANA_Constants;
import com.rabbitbase.constants.Project_Constants;
import com.rabbitbase.excelcolumns.XL_GenericSheets;
import com.rabbitbase.generic.Generic_NANA;
import com.rabbitnana.excelcolumns.XL_Leads;
import com.rabbitnana.excelcolumns.XL_WriteToExcel;
import com.rabbitnana.objectrepository.OR_Leads;

public class Leads extends FunctionsApplib {

	String generatePhoneNumber;
	String getPhoneNumber;
	private Generic_NANA genericNANA;
	private Dashboard dashboard;

	public Leads(TestWareBean testWareBean, Test test) throws BusinessException {
		super(testWareBean, test);
		genericNANA = Generic_NANA.getInstance(testWareBean, test);
		dashboard = new Dashboard(testWareBean, test);
	}

	@Override
	protected String getSheetName() {
		return XL_GenericSheets.SHEET_NANA_LEADS;
	}

	public void createLead() throws BusinessException, InterruptedException {

		test.setSheetName(XL_GenericSheets.SHEET_NANA_LEADS);
		test.script(CLICK_BUTTON, OR_Leads.BTN_ADD_LEAD_LISTPAGE, "");

		validateMandatoryLeads();
		enterLeadMandatoryData();

		test.script(CLICK_BUTTON, OR_Leads.BTN_ADD, "");
		test.reportMessage("Order ID: " + getOrderIDFromListPage(), false);

		/* Write to Excel */
		genericNANA.writeToExcel(XL_GenericSheets.SHEET_WRITE_TO_EXCEL, XL_WriteToExcel.LEADS_ORDER_ID,
				getOrderIDFromListPage());

		validateLeadData();
		dashboard.validateLeadDashboard();

		genericNANA.menuNANA(NANA_Constants.LEADS);
		if (!test.getData(XL_Leads.ASSIGNEE).isEmpty()) {
			assignmentLeads();
		}

	}

	public void createOpportunity() throws BusinessException, InterruptedException {

		test.setSheetName(XL_GenericSheets.SHEET_NANA_LEADS);
		test.script(CLICK_BUTTON, OR_Leads.BTN_ADD_LEAD_LISTPAGE, "");
		String getTitle = test.getData(XL_Leads.LEADS_TITLE);
		if (getTitle.equals("Mr")) {
			test.script(CLICK_BUTTON, OR_Leads.RDO_TITLE_MR, "");
		} else if (getTitle.equals("Ms")) {
			test.script(CLICK_BUTTON, OR_Leads.RDO_TITLE_MS, "");
		} else {
			test.script(CLICK_BUTTON, OR_Leads.RDO_TITLE_MRS, "");
		}
		validateMandatoryOpportunity();

		test.script(TYPE, OR_Leads.TXT_EMAIL, XL_Leads.LEADS_EMAIL);
		test.script(TYPE, OR_Leads.TXT_FIRST_NAME, XL_Leads.LEADS_FIRST_NAME);
		if (!test.getData(XL_Leads.LEADS_LAST_NAME).isEmpty()) {
			test.script(TYPE, OR_Leads.TXT_LAST_NAME, XL_Leads.LEADS_LAST_NAME);
		}

		enterLeadMandatoryData();

		test.script(CLICK_BUTTON, OR_Leads.BTN_ADD, "");

		validateLeadData();
		dashboard.validateLeadDashboard();
		genericNANA.menuNANA(NANA_Constants.LEADS);

	}

	private void enterLeadMandatoryData() throws BusinessException, InterruptedException {
		/* Generate Phone number and write to Excel */
		generatePhoneNumber = "080" + GenericUtil.getRandomNumber();
		genericNANA.writeToExcel(XL_GenericSheets.SHEET_WRITE_TO_EXCEL, XL_WriteToExcel.LEADS_PHONE, generatePhoneNumber);

		test.script(TYPE, OR_Leads.TXT_PHONE, XL_WriteToExcel.LEADS_PHONE);
		test.script(SELECT_LIST, OR_Leads.WLS_SOURCE, XL_Leads.LEADS_SOURCE);
		String isNewSource = test.getData(XL_Leads.LEADS_SOURCE);
		if (isNewSource.equals("New")) {
			test.script(TYPE, OR_Leads.TXT_SOURCE_NAME, XL_Leads.LEADS_SOURCE_NAME);
		}
		test.script(SELECT_LIST, OR_Leads.WLS_LANGUAGE, XL_Leads.LEADS_LANGUAGE);

		enterCampaignNumber();
	}

	private void validateMandatoryLeads() throws BusinessException, InterruptedException {

		String mandatoryPhone = test.getTextFromElement(OR_Leads.LBL_MANDATORY_PHONE);
		String mandatorySource = test.getTextFromElement(OR_Leads.LBL_MANDATORY_SOURCE);
		String mandatorySourceName = test.getTextFromElement(OR_Leads.LBL_MANDATORY_SOURCE_NAME);
		String mandatoryLanguage = test.getTextFromElement(OR_Leads.LBL_MANDATORY_LANGUAGE);

		test.reportMessage("Mandatory Fields for Lead are \n\t" + mandatoryPhone + "\n\t" + mandatorySource + "\n\t"
				+ mandatorySourceName + "\n\t" + mandatoryLanguage, false);
	}

	private void validateMandatoryOpportunity() throws BusinessException, InterruptedException {
		validateMandatoryLeads();
		String mandatoryTitle = test.getTextFromElement(OR_Leads.LBL_MANDATORY_TITLE);
		String mandatoryFirstName = test.getTextFromElement(OR_Leads.LBL_MANDATORY_FIRST_NAME);
		String mandatoryEmail = test.getTextFromElement(OR_Leads.LBL_MANDATORY_EMAIL);
		test.reportMessage("Mandatory Fields for Opportunities are \n\t" + mandatoryTitle + "\n\t" + mandatoryFirstName
				+ "\n\t" + mandatoryEmail, false);
	}

	private String getOrderIDFromListPage() throws BusinessException {
		String getOrder = "";
		int getTotalOrder = test.getCount(OR_Leads.TOTAL_ORDER_ID);

		for (int startOrder = 2; startOrder <= getTotalOrder; startOrder++) {
			String replaceXpath_OrderID[] = test.replaceXpath(OR_Leads.LBL_ORDER_ID, startOrder);
			String replaceXpath_Phone[] = test.replaceXpath(OR_Leads.LBL_PHONE_LIST, startOrder);
			getPhoneNumber = test.getTextFromElement(replaceXpath_Phone);

			if (getPhoneNumber.equals(generatePhoneNumber)) {
				getOrder = test.getTextFromElement(replaceXpath_OrderID);
				break;
			}
		}
		return getOrder;
	}

	private void enterCampaignNumber() throws BusinessException, InterruptedException {
		String isCampaignPhone = test.getData(XL_Leads.IS_CAMPAIGN_PHONE);
		if (isCampaignPhone.equals(Project_Constants.YES)) {
			test.script(CLICK_BUTTON, OR_Leads.WLS_CAMPAIGN_PHONE, "");
			int getTotalList = testWareBean.getWebDriver()
					.findElements(By.xpath("//*[contains(@id,'select2-input-campaign-phone-result-')]")).size();

			for (int i = 1; i <= getTotalList; i++) {
				String expectedCampaignNumber = test.getData(XL_Leads.LEADS_CAMPAIGN_PHONE);
				String getCampaignNumber = testWareBean.getWebDriver()
						.findElement(By.xpath("//span[2]/ul/li[" + i + "]")).getText();
				if (getCampaignNumber.equals(expectedCampaignNumber)) {
					testWareBean.getWebDriver().findElement(By.xpath("//span[2]/ul/li[" + i + "]")).click();
					test.reportMessage("Clicked on Campaign Number " + getCampaignNumber, false);
					break;
				}
			}
		}
	}

	private void validateLeadData() throws BusinessException, InterruptedException {
		if (test.getData(XL_Leads.LEAD_OPPORTUNITY).equals("Lead")) {
			dashboard.clickOnLeadFileBtn();
			hiddenTabs();
		}
		String actualCustomerPhone = test.getTextFromElement(OR_Leads.LBL_LEAD_CUSTOMER_PHONE);
		String expectedCustomerPhone = test.getData(XL_WriteToExcel.LEADS_PHONE);
		test.comparisonResult(expectedCustomerPhone, actualCustomerPhone, "Customer Phone");

		if (!test.getData(XL_Leads.LEAD_OPPORTUNITY).equals("Lead")) {
			String actualCustomerEmail = test.getTextFromElement(OR_Leads.TXT_LEAD_CUSTOMER_EMAIL);
			String expectedCustomerEmail = test.getData(XL_Leads.LEADS_EMAIL);
			test.comparisonResult(expectedCustomerEmail, actualCustomerEmail, "Customer Email");

			String actualCustomerFirstName = test.getTextFromElement(OR_Leads.TXT_LEAD_CUSTOMER_FIRSTNAME);
			String expectedCustomerFirstName = test.getData(XL_Leads.LEADS_FIRST_NAME);
			test.comparisonResult(expectedCustomerFirstName, actualCustomerFirstName, "Customer First Name");
			if (!test.getData(XL_Leads.LEADS_LAST_NAME).isEmpty()) {
				String actualCustomerLastName = test.getTextFromElement(OR_Leads.TXT_LEAD_CUSTOMER_LASTNAME);
				String expectedCustomerLastName = test.getData(XL_Leads.LEADS_LAST_NAME);
				test.comparisonResult(expectedCustomerLastName, actualCustomerLastName, "Customer Last Name");
			}

		}
	}

	private void hiddenTabs() throws BusinessException {
		if (test.isPresent(OR_Leads.TAB_HIDDEN_SHIPPING_ADDRESS)) {
			test.reportMessage("Shipping Address tab is hidden", false);
		}

		if (test.isPresent(OR_Leads.TAB_HIDDEN_DOCS)) {
			test.reportMessage("Docs tab is hidden", false);
		}
	}

	private void assignmentLeads() throws BusinessException, InterruptedException {
		String getOrderID = test.getData(XL_WriteToExcel.LEADS_ORDER_ID);
		int getTotalOrder = test.getCount(OR_Leads.TOTAL_ORDER_ID);

		for (int startOrder = 2; startOrder <= getTotalOrder; startOrder++) {
			String replaceXpath_OrderID[] = test.replaceXpath(OR_Leads.LBL_ORDER_ID, startOrder);
			String actualOrderID = test.getTextFromElement(replaceXpath_OrderID);

			if (getOrderID.equals(actualOrderID)) {
				String[] replaceXpath_Assignee = test.replaceXpath(OR_Leads.WLS_ASSIGNEE, startOrder);
				test.script(SELECT_LIST, replaceXpath_Assignee, XL_Leads.ASSIGNEE);
				test.script(CLICK_BUTTON, OR_Leads.BTN_OK_ASSIGNEE, "");
				break;
			}
		}
	}

}

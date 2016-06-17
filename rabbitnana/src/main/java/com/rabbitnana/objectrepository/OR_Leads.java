package com.rabbitnana.objectrepository;

public class OR_Leads {

	public static final String[] BTN_ADD_LEAD_LISTPAGE = { "//button[@class='btn btn-primary']",
			"Add Lead - List Page" };

	/* Add Lead Popup */
	public static final String[] RDO_TITLE_MR = { "//*[@id='input-title-mr']", "Title - Mr" };
	public static final String[] RDO_TITLE_MS = { "//*[@id='input-title-ms']", "Title - Ms" };
	public static final String[] RDO_TITLE_MRS = { "//*[@id='input-title-mrs']", "Title - Mrs" };
	public static final String[] TXT_FIRST_NAME = { "//*[@id='input-firstname']", "First Name" };
	public static final String[] TXT_LAST_NAME = { "//*[@id='input-lastname']", "Last Name" };
	public static final String[] TXT_EMAIL = { "//*[@id='input-email']", "Email" };
	public static final String[] TXT_PHONE = { "//*[@id='input-phone']", "Phone" };
	public static final String[] WLS_SOURCE = { "//*[@id='input-source']", "Source" };
	public static final String[] TXT_SOURCE_NAME = { "//*[@id='input-new-source']", "Source Name" };
	public static final String[] WLS_LANGUAGE = { "//*[@id='input-language']", "Language" };
	public static final String[] WLS_CAMPAIGN_PHONE = { "//*[@id='select2-input-campaign-phone-container']",
			"Campaign Phone" };
	public static final String[] BTN_ADD = { "//*[@id='create-lead']", "Add Lead" };

	/* Mandatory Fields in Add Lead Popup */
	public static final String[] LBL_MANDATORY_PHONE = { "//*[@for='input-phone' and contains(@class,'required')]",
			"Phone Mandatory" };
	public static final String[] LBL_MANDATORY_SOURCE = { "//*[@for='input-source' and contains(@class,'required')]",
			"Source Mandatory" };
	public static final String[] LBL_MANDATORY_SOURCE_NAME = {
			"//*[@for='input-new-source' and contains(@class,'required')]", "Source Name Mandatory" };
	public static final String[] LBL_MANDATORY_LANGUAGE = {
			"//*[@for='input-language' and contains(@class,'required')]", "Language Mandatory" };

	/* Opportunity Mandatory including above fields */
	public static final String[] LBL_MANDATORY_TITLE = { "//*[@for='title' and contains(@class,'required')]",
			"Title Mandatory" };
	public static final String[] LBL_MANDATORY_FIRST_NAME = {
			"//*[@for='input-firstname' and contains(@class,'required')]", "First Name Mandatory" };
	public static final String[] LBL_MANDATORY_EMAIL = { "//*[@for='input-email' and contains(@class,'required')]",
			"Email Mandatory" };

	/* List page */
	public static final String[] TOTAL_ORDER_ID = { "//*[@id='main-container']//tr//td[7]", "Total Order ID" };
	public static final String[] LBL_ORDER_ID = { "//*[@id='main-container']//tr[%s]/td[7]", "Order ID" };
	public static final String[] LBL_PHONE_LIST = { "//*[@id='main-container']//tr[%s]/td[9]", "Phone Number" };
	public static final String[] BTN_LEAD_FILE = { "//*[@id='main-container']//tr[%s]/td[2]/a/span", "File Button" };
	public static final String[] WLS_ASSIGNEE = {
			"//*[@id='main-container']/div/div[2]/div[1]/div[2]/div/table/tbody/tr[%s]/td[3]/select", "Assignee" };
	public static final String[] BTN_OK_ASSIGNEE = {
			"//button[@class='btn btn-primary' and contains(@data-bb-handler,'confirm')]", "Assignee - OK" };

	/* Inside Lead File */
	/* Customer Info */
	public static final String[] LBL_LEAD_CUSTOMER_PHONE = { "//*[@id='lead-phone']", "Customer - Phone" };
	public static final String[] RDO_LEAD_CUSTOMER_LANGUAGE_EN = { "//input[@class='customer-lang-th']",
			"Customer Language - EN" };
	public static final String[] RDO_LEAD_CUSTOMER_LANGUAGE_TH = { "//input[@class='customer-lang-en']",
			"Customer Language - TH" };
	public static final String[] TXT_LEAD_CUSTOMER_EMAIL = { "//*[@name='email']", "Customer - Email" };
	public static final String[] TXT_LEAD_CUSTOMER_FIRSTNAME = { "//*[@id='firstname']", "Customer - First Name" };
	public static final String[] TXT_LEAD_CUSTOMER_LASTNAME = { "//*[@id='lastname']", "Customer - Last Name" };

	/* Tabs */
	public static final String[] TAB_HIDDEN_SHIPPING_ADDRESS = {
			"//*[@id='shipping-address-list' and contains(@class,'bg-danger shipping-address hidden')]",
			"Shipping Adress Tab Hidden" };
	public static final String[] TAB_HIDDEN_DOCS = {
			"//*[@id='documents-list' and contains(@class,'bg-danger documents hidden')]", "Docs Tab Hidden" };

}

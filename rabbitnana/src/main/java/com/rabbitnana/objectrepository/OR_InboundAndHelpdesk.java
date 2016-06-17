package com.rabbitnana.objectrepository;

public class OR_InboundAndHelpdesk {

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
	public static final String[] TXT_ORDER_ID = { "//*[@id='filter-options']//input[@name='short_id']", "Order ID" };
	public static final String[] TOTAL_ORDER_ID = { "//*[@id='main-container']//tr//td[5]", "Total Order ID" };
	public static final String[] LBL_ORDER_ID = { "//*[@id='main-container']//tr[%s]/td[5]", "Order ID" };
	public static final String[] LBL_STATUS = { "//*[@id='main-container']//tr[%s]/td[11]", "Status" };
	public static final String[] BTN_LEAD_FILE = { "//*[@id='main-container']//tr[%s]/td[2]/a/span", "File Button" };
	public static final String[] BTN_FILTER = { "//*[@id='filter-options']//button[@class='btn btn-info']", "Filter" };

	/* Customer Info */
	public static final String[] LBL_NATIONAL_ID_PASSPORT = {
			"//*[@id='customer-info-form']//label[contains(@class,'required') and contains(.,'National')]",
			"Natioanl ID / Passport" };
	public static final String[] TXT_NATIONAL_ID_PASSPORT = { "//*[@id='thai_national_id']", "Natioanl ID / Passport" };
	public static final String[] BTN_SAVE_CUSTOMER_INFO = { "//*[@id='save-customer-info']", "Save - Customer Info" };
	public static final String[] LBL_LEAD_CUSTOMER_PHONE = { "//*[@id='customer-info-form']//input[@name='phone']",
			"Customer Phone" };
	public static final String[] TXT_LINE_ID = { "//*[@id='lineid']", "Line ID" };

	/* Car Info (Hidden Txt) */
	public static final String[] LBL_TXT_CAR_YEAR = { "//*[@id='car-info-form']/div[1]/div", "Car Year" };
	public static final String[] LBL_TXT_CAR_BRAND = { "//*[@id='car-info-form']/div[2]/div", "Car Brand" };
	public static final String[] LBL_TXT_CAR_MODEL = { "//*[@id='car-info-form']/div[3]/div", "Car Model" };
	public static final String[] LBL_TXT_CAR_SUB_MODEL = { "//*[@id='car-info-form']/div[4]/div", "Car Sub Model" };
	public static final String[] LBL_TXT_CAR_TYPE = { "//*[@id='car-info-form']/div[5]/div", "Car Type" };
	public static final String[] LBL_TXT_CAR_NUMBER_OF_DOORS = { "//*[@id='car-info-form']/div[6]/div",
			"Number of Doors" };
	public static final String[] LBL_TXT_CAR_ENGINE = { "//*[@id='car-info-form']/div[7]/div", "Car Engine" };
	public static final String[] LBL_LICENSE_PLATE_MANDATORY = {
			"//*[@id='car-info-form']//label[@for='car-license-plate' and contains(@class,'required')]",
			"License Plate Mandatory" };
	public static final String[] LBL_CHASSIS_NUMBER_MANDATORY = {
			"//*[@id='car-info-form']//label[@for='chassis_number' and contains(@class,'required')]",
			"Chassis Number Mandatory" };
	public static final String[] LBL_VIN_MANDATORY = {
			"//*[@id='car-info-form']//label[@for='vehicle-id-num' and contains(@class,'required')]", "VIN Mandatory" };
	public static final String[] LBL_TXT_MODIFICATIONS = { "//*[@id='car-info-form']/div[11]/div", "Modifications" };
	public static final String[] BTN_SAVE_CAR_INFO = { "//*[@id='save-car-info']", "Save- Car Info" };
	public static final String[] IS_PRESENT_CAR_TYPE = { "//*[@id='car-info-form']/div[5]/div", "Car Type" };
	public static final String[] IS_PRESENT_NUMBER_OF_DOORS = { "//*[@id='car-info-form']/div[6]/div",
			"Number of Doors" };
	public static final String[] IS_PRESENT_CAR_ENGINE = { "//*[@id='car-info-form']/div[7]/div", "Car Engine" };
	public static final String[] TXT_LICENSE_PLATE = { "//*[@id='license_plate']", "License Plate" };
	public static final String[] TXT_CHASSIS_NUMBER = { "//*[@id='chassis_number']", "Chassis Number" };
	public static final String[] TXT_VEHICLE_IDENTIFICATION_NUMBER = { "//*[@id='vin']",
			"Vehicle Identification Number" };
	public static final String[] LBL_MODIFICATION_LIST = { "//*[@id='modification-holder']/ul/li",
			"Modification List" };

	/* Insurance Package */
	public static final String[] LBL_INSURANCE_PACKAGE_NAME = { "//*[@id='policy-info']/div[2]/div[2]/div[1]/div",
			"Insurance Package Name" };

	/* Docs */

	public static final String[] BTN_LAST_POLICY_DOCS = { "//*[@id='last-policy-anchor']", "Last Policy Docs" };
	public static final String[] LNK_LAST_POLICY_DOCS_ACTIVE = {
			"//li[@class='bg-success active']//a[@id='last-policy-anchor']", "Last Policy Docs Active" };

	public static final String[] DOC_CAR_REGISTRATION = { "//*[@id='car-registration-anchor']/i",
			"Car Registration Document available" };
	public static final String[] DOC_ID_CARD = { "//*[@id='id-card-anchor']/i", "ID Card Document available" };
	public static final String[] BTN_PAYMENT_DOCUMENTS = { "//*[@id='payment-documents-anchor']", "Payment Document" };
	public static final String[] DOC_PAYMENT = { "//*[@id='payment-documents-anchor']/i",
			"Payment Document available" };
	public static final String[] LNK_PAYMENT_DOCS_ACTIVE = {
			"//li[@class='bg-success active']//a[@id='payment-documents-anchor']", "Payment Docs Active" };

	public static final String[] BTN_DRIVING_LICENSE = { "//*[@id='driving-license-anchor']", "Driving License Docs" };
	public static final String[] LNK_DRIVING_LICENSE_ACTIVE = {
			"//li[@class='bg-success active']//a[@id='driving-license-anchor']", "Driving License Active" };

	public static final String[] LBL_CAR_PIC_MANDATORY = { "//*[@id='car-pictures-anchor']//span[@class='required']",
			"Car Pictures are mandatory" };
	public static final String[] BTN_CAR_PICTURES = { "//*[@id='car-pictures-anchor']", "Car Pictures" };
	public static final String[] LNK_CAR_PICTURES_ACTIVE = {
			"//li[@class='bg-success active']//a[@id='car-pictures-anchor']", "Car Pictures Active" };
	public static final String[] DOC_CAR_PICTURES = { "//*[@id='car-pictures-anchor']/i",
			"Car Pictures are available" };
	public static final String[] LNK_DOWNLOAD_PAYMENT_DOCUMENTS = {
			"//*[@id='payment-documents']//a[@class='file-download pull-left']/i",
			"Download Link - Payment Documents" };

	/* Payment */
	public static final String[] BTN_PAYMENT_TAB = { "//*[@id='right-tab-nav']/li[2]/a", "Payment Tab" };
	public static final String[] TXT_CUSTOMER_PAY_DATE = { "//*[@id='customer-pay-date-fixed']", "Customer Pay Date" };
	public static final String[] BTN_CUSTOMER_PAY_DATE_SAVE = { "//*[@id='save-customer-pay-date-fixed']",
			"Save - Customer Pay Date" };
	public static final String[] TXT_CUSTOMER_PAID_AMOUNT = { "//*[@id='customer-paid-amount-fixed']",
			"Customer Paid Amount" };
	public static final String[] BTN_CUSTOMER_PAID_AMOUNT_SAVE = { "//*[@id='save-customer-paid-amount-fixed']",
			"Save - Customer Pay Amount" };
	public static final String[] BTN_OK_SUCCESS = { "//button[@class='btn btn-primary' and @data-bb-handler='ok']",
			"Ok - Customer Pay-Date" };
	public static final String[] BTN_CONFIRM_SUCCESS = {
			"//button[@class='btn btn-primary' and @data-bb-handler='confirm']", "Confirm" };

	/* Dashboard */
	public static final String[] BTN_READY_TO_SUBMIT = { "//*[@id='dashboard']/div/div[2]/div[3]/div[1]/form/button",
			"Ready to Submit" };
	public static final String[] LBL_PAID_INSURER = { "//*[@id='dashboard']//span[@class='label label-default']",
			"Paid Insurer" };

}

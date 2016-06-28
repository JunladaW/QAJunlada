package com.rabbitmtls.objectrepository;

public class OR_MTLSWebPage {

	/* Landing Page */
	public static final String[] BTN_SAVE_NOW_TOP = {
			"//*[@id='head-col-left']//button[@class='select-trigger select-field']", "Save Now! - From Top page" };
	public static final String[] BTN_TXT_TOP = { "//*[@id='lead-form']//*[@name='name']",
			"Select Leasing - From Top page " };

	public static final String[] BTN_SAVE_NOW_CENTER = {
			"//*[@id='lp-content']//section[4]//*[@class='select-trigger select-field']",
			"Save Now! - From Center page" };
	public static final String[] BTN_TXT_CENTER = {
			"//*[@id='lp-content']//section[7]//div[@class='select-field select-trigger text-center']",
			"Select Leasing - From Center page " };

	public static final String[] BTN_SAVE_NOW_BOTTOM = {
			"//section[7]//*[@class='select-trigger select-field question-trigger']", "Save Now! - From Bottom page" };
	public static final String[] BTN_TXT_BOTTOM = {
			"//*[@id='lp-content']/section[7]//div[@class='select-field select-trigger text-center']",
			"Select Leasing - From Bottom page " };

	/* Loan Requirements tab */
	public static final String[] RDO_COLLATERAL_CAR = { "//*[@name='collateral' and @value='car']", "Collateral Car" };
	public static final String[] RDO_COLLATERAL_BIKE = { "//*[@name='collateral' and @value='bike']",
			"Collateral Bike" };
	public static final String[] TXT_LENDING_AMOUNT = { "//*[@name='lending_amount']", "Lending Amount" };
	public static final String[] TOTAL_PROVINCES = { "//*[@name='province_id']//option", "Total Provinces" };
	public static final String[] WLS_PROVINCE = { "//*[@name='province_id']", "Province" };
	public static final String[] RDO_IS_HOMETOWN_YES = { "//*[@name='is_hometown' and @value='1']", "Is HomeTown Yes" };
	public static final String[] RDO_IS_HOMETOWN_NO = { "//*[@name='is_hometown' and @value='0']", "Is HomeTown No" };
	public static final String[] WLS_INCOME = { "//*[@name='income_range']", "Income" };
	public static final String[] TOTAL_INCOME_RANGE = { "//*[@name='income_range']//option", "Total Income Range" };
	public static final String[] LBL_INCOME_RANGE = { "//*[@name='income_range']//option[%s]", "Income Range" };
	public static final String[] BTN_NEXT_LOAN_REQUIREMENTS = {
			"//*[@class='btn btn-primary btn-block next-btn' and @data-next-tab='tab-2']", "Next - Loan Requirements" };
	public static final String[] BTN_NEXT_ADDRESS = {
			"//*[@class='btn btn-primary btn-block next-btn' and @data-next-tab='tab-3']", "Next - Address" };
	public static final String[] BTN_NEXT_CONTACT = { "//*[@id='submit']", "Next - Contact" };

	/* Contact Information */
	public static final String[] TXT_NAME = { "//*[@id='mtl-questions']//*[@name='name']", "Name" };
	public static final String[] TXT_PHONE = { "//*[@id='mtl-questions']//*[@name='phone']", "Phone" };

	/* Thanks */
	public static final String[] LBL_RABBIT_THANK_YOU = { "//*[@class='rabbit-thank']", "Rabbit Thank You Page" };
}

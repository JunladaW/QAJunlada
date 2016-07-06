package com.rabbitkrungthaiaxa.objectrepository;

public class OR_KTAWebPage {

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
	public static final String[] WLS_AGE_RANGE = { "//*[@name='age_range']", "Age Range" };
	public static final String[] TOTAL_AGE_RANGE = { "//*[@name='age_range']//option", "Total Age Range" };
	public static final String[] LBL_AGE_RANGE = { "//*[@name='age_range']//option[%s]", "Total Age Range" };
	public static final String[] RDO_GENDER_MALE = { "//*[@name='gender' and @value='0']", "Gender Male" };
	public static final String[] RDO_GENDER_FEMALE = { "//*[@name='gender' and @value='1']", "Gender Female" };

	public static final String[] TXT_NAME = { "//*[@name='name']", "Name" };
	public static final String[] TXT_PHONE = { "//*[@name='phone']", "Phone" };

	/* Thanks */
	public static final String[] LBL_RABBIT_THANK_YOU = { "//*[@class='rabbit-thank']", "Rabbit Thank You Page" };
}

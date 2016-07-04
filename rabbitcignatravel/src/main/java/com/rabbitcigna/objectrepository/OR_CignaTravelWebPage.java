package com.rabbitcigna.objectrepository;

public class OR_CignaTravelWebPage {

	/* Landing Page */
	public static final String[] BTN_SAVE_NOW = {
			"//*[@id='head-col-left']//button[@class='select-trigger select-field']", "Save Now! - From Top page" };
	public static final String[] BTN_SELECT_TRAVEL = {
			"//*[@id='head-col-left']//div[@class='select-field text-center select-trigger']",
			"Select Travel - From Top page " };

	public static final String[] BTN_SAVE_NOW_CENTER = {
			"//*[@id='lp-content']//section[4]//*[@class='select-trigger select-field']",
			"Save Now! - From Center page" };
	public static final String[] BTN_SELECT_TRAVEL_CENTER = {
			"//*[@id='lp-content']//section[7]//div[@class='select-field select-trigger text-center']",
			"Select Travel - From Center page " };

	public static final String[] BTN_SAVE_NOW_BOTTOM = {
			"//section[7]//*[@class='select-trigger select-field question-trigger']", "Save Now! - From Bottom page" };
	public static final String[] BTN_SELECT_TRAVEL_BOTTOM = {
			"//*[@id='lp-content']/section[7]//div[@class='select-field select-trigger text-center']",
			"Select Travel - From Bottom page " };

	/* Questions - Your Trip */
	public static final String[] WLS_TRAVEL_DESTINATION = { "//*[@name='cigna_country_id']", "Travel Destination" };
	public static final String[] TOTAL_TRAVEL_DESTINATION = { "//*[@name='cigna_country_id']//option",
			"Total Travel Destinations" };
	public static final String[] LBL_TRAVEL_DESTINATION = { "//*[@name='cigna_country_id']//option[%s]",
			"Destination Name" };
	public static final String[] TXT_TRAVEL_DURATION_FROM = { "//*[@id='start-date']", "Travel Duration From" };
	public static final String[] TXT_TRAVEL_DURATION_TO = { "//*[@id='end-date']", "Travel Duration To" };
	public static final String[] BTN_NEXT_YOUR_TRIP = { "//*[@class='btn btn-primary btn-block next-btn']",
			"Next - Your Trip" };

	/* Travelers */
	public static final String[] WLS_NO_OF_PEOPLE = { "//*[@name='no_of_person']", "No. Of People" };
	public static final String[] TOTAL_NO_OF_PEOPLE = { "//*[@name='no_of_person']//option", "Total No. Of People" };
	public static final String[] TXT_CONTACT_INFO = { "//*[@name='phone']", "Contact Information" };
	public static final String[] BTN_BACK_TRAVELLERS = { "//*[@class='btn btn-default btn-block prev-btn']",
			"Back - Travellers" };
	public static final String[] BTN_PROCEED_TRAVEL = { "//*[@id='form-tab-2']/div[3]/div[2]/div/button", "Proceed" };

	/* Cigna WebPage */
	public static final String[] LBL_CIGNA_DESTINATION = { "//*[@class='destination-list']//span",
			"Cigna Destination" };
	public static final String[] LBL_TRAVEL_START_DATE = { "//*[@ng-bind='tempData.shortStartDate']",
			"Travel Start Date" };
	public static final String[] LBL_TRAVEL_END_DATE = { "//*[@ng-bind='tempData.shortEndDate']", "Travel End Date" };

	/* Date Validations */
	public static final String[] BTN_PREV_MONTH = { "//tr[2]//*[@class='prev' and @style='visibility: hidden;']",
			"Previous Month Disabled" };
	public static final String[] BTN_NEXT_MONTH = { "//*[@class='next' and @style='visibility: visible;']",
			"Next Month Enabled" };
	public static final String[] LBL_PREV_DATE = { "//*[contains(@class,'disabled day') and contains(.,'%s')]",
			"Previous Date Disabled" };
	public static final String[] BTN_DATE_SELECTION = { "//*[@class='day' and contains(.,'%s')]", "Select Date" };
	public static final String[] LBL_DATE_MONTH_YEAR = { "//*[@class='datepicker-switch' and contains(.,'%s')]",
			"Month and Year" };
}

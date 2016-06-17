package com.rabbitnana.objectrepository;

public class OR_SubmittableCases {

	/* List page */
	public static final String[] TXT_ORDER_ID = { "//*[@id='main-container']//input[@name='order_id']", "Order ID" };
	public static final String[] TOTAL_ORDER_ID = { "//*[@id='main-container']//tr/td[3]", "Total Order ID" };
	public static final String[] LBL_ORDER_ID = { "//*[@id='main-container']//tr[%s]/td[3]", "Order ID" };
	public static final String[] BTN_LEAD_FILE = { "//*[@id='main-container']//tr[%s]/td[2]/a/span", "File Button" };
	public static final String[] BTN_FILTER = { "//*[@id='main-container']//button[@class='btn btn-info']", "Filter" };

	/* Generated Documents */
	public static final String[] BTN_COVER_NOTE = { "//*[@id='documents-nav']//a[@href='#covernote']", "Cover Note" };
	public static final String[] BTN_COVER_NOTE_ACTIVE = {
			"//*[@id='documents-nav']//li[@class='bg-success active']//a[@href='#covernote']", "Cover Note Active" };
	public static final String[] BTN_SEND_COVER_NOTE_EN = { "//*[@id='covernote']/button[@lang='en']",
			"Send Cover Note - EN" };
	public static final String[] BTN_COVER_NOTE_SUBMIT = { "//*[@id='wrapper']//div[@class='btn btn-ask-submit']",
			"Cover Note Submit" };

	/* Dashboard */
	public static final String[] BTN_DASHBOARD_TAB = { "//*[@id='right-tab-nav']/li[1]/a", "Dashboard" };
	public static final String[] BTN_INSURER_ACCEPTED = { "//*[@id='dashboard']/div/div[2]/div[3]/div[1]/form/button",
			"Insurer Accepted" };
	public static final String[] BTN_SEND_PRELIMINARY_EN = {
			"//div[2]/div/div/div[2]//*[@id='preliminary']/button[@lang='en']", "Preliminary Policy - En" };
	public static final String[] BTN_SUBMIT_PRELIMINARY_INVOICE = {
			"//*[@id='wrapper']//div[@class='btn btn-ask-submit']", "Submit Preliminary Invoice" };
	public static final String[] LBL_PRELIMINARY_SUCCESS_MESSAGE = { "//*[@id='preliminary']/div/div[2]/div/span",
			"Preliminary Success" };
}

package com.rabbitnana.objectrepository;

public class OR_Dashboard {

	/* Dashboard Tab */
	public static final String[] LBL_DASHBOARD_TAB = { "//*[@id='dashboard-tab-btn']/a", "Dashboard" };
	public static final String[] BTN_DASHBOARD_TAB = {
			"//div[@class='col-sm-10']//*[@id='right-sidebar']//li[@id='dashboard-tab-btn']", "Dasboard" };
	public static final String[] LBL_DASHBOARD_PHONE = { "//*[@class='phone customer-phone']", "Dashboard - Phone" };
	public static final String[] BTN_DASHBOARD_CALL = { "//*[@id='call-customer-phone']", "Call Button" };
	public static final String[] LBL_DASHBOARD_ORDER_ID = { "//*[@class='short-id']", "Dashboard - Order ID" };
	public static final String[] BTN_DASHBOARD_NOT_READY_TO_BUY = { "//*[@id='not-ready-to-buy']", "Not Ready To Buy" };
	public static final String[] WLS_DASHBOARD_CANCEL_REASON = { "//div[2]/div/div/div[2]/div/div/select",
			"Cancel Reason" };
	public static final String[] BTN_DASHBOARD_REASON_OK = { "//button[@class='btn btn-primary' and contains(.,'Ok')]",
			"Ok" };
	public static final String[] TXT_NOTE_EVENT = { "//*[@id='note-input']", "Note Event" };
	public static final String[] BTN_SAVE_NOTE_EVENT = { "//*[@id='save-note-button']", "Note Event - Save" };
	public static final String[] LBL_NOTE_EVENT_COUNT = { "//*[@id='events-holder']/div/div/div[2]", "Total Events" };
	public static final String[] LBL_NOTE_EVENT_SINGLE_FLAG = { "//*[@id='events-holder']/div/div/div[2]",
			"Note Event" };
	public static final String[] LBL_NOTE_EVENT_MULTI_FLAG = { "//*[@id='events-holder']/div[%s]/div/div[2]",
			"Note Event" };

	/* Help Desk Dashboard */
	public static final String[] BTN_DASHBOARD_TAB_HELPDESK = { "//*[@id='right-tab-nav']/li[1]/a", "Dashboard" };
	public static final String[] BTN_DASHBOARD_CALL_HELPDESK = {
			"//*[@id='dashboard']//a[@class='btn btn-success left-buffer']", "Call Button" };
}

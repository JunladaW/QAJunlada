package com.rabbitnana.objectrepository;

public class OR_Accouting {

	/* List page */
	public static final String[] TXT_ORDER_ID = { "//*[@id='main-container']//input[@name='order_id']", "Order ID" };
	public static final String[] TOTAL_ORDER_ID = { "//*[@id='main-container']//tr/td[2]", "Total Order ID" };
	public static final String[] LBL_ORDER_ID = { "//*[@id='main-container']//tr[%s]/td[2]", "Order ID" };
	public static final String[] BTN_FILTER = { "//*[@id='main-container']//button[@class='btn btn-info']", "Filter" };
	public static final String[] CHB_ORDER_CHECK = { "//*[@id='main-container']//tr[%s]/td[1]/input",
			"Check Order ID" };

	public static final String[] BTN_CLOSE_ORDER = { "//*[@id='close-orders-btn']", "Close Order" };

	public static final String[] BTN_CONFIRM_SUCCESS = {
			"//button[@class='btn btn-primary' and @data-bb-handler='confirm']", "Confirm" };
}

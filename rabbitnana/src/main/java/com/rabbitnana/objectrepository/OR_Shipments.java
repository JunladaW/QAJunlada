package com.rabbitnana.objectrepository;

public class OR_Shipments {

	/* List page */
	public static final String[] TXT_ORDER_ID = { "//*[@id='main-container']//input[@name='order_id']", "Order ID" };
	public static final String[] TOTAL_ORDER_ID = { "//*[@id='main-container']//form/span[3]", "Total Order ID" };
	public static final String[] LBL_ORDER_ID = { "//*[@id='main-container']//form[%s]/span[3]", "Order ID" };
	public static final String[] BTN_FILTER = { "//*[@id='main-container']//button[@class='btn btn-info']", "Filter" };
	public static final String[] LBL_DATA_ORDER_ID = { "//*[@id='main-container']//form[%s]", "Data Order ID" };
	public static final String[] WLS_SHIPMENT_METHOD = { "//*[@id='shipment-method-%s']", "Shipment Method" };
	public static final String[] TXT_TRACKING_CODE = { "//*[@id='shipment-tracking-code-%s']", "Tracking Code" };
	public static final String[] BTN_SAVE_SHIPMENT = { "//*[@id='update-status-button-%s']", "Save - Shipment" };

	public static final String[] BTN_CONFIRM_SUCCESS = {
			"//button[@class='btn btn-primary' and @data-bb-handler='confirm']", "Confirm" };
}

package com.rabbitnana.objectrepository;

public class OR_SalesAgent {
	
	public static final String[] WED_SEARCH = {"//*[@id='lead-opps-search-bar']","Sales Agent - Search"};
	public static final String[] TOTAL_LIST = {"//*[@id='left-content']/div[2]/table/tbody/tr","Total Leads / Opportunities"};
	public static final String[] SEARCH_NAME_EMAIL = {"//*[@id='left-content']/div[2]/table/tbody/tr[1]/td[3]","Name or Email"};
	public static final String[] SEARCH_ORDER_ID = {"//*[@id='left-content']/div[2]/table/tbody/tr[1]/td[4]","Order ID"};
	public static final String[] SEARCH_BY_NAME_EMAIL = {"//*[@id='left-content']/div[2]/table/tbody/tr[not(contains(@class,'hidden'))]/td[3]","Name / Email List"};
	public static final String[] SEARCH_BY_ORDER_ID = {"//*[@id='left-content']/div[2]/table/tbody/tr[not(contains(@class,'hidden'))]/td[4]","Order ID List"};
	public static final String[] TOTAL_LIST_AFTER_SEARCH = {"//*[@id='left-content']/div[2]/table/tbody/tr[not(contains(@class,'hidden'))]","Search List"};
}

package com.rabbitcigna.objectrepository;

public class OR_CignaTravelNANA {

	public static final String[] BTN_LANGUAGE = { "//*[@id='lang-chooser']/a[1]", "Language - English" };
	public static final String[] BTN_TRAVEL_INSURANCE = { "//*[@id='main-sidebar']//a[contains(.,'Travel Insurance')]",
			"Travel Insurance" };
	public static final String[] BTN_TRAVEL_LEADS = { "//*[@id='submenu10']/li/a[contains(.,'Leads')]",
			"Travel Insurance Leads" };
	public static final String[] TOTAL_MOBILE_LIST = { "//table[@class='table table-hover listing-table']//tr/td[3]",
			"Total Mobile List" };
	public static final String[] LBL_MOBILE_NUMBER = {
			"//table[@class='table table-hover listing-table']//tr[%s]/td[3]", "Total Mobile List" };
	public static final String[] LBL_COUNTRY = { "//table[@class='table table-hover listing-table']//tr[%s]/td[4]",
			"Travelling Country Name" };
	public static final String[] LBL_START_DATE = { "//table[@class='table table-hover listing-table']//tr[%s]/td[5]",
			"Travel Start Date" };
	public static final String[] LBL_END_DATE = { "//table[@class='table table-hover listing-table']//tr[%s]/td[6]",
			"Travel End Date" };
	public static final String[] LBL_NO_OF_PERSON = { "//table[@class='table table-hover listing-table']//tr[%s]/td[7]",
			"No. Of Person" };
	public static final String[] LBL_CREATED_DATE = { "//table[@class='table table-hover listing-table']//tr[%s]/td[2]",
			"Lead Created Date" };

	public static final String[] TXT_CREATED_DATE_SEARCH = { "//*[@name='created_at']", "Search - Created Date" };
	public static final String[] BTN_FILTER = { "//button[contains(text(),'Filter')]", "Filter" };
	public static final String[] LBL_NO_RECORDS_FOUND = { "//*[@class='table table-hover listing-table']//tr[2]/td",
			"No Records Found" };
}

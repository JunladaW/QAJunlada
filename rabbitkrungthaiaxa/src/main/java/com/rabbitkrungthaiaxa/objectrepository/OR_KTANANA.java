package com.rabbitkrungthaiaxa.objectrepository;

public class OR_KTANANA {

	public static final String[] BTN_LANGUAGE_EN = { "//*[@id='lang-chooser']/a[1]", "Language - English" };
	public static final String[] BTN_LANGUAGE_TH = { "//*[@id='lang-chooser']/a[2]", "Language - Thai" };
	public static final String[] BTN_MUANG_THAI_LEASING = {
			"//*[@id='main-sidebar']//a[contains(.,'Muang Thai Leasing')]", "Muang Thai Leasing" };
	public static final String[] BTN_MUANG_THAI_LEASING_LEADS = { "//*[@id='submenu11']/li/a[contains(.,'Leads')]",
			"Muang Thai Leasing Leads" };

	public static final String[] LBL_CREATED_DATE = { "//table[@class='table table-hover listing-table']//tr[%s]/td[2]",
			"Lead Created Date" };
	public static final String[] TOTAL_MOBILE_LIST = { "//table[@class='table table-hover listing-table']//tr/td[3]",
			"Total Mobile List" };
	public static final String[] LBL_MOBILE_NUMBER = {
			"//table[@class='table table-hover listing-table']//tr[%s]/td[3]", "Mobile Number" };
	public static final String[] LBL_NAME = { "//table[@class='table table-hover listing-table']//tr[%s]/td[4]",
			"Name" };
	public static final String[] LBL_COLLATERAL = { "//table[@class='table table-hover listing-table']//tr[%s]/td[5]",
			"Travel Start Date" };
	public static final String[] LBL_LENDING_AMOUNT = {
			"//table[@class='table table-hover listing-table']//tr[%s]/td[6]", "Travel End Date" };
	public static final String[] LBL_PROVINCE = { "//table[@class='table table-hover listing-table']//tr[%s]/td[7]",
			"No. Of Person" };
	public static final String[] LBL_HOME_TOWN = { "//table[@class='table table-hover listing-table']//tr[%s]/td[8]",
			"Is Home Town" };
	public static final String[] LBL_INCOME_RANGE = { "//table[@class='table table-hover listing-table']//tr[%s]/td[9]",
			"Income Range" };

	public static final String[] TXT_CREATED_DATE_SEARCH = { "//*[@name='created_at']", "Search - Created Date" };
	public static final String[] BTN_FILTER = { "//*[@class='btn btn-info']", "Filter" };
	public static final String[] LBL_NO_RECORDS_FOUND = { "//*[@class='table table-hover listing-table']//tr[2]/td",
			"No Records Found" };

}

package com.rabbitbase.objectrepository;

public class OR_GenericNANA {

	/* Login */
	public static final String[] WED_LOGIN_GMAIL_NANA_EMAIL = { "//*[@id='Email']", "Enter your email" };
	public static final String[] WED_LOGIN_GMAIL_NANA_PASSWORD = { "//*[@id='Passwd']", "Enter Password" };
	public static final String[] BTN_NEXT = { "//*[@id='next']", "Next" };
	public static final String[] BTN_SIGNIN = { "//*[@id='signIn']", "Sign In" };

	/* Menus */
	public static final String[] LNK_LANGUAGE_ENGLISH = { "//*[@id='lang-chooser']/a[contains(.,'English')]",
			"English Language" };
	public static final String[] BTN_CAR_INSURANCE = { "//*[@id='main-sidebar']/div[3]/ul/li[1]/a", "Car Insurance" };
	public static final String[] BTN_LEADS = { "//*[@id='submenu1']//a[contains(@href,'leads')]", "Leads" };
	public static final String[] BTN_OPPORTUNITIES = { "//*[@id='submenu1']//a[contains(@href,'opportunities')]",
			"Opportunities" };
	public static final String[] BTN_ORDERS = { "//*[@id='submenu1']//a[contains(@href,'orders')]", "Orders" };
	public static final String[] BTN_SALES_AGENT = { "//*[@id='submenu1']//a[contains(@href,'sales')]", "Sales Agent" };
	public static final String[] BTN_INBOUND_HELPDESK = { "//*[@id='submenu1']//a[contains(@href,'helpdesk')]",
			"Inbound & Helpdesk" };
	public static final String[] BTN_SHIPMENTS = { "//*[@id='submenu1']//a[contains(@href,'shipments')]", "Shipments" };
	public static final String[] BTN_DATA_ENTRY = { "//*[@id='submenu1']//a[contains(@href,'packages/create')]",
			"Data Entry" };
	public static final String[] BTN_INSURANCE_PACKAGES = {
			"//*[@id='submenu1']//a[contains(@href,'packages') and contains(.,'Insurance Packages')]",
			"Insurance Packages" };
	public static final String[] BTN_BROKER_COMMISSIONS = { "//*[@id='submenu1']//a[contains(@href,'commissions')]",
			"Broker Commissions" };
	public static final String[] BTN_SUBMITTABLE_CASES = {
			"//*[@id='submenu1']//a[contains(@href,'submittable-cases')]", "Subbittable Cases" };
	public static final String[] BTN_ACCOUNTING = { "//*[@id='submenu1']//a[contains(@href,'shipped-orders')]",
			"Accounting" };
	public static final String[] BTN_AGENT_DISCOUNTS = { "//*[@id='submenu1']//a[contains(@href,'agent-discounts')]",
			"Agent Discounts" };

	/* Menu - Page Header */
	public static final String[] LBL_PAGE_TITLE = { "//*[@id='main-container']/div/div[2]//h1", "Page Title" };

	/* Gmail Logout */
	public static final String[] BTN_CLICK_GMAIL_NAME = { "//*[@id='gb']/div[1]/div[1]/div[2]/div[4]/div[1]/a/span",
			"Click on Sigout Name" };
	public static final String[] BTN_GMAIL_SIGN_OUT = { "//*[contains(@id,'gb_') and contains(.,'Sign out')]",
			"Sign Out" };
	public static final String[] BTN_GMAIL_SIGNIN_DIFF_ACC = { "//*[@id='account-chooser-link']", "Signin Diff Acc" };
	public static final String[] BTN_GMAIL_ADD_ACCOUNT = { "//*[@id='account-chooser-add-account']", "Add Account" };

	/* Sale Agent View */
	public static final String[] LBL_FRESHLEAD_AGENT = {
			"//*[@id='left-content']//span[@class='text-capitalize' and contains(.,'CI_FRESHLEADAGENT')]",
			"Fresh Lead Agent" };

	/* Calender Validation */
	public static final String[] BTN_YEAR_FUTURE_DISABLED = { "//*[@class='next disabled']",
			"Future Month/Year Disabled" };
	public static final String[] BTN_BACK_DATE_DISABLED = { "//*[@class='prev disabled']", "Back Date Disabled" };
	public static final String[] LBL_TITLE_MONTH_YEAR = { "//*[@title='Select Month']", "Title - Month / Year" };
	public static final String[] LBL_TITLE_CUSTOMIZE_MONTH_YEAR = { "//*[@title='Select Month' and contains(.,'%s')]",
			"Customize Title - Month / Year" };
	public static final String[] BTN_PREVIOUS_MONTH = { "//*[@data-action='previous']", "Previois Month / Year" };
	public static final String[] BTN_SELECT_DATE = { "//*[@data-action='selectDay'][text()='%s']", "Select Day" };

}

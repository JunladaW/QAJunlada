package com.rabbitrewards.objectrepository;

public class OR_MyDetail {

	/*USER MY DETAIL*/
	public static final String[] LNK_USER_MY_DETAIL = {"//i[@class='icon icon-detail']","My Detail Section"};
	
	/*=== LANGUAGE ===*/
	public static final String[] LBL_MANDATORY_PREFERRED_LANGUAGE = {"//div[@class='col-md-3 form-group']//label['language']","Mandatory - Preferred Language"};
	public static final String[] WLS_PREFERRED_LANGUAGE = {"//*[@id='language']","Preferred Language"};
	
	/*=== PERSONAL INFO ===*/
	public static final String[] LBL_MANDATORY_TITLE = {"//div[@class='form-group']//label[@for='input-title']","Mandatory - Title"};
	public static final String[] WLS_TITLE = {"//*[@id='title']","Title"};
	public static final String[] LBL_MANDATORY_FIRST_NAME = {"//div[3]//div[2]/div[2]/div[@class='form-group']//label[@for='input-first-name']","Mandatory - First Name"};
	public static final String[] TXT_FIRST_NAME = {"//*[@id='input-first-name']","First Name"};
	public static final String[] LBL_LAST_NAME = {"//div[3]//div[2]/div[3]/div[@class='form-group']//label[@for='input-first-name']","Mandatory - Last Name"};
	public static final String[] TXT_LAST_NAME = {"//*[@id='input-last-name']","Last Name"};
	public static final String[] LBL_MANDATORY_DATEOFBIRTH = {"//div[@class='form-group']//label[@for='input-birthday']","Mandatory - Date of Birth"};
	public static final String[] TXT_DATE_OF_BIRTH = {"//*[@id='input-birthday']","Date of Birth"};
	
	/*=== OTHER INFORMATION ===*/
	public static final String[] LBL_MANDATORY_GENDER = {"//div[@class='form-group']//label[@for='input-gender']","Mandatory - Gender"};
	public static final String[] WLS_GENDER = {"//*[@id='input-gender']","Gender"};
	public static final String[] WLS_MARITAL_STATUS = {"//*[@id='input-marital-status']","Marital Status"};
	public static final String[] WLS_NATIONALITY = {"//*[@id='input-nationality']","Nationality"};
	public static final String[] TXT_ID_NUMBER = {"//*[@id='input-id-no']","ID Number"};
	public static final String[] TXT_PASSPORT_NUMBER = {"//*[@id='input-passport-no']","Passport Number"};
	public static final String[] TXT_HOME_TEL = {"//*[@id='input-home-tel']","Home Tel."};
	public static final String[] TXT_EXTENSION = {"//*[@id='input-extention']","Tel. Extension"};
	public static final String[] LBL_MANDATORY_MOBILE = {"//div[@class='form-group']//label[@for='input-mobile']","Mandatory - Mobile Number"};
	public static final String[] TXT_MOBILE = {"//*[@id='input-mobile']","Mobile Number"};
	public static final String[] LBL_MANDATORY_EMAIL = {"//div[@class='form-group']//label[@for='input-email']","Mandatory - Email"};
	public static final String[] TXT_EMAIL = {"//*[@id='input-email']","Email"};
	public static final String[] LBL_MANDATORY_REENTER_EMAIL = {"//div[@class='form-group']//label[@for='input-re-email']","Mandatory - Re-Enter Email"};
	public static final String[] TXT_RE_ENTER_EMAIL = {"//*[@id='input-re-email']","Re-Enter Email"};
	
	/*=== HOME ADDRESS ===*/
	public static final String[] TXT_HOME_ADDRESS_NO = {"//*[@id='input-home-address']","Home Address No."};
	public static final String[] TXT_HOME_VILLAGE_OR_BUILDING = {"//*[@id='input-home-address-village']","Home Add. Village or Building"};
	public static final String[] TXT_HOME_SOI = {"//*[@id='input-home-address-soi']","Home Add. Soi"};
	public static final String[] TXT_HOME_STREET = {"//*[@id='input-home-address-street']","Home Add. Street"};
	public static final String[] TXT_HOME_SUB_DISTRICT = {"//*[@id='input-home-address-sub-district']","Home Add. Sub-District"};
	public static final String[] TXT_HOME_DISTRICT = {"//*[@id='input-home-address-district']","Home Add. District"};
	public static final String[] WLS_HOME_PROVINCE = {"//*[@id='input-home-address-province']","Home Add. Province"};
	public static final String[] TXT_HOME_POSTCODE = {"//*[@id='input-home-address-postcode']","Home Add. Postcode"};
	
	/*=== SHIPPING ADDRESS ===*/
	public static final String[] CHK_SHIPPING_SAME_HOME_ADDRESS = {"//input[@type='checkbox' and contains(@form-action,'click:shippmentAsHomeAddress')]","Shipping same as Home address"};
	public static final String[] TXT_SHIPPING_ADDRESS_NO = {"//*[@id='input-shipping-address']","Shipping Address No."};
	public static final String[] TXT_SHIPPING_VILLAGE_OR_BUILDING = {"//*[@id='input-shipping-address-village']","Shipping Add. Village or Building"};
	public static final String[] TXT_SHIPPING_SOI = {"//*[@id='input-shipping-address-soi']","Shipping Add. Soi"};
	public static final String[] TXT_SHIPPING_STREET = {"//*[@id='input-shipping-address-street']","Shipping Add. Street"};
	public static final String[] TXT_SHIPPING_SUB_DISTRICT = {"//*[@id='input-shipping-address-sub-district']","Shipping Add. Sub-District"};
	public static final String[] TXT_SHIPPING_DISTRICT = {"//*[@id='input-shipping-address-district']","Shipping Add. District"};
	public static final String[] WLS_SHIPPING_PROVINCE = {"//*[@id='input-shipping-address-province']","Shipping Add. Province"};
	public static final String[] TXT_SHIPPING_POSTCODE = {"//*[@id='input-shipping-address-postcode']","Shipping Add. Postcode"};
	
	/*Checkout*/
	public static final String[] CHK_SUBSCRIPTION = {"//*[@id='input-subscription-preference']","Subscription"};
	public static final String[] BTN_SAVE_AND_CONTINUE = {"//*[@id='my-detail-form']//a[@class='btn btn-block btn-success']","Save and Continue"};
	public static final String[] BTN_SAVE_AND_CONTINUE_SUCCESS = {"//*[@id='my-detail-form']//span[@class='save-status-span' and contains(.,'Success')]","Save Success"};
	
}

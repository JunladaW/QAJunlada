package com.rabbitrewards.objectrepository;

public class OR_Redeem {

	/*Redeem*/
	public static final String[] LNK_REDEEM_MAIN = {"//section[1]/div/div[2]/ul/li[4]/a[contains(.,'Redeem')]","Redeem"};
	public static final String[] COUNT_REDEEM_LIST = {"//div[5]/div/div[2]/div[2]/div","Total Redeem List"};
	
	/*div[5]/div/div[2]/div[2]/div[%s]/div[1]/div[3]/p[2]/a -- To make dynamic redeem click */
	public static final String[] BTN_REDEEM_LIST = {"//div[5]/div/div[2]/div[2]/div[2]/div[1]/div[3]/p[2]/a","Redeem From List"};
	public static final String[] LBL_REDEEM_POINTS = {"//div[5]/div/div[2]/div[2]/div[2]/div[1]/div[3]/p[1]","Redeem Points"};
	public static final String[] WLS_REDEEM_QUANTITY = {"//select[@class='form-control input-sm' and contains(@data-target,'redeem.quantity')]","Quantity"};
	public static final String[] BTN_ADD_TO_CART = {"//button[@class='btn btn-block btn-warning' and contains(.,'Add to Cart')]","Add to Cart"};
	public static final String[] BTN_REDEEM_DIRECT = {"//div[2]/div/div[2]/div[2]/div[2]/div/button[1]","Direct Redeem"};
	public static final String[] LBL_REDEEM_TO_CART_SUCCESS = {"//div[@class='modal-content modal-message-done' and contains(@style,'block')]//p","Item has been added to Cart!"};
	public static final String[] BTN_GO_TO_CART = {"//div[5]/div/div[7]/a","Go to Cart"};
	
	public static final String[] WLS_DELIVERY_OPTION_CART = {"//button[@class='btn-delivery btn btn-default']","Cart - Delivery Option"};
	public static final String[] CHK_HOME_DELIVERY = {"//div[@class='popover-content input']//input[@id='optionsRadios1' and contains(@data-content,'Home delivery')]","Cart - Home Delivery"};
	public static final String[] CHK_PICKUP_AT_SERVICE = {"//div[@class='popover-content input']//input[@id='optionsRadios2' and contains(@data-content,'Pickup at Service')]","Pick Up at Service"};
	public static final String[] WLS_PICKUP_LIST = {"//*[@id='serviceCenter']","Pickup point"};
	public static final String[] BTN_CLICK_OUTSIDE = {"//div[2]/div[3]/div[1]/div/div/table/thead/tr/th[4]","Click Somewhere"};
	public static final String[] BTN_EDIT_SHIPPING_ADDRESS = {"//div[2]/div[3]/div[3]/div/div/div[1]/div[1]/button","Edit Shipping Address"};
	public static final String[] BTN_REDEEM_FROM_CART = {"//div[2]/div[3]/div[7]/div[2]/button","Redeem From Cart"};
	
	/*Shipping Address*/
	public static final String[] TXT_REDEEM_SHIPPING_ADDRESS_NO = {"//div[2]/div[3]/div[3]/div/div/div[4]/div[2]/div[1]/input","Shipping Address No."};
	public static final String[] TXT_REDEEM_VILLAGE_OR_BUILDING = {"//div[2]/div[3]/div[3]/div/div/div[4]/div[2]/div[2]/input","Village or Building"};
	public static final String[] TXT_REDEEM_SOI = {"//div[2]/div[3]/div[3]/div/div/div[4]/div[2]/div[3]/input","Redeem"};
	public static final String[] TXT_REDEEM_STREET = {"//div[2]/div[3]/div[3]/div/div/div[4]/div[2]/div[4]/input","Street"};
	public static final String[] TXT_REDEEM_SUB_DISTRICT = {"//div[2]/div[3]/div[3]/div/div/div[4]/div[2]/div[5]/input","Sub-District"};
	public static final String[] TXT_REDEEM_DISTRICT = {"//div[2]/div[3]/div[3]/div/div/div[4]/div[2]/div[6]/input","District"};
	public static final String[] WLS_REDEEM_PROVINCE = {"//div[2]/div[3]/div[3]/div/div/div[4]/div[2]/div[7]/select","City"};
	public static final String[] TXT_REDEEM_ZIPCODE = {"//div[2]/div[3]/div[3]/div/div/div[4]/div[2]/div[8]/input","Zip-Code"};
	public static final String[] CHK_SAVE_THIS_ADDRESS = {"//div[2]/div[3]/div[3]/div/div/div[4]/div[3]/div[1]/label/input","Save This Address"};
	public static final String[] BTN_SAVE_SHIPPING_ADDRESS = {"//div[2]/div[3]/div[3]/div/div/div[4]/div[3]/div[2]/button","Save Shipping Address"};
	
	public static final String[] LBL_POINTS_BALANCE = {"//div[2]/div/div/div[2]/div[2]/div[1]/span","Points Balance"};
	
	/*Point Deduction Popup*/
	public static final String[] WLS_DELIVERY_OPTION_REDEEM = {"//button[@class='btn btn-block btn-sm btn-delivery']","Redeem - Delivery Option"};
	public static final String[] CHK_HOME_DELIVERY_REDEEM = {"//div[@class='popover-content input']//input[@id='optionsRadios1']","Redeem - Home Delivery"};
	public static final String[] CHK_REDEEM_TERMS_CONDITIONS = {"//input[@name='termConditions']","Redeem - Terms and Conditions"};
	public static final String[] BTN_REDEEM_FROM_POINT_DEDUCTION = {"//button[@class='btn btn-block btn-success' and contains(@data-target,'redeemItem')]","Redeem from Point Deduction"};
	public static final String[] LBL_POINT_DEDUCTION_TITLE = {"//div[@class='modal fade redeem modal-base in' and contains(@style,'block')]//h4[contains(.,' Point deduction')]","Title - Point Deduction"};
	public static final String[] LBL_REDEEM_SUCCESS = {"//div[@class='modal fade redeem-success modal-base in' and contains(@style,'block')]//h5","Redeem Success"};
	public static final String[] BTN_CLOSE_REDEEM_SUCCESS = {"//div[@class='modal fade redeem-success modal-base in' and contains(@style,'block')]//button/span","Close Redeem Success"};
	
}

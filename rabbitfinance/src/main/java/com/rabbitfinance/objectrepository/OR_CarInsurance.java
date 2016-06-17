package com.rabbitfinance.objectrepository;

public class OR_CarInsurance {

	/*MAIN PAGE*/
	public static final String[] BTN_EN_LANGUAGE = { "//*[@id='rabbit-navbar-collapse']/nav/div/div[1]/div/a", "English Language" };
	public static final String[] WLS_SELECT_CAR = {"//*[@id='head-col-left']/div/div[3]","SELECT YOUR CAR"};
	public static final String[] IMG_RABBIT_FINANCE = {"//*[@id='logo-link']/img","Rabbit Finance Logo"};
	
	/*CAR*/
	public static final String[] WLS_CAR_YEAR = {"//*[@id='auto-years']","Car Year" };
	public static final String[] WLS_CAR_BRAND = { "//*[@id='auto-brands']", "Car Brand" };
	public static final String[] WLS_CAR_MODEL = { "//*[@id='auto-models']", "Car Model" };
	public static final String[] WLS_SUB_MODEL = { "//*[@id='auto-submodels']", "Sub Model" };
	public static final String[] RDO_CAR_MODIFIED_NO = {"//*[@id='form-section-car']/div[5]/div[2]/label[2]/input","The car has been modified? - NO"};
	public static final String[] RDO_CAR_MODIFIED_YES = {"//*[@id='form-section-car']/div[5]/div[2]/label[1]/input","The car has been modified? - YES"};
	public static final String[] BTN_MODIFIED_VALUE_ARROW_UP = {"//*[@id='modification-value-container']/div[2]/div/div/div[2]","Modified Value - Arrow Up"}; 
	public static final String[] BTN_MODIFIED_VALUE_ARROW_DOWN = {"//*[@id='modification-value-container']/div[2]/div/div/div[1]","Modified Value - Arrow Up"};
	public static final String[] TXT_MODIFIED_VALUE = {"//*[@id='modification-value']","Modified Value"};
	public static final String[] BTN_NEXT_CAR_FORM = {"//*[@id='form-section-car']/div[7]/div[1]/button","Next"};
	
	/*DISCOUNTS*/
	public static final String[] BTN_GENDER_FEMALE = {"//*[@id='female-btn']","Gender - Female"};
	public static final String[] BTN_GENDER_MALE = {"//*[@id='male-btn']","Gender - Male"};
	public static final String[] RDO_INSURANCE_CLAIM_NO = {"//*[@id='form-section-discount']/div[2]/div[2]/label[2]/input","Insurance Claim Last Year? - NO"};
	public static final String[] RDO_INSURANCE_CLAIM_YES = {"//*[@id='form-section-discount']/div[2]/div[2]/label[1]/input","Insurance Claim Last Year? - YES"};
	public static final String[] BTN_ONE_DRIVER = {"//*[@id='one-driver-btn']/div","One Driver"};
	public static final String[] BTN_TWO_DRIVER = {"//*[@id='two-driver-btn']/div","Two Driver"};
	public static final String[] BTN_MANY_DRIVER = {"//*[@id='many-driver-btn']/div","Many Driver"};
	public static final String[] TXT_YOUNGEST_DRIVER_AGE = {"//*[@id='young-driver-age-container']/div[2]/div/input","Youngest Driver Age"};
	public static final String[] WLS_REGISTER_CAR_PLACE = {"//*[@id='form-section-discount']/div[5]/div[2]/div/select","Where did you register your car?"};
	public static final String[] BTN_NEXT_DISCOUNTS_FORM = {"//*[@id='form-section-discount']/div[6]/div[2]/button","Next"};
	
	/*OPTIONS*/
	public static final String[] RDO_COMPULSARY_INSURANCE_NO = {"//*[@id='form-section-policy']/div[1]/div[2]/label[2]/input","Mandatory Insurance - NO"};
	public static final String[] RDO_COMPULSARY_INSURANCE_YES = {"//*[@id='form-section-policy']/div[1]/div[2]/label[1]/input","Mandatory Insurance - YES"};
	public static final String[] TXT_POLICY_START_COVERING = {"//*[@id='form-section-policy']/div[2]/div[2]/div/input","Policy covering start date"};
	public static final String[] BTN_SEE_QUOTES = {"//*[@id='see-quote']/button","SEE QUOTES"};
	
	/*LEAD POPUP*/
	public static final String[] TXT_PHONE_LEAD_POPUP = {"//*[@id='lead-popup-form']/div/input","Phone Number on Lead Popup"};
	public static final String[] BTN_VIEW_YOUR_RESULTS = {"//*[@id='create-lead']","View Your Results Button"};
	public static final String[] BTN_BACK_LEAD_POPUP = {"//*[@id='popup-lead']/div/div/div/div/div[1]/div[2]/div[1]/a/span","Back button on lead popup"};
	public static final String[] LBL_PHONE_SUCCESS = {"//*[@id='phone-success']","Correct Phone Number"};
	public static final String[] LBL_PHONE_ERROR = {"//*[@id='phone-error']","Wrong Phone Number"};
	
	/*RESULTS PAGE*/
	public static final String[] BTN_TYPE_1 = {"//*[@id='insurance-type-button']/div[1]/button","TYPE 1"};
	public static final String[] BTN_TYPE_2 = {"//*[@id='insurance-type-button']/div[2]/button","TYPE 2"};
	public static final String[] BTN_TYPE_3 = {"//*[@id='insurance-type-button']/div[3]/button","TYPE 3"};
	public static final String[] BTN_PROCEED_TO_LEAD = {"//*[@id='package-container']/div[1]/div[1]/ul/li[9]/button","Proceed Button"};
	public static final String[] LBL_DUPLICATE_MESSAGE = {"//*[@id='converted-to-order' and @class='alert alert-danger']","Duplication Message"};
	
	/*CAR DETAILS ON RESULTS*/
	public static final String[] LBL_PRODUCTION_YEAR = {"//*[@id='selected-car-year']","Production Year"};
	public static final String[] LBL_BRAND = {"//*[@id='selected-car-brand']","Brand"};
	public static final String[] LBL_MODEL = {"//*[@id='selected-car-model']","Model"};
	public static final String[] BTN_CHANGE_CAR = {"//*[@id='side-panel']/div[1]/a","Change Car"};
	
	/*INSURANCE OPTIONS*/
	public static final String[] LBL_LIMIT_DRIVER_NO = {"//*[@id='side-panel']/div[2]/ul/li[1]/i[contains(@class,'ricon-check-circle ricon pull-right')]","Inactive Limit Driver"};
	public static final String[] LBL_LIMIT_DRIVER_YES = {"//*[@id='side-panel']/div[2]/ul/li[1]/i[contains(@class,'active')]","Active Limit Driver"};
	public static final String[] LBL_INCLUDES_MANDATORY_NO = {"//*[@id='side-panel']/div[2]/ul/li[2]/i[contains(@class,'ricon-check-circle ricon pull-right')]","Inactive Insurance Mandatory"};
	public static final String[] LBL_INCLUDES_MANDATORY_YES = {"//*[@id='side-panel']/div[2]/ul/li[2]/i[contains(@class,'active')]","Active Insurance Mandatory"};
	public static final String[] LBL_CLAIMED_LAST_YEAR_NO = {"//*[@id='side-panel']/div[2]/ul/li[3]/i[contains(@class,'ricon-check-circle ricon pull-right')]","Inactive Claimed Last Year"};
	public static final String[] LBL_CLAIMED_LAST_YEAR_YES = {"//*[@id='side-panel']/div[2]/ul/li[3]/i[contains(@class,'active')]","Active Claimed Last Year"};
	
	
	/*PERSONAL DEAILS*/
	public static final String[] TXT_EMAIL = {"//*[@id='form-section-detail']/div[1]/div[1]/div/input","Email"};
	public static final String[] TXT_PHONE = {"//*[@id='form-section-detail']/div[2]/div[1]/div/input","Phone"};
	public static final String[] RDO_GENDER_MALE_PERSONAL = {"//*[@id='form-section-detail']/div[3]/div[1]/label[1]/input","Gender - Male - Personal Details"};
	public static final String[] RDO_GENDER_FEMALE_PERSONAL = {"//*[@id='form-section-detail']/div[3]/div[1]/label[2]/input","Gender - Female - Personal Details"};
	public static final String[] TXT_FIRST_NAME = {"//*[@id='form-section-detail']/div[4]/div[1]/div/input","First Name"};
	public static final String[] TXT_LAST_NAME = {"//*[@id='form-section-detail']/div[5]/div[1]/div/input","Last Name"};
	public static final String[] TXT_DATEOFBIRTH = {"//*[@id='form-section-detail']/div[6]/div[1]/div/input","Date of Birth"};
	public static final String[] BTN_NEXT_PERSONAL_DETAILS = {"//*[@id='form-section-detail']/div[7]/div[1]/button","NEXT - Personal Details"};
	
	/*ADDRESS*/
	public static final String[] TXT_ADDRESS_LINE = {"//*[@id='form-section-address']/div[1]/div[1]/div/input","Address Line"};
	public static final String[] WLS_PROVINCE_CITY = {"//*[@id='select-provinces']","Province / City"};
	public static final String[] WLS_DISTRICT = {"//*[@id='select-districts']","District"};
	public static final String[] WLS_SUB_DISTRICT = {"//*[@id='select-sub-districts']","Sub District"};
	public static final String[] TXT_ZIP_CODE = {"//*[@id='form-section-address']/div[5]/div[1]/div/input","Zip Code"};
	public static final String[] BTN_NEXT_ADDRESS_FORM = {"//*[@id='form-section-address']/div[6]/div[2]/button","NEXT - Address Form"};
	
	/*PAYMENT*/
	public static final String[] TXT_INSURANCE_COVERAGE_START = {"//*[@id='form-section-payment']/div[1]/div[1]/div/input","Start of Insurance Coverage"};
	public static final String[] BTN_5_PERCENT_DISCOUNT = {"//*[@id='payment-type-container']/div[1]/div[2]/button","Online Discount 5%"};
	public static final String[] BTN_0_PERCENT_DISCOUNT = {"//*[@id='payment-type-container']/div[2]/div[2]/button","Installments 0%"};
	public static final String[] RDO_EDC_PAYMENT = {"//*[@id='form-section-payment']/div[3]/div[1]/div[1]/label/input","EDC Payment"};
	public static final String[] RDO_BANK_TRANSFER_PAYMENT = {"//*[@id='form-section-payment']/div[3]/div[1]/div[2]/label/input","Bank Transfer Payment"};
	public static final String[] WLS_SELECT_BANK = {"//*[@id='one-time-container-options']/div[1]/div/select","Select Bank"};
	public static final String[] BTN_PROCEED_TO_CONFIRMATION = {"//*[@id='form-section-payment']/div[7]/div[2]/button","Proceed button"};
	public static final String[] WLS_CREDIT_CARD = {"//*[@id='form-section-payment']/div[5]/div[1]/div/select","Select your credit card"};
	public static final String[] WLS_INSTALLMENT_PERIOD = {"//*[@id='installment-period']/div[1]/div/select","Installment Period"};
	
	/*CONFIRMATION*/
	public static final String[] LBL_THANKS_MESSAGE = {"//*[@id='ref-number']/div[1]/strong","Confirmation Message"};
	public static final String[] LBL_REFERENCE_NUMBER = {"//*[@id='ref-number']/div[2]","Reference Number"};
	
	
}

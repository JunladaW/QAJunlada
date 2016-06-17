package com.rabbitnana.objectrepository;

public class OR_TabInfo {

	/* Tab Colors */
	public static final String[] TAB_RED_CUSTOMER_INFO = {
			"//*[@id='customer-info-list' and contains(@class,'bg-danger customer-info')]",
			"Customer Info tab - Red Color" };
	public static final String[] TAB_GREEN_CUSTOMER_INFO = {
			"//*[@id='customer-info-list' and contains(@class,'customer-info bg-success')]",
			"Customer Info tab - Green Color" };
	public static final String[] TAB_RED_CAR_INFO = {
			"//*[@id='car-info-list' and contains(@class,'bg-danger car-info')]", "Car Info tab - Red Color" };
	public static final String[] TAB_GREEN_CAR_INFO = {
			"//*[@id='car-info-list' and contains(@class,'car-info bg-success')]", "Car Info tab - Green Color" };
	public static final String[] TAB_RED_DRIVER_INFO = {
			"//*[@id='driver-info-list' and contains(@class,'bg-danger driver-info')]", "Driver Info tab - Red Color" };
	public static final String[] TAB_GREEN_DRIVER_INFO = {
			"//*[@id='driver-info-list' and contains(@class,'driver-info bg-success')]",
			"Driver Info tab - Green Color" };
	public static final String[] TAB_RED_POLICY_INFO = {
			"//*[@id='policy-info-list' and contains(@class,'bg-danger policy-info')]", "Policy Info tab - Red Color" };
	public static final String[] TAB_GREEN_POLICY_INFO = {
			"//*[@id='policy-info-list' and contains(@class,'policy-info bg-success')]",
			"Policy Info tab - Green Color" };
	public static final String[] TAB_RED_ADDRESS = { "//*[@id='address-list' and contains(@class,'bg-danger address')]",
			"Address tab - Red Color" };
	public static final String[] TAB_GREEN_ADDRESS = {
			"//*[@id='address-list' and contains(@class,'address bg-success')]", "Address tab - Green Color" };
	public static final String[] TAB_RED_BILLING_ADDRESS = {
			"//*[@id='billing-address-list' and contains(@class,'bg-danger billing-address')]",
			"Billing Address tab - Red Color" };
	public static final String[] TAB_GREEN_BILLING_ADDRESS = {
			"//*[@id='billing-address-list' and contains(@class,'billing-address bg-success')]",
			"Billing Address tab - Green Color" };
	public static final String[] TAB_RED_SHIPPING_ADDRESS = {
			"//*[@id='shipping-address-list' and contains(@class,'bg-danger shipping-address')]",
			"Shipping Address tab - Red Color" };
	public static final String[] TAB_GREEN_SHIPPING_ADDRESS = {
			"//*[@id='shipping-address-list' and contains(@class,'shipping-address bg-success')]",
			"Shipping Address tab - Green Color" };
	public static final String[] TAB_RED_DOCS = {
			"//*[@id='documents-list' and contains(@class,'bg-danger documents')]", "Docs tab - Red Color" };
	public static final String[] TAB_GREEN_DOCS = {
			"//*[@id='documents-list' and contains(@class,'documents bg-success')]", "Docs tab - Green Color" };

	/* Hidden tabs */
	public static final String[] TAB_HIDDEN_SHIPPING_ADDRESS = {
			"//*[@id='shipping-address-list' and contains(@class,'bg-danger shipping-address hidden')]",
			"Shipping Adress Tab Hidden" };
	public static final String[] TAB_HIDDEN_DOCS = {
			"//*[@id='documents-list' and contains(@class,'bg-danger documents hidden')]", "Docs Tab Hidden" };

	/* Check disable sections */
	public static final String[] FIELD_CAR_INFO_DISABLED = {
			"//*[@id='car-info-fieldset' and contains(@disabled,'disabled')]", "Car info disabled" };
	public static final String[] FIELD_DRIVER_INFO_DISABLED = {
			"//*[@id='driver-info-fieldset' and contains(@disabled,'disabled')]", "Driver info disabled" };
	public static final String[] FIELD_POLICY_INFO_DISABLED = {
			"//*[@id='policy-info-fieldset' and contains(@disabled,'disabled')]", "Policy info disabled" };
	public static final String[] FIELD_ADDRESS_DISABLED = {
			"//*[@id='address-fieldset' and contains(@disabled,'disabled')]", "Address disabled" };
	public static final String[] FIELD_SHIPPING_ADDRESS_DISABLED = {
			"//*[@id='billing-address-fieldset' and contains(@disabled,'disabled')]", "Shipping Address disabled" };

	/* Customer Info */
	public static final String[] LBL_MANDATORY_EMAIL = {
			"//*[@id='customer-info-fieldset']//label[@for='email' and contains(@class,'required')]",
			"Mandatory Email" };
	public static final String[] LBL_MANDATORY_FIRST_NAME = {
			"//*[@id='customer-info-fieldset']//label[@for='firstname' and contains(@class,'required')]",
			"Mandatory First Name" };
	public static final String[] LBL_MANDATORY_COMPANY = {
			"//*[@id='customer-info-fieldset']//label[@for='company' and contains(@class,'required')]",
			"Mandatory Company" };
	public static final String[] LBL_LEAD_CUSTOMER_PHONE = { "//*[@id='lead-phone']", "Customer - Phone" };
	public static final String[] TXT_LINE_ID = { "//*[@id='line_id']", "Line ID" };
	public static final String[] RDO_LEAD_CUSTOMER_LANGUAGE_EN = { "//input[@class='customer-lang-th']",
			"Customer Language - EN" };
	public static final String[] RDO_LEAD_CUSTOMER_LANGUAGE_TH = { "//input[@class='customer-lang-en']",
			"Customer Language - TH" };
	public static final String[] TXT_LEAD_CUSTOMER_EMAIL = { "//*[@name='email']", "Customer - Email" };
	public static final String[] TXT_LEAD_CUSTOMER_FIRSTNAME = { "//*[@id='firstname']", "Customer - First Name" };
	public static final String[] TXT_LEAD_CUSTOMER_LASTNAME = { "//*[@id='lastname']", "Customer - Last Name" };
	public static final String[] RDO_ORDER_FOR_COMPANY_YES = {
			"//*[@id='customer-info-fieldset']/div[8]/div/label[1]/input", "Order for Comapny - Yes" };
	public static final String[] RDO_ORDER_FOR_COMPANY_NO = {
			"//*[@id='customer-info-fieldset']/div[8]/div/label[2]/input", "Order for Comapny - No" };
	public static final String[] TXT_COMPANY = { "//*[@id='employer']", "Company" };
	public static final String[] BTN_CONVERT_TO_OPPORTUNITY = { "//*[@id='sales-convert-to-opportunity']",
			"Convert to opportunity" };
	public static final String[] BTN_SALES_DELETE = { "//*[@id='sales-delete']", "Sales Delete" };

	/* Car Info */
	public static final String[] WLS_CAR_YEAR = { "//*[@id='car-year']", "Car Year" };
	public static final String[] WLS_CAR_BRAND = { "//*[@id='car-brand']", "Car Brand" };
	public static final String[] WLS_CAR_MODEL = { "//*[@id='car-model']", "Car Model" };
	public static final String[] WLS_CAR_SUBMODEL = { "//*[@id='car-submodel']", "Car Submodel" };
	public static final String[] IS_PRESENT_CAR_TYPE = { "//*[@id='car-type']", "Car Type" };
	public static final String[] IS_PRESENT_NUMBER_OF_DOORS = { "//*[@id='car-num-of-doors']", "No of Doors" };
	public static final String[] IS_PRESENT_CAR_ENGINE = { "//*[@id='car-engine']", "Car Engine" };
	public static final String[] TXT_LICENSE_PLATE = { "//*[@id='car-license-plate']", "License Plate" };
	public static final String[] TXT_CHASSIS_NUMBER = { "//*[@id='car-chassis-num']", "Chassis Number" };
	public static final String[] TXT_VEHICLE_IDENTIFICATION_NUMBER = { "//*[@id='vehicle-id-num']",
			"Vehicle Identification Number" };
	public static final String[] RDO_DRIVING_PURPOSE_PERSONAL = {
			"//*[@class='driving-purpose' and contains(@value,'Personal')]", "Driving Purpose - Personal" };
	public static final String[] RDO_DRIVING_PURPOSE_COMMERCIAL = {
			"//*[@class='driving-purpose' and contains(@value,'Commercial')]", "Driving Purpose - Commercial" };
	public static final String[] RDO_MODIFICATIONS_NO = { "//input[@class='modification' and contains(@value,'0')]",
			"Modifications No" };
	public static final String[] RDO_MODIFICATIONS_YES = { "//input[@class='modification' and contains(@value,'1')]",
			"Modifications Yes" };
	public static final String[] WLS_MODIFICATION_VALUE = { "//*[@id='modification-holder']/div/div/div[1]/select",
			"Modification Value" };
	public static final String[] WLS_MODIFICATION_VALUE_DISABLED = { "", "Selected Modification Disabled" };
	public static final String[] TXT_MODIFICATION_AMOUNT = { "//*[@id='modification-holder']/div[1]/div/div[2]/input",
			"Modification Amount" };
	public static final String[] BTN_CAR_INFO_SAVE = { "//*[@id='car-info-save-btn']", "Save Car Info" };

	/* Driver Info */
	public static final String[] RDO_DRIVE_THAILAND = { "//*[@id='driver-info-fieldset']//input[@value='Thailand']",
			"Drive Thailand" };
	public static final String[] RDO_DRIVE_SOME_PROVINCES = {
			"//*[@id='driver-info-fieldset']//input[@value='provinces']", "Drive Some Provinces" };
	public static final String[] TXT_PROVINCES = { "//*[@id='s2id_autogen1']", "Provinces" };
	public static final String[] RDO_CUSTOMER_MAIN_DRIVER_YES = { "//*[@id='customer-main-driver-yes-btn']",
			"Customer Main Driver - Yes" };
	public static final String[] RDO_CUSTOMER_MAIN_DRIVER_NO = { "//*[@id='customer-main-driver-no-btn']",
			"Customer Main Driver - No" };
	public static final String[] TXT_DRIVER_1_FIRST_NAME = { "//*[@id='driver-1-firstname']",
			"Fixed driver 1 - First Name" };
	public static final String[] TXT_DRIVER_1_LAST_NAME = { "//*[@id='driver-1-lastname']",
			"Fixed driver 1 - Last Name" };
	public static final String[] CAL_DRIVER_1_DOB = { "//*[@data-name='first_driver_dob']", "Calender Driver 1 DOB" };
	public static final String[] TXT_DRIVER_1_DOB = { "//*[@id='driver-1-dob']", "Fixed driver 1 - Date of Birth" };
	public static final String[] TXT_DRIVER_1_NATIONALID = { "//*[@id='driver-1-national-id']",
			"Fixed driver 1 - National ID" };
	public static final String[] TXT_DRIVER_1_DRIVER_LICENSE = { "//*[@id='driver-1-license-num']",
			"Fixed driver 1 - Driver License" };
	public static final String[] RDO_DRIVER_2_YES = { "//*[@id='fixed-driver-num-2-yes-btn']", "Fixed driver 2 - Yes" };
	public static final String[] RDO_DRIVER_2_NO = { "//*[@id='fixed-driver-num-2-no-btn']", "Fixed driver 2 - No" };
	public static final String[] TXT_DRIVER_2_FIRST_NAME = { "//*[@id='driver-2-firstname']",
			"Fixed driver 2 - First Name" };
	public static final String[] TXT_DRIVER_2_LAST_NAME = { "//*[@id='driver-2-lastname']",
			"Fixed driver 2 - Last Name" };
	public static final String[] CAL_DRIVER_2_DOB = { "//*[@data-name='second_driver_dob']", "Calender Driver 2 DOB" };
	public static final String[] TXT_DRIVER_2_DOB = { "//*[@id='driver-2-dob']", "Fixed driver 2 - Date of Birth" };
	public static final String[] TXT_DRIVER_2_NATIONALID = { "//*[@id='driver-2-national-id']",
			"Fixed driver 2 - National ID" };
	public static final String[] TXT_DRIVER_2_DRIVER_LICENSE = { "//*[@id='driver-2-license-num']",
			"Fixed driver 2 - Driver License" };
	public static final String[] BTN_DRIVER_INFO_SAVE = { "//*[@id='driver-info-save-btn']", "Save Driver Info" };
	public static final String[] TOTAL_PROVINCE_LIST = { "//*[contains(@id,'select2-drive-provinces-result-')]",
			"Total Province" };
	public static final String[] UL_SELECT_PROVINCE = {
			"//*[starts-with(@id,'select2-drive-provinces-result-') and contains(.,'%s') and contains(@aria-selected,'false')]",
			"Select Province" };
	public static final String[] TXT_SELECTED_PROVINCE = { "//*[@id='provinces-holder']//li[%s]", "Selected Province" };
	public static final String[] TOTAL_SELECTED_PROVINCE = { "//*[@id='provinces-holder']//li",
			"Total Selected Province" };
	public static final String[] BTN_PROVICE_BOX = { "//*[@id='provinces-holder']//li/input", "Province" };

	/* Policy Info */
	public static final String[] WLS_LAST_INSURER = { "//*[@id='last-insurer']", "Your Last Insurer" };
	public static final String[] TXT_LAST_PRICE_DISABLED = { "//*[@id='last-price' and contains(@disabled,.)]",
			"Last Price of Insurance" };
	public static final String[] TXT_OLD_POLICY_EXPIRY_DISABLED = {
			"//*[@id='expire-date-old-policy' and contains(@disabled,.)]", "Expiry of Old Policy" };
	public static final String[] TXT_LAST_PRICE = { "//*[@id='last-price']", "Insurer Last Price" };
	public static final String[] TXT_EXPIRY_OLD_POLICY = { "//*[@id='expire-date-old-policy']", "Expiry Old Policy" };
	public static final String[] RDO_CLAIMED_LAST_YEAR_YES = { "//*[@id='policy-info-fieldset']//input[@value='1']",
			"Claimed Last Year - Yes" };
	public static final String[] RDO_CLAIMED_LAST_YEAR_NO = { "//*[@id='policy-info-fieldset']//input[@value='0']",
			"Claimed Last Year - No" };
	public static final String[] TXT_NEW_POLICY_DATE = { "//*[@id='start-date-new-policy']", "New Policy Date" };
	public static final String[] BTN_CAL_START_POLICY = { "//*[@data-name='policy_start_date']",
			"Calender - Start Policy Date" };
	public static final String[] BTN_POLICY_INFO_SAVE = { "//*[@id='policy-info-save-btn']", "Save Policy Info" };

	/* Customer Address */
	public static final String[] WLS_CUSTOMER_PROVINCE = { "//*[@id='addr-province-2']",
			"Customer Address - Province" };
	public static final String[] WLS_CUSTOMER_DISTRICT = { "//*[@id='addr-district-2']",
			"Customer Address - District" };
	public static final String[] WLS_CUSTOMER_SUB_DISTRICT = { "//*[@id='addr-sub-district-2']",
			"Customer Address - Sub District" };
	public static final String[] WLS_CUSTOMER_ADDRESS_1 = { "//*[@id='addr-line1-2']", "Customer Address Line #1" };
	public static final String[] WLS_CUSTOMER_ADDRESS_2 = { "//*[@id='addr-line2-2']", "Customer Address Line #2" };
	public static final String[] TXT_CUSTOMER_ZIP_CODE = { "//*[@id='addr-zip-code-2']",
			"Customer Address - Zip Code" };
	public static final String[] BTN_CUSTOMER_ADDRESS_SAVE = { "//*[@id='address-save-btn']",
			"Customer Address - Save" };

	/* Billing Address */
	public static final String[] RDO_BILLING_ADDRESS_YES = { "//*[@id='same-billing-address-yes-btn']",
			"Billing Address - Yes" };
	public static final String[] RDO_BILLING_ADDRESS_NO = { "//*[@id='same-billing-address-no-btn']",
			"Billing Address - No" };
	public static final String[] WLS_BILLING_PROVINCE = { "//*[@id='addr-province-0']", "Billing Address - Province" };
	public static final String[] WLS_BILLING_DISTRICT = { "//*[@id='addr-district-0']", "Billing Address - District" };
	public static final String[] WLS_BILLING_SUB_DISTRICT = { "//*[@id='addr-sub-district-0']",
			"Billing Address - Sub District" };
	public static final String[] WLS_BILLING_ADDRESS_1 = { "//*[@id='addr-line1-0']", "Billing Address Line #1" };
	public static final String[] WLS_BILLING_ADDRESS_2 = { "//*[@id='addr-line2-0']", "Billing Address Line #2" };
	public static final String[] TXT_BILLING_ZIP_CODE = { "//*[@id='addr-zip-code-0']", "Billing Address - Zip Code" };
	public static final String[] BTN_BILLING_ADDRESS_SAVE = { "//*[@id='billing-address-save-btn']",
			"Billing Address - Save" };

	/* Shipping Address */
	public static final String[] RDO_SHIPPING_ADDRESS_YES = { "//*[@id='same-shipping-address-yes-btn']",
			"Shipping Address - Yes" };
	public static final String[] RDO_SHIPPING_ADDRESS_NO = { "//*[@id='same-shipping-address-no-btn']",
			"Shipping Address - No" };
	public static final String[] WLS_SHIPPING_PROVINCE = { "//*[@id='addr-province-1']",
			"Shipping Address - Province" };
	public static final String[] WLS_SHIPPING_DISTRICT = { "//*[@id='addr-district-1']",
			"Shipping Address - District" };
	public static final String[] WLS_SHIPPING_SUB_DISTRICT = { "//*[@id='addr-sub-district-1']",
			"Shipping Address - Sub District" };
	public static final String[] WLS_SHIPPING_ADDRESS_1 = { "//*[@id='addr-line1-1']", "Shipping Address Line #1" };
	public static final String[] WLS_SHIPPING_ADDRESS_2 = { "//*[@id='addr-line2-1']", "Shipping Address Line #2" };
	public static final String[] TXT_SHIPPING_ZIP_CODE = { "//*[@id='addr-zip-code-1']",
			"Shipping Address - Zip Code" };
	public static final String[] BTN_SHIPPING_ADDRESS_SAVE = { "//*[@id='shipping-address-save-btn']",
			"Shipping Address - Save" };

	/* Upload Documents */
	public static final String[] BTN_CAR_REGISTRATION = { "//*[@id='car-registration-anchor']", "Car Registration" };
	public static final String[] LNK_CAR_REGISTRATION_ACTIVE = {
			"//li[@class='bg-success active']//a[@id='car-registration-anchor']", "Car Registration Active" };
	public static final String[] LNK_DOWNLOAD_CAR_REGISTRATION = {
			"//*[@id='car-registration']//a[@class='file-download']", "Download Link - Car Registration" };
	public static final String[] BTN_ID_CARD = { "//*[@id='id-card-anchor']", "ID Card" };
	public static final String[] LNK_ID_CARD_ACTIVE = { "//li[@class='bg-success active']//a[@id='id-card-anchor']",
			"ID Card Active" };
	public static final String[] LNK_DOWNLOAD_ID_CARD = { "//*[@id='id-card']//a[@class='file-download']",
			"Download Link - ID Card" };

	/* Quotes tab */
	public static final String[] BTN_QUOTES_TAB = { "//*[@id='quotes-tab-btn']/a", "Quotes tab" };
	public static final String[] RDO_INSURANCE_TYPE = {
			"//*[@id='insurance-type']//input[@name='car_insurance_type' and @value='%s']", "Insurance Type" };
	public static final String[] RDO_INCLUDE_MANDATORY = {
			"//*[@id='include-mandatory']//input[@name='is_mandatory_policy_required' and @value='%s']",
			"Include Mandatory" };
	public static final String[] RDO_REPAIR = { "//*[@id='repair']//input[@name='car_repair_type' and @value='%s']",
			"Repair" };
	public static final String[] RDO_DEDUCTIBLE = {
			"//*[@id='deductible']//input[@name='has_deductible' and @value='%s']", "Deductible" };
	public static final String[] WLS_INSURANCE_COMPANY = { "//*[@id='insurance-company-id']", "Insurance Company" };
	public static final String[] RDO_CLAIMED_LAST_YEAR = {
			"//*[@id='fixed-driver-claim']//input[@name='has_claimed_last_year' and @value='%s']",
			"Claimed Last Year" };
	public static final String[] BTN_SEARCH_QUOTES = { "//*[@id='quotes-search-btn']", "Search Quotes" };
	public static final String[] COUNT_QUOTES_LIST = { "//*[contains(@id,'quote-selection-')]", "Total Quote List" };
	public static final String[] CKB_SINGLE_QUOTATION = { "//*[contains(@id,'quote-selection-')]", "Quotes Checkbox" };
	public static final String[] LBL_SINGLE_QUOTATION_TYPE = { "//*[contains(@id,'package-row-')]/td[4]",
			"Quotation Type" };
	public static final String[] BTN_SEND_QUOTATION_ENGLISH = { "//*[@id='quotes-list']//button[@data-locale='en']",
			"Send Quotation English" };
	public static final String[] BTN_SEND_QUOTATION_THAI = { "//*[@id='quotes-list']//button[@data-locale='th']",
			"Send Quotation English" };
	public static final String[] BTN_SUBMIT_QUOTATION = { "//*[@id='wrapper']//div[@class='btn btn-ask-submit']",
			"Submit Quotation" };
	public static final String[] LBL_QUOTATION_SUCCESS = {
			"//*[@id='quotes-list']//div[@class='notifyjs-bootstrap-base notifyjs-bootstrap-success']",
			"Quotation Success" };
	public static final String[] LBL_QUOTATION_SENT_TO = { "//*[@id='quotes-list']//span", "Quotation Sent" };
	public static final String[] BTN_QUOTATION_SEND_NOW_SINGLE = {
			"//*[contains(@id,'package-row-')]//button[@class='btn btn-xs place-order inline btn-success']",
			"Quotation - Buy Now" };
	public static final String[] BTN_QUOTATION_SEND_NOW = {
			"//*[@id='package-row-%s']//button[@class='btn btn-xs place-order inline btn-success']",
			"Quotation - Buy Now" };
	public static final String[] BTN_BUY_NOW_OK = { "//button[@class='btn btn-primary' and contains(.,'OK')]",
			"Proceed to Buy Now - Ok" };
	public static final String[] LBL_INVOICE_SUCCESS = {
			"//div[@class='notifyjs-bootstrap-base notifyjs-bootstrap-success']//span", "Invoice Sent Successfully" };
	public static final String[] LBL_YOUNGEST_DRIVER_DOB = { "//*[@id='youngest-driver-dob']",
			"Youngest Driver's DOB" };
	public static final String[] LBL_QUOTE_FINAL_PRICE = { "//*[@id='package-row-%s']/td[8]/span",
			"Quote Final Price" };
	public static final String[] LBL_QUOTE_FINAL_PRICE_SINGLE = { "//*[contains(@id,'package-row-')]/td[8]/span",
			"Single Final Price" };
	public static final String[] TOTAL_FINAL_PRICE_LIST = { "//*[contains(@id,'package-row-')]/td[8]/span",
			"Total Final Price List" };
	public static final String[] RDO_GIFT_CAR_DVR = { "//*[@id='gifts-body']/div[1]/label/input",
			"Gift - Car DVR + vouchers" };
	public static final String[] RDO_GIFT_PTT_CARD = { "//*[@id='gifts-body']/div[2]/label/input",
			"Gift - PTT card + vouchers" };
	public static final String[] RDO_GIFT_VOUCHERS = { "//*[@id='gifts-body']/div[3]/label/input", "Gift - Vouchers" };
	public static final String[] BTN_GIFT_SAVE = { "//*[@id='gifts-action']", "Save Gift" };
	public static final String[] LBL_GIFT_POPUP = { "//*[@id='gifts-label']", "Gift Label" };

	/* Payment tab */
	public static final String[] BTN_PAYMENT_TAB = { "//*[@id='payments-tab-btn']/a", "Payment tab" };
	public static final String[] RDO_PAYMENT_OPTIONS = { "//*[@id='payment-options']//input[@value='%s']",
			"Payment Options" };
	public static final String[] RDO_PAYMENT_METHOD = { "//*[@id='onetime-methods']//input[@value='%s']",
			"Payment Method" };
	public static final String[] BTN_PAYMENT_SAVE = { "//*[@id='payment-info-save-btn']", "Save - Payment" };
	public static final String[] TOTAL_BANK_LIST = { "//*[@id='onetime-providers']//input", "Total Bank List" };
	public static final String[] LBL_BANK_NAME = { "//*[@id='onetime-providers']/div[%s]//span", "Bank Name" };
	public static final String[] RDO_BANK_NAME = { "//*[@id='onetime-providers']/div[%s]//input", "Bank Name" };
	public static final String[] TOTAL_BANK_LIST_INSTALLMENT = { "//*[@id='installments-providers']//input",
			"Total Installment Bank List" };
	public static final String[] LBL_BANK_NAME_INSTALLMENT = { "//*[@id='installments-providers']/div[%s]//span",
			"Installment Bank Name" };
	public static final String[] RDO_BANK_NAME_INSTALLMENT = { "//*[@id='installments-providers']/div[%s]//input",
			"Radio Button - Bank Name" };
	public static final String[] RDO_INSTALLMENT_PROVIDERS = {
			"//*[@id='provider-installments']/div[2]/div/label/input", "Installment Period" };

}

package com.rabbitnana.objectrepository;

public class OR_DataEntry {

	/* Package */
	public static final String[] TXT_PACKAGE_NAME = { "//*[@id='package-name']", "Package Name" };
	public static final String[] TXT_FILE_NAME = { "//*[@id='file-name']", "File Name" };
	public static final String[] TXT_EXPIRATION = { "//*[@id='expiration-date-group']/input", "Expiration Date" };
	public static final String[] WLS_INSURANCE_COMPANY = { "//*[@id='insurance-company']", "Insurance Company" };
	public static final String[] WLS_INSURANCE_TYPE = { "//*[@id='insurance-type']", "Insurance Type" };
	public static final String[] WLS_OIC_CODE = { "//*[@id='oic-code']", "OIC Code" };
	public static final String[] RDO_REPAIRER_GARAGE = { "//*[@id='repair-group']/div[1]/label/input", "Repairer - Garage" };
	public static final String[] RDO_REPAIRER_DEALER = { "//*[@id='repair-group']/div[2]/label/input", "Repairer - Dealer" };
	public static final String[] RDO_MODIFICATION_YES = { "//*[@id='modification-group']/div[1]/label/input", "Modification Accepted - Yes" };
	public static final String[] RDO_MODIFICATION_NO = { "//*[@id='modification-group']/div[2]/label/input", "Modification Accepted - No" };
	public static final String[] CKB_FEMALE_ONLY = { "//*[@id='female-only-group']/div/label/input", "Female Only" };

	/* Coverage */
	public static final String[] TXT_LIABILITY_FOR_DAMAGE_PER_PERSON = { "//*[@id='liability-per-person-group']/input", "Liability for damage per person" };
	public static final String[] TXT_LIABILITY_FOR_DAMAGE_PER_TIME = { "//*[@id='liability-per-time-group']/input", "Liability for damage per time" };
	public static final String[] TXT_LIABILITY_FOR_PROPERTY_DAMAGE = { "//*[@id='liability-for-property-group']/input", "Liability for property damage" };
	public static final String[] TXT_PERSONAL_ACCIDENT = { "//*[@id='personal-accident-group']/input", "Personal Accident" };
	public static final String[] WLS_NO_OF_PERSONS_PA = { "//*[@id='personal-accident-no']", "No. of persons PA" };
	public static final String[] TXT_MEDICAL_EXPENSES = { "//*[@id='medical-expenses-group']/input", "Medical Expenses" };
	public static final String[] WLS_NO_OF_PERSONS_ME = { "//*[@id='medical-expenses-no']", "No. of persons ME" };
	public static final String[] TXT_BAIL_BOND = { "//*[@id='bail-bond-group']/input", "Bail Bond" };

	/* Terms and Conditions */
	public static final String[] TXT_TERMS_CONDITIONS_TH = { "//*[@id='terms-and-cond-th']", "Terms and Conditions - TH" };
	public static final String[] TXT_TERMS_CONDITIONS_EN = { "//*[@id='terms-and-cond-en']", "Terms and Conditions - EN" };
	public static final String[] BTN_PROVINCES_SELECT_ALL = { "//*[@id='select-all']", "Province Covered - Select All" };

	/* Car and Sum Insured */
	public static final String[] WLS_CAR_AGE_MIN = { "//*[@id='car-age-group']/div[1]/select", "Car Age - Min" };
	public static final String[] WLS_CAR_AGE_MAX = { "//*[@id='car-age-group']/div[2]/select", "Car Age - Max" };
	public static final String[] TXT_SUM_INSURED_MIN = { "//*[@name='sum_coverage_min']", "Sum Insured - Min" };
	public static final String[] TXT_SUM_INSURED_MAX = { "//*[@name='sum_coverage_max']", "Sum Insured - Max" };
	public static final String[] TXT_DEDUCTIBLE = { "//*[@name='deductible_amount']", "Deductible" };
	public static final String[] TXT_GROSS_PREMIUM = { "//*[@name='price']", "Gross Premium / Price without mandatory" };
	public static final String[] RDO_SINGLE_RATE_FIXED_PREMIUM_YES = { "//*[@name='is_fixed_premium' and @value='1']", "Single rate / Fixed premium - Yes" };
	public static final String[] RDO_SINGLE_RATE_FIXED_PREMIUM_NO = { "//*[@name='is_fixed_premium' and @value='0']", "Single rate / Fixed premium - No" };
	public static final String[] RDO_THEFT_FIRE_COVERAGE_YES = { "//*[@name='fire_theft_coverage' and @value='1']", "Theft and Fire Coverage - Yes" };
	public static final String[] RDO_THEFT_FIRE_COVERAGE_NO = { "//*[@name='fire_theft_coverage' and @value='0']", "Theft and Fire Coverage - No" };
	public static final String[] RDO_FLOOD_COVERAGE_YES = {"//*[@name='flood_coverage' and @value=1]","Flood Coverage Yes"};
	public static final String[] RDO_FLOOD_COVERAGE_NO = {"//*[@name='flood_coverage' and @value=0]","Flood Coverage No"};
	
	/*Search Cars*/
	public static final String[] BTN_CAR_MODEL = {"//*[@id='search-group']//a[contains(text(),'car model')]","Car Model tab"};
	public static final String[] BTN_CAR_GROUP = {"//*[@id='search-group']//a[contains(text(),'car group')]","Car Group tab"};
	public static final String[] TXT_CAR_MODEL_SEARCH = {"//*[@id='search']","Car Model Search"};
	public static final String[] WLS_ENGINE_SIZE = {"//*[@id='search-model-engine-select']","Engine Size"};
	public static final String[] WLS_CAR_GROUP = {"//*[@id='search-car-group-select']","Car Group"};
	public static final String[] TOTAL_CAR_LIST = {"//*[@id='result-submodels']/li","Car List"};
	public static final String[] BTN_ADD_CARS = {"//*[@id='result-submodels']/li[%s]/span","Add Cars"};

	public static final String[] BTN_SAVE_PACKAGE = {"//*[@id='form-save-package']/div[2]/button","Save Package"};
	
}

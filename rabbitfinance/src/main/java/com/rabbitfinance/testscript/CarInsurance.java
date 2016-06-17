package com.rabbitfinance.testscript;




import com.automation.framework.applib.FunctionsApplib;
import com.automation.framework.beans.TestWareBean;
import com.automation.framework.exception.BusinessException;
import com.automation.framework.util.ExcelUtil;
import com.automation.framework.util.GenericUtil;
import com.automation.framework.util.Test;
import com.rabbitfinance.excelcolumns.XL_CarInsurance;
import com.rabbitfinance.objectrepository.OR_CarInsurance;


public class CarInsurance extends FunctionsApplib {

	private ExcelUtil excelUtil;
	
	public CarInsurance(TestWareBean testWareBean, Test test) throws BusinessException {
		super(testWareBean, test);
		excelUtil = ExcelUtil.getInstance(testWareBean);
	}

	@Override
	protected String getSheetName() {
		return "CAR";
	}

	public void createLead() throws BusinessException, InterruptedException {
		
		createCarForm();
		
		createDiscounts();
		
		createOptions();
		
		leadPopup();
		
		resultsPage();
		
		checkoutLead();
	}
	
	public void validateCarInsurance() throws BusinessException, InterruptedException {
		String isDuplicateCarInsurance = test.getData(XL_CarInsurance.ISDUPLICATECARINSURANCE);
		if(isDuplicateCarInsurance.equals(XL_CarInsurance.YES)){
			test.script(CLICK_BUTTON, OR_CarInsurance.IMG_RABBIT_FINANCE, "");	
		}
		
		createCarForm();
		
		createDiscounts();
		
		createOptions();
		
		leadPopup();
		test.setSheetName(XL_CarInsurance.SHEET_RESULTS);
		String isChangeCar = test.getData(XL_CarInsurance.ISCHANGECAR);
		if(isChangeCar.equals(XL_CarInsurance.YES)){
			resultsPage();	
		}
		
	}
	
	private void createCarForm() throws BusinessException, InterruptedException{
		test.setSheetName(XL_CarInsurance.SHEET_CAR);
		test.script(CLICK_BUTTON, OR_CarInsurance.BTN_EN_LANGUAGE, "", false, 10);
		test.script(CLICK_BUTTON, OR_CarInsurance.WLS_SELECT_CAR, "", false, 10);
		test.script(SELECT_LIST, OR_CarInsurance.WLS_CAR_YEAR, XL_CarInsurance.YEAR);
		test.script(SELECT_LIST, OR_CarInsurance.WLS_CAR_BRAND, XL_CarInsurance.BRAND);
		test.script(SELECT_LIST, OR_CarInsurance.WLS_CAR_MODEL, XL_CarInsurance.MODEL);
		test.script(SELECT_LIST, OR_CarInsurance.WLS_SUB_MODEL, XL_CarInsurance.SUB_MODEL);
		String getModifiedDefaultValue = test.getAttributeValue(OR_CarInsurance.RDO_CAR_MODIFIED_NO);
		if(getModifiedDefaultValue.equals("0")){
			test.reportMessage("Default selection for Modified Car is NO", false);
		}		
		else if(test.getData(XL_CarInsurance.CAR_MODIFIED).equals(XL_CarInsurance.YES)){
			test.script(CLICK_BUTTON, OR_CarInsurance.RDO_CAR_MODIFIED_YES, "");
			String getExpectedModifiedValue = test.getData(XL_CarInsurance.MODIFIED_VALUE);
			int getNumber = Integer.parseInt(getExpectedModifiedValue.substring(0, getExpectedModifiedValue.length()-4));
			
			for(int increaseValue=1;increaseValue<=getNumber;increaseValue++){
				test.script(CLICK_BUTTON, OR_CarInsurance.BTN_MODIFIED_VALUE_ARROW_UP, "");
				String actaulModifiedValue = test.getTextFromTextBox(OR_CarInsurance.TXT_MODIFIED_VALUE);
				if((getExpectedModifiedValue + " THB").equals(actaulModifiedValue))
					test.reportMessage("Modified Car Value : "+actaulModifiedValue, false);
			}
		}	
		test.script(CLICK_BUTTON, OR_CarInsurance.BTN_NEXT_CAR_FORM, "");
	}
	
	private void createDiscounts()throws BusinessException, InterruptedException {
		test.setSheetName(XL_CarInsurance.SHEET_DISCOUNTS);
		
		String getGender = test.getData(XL_CarInsurance.GENDER);
		
		if(getGender.equals("Male")){
			test.script(CLICK_BUTTON, OR_CarInsurance.BTN_GENDER_MALE, "");	
		}else{
			test.script(CLICK_BUTTON, OR_CarInsurance.BTN_GENDER_FEMALE, "");
		}
		
		String getInsuranceClaim = test.getData(XL_CarInsurance.INSURANCE_CLAIM_LAST_YEAR);
		if(getInsuranceClaim.equals(XL_CarInsurance.YES)){
			test.script(CLICK_BUTTON, OR_CarInsurance.RDO_INSURANCE_CLAIM_YES, "");	
		}else{
			test.script(CLICK_BUTTON, OR_CarInsurance.RDO_INSURANCE_CLAIM_NO, "");
		}
			
		String getExpectedNoOfDrivers = test.getData(XL_CarInsurance.NO_OF_DRIVERS);	
		if(getExpectedNoOfDrivers.equals("Only 1 person")){
			test.script(CLICK_BUTTON, OR_CarInsurance.BTN_ONE_DRIVER, "");
			test.script(CLICK_BUTTON, OR_CarInsurance.TXT_YOUNGEST_DRIVER_AGE, "");
			test.datePicker();
		}else if(getExpectedNoOfDrivers.equals("Only 2 person")){
			test.script(CLICK_BUTTON, OR_CarInsurance.BTN_TWO_DRIVER, "");
			test.script(CLICK_BUTTON, OR_CarInsurance.TXT_YOUNGEST_DRIVER_AGE, "");
			test.datePicker();
		}else{
			test.script(CLICK_BUTTON, OR_CarInsurance.BTN_MANY_DRIVER, "");
		}
		test.script(SELECT_LIST, OR_CarInsurance.WLS_REGISTER_CAR_PLACE, XL_CarInsurance.CAR_REGISTER_PLACE);
		test.script(CLICK_BUTTON, OR_CarInsurance.BTN_NEXT_DISCOUNTS_FORM, "");		
	}
	
	private void createOptions() throws BusinessException, InterruptedException {
		test.setSheetName(XL_CarInsurance.SHEET_OPTIONS);
		String getCompulsaryInsurance = test.getData(XL_CarInsurance.COMPULSARY_INSURANCE);
		if(getCompulsaryInsurance.equals(XL_CarInsurance.YES)){
			test.script(CLICK_BUTTON, OR_CarInsurance.RDO_COMPULSARY_INSURANCE_YES, XL_CarInsurance.COMPULSARY_INSURANCE);
		}else{
			test.script(CLICK_BUTTON, OR_CarInsurance.RDO_COMPULSARY_INSURANCE_NO, XL_CarInsurance.COMPULSARY_INSURANCE);
		}
		test.script(CLICK_BUTTON, OR_CarInsurance.TXT_POLICY_START_COVERING, "");
		test.datePicker();
		test.script(CLICK_BUTTON, OR_CarInsurance.BTN_SEE_QUOTES, "");
		
	}
	
	private void leadPopup() throws BusinessException, InterruptedException {
		test.setSheetName(XL_CarInsurance.SHEET_LEAD_POPUP);
		
		String validateBackButton = test.getData(XL_CarInsurance.VALIDATELEADBACK);
		if(validateBackButton.equals(XL_CarInsurance.YES)){
			test.script(CLICK_BUTTON, OR_CarInsurance.BTN_BACK_LEAD_POPUP, "");
			staticCarDetails();
			staticDiscounts();
			staticOptions();
		}else{
			String isNewCustomer = test.getData(XL_CarInsurance.ISNEWCUSTOMER);
			if(isNewCustomer.equals(XL_CarInsurance.YES)){
				String generatePhoneNumber = "080"+ GenericUtil.getRandomNumber();		
				test.actionWriteData(generatePhoneNumber, XL_CarInsurance.PHONE_NUMBER, false);
				test.putData(XL_CarInsurance.PHONE_NUMBER, generatePhoneNumber);
				test.putData(XL_CarInsurance.PHONE_NUMBER+"_val", generatePhoneNumber);
				test.script(TYPE, OR_CarInsurance.TXT_PHONE_LEAD_POPUP, XL_CarInsurance.PHONE_NUMBER,true);			
			}else{
				test.script(TYPE, OR_CarInsurance.TXT_PHONE_LEAD_POPUP, XL_CarInsurance.PHONE_NUMBER);
			}
				test.script(CLICK_BUTTON, OR_CarInsurance.BTN_VIEW_YOUR_RESULTS, "");
				String isDuplicateCarInsurance = test.getData(XL_CarInsurance.ISDUPLICATECARINSURANCE);
				if(isDuplicateCarInsurance.equals(XL_CarInsurance.YES)){
					String expectedDuplicationMessage = test.getData(XL_CarInsurance.DUPLICATEMESSAGE);
					String actualDuplicateMessage = test.getTextFromElement(OR_CarInsurance.LBL_DUPLICATE_MESSAGE).trim();	
					test.comparisonResult(expectedDuplicationMessage, actualDuplicateMessage, "Insurance Alert Message");
				}
			}
	}
	
	private void resultsPage() throws BusinessException, InterruptedException {
		
		validationOfCarDetails();
		validationOfInsuranceOptions();
		test.setSheetName(XL_CarInsurance.SHEET_RESULTS);
		
		String isChangeCar = test.getData(XL_CarInsurance.ISCHANGECAR);
		if(isChangeCar.equals(XL_CarInsurance.YES)){
			test.script(CLICK_BUTTON, OR_CarInsurance.BTN_CHANGE_CAR, "");
			staticCarDetails();
			staticDiscounts();
			staticOptions();
		}else{
			String isCompare = test.getData(XL_CarInsurance.ISCOMPARE);
			if(isCompare.equals(XL_CarInsurance.YES)){
			
			}else{
				Thread.sleep(3000);
				test.script(CLICK_BUTTON, OR_CarInsurance.BTN_PROCEED_TO_LEAD, "");
			}
		}
	}
	
	private void validationOfCarDetails() throws BusinessException{
		test.setSheetName(XL_CarInsurance.SHEET_CAR);
		
		String expectedProductionyear = test.getData(XL_CarInsurance.YEAR);
		String expectedBrand = test.getData(XL_CarInsurance.BRAND);
		String expectedModel = test.getData(XL_CarInsurance.MODEL);
		
		String actualProductionYear = test.getTextFromElement(OR_CarInsurance.LBL_PRODUCTION_YEAR);
		String actualBrand = test.getTextFromElement(OR_CarInsurance.LBL_BRAND);
		String actualModel = test.getTextFromElement(OR_CarInsurance.LBL_MODEL);
		
		test.comparisonResult(expectedProductionyear, actualProductionYear, "Production Year");
		test.comparisonResult(expectedBrand, actualBrand, "Brand");
		test.comparisonResult(expectedModel, actualModel, "Model");
	}
	
	private void validationOfInsuranceOptions() throws BusinessException {
		String expectedLimitDriver = excelUtil.getValueByColumnName(XL_CarInsurance.NO_OF_DRIVERS, XL_CarInsurance.SHEET_DISCOUNTS);
		String expectedInsuranceMandatory = excelUtil.getValueByColumnName(XL_CarInsurance.COMPULSARY_INSURANCE, XL_CarInsurance.SHEET_OPTIONS);
		String expectedClaimedLastYear = excelUtil.getValueByColumnName(XL_CarInsurance.INSURANCE_CLAIM_LAST_YEAR, XL_CarInsurance.SHEET_DISCOUNTS);
		
		if(expectedLimitDriver.equals("Only 1 person") || expectedLimitDriver.equals("Only 2 person")){
			test.isExists(OR_CarInsurance.LBL_LIMIT_DRIVER_YES);
		}else{
			test.isExists(OR_CarInsurance.LBL_LIMIT_DRIVER_NO);
		}
		if(expectedInsuranceMandatory.equals(XL_CarInsurance.YES)){
			test.isExists(OR_CarInsurance.LBL_INCLUDES_MANDATORY_YES);
		}else{
			test.isExists(OR_CarInsurance.LBL_INCLUDES_MANDATORY_NO);
		}
		if(expectedClaimedLastYear.equals(XL_CarInsurance.YES)){
			test.isExists(OR_CarInsurance.LBL_CLAIMED_LAST_YEAR_YES);
		}else{
			test.isExists(OR_CarInsurance.LBL_CLAIMED_LAST_YEAR_NO);
		}
	}
	
	private void checkoutLead() throws BusinessException, InterruptedException {
		
		String isNewCustomer = excelUtil.getValueByColumnName(XL_CarInsurance.ISNEWCUSTOMER, XL_CarInsurance.SHEET_LEAD_POPUP);
		
		if(isNewCustomer.equals(XL_CarInsurance.YES)){
			checkoutPersonalDetails();
			checkoutAddress();
		}
		checkoutPayment();
	}

	private void checkoutPersonalDetails() throws BusinessException, InterruptedException {
		test.setSheetName(XL_CarInsurance.SHEET_PERSONAL_DETAILS);
		
		test.script(TYPE, OR_CarInsurance.TXT_EMAIL, XL_CarInsurance.EMAIL);

		String expectedPhoneNumber = excelUtil.getValueByColumnName(testWareBean.getExcelTestDataInResultPath(), XL_CarInsurance.SHEET_LEAD_POPUP, XL_CarInsurance.PHONE_NUMBER);
		String actualPhoneNumber = test.getTextFromTextBox(OR_CarInsurance.TXT_PHONE);
		
		test.comparisonResult(expectedPhoneNumber, actualPhoneNumber, "Phone Number on Checkout");
		// Will be removed once fix the issue (It should filled based on the questions section
		String gender = test.getData(XL_CarInsurance.GENDER_CHECKOUT);
		if(gender.equals("Male")){
			test.script(CLICK_BUTTON, OR_CarInsurance.RDO_GENDER_MALE_PERSONAL, "");
		}else{
			test.script(CLICK_BUTTON, OR_CarInsurance.RDO_GENDER_FEMALE_PERSONAL, "");
		}
		
		test.script(TYPE, OR_CarInsurance.TXT_FIRST_NAME, XL_CarInsurance.FIRST_NAME);
		test.script(TYPE, OR_CarInsurance.TXT_LAST_NAME, XL_CarInsurance.LAST_NAME);
		test.script(CLICK_BUTTON, OR_CarInsurance.TXT_DATEOFBIRTH, "");
		test.datePicker();
		test.script(CLICK_BUTTON, OR_CarInsurance.BTN_NEXT_PERSONAL_DETAILS, "");
	}
	
	private void checkoutAddress() throws BusinessException, InterruptedException {
		test.setSheetName(XL_CarInsurance.SHEET_ADDRESS);
		
		test.script(TYPE, OR_CarInsurance.TXT_ADDRESS_LINE, XL_CarInsurance.ADDRESS_LINE);
		test.script(SELECT_LIST, OR_CarInsurance.WLS_PROVINCE_CITY, XL_CarInsurance.PROVINCE);
		test.script(SELECT_LIST, OR_CarInsurance.WLS_DISTRICT, XL_CarInsurance.DISTRICT);
		test.script(SELECT_LIST, OR_CarInsurance.WLS_SUB_DISTRICT, XL_CarInsurance.SUB_DISTRICT);
		test.reportMessage("Zip Code found - "+test.getTextFromElement(OR_CarInsurance.TXT_ZIP_CODE),false);
		test.script(CLICK_BUTTON, OR_CarInsurance.BTN_NEXT_ADDRESS_FORM, "");
	}
	
	private void checkoutPayment() throws BusinessException, InterruptedException {
		test.setSheetName(XL_CarInsurance.SHEET_PAYMENT);
		
		test.script(CLICK_BUTTON, OR_CarInsurance.TXT_INSURANCE_COVERAGE_START, "");
		test.datePicker();
		
		String typeOfPayment = test.getData(XL_CarInsurance.PAYMENT_TYPE);
		String paymentMethod = test.getData(XL_CarInsurance.PAYMENT_METHOD);
		
		if(typeOfPayment.equals("Online Discount")){
			test.script(CLICK_BUTTON, OR_CarInsurance.BTN_5_PERCENT_DISCOUNT, "");
			if(paymentMethod.equals("EDC")){
				test.script(CLICK_BUTTON, OR_CarInsurance.RDO_EDC_PAYMENT, "");
				test.script(SELECT_LIST, OR_CarInsurance.WLS_SELECT_BANK, XL_CarInsurance.SELECT_BANK);
			}else{
				test.script(CLICK_BUTTON, OR_CarInsurance.RDO_BANK_TRANSFER_PAYMENT, "");
				test.script(SELECT_LIST, OR_CarInsurance.WLS_SELECT_BANK, XL_CarInsurance.SELECT_BANK);
			}
		}else{
			test.script(CLICK_BUTTON, OR_CarInsurance.BTN_0_PERCENT_DISCOUNT, "");
			test.script(SELECT_LIST, OR_CarInsurance.WLS_CREDIT_CARD, XL_CarInsurance.CREDIT_CARD);
			test.script(SELECT_LIST, OR_CarInsurance.WLS_INSTALLMENT_PERIOD, XL_CarInsurance.INSTALLMENT_PERIOD);
		}
		test.script(CLICK_BUTTON, OR_CarInsurance.BTN_PROCEED_TO_CONFIRMATION, "");
		Thread.sleep(4000);
	}
	
	private void staticCarDetails() throws BusinessException, InterruptedException {
		test.setSheetName(XL_CarInsurance.SHEET_CAR);
		
		String expectedCarYear = test.getData(XL_CarInsurance.YEAR);
		String actualCarYear = test.getTextFromSelected(OR_CarInsurance.WLS_CAR_YEAR);
		
		String expectedCarBrand = test.getData(XL_CarInsurance.BRAND);
		String actualCarBrand = test.getTextFromSelected(OR_CarInsurance.WLS_CAR_BRAND);
		
		String expectedCarModel = test.getData(XL_CarInsurance.MODEL);
		String actualCarModel = test.getTextFromSelected(OR_CarInsurance.WLS_CAR_MODEL);
		
		String expectedSubModel = test.getData(XL_CarInsurance.SUB_MODEL);
		String actualSubModel = test.getTextFromSelected(OR_CarInsurance.WLS_SUB_MODEL);
		
		test.comparisonResult(expectedCarYear, actualCarYear, "Car Year");
		test.comparisonResult(expectedCarBrand, actualCarBrand, "Car Brand");
		test.comparisonResult(expectedCarModel, actualCarModel, "Car Model");
		test.comparisonResult(expectedSubModel, actualSubModel, "Sub Model");

		String expectedCarModified = test.getData(XL_CarInsurance.CAR_MODIFIED);
		if(expectedCarModified.equals(XL_CarInsurance.NO)){
			String getModifiedDefaultValue = test.getAttributeValue(OR_CarInsurance.RDO_CAR_MODIFIED_NO);
			if(getModifiedDefaultValue.equals("0")){
				test.reportMessage("Default selection for Modified Car is NO",false);
			}else{
				test.reportMessage("Default selection for Modified Car is YES",true);
			}
		}else{
			String expectedModifiedValue = test.getData(XL_CarInsurance.MODIFIED_VALUE);
			String actaulModifiedValue = test.getTextFromTextBox(OR_CarInsurance.TXT_MODIFIED_VALUE);
			test.comparisonResult(expectedModifiedValue, actaulModifiedValue, "Modified Value");
		}
		
		test.script(CLICK_BUTTON, OR_CarInsurance.BTN_NEXT_CAR_FORM, "");
	}
	
	private void staticDiscounts() throws BusinessException, InterruptedException {
		test.setSheetName(XL_CarInsurance.SHEET_DISCOUNTS);
		
		String expectedGender = test.getData(XL_CarInsurance.GENDER);
		String actualGender = "";
		if(expectedGender.equals("Female")){
			actualGender = test.getTextFromElement(OR_CarInsurance.BTN_GENDER_FEMALE);	
		}else{
			actualGender = test.getTextFromElement(OR_CarInsurance.BTN_GENDER_MALE);
		}
		test.comparisonResult(expectedGender, actualGender, "Gender");
		
		String expectedInsuranceClaim = test.getData(XL_CarInsurance.INSURANCE_CLAIM_LAST_YEAR);
		if(expectedInsuranceClaim.equals(XL_CarInsurance.YES)){
			String actualClaim = test.getAttributeValue(OR_CarInsurance.RDO_INSURANCE_CLAIM_YES); 
			if(actualClaim.equals("1")){
				test.reportMessage("Insurance Claim Last Year - YES match with expected value",false);
			}else{
				test.reportMessage("Insurance Claim Last Year - YES didn't match with expected value",true);
			}
		}else{
			String actualClaim = test.getAttributeValue(OR_CarInsurance.RDO_INSURANCE_CLAIM_NO);
			if(actualClaim.equals("0")){
				test.reportMessage("Insurance Claim Last Year - NO match with expected value",false);
			}else{
				test.reportMessage("Insurance Claim Last Year - NO didn't match with expected value",true);
			}
		}
		String expectedNoOfDrivers = test.getData(XL_CarInsurance.NO_OF_DRIVERS);	
		if(expectedNoOfDrivers.equals("Only 1 person") || expectedNoOfDrivers.equals("Only 2 person")){
			String actualDriverAge = test.getTextFromTextBox(OR_CarInsurance.TXT_YOUNGEST_DRIVER_AGE);
			test.reportMessage("Driver's Age of "+expectedNoOfDrivers+" - "+actualDriverAge,false);
		}else{
			String actualPersons = test.getTextFromElement(OR_CarInsurance.BTN_MANY_DRIVER);
			test.reportMessage(actualPersons+" has been selected as expected.",true);
		}
		
		String expectedRegisterCar = test.getData(XL_CarInsurance.CAR_REGISTER_PLACE);
		String actualRegisterCar = test.getTextFromSelected(OR_CarInsurance.WLS_REGISTER_CAR_PLACE);
		test.comparisonResult(expectedRegisterCar, actualRegisterCar, "Car Register Place");
		
		test.script(CLICK_BUTTON, OR_CarInsurance.BTN_NEXT_DISCOUNTS_FORM, "");
	}
	
	private void staticOptions() throws BusinessException {
		test.setSheetName(XL_CarInsurance.SHEET_OPTIONS);
		
		String expectedCompulsaryInsurance = test.getData(XL_CarInsurance.COMPULSARY_INSURANCE);
		if(expectedCompulsaryInsurance.equals(XL_CarInsurance.YES)){
			String actualCompulsaryInsurance = test.getAttributeValue(OR_CarInsurance.RDO_COMPULSARY_INSURANCE_YES);
			if(actualCompulsaryInsurance.equals("1")){
				test.reportMessage("Compulsary Insurance - YES match with expected value",false);
			}else{
				test.reportMessage("Compulsary Insurance - YES didn't match with expected value",true);
			}
		}else{
			String actualCompulsaryInsurance = test.getAttributeValue(OR_CarInsurance.RDO_COMPULSARY_INSURANCE_NO);
			if(actualCompulsaryInsurance.equals("0")){
				test.reportMessage("Compulsary Insurance - NO match with expected value",false);
			}else{
				test.reportMessage("Compulsary Insurance - NO didn't match with expected value",true);
			}
		}
		
		String actualPolicyStartDate = test.getTextFromElement(OR_CarInsurance.TXT_POLICY_START_COVERING);
		test.reportMessage("Policy Start Date "+actualPolicyStartDate,false);
	}
	
}

package com.rabbitrewards.testscript;

import com.automation.framework.applib.FunctionsApplib;
import com.automation.framework.beans.TestWareBean;
import com.automation.framework.exception.BusinessException;
import com.automation.framework.util.ExcelUtil;
import com.automation.framework.util.Test;
import com.rabbitbase.constants.Project_Constants;
import com.rabbitbase.excelcolumns.XL_GenericRewards;
import com.rabbitbase.objectrepository.OR_GenericRewards;
import com.rabbitrewards.excelcolumns.XL_MyDetail;
import com.rabbitrewards.objectrepository.OR_MyDetail;


public class MyDetail extends FunctionsApplib {

	public MyDetail(TestWareBean testWareBean, Test test) throws BusinessException {
		super(testWareBean, test);
		excelUtil = ExcelUtil.getInstance(testWareBean);
	}

	@Override
	protected String getSheetName() {
		return XL_GenericRewards.SHEET_MY_DETAIL;
	}	
	
	public void updateDetailsForNewCustomer() throws BusinessException, InterruptedException {

		test.script(CLICK_BUTTON, OR_GenericRewards.LBL_WELCOME_NAME, "");
		test.script(CLICK_BUTTON, OR_MyDetail.LNK_USER_MY_DETAIL, "");
		
		language();
		
		personalInformation();
		
		otherInformation();
		
		homeAddress();
		
		String isShippingSameAsHomeAddress = test.getData(XL_MyDetail.IS_SHIPPING_SAME_AS_HOME_ADDRESS);
		if(isShippingSameAsHomeAddress.equals(Project_Constants.YES)){		
			test.script(CLICK_BUTTON, OR_MyDetail.CHK_SHIPPING_SAME_HOME_ADDRESS, "");
			shippingSameAsHomeAddress();
		}else{
			shippingAddress();
		}
		saveUpdateDetails();
		
	}
	
	public void updateDetailsForExistingCustomer() throws BusinessException, InterruptedException {
		test.setSheetName(XL_GenericRewards.SHEET_UPDATE_MY_DETAIL);
		test.script(CLICK_BUTTON, OR_GenericRewards.LBL_WELCOME_NAME, "");
		test.script(CLICK_BUTTON, OR_MyDetail.LNK_USER_MY_DETAIL, "");
		
		String isUpdateLanguageRequired = test.getData(XL_MyDetail.IS_UPDATE_LANGUAGE);
		if(isUpdateLanguageRequired.equals(Project_Constants.YES)){
			language();
		}
		String isUpdatePersonalInfoRequired = test.getData(XL_MyDetail.IS_UPDATE_PERSONAL_INFO);
		if(isUpdatePersonalInfoRequired.equals(Project_Constants.YES)){
			updatePersonalInformation();
		}
		String isUpdateOtherInfoRequired = test.getData(XL_MyDetail.IS_UPDATE_OTHER_INFO);
		if(isUpdateOtherInfoRequired.equals(Project_Constants.YES)){
			updateOtherInformation();
		}
		String isUpdateHomeAddRequired = test.getData(XL_MyDetail.IS_UPDATE_HOME_ADDRESS);
		if(isUpdateHomeAddRequired.equals(Project_Constants.YES)){
			updateHomeAddress();
		}		
		String isUpdateShippingAddRequired  = test.getData(XL_MyDetail.IS_UPDATE_SHIPPING_ADDRESS);
		String isShippingSameAsHomeAddress = test.getData(XL_MyDetail.IS_SHIPPING_SAME_AS_HOME_ADDRESS);
		if(isUpdateShippingAddRequired.equals(Project_Constants.YES)){
			if(isShippingSameAsHomeAddress.equals(Project_Constants.YES)){
				shippingSameAsHomeAddress();
			}else{
				updateShippingAddress();
			}
		}
		saveUpdateDetails();
		test.scrollToElement(OR_GenericRewards.WLS_PREFERRED_LANGUAGE[0]);
	}
	
	private void rollBackCustomerDetails() throws BusinessException, InterruptedException {
		test.setSheetName(XL_GenericRewards.SHEET_MY_DETAIL);
		
		String isUpdateLanguageRequired = test.getData(XL_MyDetail.IS_UPDATE_LANGUAGE);
		if(isUpdateLanguageRequired.equals(Project_Constants.YES)){
			language();
		}
		String isUpdatePersonalInfoRequired = test.getData(XL_MyDetail.IS_UPDATE_PERSONAL_INFO);
		if(isUpdatePersonalInfoRequired.equals(Project_Constants.YES)){
			updatePersonalInformation();
		}
		String isUpdateOtherInfoRequired = test.getData(XL_MyDetail.IS_UPDATE_OTHER_INFO);
		if(isUpdateOtherInfoRequired.equals(Project_Constants.YES)){
			updateOtherInformation();
		}
		String isUpdateHomeAddRequired = test.getData(XL_MyDetail.IS_UPDATE_HOME_ADDRESS);
		if(isUpdateHomeAddRequired.equals(Project_Constants.YES)){
			updateHomeAddress();
		}		
		String isUpdateShippingAddRequired  = test.getData(XL_MyDetail.IS_UPDATE_SHIPPING_ADDRESS);
		if(isUpdateShippingAddRequired.equals(Project_Constants.YES)){
			updateShippingAddress();
		}
		saveUpdateDetails();
		test.scrollToElement(OR_GenericRewards.WLS_PREFERRED_LANGUAGE[0]);
	}
	
	public void staticValidationUpdateDetails() throws BusinessException, InterruptedException {
		test.setSheetName(XL_GenericRewards.SHEET_UPDATE_MY_DETAIL);
		test.script(CLICK_BUTTON, OR_GenericRewards.LBL_WELCOME_NAME, "");
		test.script(CLICK_BUTTON, OR_MyDetail.LNK_USER_MY_DETAIL, "");
		Thread.sleep(3000);
		
		String isUpdateLanguageRequired = test.getData(XL_MyDetail.IS_UPDATE_LANGUAGE);
		if(isUpdateLanguageRequired.equals(Project_Constants.YES)){
			staticValidateLanguage();
		}
		String isUpdatePersonalInfoRequired = test.getData(XL_MyDetail.IS_UPDATE_PERSONAL_INFO);
		if(isUpdatePersonalInfoRequired.equals(Project_Constants.YES)){
			staticValidationPersonalInformation();
		}
		String isUpdateOtherInfoRequired = test.getData(XL_MyDetail.IS_UPDATE_OTHER_INFO);
		if(isUpdateOtherInfoRequired.equals(Project_Constants.YES)){
			staticValidationOtherInformation();
		}
		String isUpdateHomeAddRequired = test.getData(XL_MyDetail.IS_UPDATE_HOME_ADDRESS);
		if(isUpdateHomeAddRequired.equals(Project_Constants.YES)){
			staticValidationHomeAddress();
		}		
		String isUpdateShippingAddRequired  = test.getData(XL_MyDetail.IS_UPDATE_SHIPPING_ADDRESS);
		if(isUpdateShippingAddRequired.equals(Project_Constants.YES)){
			staticValidationShippingAddress();
		}
		
		rollBackCustomerDetails();
	}
	
	private void language() throws BusinessException, InterruptedException {
		test.script(SELECT_LIST, OR_MyDetail.WLS_PREFERRED_LANGUAGE, XL_MyDetail.PREFERRED_LANGUAGE);
	}
	
	private void personalInformation() throws BusinessException, InterruptedException {
		test.script(PRESENT, OR_MyDetail.WLS_TITLE, XL_MyDetail.TITLE);
		test.script(PRESENT, OR_MyDetail.TXT_FIRST_NAME, XL_MyDetail.FIRST_NAME);
		test.script(PRESENT, OR_MyDetail.TXT_LAST_NAME, XL_MyDetail.LAST_NAME);
		test.script(PRESENT, OR_MyDetail.TXT_DATE_OF_BIRTH, XL_MyDetail.DATE_OF_BIRTH);
	}
	
	private void updatePersonalInformation() throws BusinessException, InterruptedException {
		test.script(SELECT_LIST, OR_MyDetail.WLS_TITLE, XL_MyDetail.TITLE);
		test.script(CLEAR_TYPE, OR_MyDetail.TXT_FIRST_NAME, XL_MyDetail.FIRST_NAME);
		test.script(CLEAR_TYPE, OR_MyDetail.TXT_LAST_NAME, XL_MyDetail.LAST_NAME);
		/*test.script(CLEAR_TYPE, OR_RabbitRewards.TXT_DATE_OF_BIRTH, XL_RabbitRewards.DATE_OF_BIRTH);*/
	}
	
	private void otherInformation() throws BusinessException, InterruptedException {

			test.script(PRESENT, OR_MyDetail.WLS_GENDER, XL_MyDetail.GENDER);
			test.script(SELECT_LIST, OR_MyDetail.WLS_MARITAL_STATUS, XL_MyDetail.MARITAL_STATUS, true);
			test.script(SELECT_LIST, OR_MyDetail.WLS_NATIONALITY, XL_MyDetail.NATIONALITY, true);
			test.script(TYPE, OR_MyDetail.TXT_ID_NUMBER, XL_MyDetail.ID_NUMBER, true);
			test.script(TYPE, OR_MyDetail.TXT_PASSPORT_NUMBER, XL_MyDetail.PASSPORT_NO, true);
			test.script(TYPE, OR_MyDetail.TXT_HOME_TEL, XL_MyDetail.HOME_TEL, true);
			test.script(TYPE, OR_MyDetail.TXT_EXTENSION, XL_MyDetail.EXTENSION, true);
			test.script(PRESENT, OR_MyDetail.TXT_MOBILE, XL_MyDetail.MOBILE);
			test.script(PRESENT, OR_MyDetail.TXT_EMAIL, XL_MyDetail.EMAIL);
			test.script(PRESENT, OR_MyDetail.TXT_RE_ENTER_EMAIL, XL_MyDetail.RE_ENTER_EMAIL);
	}
	
	private void updateOtherInformation() throws BusinessException, InterruptedException {
		
		String updateOnlyEmail = test.getData(XL_MyDetail.UPDATE_ONLY_EMAIL);
		if(updateOnlyEmail.equals(Project_Constants.YES)){
			test.script(CLEAR_TYPE, OR_MyDetail.TXT_EMAIL, XL_MyDetail.EMAIL);
			test.script(CLEAR_TYPE, OR_MyDetail.TXT_RE_ENTER_EMAIL, XL_MyDetail.RE_ENTER_EMAIL);
		}else{
			test.script(SELECT_LIST, OR_MyDetail.WLS_GENDER, XL_MyDetail.GENDER);
			test.script(SELECT_LIST, OR_MyDetail.WLS_MARITAL_STATUS, XL_MyDetail.MARITAL_STATUS, true);
			test.script(SELECT_LIST, OR_MyDetail.WLS_NATIONALITY, XL_MyDetail.NATIONALITY, true);
			test.script(CLEAR_TYPE, OR_MyDetail.TXT_ID_NUMBER, XL_MyDetail.ID_NUMBER, true);
			test.script(CLEAR_TYPE, OR_MyDetail.TXT_PASSPORT_NUMBER, XL_MyDetail.PASSPORT_NO, true);
			test.script(CLEAR_TYPE, OR_MyDetail.TXT_HOME_TEL, XL_MyDetail.HOME_TEL, true);
			test.script(CLEAR_TYPE, OR_MyDetail.TXT_EXTENSION, XL_MyDetail.EXTENSION, true);
			test.script(CLEAR_TYPE, OR_MyDetail.TXT_MOBILE, XL_MyDetail.MOBILE);
			test.script(CLEAR_TYPE, OR_MyDetail.TXT_EMAIL, XL_MyDetail.EMAIL);
			test.script(CLEAR_TYPE, OR_MyDetail.TXT_RE_ENTER_EMAIL, XL_MyDetail.RE_ENTER_EMAIL);
		}
	}
	
	private void homeAddress() throws BusinessException, InterruptedException {
		test.script(TYPE, OR_MyDetail.TXT_HOME_ADDRESS_NO, XL_MyDetail.HOME_ADDRESS_NO, true);
		test.script(TYPE, OR_MyDetail.TXT_HOME_VILLAGE_OR_BUILDING, XL_MyDetail.HOME_VILLAGE_OR_BUILDING, true);
		test.script(TYPE, OR_MyDetail.TXT_HOME_SOI, XL_MyDetail.HOME_SOI, true);
		test.script(TYPE, OR_MyDetail.TXT_HOME_STREET, XL_MyDetail.HOME_STREET, true);
		test.script(TYPE, OR_MyDetail.TXT_HOME_SUB_DISTRICT, XL_MyDetail.HOME_SUB_DISTRICT, true);
		test.script(TYPE, OR_MyDetail.TXT_HOME_DISTRICT, XL_MyDetail.HOME_DISTRICT, true);
		test.script(SELECT_LIST, OR_MyDetail.WLS_HOME_PROVINCE, XL_MyDetail.HOME_PROVINCE, true);
		test.script(TYPE, OR_MyDetail.TXT_HOME_POSTCODE, XL_MyDetail.HOME_POSTCODE, true);
	}
	
	private void updateHomeAddress() throws BusinessException, InterruptedException {
		test.script(CLEAR_TYPE, OR_MyDetail.TXT_HOME_ADDRESS_NO, XL_MyDetail.HOME_ADDRESS_NO, true);
		test.script(CLEAR_TYPE, OR_MyDetail.TXT_HOME_VILLAGE_OR_BUILDING, XL_MyDetail.HOME_VILLAGE_OR_BUILDING, true);
		test.script(CLEAR_TYPE, OR_MyDetail.TXT_HOME_SOI, XL_MyDetail.HOME_SOI, true);
		test.script(CLEAR_TYPE, OR_MyDetail.TXT_HOME_STREET, XL_MyDetail.HOME_STREET, true);
		test.script(CLEAR_TYPE, OR_MyDetail.TXT_HOME_SUB_DISTRICT, XL_MyDetail.HOME_SUB_DISTRICT, true);
		test.script(CLEAR_TYPE, OR_MyDetail.TXT_HOME_DISTRICT, XL_MyDetail.HOME_DISTRICT, true);
		test.script(SELECT_LIST, OR_MyDetail.WLS_HOME_PROVINCE, XL_MyDetail.HOME_PROVINCE, true);
		test.script(CLEAR_TYPE, OR_MyDetail.TXT_HOME_POSTCODE, XL_MyDetail.HOME_POSTCODE, true);
	}
	
	private void shippingAddress() throws BusinessException, InterruptedException {
		test.script(TYPE, OR_MyDetail.TXT_SHIPPING_ADDRESS_NO, XL_MyDetail.SHIPPING_ADDRESS_NO, true);
		test.script(TYPE, OR_MyDetail.TXT_SHIPPING_VILLAGE_OR_BUILDING, XL_MyDetail.SHIPPING_VILLAGE_OR_BUILDING, true);
		test.script(TYPE, OR_MyDetail.TXT_SHIPPING_SOI, XL_MyDetail.SHIPPING_SOI, true);
		test.script(TYPE, OR_MyDetail.TXT_SHIPPING_STREET, XL_MyDetail.SHIPPING_STREET, true);
		test.script(TYPE, OR_MyDetail.TXT_SHIPPING_SUB_DISTRICT, XL_MyDetail.SHIPPING_SUB_DISTRICT, true);
		test.script(TYPE, OR_MyDetail.TXT_SHIPPING_DISTRICT, XL_MyDetail.SHIPPING_DISTRICT, true);
		test.script(SELECT_LIST, OR_MyDetail.WLS_SHIPPING_PROVINCE, XL_MyDetail.SHIPPING_PROVINCE, true);
		test.script(TYPE, OR_MyDetail.TXT_SHIPPING_POSTCODE, XL_MyDetail.SHIPPING_POSTCODE, true);
	}
	
	private void updateShippingAddress() throws BusinessException, InterruptedException {
		test.script(CLEAR_TYPE, OR_MyDetail.TXT_SHIPPING_ADDRESS_NO, XL_MyDetail.SHIPPING_ADDRESS_NO, true);
		test.script(CLEAR_TYPE, OR_MyDetail.TXT_SHIPPING_VILLAGE_OR_BUILDING, XL_MyDetail.SHIPPING_VILLAGE_OR_BUILDING, true);
		test.script(CLEAR_TYPE, OR_MyDetail.TXT_SHIPPING_SOI, XL_MyDetail.SHIPPING_SOI, true);
		test.script(CLEAR_TYPE, OR_MyDetail.TXT_SHIPPING_STREET, XL_MyDetail.SHIPPING_STREET, true);
		test.script(CLEAR_TYPE, OR_MyDetail.TXT_SHIPPING_SUB_DISTRICT, XL_MyDetail.SHIPPING_SUB_DISTRICT, true);
		test.script(CLEAR_TYPE, OR_MyDetail.TXT_SHIPPING_DISTRICT, XL_MyDetail.SHIPPING_DISTRICT, true);
		test.script(SELECT_LIST, OR_MyDetail.WLS_SHIPPING_PROVINCE, XL_MyDetail.SHIPPING_PROVINCE, true);
		test.script(CLEAR_TYPE, OR_MyDetail.TXT_SHIPPING_POSTCODE, XL_MyDetail.SHIPPING_POSTCODE, true);
	}
	
	private void shippingSameAsHomeAddress() throws BusinessException, InterruptedException {
		test.script(CLICK_BUTTON, OR_MyDetail.CHK_SHIPPING_SAME_HOME_ADDRESS, "");
		test.script(PRESENT, OR_MyDetail.TXT_SHIPPING_ADDRESS_NO, XL_MyDetail.SHIPPING_ADDRESS_NO, true);
		test.script(PRESENT, OR_MyDetail.TXT_SHIPPING_VILLAGE_OR_BUILDING, XL_MyDetail.SHIPPING_VILLAGE_OR_BUILDING, true);
		test.script(PRESENT, OR_MyDetail.TXT_SHIPPING_SOI, XL_MyDetail.SHIPPING_SOI, true);
		test.script(PRESENT, OR_MyDetail.TXT_SHIPPING_STREET, XL_MyDetail.SHIPPING_STREET, true);
		test.script(PRESENT, OR_MyDetail.TXT_SHIPPING_SUB_DISTRICT, XL_MyDetail.SHIPPING_SUB_DISTRICT, true);
		test.script(PRESENT, OR_MyDetail.TXT_SHIPPING_DISTRICT, XL_MyDetail.SHIPPING_DISTRICT, true);
		test.script(PRESENT, OR_MyDetail.WLS_SHIPPING_PROVINCE, XL_MyDetail.SHIPPING_PROVINCE, true);
		test.script(PRESENT, OR_MyDetail.TXT_SHIPPING_POSTCODE, XL_MyDetail.SHIPPING_POSTCODE, true);
	}
	
	private void saveUpdateDetails() throws BusinessException, InterruptedException {
		test.script(CLICK_BUTTON, OR_MyDetail.BTN_SAVE_AND_CONTINUE, "");
		boolean saveSuccess = test.isExists(OR_MyDetail.BTN_SAVE_AND_CONTINUE_SUCCESS);
		if(saveSuccess){
			test.reportMessage("Rewards Update Details successfully saved!", false);
		}else{
			test.reportMessage("Rewards Update Details failed to save", true);
		}
	}
	
	private void staticValidateLanguage() throws BusinessException {
		test.staticValidateSelectList(XL_MyDetail.PREFERRED_LANGUAGE, OR_MyDetail.WLS_PREFERRED_LANGUAGE);
	}
	
	private void staticValidationPersonalInformation() throws BusinessException {
		test.staticValidateSelectList(XL_MyDetail.TITLE, OR_MyDetail.WLS_TITLE);
		test.staticValidateTextBox(XL_MyDetail.FIRST_NAME, OR_MyDetail.TXT_FIRST_NAME);
		test.staticValidateTextBox(XL_MyDetail.LAST_NAME, OR_MyDetail.TXT_LAST_NAME);
	}
	
	private void staticValidationOtherInformation() throws BusinessException {
		
		String updateOnlyEmail = test.getData(XL_MyDetail.UPDATE_ONLY_EMAIL);
		if(updateOnlyEmail.equals(Project_Constants.YES)){
			test.staticValidateTextBox(XL_MyDetail.EMAIL, OR_MyDetail.TXT_EMAIL);
			test.staticValidateTextBox(XL_MyDetail.RE_ENTER_EMAIL, OR_MyDetail.TXT_RE_ENTER_EMAIL);	
		}else{
			test.staticValidateSelectList(XL_MyDetail.GENDER, OR_MyDetail.WLS_GENDER);
			test.staticValidateSelectList(XL_MyDetail.MARITAL_STATUS, OR_MyDetail.WLS_MARITAL_STATUS);
			test.staticValidateSelectList(XL_MyDetail.NATIONALITY, OR_MyDetail.WLS_NATIONALITY);
			test.staticValidateTextBox(XL_MyDetail.ID_NUMBER, OR_MyDetail.TXT_ID_NUMBER);
			test.staticValidateTextBox(XL_MyDetail.PASSPORT_NO, OR_MyDetail.TXT_PASSPORT_NUMBER);
			test.staticValidateTextBox(XL_MyDetail.HOME_TEL, OR_MyDetail.TXT_HOME_TEL);
			test.staticValidateTextBox(XL_MyDetail.EXTENSION, OR_MyDetail.TXT_EXTENSION);
			test.staticValidateTextBox(XL_MyDetail.MOBILE, OR_MyDetail.TXT_MOBILE);
			test.staticValidateTextBox(XL_MyDetail.EMAIL, OR_MyDetail.TXT_EMAIL);
			test.staticValidateTextBox(XL_MyDetail.RE_ENTER_EMAIL, OR_MyDetail.TXT_RE_ENTER_EMAIL);
		}
	}
	
	private void staticValidationHomeAddress() throws BusinessException {
		test.staticValidateTextBox(XL_MyDetail.HOME_ADDRESS_NO, OR_MyDetail.TXT_HOME_ADDRESS_NO);
		test.staticValidateTextBox(XL_MyDetail.HOME_VILLAGE_OR_BUILDING, OR_MyDetail.TXT_HOME_VILLAGE_OR_BUILDING);
		test.staticValidateTextBox(XL_MyDetail.HOME_SOI, OR_MyDetail.TXT_HOME_SOI);
		test.staticValidateTextBox(XL_MyDetail.HOME_STREET, OR_MyDetail.TXT_HOME_STREET);
		test.staticValidateTextBox(XL_MyDetail.HOME_SUB_DISTRICT, OR_MyDetail.TXT_HOME_SUB_DISTRICT);
		test.staticValidateTextBox(XL_MyDetail.HOME_DISTRICT, OR_MyDetail.TXT_HOME_DISTRICT);
		test.staticValidateSelectList(XL_MyDetail.HOME_PROVINCE, OR_MyDetail.WLS_HOME_PROVINCE);
		test.staticValidateTextBox(XL_MyDetail.HOME_POSTCODE, OR_MyDetail.TXT_HOME_POSTCODE);
	}
	
	private void staticValidationShippingAddress() throws BusinessException {
		test.staticValidateTextBox(XL_MyDetail.SHIPPING_ADDRESS_NO, OR_MyDetail.TXT_SHIPPING_ADDRESS_NO);
		test.staticValidateTextBox(XL_MyDetail.SHIPPING_VILLAGE_OR_BUILDING, OR_MyDetail.TXT_SHIPPING_VILLAGE_OR_BUILDING);
		test.staticValidateTextBox(XL_MyDetail.SHIPPING_SOI, OR_MyDetail.TXT_SHIPPING_SOI);
		test.staticValidateTextBox(XL_MyDetail.SHIPPING_STREET, OR_MyDetail.TXT_SHIPPING_STREET);
		test.staticValidateTextBox(XL_MyDetail.SHIPPING_SUB_DISTRICT, OR_MyDetail.TXT_SHIPPING_SUB_DISTRICT);
		test.staticValidateTextBox(XL_MyDetail.SHIPPING_DISTRICT, OR_MyDetail.TXT_SHIPPING_DISTRICT);
		test.staticValidateSelectList(XL_MyDetail.SHIPPING_PROVINCE, OR_MyDetail.WLS_SHIPPING_PROVINCE);
		test.staticValidateTextBox(XL_MyDetail.SHIPPING_POSTCODE, OR_MyDetail.TXT_SHIPPING_POSTCODE);
	}
}

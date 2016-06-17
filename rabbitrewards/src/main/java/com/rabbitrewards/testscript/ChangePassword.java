package com.rabbitrewards.testscript;

import com.automation.framework.applib.FunctionsApplib;
import com.automation.framework.beans.TestWareBean;
import com.automation.framework.exception.BusinessException;
import com.automation.framework.util.Test;
import com.rabbitbase.excelcolumns.XL_GenericRewards;
import com.rabbitbase.objectrepository.OR_GenericRewards;
import com.rabbitrewards.excelcolumns.XL_ChangePassword;
import com.rabbitrewards.objectrepository.OR_ChangePassword;


public class ChangePassword extends FunctionsApplib {

	public ChangePassword(TestWareBean testWareBean, Test test) throws BusinessException {
		super(testWareBean, test);
	}

	@Override
	protected String getSheetName() {
		return XL_GenericRewards.SHEET_CHANGE_PASSWORD;
	}

	public void changePassword() throws BusinessException, InterruptedException {
		
		loginRewards();
		doChangePassword();
		
	}
	
	
	private void loginRewards() throws BusinessException, InterruptedException {
		
		Thread.sleep(3000);
		if(!test.isPresent(OR_GenericRewards.LNK_EN_LANGUAGE_ACTIVE)){
			test.script(CLICK_BUTTON, OR_GenericRewards.LNK_EN_LANGUAGE, "");
		}
		test.script(CLICK_BUTTON, OR_GenericRewards.BTN_LOGIN_MAIN_PAGE, "");
		Thread.sleep(3000);
		test.script(TYPE, OR_GenericRewards.TXT_USERNAME_RABBIT_NO, XL_ChangePassword.USER_NAME);
		test.script(TYPE, OR_GenericRewards.TXT_PASSWORD, XL_ChangePassword.CURRENT_PASSWORD);
		test.script(CLICK_BUTTON, OR_GenericRewards.BTN_LOGIN_ON_POPUP, "");
		test.script(WAIT_FOR_VISIBLE, OR_GenericRewards.LBL_WELCOME_NAME,"", false, 20);
		String expectedWelcomeMessage = test.getData(XL_ChangePassword.FIRST_NAME).toUpperCase();
		String actualWelcomeMessage = test.getTextFromElement(OR_GenericRewards.LBL_WELCOME_NAME);
		test.comparisonResult(expectedWelcomeMessage, actualWelcomeMessage, "Welcome Message");	
		
		
	}
	
	private void doChangePassword() throws BusinessException, InterruptedException {
		
		test.script(CLICK_BUTTON, OR_GenericRewards.LBL_WELCOME_NAME, "");
		test.script(CLICK_BUTTON, OR_ChangePassword.LNK_CHANGE_PASSWORD, "");
		Thread.sleep(3000);
		test.script(TYPE, OR_ChangePassword.TXT_OLD_PASSWORD, XL_ChangePassword.CURRENT_PASSWORD);
		test.script(TYPE, OR_ChangePassword.TXT_NEW_PASSWORD, XL_ChangePassword.NEW_PASSWORD);
		test.script(TYPE, OR_ChangePassword.TXT_CONFIRM_PASSWORD, XL_ChangePassword.CONFIRM_PASSWORD);
		test.script(CLICK_BUTTON, OR_ChangePassword.BTN_SUBMIT, "");
		
		if(test.isExists(OR_ChangePassword.LBL_SUCCESS)){
			test.reportMessage("Password Changed Successfully", false);
		}else{
			test.reportMessage("Password Change is failed", true);
		}
	}

}

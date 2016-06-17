package com.rabbitbase.generic;

import com.automation.framework.applib.FunctionsApplib;
import com.automation.framework.beans.TestWareBean;
import com.automation.framework.exception.BusinessException;
import com.automation.framework.util.Test;
import com.rabbitbase.constants.Project_Constants;
import com.rabbitbase.excelcolumns.XL_GenericRewards;
import com.rabbitbase.objectrepository.OR_GenericRewards;



public class Generic_Rewards extends FunctionsApplib {

	private static Generic_Rewards instance;
	
	public Generic_Rewards(TestWareBean testWareBean, Test test) throws BusinessException {
		super(testWareBean, test);
	}

	public static Generic_Rewards getInstance(TestWareBean testWareBean, Test test) throws BusinessException{
		return instance == null ? new Generic_Rewards(testWareBean, test) : instance;
	}
	
	@Override
	protected String getSheetName() {
		return null;
	}
	
	public void rewardsLogin() throws BusinessException, InterruptedException {
		Thread.sleep(3000);
		if(!test.isPresent(OR_GenericRewards.LNK_EN_LANGUAGE_ACTIVE)){
			test.script(CLICK_BUTTON, OR_GenericRewards.LNK_EN_LANGUAGE, "");
		}
		test.setSheetName(XL_GenericRewards.SHEET_LOGIN);
		String isFacebookLogin = test.getData(XL_GenericRewards.ISFACEBOOKLOGIN);
		
		if(isFacebookLogin.equals(Project_Constants.YES)){
			facebookLogin();
		}else{
			rewardsMainLogin();
		}
	}
	
	public void rewardsSignout() throws BusinessException, InterruptedException {
		test.script(CLICK_BUTTON, OR_GenericRewards.BTN_SIGNOUT, "");
	}
	
	private void facebookLogin() throws BusinessException, InterruptedException {
		test.script(CLICK_BUTTON, OR_GenericRewards.BTN_LOGIN_MAIN_PAGE, "");
		test.script(CLICK_BUTTON, OR_GenericRewards.BTN_LOGIN_FACEBOOK_REWARDS, "");
		test.script(TYPE, OR_GenericRewards.TXT_USERNAME_FACEBOOK_LOGIN, XL_GenericRewards.USERNAME);
		test.script(TYPE, OR_GenericRewards.TXT_PASSWORD_FACEBOOK_LOGIN, XL_GenericRewards.PASSWORD);
		test.script(CLICK_BUTTON, OR_GenericRewards.BTN_LOGIN_FACEBOOK_FB, "");
	}
	
	private void rewardsMainLogin() throws BusinessException, InterruptedException {
		test.script(CLICK_BUTTON, OR_GenericRewards.BTN_LOGIN_MAIN_PAGE, "");
		Thread.sleep(5000);
		test.script(TYPE, OR_GenericRewards.TXT_USERNAME_RABBIT_NO, XL_GenericRewards.USERNAME);
		test.script(TYPE, OR_GenericRewards.TXT_PASSWORD, XL_GenericRewards.PASSWORD);
		test.script(CLICK_BUTTON, OR_GenericRewards.BTN_LOGIN_ON_POPUP, "");
		test.script(WAIT_FOR_VISIBLE, OR_GenericRewards.LBL_WELCOME_NAME,"", false, 20);
		/*test.setSheetName(XL_GenericRewards.SHEET_MY_DETAIL);*/
		String expectedWelcomeMessage = test.getData(XL_GenericRewards.FIRST_NAME).toUpperCase();
		String actualWelcomeMessage = test.getTextFromElement(OR_GenericRewards.LBL_WELCOME_NAME);
		test.comparisonResult(expectedWelcomeMessage, actualWelcomeMessage, "Welcome Message");
	}
	
	
	
}

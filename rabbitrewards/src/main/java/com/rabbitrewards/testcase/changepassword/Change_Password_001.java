package com.rabbitrewards.testcase.changepassword;


import org.testng.annotations.Test;

import com.automation.framework.exception.BusinessException;
import com.rabbitbase.generic.BaseClass;
import com.rabbitbase.generic.Generic_Rewards;
import com.rabbitrewards.testscript.ChangePassword;


public class Change_Password_001 extends BaseClass {

	@Override
	protected String getConfigPath() throws BusinessException {
		return "framework";
	}
	
	@Override
	protected String getTestDataFile() throws BusinessException {
		return "Rabbit_Rewards.xls";
	}
	
	@Test(groups = {"CHANGE_PASSWORD"})
	public void changePassword() throws Exception {
		setExcelRow(2);
		ChangePassword cp = new ChangePassword(testWareBean, test);
		cp.changePassword();
		executeScript(cp);
	}
	
	@Test(dependsOnMethods = {"changePassword"}, groups = {"CHANGE_PASSWORD"})
	public void rewardsSignOut_1() throws Exception {
		setExcelRow(2);
		Generic_Rewards rewardsSignOut = Generic_Rewards.getInstance(testWareBean, test);
		rewardsSignOut.rewardsSignout();
		executeScript(rewardsSignOut);
	}
	
	@Test(dependsOnMethods = {"rewardsSignOut_1"}, groups = {"CHANGE_PASSWORD"})
	public void rollBackChangePassword() throws Exception {
		setExcelRow(3);
		ChangePassword cp = new ChangePassword(testWareBean, test);
		cp.changePassword();
		executeScript(cp);
	}
	
	@Test(dependsOnMethods = {"rollBackChangePassword"}, groups = {"CHANGE_PASSWORD"})
	public void rewardsSignOut_2() throws Exception {
		setExcelRow(2);
		Generic_Rewards rewardsSignOut = Generic_Rewards.getInstance(testWareBean, test);
		rewardsSignOut.rewardsSignout();
		executeScript(rewardsSignOut);
	}
}

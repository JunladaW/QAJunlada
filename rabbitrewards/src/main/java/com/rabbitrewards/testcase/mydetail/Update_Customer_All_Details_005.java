package com.rabbitrewards.testcase.mydetail;


import org.testng.annotations.Test;

import com.automation.framework.exception.BusinessException;
import com.rabbitbase.generic.BaseClass;
import com.rabbitbase.generic.Generic_Rewards;
import com.rabbitrewards.testscript.MyDetail;

public class Update_Customer_All_Details_005 extends BaseClass {

	@Override
	protected String getConfigPath() throws BusinessException {
		return "framework";
	}
	
	@Override
	protected String getTestDataFile() throws BusinessException {
		return "Rabbit_Rewards.xls";
	}
	
	@Test(groups = {"UPDATE_CUSTOMER"})
	public void rewardsLogin() throws Exception {
		setExcelRow(2);
		Generic_Rewards rewardsLogin = Generic_Rewards.getInstance(testWareBean, test);
		rewardsLogin.rewardsLogin();
		executeScript(rewardsLogin);
	}
	
	@Test(dependsOnMethods = {"rewardsLogin"}, groups = {"UPDATE_CUSTOMER"})
	public void updateExisitingCustomerDetails() throws Exception {
		setExcelRow(6);
		MyDetail ri = new MyDetail(testWareBean, test);
		ri.updateDetailsForExistingCustomer();
		executeScript(ri);
	}
	
	@Test(dependsOnMethods = {"updateExisitingCustomerDetails"}, groups = {"UPDATE_CUSTOMER"})
	public void rewardsSignOut_1() throws Exception {
		setExcelRow(2);
		Generic_Rewards rewardsSignOut = Generic_Rewards.getInstance(testWareBean, test);
		rewardsSignOut.rewardsSignout();
		executeScript(rewardsSignOut);
	}
	
	@Test(dependsOnMethods = {"rewardsSignOut_1"}, groups = {"UPDATE_CUSTOMER"})
	public void rewardsLogin_2() throws Exception {
		setExcelRow(2);
		Generic_Rewards rewardsLogin = Generic_Rewards.getInstance(testWareBean, test);
		rewardsLogin.rewardsLogin();
		executeScript(rewardsLogin);
	}
	
	@Test(dependsOnMethods = {"rewardsLogin_2"}, groups = {"UPDATE_CUSTOMER"})
	public void staticValidationMyDetail() throws Exception {
		setExcelRow(6);
		MyDetail ri = new MyDetail(testWareBean, test);
		ri.staticValidationUpdateDetails();
		executeScript(ri);
	}

	@Test(dependsOnMethods = {"staticValidationMyDetail"}, groups = {"UPDATE_CUSTOMER"})
	public void rewardsSignOut_2() throws Exception {
		setExcelRow(2);
		Generic_Rewards rewardsSignOut = Generic_Rewards.getInstance(testWareBean, test);
		rewardsSignOut.rewardsSignout();
		executeScript(rewardsSignOut);
	}
}

package com.rabbitrewards.testcase.redeem;


import org.testng.annotations.Test;

import com.automation.framework.exception.BusinessException;
import com.rabbitbase.generic.BaseClass;
import com.rabbitbase.generic.Generic_Rewards;
import com.rabbitrewards.testscript.Redeem;


public class Update_Shipping_Address_In_Redeem_Only_002 extends BaseClass {

	@Override
	protected String getConfigPath() throws BusinessException {
		return "framework";
	}
	
	@Override
	protected String getTestDataFile() throws BusinessException {
		return "Rabbit_Rewards.xls";
	}
	
	@Test(groups = {"REDEEM"})
	public void rewardsLogin() throws Exception {
		setExcelRow(4);
		Generic_Rewards rewardsLogin = Generic_Rewards.getInstance(testWareBean, test);
		rewardsLogin.rewardsLogin();
		executeScript(rewardsLogin);
	}
	
	@Test(dependsOnMethods = {"rewardsLogin"}, groups = {"REDEEM"})
	public void updateNewRedeemShippingAddress() throws Exception {
		setExcelRow(3);
		Redeem redeem = new Redeem(testWareBean, test);
		redeem.updateShippingAddress();
		executeScript(redeem);
	}
	
	@Test(dependsOnMethods = {"updateNewRedeemShippingAddress"}, groups = {"REDEEM"})
	public void validateRedeemAndMyDetailShippingAddress() throws Exception {
		setExcelRow(3);
		Redeem redeem = new Redeem(testWareBean, test);
		redeem.validateRedeemandMyDetailShippingAddNotSame();
		executeScript(redeem);
	}
	
	@Test(dependsOnMethods = {"validateRedeemAndMyDetailShippingAddress"}, groups = {"REDEEM"})
	public void rewardsSignOut() throws Exception {
		setExcelRow(2);
		Generic_Rewards rewardsSignOut = Generic_Rewards.getInstance(testWareBean, test);
		rewardsSignOut.rewardsSignout();
		executeScript(rewardsSignOut);
	}
}

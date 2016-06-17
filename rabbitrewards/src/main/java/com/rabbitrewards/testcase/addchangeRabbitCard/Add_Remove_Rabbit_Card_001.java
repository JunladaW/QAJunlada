package com.rabbitrewards.testcase.addchangeRabbitCard;


import org.testng.annotations.Test;

import com.automation.framework.exception.BusinessException;
import com.rabbitbase.generic.BaseClass;
import com.rabbitbase.generic.Generic_Rewards;
import com.rabbitrewards.testscript.AddChangeRabbitCard;


public class Add_Remove_Rabbit_Card_001 extends BaseClass {

	@Override
	protected String getConfigPath() throws BusinessException {
		return "framework";
	}
	
	@Override
	protected String getTestDataFile() throws BusinessException {
		return "Rabbit_Rewards.xls";
	}
	
	@Test(groups = {"ADD_REMOVE_RABBIT_CARD"})
	public void rewardsLogin() throws Exception {
		setExcelRow(2);
		Generic_Rewards rewardsLogin = Generic_Rewards.getInstance(testWareBean, test);
		rewardsLogin.rewardsLogin();
		executeScript(rewardsLogin);
	}
	
	@Test(dependsOnMethods = {"rewardsLogin"}, groups = {"ADD_REMOVE_RABBIT_CARD"})
	public void addRabbitCard() throws Exception {
		setExcelRow(2);
		AddChangeRabbitCard addRabbitCard = new AddChangeRabbitCard(testWareBean, test);
		addRabbitCard.addRabbitCard();;
		executeScript(addRabbitCard);
	}
	
	@Test(dependsOnMethods = {"addRabbitCard"}, groups = {"ADD_REMOVE_RABBIT_CARD"})
	public void rewardsSignOut_1() throws Exception {
		setExcelRow(2);
		Generic_Rewards rewardsSignOut = Generic_Rewards.getInstance(testWareBean, test);
		rewardsSignOut.rewardsSignout();
		executeScript(rewardsSignOut);
	}
	
	@Test(dependsOnMethods = {"rewardsSignOut_1"}, groups = {"ADD_REMOVE_RABBIT_CARD"})
	public void rewardsLogin_1() throws Exception {
		setExcelRow(2);
		Generic_Rewards rewardsLogin = Generic_Rewards.getInstance(testWareBean, test);
		rewardsLogin.rewardsLogin();
		executeScript(rewardsLogin);
	}
	
	@Test(dependsOnMethods = {"rewardsLogin_1"}, groups = {"ADD_REMOVE_RABBIT_CARD"})
	public void removeRabbitCard() throws Exception {
		setExcelRow(2);
		AddChangeRabbitCard addRabbitCard = new AddChangeRabbitCard(testWareBean, test);
		addRabbitCard.removeRabbitCard();;
		executeScript(addRabbitCard);
	}
	
	@Test(dependsOnMethods = {"removeRabbitCard"}, groups = {"ADD_REMOVE_RABBIT_CARD"})
	public void rewardsSignOut_2() throws Exception {
		setExcelRow(2);
		Generic_Rewards rewardsSignOut = Generic_Rewards.getInstance(testWareBean, test);
		rewardsSignOut.rewardsSignout();
		executeScript(rewardsSignOut);
	}
}

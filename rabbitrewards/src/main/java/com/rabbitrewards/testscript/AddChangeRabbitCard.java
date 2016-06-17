package com.rabbitrewards.testscript;

import com.automation.framework.applib.FunctionsApplib;
import com.automation.framework.beans.TestWareBean;
import com.automation.framework.exception.BusinessException;
import com.automation.framework.util.Test;
import com.rabbitbase.excelcolumns.XL_GenericRewards;
import com.rabbitbase.objectrepository.OR_GenericRewards;
import com.rabbitrewards.excelcolumns.XL_AddChangeRabbitCard;
import com.rabbitrewards.objectrepository.OR_AddChangeRabbitCards;


public class AddChangeRabbitCard extends FunctionsApplib {

	public AddChangeRabbitCard(TestWareBean testWareBean, Test test) throws BusinessException {
		super(testWareBean, test);
	}

	@Override
	protected String getSheetName() {
		return XL_GenericRewards.SHEET_ADD_CHANGE_RABBIT_CARDS;
	}


	public void addRabbitCard() throws BusinessException, InterruptedException {
		
		test.script(CLICK_BUTTON, OR_GenericRewards.LBL_WELCOME_NAME, "");
		test.script(CLICK_BUTTON, OR_AddChangeRabbitCards.LNK_ADD_CHANGE_RABBIT_CARDS, "");
		test.script(PRESENT, OR_AddChangeRabbitCards.LBL_ADD_CHANGE_RABBIT_CARDS, "");
		
		int totalRabbitCardsInputCount = test.getCount(OR_AddChangeRabbitCards.COUNT_ADD_MY_CARD);
		if(totalRabbitCardsInputCount>5){
			test.reportMessage("Total Available Rabbit Cards exceed more than 5 and Count is '"+totalRabbitCardsInputCount+"'", true);
		}else{
			test.reportMessage("Total Available Rabbit Cards to add '"+totalRabbitCardsInputCount+"'", false);
		}
		int incrementXpath = 1;
		String xlAddRabbitCard = test.getData(XL_AddChangeRabbitCard.ADD_RABBIT_CARD);
		String[] arrAddRabbitCard = xlAddRabbitCard.split(",");
		int xlAddRabbitCardCount = arrAddRabbitCard.length;
		for(int addRabbitCard=0;addRabbitCard<xlAddRabbitCardCount;addRabbitCard++){
			String[] txtAddRabbitCard = test.replaceXpath(OR_AddChangeRabbitCards.TXT_ADD_RABBIT_CARD_TO_REWARDS, incrementXpath);
			String[] chkAddRabbitCard = test.replaceXpath(OR_AddChangeRabbitCards.CHK_ADD_RABBIT_CARD_TO_REWARDS, incrementXpath);
			test.script(TYPE, txtAddRabbitCard, XL_AddChangeRabbitCard.ADD_RABBIT_CARD, arrAddRabbitCard[addRabbitCard]);
			test.script(CLICK_BUTTON, chkAddRabbitCard, "");
			incrementXpath = incrementXpath+2;
		}
		test.script(CLICK_BUTTON, OR_AddChangeRabbitCards.BTN_ADD, "");
		if(test.isExists(OR_AddChangeRabbitCards.LBL_ADD_SUCCESS)){
			test.reportMessage("Rabbit Card added successfully!", false);
		}else{
			test.reportMessage("Rabbit Card added successfully!", true);
		}
	}
	
	public void removeRabbitCard() throws BusinessException, InterruptedException {
		
		test.script(CLICK_BUTTON, OR_GenericRewards.LBL_WELCOME_NAME, "");
		test.script(CLICK_BUTTON, OR_AddChangeRabbitCards.LNK_ADD_CHANGE_RABBIT_CARDS, "");
		test.script(PRESENT, OR_AddChangeRabbitCards.LBL_ADD_CHANGE_RABBIT_CARDS, "");
		
		int incrementXpath = 1;
		int totalRabbitCardsRemoveCount = test.getCount(OR_AddChangeRabbitCards.COUNT_REMOVE_MY_CARD);
		for(int removeCount=1;removeCount<=totalRabbitCardsRemoveCount;removeCount++){
			String[] txtRemoveRabbitCard = test.replaceXpath(OR_AddChangeRabbitCards.TXT_REMOVE_RABBIT_CARD_NUMBER, incrementXpath);
			String actualRemoveCardNumber = test.getTextFromTextBox(txtRemoveRabbitCard);
			String expectedRemoveCardNumber = test.getData(XL_AddChangeRabbitCard.REMOVE_RABBIT_CARD);
			if(expectedRemoveCardNumber.equals(actualRemoveCardNumber)){
				test.reportMessage("Check Rabbit Card Number '"+actualRemoveCardNumber+"' to remove", false);
				String[] chkRemoveRabbitCard = test.replaceXpath(OR_AddChangeRabbitCards.CHK_REMOVE_RABBIT_CARD_NUMBER, incrementXpath);
				test.script(CLICK_BUTTON, chkRemoveRabbitCard, "");
			}
			incrementXpath = incrementXpath+2;
		}
		test.script(CLICK_BUTTON, OR_AddChangeRabbitCards.BTN_REMOVE, "");
		if(test.isExists(OR_AddChangeRabbitCards.LBL_REMOVE_SUCCESS)){
			test.reportMessage("Rabbit Card removed successfully!", false);
		}else{
			test.reportMessage("Rabbit Card removed successfully!", true);
		}
		
	}
	
	

}

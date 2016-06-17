package com.rabbitrewards.objectrepository;

public class OR_AddChangeRabbitCards {

	/*Add Rabbit Card*/
	public static final String[] LNK_ADD_CHANGE_RABBIT_CARDS = {"//i[@class='icon icon-setting']","Add / Change Rabbit Cards"};
	public static final String[] COUNT_ADD_MY_CARD = {"//div[9]//div[1]/input","Total Rabbit Card Add List"};
	public static final String[] TXT_ADD_RABBIT_CARD_TO_REWARDS = {"//div[9]/div[%s]/div[1]/input","Add Rabbit Card Textbox"};
	public static final String[] CHK_ADD_RABBIT_CARD_TO_REWARDS = {"//div[9]/div[%s]/div[2]/input","Add Rabbit Card Checkbox"};
	public static final String[] BTN_ADD = {"//button[@class='btn btn-block btn-success' and contains(@form-action,'click:add')]","Add Rabbit Card"};
	public static final String[] LBL_ADD_SUCCESS = {"//span[@class='add-status-span' and contains(.,'Success')]","Adding Rabbit Card Successful"};
	public static final String[] LBL_ADD_CHANGE_RABBIT_CARDS = {"//div[@class='partial-title h3' and contains(.,'Add/Change Rabbit cards')]","Add/Change Rabbit cards"};
	
	/*Remove Rabbit Card*/
	public static final String[] COUNT_REMOVE_MY_CARD = {"//div[4]/div[1]/div[2]/div/div/div/div[4]//div[1]/input","Total Rabbit Card Remove List"};
	public static final String[] TXT_REMOVE_RABBIT_CARD_NUMBER = {"//div[4]/div[%s]/div[1]/input","Remove Rabbit Card Textbox"};
	public static final String[] CHK_REMOVE_RABBIT_CARD_NUMBER = {"//div[4]/div[%s]/div[2]/input","Remove Rabbit Card Checkbox"};
	public static final String[] BTN_REMOVE = {"//button[@class='btn btn-block btn-success' and contains(@form-action,'click:remove')]","Remove Rabbit Card"};
	public static final String[] LBL_REMOVE_SUCCESS = {"//span[@class='remove-status-span' and contains(.,'Success')]","Removing Rabbit Card Successful"};
	
}

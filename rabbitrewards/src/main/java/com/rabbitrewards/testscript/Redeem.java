package com.rabbitrewards.testscript;

import com.automation.framework.applib.FunctionsApplib;
import com.automation.framework.beans.TestWareBean;
import com.automation.framework.exception.BusinessException;
import com.automation.framework.util.Test;
import com.rabbitbase.constants.Project_Constants;
import com.rabbitbase.excelcolumns.XL_GenericRewards;
import com.rabbitbase.objectrepository.OR_GenericRewards;
import com.rabbitrewards.excelcolumns.XL_Redeem;
import com.rabbitrewards.objectrepository.OR_MyDetail;
import com.rabbitrewards.objectrepository.OR_Redeem;


public class Redeem extends FunctionsApplib {

	public Redeem(TestWareBean testWareBean, Test test) throws BusinessException {
		super(testWareBean, test);
	}

	@Override
	protected String getSheetName() {
		return XL_GenericRewards.SHEET_REDEEM;
	}

	public void updateShippingAddress() throws BusinessException, InterruptedException {
		
		redeemAndAddToCart();
		
		test.script(WAIT_FOR_VISIBLE, OR_Redeem.WLS_DELIVERY_OPTION_CART, "");
		test.script(CLICK_BUTTON, OR_Redeem.WLS_DELIVERY_OPTION_CART, "");
		test.script(CLICK_BUTTON, OR_Redeem.CHK_HOME_DELIVERY, "");
		test.script(CLICK_BUTTON, OR_Redeem.BTN_CLICK_OUTSIDE, "");
		test.script(CLICK_BUTTON, OR_Redeem.BTN_EDIT_SHIPPING_ADDRESS, "");
		test.script(CLEAR_TYPE, OR_Redeem.TXT_REDEEM_SHIPPING_ADDRESS_NO, XL_Redeem.SHIPPING_ADDRESS_NO );
		test.script(CLEAR_TYPE, OR_Redeem.TXT_REDEEM_VILLAGE_OR_BUILDING, XL_Redeem.SHIPPING_VILLAGE_OR_BUILDING);
		test.script(CLEAR_TYPE, OR_Redeem.TXT_REDEEM_SOI, XL_Redeem.SHIPPING_SOI);
		test.script(CLEAR_TYPE, OR_Redeem.TXT_REDEEM_STREET, XL_Redeem.SHIPPING_STREET);
		test.script(CLEAR_TYPE, OR_Redeem.TXT_REDEEM_SUB_DISTRICT, XL_Redeem.SHIPPING_SUB_DISTRICT);
		test.script(CLEAR_TYPE, OR_Redeem.TXT_REDEEM_DISTRICT, XL_Redeem.SHIPPING_DISTRICT);
		test.script(SELECT_LIST, OR_Redeem.WLS_REDEEM_PROVINCE, XL_Redeem.SHIPPING_PROVINCE);
		test.script(CLEAR_TYPE, OR_Redeem.TXT_REDEEM_ZIPCODE, XL_Redeem.SHIPPING_POSTCODE);
		
		String isSaveThisAddress = test.getData(XL_Redeem.IS_UPDATE_TO_MYDETAIL);
		if(isSaveThisAddress.equals(Project_Constants.YES)){
			test.script(CLICK_BUTTON, OR_Redeem.CHK_SAVE_THIS_ADDRESS, "");
		}
		test.script(CLICK_BUTTON, OR_Redeem.BTN_SAVE_SHIPPING_ADDRESS, "");
		Thread.sleep(5000);
	}

	public void validateRedeemandMyDetailShippingAddSame() throws BusinessException, InterruptedException {
		
		test.script(CLICK_BUTTON, OR_GenericRewards.LBL_WELCOME_NAME, "");
		test.script(CLICK_BUTTON, OR_MyDetail.LNK_USER_MY_DETAIL, "");
		test.staticValidateTextBox(XL_Redeem.SHIPPING_ADDRESS_NO, OR_MyDetail.TXT_SHIPPING_ADDRESS_NO);
		test.staticValidateTextBox(XL_Redeem.SHIPPING_VILLAGE_OR_BUILDING, OR_MyDetail.TXT_SHIPPING_VILLAGE_OR_BUILDING);
		test.staticValidateTextBox(XL_Redeem.SHIPPING_SOI, OR_MyDetail.TXT_SHIPPING_SOI);
		test.staticValidateTextBox(XL_Redeem.SHIPPING_STREET, OR_MyDetail.TXT_SHIPPING_STREET);
		test.staticValidateTextBox(XL_Redeem.SHIPPING_SUB_DISTRICT, OR_MyDetail.TXT_SHIPPING_SUB_DISTRICT);
		test.staticValidateTextBox(XL_Redeem.SHIPPING_DISTRICT, OR_MyDetail.TXT_SHIPPING_DISTRICT);
		test.staticValidateSelectList(XL_Redeem.SHIPPING_PROVINCE, OR_MyDetail.WLS_SHIPPING_PROVINCE);
		test.staticValidateTextBox(XL_Redeem.SHIPPING_POSTCODE, OR_MyDetail.TXT_SHIPPING_POSTCODE);
		
	}
	
	public void validateRedeemandMyDetailShippingAddNotSame() throws BusinessException, InterruptedException {
		
		test.script(CLICK_BUTTON, OR_GenericRewards.LBL_WELCOME_NAME, "");
		test.script(CLICK_BUTTON, OR_MyDetail.LNK_USER_MY_DETAIL, "");
		
		String getNumber = test.getTextFromTextBox(OR_MyDetail.TXT_SHIPPING_ADDRESS_NO);
		String getVillage = test.getTextFromTextBox(OR_MyDetail.TXT_SHIPPING_VILLAGE_OR_BUILDING);
		String getSoi = test.getTextFromTextBox(OR_MyDetail.TXT_SHIPPING_SOI);
		String getStreet = test.getTextFromTextBox(OR_MyDetail.TXT_SHIPPING_STREET);
		String getSubDistrict = test.getTextFromTextBox(OR_MyDetail.TXT_SHIPPING_SUB_DISTRICT);
		String getDistrict = test.getTextFromTextBox(OR_MyDetail.TXT_SHIPPING_DISTRICT);
		String getProvince = test.getTextFromSelected(OR_MyDetail.WLS_SHIPPING_PROVINCE);
		String getPostcode = test.getTextFromTextBox(OR_MyDetail.TXT_SHIPPING_POSTCODE);
		
		String actNumber = test.getData(XL_Redeem.SHIPPING_ADDRESS_NO);
		String actVillage = test.getData(XL_Redeem.SHIPPING_VILLAGE_OR_BUILDING);
		String actSoi = test.getData(XL_Redeem.SHIPPING_SOI);
		String actStreet = test.getData(XL_Redeem.SHIPPING_STREET);
		String actSubDistrict = test.getData(XL_Redeem.SHIPPING_SUB_DISTRICT);
		String actDistrict = test.getData(XL_Redeem.SHIPPING_DISTRICT);
		String actProvince = test.getData(XL_Redeem.SHIPPING_PROVINCE);
		String actPostcode = test.getData(XL_Redeem.SHIPPING_POSTCODE);

		if(!getNumber.equals(actNumber) && !getVillage.equals(actVillage) && !getSoi.equals(actSoi) && !getStreet.equals(actStreet) &&
				!getSubDistrict.equals(actSubDistrict) && !getDistrict.equals(actDistrict) && !getProvince.equals(actProvince) && !getPostcode.equals(actPostcode)){
			test.reportMessage("Redeem and My Detail Shipping Address are not same", false);
			test.reportMessage("Shipping Number : Redeem '"+actNumber+ "' || My Detail '"+getNumber+"'", false);
			test.reportMessage("Shipping Building : Redeem '"+actVillage+ "' || My Detail '"+getVillage+"'", false);
			test.reportMessage("Shipping Soi : Redeem '"+actSoi+ "' || My Detail '"+getSoi+"'", false);
			test.reportMessage("Shipping Street : Redeem '"+actStreet+ "' || My Detail '"+getStreet+"'", false);
			test.reportMessage("Shipping Sub-District : Redeem '"+actSubDistrict+ "' My Detail '"+getSubDistrict+"'", false);
			test.reportMessage("Shipping District : Redeem '"+actDistrict+ "' || My Detail '"+getDistrict+"'", false);
			test.reportMessage("Shipping Province : Redeem '"+actProvince+ "' || My Detail '"+getProvince+"'", false);
			test.reportMessage("Shipping Postcode : Redeem '"+actPostcode+ "' || My Detail '"+getPostcode+"'", false);
		}else{
			test.reportMessage("Redeem and My Detail Shipping Address are not same", false);
			test.reportMessage("Shipping Number : Redeem '"+actNumber+ "' || My Detail '"+getNumber+"'", false);
			test.reportMessage("Shipping Building : Redeem '"+actVillage+ "' || My Detail '"+getVillage+"'", false);
			test.reportMessage("Shipping Soi : Redeem '"+actSoi+ "' || My Detail '"+getSoi+"'", false);
			test.reportMessage("Shipping Street : Redeem '"+actStreet+ "' || My Detail '"+getStreet+"'", false);
			test.reportMessage("Shipping Sub-District : Redeem '"+actSubDistrict+ "' My Detail '"+getSubDistrict+"'", false);
			test.reportMessage("Shipping District : Redeem '"+actDistrict+ "' || My Detail '"+getDistrict+"'", false);
			test.reportMessage("Shipping Province : Redeem '"+actProvince+ "' || My Detail '"+getProvince+"'", false);
			test.reportMessage("Shipping Postcode : Redeem '"+actPostcode+ "' || My Detail '"+getPostcode+"'", true);
		}
		
	}
	
	public void redeemDirectly() throws BusinessException, InterruptedException {
		
		int pointsBalanceBforeRedeem = pointsBalanace();
		test.reportMessage("Points Balance Before Redeem --- "+pointsBalanceBforeRedeem, false);
		
		test.script(CLICK_BUTTON, OR_Redeem.LNK_REDEEM_MAIN, "");
		
		int getRedeemCount = test.getCount(OR_Redeem.COUNT_REDEEM_LIST);
		test.reportMessage("Redeem Count --- "+getRedeemCount, false);
		
		String getPoints = test.getTextFromElement(OR_Redeem.LBL_REDEEM_POINTS);
		String arrPoints[] = getPoints.split(" ");
		int getActualPoints = Integer.parseInt(arrPoints[0]);
		int getQuantity = Integer.parseInt(test.getData(XL_Redeem.REDEEM_QUANTITY));
		int getTotalPoints = getActualPoints * getQuantity;
		
		test.script(CLICK_BUTTON, OR_Redeem.BTN_REDEEM_LIST, "");
		test.script(SELECT_LIST, OR_Redeem.WLS_REDEEM_QUANTITY, XL_Redeem.REDEEM_QUANTITY);
		test.script(CLICK_BUTTON, OR_Redeem.BTN_REDEEM_DIRECT, "");
		
		redeemPointDeduction();
		
		int actualPointsAfterRedeem = pointsBalanace();
		int expectedPointsAfterRedeem = pointsBalanceBforeRedeem - getTotalPoints;
		test.comparisonResult(""+expectedPointsAfterRedeem, ""+actualPointsAfterRedeem, "Points Balance");	
	}
	
	public void redeemFromCart() throws BusinessException, InterruptedException {
		int pointsBalanceBforeRedeem = pointsBalanace();
		test.reportMessage("Points Balance Before Redeem --- "+pointsBalanceBforeRedeem, false);
		
		test.script(CLICK_BUTTON, OR_Redeem.LNK_REDEEM_MAIN, "");
		
		int getRedeemCount = test.getCount(OR_Redeem.COUNT_REDEEM_LIST);
		test.reportMessage("Redeem Count --- "+getRedeemCount, false);
		
		String getPoints = test.getTextFromElement(OR_Redeem.LBL_REDEEM_POINTS);
		String arrPoints[] = getPoints.split(" ");
		int getActualPoints = Integer.parseInt(arrPoints[0]);
		int getQuantity = Integer.parseInt(test.getData(XL_Redeem.REDEEM_QUANTITY));
		int getTotalPoints = getActualPoints * getQuantity;
		
		test.script(CLICK_BUTTON, OR_Redeem.BTN_REDEEM_LIST, "");
		test.script(SELECT_LIST, OR_Redeem.WLS_REDEEM_QUANTITY, XL_Redeem.REDEEM_QUANTITY);
		test.script(CLICK_BUTTON, OR_Redeem.BTN_ADD_TO_CART, "");
		
		String getCartMessage = test.getTextFromElement(OR_Redeem.LBL_REDEEM_TO_CART_SUCCESS);
		test.reportMessage("Redeem Success : "+getCartMessage, false);
		test.script(CLICK_BUTTON, OR_Redeem.BTN_GO_TO_CART, "");
		test.script(CLICK_BUTTON, OR_Redeem.WLS_DELIVERY_OPTION_CART, "");
		test.script(CLICK_BUTTON, OR_Redeem.CHK_HOME_DELIVERY, "");
		test.script(CLICK_BUTTON, OR_Redeem.BTN_CLICK_OUTSIDE, "");
		test.script(CLICK_BUTTON, OR_Redeem.CHK_REDEEM_TERMS_CONDITIONS, "");
		test.script(CLICK_BUTTON, OR_Redeem.BTN_REDEEM_FROM_CART, "");
		String redeemSuccess = test.getTextFromElement(OR_Redeem.LBL_REDEEM_SUCCESS);
		test.reportMessage(redeemSuccess, false);
		test.script(CLICK_BUTTON, OR_Redeem.BTN_CLOSE_REDEEM_SUCCESS, "");
		
		int actualPointsAfterRedeem = pointsBalanace();
		int expectedPointsAfterRedeem = pointsBalanceBforeRedeem - getTotalPoints;
		test.comparisonResult(""+expectedPointsAfterRedeem, ""+actualPointsAfterRedeem, "Points Balance");	
	}
	
	private void redeemAndAddToCart() throws BusinessException, InterruptedException {
		
		test.script(CLICK_BUTTON, OR_Redeem.LNK_REDEEM_MAIN, "");
		
		int getRedeemCount = test.getCount(OR_Redeem.COUNT_REDEEM_LIST);
		test.reportMessage("Redeem Count "+getRedeemCount, false);
		test.script(CLICK_BUTTON, OR_Redeem.BTN_REDEEM_LIST, "");
		test.script(SELECT_LIST, OR_Redeem.WLS_REDEEM_QUANTITY, XL_Redeem.REDEEM_QUANTITY);
		test.script(CLICK_BUTTON, OR_Redeem.BTN_ADD_TO_CART, "");
		
		String getCartMessage = test.getTextFromElement(OR_Redeem.LBL_REDEEM_TO_CART_SUCCESS);
		test.reportMessage("Redeem Success : "+getCartMessage, false);
		test.script(CLICK_BUTTON, OR_Redeem.BTN_GO_TO_CART, "");		
	}
	
	private int pointsBalanace() throws BusinessException, InterruptedException {
		test.script(WAIT_FOR_CLICKABLE, OR_GenericRewards.LBL_WELCOME_NAME, "");
		test.script(CLICK_BUTTON, OR_GenericRewards.LBL_WELCOME_NAME, "");
		int getPointsBalance = Integer.parseInt(test.getTextFromElement(OR_Redeem.LBL_POINTS_BALANCE));
		return getPointsBalance;
	}
	
	private void redeemPointDeduction() throws BusinessException, InterruptedException {
		String getTitle = test.getTextFromElement(OR_Redeem.LBL_POINT_DEDUCTION_TITLE);
		test.reportMessage("Title "+getTitle, false);
		test.script(CLICK_BUTTON, OR_Redeem.WLS_DELIVERY_OPTION_REDEEM, "");
		test.script(CLICK_BUTTON, OR_Redeem.CHK_HOME_DELIVERY_REDEEM, "");
		test.script(CLICK_BUTTON, OR_Redeem.LBL_POINT_DEDUCTION_TITLE, "");
		test.script(CLICK_BUTTON, OR_Redeem.CHK_REDEEM_TERMS_CONDITIONS, "");
		test.script(CLICK_BUTTON, OR_Redeem.BTN_REDEEM_FROM_POINT_DEDUCTION, "");
		String redeemSuccess = test.getTextFromElement(OR_Redeem.LBL_REDEEM_SUCCESS);
		test.reportMessage(redeemSuccess, false);
		test.script(CLICK_BUTTON, OR_Redeem.BTN_CLOSE_REDEEM_SUCCESS, "");
	}
}

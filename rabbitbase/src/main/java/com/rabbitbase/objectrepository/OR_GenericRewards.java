package com.rabbitbase.objectrepository;

public class OR_GenericRewards {

	/*MAIN PAGE*/
	public static final String[] LNK_EN_LANGUAGE = {"//*[@id='navbar-collapse']/div/a[1]","English Language"};
	public static final String[] LNK_EN_LANGUAGE_ACTIVE = {"//*[@id='navbar-collapse']/div/a[@class='active' and contains(.,'EN')]","English Language"};
	public static final String[] LNK_TH_LANGUAGE = {"//*[@id='navbar-collapse']/div/a[2]","Thai Language"};
	
	
	/*MENU*/
	public static final String[] LBL_WELCOME_NAME = {"//section/div/div[2]/ul/li[8]/a[contains(@href,'/account')]","Welcome Name"};
	public static final String[] BTN_SHOPPING_CART = {"//section[1]/div/div[2]/ul/li[9]/a[@class='badge-item']","Shopping Cart"};
	public static final String[] BTN_SIGNOUT = {"//i[@class='icon icon-logout']","Sign Out"};
	public static final String[] BTN_LOGIN_MAIN_PAGE = { "//section[1]/div/div[2]/ul/li[8]/a[contains(.,'Login')]", "Login on Main Page" };
	public static final String[] BTN_SIGNUP_MAIN_PAGE = {"//section[1]/div/div[2]/ul/li[8]/a[contains(.,'Sign Up')]","Sign up on Main page"};
	
	/*LOGIN PAGE*/
	public static final String[] TXT_USERNAME_RABBIT_NO = {"//*[@id='popup-login-form']/div[1]/input","UserName / Rabbit Card No"};
	public static final String[] TXT_PASSWORD = {"//*[@id='popup-login-form']/div[2]/input","Password"};
	public static final String[] BTN_LOGIN_FACEBOOK_REWARDS = {"//*[@id='fb-login-button']/a","Facebook Login button on Rewards"};
	public static final String[] BTN_LOGIN_ON_POPUP = {"//*[@id='popup-login-form']/button","Login on Popup"};
	public static final String[] LNK_FORGOT_PASSWORD = {"//*[@id='forgotten-password']/a","Forgot Password"};
	public static final String[] TXT_EMAIL_FORGOT_PASSWORD = {"//*[@id='form-forgotten-password']/div[1]/input","Email Forgot Password"};
	public static final String[] BTN_BACK_FORGOT_PASSWORD = {"//*[@id='back-to-login']","Back button Forgot Password"};
	public static final String[] BTN_SEND_FORGOT_PASSWORD = {"//*[@id='form-forgotten-password']/div[2]/div[2]/button","SEND button Forgot Password"};
	public static final String[] LNK_DONT_HAVE_AN_ACCOUNT = {"//*[@id='popup-login-form']/p[3]/a","Don't have an account"};
	public static final String[] TXT_USERNAME_FACEBOOK_LOGIN = {"//*[@id='email']","Facebook Email or phone number"};
	public static final String[] TXT_PASSWORD_FACEBOOK_LOGIN = {"","Facebook Password"};
	public static final String[] BTN_LOGIN_FACEBOOK_FB = {"//*[@id='loginbutton']","Facebook Login button on Facebook"};
	
	public static final String[] WLS_PREFERRED_LANGUAGE = {"//*[@id='language']","Preferred Language"};
}

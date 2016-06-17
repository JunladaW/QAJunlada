package com.rabbitrewards.objectrepository;

public class OR_ChangePassword {

	public static final String[] LNK_CHANGE_PASSWORD = {"//i[@class='icon icon-keyword']","Change Password"};
	public static final String[] TXT_OLD_PASSWORD = {"//input[@type='password' and contains(@form-name,'oldPassword')]","Old Password"};
	public static final String[] TXT_NEW_PASSWORD = {"//input[@type='password' and contains(@form-name,'newPassword') and contains(@placeholder,'Enter your NEW password')]","New Password"};
	public static final String[] TXT_CONFIRM_PASSWORD = {"//input[@type='password' and contains(@form-name,'newPasswordConfirm')]","Confirm Password"};
	public static final String[] BTN_SUBMIT = {"//button[@class='btn btn-block btn-success' and contains(@form-action,'click:submit')]","Submit"};
	public static final String[] LBL_SUCCESS = {"//span[@class='alert-content' and contains(.,'Successful')]","Change password Success"};
}

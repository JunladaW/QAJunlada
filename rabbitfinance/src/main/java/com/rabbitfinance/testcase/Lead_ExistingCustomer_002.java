package com.rabbitfinance.testcase;


import org.testng.annotations.Test;

import com.automation.framework.exception.BusinessException;
import com.rabbitbase.generic.BaseClass;
import com.rabbitfinance.testscript.CarInsurance;

public class Lead_ExistingCustomer_002 extends BaseClass {

	@Override
	protected String getConfigPath() throws BusinessException {
		return "framework";
	}
	
	@Override
	protected String getTestDataFile() throws BusinessException {
		return "Rabbit_Car_Insurance.xls";
	}
	
	@Test
	public void createLead_ExistingCustomer() throws Exception{
		setExcelRow(3);
		CarInsurance ci = new CarInsurance(testWareBean, test);
		ci.createLead();
		executeScript(ci);
	}
}

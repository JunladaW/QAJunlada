package com.rabbitfinance.testcase;


import org.testng.annotations.Test;

import com.automation.framework.exception.BusinessException;
import com.rabbitbase.generic.BaseClass;
import com.rabbitfinance.testscript.CarInsurance;

public class Lead_ChangeCar_004 extends BaseClass {

	@Override
	protected String getConfigPath() throws BusinessException {
		return "framework";
	}
	
	@Override
	protected String getTestDataFile() throws BusinessException {
		return "Rabbit_Car_Insurance.xls";
	}
	
	@Test(groups = {"TEST"})
	public void createLead() throws Exception{
		setExcelRow(5);
		CarInsurance ci = new CarInsurance(testWareBean, test);
		ci.validateCarInsurance();
		executeScript(ci);
	}
}

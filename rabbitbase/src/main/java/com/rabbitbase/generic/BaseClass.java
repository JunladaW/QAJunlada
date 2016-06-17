package com.rabbitbase.generic;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.automation.framework.exception.BusinessException;
import com.automation.framework.testcase.TestCase;

public class BaseClass extends TestCase {

	@Parameters({ "Browser" })
	@BeforeSuite()
	public void getBrowserName(@Optional("chrome") String browserName) {
		setBrowserName(browserName);
	}

	@Override
	protected String getConfigPath() throws BusinessException {
		return null;
	}

	@Override
	protected String getTestDataFile() throws BusinessException {
		return null;
	}
}

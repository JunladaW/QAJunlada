package com.rabbitnana.testscript;

import com.automation.framework.applib.FunctionsApplib;
import com.automation.framework.beans.TestWareBean;
import com.automation.framework.exception.BusinessException;
import com.automation.framework.util.Test;
import com.rabbitbase.constants.Project_Constants;
import com.rabbitbase.excelcolumns.XL_GenericSheets;
import com.rabbitnana.excelcolumns.XL_DataEntry;
import com.rabbitnana.objectrepository.OR_DataEntry;

public class DataEntry extends FunctionsApplib {

	public DataEntry(TestWareBean testWareBean, Test test) throws BusinessException {
		super(testWareBean, test);
	}

	@Override
	protected String getSheetName() {
		return XL_GenericSheets.SHEET_NANA_DATA_ENTRY;
	}

	public void dateEntry() throws BusinessException, InterruptedException {

		dataPackage();
		dataCoverage();
		dataTermsConditions();
		dataCarSumInsured();
		searchCars();
		test.script(CLICK_BUTTON, OR_DataEntry.BTN_SAVE_PACKAGE, "");
	}

	private void dataPackage() throws BusinessException, InterruptedException {
		test.script(TYPE, OR_DataEntry.TXT_PACKAGE_NAME, XL_DataEntry.PACKAGE_NAME);
		test.script(TYPE, OR_DataEntry.TXT_FILE_NAME, XL_DataEntry.FILE_NAME);
		test.script(CLICK_BUTTON, OR_DataEntry.TXT_EXPIRATION, "");
		test.script(SELECT_LIST, OR_DataEntry.WLS_INSURANCE_COMPANY, XL_DataEntry.INSURANCE_COMPANY);
		test.script(SELECT_LIST, OR_DataEntry.WLS_INSURANCE_TYPE, XL_DataEntry.INSURANCE_TYPE);
		test.script(SELECT_LIST, OR_DataEntry.WLS_OIC_CODE, XL_DataEntry.OIC_CODE);

		String getRepair = test.getData(XL_DataEntry.REPAIR);
		if (getRepair.equals("Garage")) {
			test.script(CLICK_BUTTON, OR_DataEntry.RDO_REPAIRER_GARAGE, "");
		} else {
			test.script(CLICK_BUTTON, OR_DataEntry.RDO_REPAIRER_DEALER, "");
		}

		String carModification = test.getData(XL_DataEntry.CAR_MODIFICATION_ACCEPTED);
		if (carModification.equals(Project_Constants.YES)) {
			test.script(CLICK_BUTTON, OR_DataEntry.RDO_MODIFICATION_YES, "");
		} else {
			test.script(CLICK_BUTTON, OR_DataEntry.RDO_MODIFICATION_NO, "");
		}

		String onlyFemale = test.getData(XL_DataEntry.FEMALE_ONLY);
		if (onlyFemale.equals(Project_Constants.YES)) {
			test.script(CLICK_BUTTON, OR_DataEntry.CKB_FEMALE_ONLY, "");
		}
	}

	private void dataCoverage() throws BusinessException, InterruptedException {

		test.script(CLEAR_TYPE, OR_DataEntry.TXT_LIABILITY_FOR_DAMAGE_PER_PERSON,
				XL_DataEntry.LIABILITY_DAMAGE_PER_PERSON);
		test.script(PRESENT, OR_DataEntry.TXT_LIABILITY_FOR_DAMAGE_PER_TIME, "");
		test.script(CLEAR_TYPE, OR_DataEntry.TXT_LIABILITY_FOR_PROPERTY_DAMAGE, XL_DataEntry.LIABILITY_PROPERTY_DAMAGE);
		test.script(SELECT_LIST, OR_DataEntry.WLS_NO_OF_PERSONS_PA, XL_DataEntry.NO_PERSONS_PA);
		test.script(SELECT_LIST, OR_DataEntry.WLS_NO_OF_PERSONS_ME, XL_DataEntry.NO_PERSONS_ME);

		String getInsuranceType = test.getData(XL_DataEntry.INSURANCE_TYPE);
		String getPersonalAccident = test.getData(XL_DataEntry.PERSONAL_ACCIDENT);
		String getMedicalExpenses = test.getData(XL_DataEntry.MEDICAL_EXPENSES);
		String getBailBond = test.getData(XL_DataEntry.BAIL_BOND);

		/* When insurance type 3 & 3+, PA, ME and Bail Bond amount can be 0 */
		if (getInsuranceType.equals("Type 3") || getInsuranceType.equals("Type 3+")) {
			if (!getPersonalAccident.equals("0")) {
				test.script(CLEAR_TYPE, OR_DataEntry.TXT_PERSONAL_ACCIDENT, XL_DataEntry.PERSONAL_ACCIDENT);
			}
			if (!getMedicalExpenses.equals("0")) {
				test.script(CLEAR_TYPE, OR_DataEntry.TXT_MEDICAL_EXPENSES, XL_DataEntry.MEDICAL_EXPENSES);
			}
			if (!getBailBond.equals("0")) {
				test.script(CLEAR_TYPE, OR_DataEntry.TXT_BAIL_BOND, XL_DataEntry.BAIL_BOND);
			}
		} else {
			test.script(CLEAR_TYPE, OR_DataEntry.TXT_PERSONAL_ACCIDENT, XL_DataEntry.PERSONAL_ACCIDENT);
			test.script(CLEAR_TYPE, OR_DataEntry.TXT_MEDICAL_EXPENSES, XL_DataEntry.MEDICAL_EXPENSES);
			test.script(CLEAR_TYPE, OR_DataEntry.TXT_BAIL_BOND, XL_DataEntry.BAIL_BOND);
		}
	}

	private void dataTermsConditions() throws BusinessException, InterruptedException {

		String thTermsConditions = test.getData(XL_DataEntry.TERMS_CONDITIONS_TH);
		String enTermsConditions = test.getData(XL_DataEntry.TERMS_CONDITIONS_EN);

		if (!thTermsConditions.isEmpty()) {
			test.script(TYPE, OR_DataEntry.TXT_TERMS_CONDITIONS_TH, XL_DataEntry.TERMS_CONDITIONS_TH);
		}
		if (!enTermsConditions.isEmpty()) {
			test.script(TYPE, OR_DataEntry.TXT_TERMS_CONDITIONS_EN, XL_DataEntry.TERMS_CONDITIONS_EN);
		}
		test.script(CLICK_BUTTON, OR_DataEntry.BTN_PROVINCES_SELECT_ALL, "");

	}

	private void dataCarSumInsured() throws BusinessException, InterruptedException {

		test.script(SELECT_LIST, OR_DataEntry.WLS_CAR_AGE_MIN, XL_DataEntry.CAR_AGE_MIN);
		test.script(SELECT_LIST, OR_DataEntry.WLS_CAR_AGE_MAX, XL_DataEntry.CAR_AGE_MAX);
		test.script(CLEAR_TYPE, OR_DataEntry.TXT_SUM_INSURED_MIN, XL_DataEntry.SUM_INSURED_MIN);
		test.script(CLEAR_TYPE, OR_DataEntry.TXT_SUM_INSURED_MAX, XL_DataEntry.SUM_INSURED_MAX);

		String getSingleFixedPremium = test.getData(XL_DataEntry.SINGLE_RATE_FIXED_PREMIUM);
		if (getSingleFixedPremium.equals(Project_Constants.NO)) {
			test.script(CLICK_BUTTON, OR_DataEntry.RDO_SINGLE_RATE_FIXED_PREMIUM_NO, "");
		} else {
			test.script(CLICK_BUTTON, OR_DataEntry.RDO_SINGLE_RATE_FIXED_PREMIUM_YES, "");
		}

		String getTheftFireCoverage = test.getData(XL_DataEntry.THEFT_FIRE_COVERAGE);
		if (getTheftFireCoverage.equals(Project_Constants.YES)) {
			test.script(CLICK_BUTTON, OR_DataEntry.RDO_THEFT_FIRE_COVERAGE_YES, "");
		} else {
			test.script(CLICK_BUTTON, OR_DataEntry.RDO_THEFT_FIRE_COVERAGE_NO, "");
		}

		String getFloodCoverage = test.getData(XL_DataEntry.FLOOD_COVERAGE);
		if (getFloodCoverage.equals(Project_Constants.YES)) {
			test.script(CLICK_BUTTON, OR_DataEntry.RDO_FLOOD_COVERAGE_YES, "");
		} else {
			test.script(CLICK_BUTTON, OR_DataEntry.RDO_FLOOD_COVERAGE_NO, "");
		}
	}

	private void searchCars() throws BusinessException, InterruptedException {
		String searchBy = test.getData(XL_DataEntry.SEARCH_CARS);
		if (searchBy.equalsIgnoreCase("car model")) {
			test.script(CLICK_BUTTON, OR_DataEntry.BTN_CAR_MODEL, "");
			test.script(TYPE, OR_DataEntry.TXT_CAR_MODEL_SEARCH, XL_DataEntry.CAR_MODEL_SEARCH);
		} else {
			test.script(CLICK_BUTTON, OR_DataEntry.BTN_CAR_GROUP, "");
			test.script(SELECT_LIST, OR_DataEntry.WLS_CAR_GROUP, XL_DataEntry.CAR_GROUP);
		}

		String getEngineSize = test.getData(XL_DataEntry.ENGINE_SIZE);
		if (!getEngineSize.isEmpty()) {
			test.script(SELECT_LIST, OR_DataEntry.WLS_ENGINE_SIZE, XL_DataEntry.ENGINE_SIZE);
		}

		/* Get Total Car List */
		int getCarSearchList = test.getCount(OR_DataEntry.TOTAL_CAR_LIST);
		for (int carList = 1; carList <= getCarSearchList; carList++) {
			String[] replaceXpathCarList = test.replaceXpath(OR_DataEntry.BTN_ADD_CARS, carList);
			test.script(CLICK_BUTTON, replaceXpathCarList, "");
			if (carList > 5) {
				break;
			}
		}
	}

}

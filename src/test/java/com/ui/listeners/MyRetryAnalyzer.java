package com.ui.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.constants.Env;
import com.utility.JSONUtitlity;
import com.utility.PropertiesUtil;

public class MyRetryAnalyzer implements IRetryAnalyzer {
//	private static final int MAX_NUMBER_OF_ATTEMPTS = Integer.parseInt(PropertiesUtil.readProperties(Env.DEV, "MAX_NUMBER_OF_ATTEMPTS"));
	private static final int MAX_NUMBER_OF_ATTEMPTS = JSONUtitlity.readJSON(Env.QA).getMAX_NUMBER_OF_ATTEMPTS();
	private static int currentAttempt=1;

	@Override
	public boolean retry(ITestResult result) {
		if(currentAttempt <=MAX_NUMBER_OF_ATTEMPTS){
			currentAttempt++;
			return true;
		}
		return false;
	}

}

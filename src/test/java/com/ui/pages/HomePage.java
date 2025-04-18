package com.ui.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.constants.Browser;
import com.constants.Env;
import com.utility.BrowserUtility;
import com.utility.JSONUtitlity;
import com.utility.LoggerUtility;


public final class HomePage extends BrowserUtility {
	Logger logger=LoggerUtility.getLogger(this.getClass());

	private static final By SIGN_IN_LINK_LOCATOR = By.xpath("//a[contains(text(), 'Sign in')]");
	
			
	public HomePage(Browser browserName, boolean isHeadless) {
		super(browserName,isHeadless);
		Env QA=null;
		Env DEV=null;
		Env UAT = null;
		goToWebsite(JSONUtitlity.readJSON(QA).getUrl());
	}
	
	public HomePage(WebDriver driver) {
		super(driver);
		Env QA=null;
		Env DEV=null;
		Env UAT = null;
		goToWebsite(JSONUtitlity.readJSON(QA).getUrl());
		
	}
	
	

	public LoginPage goToLoginPage() {
		logger.info("Trying to performing click to go Sing in Page");
		clickOn(SIGN_IN_LINK_LOCATOR);
		LoginPage loginPage= new LoginPage(getDriver());
		return loginPage;
		
	}

		
}

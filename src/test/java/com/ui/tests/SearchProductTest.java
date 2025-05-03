package com.ui.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ui.pages.MyAccountPage;

public class SearchProductTest extends TestBase {
	
	private MyAccountPage myAccountPage;
	private static final String SEARCH_TERM="Printed Summer Dress";
	
	@BeforeMethod(description = "Valid user logs into the application ")
	public void setUp() {
		myAccountPage = homePage.goToLoginPage().doLoginWith("keyword1623@skylersclass.live", "password");
	}
	
	@Test(description = "Verify if the logged in user is able to search for a product and correct products search result are displayed",
			groups = {"e2e", "smoke","sanity"}
			)
	public void verifyProductSearchTest() {
		boolean actualResult = myAccountPage.searchForProduct(SEARCH_TERM)
				.isSearchTermPresentInProductList(SEARCH_TERM);
		Assert.assertEquals(actualResult, true);
	}

}

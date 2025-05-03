package com.ui.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ui.pages.AddressPage;
import com.ui.pages.MyAccountPage;
import com.ui.pojo.AddressPOJO;
import com.utility.FakeAddressUtility;

public class AddNewFirstAddressTest extends TestBase {
	
	private MyAccountPage myAccountPage;
	private AddressPOJO addressPojo;
	
	@BeforeMethod(description = "Valid first time user logs into the application ")
	public void setUp() {
		myAccountPage = homePage.goToLoginPage().doLoginWith("jifeli3221@bariswc.com", "radha123");
		addressPojo = FakeAddressUtility.getFakeAddress();
	
	
	}
	@Test
	public void addNewAddress() {
		String newAddress=myAccountPage.goToAddAddressPage().saveAddress(addressPojo);
		Assert.assertEquals(newAddress, addressPojo.getAdressAlias().toUpperCase());
	}

}

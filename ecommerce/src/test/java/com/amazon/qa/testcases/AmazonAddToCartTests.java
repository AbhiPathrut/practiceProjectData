package com.amazon.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.amazon.qa.base.TestBase;
import com.amazon.qa.pages.HomePage;

public class AmazonAddToCartTests extends TestBase {
	HomePage homepage;

	public AmazonAddToCartTests() {
		super();
	}

	@Parameters({ "Browser", "Url" })
	@BeforeMethod
	public void setUp(String browser, String url) throws Exception {
		initialization(browser, url);
		homepage = new HomePage();
	}

	@Parameters({"productName"})
	@Test(priority = 1)
	public void verifyAddToCartForOrderProcess(String ProductName) throws Exception {
		homepage.validateTheTitleOfPageLanded();
		homepage.logoIsDisplayed();
		homepage.eneterProductName(ProductName);
		homepage.clickOnSearchButton();
		homepage.selectProductFromResultsShown(2);
		homepage.swicthToWindowByTitle();
		homepage.clickOnAddToCartButton();
		homepage.clickOnCartButton();
		homepage.verifySubTotalAmtIsEqualToPriceOfAllProductsInCart();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
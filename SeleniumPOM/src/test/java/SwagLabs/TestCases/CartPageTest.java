package SwagLabs.TestCases;

import org.testng.Assert;
import org.testng.annotations.*;

import SwagLabs.Base.BaseClass;
import SwagLabs.Pages.CartPage;
import SwagLabs.Pages.HomePage;
import SwagLabs.Pages.LoginPage;

public class CartPageTest extends BaseClass{
	
	
	LoginPage loginPage;
	HomePage homePage;
	CartPage cartPage;
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		homePage = new HomePage();
		homePage.ClickAddToCart();
		cartPage = new CartPage();
		
	}
	
	@Test(priority=1)
	public void verifyYourCartTitleTest() {
		boolean TitleDisplayed = cartPage.VerifyYourCartTitle();
		Assert.assertTrue(TitleDisplayed);
		
	}
	
	@Test(priority=2)
	public void verifyBackpackNameTest() {
		String name = cartPage.VerifyBackpackName();
		Assert.assertEquals(name, "Sauce Labs Backpack");
		
	}
	
	@Test(priority=3)
	public void verifyBackpackDescriptionTest() {
		String description = cartPage.VerifyBackpackDescription();
		Assert.assertEquals(description, "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.");
		
	}

	@Test(priority=4)
	public void verifyBackpackPriceTest() {
		String price = cartPage.VerifyBackpackPrice();
		Assert.assertEquals(price, "$29.99");
		
	}

	@Test(priority=5)
	public void clickCheckoutButtonTest() {
		cartPage.ClickCheckoutButton();
		
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
		
		
	
	
	
	
	
	
	
	}
}

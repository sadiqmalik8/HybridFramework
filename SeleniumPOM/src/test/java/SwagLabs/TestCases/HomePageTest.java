package SwagLabs.TestCases;

import org.testng.Assert;
import org.testng.annotations.*;


import SwagLabs.Base.BaseClass;
import SwagLabs.Pages.HomePage;
import SwagLabs.Pages.LoginPage;


public class HomePageTest extends BaseClass{
	
	HomePage homePage;
	LoginPage loginPage;
	
	// Constructor to initialize the BaseClass
	public HomePageTest() {
		super();
	}
	
	
	@BeforeMethod
	public void setUp() {
		initialization();
		
		loginPage = new LoginPage();
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		homePage = new HomePage();
	
	}
	
	@Test(priority=1)
	public void verifyHomePageTitleTest() throws InterruptedException {
		String title = homePage.VerifyHomePageTitle();
		Assert.assertEquals(title, "Swag Labs");
		Thread.sleep(5000);
	}
	
	@Test(priority=2)
	public void verifyBackpackImageTest() throws InterruptedException {
		driver.switchTo().alert().accept();
		boolean imageDisplayed = homePage.VerifyBackpackImage();
		Assert.assertTrue(imageDisplayed);
		Thread.sleep(5000);
	}
	
	@Test(priority=3)
	public void verifyBackpackPriceTextTest() {
		String priceText = homePage.VerifyBackpackPriceText();
		Assert.assertEquals(priceText, "$29.99", "Price text is not matching");
		
	}
	
	@Test(priority=4)
	public void clickAddToCartTest() {
		homePage.ClickAddToCart();
		
	}
	
	@Test(priority=5)
	public void clickCartIconTest() {
		homePage.ClickCartIcon();
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/cart.html", "URL is not matching");
	}
		
		
	@AfterMethod
	public void tearDown() {
		driver.quit();
		
	

	
	
	
	}}


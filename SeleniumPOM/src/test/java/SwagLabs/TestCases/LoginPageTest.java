package SwagLabs.TestCases;


import org.testng.Assert;
import org.testng.annotations.*;

import SwagLabs.Base.BaseClass;
import SwagLabs.Pages.HomePage;
import SwagLabs.Pages.LoginPage;

public class LoginPageTest extends BaseClass {
	LoginPage loginPage;  // Instance of the LoginPage class
	HomePage homePage;  // Instance of the HomePage class
	
	
	
	
	// Test class for the LoginPage
	public LoginPageTest() {
		super();  // Calls the constructor of the BaseClass to load properties
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();  // Initializes the WebDriver and opens the browser
	
		loginPage = new LoginPage(); 
	}
	
	
	
	
	
	
	@Test(priority=1)
	public void LoginPageTitleTest() {
		String title = loginPage.validateLoginPageTitle();  // Gets the title of the login page
		Assert.assertEquals(title, "Swag Labs");  // Asserts that the title is "Swag Labs"
		System.out.println(title);  // Prints the title
	}
	
	@Test(priority=2)
	public void SwagLabsLogoTest() {
		boolean logo = loginPage.validateSwagLabsLogo();  // Checks if the Swag Labs logo is displayed
		Assert.assertTrue(logo);  // Asserts that the logo is displayed
	}
	
	@Test(priority=3)
	public void LoginTest() {
		homePage= loginPage.login(prop.getProperty("username"), prop.getProperty("password"));  // Logs in with the username and password from properties file
	}
	
	
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();  // Closes the browser
	}
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
}

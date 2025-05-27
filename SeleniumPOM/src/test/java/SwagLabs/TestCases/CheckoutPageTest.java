package SwagLabs.TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.*;

import SwagLabs.Base.BaseClass;
import SwagLabs.Pages.CartPage;
import SwagLabs.Pages.CheckoutPage;
import SwagLabs.Pages.HomePage;
import SwagLabs.Pages.LoginPage;
import SwagLabs.Utility.UtilityClass;


public class CheckoutPageTest extends BaseClass {
	
	
	String sheetName = "ContactDetails"; // Name of the sheet in the Excel file containing contact details
	String filePath = "C:\\Users\\Sadiq\\Desktop\\Automation\\SeleniumPOM\\src\\main\\java\\SwagLabs\\TestData\\SwagLabsTestData.xlsx"; // Path to the Excel file

	CheckoutPage checkoutPage;
	LoginPage loginPage;
	HomePage homePage;
	CartPage cartPage;
	
	public CheckoutPageTest() {
		super();  // Call the constructor of the BaseClass to initialize properties
	}
	

	@BeforeMethod
	public void setUp() {
		initialization();  // Initialize the WebDriver and open the browser
		checkoutPage = new CheckoutPage();  // Create an instance of CheckoutPage
		
		loginPage = new LoginPage();  // Create an instance of LoginPage
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));  // Log in using credentials from properties file
		
		
		homePage = new HomePage();  // Create an instance of HomePage
		//homePage.ClickAddToCart(); // Click to add an item to the cart
		//homePage.ClickAddToCart();  // Click to add an item to the cart
		homePage.ClickCartIcon();  // Add an item to the cart
		
		cartPage = new CartPage();  // Create an instance of CartPage
		cartPage.ClickCheckoutButton();  // Click the checkout button to proceed to the checkout page
		
		
	}
		
	
	@Test(priority=1)
	public void verifyCheckoutPageTitleTest() {
		String title = checkoutPage.verifyCheckoutPageTitle();  // Get the title of the checkout page
		Assert.assertEquals(title, "Swag Labs");  // Assert that the title matches the expected value
	}
	
	
	@Test(priority=2)
	public void CheckoutPageHeaderTest() {
		String header = checkoutPage.verifyCheckoutPageHeader();  // Get the header text of the checkout page
		Assert.assertEquals(header, "Checkout: Your Information");  // Assert that the header matches the expected value
	}
	
	@DataProvider(name = "EnterTestData")
	public String[][] getTestData() throws IOException {
		UtilityClass utility = new UtilityClass();  // Create an instance of UtilityClass
		return utility.getTableArray(filePath, sheetName);  // Read data from the specified Excel file and sheet
	}
	

	@Test(priority=3, dataProvider = "EnterTestData")
	public void ContactDetailsTest(String firstName, String lastName, String postalCode) throws InterruptedException {
		//driver.switchTo().alert().accept();  // Accept any alert that may appear
		checkoutPage.EnterContactDetails(firstName, lastName, postalCode);  
	}
	
	
	@Test(priority=4)
	public void clickContinueButtonTest() {
		checkoutPage.clickContinue();  // Click the continue button 
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();  // Close the browser 
	}
		
		
		 
	
	
	
	
	
	
	
	
	
	
	
	
}

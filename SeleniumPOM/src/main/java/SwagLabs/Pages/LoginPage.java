package SwagLabs.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SwagLabs.Base.BaseClass;

public class LoginPage extends BaseClass{
	
	// Page Factory - OR(Object Repository)
	@FindBy(id = "user-name")
	WebElement username;  // WebElement for username input field
	
	@FindBy(id = "password")
	WebElement password;  // WebElement for password input field
	
	@FindBy(xpath = "//input[@id='login-button']")
	WebElement loginButton;  // WebElement for login button

	@FindBy(xpath = "//div[contains(text(),'Swag Labs')]")
	WebElement swagLabsLogo;  // WebElement for Swag Labs logo
	
	
	// Constructor to initialize the PageFactory elements
	public LoginPage() {
		PageFactory.initElements(driver, this);
	
	}
	
	// Actions
	public String validateLoginPageTitle() {
		return driver.getTitle();  // Returns the title of the current page
	}
	
	public boolean validateSwagLabsLogo() {
		return swagLabsLogo.isDisplayed();  // Returns true if the Swag Labs logo is displayed
	}
	
	
	public HomePage login(String un, String pwd) {
		username.clear();  // Clears the username input field
		username.sendKeys(un);  // Sends the username to the input field
		password.sendKeys(pwd);  // Sends the password to the input field
		loginButton.click();  // Clicks the login button
		
		return new HomePage();  // Returns an instance of the HomePage class
	}
	
	
}

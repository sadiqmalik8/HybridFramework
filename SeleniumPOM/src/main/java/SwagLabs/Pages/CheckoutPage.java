package SwagLabs.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SwagLabs.Base.BaseClass;

public class CheckoutPage extends BaseClass{
	
	//Page Factory - Object Repository (OR)
	
	@FindBy(xpath = "//span[contains(text(),'Checkout: Your Information')]")
	WebElement checkoutPageHeader;  // WebElement for the header of the checkout page
	
	@FindBy(id = "first-name")
	WebElement firstNameField;
	
	@FindBy(id = "last-name")
	WebElement lastNameField;
	
	@FindBy(id = "postal-code")
	WebElement postalCodeField;
	
	@FindBy(id = "continue")
	WebElement continueButton;
	
	
	// Constructor to initialize the PageFactory elements
	public CheckoutPage() {
		PageFactory.initElements(driver, this);
		}

	
	// Actions
	
	public String verifyCheckoutPageTitle() {
		return driver.getTitle();  // Returns the title of the current page
		
	}
	
	public String verifyCheckoutPageHeader() {
		return checkoutPageHeader.getText();  // Returns the text of the checkout page header
	
	}
				
	
	
	public void EnterContactDetails(String firstName, String lastName, String postalCode) {
		firstNameField.sendKeys(firstName); // Enter first name in the input field
		lastNameField.sendKeys(lastName);  // Enter last name in the input field
		postalCodeField.sendKeys(postalCode); // Enter postal code in the input field
	}
	

	public void clickContinue() {
		continueButton.click();  // Click the continue button
	}
	
	
}


	
	
	

	
	



package SwagLabs.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SwagLabs.Base.BaseClass;

public class CartPage extends BaseClass {
	
	// Page Factory - OR(Object Repository)
	@FindBy(xpath = "//span[contains(text(),'Your Cart')]")
	WebElement YourCartTitle;
	
	@FindBy(xpath = "//div[contains(text(),'Sauce Labs Backpack')]")
	WebElement BackpackName;
	
	@FindBy(xpath = "//div[contains(text(),'carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.')]")
	WebElement BackpackDescription;
	
	@FindBy(xpath = "//div[@class='inventory_item_price']")
	WebElement BackpackPrice;
	
	@FindBy(xpath = "//button[@id='checkout']")
	WebElement CheckoutButton;
	
	// Constructor to initialize the PageFactory elements
	public CartPage() {
		PageFactory.initElements(driver, this);
		
	}
	
	// Actions
	public boolean VerifyYourCartTitle() {
		return YourCartTitle.isDisplayed();
		
	}
	
	public String VerifyBackpackName() {
		return BackpackName.getText();
		
	}
	
	public String VerifyBackpackDescription() {
		return BackpackDescription.getText();
		
	}
	
	public String VerifyBackpackPrice() {
		return BackpackPrice.getText();
		
	}
	
	public CheckoutPage ClickCheckoutButton() {
		CheckoutButton.click();
		return new CheckoutPage();
		
	}
	
	
	

}

package SwagLabs.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



import SwagLabs.Base.BaseClass;

public class HomePage extends BaseClass{
	
	
	// Page Factory - OR(Object Repository)
	@FindBy(xpath = "//title[contains(text(),'Swag Labs')]")
	WebElement HomepageTitle;
	
	@FindBy(xpath = "//img[@alt='Sauce Labs Backpack']")
	WebElement backpackImage;
	
	@FindBy(xpath = "(//div[contains(text(),'$')])[1]")
	WebElement backpackPrice;

	@FindBy(id= "add-to-cart-sauce-labs-backpack")
	WebElement AddToCart;
	
	@FindBy(xpath = "//a[@class='shopping_cart_link']")
	WebElement CartIcon;
	
	// Constructor to initialize the PageFactory elementss
	public HomePage() {
		PageFactory.initElements(driver, this);
		
	}
	
	// Actions
	public String VerifyHomePageTitle() {
		return driver.getTitle();
		
	}
	
	public boolean VerifyBackpackImage() {
		return backpackImage.isDisplayed();
		
	}
	
	public String VerifyBackpackPriceText() {
		return backpackPrice.getText();
	}
	
	
	public void ClickAddToCart() {
		AddToCart.click();
		
	}
	
	public CartPage ClickCartIcon() {
		CartIcon.click();
		return new CartPage();
		
	}
	
	
	
	
	
	
	
	
	
	
}

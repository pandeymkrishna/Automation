package com.app.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartSummaryPage {
	
	WebDriver driver; 
	
	@FindBy(linkText="Proceed to checkout")
	WebElement btnProceedToCheckout;
	
	public ShoppingCartSummaryPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickBtnProceedToCheckout(){
		btnProceedToCheckout.click();
	}
	
	

}

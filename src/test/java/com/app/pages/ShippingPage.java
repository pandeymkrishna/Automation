package com.app.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShippingPage {
	

	WebDriver driver;
	
	@FindBy(name="processCarrier")
	WebElement btnProceedToCheckout;
	
	@FindBy(id="cgv")
	WebElement termsAndCondition;
	
	
	public ShippingPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickbtnProceedToCheckout(){
		btnProceedToCheckout.click();
	}
	
	public void acceptTermsAndCondition(){
		termsAndCondition.click();
	}
}

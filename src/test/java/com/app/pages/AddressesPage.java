package com.app.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddressesPage {
	WebDriver driver;
	
	@FindBy(name="processAddress")
	WebElement btnProceedToCheckout;
	
	public AddressesPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickbtnProceedToCheckout(){
		btnProceedToCheckout.click();
	}
}

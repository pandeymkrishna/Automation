package com.app.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductAdditionModalWindow {
	
	WebDriver driver;
	
	@FindBy(xpath="//*[@id='layer_cart']//h2/i[@class='icon-ok']/..")
	WebElement message;
	
	@FindBy(linkText="Proceed to checkout")
	WebElement btnProceedToCheckout;
	
	public ProductAdditionModalWindow(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickBtnProceedToCheckout(){
		btnProceedToCheckout.click();
	}
	

}

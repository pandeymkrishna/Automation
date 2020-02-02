package com.app.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage {
	
	WebDriver driver;
	
	@FindBy(partialLinkText="Pay by bank wire")
	WebElement payByBankWire;
	
	public PaymentPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void selectPayByBankWire(){
		payByBankWire.click();
		
	}

}

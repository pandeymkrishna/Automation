package com.app.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BannerPage {
	
	WebDriver driver;
	//a[@title='View my customer account']
	@FindBy(className="account")
	WebElement customerAccount;
	
	@FindBy(className="login")
	WebElement signIn;
	
	public BannerPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void openCustomerAccount(){
		customerAccount.click();
	}
	
	public void clickSignIn(){
		signIn.click();
	}
	
	
}

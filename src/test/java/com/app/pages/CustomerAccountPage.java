package com.app.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CustomerAccountPage {
	
	WebDriver driver;
	//a[@title='View my customer account']
	@FindBy(xpath="//a[@title='Orders']")
	WebElement orderHistory;
	
	@FindBy(xpath="//a[@title='Information']")
	WebElement personalInformation;
	
	@FindBy(className="page-heading")
	WebElement pageHeading;
	
	public CustomerAccountPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void openOrderHistory(){
		orderHistory.click();
		
	}
	
	public void openPersonalInformation(){
		personalInformation.click();
	}
	
	public void verifyPage(){
		Assert.assertEquals(pageHeading.getText(),"MY ACCOUNT", "Page heading not matching");
	}
	
}


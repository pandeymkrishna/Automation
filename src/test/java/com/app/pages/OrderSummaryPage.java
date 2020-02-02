package com.app.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderSummaryPage {
	
	WebDriver driver;
	
	@FindBy(xpath="//form/p[@id='cart_navigation']/button[@type='submit']")
	WebElement confirmOrder;
	
	public OrderSummaryPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickConfirmOrder(){
		confirmOrder.click();
	}
}

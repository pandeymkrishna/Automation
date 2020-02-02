package com.app.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderHistoryPage {
	WebDriver driver;
	
	@FindBy(xpath="//div[@class='box']/p/strong")
	WebElement verifyOrderCompleteText;
	
	@FindBy(xpath="//div[@class='box']")
	WebElement confirmationMessage;
	
	public OrderHistoryPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public boolean verifyReferenceString(String ref){
		
		try{
			driver.findElement(By.linkText(ref)).click();
			return true;
		}catch(Exception e){
			return false;
		}

		
	}
	
}

package com.app.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderConfirmationPage {
	
	WebDriver driver;
	
	@FindBy(xpath="//div[@class='box']")
	WebElement OrderCompleteText;
	
	@FindBy(xpath="//div[@class='box']/p/strong")
	WebElement confirmationMessage;
	
	public OrderConfirmationPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getCompleteText(){
		//System.out.println(OrderCompleteText.getText());
		return OrderCompleteText.getText();
	}
	
	public String getConfirmationMessage(){
		System.out.println(confirmationMessage.getText());
		return confirmationMessage.getText();
	}
}

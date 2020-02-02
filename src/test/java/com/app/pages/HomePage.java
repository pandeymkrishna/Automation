package com.app.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
	
	@FindBy(xpath="//div[@id='block_top_menu']/ul/li/a[text()='T-shirts']")
	WebElement linkTshirts;
	
	public HomePage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickTshirts(){
		linkTshirts.click();
	}

}

package com.app.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	@FindBy(id="email")
	WebElement loginID;
	
	@FindBy(id="passwd")
	WebElement password;
	
	@FindBy(id="SubmitLogin")
	WebElement submitLogin;
	
	
	public LoginPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void setUserName(String userName){
		loginID.sendKeys(userName);
	}
	
	public void setPassword(String pwd){
		password.sendKeys(pwd);
	}
	
	public void completeLogin(String userName, String pwd){
		setUserName(userName);
		setPassword(pwd);
		submitLogin.click();
	}
	
	
}

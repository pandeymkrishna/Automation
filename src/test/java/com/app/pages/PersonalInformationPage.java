package com.app.pages;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class PersonalInformationPage {
	
	WebDriver driver;
	
	@FindBy(id="firstname")
	WebElement firstName;
	
	@FindBy(id="old_passwd")
	WebElement oldPassword;
	
	@FindBy(name="submitIdentity")
	WebElement save;
	
	@FindBy(className="page-subheading")
	WebElement pageHeading;
	
	@FindBy(xpath="//p[@class='alert alert-success']")
	WebElement successMessage;
	
	public PersonalInformationPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
		
	public void setFirstName(String fName){
		String existingName = firstName.getAttribute("value");
		firstName.clear();
		firstName.sendKeys(fName);
		Reporter.log("Existing name: "+ existingName+"  First Name set as: "+ fName);
	}
	
	public void setOldPassword(String pwd){
		oldPassword.clear();
		oldPassword.sendKeys(pwd);
	}
	
	public void save(){
		save.click();
		Reporter.log("Clicked save");
	}
	
	
	public void verifySuccessMessage(){
		String text = successMessage.getText();
		Assert.assertEquals(text, "Your personal information has been successfully updated.");
		System.out.println(text);
	}
	
	public void verifyPageHeading(){
		Assert.assertEquals(pageHeading.getText(), "YOUR PERSONAL INFORMATION");
		Reporter.log("YOUR PERSONAL INFORMATION Page loaded");
	}
}

package com.app.test;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.app.data.DataUtils;
import com.app.pages.BannerPage;
import com.app.pages.CustomerAccountPage;
import com.app.pages.HomePage;
import com.app.pages.LoginPage;
import com.app.pages.PersonalInformationPage;

public class PersonInfo {
	
	    
    WebDriver driver;

    HomePage homePage;
    
    LoginPage loginPage;
   
    BannerPage banner;
    CustomerAccountPage custAccount;
    
    PersonalInformationPage persInfo;
    
    
	@BeforeTest

    public void setup(){

        try {
			System.setProperty("webdriver.chrome.driver", DataUtils.getChromeDriverPath());
		} catch (IOException e) {
			
			e.printStackTrace();
		}
        
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //driver.manage().window().maximize(); 
        driver.get("http://automationpractice.com/index.php");

    }
	
	
	@Test(dataProvider="ModifyPersonInfoData", dataProviderClass = DataUtils.class )
	public void testPersonalInfoModification(Map<String, String> map){
		
		banner = new BannerPage(driver);
		loginPage = new LoginPage(driver);
		custAccount = new CustomerAccountPage(driver);
		persInfo = new PersonalInformationPage(driver);
		
		banner.clickSignIn();
		loginPage.completeLogin(map.get("UserName"), map.get("Password"));
		
		custAccount.verifyPage();
		custAccount.openPersonalInformation();
		
		persInfo.verifyPageHeading();
		persInfo.setFirstName(map.get("NewFirstName"));
		persInfo.setOldPassword(map.get("Password"));
		persInfo.save();
		persInfo.verifySuccessMessage();
		
		 
	}
	
	
	

}

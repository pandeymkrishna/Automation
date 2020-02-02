package com.app.test;



import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.app.data.DataUtils;
import com.app.pages.AddressesPage;
import com.app.pages.BannerPage;
import com.app.pages.CustomerAccountPage;
import com.app.pages.HomePage;
import com.app.pages.LoginPage;
import com.app.pages.OrderConfirmationPage;
import com.app.pages.OrderHistoryPage;
import com.app.pages.OrderSummaryPage;
import com.app.pages.PaymentPage;
import com.app.pages.ProductAdditionModalWindow;
import com.app.pages.ProductPage;
import com.app.pages.ShippingPage;
import com.app.pages.ShoppingCartSummaryPage;
import com.app.pages.TshirtsPage;

public class TestOrder {
	
	
	   
    WebDriver driver;

    HomePage homePage;
    TshirtsPage tShirtsPage;
    ProductAdditionModalWindow modalWindow;
    ShoppingCartSummaryPage shoppingCartSummary;
    LoginPage loginPage;
    ProductPage productPage;
    AddressesPage addressPage;
    ShippingPage shippingPage;
    PaymentPage paymentPage;
    OrderSummaryPage orderSummaryPage;
    OrderConfirmationPage orderConfirmPage;
    BannerPage banner;
    CustomerAccountPage custAccount;
    OrderHistoryPage orderHistory;
    
    
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
	@Test(dataProvider="orderTshirtsData", dataProviderClass = DataUtils.class )
	public void testOrderTshirts(Map<String, String> map){
		
		System.out.println(map.get("UserName"));
		homePage = new HomePage(driver);
		
		modalWindow = new ProductAdditionModalWindow(driver);
		shoppingCartSummary = new ShoppingCartSummaryPage(driver);
		loginPage = new LoginPage(driver);
		productPage = new ProductPage(driver);
		addressPage = new AddressesPage(driver);
		shippingPage = new ShippingPage(driver);
		paymentPage = new PaymentPage(driver);
		orderSummaryPage = new OrderSummaryPage(driver);
		orderConfirmPage = new OrderConfirmationPage(driver);
		banner = new BannerPage(driver);
		custAccount = new CustomerAccountPage(driver);
		orderHistory = new OrderHistoryPage(driver);
		
		
		homePage.clickTshirts();
		
		//driver.findElement(By.linkText("Faded Short Sleeve T-shirts")).click();
		
		tShirtsPage = new TshirtsPage(driver);
		tShirtsPage.selectItem(map.get("ItemName"));
		//tShirtsPage.addItemToCart("Faded Short Sleeve T-shirts");
		
		productPage.clickbtnAddToCart();
		modalWindow.clickBtnProceedToCheckout();
		shoppingCartSummary.clickBtnProceedToCheckout();
		
		loginPage.completeLogin(map.get("UserName"), map.get("Password"));
		
		addressPage.clickbtnProceedToCheckout();
		
		shippingPage.acceptTermsAndCondition();
		shippingPage.clickbtnProceedToCheckout();
		
		paymentPage.selectPayByBankWire();
		
		orderSummaryPage.clickConfirmOrder();
		
		
		
		String cText = orderConfirmPage.getCompleteText();
		String sHalf = cText.split("Do not forget to insert your order reference")[1];
		String ref = sHalf.split("in the subject of your bank wire")[0].trim();
		System.out.println(ref);
		
		
		banner.openCustomerAccount();
		custAccount.openOrderHistory();
		boolean res = orderHistory.verifyReferenceString(ref);
		System.out.println(res);
		
		Assert.assertEquals(true, res);
	}
	
	
	
}

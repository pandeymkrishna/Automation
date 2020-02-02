package com.app.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TshirtsPage {
	
	WebDriver driver;
	
	@FindBy(xpath="//*[@id='center_column']/h1[@class='page-heading product-listing']/span[@class='cat-name']")
	WebElement categoryTitle;
	
	@FindBy(className="product-container")
	WebElement productContainer;
	
	public TshirtsPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getCategoryTitle(){
		System.out.println(categoryTitle.getText());
		return categoryTitle.getText();
	}
	
	public void selectItem(String itemName){
		// //div[@class='product-container']//div[@class='right-block']/h5[@itemprop='name']/a[normalize-space(text())='Faded Short Sleeve T-shirts']
		productContainer.findElement(By.xpath("//div[@class='right-block']/h5[@itemprop='name']/a[normalize-space(text())='Faded Short Sleeve T-shirts']")).click();
		
		
		
	}
	
	public void addItemToCart(String itemName){
		//div[@class='product-container']//div[@class='right-block']/h5[@itemprop='name']/a[normalize-space(text())='Faded Short Sleeve T-shirts']//../..//following-sibling::div[@class='button-container']//span[text()='Add to cart']
		
		WebElement itemObj = driver.findElement(By.linkText(itemName));
		itemObj.findElement(By.xpath("//../..//following-sibling::div[@class='button-container']//span[text()='Add to cart']")).click();
	
		
	}
	
	
	
	
}

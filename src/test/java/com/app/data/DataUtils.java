package com.app.data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataUtils {
	
	
	@DataProvider
    public static Object[][] orderTshirtsData() 
    {
		Object[][] obj = new Object[1][1];
		HashMap<String, String> hmap = new HashMap<String, String>();
		hmap.put("ItemName", "Faded Short Sleeve T-shirts");
		hmap.put("UserName", "loginntest@g.com");
		hmap.put("Password", "Password123");
		
        obj[0][0]= hmap;
        
        return obj;
    }
	
	@DataProvider
    public static Object[][] ModifyPersonInfoData() 
    {
		Object[][] obj = new Object[1][1];
		HashMap<String, String> hmap = new HashMap<String, String>();
		hmap.put("NewFirstName", "Namename");
		hmap.put("UserName", "loginntest@g.com");
		hmap.put("Password", "Password123");
		
        obj[0][0]= hmap;
        
        return obj;
    }
	
	
	public static String getChromeDriverPath() throws IOException{
		Properties obj = new Properties(); 
		FileInputStream objfile = new FileInputStream(System.getProperty("user.dir")+"\\application.properties");
		obj.load(objfile);
		String path = System.getProperty("user.dir")+obj.getProperty("chromeDriverPath");
		return path;
	}
	
}
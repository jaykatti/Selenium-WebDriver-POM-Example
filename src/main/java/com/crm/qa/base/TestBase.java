package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.qa.util.Constants;

public class TestBase {
		
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase() {
		
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("C:\\Jay\\Projects\\Eclipse\\workspace\\FreeCRMTest"
					+ "\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
			prop.load(ip);
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void initialization() {
		
		String browserName = prop.getProperty("browser");
		//String driverPath = prop.getProperty("webdriver.chrome.driver");
				
		if (browserName.equals("chrome")) {
			//System.setProperty("webdriver.chrome.driver",driverPath);
			System.setProperty("webdriver.chrome.driver","C:\\Jay\\Projects\\Eclipse\\JARs\\Selenium\\chromedriver.exe");
			driver = new ChromeDriver();
			
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			
			driver.manage().timeouts().pageLoadTimeout(Constants.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT, TimeUnit.SECONDS);
			
			driver.get(prop.getProperty("url"));
		}
		
	}
	
	
	
	

}

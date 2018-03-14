package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		loginPage = new LoginPage();
		//System.out.println("Was in setup() method");
	}
	
	@Test(priority=1)
	public void loginPageTitleTest() {
		String pageTitle = loginPage.validateLoginPageTitle();
		//System.out.println("Title: 2 " + pageTitle);
		Assert.assertEquals(pageTitle, "#1 Free CRM for Any Business: Online Customer Relationship Software");
	}
	
	
	@Test(priority=2)
	public void crmLogoTest() {
		boolean logoTrue = loginPage.validateCrmLogo();
		Assert.assertTrue(logoTrue);
	}
	
	@Test(priority=3)
	public void loginTest() {
		homePage = loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
}

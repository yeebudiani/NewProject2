package com.myproject.testcases;

import java.time.Clock;
import java.time.Duration;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.myproject.pageobjects.LoginPage;

public class TC__LoginTest_001 extends BaseClass{
   
	
	@Test
	public void login() throws Exception
	{
		LoginPage lp=new LoginPage(driver);
		lp.username("admin@yourstore.com");
		logger.info("username entered");
		
		lp.pwd("admin");
		logger.info("password entered");
		lp.login();
		logger.info("clicked submit button");
		
		Thread.sleep(5000);
		
		if(driver.getTitle().equalsIgnoreCase("Dashboard / nopCommerce administration"))
		{
			Assert.assertTrue(true);
			logger.info("login is successful");
		}
		else
		{
			captureScreen(driver,"TC__LoginTest_001");
			Assert.fail();
			logger.info("login is failed");
		}
		lp.logout();
		
	}
	
	
	

}

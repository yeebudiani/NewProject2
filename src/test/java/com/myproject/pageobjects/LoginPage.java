package com.myproject.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	

	@FindBy(id="Email") 
	WebElement uname;
	
	@FindBy(id="Password") 
	WebElement password;
	
	@FindBy(xpath="//*[@class='button-1 login-button']")
	public 
	WebElement btnlogin;
	
	@FindBy(xpath="//*[@id=\"navbarText\"]/ul/li[3]/a") 
	WebElement logout;
	
	public void username(String usname)
	{
		uname.clear();
		uname.sendKeys(usname);
	}
	public void pwd(String pswd)
	{
		password.clear();
		password.sendKeys(pswd);
	}
	public void login()
	{
		btnlogin.click();
	}
	public void logout()
	{
		logout.click();
	}
}

package com.myproject.testcases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.myproject.utilities.ReadConfig;

public class BaseClass {
	  ReadConfig readconfig=new ReadConfig();
	  String baseurl=readconfig.getApplicationURL();
	  public static WebDriver driver;
	  public static Logger logger;   
		
		@BeforeClass
		@Parameters("browser")
		public void setup(String br)
		{
			System.out.println(br);
			logger=Logger.getLogger("myproject");
			PropertyConfigurator.configure("Log4j.properties"); 
			
			if(br.equals("chrome"))
			{
			System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());
			driver=new ChromeDriver();
			}
			else if(br.equals("firefox"))
			{
			System.setProperty("webdriver.gecko.driver", readconfig.getFirefoxPath());
			driver=new FirefoxDriver();
			}
			else if(br.equals("ie"))
			{
			System.setProperty("webdriver.ie.driver", readconfig.getIEPath());
			driver=new InternetExplorerDriver();
			}
			
			driver.get(baseurl);
			driver.manage().window().maximize();
			
			
		}
		
		@AfterClass
		public void close()
		{
			driver.quit();
		}
		
		public void captureScreen(WebDriver driver,String tname) throws Exception {
			TakesScreenshot ts=(TakesScreenshot) driver;
			File source=ts.getScreenshotAs(OutputType.FILE);
			File target=new File("C:/Users/DELL/eclipse-workspace/NewProject/Screenshots");
			FileUtils.copyFile(source, target);
			System.out.println("ScreenShots are taken");
		}

}

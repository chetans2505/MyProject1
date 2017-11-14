package com.pack1;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class BaseClass {
	protected WebDriver driver;
	protected ExtentReports report;
	public ExtentTest logger;
	
	@BeforeClass
	public void declare(){
		
		report=new ExtentReports("D:\\CSProject\\TestAutomation.html");		
		
		System.setProperty("webdriver.gecko.driver", "D:\\CSProject\\Myproject\\drivers\\geckodriver.exe");
		
	}
	
	
	@BeforeTest
	public void launchBrowser(){
		System.setProperty("webdriver.gecko.driver", "D:\\CS\\MyProject3\\drivers\\geckodriver.exe");
		System.out.println("Launching the browser");
		driver=new FirefoxDriver();
		
	}
	
	@AfterSuite
	public void closeBrowser() throws InterruptedException{
		//driver.close();
		System.out.println("closing the browser");
		System.out.println("Launching the reports file");
		//driver=new FirefoxDriver();
		driver.get("file:///D:/CSProject/TestAutomation.html");
		
		Thread.sleep(5000);
		report.endTest(logger);
		report.flush();
		driver.close();
		
	}
	/*@AfterClass
	public void launchReport(){
		
	}*/
	
	/*@AfterSuite
	public void showReports(){
		
	}
*/
}

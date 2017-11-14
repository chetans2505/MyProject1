package com.testng;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.pack1.BaseClass;
import com.pom.LoginPage;
import com.relevantcodes.extentreports.LogStatus;

public class Login extends BaseClass {
	
	

	
	@Test(priority=1)
	public void loginPage(){
		logger=report.startTest("verifyLogo");
		driver.get("https://www.gmail.com");
		logger.log(LogStatus.INFO, "Application is up and running");
		System.out.println("Application is up and running");
		LoginPage login=new LoginPage(driver);
		login.verifyLogo();
		logger.log(LogStatus.INFO, "Execution started");
		System.out.println("Execution started");
		
		logger.log(LogStatus.PASS, "title verified");
		
	 	
	}
	
	@Test(priority=2)
	public void loginPage1(){
		LoginPage login=new LoginPage(driver);
		login.verifySignInText();
		logger.log(LogStatus.INFO, "Execution started");
		System.out.println("Execution started");
		
		logger.log(LogStatus.PASS, "Sign In text verified");
		
	 	
	}
}

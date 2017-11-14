package com.testng;

import org.testng.annotations.Test;

import com.pack1.BaseClass;
import com.pom.LoginPage;
import com.relevantcodes.extentreports.LogStatus;

public class Login2 extends BaseClass {
	

	/*@Test(priority=1)
	public void launchApp(){
		logger=report.startTest("verify Signin text");
		driver.get("https://www.gmail.com");
		logger.log(LogStatus.INFO, "Application is up and running");
	}*/
	
	@Test
	public void loginPage1(){
		LoginPage login=new LoginPage(driver);
		login.verifySignInText();
		logger.log(LogStatus.INFO, "Execution started");
		System.out.println("Execution started");
		
		logger.log(LogStatus.PASS, "Sign In text verified");
		
	 	
	}

}

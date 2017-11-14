package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;



public class LoginPage  {
	
	@FindBy(xpath="//div[@class='gmail-nav__logo gmail-logo']")
	WebElement gmailLogo;
	
	@FindBy(xpath="//h1[@id='headingText']")
	WebElement signInText;
	
	
	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver,this);
	}
	public void verifyLogo(){
		
		Assert.assertTrue(gmailLogo.isDisplayed());
		
	}
	
	public void verifySignInText(){
		Assert.assertEquals(signInText.getText(), "Sign in");
	}

}

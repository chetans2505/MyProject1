package test1;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Loginpage extends BaseClass{
	
	

	ExtentReports report;
	ExtentTest logger;
	WebDriver driver;
	@BeforeMethod
	public void declare(){
		
		report=new ExtentReports("D:\\CSProject\\TestAutomation.html");		
		logger=report.startTest("verifyLoginpage");
		System.setProperty("webdriver.gecko.driver", "D:\\CSProject\\Myproject\\drivers\\geckodriver.exe");
		
	}
	
	
	@Test
	public void verifyLoginpage() throws IOException{
		driver=new FirefoxDriver();
		driver.get("https://www.gmail.com");
		logger.log(LogStatus.INFO, "Execution started");
		System.out.println("Execution started");
		
		logger.log(LogStatus.INFO, "Application is up and running");
		
		String title=driver.getTitle();
		Assert.assertTrue(title.contains("Gmail"));
		
		logger.log(LogStatus.PASS, "title verified");
		
	}
	@Test
	public void verifySignInText() throws IOException{	
		/*driver=new FirefoxDriver();
		driver.get("https://www.gmail.com");
		logger=report.startTest("verifySignInText");	*/	
		logger.log(LogStatus.INFO, "Execution started");
		System.out.println("test-2");
		//driver.get("https://www.gmail.com");
		logger.log(LogStatus.INFO, "Application is up and running");		
		String title=driver.findElement(By.xpath("//h1[@id='headingText']")).getText();
		Assert.assertTrue(title.contains("Signv in"));		
		logger.log(LogStatus.PASS, "title verified");
		
	}
	


	@AfterTest
	public void testFailure(ITestResult result) throws IOException
	{
		if(result.getStatus()==ITestResult.FAILURE){
			logger.log(LogStatus.FAIL, "Title is not as axpected");
			String screenShot_path=ScreenShot.captureScreenshot(driver, result.getName());
			String image=logger.addScreenCapture(screenShot_path);
			logger.log(LogStatus.FAIL, "Title verification",image);
			
		}
		report.endTest(logger);
		report.flush();
		driver.close();
		
		
		
		
	}
	
	
	

	@AfterTest
	public void launchReportURL(){
		System.setProperty("webdriver.chrome.driver", "D:\\CSProject\\Myproject\\drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///D:/CSProject/TestAutomation.html");
	}
}

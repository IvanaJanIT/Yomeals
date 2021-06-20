package tests;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import pages.AuthPage;
import pages.LocationPopupPage;
import pages.LoginPage;
import pages.NotificationSistemPage;
import pages.ProfilePage;


public abstract class BasicTest {

	protected WebDriver driver;
	protected JavascriptExecutor js;
	protected ProfilePage profilePage;
	protected LocationPopupPage locationPopupPage;
	protected LoginPage loginPage;
	protected NotificationSistemPage notificationSistemPage;
	protected AuthPage authPage;

	protected String baseUrl="http://demo.yo-meals.com";
	protected String email="customer@dummyid.com";
	protected String password="12345678a";
	

	@BeforeMethod
	public void setup() {

		System.setProperty("webdriver.chrome.driver", "driver-lib/chromedriver");

		driver = new ChromeDriver();


		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

        profilePage=new ProfilePage(driver, js);
        locationPopupPage=new LocationPopupPage(driver, js);
        loginPage=new LoginPage(driver, js);
        notificationSistemPage=new NotificationSistemPage(driver, js);
        authPage=new AuthPage(driver, js);
        
	}

//	@AfterMethod
//	
//		
//		public void screenShot(ITestResult result){
//		
//			//using ITestResult.FAILURE is equals to result.getStatus then it enter into if condition
//				if(ITestResult.FAILURE==result.getStatus()){
//					try{
//						// To create reference of TakesScreenshot
//						TakesScreenshot screenshot=(TakesScreenshot)driver;
//						// Call method to capture screenshot
//						File src=screenshot.getScreenshotAs(OutputType.FILE);
//						// Copy files to specific location 
//						// result.getName() will return name of test case so that screenshot name will be same as test case name
//						FileUtils.copyFile(src, new File("/screenshots/"+result.getName()+".png"));
//						System.out.println("Successfully captured a screenshot");
//					}catch (Exception e){
//						System.out.println("Exception while taking screenshot "+e.getMessage());
//					} 
//			}
//		
//		this.driver.quit();
//	}
}

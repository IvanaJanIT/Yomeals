package tests;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
import pages.CartSummaryPage;
import pages.LocationPopupPage;
import pages.LoginPage;
import pages.MealPage;
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
	protected MealPage mealPage;
    protected CartSummaryPage cartSummaryPage;
    
	protected String baseUrl="http://demo.yo-meals.com";
	protected String email="customer@dummyid.com";
	protected String password="12345678a";
	

	@BeforeMethod
	public void setup() {

		System.setProperty("webdriver.chrome.driver", "driver-lib/chromedriver");

		driver = new ChromeDriver();
        js= (JavascriptExecutor)driver;


		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

        profilePage=new ProfilePage(driver, js);
        locationPopupPage=new LocationPopupPage(driver, js);
        loginPage=new LoginPage(driver, js);
        notificationSistemPage=new NotificationSistemPage(driver, js);
        authPage=new AuthPage(driver, js);
        mealPage=new MealPage(driver, js);
        cartSummaryPage=new CartSummaryPage(driver, js);
        }

	@AfterMethod
		public void screenShotOnFailureAndClose(ITestResult result) throws InterruptedException, IOException{
		
			//using ITestResult.FAILURE is equals to result.getStatus then it enter into if condition
				if(ITestResult.FAILURE==result.getStatus()){
					//try{
						
						TakesScreenshot screenshot=(TakesScreenshot)driver;
						File src=screenshot.getScreenshotAs(OutputType.FILE);
	
						LocalDateTime ldt = LocalDateTime.now();
						DateTimeFormatter formatDateTime = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss");
						
						FileUtils.copyFile(src, new File("./screenshots/"+ldt.format(formatDateTime)+".png"));
						
						System.out.println(ldt.format(formatDateTime));
					//}catch (Exception e){
						//System.out.println("Exception while taking screenshot "+e.getMessage());
					//} 
			}
	    Thread.sleep(3000);
		this.driver.quit();
	}
	
	
}

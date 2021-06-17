package tests;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public abstract class BasicTest {

	protected WebDriver driver;
	protected String baseUrl="demo.yo-meals.com";
	protected String email="customer@dummyid.com";
	protected String password="12345678a";
	
//	od dodatnih atributa ima:
//		baseUrl 
//		imejl i lozinku demo korisnika customer@dummyid.com/12345678a
//		BeforeMethod metoda koja konfiguriše Selenium drajver
//		AfterMethod metoda koja u slučaju pada testa kreira screenshot stranice i te slike čuva u okviru screenshots direktorijuma i zatvara sesiju drajvera
//		sve ostale test klase nasleđuju ovu klasu

	@BeforeMethod
	public void setup() {

		System.setProperty("webdriver.chrome.driver", "driver-lib/chromedriver");

		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);


	}

	@AfterMethod
	
		
		public void screenShot(ITestResult result){
		
			//using ITestResult.FAILURE is equals to result.getStatus then it enter into if condition
				if(ITestResult.FAILURE==result.getStatus()){
					try{
						// To create reference of TakesScreenshot
						TakesScreenshot screenshot=(TakesScreenshot)driver;
						// Call method to capture screenshot
						File src=screenshot.getScreenshotAs(OutputType.FILE);
						// Copy files to specific location 
						// result.getName() will return name of test case so that screenshot name will be same as test case name
						FileUtils.copyFile(src, new File("screenshots/"+result.getName()+".png"));
						System.out.println("Successfully captured a screenshot");
					}catch (Exception e){
						System.out.println("Exception while taking screenshot "+e.getMessage());
					} 
			}
		
		this.driver.quit();
	}
}

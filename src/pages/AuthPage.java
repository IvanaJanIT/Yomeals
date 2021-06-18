package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AuthPage extends BasicPage{

	public AuthPage(WebDriver driver, JavascriptExecutor js) {
		super(driver, js);
	}

	public WebElement getUser() {
		
		return driver.findElement(By.xpath("//li[@class=\"filled \"]/a"));
	}

	
	public WebElement getMyAccount() {
		
		return driver.findElement(By.linkText("My Account"));
	}
	
	public WebElement getLogout() {
		
		return driver.findElement(By.linkText("Logout"));
	}
}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasicPage{

	public LoginPage(WebDriver driver, JavascriptExecutor js) {
		super(driver, js);

	}

	public WebElement getUsername() {
		
		return driver.findElement(By.name("username"));
	}
	
	public WebElement getPassword() {
		
		return driver.findElement(By.name("password"));
	}
	
	public WebElement getRememberMe() {
		
		return driver.findElement(By.name("remember_me"));
	}
	
	public WebElement getLoginBtn() {
		
		return driver.findElement(By.name("btn_submit"));
	}
	
	public WebElement getForgotPassword() {
		
		return driver.findElement(By.linkText("Password"));
	}
	
	public WebElement getFacebookLogin() {
		
		return driver.findElement(By.xpath("//a[text()='Facebook']"));
	}
	
	public WebElement getGoogleLogin() {
		
		return driver.findElement(By.xpath("//a[text()='Google']"));
	}
	
	public WebElement getSignUpNow() {
		
		return driver.findElement(By.linkText("Signup Now"));
	}
}

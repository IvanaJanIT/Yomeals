package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasicPage {

	public LoginPage(WebDriver driver, JavascriptExecutor js) {
		super(driver, js);

	}

	// get username input
	public WebElement getUsername() {

		return driver.findElement(By.name("username"));
	}

	// get password input
	public WebElement getPassword() {

		return driver.findElement(By.name("password"));
	}

	// get Remember me
	public WebElement getRememberMe() {

		return driver.findElement(By.name("remember_me"));
	}

	// get Login button
	public WebElement getLoginBtn() {

		return driver.findElement(By.name("btn_submit"));
	}

	// get Forgot password link
	public WebElement getForgotPassword() {

		return driver.findElement(By.linkText("Password"));
	}
    //login
    public void login(String email, String password) {
    	this.getUsername().clear();
    	this.getUsername().sendKeys(email);
    	this.getPassword().clear();
    	this.getPassword().sendKeys(password);
    	this.getLoginBtn().click();
    }
}

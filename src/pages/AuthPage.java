package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AuthPage extends BasicPage {

	public AuthPage(WebDriver driver, JavascriptExecutor js) {
		super(driver, js);
	}
    //get Account link
	public WebElement getAccountLink() {

		return driver.findElement(By.xpath("//li[@class=\"filled \"]/a"));
	}
    //get My account dropdown
	public WebElement getMyAccount() {

		return driver.findElement(By.linkText("My Account"));
	}
    //get Logout dropdown
	public WebElement getLogout() {

		return driver.findElement(By.linkText("Logout"));
	}
    //logout user
	public void logOut() {
		
        this.getAccountLink().click();
		this.getLogout().click();
	}
}

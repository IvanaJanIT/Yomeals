package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AuthPage extends BasicPage {

	public AuthPage(WebDriver driver, JavascriptExecutor js) {
		super(driver, js);
	}

	// get Account link
	public WebElement getAccountLink() {

		return driver.findElement(By.xpath("//li[@class=\"filled \"]/a"));
	}

	// get My account dropdown
	public WebElement getMyAccount() {

		return driver.findElement(By.linkText("My Account"));
	}

	// get Logout dropdown
	public WebElement getLogout() {

		return driver.findElement(By.xpath("//*[@class=\"my-account-dropdown\"]//li[2]/a"));

	}

	// logout user
	public void logOut() throws InterruptedException {

		this.getAccountLink().click();
		// js.executeScript("argument[0].click();",lo );
		Thread.sleep(3000);
		this.getLogout().click();
	}
}

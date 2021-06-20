package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartSummaryPage extends BasicPage {

	public CartSummaryPage(WebDriver driver, JavascriptExecutor js) {
		super(driver, js);
	}

	// get Clear All button
	public WebElement getClearAll() {

		return driver.findElement(By.linkText("Clear All"));
	}

	// clear all from Cart
	public void clearAllFromCart() {

		this.getClearAll().click();
	}
}

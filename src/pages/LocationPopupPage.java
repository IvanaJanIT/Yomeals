package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LocationPopupPage extends BasicPage {



	public LocationPopupPage(WebDriver driver, JavascriptExecutor js) {
		super(driver, js);
	}

	public WebElement getSelectLocationHeader() {

		return driver.findElement(By.xpath("//div[@class=\"location-selector\"]/a"));
	}

	public WebElement getCloseLocationPopup() {

		return driver.findElement(By.xpath("//a[@class=\"close-btn close-btn-white\"]"));

	}

	public WebElement getKeyword() {

		return driver.findElement(By.id("locality_keyword"));

	}

	public WebElement getLocationItem(String locationName) {

		return driver.findElement(By.xpath("//li/a[contains(text(), '\" + locationName + \"')]/.."));
	}

	public WebElement getLocationInput() {

		return driver.findElement(By.id("location_id"));
	}

	public WebElement getSubmit() {

		return driver.findElement(By.name("btn_submit"));
	}

	public void openLocationPopup() {

		this.getSelectLocationHeader().click();
	}

	public void setLocation(String locationName) {

		this.getKeyword().click();

		WebElement locationInput = this.getLocationInput();
		String dataValue = this.getLocationItem(locationName).getAttribute("data-value");

		//JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value=arguments[1]", locationInput, dataValue);

		js.executeScript("arguments[0].click()", this.getSubmit());
	}

	public void closeLocationPopup() {

		this.getCloseLocationPopup().click();
	}
}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LocationPopupPage extends BasicPage {

	public LocationPopupPage(WebDriver driver, JavascriptExecutor js) {
		super(driver, js);
	}

	// get Select Location from header
	public WebElement getSelectLocationHeader() {

		return driver.findElement(By.xpath("//div[@class=\"location-selector\"]/a"));
	}

	// get close Select Location popup
	public WebElement getCloseLocationPopup() {

		return driver.findElement(By.xpath("//a[@class=\"close-btn close-btn-white\"]"));

	}

	// get Select Location
	public WebElement getKeyword() {

		return driver.findElement(By.id("locality_keyword"));

	}

	// get Location item
	public WebElement getLocationItem(String locationName) {

		return driver.findElement(By.xpath("//li/a[contains(text(), '\" + locationName + \"')]/.."));
	}

	// get Location input
	public WebElement getLocationInput() {

		return driver.findElement(By.id("location_id"));
	}

	// submit selected location
	public WebElement getSubmit() {

		return driver.findElement(By.name("btn_submit"));
	}

	// open Select Location popup
	public void openLocationPopup() {

		this.getSelectLocationHeader().click();
	}

	// set location
	public void setLocation(String locationName) {

		this.getKeyword().click();

		WebElement locationInput = this.getLocationInput();
		String dataValue = this.getLocationItem(locationName).getAttribute("data-value");

		js.executeScript("arguments[0].value=arguments[1]", locationInput, dataValue);

		js.executeScript("arguments[0].click()", this.getSubmit());
	}

	// close Select Location popup
	public void closeLocationPopup() {

		this.getCloseLocationPopup().click();
	}
}

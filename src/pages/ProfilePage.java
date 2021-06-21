package pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage extends BasicPage {

	public ProfilePage(WebDriver driver, JavascriptExecutor js) {
		super(driver, js);
	}

	// get First name input
	public WebElement getFirstName() {

		return driver.findElement(By.name("user_first_name"));
	}

	// get Last name input
	public WebElement getLastName() {

		return driver.findElement(By.name("user_last_name"));
	}

	// get Email input
	public WebElement getEmail() {

		return driver.findElement(By.name("user_email"));
	}

	// get Address input
	public WebElement getAddress() {

		return driver.findElement(By.name("user_address"));
	}

	// get Phone input
	public WebElement getPhone() {

		return driver.findElement(By.name("user_phone"));
	}

	// get Zip input
	public WebElement getZip() {

		return driver.findElement(By.name("user_zip"));
	}

	// Country select
	public void getCountry(String country) {

		Select se = new Select(driver.findElement(By.id("user_country_id")));
		se.selectByVisibleText(country);
	}

	// State select
	public void getState(String state) {

		Select se = new Select(driver.findElement(By.id("user_state_id")));
		se.selectByVisibleText(state);
	}

	// City select
	public void getCity(String city) {

		Select se = new Select(driver.findElement(By.id("user_city")));
		se.selectByVisibleText(city);
	}

	// get Save personal info button
	public WebElement getSavePersonalInfo() {

		return driver.findElement(By.xpath("//form[@name=\"frmProfileInfo\"]//input[@value=\"Save\"]"));
	}

	// set personal information
	public void setPersonalInfo(String fname, String lname, String address, String phone, String zip, String country,
			String state, String city) throws InterruptedException {

		this.getFirstName().clear();
		this.getFirstName().sendKeys(fname);
		this.getLastName().clear();
		this.getLastName().sendKeys(lname);
		// this.getEmail().clear();
		// this.getEmail().sendKeys(email);
		this.getAddress().clear();
		this.getAddress().sendKeys(address);
		this.getPhone().clear();
		this.getPhone().sendKeys(phone);
		this.getZip().clear();
		this.getZip().sendKeys(zip);

		this.getCountry(country);
		Thread.sleep(3000);
		this.getState(state);
		Thread.sleep(3000);
		this.getCity(city);
		Thread.sleep(3000);
		this.getSavePersonalInfo().submit();
	}

	// get image
	public WebElement getImg() {

		return driver.findElement(By.xpath("//*[@class=\"avatar\"]/img"));
	}

	// get image upload link
	public WebElement getUpload() {

		return driver.findElement(By.xpath("//*[@class=\"hover-elemnts\"]/a"));
	}

	// get image remove link
	public WebElement getRemove() {

		return driver.findElement(By.xpath("//*[@class=\"hover-elemnts\"]/a[2]"));
	}

	// get image input
	public WebElement getImgInput() {

		return driver.findElement(By.xpath("//input[@type=\"file\"]"));
	}

	// Upload image
	public void imgUpload(String imgPath) throws InterruptedException, AWTException {

		Actions act = new Actions(driver);
		WebElement element = this.getImg();
		act.moveToElement(element).build().perform();

		WebElement upload = this.getUpload();
		act.moveToElement(upload);
		Thread.sleep(3000);
		act.click().build().perform();
		// js.executeScript("arguments[0].click()", upload);
		this.getImgInput().sendKeys(imgPath);

	     Robot robot = new Robot();
		 Thread.sleep(2000);
	     robot.keyPress(KeyEvent.VK_TAB);
	     Thread.sleep(2000);
	     robot.keyPress(KeyEvent.VK_TAB);
	     Thread.sleep(2000);
	     robot.keyPress(KeyEvent.VK_TAB);
	     Thread.sleep(2000);
	     robot.keyRelease(KeyEvent.VK_ENTER);
	     
	     Thread.sleep(2000);

	}

	// Remove image
	public void imgRemove() throws InterruptedException {

		Actions act = new Actions(driver);
		WebElement element = this.getImg();
		act.moveToElement(element).build().perform();

		WebElement remove = this.getRemove();
		act.moveToElement(remove);
		Thread.sleep(3000);
		act.click().build().perform();
		// js.executeScript("arguments[0].click()", this.getRemove());
	}

}

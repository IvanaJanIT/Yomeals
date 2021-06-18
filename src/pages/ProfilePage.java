package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ProfilePage extends BasicPage {

	public ProfilePage(WebDriver driver, JavascriptExecutor js) {
		super(driver, js);
	}

//	get metode za sve potrebne elemente
//	sve elemente za izmenu osnovnih informacija kao i 
//	sve elemente potrebne za rad sa profilnom slikom
//	da bi se na stranici pojavio element input type="file" potrebno je da se prvo izvrši JavaScript kod koji vrši akciju klik na Upload dugme 
//	Skripta: arguments[0].click();
//	metodu koja otprema profilnu sliku - kao parametar se prosleđuje putanja do fajla, tj. u ovom slučaju do slike
//	metodu koja briše profilnu sliku
//	klikom na Remove dugme 
//	Preporuka: izvršite JavaScript kod arguments[0].click(); nad tim dugmetom
//	metodu koja menja sve osnovne informacije korisnika - kao parametri se prosleđuju sve potrebne informacije

	public WebElement getFirstName() {

		return driver.findElement(By.name("user_first_name"));
	}

	public WebElement getLastName() {

		return driver.findElement(By.name("user_last_name"));
	}

	public WebElement getEmail() {

		return driver.findElement(By.name("user_email"));
	}

	public WebElement getAddress() {

		return driver.findElement(By.name("user_address"));
	}

	public WebElement getPhone() {

		return driver.findElement(By.name("user_phone"));
	}

	public WebElement getZip() {

		return driver.findElement(By.name("user_zip"));
	}

	public void getCountry(String country) {

		Select se = new Select(driver.findElement(By.id("user_country_id")));
		se.selectByVisibleText(country);
	}

	public void getState(String state) {

		Select se = new Select(driver.findElement(By.id("user_state_id")));
		se.selectByVisibleText(state);
	}

	public void getCity(String city) {

		Select se = new Select(driver.findElement(By.id("user_city")));
		se.selectByVisibleText(city);
	}

	public WebElement getSavePersonalInfo() {

		return driver.findElement(By.xpath("//*[@name=\"frmProfileInfo\"]//input[@value=\"Save\"]"));
	}


public void setPersonalInfo(String fname, String lname, String email, String address, String phone, String zip, String country, String state, String city){
	
	this.getFirstName().sendKeys(fname);
	this.getLastName().sendKeys(lname);
	this.getEmail().sendKeys(email);
	this.getAddress().sendKeys(address);
	this.getPhone().sendKeys(phone);
	this.getZip().sendKeys(zip);
	this.getCountry(country);
	this.getState(state);
	this.getCity(city);
	this.getSavePersonalInfo().click();
}
}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProfilePage extends BasicPage{


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
}

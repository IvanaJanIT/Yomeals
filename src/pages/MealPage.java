package pages;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MealPage extends BasicPage{

	public MealPage(WebDriver driver, JavascriptExecutor js) {
		super(driver, js);
	}

	public List<WebElement> getProducts(){

		return driver.findElements(By.xpath("//*[@class=\"featured-img\"]/a"));
	}
	
	public WebElement getAddCart() {
		
		return driver.findElement(By.linkText("Add To Cart"));
	}
	
	public WebElement getProductQty() {
		
		return driver.findElement(By.name("product_qty"));
	}
	
	
	public WebElement getFavorite() {
		
		return driver.findElement(By.xpath("//a[@title=\"Favorite\"]"));
	}
	
}

package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MealPage extends BasicPage {

	public MealPage(WebDriver driver, JavascriptExecutor js) {
		super(driver, js);
	}

	// get list of products
	public List<WebElement> getProducts() {

		return driver.findElements(By.xpath("//*[@class=\"featured-img\"]/a"));
	}

	// get Add cart button
	public WebElement getAddCart() {

		return driver.findElement(By.linkText("Add To Cart"));
	}

	// get Product quantity input
	public WebElement getProductQty() {

		return driver.findElement(By.name("product_qty"));
	}

	// get Favorite link
	public WebElement getFavorite() {

		return driver.findElement(By.xpath("//a[@title=\"Favorite\"]"));
	}

	// add product to Cart
	public void addToCart(String quantity) {

		this.getProductQty().sendKeys(quantity);
		this.getAddCart().click();
	}

	// add to Favorites
	public void addInFavorite() {

		this.getFavorite().click();
	}
}

package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchResultPage extends BasicPage {

	public SearchResultPage(WebDriver driver, JavascriptExecutor js) {
		super(driver, js);
	}

	// get SearchMeals input
	public WebElement getSearchMeals() {

		return driver.findElement(By.xpath("//form[@name=\"frmSearchMeals\"]/input"));
	}

	// get a list of searched products
	public List<WebElement> getProductsList() {

		return driver.findElements(By.xpath("//*[@class=\"product-name\"]/a"));
	}

	// get a list of names of products
	public List<String> getProductsNames() {

		List<String> productNames = new ArrayList<String>();
		for (int i = 0; i < this.getProductsList().size(); i++) {

			productNames.add(this.getProductsList().get(i).getText());
		}
		return productNames;
	}

	// get a number of all products
	public int getProductsNumber() {

		return this.getProductsList().size();
	}
}

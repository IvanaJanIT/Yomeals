package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class MealItemTest extends BasicTest{

//	@Test(priority = 0)
//	public void addMealToCartTest() throws InterruptedException {
//		
//		this.driver.get(baseUrl + "/meal/lobster-shrimp-chicken-quesadilla-combo");
//		locationPopupPage.closeLocationPopup();
//		mealPage.addToCart("1");
//
//		Assert.assertTrue(notificationSistemPage.getMessageText().contains("The Following Errors Occurred:"),
//				"Message 'The Following Errors Occurred:' is not displayed");
//		Assert.assertTrue(notificationSistemPage.getMessageText().contains("Please Select Location"),
//				"Message 'Please Select Location' is not displayed");
//		
//		notificationSistemPage.waitMessageDisappear();
//		locationPopupPage.openLocationPopup();
//		locationPopupPage.setLocation("City Center - Albany");
//		
//		//mealPage.getProducts().get(0).click();
//		mealPage.addToCart("1");
//		Assert.assertTrue(notificationSistemPage.getMessageText().contains("Meal Added To Cart"),
//				"Message 'Meal Added To Cart' is not displayed");
//	
//	} 
//	@Test(priority = 1)
//	public void addMealToFavoriteTest() {
//		
//		this.driver.get(baseUrl + "/meal/lobster-shrimp-chicken-quesadilla-combo");
//		locationPopupPage.closeLocationPopup();
//		mealPage.addInFavorite();
//		Assert.assertTrue(notificationSistemPage.getMessageText().contains("Please login first!"),
//				"Message 'Please login first!' is not displayed");
//		
//		this.driver.get(baseUrl + "/guest-user/login-form");
//		loginPage.login(this.email, this.password);
//		Assert.assertTrue(notificationSistemPage.getMessageText().contains("Login Successfull"),
//				"Message 'Login Successfull' is not displayed");
//		
//		this.driver.get(baseUrl + "/meal/lobster-shrimp-chicken-quesadilla-combo");
//		mealPage.addInFavorite();
//		Assert.assertTrue(notificationSistemPage.getMessageText().contains("Product has been added to your favorites."),
//				"Message 'Product has been added to your favorites.' is not displayed");
//		
//	}
	
	@Test(priority = 2)
	public void clearCartTest() throws InterruptedException, IOException {
		this.driver.get(baseUrl + "/meals");
		locationPopupPage.setLocation("City Center - Albany");
		
		File file = new File("data/Data.xlsx");
		FileInputStream fis = new FileInputStream(file);

		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("Meals");
		
		for (int i = 1; i < 6; i++) {
			
			String mealURL = sheet.getRow(i).getCell(0).getStringCellValue();
			this.driver.get(mealURL);
			Thread.sleep(3000);
			int quantity = (int) sheet.getRow(i).getCell(1).getNumericCellValue();
			String quant=Integer.toString(quantity); 
			mealPage.addToCart(quant);
			Thread.sleep(3000);
			SoftAssert softAssertion= new SoftAssert();
			softAssertion.assertTrue(notificationSistemPage.getMessageText().contains("Meal Added To Cart"),
					"Message 'Meal Added To Cart' is not displayed");
			
		}
		cartSummaryPage.clearAllFromCart();
		Assert.assertTrue(notificationSistemPage.getMessageText().contains("All meals removed from Cart successfully"),
				"Message 'All meals removed from Cart successfully' is not displayed");
		
	}
}

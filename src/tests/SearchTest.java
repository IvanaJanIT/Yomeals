package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SearchTest extends BasicTest {

	@Test(priority = 0)
	public void searchResultsTest() throws InterruptedException, IOException {

		this.driver.get(baseUrl + "/meals");
		locationPopupPage.setLocation("City Center - Albany");

		// Assert.assertTrue(notificationSistemPage.getMessageText().contains("Locality
		// Setup Successfully"),
		// "Message 'Locality Setup Successfully' is not displayed");

		File file = new File("data/Data.xlsx");
		FileInputStream fis = new FileInputStream(file);

		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("Meal Search Results");
		
		SoftAssert softAssertion = new SoftAssert();

		for (int i = 1; i < 7; i++) {

			String mealURL = sheet.getRow(i).getCell(1).getStringCellValue();
			this.driver.get(mealURL);
			Thread.sleep(3000);

			String location = sheet.getRow(i).getCell(0).getStringCellValue();
			locationPopupPage.openLocationPopup();
			locationPopupPage.setLocation(location);
			
			// softAssertion.assertTrue(notificationSistemPage.getMessageText().contains("Locality
			// Setup Successfully"),
			// "Message 'Locality Setup Successfully' is not displayed");

			int numberOfResults = (int) sheet.getRow(i).getCell(2).getNumericCellValue();
			int numberOfProducts = searchResultPage.getProductsNumber();
			Thread.sleep(3000);
			softAssertion.assertEquals(numberOfProducts, numberOfResults, "Product numbers do not match.");
			Thread.sleep(3000);

			for (int j = 3; j < 3 + numberOfResults; j++) {

				String meal = sheet.getRow(i).getCell(j).getStringCellValue();
				String name = searchResultPage.getProductsNames().get(j - 3);
				Thread.sleep(3000);
				softAssertion.assertTrue(name.contains(meal), "Product names do not match. ");
			}

			Thread.sleep(3000);
		}
		workbook.close();
		softAssertion.assertAll();
	}
}

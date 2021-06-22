package tests;

import java.awt.AWTException;

import java.io.File;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfileTest extends BasicTest {

	@Test(priority = 0)
	public void editProfileTest() throws InterruptedException {

		this.driver.get(baseUrl + "/guest-user/login-form");
		locationPopupPage.closeLocationPopup();
		loginPage.login(this.email, this.password);
		Assert.assertTrue(notificationSistemPage.getMessageText().contains("Login Successfull"),
				"Message 'Login Successfull' is not displayed");
		this.driver.get(baseUrl + "/member/profile");
		profilePage.setPersonalInfo("Ivana", "Ilic", "Rajiceva 12", "+38118456765", "18000", "India", "Bihar", "Ara");
		Assert.assertTrue(notificationSistemPage.getMessageText().contains("Setup Successful"),
				"Message 'Setup Successful' is not displayed");
		Thread.sleep(3000);
		authPage.logOut();
		Assert.assertTrue(notificationSistemPage.getMessageText().contains("Logout Successfull!"),
				"Message 'Logout Successfull!' is not displayed");
	}

	@Test(priority = 1)
	public void changeProfileTest() throws InterruptedException, IOException, AWTException {

		this.driver.get(baseUrl + "/guest-user/login-form");
		locationPopupPage.closeLocationPopup();
		loginPage.login(this.email, this.password);
		Assert.assertTrue(notificationSistemPage.getMessageText().contains("Login Successfull"),
				"Message 'Login Successfull' is not displayed");
		this.driver.get(baseUrl + "/member/profile");

		String imgPath = new File("img/fav.jpg").getCanonicalPath();
		profilePage.imgUpload(imgPath);
		String messageText = notificationSistemPage.getMessageText();
		Assert.assertTrue(messageText.contains("Profile Image Uploaded Successfully"),
				"Message 'Profile Image Uploaded Successfully' is not displayed");
		notificationSistemPage.waitMessageDisappear();

		profilePage.imgRemove();
		messageText = notificationSistemPage.getMessageText();
		Assert.assertTrue(messageText.contains("Profile Image Deleted Successfully"),
				"Message 'Profile Image Deleted Successfully' is not displayed");
		notificationSistemPage.waitMessageDisappear();

		authPage.logOut();
		Assert.assertTrue(notificationSistemPage.getMessageText().contains("Logout Successfull!"),
				"Message 'Logout Successfull!' is not displayed");
	}
}

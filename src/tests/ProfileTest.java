package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfileTest extends BasicTest{

	
	@Test
	public void editProfileTest() throws InterruptedException {
		
		this.driver.get(baseUrl + "/guest-user/login-form");
        locationPopupPage.closeLocationPopup();
        loginPage.login(this.email, this.password);
        Assert.assertTrue(notificationSistemPage.getMessageText().contains("Login Successfull"), "Message 'Login Successfull' is not displayed");
        this.driver.get(baseUrl + "/member/profile");
        profilePage.setPersonalInfo("Ivana", "Ilic", "Rajiceva 12", "+38118456765", "18000", "India", "Bihar", "Ara");
        Assert.assertTrue(notificationSistemPage.getMessageText().contains("Setup Successful"), "Message 'Setup Successful' is not displayed");
        Thread.sleep(3000);
        authPage.logOut();
        Assert.assertTrue(notificationSistemPage.getMessageText().contains("Logout Successfull!"), "Message 'Logout Successfull!' is not displayed");
	}
}

package guruBankTestCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import guruBank_POM.loginPage;
import utilities.baseClass;

public class TC_LoginDP_001 extends baseClass{
	
	@Test(dataProvider = "GetLoginData")
	public void validateLogin(String uID, String pass) throws IOException {

		loginPage lp = new loginPage(driver);

		lp.setUserName(uID);
		System.out.println("Entered username.");

		lp.setPassword(pass);
		System.out.println("Entered password.");

		try
		{
			lp.clickLogin();
			String actualTitle = (driver.getTitle());
			String expectedTitle = "Guru99 Bank Manager HomePage";
			Assert.assertEquals(actualTitle, expectedTitle);
			System.out.println("Login Test with DataProvider passed...");
		}
		catch (Exception e)
		{
			screenCapture(driver, "LoginTestFailed");
			System.out.println("Login Test with DataProvider failed...");
		}

		lp.clickLogout();
		WebDriverWait wait = new WebDriverWait (driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='uid']")));
	}

	@DataProvider(name = "GetLoginData")
	public Object[][] loginData() {

		return new Object[][] {{"mngr384654","dypYhev"}};
	}
}

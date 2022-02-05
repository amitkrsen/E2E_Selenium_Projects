package testCode_Mod8;

import org.testng.annotations.Test;

import baseCode_Mod8.baseCode_Module8;
import baseCode_Mod8.loginWithPageFactory;
import baseCode_Mod8.loginWithoutPageFactory;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class gmailValidation extends setupBrowser {

	loginWithoutPageFactory login;
	//baseCode_Module8 bcm8 = new baseCode_Module8();

	@BeforeClass
	public void beforeClass() {
		login = new loginWithoutPageFactory(driver);
	}

	@Parameters({"email","pass"})
	@Test(description = "TC_001 - This is to validate login", priority = 1)
	public void a_validateLogin(String email, String pass) throws InterruptedException {
		login.loginAsUser(email, pass);
		String expectedTitle = driver.getCurrentUrl();
		String actualTitle = "https://mail.google.com/mail/u/0/#inbox";
		assertTrue(expectedTitle.equals(actualTitle));
	}

	@Test(description = "TC_002 - This is to validate compse and send mail", dependsOnMethods = {"a_validateLogin"})
	public void b_validateSendMail() throws InterruptedException {
		bcm8.compose();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[7]/div[3]/div/div[1]/div[4]/div[1]/div/div[3]/div/div/div[2]/span/span[1]")));
		WebElement msgSent = driver.findElement(By.xpath("/html/body/div[7]/div[3]/div/div[1]/div[4]/div[1]/div/div[3]/div/div/div[2]/span/span[1]"));
		String actualText = msgSent.getText();
		String expectedText = "Message sent.";
		assertTrue(actualText.equals(expectedText));
	}

	@Test(description = "TC_003 - This is to validate logout", dependsOnMethods = {"b_validateSendMail"}, enabled = true)
	public void c_validateLogout() throws InterruptedException {
		bcm8.logout();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='cRiDhf']")));
		WebElement signedOut = driver.findElement(By.xpath("//div[@class='cRiDhf']"));
		String actualText = signedOut.getText();
		String expectedText = "Signed out";
		assertTrue(actualText.equals(expectedText));
	}

	@Test(description = "TC_004 - Close browser", dependsOnMethods = {"c_validateLogout"}, enabled = true)
	public void d_browserClose() {
		bcm8.browserClose();
	}
}

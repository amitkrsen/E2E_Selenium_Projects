package baseCode_Mod8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class loginWithoutPageFactory {

	WebDriver driver;

	By emailID = By.xpath("//input[@type='email']");
	By passwd = By.xpath("//input[@type='password']");
	By next = By.xpath("//span[@class='RveJvd snByac']");


	public loginWithoutPageFactory(WebDriver driver) {
		this.driver = driver;
	}
	//login to gmail...
	public void loginAsUser(String email, String pass) throws InterruptedException {
		driver.findElement(emailID).sendKeys(email);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(next));
		driver.findElement(next).click();
		wait.until(ExpectedConditions.elementToBeClickable(passwd));
		driver.findElement(passwd).sendKeys(pass);
		wait.until(ExpectedConditions.elementToBeClickable(next));
		driver.findElement(next).click();
		Thread.sleep(5000);
	}

}

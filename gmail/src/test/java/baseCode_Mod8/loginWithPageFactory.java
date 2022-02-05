package baseCode_Mod8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class loginWithPageFactory {

	WebDriver driver;


	@FindBy(how=How.XPATH, using="//input[@type='email']")
	@CacheLookup
	WebElement emailID;

	@FindBy(how=How.XPATH, using="//input[@type='password']")
	@CacheLookup
	WebElement passwd;

	@FindBy(how=How.XPATH, using="//span[@class='RveJvd snByac']")
	@CacheLookup
	WebElement next;

	public loginWithPageFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	//login to gmail...
	public void loginAsUser(String email, String pass) throws InterruptedException {
		emailID.sendKeys(email);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(next));
		next.click();
		Thread.sleep(3000);
		passwd.sendKeys(pass);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[@class='RveJvd snByac']")).click();
		Thread.sleep(5000);
	}
}


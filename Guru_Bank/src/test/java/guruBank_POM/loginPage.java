package guruBank_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class loginPage {
	
	WebDriver driver;
	
	public loginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.XPATH, using = "//input[@name='uid']")
	WebElement txtUserID;
	
	@FindBy(how = How.XPATH, using = "//input[@name='password']")
	WebElement txtPassowrd;
	
	@FindBy(how = How.XPATH, using = "//input[@name='btnLogin']")
	WebElement btnLogin;
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Log out')]")
	WebElement btnLogout;
	
	
	public void setUserName(String uname) {
		
		txtUserID.sendKeys(uname);
	}
	
	public void setPassword(String pass) {
		
		txtPassowrd.sendKeys(pass);
	}
	
	public void clickLogin() {
		
		btnLogin.click();
	}
	
	public void clickLogout() {
		
		btnLogout.click();
		driver.switchTo().alert().accept();
	}
	
}

package testCode_Mod8;

import baseCode_Mod8.baseCode_Module8;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;

public class setupBrowser {

	WebDriver driver;
	baseCode_Module8 bcm8 = new baseCode_Module8();

	@Parameters({"browser","url"})
	@BeforeSuite
	public void beforeSuite(String browser, String url) {
		bcm8.setupBrowser(browser, url);
		driver = bcm8.getDriver();
	}

	@AfterSuite
	public void afterSuite() {
//		bcm8.browserClose();
	}

}

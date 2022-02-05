package utilities;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class baseClass {

	public static WebDriver driver;
	
	@Parameters({"browser","url"})
	@BeforeClass
	public void setUpBrowser(String browser, String url) {

		String currDir = System.getProperty("user.dir");

		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", currDir+"\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", currDir+"\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		System.out.println("Browser opened successfully...");
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		System.out.println("Landed on HomePage...");
	}
	
	
	@AfterClass
	public void tearDown() {
		
		driver.close();
		driver.quit();
		System.out.println("Browser closed successfully...");
	}
	
	public void screenCapture(WebDriver driver, String filename) throws IOException {
		
		String currDir = System.getProperty("user.dir");
		File screenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenShot, new File(currDir+"\\screenShots\\"+filename+".jpeg"));
		System.out.println("Screenshot taken...");
	}

}

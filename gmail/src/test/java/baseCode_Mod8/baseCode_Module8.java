package baseCode_Mod8;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class baseCode_Module8 {
	
	static WebDriver driver;

	public void setupBrowser(String browser, String url) {
		String currDir = System.getProperty("user.dir");
		
		//calling chrome browser...
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", currDir+"\\drivers\\chromedriver.exe");

			ChromeOptions option = new ChromeOptions();
			option.addArguments("start-maximized");
			driver = new ChromeDriver(option);
		}
		//calling firefox browser...
		else if(browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", currDir+"\\drivers\\geckodriver.exe");

			FirefoxOptions option = new FirefoxOptions();
			option.addArguments("start-maximized");
			driver = new FirefoxDriver(option);
		}

		//get url...
		if(url != "")
			driver.get(url);
		else
			driver.get("about:blank");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	//close browser...
	public void browserClose() {
		driver.quit();
	}

	//get driver...
	public WebDriver getDriver() {
		return driver;
	}
	
	//compose and send mail...
	public void compose() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='T-I J-J5-Ji T-I-KE L3']")));
		driver.findElement(By.xpath("//*[@class='T-I J-J5-Ji T-I-KE L3']")).click();
		driver.findElement(By.xpath("//textarea[contains(@aria-label, 'To')]")).click();
		driver.findElement(By.xpath("//textarea[contains(@aria-label, 'To')]")).sendKeys("amit.kr.sen21@gmail.com");
		driver.findElement(By.xpath("//textarea[contains(@aria-label, 'To')]")).sendKeys(Keys.ENTER);
		driver.findElement(By.name("subjectbox")).click();
		driver.findElement(By.name("subjectbox")).sendKeys("Automation test mail");
		driver.findElement(By.xpath("//div[contains(@aria-label, 'Message Body')]")).click();
		driver.findElement(By.xpath("//div[contains(@aria-label, 'Message Body')]")).sendKeys("Automation test mail body");
		driver.findElement(By.xpath("//div[contains(@aria-label, 'Send ‪(Ctrl-Enter)‬')]")).click();
		Thread.sleep(10000);
	}

	//logout...
	public void logout() {
		driver.findElement(By.xpath("//*[@id='gb']/div[2]/div[3]/div[1]/div[2]/div/a")).click();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='gb_71']")));
		driver.findElement(By.xpath("//*[@id='gb_71']")).click();
	}
}

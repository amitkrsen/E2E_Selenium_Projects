package guruBankTestCases;

import org.testng.annotations.Test;

import guruBank_POM.loginPage;
import guruBank_POM.newCustomer_Page;
import utilities.baseClass;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

public class TC_AddNewCustomer_003 extends baseClass {
	
		
  @Test(dataProvider = "GetLoginData")
  public void addCustomer(String uID, String pass) throws IOException {
	  
	  loginPage lp = new loginPage(driver);
	  newCustomer_Page ncp = new newCustomer_Page(driver);

		lp.setUserName(uID);
		System.out.println("Entered username.");

		lp.setPassword(pass);
		System.out.println("Entered password.");
		
		lp.clickLogin();
		
		ncp.clickNewCust();
		ncp.setNewCust("Dum Dam");
		ncp.clickGender();
		ncp.setDob("06","15","1968");
		ncp.setAddress("FB92 Narayantala WestBaguiati Ambika Apartme");
		ncp.setCity("Kolkata");
		ncp.setState("West Bengal");
		ncp.setPin("700001");
		ncp.setMobNum("8617739647");
		ncp.setEmail("dumdam@yahoo.com");
		ncp.setPass("123456789");
		
		try
		{
			ncp.clickSubmit();
			Thread.sleep(3000);
			screenCapture(driver, "NewCustomer");
			String expectedMsg = "Customer Registered Successfully!!!";
			Assert.assertEquals(ncp.actualMsg(), expectedMsg);
			System.out.println(ncp.actualMsg());
			System.out.println("New customer ID is: "+ncp.newCustId());
		}
		catch(Exception e)
		{
//			driver.switchTo().alert().accept();
			screenCapture(driver, "NewCustomer_Error");
			System.out.println("Customer not added due to: "+e);
		}
		
		lp.clickLogout();
		WebDriverWait wait = new WebDriverWait (driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='uid']")));
		
  }
  
  
  @DataProvider(name = "GetLoginData")
	public Object[][] loginData() {

		return new Object[][] {{"mngr379628","dEqajat"}};
	}

}

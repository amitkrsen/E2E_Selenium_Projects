package guruBankTestCases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import guruBank_POM.loginPage;
import utilities.baseClass;

public class TC_LoginExcl_002 extends baseClass {

	XSSFWorkbook workbook;
	XSSFSheet sheet;
	XSSFCell cell;

	@Test
	public void validateLogin() throws IOException {

		loginPage lp = new loginPage(driver);

		String currDir = System.getProperty("user.dir");

		File src = new File(currDir+"\\datafiles\\loginData.xlsx");
		FileInputStream fis = new FileInputStream(src);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheetAt(0);

		for (int i = 1; i <= sheet.getLastRowNum(); i++) {

			cell = sheet.getRow(i).getCell(0);
			cell.setCellType(CellType.STRING);
			lp.setUserName(cell.getStringCellValue());
			System.out.println("Entered username.");

			cell = sheet.getRow(i).getCell(1);
			cell.setCellType(CellType.STRING);
			lp.setPassword(cell.getStringCellValue());
			System.out.println("Entered password.");
			
			FileOutputStream fos = new FileOutputStream(src);
			String pass = "Passed - Valid Login";
			String fail = "Failed - Invalid Login";
			SoftAssert softAssert = new SoftAssert();

			try
			{
				lp.clickLogin();
				String actualTitle = (driver.getTitle());
				String expectedTitle = "Guru99 Bank Manager HomePage";
				Assert.assertEquals(actualTitle, expectedTitle);
//				softAssert.assertEquals(actualTitle, expectedTitle);
				System.out.println("Login Test with Excel Input passed...");
			}
			catch (Exception e)
			{
				sheet.getRow(i).createCell(2).setCellValue(fail);
				workbook.write(fos);
				System.out.println("Login Test with Excel Input failed...");
				screenCapture(driver, "LoginTestFailed");
			}
			

			lp.clickLogout();
			sheet.getRow(i).createCell(2).setCellValue(pass);
			workbook.write(fos);
			WebDriverWait wait = new WebDriverWait (driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='uid']")));
		}


	}

}

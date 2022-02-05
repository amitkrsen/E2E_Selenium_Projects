package guruBank_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class newCustomer_Page {

	WebDriver driver;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'New Customer')]")
	WebElement newCustomer;

	@FindBy(how = How.XPATH, using = "//input[@name='name']")
	WebElement custName;

	@FindBy(how = How.XPATH, using = "//input[@value='m']")
	WebElement gender;

	@FindBy(how = How.XPATH, using = "//input[@id='dob']")
	WebElement dob;

	@FindBy(how = How.XPATH, using = "//textarea[@name='addr']")
	WebElement address;

	@FindBy(how = How.XPATH, using = "//input[@name='city']")
	WebElement city;

	@FindBy(how = How.XPATH, using = "//input[@name='state']")
	WebElement state;

	@FindBy(how = How.XPATH, using = "//input[@name='pinno']")
	WebElement pin;

	@FindBy(how = How.XPATH, using = "//input[@name='telephoneno']")
	WebElement mobNum;

	@FindBy(how = How.XPATH, using = "//input[@name='emailid']")
	WebElement custEmail;

	@FindBy(how = How.XPATH, using = "//input[@name='password']")
	WebElement custPass;

	@FindBy(how = How.XPATH, using = "//input[@value='Submit']")
	WebElement submit;

	@FindBy(how = How.XPATH, using = "//p[contains(text(),'Customer Registered Successfully!!!')]")
	WebElement actualMsg;

	@FindBy(how = How.XPATH, using = "//p[contains(text(),'Customer Registered Successfully!!!')]//parent::td[@colspan='2']//parent::tr//following-sibling::tr//td[contains(text(),'Customer ID')]//following-sibling::td")
	WebElement custId;

	public newCustomer_Page(WebDriver ndriver) {

		this.driver = ndriver;
		PageFactory.initElements(ndriver, this);
	}

	public void clickNewCust() {

		newCustomer.click();
	}

	public void setNewCust(String newCustName) {

		custName.sendKeys(newCustName);
	}

	public void clickGender() {

		gender.click();
	}

	public void setDob(String mm, String dd, String yyyy) {

		dob.sendKeys(mm);
		dob.sendKeys(dd);
		dob.sendKeys(yyyy);
	}

	public void setAddress(String addrs) {

		address.sendKeys(addrs);
	}

	public void setCity(String cityName) {

		city.sendKeys(cityName);
	}

	public void setState(String stateName) {

		state.sendKeys(stateName);
	}

	public void setPin(String pinCode) {

		pin.sendKeys(pinCode);
	}

	public void setMobNum(String phNum) {

		mobNum.sendKeys(phNum);
	}

	public void setEmail(String email) {

		custEmail.sendKeys(email);
	}

	public void setPass(String pass) {

		custPass.sendKeys(pass);
	}

	public void clickSubmit() {

		submit.click();
	}

	public String actualMsg() {

		String sucessMsg = actualMsg.getText();
		return sucessMsg;
	}

	public String newCustId() {

		return custId.getText();
	}

}

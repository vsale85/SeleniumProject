package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyPersonalInfoPage {

	WebDriver driver;
	WebElement name;
	WebElement lastName;
	WebElement email;
	WebElement currentPassword;
	WebElement saveBtn;
	WebElement confirmationMsg;
	
	public MyPersonalInfoPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public WebElement getName() {
		return driver.findElement(By.id("firstname"));
	}

	public WebElement getLastName() {
		return driver.findElement(By.id("lastname"));
	}

	public WebElement getEmail() {
		return driver.findElement(By.id("email"));
	}

	public WebElement getCurrentPassword() {
		return driver.findElement(By.id("old_passwd"));
	}

	public WebElement getSaveBtn() {
		return driver.findElement(By.name("submitIdentity"));
	}

	public WebElement getConfirmationMsg() {
		return driver.findElement(By.className("alert-success"));
	}
	
	public void updatePersonalInfo(String firstName, String lastName, String email, String currentPass) throws InterruptedException {
		getName().clear();
		getName().sendKeys(firstName);
		getLastName().clear();
		getLastName().sendKeys(lastName);
		getEmail().clear();
		getEmail().sendKeys(email);
		getCurrentPassword().clear();
		getCurrentPassword().sendKeys(currentPass);		
		Thread.sleep(2000);
		getSaveBtn().click();

	}

}

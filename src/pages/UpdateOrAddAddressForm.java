package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class UpdateOrAddAddressForm {

	WebDriver driver;
	WebElement name, lastName, address, city, postalCode, phoneHome, addressTitle, saveBtn;
	Select state;
//	List<WebElement> deleteBtns;  // moved to MyAccountPage

	public UpdateOrAddAddressForm(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public WebElement getName() {
		return driver.findElement(By.id("firstname"));
	}

	public WebElement getLastName() {
		return driver.findElement(By.id("lastname"));
	}

	public WebElement getAddress() {
		return driver.findElement(By.id("address1"));
	}

	public WebElement getCity() {
		return driver.findElement(By.id("city"));
	}

	public WebElement getPostalCode() {
		return driver.findElement(By.id("postcode"));
	}

	public WebElement getPhoneHome() {
		return driver.findElement(By.id("phone"));
	}

	public WebElement getSaveBtn() {
		return driver.findElement(By.id("submitAddress"));
	}

	public WebElement getAddressTitle() {
		return driver.findElement(By.id("alias"));
	}

	public Select getState() {
		return state = new Select(driver.findElement(By.name("id_state")));
	}
	

//	public List<WebElement> getDeleteBtns() {
//		return deleteBtns;
//	}

	public void updateAddress(String firstName, String lastName, String address, String city, String zipCode,
			String phone) throws InterruptedException {
		getName().clear();
		getName().sendKeys(firstName);
		getLastName().clear();
		getLastName().sendKeys(lastName);
		getAddress().clear();
		getAddress().sendKeys(address);
		getCity().clear();
		getCity().sendKeys(city);
		getPostalCode().clear();
		getPostalCode().sendKeys(zipCode);
		getPhoneHome().clear();
		getPhoneHome().sendKeys(phone);
		Thread.sleep(2000);
		getSaveBtn().click();

	}

	public void addAddress(String address, String city, String zipCode, String phone,String state, String title)
			throws InterruptedException {

		getAddress().clear();
		getAddress().sendKeys(address);
		getCity().clear();
		getCity().sendKeys(city);
		getPostalCode().clear();
		getPostalCode().sendKeys(zipCode);
		getPhoneHome().clear();
		getPhoneHome().sendKeys(phone);
		getState().selectByVisibleText(state);
		getAddressTitle().clear();
		getAddressTitle().sendKeys(title);
		Thread.sleep(5000);
		getSaveBtn().click();

	}

	public List<String> checkFields() {
		List<WebElement> updateFields = driver.findElements(By.className("form-control"));
		List<String> fieldsValue = new ArrayList<String>();
		for (int i = 0; i < updateFields.size(); i++) {
			fieldsValue.add(updateFields.get(i).getText());
		}
		return fieldsValue;
	}

	public boolean assertFields(List<String> fieldsValue) {
		int counter = 0;
		for (int i = 0; i < checkFields().size(); i++) {
			if (checkFields().get(i).equals(fieldsValue.get(i))) {
				counter++;
			}
		}

		if (counter > 0) {
			return true;
		} else {
			return false;
		}
	}
	
}

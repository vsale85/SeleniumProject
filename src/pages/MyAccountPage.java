package pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyAccountPage {

	WebDriver driver;
	WebElement myAddresses;
	WebElement myWishList;
	WebElement myPersonalInfo;
	WebElement updateBtn;
	List<WebElement> deleteBtn;
	WebElement addAddress;

	public MyAccountPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public WebElement getMyAddresses() { // custom xpath
		return driver
				.findElement(By.xpath("//a[@href=\"http://automationpractice.com/index.php?controller=addresses\"]"));
	}

	public WebElement getMyWishList() { // custom xpath
		return driver.findElement(By.xpath(
				"//a[@href=\"http://automationpractice.com/index.php?fc=module&module=blockwishlist&controller=mywishlist\"]"));
	}

	public WebElement getMyPersonalInfo() { // custom xpath
		return driver
				.findElement(By.xpath("//a[@href=\"http://automationpractice.com/index.php?controller=identity\"]"));
	}

	public WebElement getUpdateBtn() {
		return driver.findElement(By
				.xpath("//a[@href=\"http://automationpractice.com/index.php?controller=address&id_address=444519\"]"));
	}

	
	public List<WebElement> getDeleteBtn() {
		return driver.findElements(By.xpath(
				"//a[@title=\"Delete\"]"));
	}

	public WebElement getAddAddress() {
		return driver
				.findElement(By.xpath("//a[@href=\"http://automationpractice.com/index.php?controller=address\"]"));
	}

	public void navigateToMyAddresses() {
		getMyAddresses().click();
	}

	public void navigateToUpdate() {
		getUpdateBtn().click();

	}

	public void navigateToAddNewAddress() {
		getAddAddress().click();

	}
	public void deleteLastAddress() {
		
	}
}

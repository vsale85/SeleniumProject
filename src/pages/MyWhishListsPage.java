package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyWhishListsPage {

	WebDriver driver;
	WebElement listName;
	WebElement saveListBtn;
	WebElement deleteListBtn;
	List<WebElement> deleteListsBtn;

	public MyWhishListsPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	// GETTERS
	public WebElement getListName() {
		return driver.findElement(By.id("name"));
	}

	public WebElement getSaveListBtn() {
		return driver.findElement(By.id("submitWishlist"));
	}

	public WebElement getDeleteListBtn() {
		int lastBtn = countWishLists() - 1; // last index in list of TR's
		return getDeleteLists().get(lastBtn).findElement(By.className("icon")); // target deleteBtn from TR tag

	}

	public List<WebElement> getDeleteLists() {
		// return driver.findElements(By.tagName("tr"));
		return driver.findElements(By.xpath("//tr[starts-with(@id ,'wishlist')]"));
	}

	// METHODS
	public int countWishLists() {

		return getDeleteLists().size();

	}

	public void addWhishlist(String listName) throws InterruptedException {
		getListName().clear();
		getListName().sendKeys(listName);
		getSaveListBtn().click();
		Thread.sleep(2000);
	}

	public void deleteWhishlist() throws InterruptedException {
		if (countWishLists() > 0) {
			getDeleteListBtn().click();
			driver.switchTo().alert().accept(); // OK JS alert popup confirmation
			Thread.sleep(2000);
		}
	}

	public void deleteAllWhishlists() throws InterruptedException {
		if (countWishLists() > 0) {
			for (int i = 0; i < countWishLists(); i++) {
				System.out.println(getDeleteLists().size());
				getDeleteListBtn().click();
				driver.switchTo().alert().accept();
				Thread.sleep(3000);
				System.out.println(getDeleteLists().size());
			}
		}

	}

}

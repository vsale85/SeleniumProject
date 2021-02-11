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
		int lastBtn = countWishLists() - 1;  // last index in list of TR's
		return	getDeleteLists().get(lastBtn).findElement(By.className("icon")); // target deleteBtn from TR tag
	
	}
	
	
	public List<WebElement> getDeleteLists() {
		return driver.findElements(By.tagName("tr"));
	}

	// METHODS
	public int countWishLists() {
		System.out.println(getDeleteLists().size());
		return getDeleteLists().size();
		
	}
	public void addWhishlist(String listName) {
		getListName().clear();
		getListName().sendKeys(listName);
		getSaveListBtn().click();
	}
	public void deleteWhishlist() {
		if (countWishLists() > 1) {
			getDeleteListBtn().click();
			driver.switchTo().alert().accept();  // OK JS alert popup confirmation 
		}
		
	}
	
}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Authentication {

	WebDriver driver;
	WebElement username;
	WebElement password;
	WebElement signInBtn;
	WebElement alert;
	WebElement logOut;
	
	public Authentication(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public WebElement getUsername() {
		return driver.findElement(By.id("email"));
	}

	public WebElement getPassword() {
		return driver.findElement(By.id("passwd"));
	}

	public WebElement getSignInBtn() {
		return driver.findElement(By.id("SubmitLogin"));
	}
	
	public WebElement getAlert() {
		return driver.findElement(By.className("alert"));
	}
	

	public WebElement getLogOut() {
		return driver.findElement(By.className("logout"));
	}

	public void logIn(String email, String password) throws InterruptedException {
		getUsername().clear();
		getUsername().sendKeys(email);
		Thread.sleep(1000);
		getPassword().clear();
		getPassword().sendKeys(password);
		Thread.sleep(1000);
		getSignInBtn().click();
		Thread.sleep(2000);
		
	}
	public void logOut() throws InterruptedException {
		getLogOut().click();
		Thread.sleep(3000);		
	}
	public boolean isSignOut() {
		if (getSignInBtn().isDisplayed()) {
			return true;
		}else {
			return false;
		}
	}
	public boolean isLoged() {
		if (getLogOut().isDisplayed()) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean isAlertMsg() {
		if(getAlert().isDisplayed()) {
			return true;
		}else {
			return false;
		}
	}
	
	
}

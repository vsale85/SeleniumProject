package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {

	WebDriver driver;
	WebElement signIn;
	WebElement myAccountPage;
	
	public MainPage(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	public WebElement getSignIn() {
		return driver.findElement(By.className("login"));
	}


	public WebElement getMyAccountPage() {
		return driver.findElement(By.className("account"));
	}

	public void navigateToSignIn() {
		getSignIn().click();
	}
	
	public void navigateToMyAccount() {
		getSignIn().click();
	}
	
}

package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogInTests extends TestBase{
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		driver.navigate().to("http://automationpractice.com/index.php");
		Thread.sleep(3000);
	}
	
	@Test (priority = 5)
	public void validCredentials() throws InterruptedException {
		String email = reader.getCellData("TC1", 11, 4);
		String password = reader.getCellData("TC1", 12, 4);
		
		System.out.println(email + " " + password);
		mainPage.navigateToSignIn();
		authPage.logIn(email, password);
		
		assertTrue(authPage.isLoged());
	}
	@Test (priority = 10)
	public void invalidCredentials() throws InterruptedException {
		String email = reader.getCellData("TC1", 8, 4);
		String password = reader.getCellData("TC1", 9, 4);
		
		System.out.println(email + " " + password);
		mainPage.navigateToSignIn();
		authPage.logIn(email, password);
		
		assertTrue(authPage.isAlertMsg());
		
	}
	@Test (priority = 15)
	public void emptyCredentials() throws InterruptedException {
		
		mainPage.navigateToSignIn();
		authPage.logIn("", "");
		
		assertTrue(authPage.isAlertMsg());
		
	}
	@Test (priority = 20)
	public void logOut() throws InterruptedException {
		validCredentials();
		authPage.logOut();
		
		assertTrue(authPage.isSignOut());
		
	}
	
	@AfterMethod
	public void afterMethod() {
		driver.manage().deleteAllCookies();
	}
}

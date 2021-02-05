package tests;

import org.testng.annotations.Test;

public class LogInTests extends TestBase{
	
	@Test
	public void logIn() throws InterruptedException {
		driver.navigate().to("https://www.saucedemo.com/index.html");
		Thread.sleep(3000);
	}
}

package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class TestBase {
	WebDriver driver;
	
	@BeforeClass
	public void beforeClass() {

		System.setProperty("webdriver.chrome.driver", "driver-lib\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

	}

	@AfterClass
	public void afterClass() {
		 driver.close();

	}
}

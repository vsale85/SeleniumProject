package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import pages.Authentication;
import pages.ExcelReader;
import pages.MainPage;
import pages.MyAccountPage;
import pages.UpdateOrAddAddressForm;

public class TestBase {
	WebDriver driver;
	MainPage mainPage;
	Authentication authPage;
	ExcelReader reader;
	MyAccountPage myAccount;
	UpdateOrAddAddressForm updateOrAddForm;

	// function for login
	public void login() throws InterruptedException {
		String email = reader.getCellData("TC1", 11, 4);
		String password = reader.getCellData("TC1", 12, 4);

		System.out.println(email + " " + password);
		mainPage.navigateToSignIn();
		authPage.logIn(email, password);
	}

	@BeforeClass
	public void beforeClass() throws IOException {

		System.setProperty("webdriver.chrome.driver", "driver-lib\\chromedriver.exe");
		driver = new ChromeDriver();
		mainPage = new MainPage(driver);
		authPage = new Authentication(driver);
		reader = new ExcelReader("data/TestPlan.xlsx");
		myAccount = new MyAccountPage(driver);
		updateOrAddForm = new UpdateOrAddAddressForm(driver);

		driver.manage().window().maximize();

	}

	@AfterClass
	public void afterClass() throws InterruptedException {

		Thread.sleep(5000);
	//	driver.quit();

	}
}

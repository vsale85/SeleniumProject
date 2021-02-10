package tests;

import static org.testng.Assert.assertTrue;

import org.apache.poi.examples.xwpf.usermodel.UpdateEmbeddedDoc;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MypersonalInfoTest extends TestBase{

	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		driver.navigate().to("http://automationpractice.com/index.php");
		mainPage.navigateToMyAccount();

		Thread.sleep(3000);
	}
	
	@Test(priority = 5)
	public void updatePersonalInfo() throws InterruptedException {
		login();
		myAccount.navigateToPersonalInfo();
		Thread.sleep(2000);
		String firstName = reader.getCellData("TC4", 3, 4);
		String lastName = reader.getCellData("TC4", 4, 4);
		String email = reader.getCellData("TC4", 5, 4);
		String currentPass = reader.getCellData("TC4", 6, 4);
		myPersonalInfo.updatePersonalInfo(firstName, lastName, email, currentPass);
		assertTrue(myPersonalInfo.getConfirmationMsg().isDisplayed());
		updateToOriginPersonalInfo();
	}
	@AfterMethod
	public void afterMethod() {
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
	}
	public void updateToOriginPersonalInfo() throws InterruptedException {
		
		myAccount.backToAccount();
		myAccount.navigateToPersonalInfo();
		String firstName = reader.getCellData("TC4", 3, 2);
		String lastName = reader.getCellData("TC4", 4, 2);
		String email = reader.getCellData("TC4", 5, 2);
		String currentPass = reader.getCellData("TC4", 6, 2);
		myPersonalInfo.updatePersonalInfo(firstName, lastName, email, currentPass);

	}
}

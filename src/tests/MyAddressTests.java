package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MyAddressTests extends TestBase {
	// back first address to origin data
	public void updateToOriginAddress() throws InterruptedException {
		String firstName = reader.getCellData("TC2", 4, 2);
		String lastName = reader.getCellData("TC2", 5, 2);
		String address = reader.getCellData("TC2", 6, 2);
		String city = reader.getCellData("TC2", 7, 2);
		String zipCode = reader.getCellData("TC2", 8, 2);
		String homePhone = reader.getCellData("TC2", 9, 2);

		updateOrAddForm.updateAddress(firstName, lastName, address, city, zipCode, homePhone);

	}

	public void addAddress() throws InterruptedException {

		myAccount.navigateToMyAddresses();
		myAccount.navigateToAddNewAddress();
		Thread.sleep(2000);
		String address = reader.getCellData("TC3", 4, 4);
		String city = reader.getCellData("TC3", 5, 4);
		String zipCode = reader.getCellData("TC3", 6, 4);
		String homePhone = reader.getCellData("TC3", 7, 4);
		String state = reader.getCellData("TC3", 8, 4);
		String addressTitle = reader.getCellData("TC3", 9, 4);
		updateOrAddForm.addAddress(address, city, zipCode, homePhone, state, addressTitle);
		Thread.sleep(2000);

	}

	@BeforeMethod
	public void setUp() throws InterruptedException {
		driver.navigate().to("http://automationpractice.com/index.php");
		mainPage.navigateToMyAccount();

		Thread.sleep(3000);
	}

	// @Test(priority = 5)
	public void updateAddress() throws InterruptedException {
		login();
		myAccount.navigateToMyAddresses();
		myAccount.navigateToUpdate();
		Thread.sleep(2000);
		List<String> oldFields = new ArrayList<String>();
		oldFields.addAll(updateOrAddForm.checkFields());

		String firstName = reader.getCellData("TC2", 4, 4);
		String lastName = reader.getCellData("TC2", 5, 4);
		String address = reader.getCellData("TC2", 6, 4);
		String city = reader.getCellData("TC2", 7, 4);
		String zipCode = reader.getCellData("TC2", 8, 4);
		String homePhone = reader.getCellData("TC2", 9, 4);

		updateOrAddForm.updateAddress(firstName, lastName, address, city, zipCode, homePhone);
		Thread.sleep(2000);
		assertTrue(updateOrAddForm.assertFields(oldFields));
		updateToOriginAddress();

	}

	@Test(priority = 10)
	public void addNewAddress() throws InterruptedException {
		login();
		addAddress();

	}

	@Test(priority = 15)
	public void deleteAddress() throws InterruptedException {
		login();
		int initialNumOfAddress = 1;
		myAccount.navigateToMyAddresses();
		if (myAccount.countDeleteAddressBtn() > 1) {

			initialNumOfAddress = myAccount.countDeleteAddressBtn();
			myAccount.deleteLastAddress();
			assertEquals(myAccount.countDeleteAddressBtn(), initialNumOfAddress - 1);
		} else {
			addAddress();
			Thread.sleep(2000);
			myAccount.deleteLastAddress();
			assertEquals(initialNumOfAddress, 1);
		}

	}

	@AfterMethod
	public void afterMethod() {
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
	}

}

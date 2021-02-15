package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WishListTests extends TestBase{
	
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		driver.navigate().to("http://automationpractice.com/index.php");
		mainPage.navigateToMyAccount();
		Thread.sleep(3000);
	}
	
	@Test(priority = 5)
	public void addWishList() throws InterruptedException {
		login();
		myAccount.navigateToMyWhishLists();
		int numList = wishList.countWishLists() + 1;		
		wishList.addWhishlist(reader.getCellData("TC5", 3, 5));
		assertEquals(wishList.countWishLists(), numList + 1);
	}
	
	@Test(priority = 10)
	public void addmultipleWishLists() throws InterruptedException {
		login();
		myAccount.navigateToMyWhishLists();
		int numList = wishList.countWishLists() + 1;
		wishList.addWhishlist(reader.getCellData("TC5", 7, 5));
		wishList.addWhishlist(reader.getCellData("TC5", 9, 5));
		wishList.addWhishlist(reader.getCellData("TC5", 11, 5));
		assertEquals(wishList.countWishLists(), numList + 3);
	}
	
	@Test(priority = 15)
	public void deleteWishList() throws InterruptedException {
		login();
		myAccount.navigateToMyWhishLists();
		int numList = wishList.countWishLists();
		if (numList < 1) {
			wishList.addWhishlist(reader.getCellData("TC5", 3, 5));
			wishList.deleteWhishlist();
			assertEquals(wishList.countWishLists(), numList - 1);
		}else {
			wishList.deleteWhishlist();
			assertEquals(wishList.countWishLists(), numList - 1);
		}
		wishList.deleteAllWhishlists();
		
	}
	
	@AfterMethod
	public void afterMethod() {
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
	}
}

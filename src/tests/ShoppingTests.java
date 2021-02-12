package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ShoppingTests extends TestBase{
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		driver.navigate().to("http://automationpractice.com/index.php");
		mainPage.navigateToMyAccount();
		Thread.sleep(3000);
	}
	
	@Test(priority = 5)
	public void addToCartOneProduct() throws InterruptedException {
		login();
		myAccount.navigateToHome();
		Thread.sleep(5000);
		shopping.addToCartOne();
		assertEquals(shopping.countProducts(), 1);
		shopping.deleteProducts();
	}
	
	@Test(priority = 10)
	public void addToCartOneProductQty() throws InterruptedException {
		login();
		myAccount.navigateToHome();
		shopping.addToCartOneQuantity();
		assertEquals(shopping.productQuantity(), "3");
		shopping.deleteProducts();
	}
	@Test(priority = 15)
	public void addToCartMultipleProducts() throws InterruptedException {
		login();
		myAccount.navigateToHome();
		shopping.addToCartMulti();
		assertEquals(shopping.countProducts(), 3);
		shopping.deleteProducts();
	}
	
	
	@AfterMethod
	public void afterMethod() {
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
	}
}

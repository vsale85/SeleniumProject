package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShoppingPage {

	WebDriver driver;
	WebElement addToCart1;
	WebElement addToCart2;
	WebElement addToCart3;
	WebElement closePopup;
	WebElement cart;
	WebElement quantity;
	WebElement inputQuantity;
	WebElement more;
	WebElement product1;
	WebElement product2;
	WebElement product3;
	WebElement addQuantity;
	List<WebElement> deleteProduct;
	List<WebElement> numProduct;

	public ShoppingPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	// GETTERS
	public WebElement getAddToCart1() {
		return driver.findElement(By.xpath("//a[@data-id-product=\"1\"]"));
	}

	public WebElement getAddToCart2() {
		return driver.findElement(By.xpath("//a[@data-id-product=\"3\"]"));
	}

	public WebElement getAddToCart3() {
		return driver.findElement(By.xpath("//a[@data-id-product=\"7\"]"));
	}

	public WebElement getClosePopup() {
		return driver.findElement(By.xpath("//span[@title=\"Close window\"]"));
	}

	public WebElement getCart() {
		return driver.findElement(By.className("shopping_cart"));
	}

	public WebElement getQuantity() {
		return driver.findElement(By.className("ajax_cart_quantity"));
	}

	public WebElement getProduct1() {
		return driver.findElement(By.xpath("//img[@title=\"Faded Short Sleeve T-shirts\"]"));

	}

	public WebElement getProduct2() {
		return driver.findElement(By.xpath("//img[@title=\"Printed Dress\"]"));

	}

	public WebElement getProduct3() {
		return driver.findElement(By.xpath("//img[@title=\"Printed Chiffon Dress\"]"));

	}

	public WebElement getAddQuantity() {
		return driver.findElement(By.name("Submit"));
	}

	public List<WebElement> getNumProduct() {
		WebElement cart = driver.findElement(By.className("products"));
		return cart.findElements(By.tagName("dt"));
	}

	public WebElement getMore() {
		return driver.findElement(By.xpath("//*[@id=\"homefeatured\"]/li[1]/div/div[2]/div[2]/a[2]/span"));
	}

	public WebElement getInputQuantity() {
		return driver.findElement(By.id("quantity_wanted"));
	}

	public List<WebElement> getDeleteProduct() {
	//	return driver.findElements(By.className("icon-trash"));
		jsScrollToElement(getCart());
		hoverElement(getCart());
		return driver.findElements(By.className("ajax_cart_block_remove_link"));
	}
	
	// METHODS
	public void jsScrollToElement(WebElement webElement) {
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView();", webElement);
	}

	public void hoverElement(WebElement webElement) {
		Actions actions = new Actions(driver);

		actions.moveToElement(webElement).build().perform();
	}

	public void waiter(WebElement elementToWait) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(elementToWait));
		elementToWait.click();
	}
	
	public void addProduct(WebElement scrollTo, WebElement click) throws InterruptedException {

		jsScrollToElement(scrollTo);
		hoverElement(scrollTo);
		click.click();

	}

	public void addToCartOne() throws InterruptedException {

		addProduct(getProduct1(), getAddToCart1());
		waiter(getClosePopup());
		Thread.sleep(2000);

	}

	public void addToCartOneQuantity() throws InterruptedException {
	
		addProduct(getProduct1(), getMore());
		Thread.sleep(2000);
		getInputQuantity().clear();
		getInputQuantity().sendKeys("3");
		jsScrollToElement(getAddQuantity());
		waiter(getAddQuantity());	
		waiter(getClosePopup());

	}

	public void addToCartMulti() throws InterruptedException {

		addProduct(getProduct1(), getAddToCart1());
		waiter(getClosePopup());
		addProduct(getProduct2(), getAddToCart2());
		waiter(getClosePopup());
		addProduct(getProduct3(), getAddToCart3());
		waiter(getClosePopup());
		System.out.println(getDeleteProduct().size());
	}

	public void navigateToCart() {
		getCart().click();
	}

	public int countProducts() throws InterruptedException {
		jsScrollToElement(getCart());
		hoverElement(getCart());
		Thread.sleep(2000);

		return getNumProduct().size();
	}

	public String productQuantity() throws InterruptedException {
		jsScrollToElement(getCart());
		Thread.sleep(2000);

		return getQuantity().getText();
	}
	public void deleteProducts() throws InterruptedException {
		jsScrollToElement(getCart());
		hoverElement(driver.findElement(By.xpath("//a[@title=\"View my shopping cart\"]")));
		Thread.sleep(5000);
		for (int i = 0; i < getDeleteProduct().size(); i++) {
			getDeleteProduct().get(i).click();
			Thread.sleep(2000);
		}
	}
}

package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ShoppingPage {

	WebDriver driver;
	WebElement addToCart1;
	WebElement addToCart2;
	WebElement addToCart3;
	WebElement closePopup;
	WebElement cart;
	WebElement quantity;
	WebElement product;
	WebElement addQuantity;
	List<WebElement> numProduct;
	Actions actions;

	public ShoppingPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	// GETTERS
	public WebElement getAddToCart1() {
		return driver.findElement(By.xpath("//a[@data-id-product=\"1\"]"));
	}

	public WebElement getAddToCart2() {
		return driver.findElement(By.xpath("//a[@data-id-product=\"2\"]"));
	}

	public WebElement getAddToCart3() {
		return driver.findElement(By.xpath("//a[@data-id-product=\"3\"]"));
	}

	public WebElement getClosePopup() {
		return driver.findElement(By.xpath("//span[@title=\"Close window\"]"));
	}

	public WebElement getCart() {
		return driver.findElement(By.xpath("//a[@href=\"http://automationpractice.com/index.php?controller=order\"]"));
	}

	public WebElement getQuantity() {
		return driver.findElement(By.id("quantity_wanted"));
	}

	public WebElement getProduct() {
		return driver.findElement(By.xpath("//a[@title=\"Faded Short Sleeve T-shirts\"]"));
	}

	public WebElement getAddQuantity() {
		return driver.findElement(By.className("exclusive"));
	}

	public List<WebElement> getNumProduct() {
		WebElement cart = driver.findElement(By.className("shopping_cart"));
		return cart.findElements(By.tagName("dt"));
	}
	

	public Actions getActions() {
		return actions;
	}

	public void setActions(Actions actions) {
		this.actions = new Actions(driver);
	}

	// METHODS
	public void addToCartOne() {
		getActions().moveToElement(getAddToCart1()).perform();
		getAddToCart1().click();
		getClosePopup().click();
	}

	public void addToCartOneQuantity() {
		getProduct().click();
		getQuantity().clear();
		getQuantity().sendKeys("3");
		getAddQuantity().click();
		getClosePopup().click();
	}

	public void addToCartMulti() {
		getAddToCart1().click();
		getAddToCart2().click();
		getAddToCart3().click();
		getClosePopup().click();
	}

	public void navigateToCart() {
		getCart().click();
	}

	public int countProducts() {
		
		actions.moveToElement(getCart()).perform();
		return getNumProduct().size();
	}

	public String productQuantity() {
		return getQuantity().getText();
	}
}

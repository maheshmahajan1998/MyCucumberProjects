package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

	public WebDriver driver;

	public CartPage(WebDriver driver) {
		super();
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	// Cart

	@FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-backpack']")
	WebElement add_first_product;

	@FindBy(xpath = "//button[@id='remove-sauce-labs-backpack']")
	WebElement remove_first_product;

	@FindBy(xpath = "//button[@id='add-to-cart-test.allthethings()-t-shirt-(red)']")
	WebElement add_last_product;

	@FindBy(xpath = "//span[@class='shopping_cart_badge']")
	public static WebElement cart_badge_count;

	@FindBy(xpath = "//a[@class='shopping_cart_link']")
	WebElement click_on_cart;

	@FindBy(xpath = "//*[@class='cart_item']")
	WebElement product_is_available_in_cartBag;

	public void addFirstProduct() {

		add_first_product.click();
	}

	public void addLasttProduct() {

		add_last_product.click();
	}

	public void removeFirstProduct() {

		remove_first_product.click();
		System.out.println("Removed first product from the cart");

	}

	public void clickOnCart() {

		click_on_cart.click();
	}

	public boolean productIsAvailable() {
		return product_is_available_in_cartBag.isDisplayed();
		// System.out.println("Verified added product is available");
	}

}

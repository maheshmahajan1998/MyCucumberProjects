package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

	public WebDriver driver;

	/**
	 * @param driver
	 */
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
	WebElement cart_badge_count;
	
	@FindBy(xpath = "//a[@class='shopping_cart_link']")
	WebElement click_on_cart;
	
	@FindBy(xpath = "//*[@class='cart_item']")
	WebElement product_is_available_in_cartBag;
	
	String a;
	int int1,b;

	public void addFirstProduct() {
		// TODO Auto-generated method stub
		add_first_product.click();
	}
	public void addLasttProduct() {
		// TODO Auto-generated method stub
		add_last_product.click();
	}
	public void removeFirstProduct() {
		// TODO Auto-generated method stub
		remove_first_product.click();
		System.out.println("Removed first product from the cart");

	}
	

	public void verifyCartBadgeCount(Integer int1) {
		// TODO Auto-generated method stub
		a = cart_badge_count.getText();
		b = Integer.parseInt(a);
		if (b == int1) {
			System.out.println("You have " + int1 + " item in your cart");
			System.out.println("Verified the cart badge has " + int1 + " product");
		} else if (b > int1) {
			System.out.println("You have " + b + " item in your cart");
		}
	}
		
	public void verifyCartBadgeValueIncreased() {
		// TODO Auto-generated method stub
		if (b > int1) {
			System.out.println("cart badge value is increased");
		}
	}
	public void clickOnCart() {
		// TODO Auto-generated method stub
		click_on_cart.click();
	}
	
	public boolean verify_the_added_product_is_available()
	{
		return product_is_available_in_cartBag.isDisplayed();
		//System.out.println("Verified added product is available");
	}
	
	
	
}

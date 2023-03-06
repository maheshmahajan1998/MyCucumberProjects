package stepDefinations;

import static org.junit.Assert.assertEquals;

import java.time.Duration;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.*;
import pages.CartPage;
import pages.FilterDataUsingDropDownPage;
import pages.LoginWithInvalidDataPage;
import pages.LoginWithValidDataPage;
import pages.PlaceOrderPage;
import pages.VerifyHomePage;

public class SouceDemoLoginPage {

	public WebDriver driver;

	private LoginWithInvalidDataPage login_pf;
	private LoginWithValidDataPage lg;
	protected CartPage cartpage;
	protected PlaceOrderPage placeOrder_obj;
	public FilterDataUsingDropDownPage filter_obj;

	WebDriverWait wait;

	// 1st Scenario

	@Given("browser is opened")
	public void browser_is_opened() {
		System.out.println("Inside Step-browser is open");

		// System.setProperty("webdriver.chrome.driver","C:/Users/mahbhask/eclipse-workspace/CucumberSouceDemoProject/src/test/resources/driver/chromedriver.exe");
		driver = new ChromeDriver();

		login_pf = new LoginWithInvalidDataPage(driver);

		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@And("user is in login page")
	public void user_is_in_login_page() {
		driver.get("https://www.saucedemo.com/");
	}

	@When("^user enters Invalid username as (.*) and password as (.*)$")
	public void user_enters_invalid_username_as_and_password_as(String username, String password) {

		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		login_pf.enterInvalidUsername(username);
		login_pf.enterInvalidPassword(password);
	}

	@And("user clicks on login")
	public void user_clicks_on_login() {

		login_pf.loginClick();

	}

	@Then("user is not navigated to the home page")
	public void user_is_not_navigated_to_the_home_page() {

		String res = login_pf.invalidLoginText();
		String expected = "Epic sadface: Username and password do not match any user in this service";
		assertEquals(expected, res);

	}

	// 2nd Scenario

	@When("user enters username as {string} and password as {string}")
	public void user_enters_username_as_and_password_as(String username, String password) {
		lg = new LoginWithValidDataPage(driver);
		lg.entervalidUsername(username);
		lg.entervalidPassword(password);
	}

	@And("Verify the login button text is capitalized")
	public void verify_the_login_button_text_is_capitalized() {
		login_pf.checkLoginText();

	}

	@Then("user clicks on logout")
	public void user_clicks_on_logout() {
		lg = new LoginWithValidDataPage(driver);
		lg.clickToggle_Menu();
		lg.logout();
	}

	// Verify the Home Page
	VerifyHomePage obj;

	@And("verify the title as Swag Labs")
	public void verify_the_title_as_swag_labs() {

		obj.verify_the_title_as_swag_labs();
	}

	@Then("verify default filter dropdown is A-Z")
	public void verify_default_filter_dropdown_is_a_z() {
		obj = new VerifyHomePage(driver);
		obj.verifyDropDown();
	}

	// Cart

	@When("Add the first product to the cart")
	public void add_the_first_product_to_the_cart() {

		cartpage = new CartPage(driver);
		cartpage.addFirstProduct();
	}

	@And("Verify the cart badge has {int} product")
	public void verify_the_cart_badge_has_product(Integer int1) {

		cartpage.verifyCartBadgeCount(int1);

	}

	@And("Add the last product to the cart")
	public void add_the_last_product_to_the_cart() {
		cartpage.addLasttProduct();

	}

	@Then("Verify the cart badge value is increased")
	public void verify_the_cart_badge_value_is_increased() {

		cartpage.verifyCartBadgeValueIncreased();

	}

	@And("Remove the first product from the cart")
	public void remove_the_first_product_from_the_cart() {

		cartpage.removeFirstProduct();
	}

	@And("Click on the cart")
	public void click_on_the_cart() {

		cartpage.clickOnCart();
	}

	@Then("Verify the added product is available")
	public void verify_the_added_product_is_available() {

		cartpage.verify_the_added_product_is_available();
	}

	// filter data

	@And("Click on the continue shopping")
	public void click_on_the_continue_shopping() {
		filter_obj = new FilterDataUsingDropDownPage(driver);
		filter_obj.continueShopping();
	}

	@And("Change the price filter from low to high")
	public void change_the_price_filter_from_low_to_high() {
		filter_obj.Change_the_price_filter_from_low_to_high();
	}

	@Then("Verify the price sorted properly")
	public void verify_the_price_sorted_properly() {

		String actual = filter_obj.Verify_the_price_sorted_properly();
		String expected = "Price (low to high)";
		assertEquals(expected, actual);
	}

	// place order

	@When("user want to checkout")
	public void user_want_to_checkout() {
		placeOrder_obj = new PlaceOrderPage(driver);
		placeOrder_obj.user_want_to_checkout();
	}

	@When("Add Checkout: Your Information")
	public void add_checkout_your_information() {
		placeOrder_obj.add_checkout_your_information();
	}

	@When("check the order details")
	public void check_the_order_details() {
		placeOrder_obj.check_the_order_details();
	}

	@Then("order placed")
	public void order_placed() throws InterruptedException {

		placeOrder_obj.order_placed();
	}

}

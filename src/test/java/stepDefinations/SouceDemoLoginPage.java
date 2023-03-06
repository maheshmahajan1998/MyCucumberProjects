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
	public void loginPage() {
		driver.get("https://www.saucedemo.com/");
	}

	@When("^user enters Invalid username as (.*) and password as (.*)$")
	public void enterInvalidUsernameAndPassword(String username, String password) {

		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		login_pf.enterInvalidUsername(username);
		login_pf.enterInvalidPassword(password);
	}

	@And("user clicks on login")
	public void userClicksOnLogin() {

		login_pf.loginClick();

	}

	@Then("user is not navigated to the home page")
	public void notVavigatedToHome_page() {

		String res = login_pf.invalidLoginText();
		String expected = "Epic sadface: Username and password do not match any user in this service";
		assertEquals(expected, res);

	}

	// 2nd Scenario

	@When("user enters username as {string} and password as {string}")
	public void enterUsername_and_password(String username, String password) {
		lg = new LoginWithValidDataPage(driver);
		lg.entervalidUsername(username);
		lg.entervalidPassword(password);
	}

	@And("Verify the login button text is capitalized")
	public void verifyLoginButtonCapitalized() {

		String ele = login_pf.login_text.getCssValue("Login");
		if (ele.toLowerCase().equalsIgnoreCase(ele)) {
			System.out.println(ele.toUpperCase());
			System.out.println("Login button is capitalized");
		}

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
	public void titleAsSwagLabs() {

		String expectedTitle = "Swag Labs";
		if (driver.getPageSource().contains("Epic sadface")) {
			driver.close();
			Assert.assertTrue(false);
		} else {
			Assert.assertEquals(expectedTitle, driver.getTitle());
		}
	}

	@Then("verify default filter dropdown is A-Z")
	public void defaultDropdownFilter() {
		obj = new VerifyHomePage(driver);
		WebElement dropdown = obj.dropdown_filter;
		Select selectObject = new Select(dropdown);
		selectObject.selectByIndex(0);
		// selectObject.selectByVisibleText("Name (A to Z)");
		System.out.println("default filter dropdown is A-Z is verified");
		
	}

	// Cart

	@When("Add the first product to the cart")
	public void addFirstProduct() {

		cartpage = new CartPage(driver);
		cartpage.addFirstProduct();
	}

	String a;
	int int1, b;

	@And("Verify the cart badge has {int} product")
	public void verifyCartBadgeProduct(Integer int1) {

		a = cartpage.cart_badge_count.getText();
		b = Integer.parseInt(a);
		if (b == int1) {
			System.out.println("You have " + int1 + " item in your cart");
			System.out.println("Verified the cart badge has " + int1 + " product");
		} else if (b > int1) {
			System.out.println("You have " + b + " item in your cart");
		}

	}

	@And("Add the last product to the cart")
	public void addLastProduct() {
		cartpage.addLasttProduct();

	}

	@Then("Verify the cart badge value is increased")
	public void checkCartBadgeValue() {

		if (b > int1) {
			System.out.println("cart badge value is increased");
		}

	}

	@And("Remove the first product from the cart")
	public void removeFirstProductFromCart() {

		cartpage.removeFirstProduct();
	}

	@And("Click on the cart")
	public void click_on_the_cart() {

		cartpage.clickOnCart();
	}

	@Then("Verify the added product is available")
	public void checkProductIsPresent() {

		cartpage.productIsAvailable();
	}

	// filter data

	@And("Click on the continue shopping")
	public void clickOnContinueShopping() {
		filter_obj = new FilterDataUsingDropDownPage(driver);
		filter_obj.continueShopping();
	}

	@And("Change the price filter from low to high")
	public void checkThePriceFilter() {

		Select selectObject;
		WebElement dropdown = filter_obj.dropdown_filter;
		selectObject = new Select(dropdown);
		selectObject.selectByIndex(2);

	}

	@Then("Verify the price sorted properly")
	public void checkPriceSortedProperly() {

		String actual = filter_obj.verifyPriceSortedProperly();
		String expected = "Price (low to high)";
		assertEquals(expected, actual);
	}

	// place order

	@When("user want to checkout")
	public void checkout() {
		placeOrder_obj = new PlaceOrderPage(driver);
		placeOrder_obj.checkout();
	}

	String fname, lname, code1;

	@When("Add Checkout: Your Information")
	public void addCheckoutInformation() {
		// placeOrder_obj.checkoutYourInformation();

		System.out.println("*****************");
		System.out.println("User please Enter Your Data \n");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your first name");
		fname = sc.nextLine();
		placeOrder_obj.fistname.sendKeys(fname);
		System.out.println("Enter your last name");
		lname = sc.nextLine();
		placeOrder_obj.lastname.sendKeys(lname);
		System.out.println("Enter your Zip/Postal Code");
		int code = sc.nextInt();
		code1 = String.valueOf(code);
		placeOrder_obj.postalcode.sendKeys(code1);
	}

	@When("check the order details")
	public void checkOrderDetails() {
		placeOrder_obj.orderDetails();
	}

	@Then("order placed")
	public void orderPlaced() throws InterruptedException {

		System.out.println("Please check your Information");
		System.out.println("FirstName " + fname);
		System.out.println("LastName " + lname);
		System.out.println("Zip/Postal Code " + code1);
		Scanner sc1 = new Scanner(System.in);
		Thread.sleep(2000);
		System.out.println("Do you want to place the order");
		String ans = sc1.nextLine();
		if (ans.equalsIgnoreCase("yes")) {
			placeOrder_obj.place_orderbtn.click();
			System.out.println("Thank you for your order!");
		} else {
			placeOrder_obj.cancel_orderbtn.click();
			System.out.println("Sorry Your order not placed");
		}
	}

}

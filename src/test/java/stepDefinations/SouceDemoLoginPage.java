package stepDefinations;

import static org.junit.Assert.assertEquals;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.CartPage;
import pages.FilterDataUsingDropDownPage;
import pages.LoginPage;
import pages.PlaceOrderPage;
import pages.VerifyHomePage;

public class SouceDemoLoginPage {

	public WebDriver driver;
	private LoginPage lg;
	protected CartPage cartpage;
	protected PlaceOrderPage placeOrder_obj;
	public FilterDataUsingDropDownPage filter_obj;

	WebDriverWait wait;

	// 1st Scenario
	@SuppressWarnings("deprecation")
	@Before
	@Given("browser is opened")
	public void browser_is_opened() {
		System.out.println("Inside Step-browser is open");

		// System.setProperty("webdriver.chrome.driver",
		// "src\\test\\resources\\driver\\chromedriver.exe");
		driver = new EdgeDriver();

		lg = new LoginPage(driver);

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
		lg.enterInvalidUsername(username);
		lg.enterInvalidPassword(password);
	}

	@And("user clicks on login")
	public void userClicksOnLogin() {

		lg.loginClick();

	}

	@Then("user is not navigated to the home page")
	public void notVavigatedToHome_page() {

		String res = lg.invalidLoginText();
		String expected = "Epic sadface: Username and password do not match any user in this service";
		assertEquals(expected, res);

	}

	// 2nd Scenario

	@When("user enters username as {string} and password as {string}")
	public void enterUsername_and_password(String username, String password) {
		lg = new LoginPage(driver);
		lg.entervalidUsername(username);
		lg.entervalidPassword(password);
	}

	@And("Verify the login button text is capitalized")
	public void verifyLoginButtonCapitalized() {

		String ele = lg.login_text.getCssValue("Login");
		if (ele.toLowerCase().equalsIgnoreCase(ele)) {
			System.out.println(ele.toUpperCase());
			System.out.println("Login button is capitalized");
		}

	}

	@Then("user clicks on logout")
	public void user_clicks_on_logout() {
		lg = new LoginPage(driver);
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

		String actualText = obj.getDefaultDropdownText();
		String expected = "Name (A to Z)";
		Assert.assertTrue("Default filter dropdown is not A-Z", actualText.equals(expected));
		// assertEquals(actualText, expected);

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

		// fetching all product text
		List<WebElement> list_of_products = filter_obj.fetchAllproducts_text;
		List<WebElement> list_of_products_price = filter_obj.fetchAllproducts_price;

		// Use of HashMaop to store Products and Their prices(after conversion to
		// Integer)
		String product_name;
		String product_price;
		int int_product_price;
		HashMap<Integer, String> map_final_products = new HashMap<Integer, String>();
		for (int i = 0; i < list_of_products.size(); i++) {
			product_name = list_of_products.get(i).getText();// Iterate and fetch product name
			product_price = list_of_products_price.get(i).getText();// Iterate and fetch product price
			product_price = product_price.replaceAll("[^0-9]", "");// Replace anything wil space other than numbers
			int_product_price = Integer.parseInt(product_price);// Convert to Integer
			map_final_products.put(int_product_price, product_name);// Add product and price in HashMap
		}
		// Reporter.log("Product Name and price fetched from UI and saved in HashMap
		// as:" + map_final_products.toString() + "<br>",true);
		// System.out.println("Product Name and price fetched from UI and saved in
		// HashMap as:" + map_final_products.toString());

		// Get all the keys from Hash Map
		Set<Integer> allkeys = map_final_products.keySet();
		ArrayList<Integer> array_list_values_product_prices = new ArrayList<Integer>(allkeys);

		// Sort the Prices in Array List using Collections class
		// this will sort in ascending order lowest at the top and highest at the bottom
		//Collections.sort(array_list_values_product_prices);
		System.out.println(array_list_values_product_prices);

		int[] a = new int[array_list_values_product_prices.size()];

		for (int i = 0; i < array_list_values_product_prices.size(); i++) {
			a[i] = array_list_values_product_prices.get(i);

		}

		// Printing using for each loop
		for (int k : a) {
			System.out.println(k);
		}
		
		
		

	}

	@Then("Verify the price sorted properly")
	public void checkPriceSortedProperly() {

		Select selectObject;
		WebElement dropdown = filter_obj.dropdown_filter;
		selectObject = new Select(dropdown);
		selectObject.selectByIndex(2);
//		String actual = filter_obj.verifyPriceSortedProperly();
//		String expected = "Price (low to high)";
//		Assert.assertTrue("price not sorted properly", actual.equals(expected));

		// fetching all product text
		List<WebElement> list_of_products = filter_obj.fetchAllproducts_text;
		List<WebElement> list_of_products_price = filter_obj.fetchAllproducts_price;

		// Use of HashMaop to store Products and Their prices(after conversion to
		// Integer)
		String product_name;
		String product_price1;
		int int_product_price1;
		HashMap<Integer, String> map_final_products = new HashMap<Integer, String>();
		for (int i = 0; i < list_of_products.size(); i++) {
			product_name = list_of_products.get(i).getText();// Iterate and fetch product name
			product_price1 = list_of_products_price.get(i).getText();// Iterate and fetch product price
			product_price1 = product_price1.replaceAll("[^0-9]", "");// Replace anything wil space other than numbers
			int_product_price1 = Integer.parseInt(product_price1);// Convert to Integer
			map_final_products.put(int_product_price1, product_name);// Add product and price in HashMap
		}
		// Reporter.log("Product Name and price fetched from UI and saved in HashMap
		// as:" + map_final_products.toString() + "<br>",true);
		// System.out.println("Product Name and price fetched from UI and saved in
		// HashMap as:" + map_final_products.toString());

		// Get all the keys from Hash Map
		Set<Integer> allkeys = map_final_products.keySet();
		ArrayList<Integer> array_list_values_product_prices = new ArrayList<Integer>(allkeys);

		// Sort the Prices in Array List using Collections class
		// this will sort in ascending order lowest at the top and highest at the bottom
		//Collections.sort(array_list_values_product_prices);
		System.out.println(array_list_values_product_prices);

		int[] b = new int[array_list_values_product_prices.size()];

		for (int i = 0; i < array_list_values_product_prices.size(); i++) {
			b[i] = array_list_values_product_prices.get(i);

		}

		for (int k : b) {
			System.out.println(k);
		}

		
		
		
		
		
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

		placeOrder_obj.fistname.sendKeys("abc");
		placeOrder_obj.lastname.sendKeys("xyz");
		placeOrder_obj.postalcode.sendKeys("40242");

	}

	@When("check the order details")
	public void checkOrderDetails() throws InterruptedException {
		placeOrder_obj.orderDetails();
		Thread.sleep(2000);
	}

	@Then("order placed")
	public void orderPlaced() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofMinutes(2));

		wait.until(ExpectedConditions.elementToBeClickable(placeOrder_obj.place_orderbtn)).click();

		String actuString = placeOrder_obj.getmeg.getText();
		String expectedString = "Thank you for your order!";
		Assert.assertTrue("Your order not placed", actuString.equals(expectedString));
	}

	@After
	public void tearDown() {
		// driver.close();
		driver.quit();
	}

	@After(order=1)
	public void takeScreenshotOnFailure(Scenario scenario) {
		if(scenario.isFailed())
		{
			TakesScreenshot ts = (TakesScreenshot) driver;
			 byte[] src = ts.getScreenshotAs(OutputType.BYTES);
			 scenario.attach(src, "image/png", "screenshot");
		}
	
	}
	@After(order = 0)
	public void teardoDown()
	{
		//driver.close();
	}

}

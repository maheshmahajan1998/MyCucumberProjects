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
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import pages.CartPage;
import pages.FilterDataUsingDropDownPage;
import pages.LoginPage;
import pages.PlaceOrderPage;
import pages.VerifyHomePage;
import utilities.Xls_Reader;

public class SouceDemoLoginPage {

	static WebDriver driver;
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

		ChromeOptions options = new ChromeOptions();
		System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\driver\\chromedriver.exe");
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);

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

	}

	// Cart

	@When("Add the first product to the cart")
	public void addFirstProduct() {

		cartpage = new CartPage(driver);
		cartpage.addFirstProduct();
	}

	int int1, b;

	@And("Verify the cart badge has {int} product")
	public void verifyCartBadgeProduct(Integer int1) {

		String a = cartpage.cart_badge_count.getText();
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

	int i;
	int[] a;
	ArrayList<Integer> list1;
	ArrayList<Integer> list2;

	@And("Change the price filter from low to high")
	public void checkThePriceFilter() {

		List<WebElement> list_of_products_price = filter_obj.fetchAllproducts_price;

		String product_price;
		int int_product_price;
		list1 = new ArrayList<Integer>();

		for (int i = 0; i < list_of_products_price.size(); i++) {
			product_price = list_of_products_price.get(i).getText();
			product_price = product_price.replaceAll("[^0-9]", "");
			int_product_price = Integer.parseInt(product_price);
			// System.out.println(int_product_price);
			list1.add(int_product_price);
		}
		ArrayList<Integer> array_list_values_product_prices = new ArrayList<Integer>(list1);

		a = new int[array_list_values_product_prices.size()];

		for (int i = 0; i < array_list_values_product_prices.size(); i++) {
			a[i] = array_list_values_product_prices.get(i);

			// Assert.assertSame( list2, list1);

		}

		Select selectObject;
		WebElement dropdown = filter_obj.dropdown_filter;
		selectObject = new Select(dropdown);
		selectObject.selectByIndex(2);

	}

	@Then("Verify the price sorted properly")
	public void checkPriceSortedProperly() {

		List<WebElement> list_of_products_price = filter_obj.fetchAllproducts_price;

		String product_price;
		int int_product_price;
		list2 = new ArrayList<Integer>();

		for (int i = 0; i < list_of_products_price.size(); i++) {
			product_price = list_of_products_price.get(i).getText();
			product_price = product_price.replaceAll("[^0-9]", "");
			int_product_price = Integer.parseInt(product_price);
			// System.out.println(int_product_price);
			list2.add(int_product_price);
		}
		ArrayList<Integer> array_list_values_product_prices = new ArrayList<Integer>(list2);

		a = new int[array_list_values_product_prices.size()];

		for (int i = 0; i < array_list_values_product_prices.size(); i++) {
			a[i] = array_list_values_product_prices.get(i);

			Assert.assertSame("price sorted properly", list2, list1);
		}

	}

	// place order

	@When("user want to checkout")
	public void checkout() {
		placeOrder_obj = new PlaceOrderPage(driver);
		placeOrder_obj.checkout();
	}

	// String fname, lname, code1;

	@When("Add Checkout: Your Information")
	public void addCheckoutInformation() {

		Xls_Reader reader = new Xls_Reader("src\\test\\resources\\ExcelData\\userinfo.xlsx");
		String sheetname = "Sheet1";

		int rowCount = reader.getRowCount(sheetname);
//		System.out.println(rowCount);
//		String data=reader.getCellData(sheetname, 0, 2);
//		System.out.println(data);
		for (int rowNum = 2; rowNum <= rowCount; rowNum++) {
			String fname = reader.getCellData(sheetname, "firstname", rowNum);
			String lname = reader.getCellData(sheetname, "lastname", rowNum);
			String postcode = reader.getCellData(sheetname, "postalcode", rowNum);

//			System.out.println(fname+ " " + lname);
//			System.out.println();
//			
			placeOrder_obj.fistname.sendKeys(fname);
			placeOrder_obj.lastname.sendKeys(lname);
			placeOrder_obj.postalcode.sendKeys(postcode);

		}

	}

	@When("check the order details")
	public void checkOrderDetails() throws InterruptedException {
		placeOrder_obj.orderDetails();
		Thread.sleep(2000);
	}

	@Then("order placed")
	public void orderPlaced() throws InterruptedException {
//		wait = new WebDriverWait(driver, Duration.ofMinutes(2));
//
//		wait.until(ExpectedConditions.elementToBeClickable(placeOrder_obj.place_orderbtn)).click();
		placeOrder_obj.place_orderbtn.click();
		String actuString = placeOrder_obj.getmeg.getText();
		String expectedString = "Thank you for your order!";
		Assert.assertTrue("Your order not placed", actuString.equals(expectedString));
	}

	@After
	public void tearDown() {
		// driver.close();
		// driver.quit();
	}

	@After(order = 1)
	public void takeScreenshotOnFailure(Scenario scenario) {
		if (scenario.isFailed()) {
			TakesScreenshot ts = (TakesScreenshot) driver;
			byte[] src = ts.getScreenshotAs(OutputType.BYTES);
			scenario.attach(src, "image/png", "screenshot");
		}

	}

	@After(order = 0)
	public void teardoDown() {
		driver.close();
	}

}

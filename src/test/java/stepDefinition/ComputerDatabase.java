package stepDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import pageFactory.AddComputerPage;
import pageFactory.SearchingDataPage;
import pageFactory.VerifyHomePage;

public class ComputerDatabase {

	WebDriver driver;
	VerifyHomePage verify_obj;
	AddComputerPage addComputer;
	SearchingDataPage search;

	@Before
	//@Given("browser is open")
	public void browser_is_open() {
		System.out.println("Inside Step-browser is open");

		driver = new ChromeDriver();
		verify_obj = new VerifyHomePage(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@And("user nevigate to computer database page")
	public void user_nevigate_to_computer_database_page() {
		driver.get("https://computer-database.gatling.io/computers/");
	}

	@When("Verify the title as Computers database")
	public void verify_the_title_as_computers_database() {

		verify_obj.verify_the_title_as_computers_database();
	}

	@And("Verify the page header is the same as the page title")
	public void verify_the_page_header_is_the_same_as_the_page_title() {

		verify_obj.verify_the_page_header_is_the_same_as_the_page_title();

	}

	@Then("User must see the filter by computer name text box")
	public void user_must_see_the_filter_by_computer_name_text_box() {

		verify_obj.check_filter_by_name();

	}

	@And("User able to see add a new computer button")
	public void user_able_to_see_add_a_new_computer_button() {

		verify_obj.user_able_to_see_add_a_new_computer_button();
	}

	@And("User able to see the filter by name button")
	public void user_able_to_see_the_filter_by_name_button() {

		verify_obj.user_able_to_see_the_filter_by_name_button();
	}

	@And("User able to see the table and the headers as follows")
	public void user_able_to_see_the_table_and_the_headers_as_follows() {
		verify_obj.user_able_to_see_the_table_and_the_headers_as_follows();
	}

	@Then("The user should see the pagination")
	public void the_user_should_see_the_pagination() {
		verify_obj.the_user_should_see_the_pagination();
	}

	// 2nd Scenario

	@When("add a new cumputer")
	public void add_a_new_cumputer() {
		addComputer = new AddComputerPage(driver);
		addComputer.addComputerBtn();
	}

	@And("Click on create this computer")
	public void click_on_create_this_computer() throws InterruptedException {
		addComputer.create_computer();
	}

	@And("User should see the red background on the computer name field")
	public void user_should_see_the_red_background_on_the_computer_name_field() throws InterruptedException {

		addComputer.backgroundColorOnComputerNameField();
	}

	@Then("Enter the computer name")
	public void enter_the_computer_name() throws InterruptedException {
		addComputer.computer_name();
	}

	@And("Select the company as Nokia")
	public void select_the_company_as_nokia() throws InterruptedException {
		addComputer.company_name();
	}

	@And("Submit the form")
	public void submit_the_form() throws InterruptedException {
		addComputer.click_sumbit();
	}

	@Then("Successful message should be displayed")
	public void successful_message_should_be_displayed() throws InterruptedException {
		addComputer.successful();
	}

	// 3rd Scenario

	@When("After adding the computer count should be increased")
	public void after_adding_the_computer_count_should_be_increased() {
		addComputer.afterAddingcom_coumputerFoundCount();
	}

	@And("Search the created data")
	public void search_the_created_data() throws InterruptedException {
		search = new SearchingDataPage(driver);
		Thread.sleep(2000);
		search.searchAddedComputer();
	}

	@Then("result should be visible")
	public void result_should_be_visible() {

	}
	
	@After
	public void tearDown()
	{
		
		driver.quit();
	}

}

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
	public void nevigateToComputer_database_page() {
		driver.get("https://computer-database.gatling.io/computers/");
	}

	@When("Verify the title as Computers database")
	public void checkTitleAsComputersDatabase() {

		verify_obj.verifyTheTitle();
	}

	@And("Verify the page header is the same as the page title")
	public void checkPageHeaderAndPageTitle() {

		verify_obj.verifyThePageHeaderIsSameAsThePage_title();

	}

	@Then("User must see the filter by computer name text box")
	public void computerNamefilterByText() {

		verify_obj.filterByNnameText();

	}

	@And("User able to see add a new computer button")
	public void addNewComputerButton() {

		verify_obj.addNewComputer();
	}

	@And("User able to see the filter by name button")
	public void checkFilterByNameBtn() {

		verify_obj.filterByNameBtn();
	}

	@And("User able to see the table and the headers as follows")
	public void checkTheTable() {
		verify_obj.tableIsPresent();
	}

	@Then("The user should see the pagination")
	public void paginationIsPresent() {
		verify_obj.seeThePagination();
	}

	// 2nd Scenario

	@When("add a new cumputer")
	public void addNewCumputer() {
		addComputer = new AddComputerPage(driver);
		addComputer.addComputerBtn();
	}

	@And("Click on create this computer")
	public void clickOnCreateThisComputer()  {
		addComputer.create_computer();
	}

	@And("User should see the red background on the computer name field")
	public void checkBackgroundColor() throws InterruptedException {

		addComputer.backgroundColorOnComputerNameField();
	}

	@Then("Enter the computer name")
	public void addComputerName() throws InterruptedException {
		addComputer.computer_name();
	}

	@And("Select the company as Nokia")
	public void selectTheCompany() throws InterruptedException {
		addComputer.company_name();
	}

	@And("Submit the form")
	public void submitForm() throws InterruptedException {
		addComputer.click_sumbit();
	}

	@Then("Successful message should be displayed")
	public void CheckSuccessfulMessaged() throws InterruptedException {
		addComputer.successful();
	}

	// 3rd Scenario

	@When("After adding the computer count should be increased")
	public void after_adding_the_computer_count_should_be_increased() {
		addComputer.afterAddingcom_coumputerFoundCount();
	}

	
	
	@After
	public void tearDown()
	{
		
		driver.quit();
	}

}

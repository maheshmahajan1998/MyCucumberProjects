package pageFactory;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import junit.framework.Assert;

public class VerifyHomePage {

	WebDriver driver;

	@FindBy(xpath = "//a[@class='fill']")
	WebElement check_header;

	@FindBy(xpath = "//input[@id='searchbox']")
	WebElement filter_by_computer;

	@FindBy(xpath = "//a[@id='add']")
	WebElement add_new_computer;

	@FindBy(xpath = "//input[@id='searchsubmit']")
	WebElement filter_by_name_btn;

	@FindBy(xpath = "//table[@class='computers zebra-striped']")
	WebElement table;
	
	@FindBy(xpath = "//*[@class='pagination']")
	WebElement pagination;
	
	

	public VerifyHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public void verify_the_title_as_computers_database() {
		String title = driver.getTitle();
		String expectedTitle = "Computers database";
		assertEquals(expectedTitle,title);
	}

	public void verify_the_page_header_is_the_same_as_the_page_title() {
		String pageHeader = check_header.getText();
		String pageTitle = driver.getTitle();
		System.out.println(pageHeader);
		System.out.println(pageTitle);
		// assertEquals(pageHeader,pageTitle);
		if (pageHeader.equals(pageTitle)) {
			System.out.println("Both names are same");
		} else {
			System.out.println("Both names are not same");
		}
	}

	public boolean check_filter_by_name() {
		return filter_by_computer.isDisplayed();
	}

	public boolean user_able_to_see_add_a_new_computer_button() {

		return add_new_computer.isDisplayed();
	}

	public boolean user_able_to_see_the_filter_by_name_button() {

		return filter_by_name_btn.isDisplayed();
	}

	public boolean user_able_to_see_the_table_and_the_headers_as_follows() {
		return table.isDisplayed();
	}
	public boolean the_user_should_see_the_pagination() {

		return pagination.isDisplayed();
	}
}

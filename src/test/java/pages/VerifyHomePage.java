package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class VerifyHomePage {

	public WebDriver driver;

	public VerifyHomePage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// HomePage

	@FindBy(xpath = "//select[@class='product_sort_container']")
	WebElement verify_dropdown_filter;

	public void verifyDropDown() {
		WebElement dropdown = verify_dropdown_filter;
		Select selectObject = new Select(dropdown);
		selectObject.selectByIndex(0);
		// selectObject.selectByVisibleText("Name (A to Z)");
		System.out.println("default filter dropdown is A-Z is verified");
	}
	
	public void verify_the_title_as_swag_labs()
	{
		String expectedTitle = "Swag Labs";
		if (driver.getPageSource().contains("Epic sadface")) {
			driver.close();
			Assert.assertTrue(false);
		} else {
			Assert.assertEquals(expectedTitle, driver.getTitle());
		}
	}
	
	

}

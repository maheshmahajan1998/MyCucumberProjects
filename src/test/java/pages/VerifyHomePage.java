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
	public
	WebElement dropdown_filter;

	
	
	
	
	

}

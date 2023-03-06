package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class FilterDataUsingDropDownPage {

	public WebDriver driver;

	/**
	 * @param driver
	 */
	public FilterDataUsingDropDownPage(WebDriver driver) {
		super();
		this.driver = driver;
		
		PageFactory.initElements(driver,this);	
	}
	
	@FindBy(xpath = "//button[@id='continue-shopping']")
	WebElement continue_shoppingbtn;
	

	@FindBy(xpath = "//select[@class='product_sort_container']")
	public
	WebElement dropdown_filter;

	@FindBy(xpath = "//option[@value='lohi']")
	WebElement fetch_price;
	
	public void continueShopping()
	{
		continue_shoppingbtn.click();
	}
	
	public String verifyPriceSortedProperly()
	{
		return fetch_price.getText();	 
	}
}

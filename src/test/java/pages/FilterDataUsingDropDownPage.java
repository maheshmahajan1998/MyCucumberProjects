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
	WebElement verify_dropdown_filter;

	@FindBy(xpath = "//option[@value='lohi']")
	WebElement check_price_low_to_high_btn;
	
	public void continueShopping()
	{
		continue_shoppingbtn.click();
	}
	Select selectObject;
	public void Change_the_price_filter_from_low_to_high() {
		WebElement dropdown = verify_dropdown_filter;
		 selectObject = new Select(dropdown);
		selectObject.selectByIndex(2);	
	}
	
	public String Verify_the_price_sorted_properly()
	{
		return check_price_low_to_high_btn.getText();
		 
	}
}

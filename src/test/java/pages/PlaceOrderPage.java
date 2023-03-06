package pages;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PlaceOrderPage {
	public WebDriver driver;

	public PlaceOrderPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	// place order

		@FindBy(xpath = "//button[@name='checkout']")
		WebElement checkout_btn;
		
		@FindBy(xpath = "//input[@id='first-name']")
		public
		WebElement fistname;
		
		@FindBy(xpath = "//input[@id='last-name']")
		public
		WebElement lastname;
		
		@FindBy(xpath = "//input[@id='postal-code']")
		public
		WebElement postalcode;
		
		@FindBy(xpath = "//input[@id='continue']")
		public
		WebElement continue_btn;
		
		@FindBy(xpath = "//button[@class='btn btn_action btn_medium cart_button']")
		public
		WebElement place_orderbtn;
		
		@FindBy(xpath = "//button[@class='btn btn_secondary back btn_medium cart_cancel_link']")
		public
		WebElement cancel_orderbtn;
		
		public void checkout()
		{
			checkout_btn.click();
		}
		
		public void orderDetails()
		{
			continue_btn.click();
		}
		
		
}

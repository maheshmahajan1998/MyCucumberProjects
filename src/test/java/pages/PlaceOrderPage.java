package pages;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PlaceOrderPage {
	public WebDriver driver;

	/**
	 * @param driver
	 */
	public PlaceOrderPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	// place order

		@FindBy(xpath = "//button[@name='checkout']")
		WebElement checkout_btn;
		
		@FindBy(xpath = "//input[@id='first-name']")
		WebElement fistname;
		
		@FindBy(xpath = "//input[@id='last-name']")
		WebElement lastname;
		
		@FindBy(xpath = "//input[@id='postal-code']")
		WebElement postalcode;
		
		@FindBy(xpath = "//input[@id='continue']")
		WebElement continue_btn;
		
		@FindBy(xpath = "//button[@class='btn btn_action btn_medium cart_button']")
		WebElement place_orderbtn;
		
		@FindBy(xpath = "//button[@class='btn btn_secondary back btn_medium cart_cancel_link']")
		WebElement cancel_orderbtn;
		
		public void user_want_to_checkout()
		{
			checkout_btn.click();
		}
		String fname, lname, code1;
		
		public void add_checkout_your_information()
		{
			System.out.println("*****************");
			System.out.println("User please Enter Your Data \n");
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter your first name");
			fname = sc.nextLine();
			fistname.sendKeys(fname);
			System.out.println("Enter your last name");
			lname = sc.nextLine();
			lastname.sendKeys(lname);
			System.out.println("Enter your Zip/Postal Code");
			int code = sc.nextInt();
			code1 = String.valueOf(code);
			postalcode.sendKeys(code1);
		}
		public void check_the_order_details()
		{
			continue_btn.click();
		}
		
		public void order_placed() throws InterruptedException
		{
			System.out.println("Please check your Information");
			System.out.println("FirstName " + fname);
			System.out.println("LastName " + lname);
			System.out.println("Zip/Postal Code " + code1);
			Scanner sc1 = new Scanner(System.in);
			Thread.sleep(2000);
			System.out.println("Do you want to place the order");
			String ans = sc1.nextLine();
			if (ans.equalsIgnoreCase("yes")) {
				place_orderbtn.click();
				System.out.println("Thank you for your order!");
			} else {
				cancel_orderbtn.click();
				System.out.println("Sorry Your order not placed");
			}

		}
		
}

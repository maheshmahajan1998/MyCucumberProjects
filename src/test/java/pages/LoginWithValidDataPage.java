package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginWithValidDataPage {

WebDriver driver;
	
	public LoginWithValidDataPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	//Login
	
	@FindBy(id = "user-name")
	WebElement txt_username;

	@FindBy(id = "password")
	WebElement txt_password;

	@FindBy(xpath = "//input[@id='login-button']")
	WebElement txt_login;
	
	@FindBy(css = "#login-button")
	WebElement login_text;
	
	@FindBy(xpath = "//*[@class='bm-burger-button']")
	WebElement toggle_menu;
	
	@FindBy(xpath = "//a[@id='logout_sidebar_link']")
	WebElement logout;
	
	

	public void entervalidUsername(String username) {
		txt_username.sendKeys(username);
	}

	public void entervalidPassword(String password) {
		txt_password.sendKeys(password);
	}
	public void loginClick()
	{
		
		txt_login.click();
	}
	public void checkLoginText()
	{
		String ele = login_text.getCssValue("Login");
		if (ele.toLowerCase().equalsIgnoreCase(ele)) {
			System.out.println(ele.toUpperCase());
			System.out.println("Login button is capitalized");
		}
	}

	public void clickToggle_Menu()
	{
		toggle_menu.click();
	}
	public void logout()
	{
		logout.click();
	}
	
}

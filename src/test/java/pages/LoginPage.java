package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import read.ReadLogin;

public class LoginPage {

WebDriver driver;

public ReadLogin lg;
	
	public LoginPage(WebDriver driver)
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
	public
	WebElement login_text;
	
	@FindBy(xpath = "//*[@class='bm-burger-button']")
	WebElement toggle_menu;
	
	@FindBy(xpath = "//a[@id='logout_sidebar_link']")
	WebElement logout;
	
	@FindBy(xpath ="//h3[@data-test='error']" )
	WebElement invalid_login_error;
	
	public void enterInvalidUsername(String username) {
		txt_username.clear();
		txt_username.sendKeys(username);
	}

	public void enterInvalidPassword(String password) {
		
		txt_password.clear();
		txt_password.sendKeys(password);
	}

	public void loginClick()
	{
		 WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(50));
		 wait.until(ExpectedConditions.elementToBeClickable(txt_login)).click();
		
	}
	
	public String invalidLoginText()
	{
		return invalid_login_error.getText();
	}
	
	
	public void entervalidUsername(String username) {
		lg=new ReadLogin();
		String uname=lg.getUserName();
		txt_username.sendKeys(uname);
		
		//txt_username.sendKeys(username);
	}

	public void entervalidPassword(String password) {
		lg=new ReadLogin();
		String pass=lg.getUserName();
		txt_username.sendKeys(pass);
		//txt_password.sendKeys(password);
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

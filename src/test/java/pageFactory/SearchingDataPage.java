package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class SearchingDataPage {

	WebDriver driver;
	AddComputerPage ad;
	VerifyHomePage vhp;

	public SearchingDataPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void searchAddedComputer() throws InterruptedException
	{
		ad=new AddComputerPage(driver);
		vhp=new VerifyHomePage(driver);
		Thread.sleep(2000);
		ad.company_name();
		vhp.filter_by_computer.click();
		
	}
	
	
}

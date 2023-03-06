package pageFactory;

import java.time.Duration;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddComputerPage {

	public WebDriver driver;
	WebDriverWait wait;

	public AddComputerPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@FindBy(xpath = "//a[@class=\"btn success\"]")
	WebElement add_new_computer;

	@FindBy(xpath = "//input[@type=\"submit\"]")
	WebElement create_btn;

	@FindBy(xpath = "//input[@id=\"name\"]")
	WebElement enter_comp;

	@FindBy(id ="company")
	WebElement comp_name;

	@FindBy(xpath = "//input[@value=\"Create this computer\"]")
	WebElement submit;

	@FindBy(xpath = "//div[@class=\"alert-message warning\"]")
	WebElement check;

	@FindBy(xpath = "//*[@class=\"clearfix error\"]")
	WebElement bgcolor;

	@FindBy(xpath = "//section//h1")
	WebElement coumputer_foundCount;

	int count = 0;
	String strCount, s;
	int i, j;

	public void modifyTheString() {
		// initializing a string
		strCount = coumputer_foundCount.getText();
		// declaring an empty string array
		String strArr[] = null;
		// parsing white space as a parameter
		Pattern ptr = Pattern.compile(" ");
		// storing the string elements in array after splitting
		strArr = ptr.split(strCount);
		// printing the converted string array

		for (i = 0; i < strArr.length; i++) {
			if (strArr[i].equals("574")) {
				// System.out.println(strArr[i]);
				String str = strArr[i];
				j = Integer.parseInt(str);
				// System.out.println(j);
				j++;
				// System.out.println(j);
				s = String.valueOf(j);
				// System.out.println(s);
				break;
			}

		}
		for (int k = 0; k < strArr.length; k++) {
			strArr[0] = s;

		}

		String joinedString = Arrays.toString(strArr);
		strCount = joinedString;
		System.out.println(strCount);
	}

	public void addComputerBtn() {
		
		add_new_computer.click();
	}

	public void create_computer()  {
		
		wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(create_btn)).click();
	}

	public void backgroundColorOnComputerNameField()  {
		
		String color = bgcolor.getCssValue("background-color");
		System.out.println(color + " user can see the bacground color");

	}

	public void computer_name() throws InterruptedException {
		Thread.sleep(500);
		enter_comp.sendKeys("xyz");
	}

	public void company_name() throws InterruptedException {
		Thread.sleep(500);
		WebElement dropdown = comp_name;
		Select selectObject = new Select(dropdown);
		selectObject.selectByIndex(16);
	}

	public void click_sumbit() throws InterruptedException {
		submit.click();
		count++;
		modifyTheString();
	}

	public boolean successful() throws InterruptedException {
		// System.out.println(count);
		Thread.sleep(2000);
		return check.isDisplayed();
	}

	String str;
	int num;

	public void afterAddingcom_coumputerFoundCount() {

		try {

			str = coumputer_foundCount.getText();
			String str1 = str.replace("574 computers found", "575 computers found");
			System.out.println(str1);
		} catch (NumberFormatException a) {
			num = Integer.parseInt(str);
			System.out.println(num);
		}

	}
}

package stepDefinations;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src\\test\\resources\\Features\\SouceDemo.feature",glue = {"stepDefinations"},
		monochrome = true,
		tags = "@FilterData",		
		plugin = {"pretty","html:target/HtmlReports/index.html",
				"json:target/JSONReports/report.json",
				"junit:target/JUNITReports/report.xml",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"	}
		)
public class TestRunner {

	
}


package testRunner;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import drivers.DriverManager;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
		features = "src/test/resources/Features",
		glue = { "hooks", "stepDefinitions" },

		 //tags = "@mypatients",
		plugin = {
				"pretty",
				"html:target/cucumber-reports.html",
				"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"rerun:target/failed_scenarios.txt"
		},
		dryRun = false,
		monochrome = true)
public class Runner extends AbstractTestNGCucumberTests {
	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}

	@BeforeClass
	@Parameters("browserType")
	public void beforeClass(@Optional("chrome") String browserType) {
		if (browserType != null && !browserType.equals("param-val-not-found")) {
			System.out.println(browserType);
			DriverManager.setBrowser(browserType);
		}
	}
}

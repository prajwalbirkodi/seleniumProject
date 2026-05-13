package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

public class FailedTestRunner {

    @CucumberOptions(
            features =  {"@target/failed_scenarios.txt"},
            glue = {"hooks", "stepDefinitions"},
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
    }
}

package hooks;


import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import drivers.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import pageObjectManager.PageObjectManager;
import utilities.ConfigReader;
import utilities.LoggerFactory;
public class Hooks {


	public static PageObjectManager pom;
	@Before(order =1)
	public void Setup() throws IOException {

		DriverManager.initBrowser();
		pom = new PageObjectManager(DriverManager.getDriver());
	}
	@Before(value = "@DietitianLogin", order = 2)
	public void login() {

		LoggerFactory.info("Performing login ");
		pom.getLoginPage().validlogin(
			ConfigReader.getProperty("username"),
			ConfigReader.getProperty("password")
		);
		LoggerFactory.info("Login successful");
	}
	@After
	public void tearDown(Scenario scenario) {
		if (DriverManager.getDriver() != null) {
			DriverManager.getDriver().quit();
		}
		LoggerFactory.info("DONE tearDown()..");
	}

	//@AfterStep
	public void takeScreenShot(Scenario scenario) {
		if (scenario.isFailed()) {
			TakesScreenshot takesScreenshot = (TakesScreenshot) DriverManager
					.getDriver();
			byte[] screenShot = takesScreenshot
					.getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenShot, "image/png", scenario.getName());
			Allure.addAttachment(scenario.getName(),
					new ByteArrayInputStream(screenShot));
		}
	}
}

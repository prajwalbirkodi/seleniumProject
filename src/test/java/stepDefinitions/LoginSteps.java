package stepDefinitions;

import java.util.Map;

import org.testng.Assert;

import drivers.DriverManager;
import hooks.Hooks;
import io.cucumber.java.en.*;
import pageObjectManager.PageObjectManager;
import utilities.ConfigReader;
import utilities.ExcelUtils;

public class LoginSteps {
	private PageObjectManager pom;
	private ExcelUtils excel;
 
	public LoginSteps(Hooks hooks)
	{
		this.pom = new PageObjectManager(DriverManager.getDriver());
		this.excel = new ExcelUtils(ConfigReader.getProperty("test_data_path"));
	}


@When("user enters application URL")
public void user_enters_application_url() {
	
	pom.getLoginPage().DietitianPageUrl();
	pom.getLoginPage().clicklogIn();
}

@Then("{string} should have {string} as {string}")
public void should_have_as(String element, String action, String value) {
   

	switch (element.toLowerCase()) {

	case "navigation bar title on left side":
		Assert.assertEquals(pom.getLoginPage().getNavTitleText(), value);
		break;

	case "navigation bar home icon on left side":
		Assert.assertEquals(pom.getLoginPage().isHomeIconVisible(), value.equalsIgnoreCase("visible"));
		break;
		
	case "login card heading":
		Assert.assertEquals(pom.getLoginPage().getLoginCardHeading(), value);
		break;
		
	case "username field":
		Assert.assertEquals(pom.getLoginPage().isUsernameFieldVisible(), value.equalsIgnoreCase("visible"));
		break;

	case "password field":
		Assert.assertEquals(pom.getLoginPage().isPasswordFieldVisible(), value.equalsIgnoreCase("visible"));
		break;

	case "login button":
		switch (action.toLowerCase()) {
		case "visibility":
			Assert.assertEquals(pom.getLoginPage().isLoginButtonVisible(), value.equalsIgnoreCase("visible"));
			break;

	case "enabled":
			Assert.assertEquals(pom.getLoginPage().isLoginButtonEnabled(), Boolean.parseBoolean(value));
			break;
			
	case "text-color":
			if (value.equalsIgnoreCase("white")) {
				Assert.assertTrue(pom.getLoginPage().isLoginButtonTextWhite());
			}
			break;
		}
		break;
		
	case "background-color":
		if (value.equalsIgnoreCase("blue-purple")) {
			Assert.assertTrue(pom.getLoginPage().isLoginButtonBgBluePurple());
		} else if (value.equalsIgnoreCase("white")) {
			Assert.assertTrue(pom.getLoginPage().isWhite(pom.getLoginPage().getLoginButtonBgColor()));
		}
		break;
		}
	}
	
//Functional


@When("User logs in as {string}")
public void user_logs_in_as(String scenario) {
	
	Map<String, String> data = excel.getRowDataByScenario("Login",  scenario);      
     
	String username=data.get(("username"));
	String password = data.get("password");
	
	pom.getLoginPage().validlogin(username, password);
	
	
}

@Then("User should see the dashboard")
public void user_should_see_the_dashboard() {
    Assert.assertTrue(pom.getDashboardPage().isDashboard());

}


@Then("An error message {string} should be displayed")
public void an_error_message_should_be_displayed(String message) {
    
 Assert.assertEquals(message, pom.getLoginPage().getErrorMessage());

}






}



	


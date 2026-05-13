package stepDefinitions;

import org.testng.Assert;

import drivers.DriverManager;
import hooks.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjectManager.PageObjectManager;

public class DashboardSteps {

	private PageObjectManager pom;
 
	public DashboardSteps(Hooks hooks)
	{
		this.pom = new PageObjectManager(DriverManager.getDriver());
	}
	
	@Given("User is on the login page")
	public void user_is_on_the_login_page() {
	    
	}

	@When("user logs in with valid credentials")
	public void user_logs_in_with_valid_credentials() {
	    
	}
	
	@Then("User should be redirected to dashboard page")
	public void user_should_be_redirected_to_dashboard_page() {
	    Assert.assertTrue(pom.getDashboardPage().isDashboard());

	}

	@Then("user should see {int} navigation links in the navbar")
	public void user_should_see_navigation_links_in_the_navbar(Integer expectedCount) {
	    int actcount = pom.getDashboardPage().getNavbarLinksCount();
	    Assert.assertEquals(actcount, expectedCount);
	}

	@Given("User is on the Dashboard page")
	public void user_is_on_the_dashboard_page() {
	   // pom.getDashboardPage()
	}

	@When("User clicks on {string}")
	public void user_clicks_on(String link) {
	    pom.getDashboardPage().clickOnLink(link);
	}

	@Then("user should navigate to {string}")
	public void user_should_navigate_to(String expectedPage) {
	   String actualPage = pom.getDashboardPage().getPageTitle();
	   Assert.assertTrue(actualPage.contains(expectedPage));
	}



}

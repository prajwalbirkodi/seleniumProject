package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import drivers.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjectManager.PageObjectManager;
import utilities.LoggerFactory;


public class DeletePopupInfoSteps {

    WebDriver driver = DriverManager.getDriver();
    PageObjectManager pom = new PageObjectManager(driver);


@Given("User is on the My Patient page")
public void user_is_on_the_my_patient_page() {
   
}

    @When("User clicks the Delete icon for a particular patient in the patient table")
    public void click_delete_icon() {
       // pom.getMyPatientPage().clickDeleteIcon(patientName);
    }

    @Then("{string} should be {string}")
    public void validate_popup(String validation) {
		LoggerFactory.info("Verify delete patient pop-up details.");

        if (validation.contains("Alert Title")) {

            String actual = pom.getCommonMethods().getAlert();
            Assert.assertTrue(actual.equals("Confirm"), "Title mismatch");
                    
        }

        else if (validation.contains("Alert text")) {

            String actual = pom.getCommonMethods().getAlert();
            		
            Assert.assertTrue(actual.contains("Are you sure to delete"),
                    "Alert text mismatch");
        }

        else if (validation.contains("Alert Yes button")) {

            
        	Assert.assertTrue( pom.getDeletePopupInfo().isYesButtonDisplayed(),"Yes button not visible" );
                    
           
        }

        else if (validation.contains("Alert No button")) {

            Assert.assertTrue(pom.getDeletePopupInfo().isNoButtonDisplayed(),"No button not visible");
        }
    }




    }


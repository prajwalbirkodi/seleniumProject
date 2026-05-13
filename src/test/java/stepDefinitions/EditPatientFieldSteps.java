package stepDefinitions;

import drivers.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import pageObjectManager.PageObjectManager;
import utilities.LoggerFactory;

public class EditPatientFieldSteps {

    private static final Logger logger = LogManager.getLogger(EditPatientFieldSteps.class);

    private PageObjectManager pom;

    public EditPatientFieldSteps() {
        pom = new PageObjectManager(DriverManager.getDriver());
    }

    @Given("Patients already exists and Dietitian is in My patients page")
    public void patients_already_exists_and_dietitian_is_in_my_patients_page() {
        logger.info("Dietitian is in My Patients page");
        pom.getPatientspage().navigateToMyPatientsPage();

    }

    @When("User clicks edit icon for the particular patient")
    public void user_clicks_edit_icon_for_the_particular_patient() {
        logger.info("Dietitian clicks on edit icon for the particular patient");
        pom.getPatientspage().clickEditIcon();

    }

    @Then("User should see Edit Patient page on the dialog box")
    public void user_should_see_edit_patient_page_on_the_dialog_box() {
        logger.info("Verifying Edit Patient dialog title is displayed");
        Assert.assertTrue( pom.getPatientspage().isDialogTitleDisplayed(), "Edit Patient dialog title is NOT displayed!"
        );
    }

    @Then("User should see submit button")
    public void user_should_see_submit_button() {
        logger.info("Verifying Submit button is displayed");
        Assert.assertTrue(pom.getPatientspage().isSubmitButtonDisplayed(), "Submit button is NOT displayed!");
    }

    @Then("User should see submit button in enable mode")
    public void user_should_see_submit_button_in_enable_mode() {
        logger.info("Verifying Submit button is enabled");
        Assert.assertTrue(pom.getPatientspage().isSubmitButtonEnabled(), "Submit button is NOT enabled!"
        );
    }

    @Then("User should see close button")
    public void user_should_see_close_button() {
        logger.info("Verifying Close button is displayed");
        Assert.assertTrue(pom.getPatientspage().isCloseButtonDisplayed(), "Close button is NOT displayed!");
    }

    @Then("User should see close button in enable mode")
    public void user_should_see_close_button_in_enable_mode() {
        logger.info("Verifying Close button is enabled");
        Assert.assertTrue(pom.getPatientspage().isCloseButtonEnabled(), "Close button is NOT enabled!");
    }

    @Then("User should see {int} input fields")
    public void user_should_see_input_fields(Integer expectedCount) {
        logger.info("Verifying input fields count is correct");
        Assert.assertTrue(pom.getPatientspage().isInputFieldCountCorrect(expectedCount), "Input fields count does NOT match! Expected: " + expectedCount
        );
    }

    @Then("User should see {int} drop downs")
    public void user_should_see_drop_downs(Integer expectedCount) {
        logger.info("Verifying dropdowns count is correct");
        Assert.assertTrue(pom.getPatientspage().isDropdownCountCorrect(expectedCount), "Dropdowns count does NOT match! Expected: " + expectedCount
        );
    }

    @Then("User should see exactly {int} file upload option")
    public void user_should_see_exactly_file_upload_option(Integer expectedCount) {
        logger.info("Verifying file upload count is correct");
        Assert.assertTrue(pom.getPatientspage().isFileUploadCountCorrect(expectedCount), "File upload count does NOT match! Expected: " + expectedCount);
    }

    @Then("User should see the {string} field populated with the value entered during patient creation")
    public void user_should_see_the_field_populated_with_the_value_entered_during_patient_creation(String fieldName) {
        logger.info("Verifying " + fieldName + " field is populated with the value entered during patient creation");
        Assert.assertTrue(pom.getPatientspage().isFieldPopulated(fieldName), fieldName + " field is NOT populated!");
}


    @Then("User should see vitals title after DOB field")
    public void user_should_see_vitals_title_after_dob_field() {
        logger.info("Verifying Vitals title is displayed after DOB field");
        Assert.assertTrue(pom.getPatientspage().isVitalsTitleDisplayed(), "Vitals title is NOT displayed!");
    }
//
    @Then("User should see SP placeholder in SP field")
    public void user_should_see_sp_placeholder_in_sp_field() {
        logger.info("Verifying SP placeholder is displayed in SP field");
        Assert.assertEquals("SP", pom.getPatientspage().getSPFieldPlaceholder(), "SP placeholder is NOT displayed in SP field!");

    }

    @Then("User should see DP placeholder in DP field")
    public void user_should_see_dp_placeholder_in_dp_field() {
        logger.info("Verifying DP placeholder is displayed in DP field");
        Assert.assertEquals("DP", pom.getPatientspage().getDPFieldPlaceholder(), "DP placeholder is NOT displayed in DP field!");

    }

    @Then("User should see Weight placeholder in Weight field")
    public void user_should_see_weight_placeholder_in_weight_field() {
        logger.info("Verifying Weight placeholder is displayed in Weight field");
        Assert.assertEquals("Weight", pom.getPatientspage().getWeightFieldPlaceholder());

    }

    @Then("User should see Height placeholder in Height field")
    public void user_should_see_height_placeholder_in_height_field() {
        logger.info("Verifying Height placeholder is displayed in Height field");
        Assert.assertEquals("Height", pom.getPatientspage().getHeightFieldPlaceholder());

    }

    @Then("User should see Temperature placeholder in Temperature field")
    public void user_should_see_temperature_placeholder_in_temperature_field() {
        logger.info("Verifying Temperature placeholder is displayed in Temperature field");
        Assert.assertEquals("Temperature", pom.getPatientspage().getTemperatureFieldPlaceholder());

    }

    @Then("User should not see mandatory indicators for Vitals Information fields")
    public void user_should_not_see_mandatory_indicators_for_vitals_information_fields() {
        logger.info("Verifying mandatory indicators are NOT present for Vitals fields");
        Assert.assertTrue(pom.getPatientspage().isNoMandatoryIndicatorForVitals(), "Mandatory indicators ARE present for Vitals fields!");
    }

    @Then("User should see {string} text for Upload button")
    public void user_should_see_text_for_upload_button(String string) {
        logger.info("Verifying Upload button has " + string + " text");
        Assert.assertTrue(pom.getPatientspage().isUploadHealthReportLabelDisplayed(), "Upload health report label is NOT displayed!");
    }

    @Then("User should see {string} text")
    public void user_should_see_text(String string) {
        logger.info("Verifying No File Chosen text is displayed");
        Assert.assertTrue(
                pom.getPatientspage().isNoFileChosenTextDisplayed(),
                "No File Chosen text is NOT displayed!"
        );
    }

    @Then("Close button should have red color")
    public void close_button_should_have_red_color() {
        logger.info("Verifying Close button has red color");
        Assert.assertTrue(
                pom.getPatientspage().isCloseButtonRedColor(),
                "Close button does NOT have red color!"
        );
    }

    @Then("User should see {string} placeholder in {string} field")
    public void user_should_see_placeholder_in_field(String placeholder, String fieldName) {
        logger.info("Verifying " + placeholder + " placeholder is displayed in " + fieldName + " field");
        Assert.assertTrue(pom.getPatientspage().isVitalsPlaceholderDisplayed(fieldName), fieldName + " placeholder is NOT displayed!");
    }

}

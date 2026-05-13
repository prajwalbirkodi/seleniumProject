package stepDefinitions;

import drivers.DriverManager;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import pageObjectManager.PageObjectManager;
import utilities.LoggerFactory;

import java.util.Arrays;
import java.util.List;

public class ViewReportsSteps {

    private static final Logger logger = LogManager.getLogger(ViewReportsSteps.class);
    private PageObjectManager pom;
    private String originalWindowHandle;

    public ViewReportsSteps() {
        pom = new PageObjectManager(DriverManager.getDriver());
    }

    @Given("User is in My Patients page")
    public void user_is_in_my_patients_page() {
        logger.info("Dietitian is navigating to My Patients page");
        pom.getReportsPage().navigateToMyPatientsPage();
    }

    @When("User clicks View Previous Test Reports button for a particular record")
    public void user_clicks_view_previous_test_reports_button_for_a_particular_record() {
        logger.info("Dietitian is clicking view previous test report button for a particular patient");
        pom.getReportsPage().clickTestReports();

    }
    @Then("Title View Patient Test Reports should be displayed")
    public void title_view_patient_test_reports_should_be_displayed() {
        String title = "View Patient Test Reports";
        logger.info("Title View Patient Test Reports is displayed");
        Assert.assertEquals(pom.getReportsPage().getTitle(), title, "Title is not matching");
    }

    @Then("Patient ID field should be displayed")
    public void patient_id_field_should_be_displayed() {
        logger.info("Patient ID is displayed");
        Assert.assertTrue(pom.getReportsPage().isPatientIdDisplayed(), "Patient ID field is not displayed");
    }

    @Then("Name field should be displayed")
    public void name_field_should_be_displayed() {
        logger.info("Name field is displayed");
        Assert.assertTrue(pom.getReportsPage().isNameDisplayed(), "Name field is not displayed");
    }

    @Then("Email should be displayed")
    public void email_should_be_displayed() {
        logger.info("Email field is displayed");
        Assert.assertTrue(pom.getReportsPage().isEmailDisplayed(), "Email field is not displayed");
    }

    @Then("Contact Number field should be displayed")
    public void contact_number_field_should_be_displayed() {
        logger.info("Contact Number field is displayed");
        Assert.assertTrue(pom.getReportsPage().isContactNumberDisplayed(), "Contact Number field is not displayed");
    }

    @Then("Close icon x should be displayed")
    public void close_icon_x_should_be_displayed() {
        logger.info("Close icon is displayed");
        Assert.assertTrue(pom.getReportsPage().isCloseBtnDisplayed(), "close Button is not displayed");

    }

     @Then("{string} corresponding to the record selected in My Patients page should be displayed")
    public void corresponding_to_the_record_selected_in_my_patients_page_should_be_displayed(String patientId) {
         logger.info("Corresponding patient Id is displayed");
         Assert.assertEquals(pom.getReportsPage().getPatientId(), patientId, "Patient id is not matching");
    }


    @Then("Reports table should be displayed")
    public void reports_table_should_be_displayed() {
        logger.info("Reports table is displayed");
        Assert.assertTrue(pom.getReportsPage().isReportTableDisplayed(), "Reports table is not displayed");
    }

    @Then("Table headers should have below {string}")
    public void table_headers_should_have_below(String field) {
        logger.info("Table header has " + field + " column");
        Assert.assertTrue(pom.getReportsPage().isColumnHeaderPresent(field), "Column header " + field + " is NOT present in the Reports table");
    }

    @Then("Record headers should be in the exact order")
    public void record_headers_should_be_in_the_exact_order(DataTable dataTable) {
        List<String> expectedOrder = dataTable.asList();
        logger.info("Verifying the record headers are in the exact order");
        Assert.assertTrue(pom.getReportsPage().isColumnOrderCorrect(expectedOrder), "Column headers are not in the correct order"
        );
    }

    @Then("Pagination controls First, previous, next, last arrows should be displayed")
    public void pagination_controls_first_previous_next_last_arrows_should_be_displayed() {
        logger.info("Pagination controls First, previous, next, last arrows are displayed");
        Assert.assertTrue(pom.getReportsPage().isLastPageIconDisplayed(), "Last page icon is not displayed");
        Assert.assertTrue(pom.getReportsPage().isNextPageIconDisplayed(), "Next page icon is not displayed");
        Assert.assertTrue(pom.getReportsPage().isFirstPageIconDisplayed(), "First page icon is not displayed");
        Assert.assertTrue(pom.getReportsPage().isPreviousPageIconDisplayed(), "Previous page icon is not displayed");
    }

    @Then("Each report should display View PDF button")
    public void each_report_should_display_view_pdf_button() {
        logger.info("Each report is displayed with view pdf button");
        Assert.assertTrue(pom.getReportsPage().isViewPdfBtnDisplayed(), "View PDF button is not displayed");
    }

    @Then("Vitals should be displayed in the order Weight → Height → Temperature → SP → DP")
    public void vitals_should_be_displayed_in_the_order_weight_height_temperature_sp_dp() {
        logger.info("Verifying the vitals are displayed in an order");
        List<String> expectedOrder = Arrays.asList("Weight", "Height", "Temperature", "SP", "DP");
        List<String> actualOrder = pom.getReportsPage().getActualVitalsOrder();
        Assert.assertEquals(actualOrder, expectedOrder, "The Vitals are not in the correct order!");
    }

    @Then("Vitals should be displayed in multiLines")
    public void vitals_should_be_displayed_in_multiLines() {
        boolean result = pom.getReportsPage().areVitalsDisplayedInMultiLines();
        logger.info("Vitals details are displayed in multilines");
        Assert.assertTrue(result,"Vitals are NOT displayed in multiLines!" );
    }

    @Then("Each report should display Identified health conditions")
    public void each_report_should_display_identified_health_conditions() {
        List<String> expectedOrder = Arrays.asList("Diabetic", "Thyroid", "Blood Pressure", "PCOS");
        List<String> actualOrder = pom.getReportsPage().getActualHealthConditionsOrder();
        logger.info("Each reports are displayed with Identified health conditions");
        Assert.assertEquals(actualOrder, expectedOrder, "The Identified health conditions are not in the correct order!");
    }

    @Then("Identified health conditions should be displayed in multiLines")
    public void identified_health_conditions_should_be_displayed_in_multiLines() {
        boolean result = pom.getReportsPage().isConditionsOrderInMultiLines();
        logger.info("Identified health condition is displayed in multiLines");
        Assert.assertTrue(result,"Vitals are NOT displayed in multiLines!" );
    }

    @Given("User is in View Plan Test Reports page")
    public void user_is_in_view_plan_test_reports_page() {
        logger.info("Dietitian is in View patient Test Reports page");
        Assert.assertTrue(pom.getReportsPage().isOnViewTestReportsPage(), "User is not on View Test Reports page");
    }

    @When("User clicks View PDF button for a particular record")
    public void user_clicks_view_pdf_button_for_a_particular_record() {
        logger.info("Dietitian clicked on View PDF button for a particular record");
        originalWindowHandle = pom.getReportsPage().getCurrentWindowHandle();
        pom.getReportsPage().clickViewPdfButton();
    }

    @Then("Corresponding report for that record should be opened")
    public void corresponding_report_for_that_record_should_be_opened() {
        logger.info("corressponding report for that record is opened");
        Assert.assertTrue(pom.getReportsPage().isPdfReportOpened(originalWindowHandle), "PDF report did not open in a new tab");
    }

    @Given("User is in {string}")
    public void user_is_in(String startCondition) {
        logger.info("Dietitian is in "+ startCondition+" page");
        pom.getReportsPage().navigateToPage(startCondition);
    }

    @When("User clicks the {string} pagination arrow")
    public void user_clicks_the_pagination_arrow(String arrow) {
        logger.info("User clicks the pagination arrow: " + arrow);
        pom.getReportsPage().clickPaginationArrow(arrow);

    }
    @Then("{string} should be displayed")
    public void should_be_displayed(String expectedResult) {
        logger.info(expectedResult + " is displayed");
        Assert.assertTrue(pom.getReportsPage().verifyRecordsDisplayed(expectedResult),
                expectedResult + " was not displayed!");
    }

    @Given("User is in View Patient Test Reports page with multiple pages of record")
    public void user_is_in_view_patient_test_reports_page_with_multiple_pages_of_record() {
        logger.info("Dietitian is in View Patient Test Reports page with multiple pages of record");
        pom.getReportsPage().clickTestReports();
    }

    @When("User navigates to any page")
    public void user_navigates_to_any_page() {
        logger.info("Dietitian is navigating to any page using pagination arrow");
        pom.getReportsPage().clickPaginationArrow(">");
    }

    @Then("Pagination controls should be displayed")
    public void pagination_controls_should_be_displayed() {
        logger.info("Verifying the pagination controls are displayed");
        Assert.assertTrue(pom.getReportsPage().isPaginationControlsDisplayed(), "Pagination controls are NOT displayed!");
    }


    @Given("User is in any page of Report table")
    public void user_is_in_any_page_of_report_table() {
        logger.info("User is on any page of Report table");
        pom.getReportsPage().isReportTableVisible();
    }

    @When("User clicks any page navigation arrow")
    public void user_clicks_any_page_navigation_arrow() {
        logger.info("Dietitian is clicking the page navigation arrow");
        pom.getReportsPage().clickPaginationArrow(">");
    }

    @Then("Pagination text should display the correct range and total number of patients")
    public void pagination_text_should_display_the_correct_range_and_total_number_of_patients() {
        logger.info("Verifying the pagination text display");
        Assert.assertTrue(pom.getReportsPage().isPaginationTextCorrect(),"Pagination text is incorrect!");
    }

    @When("User navigates to {string}")
    public void user_navigates_to(String navigateTo) {
        logger.info("User navigates to particular page using " + navigateTo + " arrow");
        pom.getReportsPage().navigateToPosition(navigateTo);
    }

    @Then("{string} should be {string} state")
    public void should_be_state(String string, String string2) {
        boolean result = pom.getReportsPage().isArrowInExpectedState(string, string2);
        logger.info("verifying the state of " + string + " arrow is " + string2);
        Assert.assertTrue(result, "Arrow " + string + " should be " + string2 + " but it is NOT!");
    }

    @When("User clicks on View Patient Test Reports button")
    public void user_clicks_on_view_patient_test_reports_button() {
        logger.info("User is clicking View Patient Test Reports button");
        pom.getReportsPage().clickTestReports();
    }

    @Then("First, previous, next, last arrows should be disabled")
    public void first_previous_next_last_arrows_should_be_disabled() {
        pom.getReportsPage().clickTestReports();
        logger.info("First, previous, next, last arrows are disabled");
        Assert.assertTrue(
                pom.getReportsPage().isFirstPageArrowDisabled(), "First << arrow is NOT disabled!");
        Assert.assertTrue(
                pom.getReportsPage().isPreviousPageArrowDisabled(), "Previous < arrow is NOT disabled!"
        );
        Assert.assertTrue(
                pom.getReportsPage().isNextPageArrowDisabled(), "Next > arrow is NOT disabled!"
        );
        Assert.assertTrue(
                pom.getReportsPage().isLastPageArrowDisabled(), "Last >> arrow is NOT disabled!"
        );
    }

    @Given("User is in dietician application dashboard page")
    public void user_is_in_dietician_application_dashboard_page() {
        logger.info("User is in dietitian application dashboard page");
        pom.getReportsPage().isDashboardPageDisplayed();
    }

    @When("User clicks on my Patients button")
    public void user_clicks_on_my_Patients_button() {
        logger.info("User is clicking My Patients button");
        pom.getReportsPage().clickMyPatientsButton();
    }

    @Then("User should see only {int} records in each page")
    public void user_should_see_only_records_in_each_page(Integer expectedCount) {
        logger.info("User is able to see only 2 records in each page");
        Assert.assertEquals(pom.getReportsPage().getRecordsCountOnCurrentPage(), (int) expectedCount, "Records count on page does NOT match expected count!");
    }
}

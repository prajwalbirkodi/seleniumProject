package stepDefinitions;

import io.cucumber.java.en.*;
import pageObjectManager.PageObjectManager;
import pages.MyPatientsPage;
import utilities.LoggerFactory;
import io.cucumber.datatable.DataTable;
import org.testng.Assert;
import drivers.DriverManager;
import java.util.List;
import java.util.Map;

public class MyPatientsPageSteps {

    private PageObjectManager pom;
    private MyPatientsPage myPatientsPage;
    

    public MyPatientsPageSteps() {
        this.pom = new PageObjectManager(DriverManager.getDriver());
        this.myPatientsPage = pom.getMyPatientsPage();
        
    }

    // ------------------- Dashboard -------------------
    @Given("User is on the dashboard page")
    public void user_is_on_the_dashboard_page() {
        LoggerFactory.info("Validating dashboard page");
        Assert.assertTrue(
            pom.getDashboardPage().isDashboard(),
            "Dashboard page is not displayed"
        );
    }

    @When("User clicks on My Patients button")
    public void user_clicks_on_my_patients_button() {
        LoggerFactory.info("Clicking on My Patients button");
        pom.getDashboardPage().clickOnLink("My Patients");
    }
    // ------------------- Column Headers -------------------
   
    @Then("Up and Down arrow icons should be displayed in the Patient Id of My Patients Page column header")
    public void up_and_down_arrow_icons_should_be_displayed_in_the_patient_id_of_My_Patients_Page_column_header() {
        LoggerFactory.info("Validating Patient Id column sorting icons are displayed");
        Assert.assertTrue(
                myPatientsPage.isPatientIdSortIconDisplayed(),
                "Patient Id sorting icons not displayed"
        );
    }

    @Then("Up and Down arrow icons should be displayed in the Name column header")
    public void up_and_down_arrow_icons_should_be_displayed_in_the_name_column_header() {
        LoggerFactory.info("Validating Name column sorting icons are displayed");
        Assert.assertTrue(
                myPatientsPage.isNameSortIconDisplayed(),
                "Name sorting icons not displayed"
        );
    }

    @Then("the following columns should be displayed:")
    public void the_following_columns_should_be_displayed(DataTable dataTable) {
        List<String> columns = dataTable.asList();
        LoggerFactory.info("Validating displayed columns: " + columns);
        for (String column : columns) {
            Assert.assertTrue(
                    myPatientsPage.isColumnDisplayed(column),
                    "Column not displayed: " + column
            );
        }
    }

    @Then("the following elements should be displayed:")
    public void the_following_elements_should_be_displayed(DataTable table) {
        List<Map<String, String>> rows = table.asMaps(String.class, String.class);
        for (Map<String, String> row : rows) {
            String element = row.get("Element");
            String expected = row.get("Expected Value");

            switch (element.toLowerCase()) {
                case "page header":
                    LoggerFactory.info("Validating page header text");
                    Assert.assertEquals(myPatientsPage.getPageHeader(), expected, "Page header mismatch");
                    break;
                case "search bar":
                    LoggerFactory.info("Validating search bar visibility");
                    Assert.assertTrue(myPatientsPage.isSearchBarDisplayed(), "Search bar is not displayed");
                    break;
                case "search icon":
                    LoggerFactory.info("Validating search icon visibility");
                    Assert.assertTrue(myPatientsPage.isSearchIconDisplayed(), "Search icon is not displayed");
                    break;
                case "placeholder text":
                    LoggerFactory.info("Validating search placeholder text");
                    Assert.assertEquals(myPatientsPage.getSearchPlaceholder(), expected, "Placeholder text mismatch");
                    break;
                default:
                    LoggerFactory.warn("Unknown element specified: " + element);
            }
        }
    }

    // ------------------- Patient Table -------------------
    @Then("Following patient details should be displayed:")
    public void following_patient_details_should_be_displayed(DataTable dataTable) {
        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : rows) {
            String field = row.get("field");
            LoggerFactory.info("Validating presence of field: " + field);
            Assert.assertTrue(myPatientsPage.isColumnPresent(field), "Field not displayed: " + field);
        }
    }

    @Then("All columns should have values for each patient record")
    public void all_columns_should_have_values_for_each_patient_record() {
        LoggerFactory.info("Validating all table cells are filled");
        Assert.assertTrue(myPatientsPage.areAllCellsFilled(), "Some table cells are empty");
    }

    @Then("Following formats should be valid:")
    public void following_formats_should_be_valid(DataTable dataTable) {
        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);
        int rowIndex = 1; // adjust if needed
        for (Map<String, String> row : rows) {
            String field = row.get("field");
            String value = "";

            switch (field.toLowerCase()) {
                case "email":
                    value = myPatientsPage.getCellData(rowIndex, 4);
                    LoggerFactory.info("Validating email format: " + value);
                    Assert.assertTrue(myPatientsPage.isValidEmail(value), "Invalid email: " + value);
                    break;
                case "phone number":
                    value = myPatientsPage.getCellData(rowIndex, 3);
                    LoggerFactory.info("Validating phone number: " + value);
                    Assert.assertTrue(myPatientsPage.isNumeric(value), "Invalid phone number: " + value);
                    break;
                case "date of birth":
                case "last visit date":
                    value = myPatientsPage.getCellData(rowIndex, 5);
                    LoggerFactory.info("Validating date format: " + value);
                    Assert.assertTrue(myPatientsPage.isValidDate(value), "Invalid date: " + value);
                    break;
                default:
                    throw new RuntimeException("Unknown field: " + field);
            }
        }
    }

    // ------------------- Pagination -------------------
    @Then("Pagination text should display:")
    public void verifyPaginationText(DataTable table) {
        List<String> expectedTexts = table.asList();
        String actualText = myPatientsPage.getPaginationText();
        LoggerFactory.info("Validating pagination text: " + actualText);
        Assert.assertTrue(expectedTexts.contains(actualText), "Pagination text mismatch! Actual: " + actualText);
    }

    @Then("Pagination arrows should be disabled:")
    public void verifyArrowsDisabled(DataTable table) {
        List<String> arrows = table.asList();
        for (String arrow : arrows) {
            LoggerFactory.info("Validating arrow disabled: " + arrow);
            Assert.assertFalse(myPatientsPage.isArrowEnabled(arrow), arrow + " should be disabled");
        }
    }

    // ------------------- Actions -------------------
    @Then("The following actions should be displayed for each patient:")
    public void the_following_actions_should_be_displayed_for_each_patient(DataTable dataTable) {
        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : rows) {
            String action = row.get("action");
            LoggerFactory.info("Validating action displayed: " + action);
            Assert.assertTrue(myPatientsPage.isActionDisplayed(action), "Action not displayed: " + action);
        }
    }

    @Then("Edit icon should be displayed for each patient")
    public void edit_icon_should_be_displayed_for_each_patient() {
        LoggerFactory.info("Validating Edit icon for each patient");
        Assert.assertTrue(myPatientsPage.areEditIconsDisplayed(), "Edit icon not displayed");
    }

    @Then("Delete icon should be displayed for each patient")
    public void delete_icon_should_be_displayed_for_each_patient() {
        LoggerFactory.info("Validating Delete icon for each patient");
        Assert.assertTrue(myPatientsPage.areDeleteIconsDisplayed(), "Delete icon not displayed");
    }

    // ------------------- Test Reports Navigation -------------------
    @When("User clicks {string} under Actions column for a patient")
    public void user_clicks_under_actions_column(String action) {
        LoggerFactory.info("Clicking action: " + action);
        if (action.equalsIgnoreCase("View Previous Test Reports")) {
            myPatientsPage.clickViewPreviousTestReports();
        } else {
            LoggerFactory.warn("Action not implemented: " + action);
        }
    }

    @Then("User should be navigated to the {string} page")
    public void user_should_be_navigated_to_the_page(String expectedPage) {
        LoggerFactory.info("Validating navigation to page: " + expectedPage);
        boolean isOnPage = myPatientsPage.isOnTestReportsPage();
        Assert.assertTrue(isOnPage, "Navigation failed to expected page: " + expectedPage);
    }
}
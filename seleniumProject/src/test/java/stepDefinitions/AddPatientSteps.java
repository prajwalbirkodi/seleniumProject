package stepDefinitions;

import java.util.Map;

import org.testng.Assert;

import drivers.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjectManager.PageObjectManager;
import io.cucumber.datatable.DataTable;
import pages.AddPatientPage;
import pages.DashboardPage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class AddPatientSteps {

    private static final Logger logger = LogManager.getLogger(AddPatientSteps.class);
    PageObjectManager pom;
    WebDriver driver;
    private AddPatientPage addPatientPage;
    private DashboardPage dashboardPage;
    private Integer selectedYear;
    
    public AddPatientSteps() {
    this.pom = new PageObjectManager(DriverManager.getDriver());
    addPatientPage = pom.getAddpatientPage();
     }

    @Given("User is on Dashboard page")
    public void user_is_on_dashboard_page() {

    }

    @When("User clicks on New Patient in the header section")
    public void user_clicks_on_new_patient_in_the_header_section() {
        logger.info("User clicks on New Patient in the header section");
        pom.getDashboardPage().clickOnLink("New Patient");
    }


    @Then("User should see Add Patient Details on the dialog box")
    public void user_should_see_add_patient_details_on_the_dialog_box() {
        logger.info("User verify dialog box title");
        String actualTitle = addPatientPage.getDialogTitle();
        Assert.assertEquals(actualTitle, "Add Patient Details");
    }

    @Then("User should see {int} input boxes in the Add Patient Details dialog box")
    public void user_should_see_input_boxes_in_the_add_patient_details_dialog_box(Integer expectedCount) {
        logger.info("User verify number of input fields in the dialog box");
        int actualCount = addPatientPage.countInputFields();
        Assert.assertEquals(actualCount, expectedCount);
    }


    @Then("User should see {int} dropdowns in the Add Patient Details dialog box")
    public void user_should_see_dropdowns_in_the_add_patient_details_dialog_box(Integer expectedCount) {
        logger.info("User verify number of dropdowns in the dialog box");
        int actualCount = addPatientPage.countDropdowns();
        Assert.assertEquals(actualCount, expectedCount);
    }

    @Then("User should see a date picker for DOB field with MM\\/DD\\/YYYY displayed")
    public void user_should_see_a_date_picker_for_dob_field_with_mm_dd_yyyy_displayed() {
        logger.info("User verify date picker for DOB field");
        Assert.assertTrue(addPatientPage.isDOBDisplayed());
        String placeholder = addPatientPage.getDOBPlaceholder();
        Assert.assertEquals(placeholder, "Date of Birth"); 
                }

    @Then("User should see exactly {int} file upload option in Add Patient Details dialog box")
    public void user_should_see_exactly_file_upload_option_in_add_patient_details_dialog_box(Integer expectedCount) {
        logger.info("User verify number of file upload options in the dialog box");
        int actualCount = addPatientPage.countFileUploadOptions();
        Assert.assertEquals(actualCount, expectedCount);
    }

    @Then("User should see one Submit button")
    public void user_should_see_one_submit_button() {
        logger.info("User verify number of submit buttons in the dialog box");
        int submitButtonCount = addPatientPage.countSubmitButtons();
        Assert.assertEquals(submitButtonCount, 1); 
        Assert.assertTrue(addPatientPage.isSubmitButtonDisplayed());
    }

    @Then("User should see one Submit button in disabled state")
    public void user_should_see_one_submit_button_in_disabled_state() {
        logger.info("User verify submit button is in disabled state");
        Assert.assertTrue(addPatientPage.isSubmitButtonDisabled());
    }
    
    @Then("User should see one Close button")
    public void user_should_see_one_close_button() {
        logger.info("User verify number of close buttons in the dialog box");
        int closeButtonCount = addPatientPage.countCloseButtons();
        Assert.assertEquals(closeButtonCount, 1);
        Assert.assertTrue(addPatientPage.isCloseButtonDisplayed());
    }

    @Then("User should see one Close button in enabled state")
    public void user_should_see_one_close_button_in_enabled_state() {
        logger.info("User verify close button is in enabled state");
        Assert.assertTrue(addPatientPage.isCloseButtonEnabled());
    }

    @Then("User should see mandatory field with placeholder {string}")
    public void user_should_see_mandatory_field_with_placeholder(String placeholderText) {
        logger.info("User verify mandatory field with placeholder: " + placeholderText);
        String actualPlaceholder = null;
        switch(placeholderText) {
            case "First name":
                actualPlaceholder = addPatientPage.getFirstNamePlaceholder();
                break;
            case "Last name":
                actualPlaceholder = addPatientPage.getLastNamePlaceholder();
                break;
            case "Email":
                actualPlaceholder = addPatientPage.getEmailPlaceholder();
                break;
            case "Contact Number":
                actualPlaceholder = addPatientPage.getContactNumberPlaceholder();
                break;
            default:
                Assert.fail("Unknown placeholder: " + placeholderText);
        }
        
        Assert.assertEquals(actualPlaceholder, placeholderText);
    }

    @Then("User should see mandatory dropdown with placeholder {string}")
    public void user_should_see_mandatory_dropdown_with_placeholder(String dropdownName) {
        logger.info("User verify mandatory dropdown with placeholder: " + dropdownName);
        String actualPlaceholder = null;
        switch(dropdownName) {
            case "Allergies":
                actualPlaceholder = addPatientPage.getAllergiesPlaceholder();
                break;
            case "Food Preference":
                actualPlaceholder = addPatientPage.getFoodPreferencePlaceholder();
                break;
            case "Cusine Category":
                actualPlaceholder = addPatientPage.getCuisineCategoryPlaceholder();
                break;
            default:
                Assert.fail("Unknown dropdown: " + dropdownName);
        }
        
        Assert.assertEquals(actualPlaceholder, dropdownName);
    }

    @Then("User should see non-manadatory field placeholder with {string}")
    public void user_should_see_non_manadatory_field_placeholder_with(String placeholderText) {
        logger.info("User verify non-mandatory field with placeholder: " + placeholderText);
        String actualPlaceholder = null; 
        switch(placeholderText) {
            case "Weight":
                actualPlaceholder = addPatientPage.getWeightPlaceholder();
                break;
            case "Height":
                actualPlaceholder = addPatientPage.getHeightPlaceholder();
                break;
            case "Temperature":
                actualPlaceholder = addPatientPage.getTemperaturePlaceholder();
                break;
            case "SP":
                actualPlaceholder = addPatientPage.getSPPlaceholder();
                break;
            case "DP":
                actualPlaceholder = addPatientPage.getDPPlaceholder();
                break;
            default:
                Assert.fail("Unknown non-mandatory field: " + placeholderText);
        }
        
        Assert.assertEquals(actualPlaceholder, placeholderText);
    }

    @Then("User should see text Upload Health Report")
    public void user_should_see_text_upload_health_report() {
        logger.info("User verify text Upload Health Report");
        Assert.assertTrue(addPatientPage.isUploadHealthReportLabelDisplayed());
        String labelText = addPatientPage.getUploadHealthReportLabelText();
             Assert.assertEquals(labelText, "Upload Health Report");
    }

    @Then("User should see text No file Chosen")
    public void user_should_see_text_no_file_chosen() {
        logger.info("User verify text No file Chosen");
        Assert.assertTrue(addPatientPage.isNoFileChosenTextDisplayed());
        String noFileText = addPatientPage.getNoFileChosenText();
        Assert.assertEquals(noFileText, "No file Chosen");
    }

    @Then("User should see mandatory DOB with placeholder {string}")
    public void user_should_see_mandatory_dob_with_placeholder(String placeholderText) {
        logger.info("User verify mandatory DOB with placeholder: " + placeholderText);
        String actualPlaceholder = addPatientPage.getDOBPlaceholder();
        Assert.assertEquals(actualPlaceholder, placeholderText);
    }

    @Then("User should see a scroll bar at the right side of dialog box")
    public void user_should_see_a_scroll_bar_at_the_right_side_of_dialog_box() {
        logger.info("User verify scroll bar is visible on the right side of dialog box");
        Assert.assertTrue(addPatientPage.isScrollBarVisible());
    }

        @When("User navigate to next field after entering numeric data in First name field")
    public void user_navigate_to_next_field_after_entering_numeric_data_in_first_name_field() {
        logger.info("User enters numeric data in First name field and navigate to next field");
        addPatientPage.enterFirstName("12345");
        addPatientPage.moveToNextField();
    }

    @Then("User should see error message in Patient first name accepts only alphabets")
    public void user_should_see_error_message_in_patient_first_name_accepts_only_alphabets() {
        logger.info("User verify error message in Patient first name accepts only alphabets");
        Assert.assertTrue(addPatientPage.errorMessageContains("only alphabets") || 
            addPatientPage.errorMessageContains("only letters"));
    }

    @When("User navigate to next field after entering special characters in First name field")
    public void user_navigate_to_next_field_after_entering_special_characters_in_first_name_field(DataTable dataTable) {
        logger.info("User enters special characters in First name field and navigate to next field");
        Map<String, String> data = dataTable.asMap(String.class, String.class);
        String firstName = data.get("Firstname");
        addPatientPage.enterFirstName(firstName);
        addPatientPage.moveToNextField();
    }

    @When("User selects date {int} in calendar")
    public void user_selects_date_in_calendar(Integer year) {
        logger.info("User selects date " + year + " in calendar");
        this.selectedYear = year;
        addPatientPage.clickDOBField();
    }

    @Then("Years older than {int} years from today should be disabled")
    public void years_older_than_years_from_today_should_be_disabled(Integer yearsOld) {
        logger.info("User verify years older than " + yearsOld + " years from today are disabled in calendar");
        Assert.assertNotNull(selectedYear, "Year should have been selected in previous step");
        Assert.assertTrue(addPatientPage.isDateOlderThan100Years(String.valueOf(selectedYear)), 
            "Year " + selectedYear + " (which is older than " + yearsOld + " years) should be considered disabled");
    }

    @When("User enters Feb {int} {int} in DOB")
    public void user_enters_feb_in_dob(Integer dayOfMonth, Integer year) {
        logger.info("User enters Feb " + dayOfMonth + " " + year + " in DOB");
        addPatientPage.enterDateInDOB(String.format("02/%02d/%d", dayOfMonth, year));
    }

    @Then("User should see the selected date Feb {int} {int}")
    public void user_should_see_the_selected_date_feb(Integer dayOfMonth, Integer year) {
        logger.info("User verify the selected date Feb " + dayOfMonth + " " + year + " is displayed in DOB field");
        String expectedDate = String.format("02/%02d/%d", dayOfMonth, year);
        String actualDate = addPatientPage.getDOBFieldValue();
        Assert.assertTrue(actualDate.contains(expectedDate));
    }

    @When("User navigate to next field leaving First name field empty")
    public void user_navigate_to_next_field_leaving_first_name_field_empty() {
        logger.info("User leaves First name field empty and navigate to next field");
        addPatientPage.moveToNextField();
    }

    @Then("User should see error message {string}")
    public void user_should_see_error_message(String expectedMessage) {
        logger.info("User verify error message: " + expectedMessage);
        Assert.assertTrue(addPatientPage.errorMessageContains(expectedMessage));
    }

    @When("User clicks Submit after entering valid data in all mandatory fields")
    public void user_clicks_submit_after_entering_valid_data_in_all_mandatory_fields(DataTable dataTable) {
        logger.info("User enters valid data in all mandatory fields and clicks Submit");
        Map<String, String> data = dataTable.asMap(String.class, String.class);
        
        String firstName = data.get("firstName");
        String lastName = data.get("lastName");
        String email = data.get("email");
        String contactNumber = data.get("contactNumber");
        String allergy = data.get("allergy");
        String foodPref = data.get("foodPref");
        String cuisine = data.get("cuisine");
        String dob = data.get("dob");
        
        addPatientPage.fillAllMandatoryFields(firstName, lastName, email, 
            contactNumber, allergy, foodPref, cuisine, dob);
        addPatientPage.clickSubmitButton();
    }

    @Then("User is directed to My Patient Page with New Patient Details created")
    public void user_is_directed_to_my_patient_page_with_new_patient_details_created() {
        logger.info("User verify that they are directed to My Patient Page with New Patient Details created");
        Assert.assertTrue(addPatientPage.isMyPatientPageDisplayed());
    }

    @When("User enters Feb {int} {int}")
    public void user_enters_feb(Integer dayOfMonth, Integer year) {
        logger.info("User enters Feb " + dayOfMonth + " " + year + " in DOB");
        addPatientPage.enterDateInDOB(String.format("02/%02d/%d", dayOfMonth, year));
    }

    @Then("User should see an error message {string}")
    public void user_should_see_an_error_message(String expectedMessage) {
        logger.info("User verify error message: " + expectedMessage);
        Assert.assertTrue(addPatientPage.errorMessageContains(expectedMessage));
    }

    @When("User clicks on Allergry dropdown")
    public void user_clicks_on_allergry_dropdown() {
        logger.info("User clicks on Allergy dropdown");
        addPatientPage.clickAllergiesDropdown();
    }

    @Then("Dropdown should contain {int} values")
    public void dropdown_should_contain_values(Integer expectedCount) {
        logger.info("User verify number of values in Allergy dropdown");
        int actualCount = addPatientPage.getAllergiesDropdownValueCount();
        Assert.assertEquals(actualCount, expectedCount);
    }

    @When("User clicks on cuisine dropdown")
    public void user_clicks_on_cuisine_dropdown() {
        logger.info("User clicks on Cuisine dropdown");
        addPatientPage.clickCuisineDropdown();
    }

    @When("User clicks on Food Preference dropdown")
    public void user_clicks_on_food_preference_dropdown() {
        logger.info("User clicks on Food Preference dropdown");
        addPatientPage.clickFoodPreferenceDropdown();
    }

    @Then("Values should be present inside Allergy dropdown")
    public void values_should_be_present_inside_allergy_dropdown() {
        logger.info("User verify values are present inside Allergy dropdown");
        Assert.assertTrue(addPatientPage.allergiesDropdownContainsValues());
    }

    @Then("Values should be present inside Cuisine dropdown")
    public void values_should_be_present_inside_cuisine_dropdown() {
        logger.info("User verify values are present inside Cuisine dropdown");
        Assert.assertTrue(addPatientPage.cuisineDropdownContainsValues());
    }

    @Then("Values should be present inside Food preference dropdown")
    public void values_should_be_present_inside_food_preference_dropdown() {
        logger.info("User verify values are present inside Food Preference dropdown");
        Assert.assertTrue(addPatientPage.foodPreferenceDropdownContainsValues());
    }

    @When("User clicks calendar Date of Birth field")
    public void user_clicks_calendar_date_of_birth_field() {
        logger.info("User clicks on Date of Birth field");
        addPatientPage.clickDOBField();
    }

    @Then("User should see the future date to be disabled")
    public void user_should_see_the_future_date_to_be_disabled() {
        logger.info("User verify future date is disabled");
        Assert.assertTrue(addPatientPage.isFutureDateDisabled());
    }

    @When("User selects {string} from Allergy dropdown")
    public void user_selects_from_allergy_dropdown(String allergyValue) {
        logger.info("User selects " + allergyValue + " from Allergy dropdown");
        addPatientPage.selectAllergiesValue(allergyValue);
    }

    @Then("{string} should be selected in the Allergy field")
    public void should_be_selected_in_the_allergy_field(String allergyValue) {
        logger.info("User verify " + allergyValue + " is selected in the Allergy field");
        Assert.assertTrue(addPatientPage.isAllergiesValueSelected(allergyValue));
    }

    @When("User selects {string} from Cuisine Category dropdown")
    public void user_selects_from_cuisine_category_dropdown(String cuisineValue) {
        logger.info("User selects " + cuisineValue + " from Cuisine Category dropdown");
        addPatientPage.selectCuisineValue(cuisineValue);
    }

    @Then("{string} should be selected in the Cuisine Category field")
    public void should_be_selected_in_the_cuisine_category_field(String cuisineValue) {
        logger.info("User verify " + cuisineValue + " is selected in the Cuisine Category field");
        Assert.assertTrue(addPatientPage.isCuisineValueSelected(cuisineValue));
    }

    @When("User selects {string} from Food Preference dropdown")
    public void user_selects_from_food_preference_dropdown(String preferenceValue) {
        logger.info("User selects " + preferenceValue + " from Food Preference dropdown");
        addPatientPage.selectFoodPreferenceValue(preferenceValue);
    }

    @Then("{string} should be selected in the Food Preference field")
    public void should_be_selected_in_the_food_preference_field(String preferenceValue) {
        logger.info("User verify " + preferenceValue + " is selected in the Food Preference field");
        Assert.assertTrue(addPatientPage.isFoodPreferenceValueSelected(preferenceValue));
    }

    @When("User selects {string} and {string} from Allergy dropdown")
    public void user_selects_and_from_allergy_dropdown(String allergy1, String allergy2) {
        logger.info("User selects " + allergy1 + " and " + allergy2 + " from Allergy dropdown");
        addPatientPage.selectMultipleAllergiesValues(allergy1, allergy2);
    }

    @When("User selects {string} and {string} from Cuisine Category dropdown")
    public void user_selects_and_from_cuisine_category_dropdown(String cuisine1, String cuisine2) {
        logger.info("User selects " + cuisine1 + " and " + cuisine2 + " from Cuisine Category dropdown");
        addPatientPage.selectMultipleCuisineValues(cuisine1, cuisine2);
    }

    @When("User selects {string} and {string} from Food Preference dropdown")
    public void user_selects_and_from_food_preference_dropdown(String preference1, String preference2) {
        logger.info("User selects " + preference1 + " and " + preference2 + " from Food Preference dropdown");
        addPatientPage.selectMultipleFoodPreferenceValues(preference1, preference2);
    }

    @When("User enters invalid date \\({int}\\/{int}\\/{int})")
    public void user_enters_invalid_date(Integer month, Integer day, Integer year) {
        logger.info("User enters invalid date " + month + "/" + day + "/" + year + " in DOB field");
        addPatientPage.enterDateInDOB(String.format("%d/%d/%d", month, day, year));
    }

    @When("User select {string} from Allergy dropdown")
    public void user_select_from_allergy_dropdown(String allergy) {
        logger.info("User selects " + allergy + " from Allergy dropdown");
        addPatientPage.selectAllergiesValue(allergy);
    }

    @Then("No selection should occur")
    public void no_selection_should_occur() {
        logger.info("User verify no selection occurs in Allergy dropdown");
        String selectedValue = addPatientPage.getSelectedAllergiesValue();
        Assert.assertNotEquals(selectedValue, "");
    }

    @When("User tries to select {string} from Cuisine Category dropdown")
    public void user_tries_to_select_from_cuisine_category_dropdown(String cuisine) {
        logger.info("User tries to select " + cuisine + " from Cuisine Category dropdown");
        addPatientPage.selectCuisineValue(cuisine);
    }

    @When("User tries to select {string} from Food Preference dropdown")
    public void user_tries_to_select_from_food_preference_dropdown(String preference) {
        logger.info("User tries to select " + preference + " from Food Preference dropdown");
        addPatientPage.selectFoodPreferenceValue(preference);
    }

    @When("User selects current date as DOB")
    public void user_selects_current_date_as_dob() {
        logger.info("User selects current date as DOB");
        addPatientPage.clickDOBField();
        java.time.LocalDate today = java.time.LocalDate.now();
        String todayDate = String.format("%02d/%02d/%d", today.getMonthValue(), today.getDayOfMonth(), today.getYear());
        addPatientPage.enterDateInDOB(todayDate);
    }

    @When("User clicks Date of Birth field")
    public void user_clicks_date_of_birth_field() {
        logger.info("User clicks on Date of Birth field");
        addPatientPage.clickDOBField();
    }

    @Then("User should see calender date picker displayed with Month,Day,Year")
    public void user_should_see_calender_date_picker_displayed_with_month_day_year() {
        logger.info("User verify calendar date picker is displayed with Month, Day, Year");
        Assert.assertTrue(addPatientPage.isDatePickerDisplayed());
    }

    @When("User enters {string} in the DOB field")
    public void user_enters_in_the_dob_field(String dateInput) {
        logger.info("User enters " + dateInput + " in the DOB field");
        addPatientPage.enterDateInDOB(dateInput);
    }

    @When("User clicks Date of Birth field, selects valid date {int}\\/{int}\\/{int}")
    public void user_clicks_date_of_birth_field_selects_valid_date(Integer month, Integer day, Integer year) {
        logger.info("User clicks on Date of Birth field and selects valid date " + month + "/" + day + "/" + year);
        addPatientPage.clickDOBField();
        addPatientPage.enterDateInDOB(String.format("%02d/%02d/%d", month, day, year));
    }

    @Then("User should see the selected date {int}\\/{int}\\/{int}")
    public void user_should_see_the_selected_date(Integer month, Integer day, Integer year) {
        logger.info("User verify the selected date " + month + "/" + day + "/" + year + " is displayed in DOB field");
        String expectedDate = String.format("%02d/%02d/%d", month, day, year);
        String actualDate = addPatientPage.getDOBFieldValue();
        Assert.assertTrue(actualDate.contains(expectedDate));
    }

    @Then("Dropdown should contain allergy values")
    public void dropdown_should_contain_allergy_values(DataTable dataTable) {
        logger.info("User verify Allergy dropdown contains expected values");
        List<String> expectedValues = dataTable.asList();
        Assert.assertTrue(addPatientPage.dropdownContainsSpecificValues("Allergies", expectedValues));
    }

    @Then("Dropdown should contain food preference values")
    public void dropdown_should_contain_food_preference_values(DataTable dataTable) {
        logger.info("User verify Food Preference dropdown contains expected values");
        List<String> expectedValues = dataTable.asList();
        Assert.assertTrue(addPatientPage.dropdownContainsSpecificValues("Food Preference", expectedValues));
    }

    @Then("Dropdown should contain cuisine category values")
    public void dropdown_should_contain_cuisine_category_values(DataTable dataTable) {
        logger.info("User verify Cuisine Category dropdown contains expected values");
        List<String> expectedValues = dataTable.asList();
        Assert.assertTrue(addPatientPage.dropdownContainsSpecificValues("Cuisine", expectedValues));
    }

    @When("User enters valid values in all field")
    public void user_enters_valid_values_in_all_field(DataTable dataTable) {
        logger.info("User enters valid values in all mandatory fields");
        Map<String, String> data = dataTable.asMap(String.class, String.class);
        
        String firstName = data.get("firstName");
        String lastName = data.get("lastName");
        String email = data.get("email");
        String contactNumber = data.get("contactNumber");
        String allergy = data.get("allergy");
        String foodPref = data.get("foodPref");
        String cuisine = data.get("cuisine");
        String dob = data.get("dob");
        
        addPatientPage.fillAllMandatoryFields(firstName, lastName, email, 
            contactNumber, allergy, foodPref, cuisine, dob);
    }

    @Then("Submit button should be enabled")
    public void submit_button_should_be_enabled() {
        logger.info("User verify Submit button is enabled after entering valid data in all mandatory fields");
        Assert.assertTrue(addPatientPage.isSubmitButtonEnabled());
    }

    @Then("User should see Patient successfully created - toast message")
    public void user_should_see_patient_successfully_created_toast_message() {
        logger.info("User verify Patient successfully created toast message is displayed");
        Assert.assertTrue(addPatientPage.isPatientSuccessfullyCreatedMessageDisplayed());
    }

    @When("User clicks Date of Birth field, selects valid date")
    public void user_clicks_date_of_birth_field_selects_valid_date() {
        logger.info("User clicks on Date of Birth field and selects valid date");
        addPatientPage.clickDOBField();
        addPatientPage.enterDateInDOB("05/10/1995");
    }

    @Then("User should see the selected date in MM\\/DD\\/YYYY format")
    public void user_should_see_the_selected_date_in_mm_dd_yyyy_format() {
        logger.info("User verify the selected date is displayed in MM/DD/YYYY format in DOB field");
        String dobValue = addPatientPage.getDOBFieldValue();
        logger.info("Selected date in DOB field: " + dobValue);
        Assert.assertTrue(addPatientPage.isDateInMMDDYYYYFormat(dobValue));
    }

    	@Given("User is logged into the Dietitian application")
	public void user_is_logged_into_the_dietitian_application() {
		String currentUrl = DriverManager.getDriver().getCurrentUrl();
		Assert.assertTrue(currentUrl.contains("dietician"), "Not on the dietician UI");

	}
/***************************************************Pramodini*****************************************************************/
	@When("User clicks on {string} Link")
	public void user_clicks_on_link(String newPatient) {
		dashboardPage.clickOnLink(newPatient);

	}

	@Then("User is on Add Patient Details Dialog Box")
	public void user_is_on_add_patient_details_dialog_box() {
		boolean isDialogBoxVisible = addPatientPage.isOnMyPatientsPage();
		Assert.assertTrue(isDialogBoxVisible, "Add Patient Details Dialog Box is not visible");
		logger.info("Successfully verified visibility of Add Patient Details Dialog Box.");
	}

	@When("User enters for {string} from Excel sheet {string} and navigates to next field")
	public void user_enters_for_from_excel_sheet_and_navigates_to_next_field(String sheetName, String testCaseID) {
		addPatientPage.fillFormByTestCase(sheetName, testCaseID);
	}

	@Then("User should see the expected error for {string}")
	public void user_should_see_the_expected_error_for(String testCaseID) {

		addPatientPage.validateErrorByTestCase(testCaseID, "PatientData");
		logger.info("Validated expected error message for TestCase: " + testCaseID);
	}

	@When("User enters valid patient data but does not select a file")
	public void user_enters_valid_patient_data_but_does_not_select_a_file(DataTable dataTable) {
        logger.info("User enters valid values in all mandatory fields");
        Map<String, String> data = dataTable.asMap(String.class, String.class);
        
        String firstName = data.get("firstName");
        String lastName = data.get("lastName");
        String email = data.get("email");
        String contactNumber = data.get("contactNumber");
        String allergy = data.get("allergy");
        String foodPref = data.get("foodPref");
        String cuisine = data.get("cuisine");
        String dob = data.get("dob");
        
        addPatientPage.fillAllMandatoryFields(firstName, lastName, email, 
            contactNumber, allergy, foodPref, cuisine, dob);
	}

	@When("User clicks Submit button")
	public void user_clicks_submit_button() {
		addPatientPage.clickSubmit();
	}

	@Then("User should be redirected to My Patient page")
	public void user_should_be_redirected_to_my_patient_page() {
		Assert.assertTrue(addPatientPage.isOnMyPatientsPage(), "User not on My Patients page after submit");
		logger.info("Verified redirection to My Patient page.");
	}

	@Then("User should see the New Patient record added successfully")
	public void user_should_see_the_new_patient_record_added_successfully() {
		Assert.assertTrue(addPatientPage.isPdfDisplayed(), "New record not found in the table");
		logger.info("Verified that the New Patient record was added successfully.");
	}

	@When("User uploads health report in {string} format")
	public void user_uploads_health_report_in_format(String format) {
		addPatientPage.uploadHealthReport("health_report." + format);

	}

	@Then("User is directed to the Test Report section")
	public void user_is_directed_to_the_test_report_section() {
		Assert.assertTrue(driver.getCurrentUrl().contains("test-report"), "Not in Test Report section");
		logger.info("Verified redirection to Test Report section.");
	}

	@When("User clicks {string}")
	public void user_clicks(String buttonText) {
		addPatientPage.clickButtonByText(buttonText);

	}

	@Then("User should see new record number in test report page")
	public void user_should_see_new_record_number_in_test_report_page() {
		Assert.assertTrue(addPatientPage.isPdfDisplayed());
		logger.info("Verified new record number on test report page.");
	}

	@Then("User should see PDF file in test report")
	public void user_should_see_pdf_file_in_test_report() {
		Assert.assertTrue(addPatientPage.isPdfDisplayed());
		logger.info("Verified PDF file presence in test report.");
	}

	@Then("User should see upload date info in test report")
	public void user_should_see_upload_date_info_in_test_report() {
		Assert.assertNotNull(addPatientPage.getHealthConditionText());
		logger.info("Verified upload date info is present.");
	}

	@Then("User should see health condition as the values in health report")
	public void user_should_see_health_condition_as_the_values_in_health_report() {
		String conditionText = addPatientPage.getHealthConditionText();
		Assert.assertFalse(conditionText.isEmpty(), "Health condition text is missing");
		logger.info("Verified health condition values match the report.");
	}

	@When("User clicks Close button after submit")
	public void user_clicks_close_button_after_submit() {
		addPatientPage.clickClose();
		
	}

	@Then("Add Patient dialog box should close")
	public void add_patient_dialog_box_should_close() {
		Assert.assertFalse(addPatientPage.isDialogTitleVisible(), "Dialog box did not close");
		logger.info("Verified that the Add Patient dialog box has closed.");
	}

	@Then("User should be on my patients page")
	public void user_should_be_on_my_patients_page() {
		Assert.assertTrue(addPatientPage.isOnMyPatientsPage());
		logger.info("Final check: User is on the My Patients page.");
	}
    
}

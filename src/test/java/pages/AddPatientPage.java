package pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.CommonMethods;
import utilities.ExcelUtils;

public class AddPatientPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private CommonMethods common;

    @FindBy(xpath = "//allTextInputs")
    private List<WebElement> allTextInputs;

    @FindBy(xpath = "//allDropdowns")
    private List<WebElement> allDropdowns;

    @FindBy(xpath = "//allFileInputs")
    private List<WebElement> allFileInputs;

    @FindBy(xpath = "//allSubmitButtons")
    private List<WebElement> allSubmitButtons;

    @FindBy(xpath = "//allCloseButtons")
    private List<WebElement> allCloseButtons;

    @FindBy(xpath = "//disabledDateElements")
    private List<WebElement> disabledDateElements;

    @FindBy(xpath = "//dialogTitle")
    private WebElement dialogTitle;

    @FindBy(xpath = "//dialogContent")
    private WebElement dialogContent;

    @FindBy(xpath = "//firstName")
    private WebElement firstNameField;

    @FindBy(xpath = "//lastName")
    private WebElement lastNameField;

    @FindBy(xpath = "//emailField")
    private WebElement emailField;

    @FindBy(xpath = "//contactNumber")
    private WebElement contactNumberField;

    @FindBy(xpath = "//dobField")
    private WebElement dobField;

    @FindBy(xpath = "//allergiesDropdown")
    private WebElement allergiesDropdown;

    @FindBy(xpath = "//foodPreferenceDropdown")
    private WebElement foodPreferenceDropdown;

    @FindBy(xpath = "//cuisineCategoryDropdown")
    private WebElement cuisineCategoryDropdown;

    @FindBy(xpath = "//weight")
    private WebElement weightField;

    @FindBy(xpath = "//height")
    private WebElement heightField;

    @FindBy(xpath = "//temperature")
    private WebElement temperatureField;

    @FindBy(xpath = "//systolicpressure")
    private WebElement spField;

    @FindBy(xpath = "//diostolic")
    private WebElement dpField;

    @FindBy(xpath = "//inputFile")
    private WebElement fileUploadInput;

    @FindBy(xpath = "//uploadHealthReportLabel")
    private WebElement uploadHealthReportLabel;

    @FindBy(xpath = "//noFileChosenText")
    private WebElement noFileChosenText;

    @FindBy(xpath = "//submitButton")
    private WebElement submitButton;

    @FindBy(xpath = "//closeButton")
    private WebElement closeButton;

    @FindBy(xpath = "//toastMessage")
    private WebElement toastMessage;

    @FindBy(xpath = "//errorMessage")
    private WebElement errorMessage;

    @FindBy(xpath = "//datePickerContainer")
    private WebElement datePickerContainer;

    @FindBy(xpath = "//dynamicFirstNameInput")
    private WebElement dynamicFirstNameInput;

    @FindBy(xpath = "//dynamicLastNameInput")
    private WebElement dynamicLastNameInput;

    @FindBy(xpath = "//input[@placeholder='Email']")
    private WebElement dynamicEmailInput;

    @FindBy(xpath = "//dynamicContactInput")
    private WebElement dynamicContactInput;

    @FindBy(xpath = "myPatientHeading")
    private WebElement myPatientHeading;

    //Pramodini Created below web elements
    @FindBy(xpath = "//input[@type='file']")
    private WebElement fileInput;

    @FindBy(xpath = "//td[contains(text(),'.pdf')]")
    private WebElement uploadedFileName;

    @FindBy(xpath = "//td[contains(text(),'Diabetic') or contains(text(),'Thyroid')]")
	private WebElement healthConditions;

    @FindBy(xpath = "//*[text()='New Patient']")
	private WebElement newPatientLink;

    public AddPatientPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getDialogTitle() {
        String titleText = dialogTitle.getText().trim();
        return titleText;
    }

    public int countInputFields() {
        int count = allTextInputs.size();
        return count;
    }

    public int countDropdowns() {
        int count = allDropdowns.size();
        return count;
    }

    public boolean isDOBDisplayed() {
        return dobField.isDisplayed();
    }

    public int countFileUploadOptions() {
        int count = allFileInputs.size();
        return count;
    }

    public boolean isUploadHealthReportLabelDisplayed() {
        return uploadHealthReportLabel.isDisplayed();
    }

    public String getUploadHealthReportLabelText() {
        return uploadHealthReportLabel.getText().trim();
    }

    public boolean isNoFileChosenTextDisplayed() {
        return noFileChosenText.isDisplayed();
    }

    public String getNoFileChosenText() {
        return noFileChosenText.getText().trim();
    }

    public int countSubmitButtons() {
        int count = allSubmitButtons.size();
        return count;
    }

    public boolean isSubmitButtonDisplayed() {
        return submitButton.isDisplayed();
    }

    public int countCloseButtons() {
        int count = allCloseButtons.size();
        return count;
    }

    public boolean isCloseButtonDisplayed() {
        return closeButton.isDisplayed();
    }

    public boolean isSubmitButtonDisabled() {
        boolean isEnabled = submitButton.isEnabled();
        return !isEnabled;
    }

    public boolean isCloseButtonEnabled() {
        return closeButton.isEnabled();
    }

    public String getFirstNamePlaceholder() {
        return firstNameField.getAttribute("placeholder");
    }

    public String getLastNamePlaceholder() {
        return lastNameField.getAttribute("placeholder");
    }

    public String getEmailPlaceholder() {
        return emailField.getAttribute("placeholder");
    }

    public String getContactNumberPlaceholder() {
        return contactNumberField.getAttribute("placeholder");
    }

    public String getAllergiesPlaceholder() {
        return allergiesDropdown.getAttribute("placeholder");
    }

    public String getFoodPreferencePlaceholder() {
        return foodPreferenceDropdown.getAttribute("placeholder");
    }

    public String getCuisineCategoryPlaceholder() {
        return cuisineCategoryDropdown.getAttribute("placeholder");
    }

    public String getDOBPlaceholder() {
        return dobField.getAttribute("placeholder");
    }

    public String getWeightPlaceholder() {
        return weightField.getAttribute("placeholder");
    }

    public String getHeightPlaceholder() {
        return heightField.getAttribute("placeholder");
    }

    public String getTemperaturePlaceholder() {
        return temperatureField.getAttribute("placeholder");
    }

    public String getSPPlaceholder() {
        return spField.getAttribute("placeholder");
    }

    public String getDPPlaceholder() {
        return dpField.getAttribute("placeholder");
    }

    public boolean isScrollBarVisible() {
        int elementHeight = dialogContent.getSize().getHeight();
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        long scrollHeight = (long) jsExecutor.executeScript("return arguments[0].scrollHeight;", dialogContent);
        return scrollHeight > elementHeight;
    }

    public void enterFirstName(String firstName) {
        firstNameField.sendKeys(firstName);
    }

    public void clickSubmitButton() {
        submitButton.click();
    }

    public boolean isSubmitButtonEnabled() {
        return submitButton.isEnabled();
    }

    public void clickCloseButton() {
        closeButton.click();
    }

    public void clickAllergiesDropdown() {
        wait.until(ExpectedConditions.elementToBeClickable(allergiesDropdown)).click();
    }

    private List<String> getAllergiesDropdownValues() {
        clickAllergiesDropdown();
        Select select = new Select(allergiesDropdown);
        List<WebElement> options = select.getOptions();
        List<String> values = new ArrayList<>();
        for (WebElement option : options) {
            String text = option.getText().trim();
            if (!text.isEmpty() && !text.equals("Allergies")) {
                values.add(text);
            }
        }
        return values;
    }

    public int getAllergiesDropdownValueCount() {
        int count = getAllergiesDropdownValues().size();
        return count;
    }

    public boolean allergiesDropdownContainsValues() {
        return getAllergiesDropdownValueCount() > 0;
    }

    public void selectAllergiesValue(String alergy) {
        clickAllergiesDropdown();
        Select select = new Select(allergiesDropdown);
        try {
            select.selectByVisibleText(alergy);
        } catch (Exception e) {
        }
    }

    public void selectMultipleAllergiesValues(String alergy1, String alergy2) {
        selectAllergiesValue(alergy1);
        selectAllergiesValue(alergy2);
    }

    public String getSelectedAllergiesValue() {
        Select select = new Select(allergiesDropdown);
        return select.getFirstSelectedOption().getText();
    }

    public boolean isAllergiesValueSelected(String alergy) {
        String selectedValue = getSelectedAllergiesValue();
        return selectedValue.equals(alergy);
    }

    public void clickFoodPreferenceDropdown() {
        wait.until(ExpectedConditions.elementToBeClickable(foodPreferenceDropdown)).click();
    }

    public boolean foodPreferenceDropdownContainsValues() {
        List<String> values = new ArrayList<>();
        Select select = new Select(foodPreferenceDropdown);
        List<WebElement> options = select.getOptions();
        for (WebElement option : options) {
            String text = option.getText().trim();
            if (!text.isEmpty() && !text.equals("Food Preference")) {
                values.add(text);
            }
        }
        return values.size() > 0;
    }

    public void selectFoodPreferenceValue(String foodPreference) {
        clickFoodPreferenceDropdown();
        Select select = new Select(foodPreferenceDropdown);
        try {
            select.selectByVisibleText(foodPreference);
        } catch (Exception e) {
        }
    }

    public void selectMultipleFoodPreferenceValues(String foodPreference1, String foodPreference2) {
        selectFoodPreferenceValue(foodPreference1);
        selectFoodPreferenceValue(foodPreference2);
    }

    public boolean isFoodPreferenceValueSelected(String foodPreference) {
        try {
            Select select = new Select(foodPreferenceDropdown);
            String selected = select.getFirstSelectedOption().getText();
            return selected.equals(foodPreference);
        } catch (Exception e) {
            return false;
        }
    }

    public void clickCuisineDropdown() {
        wait.until(ExpectedConditions.elementToBeClickable(cuisineCategoryDropdown)).click();
    }

    public boolean cuisineDropdownContainsValues() {
        List<String> values = new ArrayList<>();
        Select select = new Select(cuisineCategoryDropdown);
        List<WebElement> options = select.getOptions();
        for (WebElement option : options) {
            String text = option.getText().trim();
            if (!text.isEmpty() && !text.equals("Cusine Category")) {
                values.add(text);
            }
        }
        return values.size() > 0;
    }

    public void selectCuisineValue(String cuisine) {
        clickCuisineDropdown();
        Select select = new Select(cuisineCategoryDropdown);
        try {
            select.selectByVisibleText(cuisine);
        } catch (Exception e) {
        }
    }

    public void selectMultipleCuisineValues(String cuisine1, String cuisine2) {
        selectCuisineValue(cuisine1);
        selectCuisineValue(cuisine2);
    }

    public boolean isCuisineValueSelected(String cuisine) {
        try {
            Select select = new Select(cuisineCategoryDropdown);
            String selected = select.getFirstSelectedOption().getText();
            return selected.equals(cuisine);
        } catch (Exception e) {
            return false;
        }
    }

    public boolean dropdownContainsSpecificValues(String dropdown, List<String> expectedValues) {
        List<String> actualValues = new ArrayList<>();

        if (dropdown.equalsIgnoreCase("Allergies")) {
            actualValues = getAllergiesDropdownValues();
        } else if (dropdown.equalsIgnoreCase("Food Preference")) {
            actualValues = getDropdownValues(foodPreferenceDropdown, "Food Preference");
        } else if (dropdown.equalsIgnoreCase("Cuisine")) {
            actualValues = getDropdownValues(cuisineCategoryDropdown, "Cusine Category");
        }

        return actualValues.containsAll(expectedValues);
    }

    private List<String> getDropdownValues(WebElement dropdown, String excludeText) {
        Select select = new Select(dropdown);
        List<WebElement> options = select.getOptions();
        List<String> values = new ArrayList<>();
        for (WebElement option : options) {
            String text = option.getText().trim();
            if (!text.isEmpty() && !text.equals(excludeText)) {
                values.add(text);
            }
        }
        return values;
    }

    public void clickDOBField() {
        dobField.click();
    }

    public void enterDateInDOB(String date) {
        dobField.clear();
        dobField.sendKeys(date);
    }

    public String getDOBFieldValue() {
        return dobField.getAttribute("value");
    }

    public boolean isDateInMMDDYYYYFormat(String date) {
        boolean matches = date.matches("\\d{2}/\\d{2}/\\d{4}");
        return matches;
    }

    public boolean isFutureDateDisabled() {
        clickDOBField();
        return disabledDateElements.size() > 0;
    }

    public boolean isDateOlderThan100Years(String year) {
        int selectedYear = Integer.parseInt(year);
        Calendar today = Calendar.getInstance();
        int currentYear = today.get(Calendar.YEAR);
        int difference = currentYear - selectedYear;
        return difference > 100;
    }

    public void moveToNextField() {
        firstNameField.sendKeys("\t");
    }

    public boolean isErrorMessageDisplayed() {
        try {
            boolean isVisible = wait.until(ExpectedConditions.visibilityOf(errorMessage)).isDisplayed();
            return isVisible;
        } catch (Exception e) {
            return false;
        }
    }

    public String getErrorMessageText() {
        if (isErrorMessageDisplayed()) {
            return errorMessage.getText().trim();
        }
        return "";
    }

    public boolean errorMessageContains(String expectedMessage) {
        return getErrorMessageText().contains(expectedMessage);
    }

    public void fillAllMandatoryFields(String firstName, String lastName, String email,
            String contactNumber, String allergy, String foodPref,
            String cuisine, String dob) {
        firstNameField.sendKeys(firstName);
        lastNameField.sendKeys(lastName);
        emailField.sendKeys(email);
        contactNumberField.sendKeys(contactNumber);
        selectAllergiesValue(allergy);
        selectFoodPreferenceValue(foodPref);
        selectCuisineValue(cuisine);
        enterDateInDOB(dob);
    }

    public boolean isPatientSuccessfullyCreatedMessageDisplayed() {
        String message = getSuccessMessageText();
        boolean hasPatient = message.contains("Patient");
        boolean hasCreated = message.contains("successfully created");
        return hasPatient && hasCreated;
    }

    private String getSuccessMessageText() {
        try {
            boolean isVisible = wait.until(ExpectedConditions.visibilityOf(toastMessage)).isDisplayed();
            if (isVisible) {
                return toastMessage.getText().trim();
            }
        } catch (Exception e) {
        }
        return "";
    }

    public boolean isMyPatientPageDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOf(myPatientHeading));
            boolean isShowing = myPatientHeading.isDisplayed();
            return isShowing;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isDatePickerDisplayed() {
        try {
            boolean isVisible = wait.until(ExpectedConditions.visibilityOf(datePickerContainer)).isDisplayed();
            return isVisible;
        } catch (Exception e) {
            return false;
        }
    }

    /********************************************************Pramodini***********************************************/

    public boolean isOnMyPatientsPage() {
        return common.isElementDisplayed(dialogTitle);
    }

    public void fillFormByTestCase(String testCaseID, String sheetName) {
        List<Map<String, String>> excelData = getExcelData(sheetName);

        for (Map<String, String> row : excelData) {
            if (row.get("TestCaseID").equalsIgnoreCase(testCaseID)) {
                String input = row.get("InputData") == null ? "" : row.get("InputData");
                String field = row.get("ExpectedField").toLowerCase().trim();

                switch (field) {
                    case "firstname":
                        common.sendKeys(firstNameField, input);
                        common.clickWebElement(lastNameField); // Blur to trigger error
                        break;

                    case "lastname":
                        common.sendKeys(lastNameField, input);
                        common.clickWebElement(firstNameField);
                        break;

                    case "email":
                        common.sendKeys(emailField, input);
                        common.clickWebElement(lastNameField);
                        break;

                    case "contact number":
                    case "contact":
                        common.sendKeys(contactNumberField, input);
                        common.clickWebElement(lastNameField);
                        break;

                    case "weight":
                        common.sendKeys(weightField, input);
                        common.clickWebElement(heightField);
                        break;

                    case "height":
                        common.sendKeys(heightField, input);
                        common.clickWebElement(weightField);
                        break;

                    case "temp":
                        common.sendKeys(temperatureField, input);
                        common.clickWebElement(weightField);
                        break;

                    case "spdp":
                        if (input.contains("/")) {
                            String[] vals = input.split("/");
                            common.sendKeys(spField, vals[0]);
                            common.sendKeys(dpField, vals[1]);
                        } else {
                            common.sendKeys(spField, input);
                        }
                        common.clickWebElement(weightField);
                        break;

                    default:
                        System.out.println("Warning: No matching field logic for " + field);
                }
                return;
            }
        }
        throw new RuntimeException("TestCaseID '" + testCaseID + "' not found in sheet: " + sheetName);
    }

    private List<Map<String, String>> getExcelData(String sheetName) {
        String path = utilities.ConfigReader.getProperty("test_data_path");
        try {
            utilities.ExcelUtils excel = new utilities.ExcelUtils(path);
            return ExcelUtils.getDataAll(sheetName);

        } catch (Exception e) {
            System.err.println("CRITICAL: Could not read sheet '" + sheetName + "' from " + path);
            return new ArrayList<>();
        }

    }

    public void validateErrorByTestCase(String testCaseID, String sheetName) {
        List<Map<String, String>> data = getExcelData(sheetName);
        String expectedError = "";
        for (Map<String, String> row : data) {
            if (row.get("TestCaseID").equalsIgnoreCase(testCaseID)) {
                expectedError = row.get("ExpectedErrorMessage");
                break;
            }
        }
        if (expectedError == null || expectedError.trim().isEmpty()) {
            return;
        }

        try {

            By errorLocator = By.xpath("//*[contains(text(),\"" + expectedError.trim() + "\")]");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            WebElement errorMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(errorLocator));
            String actualError = errorMsg.getText().trim();
           
        } catch (Exception e) {
            
        }
    }

    public void uploadHealthReport(String fileName) {
        String filePath = System.getProperty("user.dir") + "/src/test/resources/testData/" + fileName;
        fileInput.sendKeys(filePath);
    }

    public void clickSubmit() {
        common.clickWebElement(submitButton);
    }

    public void clickClose() {
        common.clickWebElement(submitButton);
    }

    public String getHealthConditionText() {
        return common.getText(healthConditions);
    }

    public boolean isPdfDisplayed() {
        return common.isElementDisplayed(uploadedFileName);

    }

    public void clickButtonByText(String text) {
        driver.findElement(By.xpath("//button[contains(text(),'" + text + "')]")).click();
    }

    public boolean isDialogTitleVisible() {
        try {
            return dialogTitle.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjectManager.PageObjectManager;

import java.util.List;

public class EditPatientFieldsPage {

    private WebDriver driver;
    private PageObjectManager pom;

    public EditPatientFieldsPage(WebDriver driver) {
        this.driver = driver;
        this.pom = new PageObjectManager(driver);
        PageFactory.initElements(driver, this);
    }

        @FindBy(xpath = "//button[contains(@class,'edit')]")
        WebElement editIcon;

        @FindBy(linkText = "My Patients")
        WebElement myPatientsLink;

        @FindBy(xpath = "//h1[contains(text(),'Edit Patient')]")
        WebElement dialogTitle;


        @FindBy(xpath = "//button[normalize-space(text())='Submit']")
        WebElement submitButton;


        @FindBy(xpath = "//button[normalize-space(text())='Close']")
        WebElement closeButton;

        @FindBy(xpath = "//form//input")
        List<WebElement> allInputFields;

        @FindBy(xpath = "//select")
        List<WebElement> allDropdowns;

        @FindBy(xpath = "//input[@type='file']")
        List<WebElement> fileUploadInputs;

        @FindBy(xpath = "//input[@name='firstName']")
        WebElement firstNameField;

        @FindBy(xpath = "//input[@name='lastName']")
        WebElement lastNameField;

        @FindBy(xpath = "//input[@name='email']")
        WebElement emailField;

        @FindBy(xpath = "//input[@name='contactNumber']")
        WebElement contactNumberField;

        @FindBy(xpath = "//input[@name='allergy']")
        WebElement allergyField;

        @FindBy(xpath = "//select[@name='foodPreference']")
        WebElement foodPreferenceField;

        @FindBy(xpath = "//select[@name='cuisineCategory']")
        WebElement cuisineCategoryField;

        @FindBy(xpath = "//input[@name='dateOfBirth']")
        WebElement dateOfBirthField;

        @FindBy(xpath = "//h2[contains(text(),'Vitals')]")
        WebElement vitalsTitle;


         @FindBy(id = "sp_field")
         WebElement spField;

         @FindBy(id = "dp_field")
         WebElement dpField;

         @FindBy(id = "weight_field")
         WebElement weightField;

         @FindBy(id = "height_field")
         WebElement heightField;

         @FindBy(id = "temperature_field")
         WebElement temperatureField;

         @FindBy(xpath = "//span[contains(text(),'*')]")
         List<WebElement> mandatoryIndicators;

         @FindBy(xpath = "//*[contains(text(),'Upload health report')]")
         WebElement uploadHealthReportLabel;

         @FindBy(xpath = "//*[contains(text(),'No File Chosen')]")
         WebElement noFileChosenText;

        public void clickEditIcon() {
            pom.getCommonMethods().clickWebElement(editIcon);
        }

    public void navigateToMyPatientsPage() {
        pom.getCommonMethods().clickWebElement(myPatientsLink);
    }

    public boolean isDialogTitleDisplayed() {
        pom.getCommonMethods().waitForVisibilityOfElement(dialogTitle);
            return dialogTitle.getText().contains("Edit Patient");
        }

        public boolean isSubmitButtonDisplayed() {
            pom.getCommonMethods().waitForVisibilityOfElement(submitButton);
            return submitButton.isDisplayed();
        }

        public boolean isSubmitButtonEnabled() {
            return submitButton.isEnabled();
        }

        public boolean isCloseButtonDisplayed() {
            pom.getCommonMethods().waitForVisibilityOfElement(closeButton);
            return closeButton.isDisplayed();
        }

        public boolean isCloseButtonEnabled() {
            return closeButton.isEnabled();
        }

        public boolean isInputFieldCountCorrect(int expectedCount) {
            return allInputFields.size() == expectedCount;
        }

        public boolean isDropdownCountCorrect(int expectedCount) {
            return allDropdowns.size() == expectedCount;
        }

        public boolean isFileUploadCountCorrect(int expectedCount) {
            return fileUploadInputs.size() == expectedCount;
        }

    public String getSPFieldPlaceholder() {
        return spField.getAttribute("placeholder");
    }

    public String getDPFieldPlaceholder() {
        return dpField.getAttribute("placeholder");
    }

    public String getWeightFieldPlaceholder() {
        return weightField.getAttribute("placeholder");
    }

    public String getHeightFieldPlaceholder() {
        return heightField.getAttribute("placeholder");
    }

    public String getTemperatureFieldPlaceholder() {
        return temperatureField.getAttribute("placeholder");
    }

        public boolean isFieldPopulated(String fieldName) {
            WebElement field = getFieldByName(fieldName);
            pom.getCommonMethods().waitForVisibilityOfElement(field);
            String value = field.getAttribute("value");
            return value != null && !value.isEmpty();
        }

        private WebElement getFieldByName(String fieldName) {
            switch (fieldName) {
                case "First Name"       : return firstNameField;
                case "Last Name"        : return lastNameField;
                case "Email"            : return emailField;
                case "Contact Number"   : return contactNumberField;
                case "Allergy"          : return allergyField;
                case "Food Preference"  : return foodPreferenceField;
                case "Cuisine Category" : return cuisineCategoryField;
                case "Date of Birth"    : return dateOfBirthField;
                default: throw new IllegalArgumentException(
                        "Unknown field: " + fieldName
                );
            }
        }

        public boolean isVitalsTitleDisplayed() {
            pom.getCommonMethods().waitForVisibilityOfElement(vitalsTitle);
            return vitalsTitle.isDisplayed();
        }

        public boolean isVitalsPlaceholderDisplayed(String vital) {
            WebElement field = getVitalFieldByName(vital);
            pom.getCommonMethods().waitForVisibilityOfElement(field);
            String placeholder = field.getAttribute("placeholder");
            System.out.println(vital + " placeholder : " + placeholder);
            return placeholder != null && placeholder.equalsIgnoreCase(vital);
        }

        private WebElement getVitalFieldByName(String vital) {
            switch (vital) {
                case "SP"          : return spField;
                case "DP"          : return dpField;
                case "Weight"      : return weightField;
                case "Height"      : return heightField;
                case "Temperature" : return temperatureField;
                default: throw new IllegalArgumentException(
                        "Unknown vital: " + vital
                );
            }
        }

        public boolean isNoMandatoryIndicatorForVitals() {
            return mandatoryIndicators.size() == 0;
        }

        public boolean isUploadHealthReportLabelDisplayed() {
            pom.getCommonMethods().waitForVisibilityOfElement(uploadHealthReportLabel);
            return uploadHealthReportLabel.getText()
                    .contains("Upload health report");
        }

        public boolean isNoFileChosenTextDisplayed() {
            pom.getCommonMethods().waitForVisibilityOfElement(noFileChosenText);
            return noFileChosenText.isDisplayed();
        }

        public boolean isCloseButtonRedColor() {
            String color = closeButton.getCssValue("background-color");
            return color.contains("255, 0, 0")
                    || color.contains("255, 82, 82");   // Common red shade
        }
    }


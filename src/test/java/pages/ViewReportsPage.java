package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjectManager.PageObjectManager;
import utilities.CommonMethods;

import java.util.ArrayList;
import java.util.List;


public class ViewReportsPage {

    private WebDriver driver;
    private PageObjectManager pom;

    public ViewReportsPage(WebDriver driver) {
        this.driver = driver;
        this.pom = new PageObjectManager(driver);
        PageFactory.initElements(driver, this);

    }

    @FindBy(linkText = "My Patients")
     WebElement myPatientsLink;

    @FindBy(xpath = "//button[text()='View Previous Test Reports']")
     WebElement viewReportsBtn;

    @FindBy(tagName = "h1")
     WebElement reportsTitle;

    @FindBy(id = "patientId")
     WebElement patientId;

    @FindBy(id = "Name")
     WebElement nameField;

    @FindBy(name = "Email")
     WebElement emailField;

    @FindBy(name = "Contact Number")
     WebElement contactNumberField;

    @FindBy(className = "Close")
     WebElement closeBtn;

    @FindBy(xpath = "//table")
     WebElement reportsTable;

    @FindBy(xpath = "//table//th")
     WebElement reportsTableHeaders;

    @FindBy(xpath = "//span[text()='>>']")
    WebElement lastPageIcon;

    @FindBy(xpath = "//span[text()='>']")
    WebElement nextPageIcon;

    @FindBy(xpath = "//span[text()='<']")
    WebElement previousPageIcon;

    @FindBy(xpath = "//span[text()='<<']")
    WebElement firstPageIcon;

    @FindBy(xpath = "//span[contains(@text,'Showing 1 to 1 test reports']")
    WebElement paginationInfo;

    @FindBy(xpath = "//button[contains(@text,'View PDF']")
    WebElement viewPdfBtn;

    @FindBy(xpath = "//div[@class='vitals-section']//th")
    List<WebElement> vitalHeaders;

    @FindBy(xpath = "//*[contains(text(),'Weight:')]")
    WebElement weightField;

    @FindBy(xpath = "//*[contains(text(),'Height:')]")
    WebElement heightField;

    @FindBy(xpath = "//*[contains(text(),'Temperature:')]")
    WebElement temperatureField;

    @FindBy(xpath = "//*[contains(text(),'SP:')]")
    WebElement spField;

    @FindBy(xpath = "//*[contains(text(),'DP:')]")
    WebElement dpField;

    @FindBy(xpath = "//div[@class='Identified-health']//th")
    List<WebElement> identifiedHealthHeaders;

    @FindBy(xpath = "//*[contains(text(),'Diabetic')]")
    WebElement diabeticField;

    @FindBy(xpath = "//*[contains(text(),'Thyroid')]")
    WebElement thyroidField;

    @FindBy(xpath = "//*[contains(text(),'Blood Pressure')]")
    WebElement bpField;

    @FindBy(xpath = "//*[contains(text(),'PCOS')]")
    WebElement pcosField;

    @FindBy(xpath = "//h1[contains(text(),'View Patient Test Reports')] ")
    WebElement pageTitle;

    @FindBy(xpath = "//button[normalize-space(text())='View PDF']")
    WebElement viewPdfButtons;

    @FindBy(xpath = "//button[text()='>']  | //a[text()='>']")
    WebElement nextArrow;

    @FindBy(xpath = "//button[text()='<']  | //a[text()='<']")
    WebElement previousArrow;

    @FindBy(xpath = "//button[text()='<<'] | //a[text()='<<']")
    WebElement firstArrow;

    @FindBy(xpath = "//button[text()='>>'] | //a[text()='>>']")
    WebElement lastArrow;

    @FindBy(xpath = "//table//tbody//tr")
    List<WebElement> tableRows;

    @FindBy(xpath = "//*[contains(text(),'Showing')]")
    WebElement paginationText;

    @FindBy(xpath = "//h1[contains(text(),'My Patients')]")
    WebElement myPatientsHeader;

    @FindBy(xpath = "//h1[contains(text(),'Dashboard')]")
    WebElement dashboardHeader;

    @FindBy(xpath = "//button[contains(text(),'My Patients')]")
    WebElement myPatientsButton;

    public String getTitle() {
        return pom.getCommonMethods().getText(reportsTitle);
    }

    public String getPatientId() {
        return pom.getCommonMethods().getText(patientId);
    }

    public void navigateToMyPatientsPage() {
        pom.getCommonMethods().clickWebElement(myPatientsLink);
    }

    public void clickTestReports() {
        pom.getCommonMethods().clickWebElement(viewReportsBtn);
    }

    public Boolean isNameDisplayed() {
        return pom.getCommonMethods().waitForVisibilityOfElement(nameField).isDisplayed();
    }

    public Boolean isPatientIdDisplayed() {
        return pom.getCommonMethods().waitForVisibility((By) patientId).isDisplayed();
    }

    public Boolean isEmailDisplayed() {
        return pom.getCommonMethods().waitForVisibilityOfElement(emailField).isDisplayed();
    }

    public Boolean isContactNumberDisplayed() {
        return pom.getCommonMethods().waitForVisibilityOfElement(contactNumberField).isDisplayed();
    }

    public Boolean isCloseBtnDisplayed() {
        return pom.getCommonMethods().waitForVisibilityOfElement(closeBtn).isDisplayed();
    }

    public Boolean isReportTableDisplayed() {
        return pom.getCommonMethods().waitForVisibilityOfElement(reportsTable).isDisplayed();
    }

    public boolean isColumnHeaderPresent(String columnName) {
        List<WebElement> headers = driver.findElements((By) reportsTableHeaders);
        for (WebElement header : headers) {
            if (header.getText().trim().equals(columnName)) {
                return true;
            }
        }
        return false;
    }

    public boolean isColumnOrderCorrect(List<String> expectedOrder) {
        List<WebElement> headers = driver.findElements((By) reportsTableHeaders);
        for (int i = 0; i < expectedOrder.size(); i++) {
            if (!headers.get(i).getText().trim().equals(expectedOrder.get(i))) {
                return false;
            }
        }
        return true;
    }

    public Boolean isFirstPageIconDisplayed() {
        return pom.getCommonMethods().waitForVisibilityOfElement(firstPageIcon).isDisplayed();
    }

    public Boolean isNextPageIconDisplayed() {
        return pom.getCommonMethods().waitForVisibilityOfElement(nextPageIcon).isDisplayed();
    }

    public Boolean isPreviousPageIconDisplayed() {
        return pom.getCommonMethods().waitForVisibilityOfElement(previousPageIcon).isDisplayed();
    }

    public Boolean isLastPageIconDisplayed() {
        return pom.getCommonMethods().waitForVisibilityOfElement(lastPageIcon).isDisplayed();
    }

    public Boolean isViewPdfBtnDisplayed() {
        return pom.getCommonMethods().waitForVisibilityOfElement(viewPdfBtn).isDisplayed();
    }

    public List<String> getActualVitalsOrder() {
        List<String> actualOrder = new ArrayList<>();
        for (WebElement element : vitalHeaders) {
            actualOrder.add(element.getText().trim());
        }
        return actualOrder;
    }

    public boolean areVitalsDisplayedInMultiLines() {
        boolean weightDisplayed = weightField.isDisplayed();
        boolean heightDisplayed = heightField.isDisplayed();
        boolean tempDisplayed = temperatureField.isDisplayed();
        boolean spDisplayed = spField.isDisplayed();
        boolean dpDisplayed = dpField.isDisplayed();
        int weightY = weightField.getLocation().getY();
        int heightY = heightField.getLocation().getY();
        int tempY = temperatureField.getLocation().getY();
        int spY = spField.getLocation().getY();
        int dpY = dpField.getLocation().getY();
        boolean isMultiline = (weightY < heightY) &&
                (heightY < tempY) &&
                (tempY < spY) &&
                (spY < dpY);
        return weightDisplayed && heightDisplayed && tempDisplayed
                && spDisplayed && dpDisplayed && isMultiline;
    }

    public List<String> getActualHealthConditionsOrder() {
        List<String> actualOrder = new ArrayList<>();
        for (WebElement element : identifiedHealthHeaders) {
            actualOrder.add(element.getText().trim());
        }
        return actualOrder;
    }

    public boolean isConditionsOrderInMultiLines() {
        boolean diabeticDisplayed = diabeticField.isDisplayed();
        boolean thyroidDisplayed = thyroidField.isDisplayed();
        boolean bpDisplayed = bpField.isDisplayed();
        boolean pcosDisplayed = pcosField.isDisplayed();
        int diabeticY = diabeticField.getLocation().getY();
        int thyroidY = thyroidField.getLocation().getY();
        int bpY = bpField.getLocation().getY();
        int pcosY = pcosField.getLocation().getY();
        boolean isMultiline = (diabeticY < thyroidY) &&
                (thyroidY < bpY) &&
                (bpY < pcosY);
        return diabeticDisplayed && thyroidDisplayed && bpDisplayed
                && pcosDisplayed && isMultiline;
    }

    public boolean isOnViewTestReportsPage() {
        pom.getCommonMethods().waitForVisibilityOfElement(pageTitle);
        return pageTitle.isDisplayed();
    }

    public String getCurrentWindowHandle() {
        return driver.getWindowHandle();
    }

    public void clickViewPdfButton() {
        WebElement btn = pom.getCommonMethods().clickWebElement(viewPdfButtons);
    }

    public boolean isPdfReportOpened(String originalWindowHandle) {

        for (String window : driver.getWindowHandles()) {
            if (!window.equals(originalWindowHandle)) {
                driver.switchTo().window(window);
                break;
            }
        }
        String currentUrl = driver.getCurrentUrl().toLowerCase();
        return currentUrl.contains("pdf");
    }


    public void navigateToPage(String startCondition) {

        switch (startCondition) {

            case "View Patient Test Reports page with multiple records":
                pom.getCommonMethods().waitForVisibilityOfElements((WebElement) tableRows);
                break;

            case "Report table of View Patient Test Reports page":
                pom.getCommonMethods().waitForVisibilityOfElements((WebElement) tableRows);
                break;

            case "any page except first page of Report table":
                clickPaginationArrow(">");
                break;

            case "any page except last page of Report table":

                pom.getCommonMethods().clickWebElement(firstArrow);
                break;

            default:
                throw new IllegalArgumentException(
                        "Unknown start condition: " + startCondition
                );
        }
    }

    public void clickPaginationArrow(String arrow) {
        switch (arrow) {
            case ">" -> pom.getCommonMethods().clickWebElement(nextArrow);
            case "<" -> pom.getCommonMethods().clickWebElement(previousArrow);
            case "<<" -> pom.getCommonMethods().clickWebElement(firstArrow);
            case ">>" -> pom.getCommonMethods().clickWebElement(lastArrow);
            default -> throw new IllegalArgumentException(
                    "Unknown arrow: " + arrow);
        }
    }

    public boolean verifyRecordsDisplayed(String expectedResult) {

        pom.getCommonMethods().waitForVisibilityOfElement(paginationText);

        switch (expectedResult){

            case "Next set of patient records":
            case "Previous set of patient records":
                return tableRows.size() > 0;

            case "First page of patient records":
                return paginationText.getText().contains("Showing 1 to");

            case "Last page of patient records":
                return !nextArrow.isEnabled() && !lastArrow.isEnabled();

            default:
                throw new IllegalArgumentException("Unknown expected result: " + expectedResult);
        }
    }
    public boolean isReportTableVisible() {

        pom.getCommonMethods().waitForVisibilityOfElements((WebElement) tableRows);

        // If rows count is more than 0 - table has data - return true
        return tableRows.size() > 0;
    }

    public boolean isPaginationTextCorrect() {
        pom.getCommonMethods().waitForVisibilityOfElement(paginationText);

        String actualText = paginationText.getText();

        boolean isCorrect = actualText.matches(
                "Showing \\d+ to \\d+ of \\d+ patients"
        );
        return isCorrect;
    }
    public boolean isPaginationControlsDisplayed() {

        boolean isFirstDisplayed    = pom.getCommonMethods().waitForVisibilityOfElement(firstPageIcon).isDisplayed();
        boolean isPreviousDisplayed = pom.getCommonMethods().waitForVisibilityOfElement(previousPageIcon).isDisplayed();
        boolean isNextDisplayed     = pom.getCommonMethods().waitForVisibilityOfElement(nextPageIcon).isDisplayed();
        boolean isLastDisplayed     = pom.getCommonMethods().waitForVisibilityOfElement(lastPageIcon).isDisplayed();
        return isFirstDisplayed && isPreviousDisplayed && isNextDisplayed && isLastDisplayed;
    }

    public void navigateToPosition(String navigateTo) {
        switch (navigateTo) {

            case "first page of patient record":
                pom.getCommonMethods().clickWebElement(firstPageIcon);
                break;

            case "any page after the first page":
                pom.getCommonMethods().clickWebElement(firstPageIcon);
                pom.getCommonMethods().clickWebElement(nextPageIcon);
                break;

            case "any page except the last page":
                pom.getCommonMethods().clickWebElement(firstPageIcon);
                break;

            case "last page of patient record":
                pom.getCommonMethods().clickWebElement(lastPageIcon);
                break;

            default:
                throw new IllegalArgumentException(
                        "Unknown navigation: " + navigateTo
                );
        }
    }

    public boolean isArrowInExpectedState(String arrow, String state) {

        WebElement arrowElement = getArrowElement(arrow);

        if (state.equals("enabled")) {
            return arrowElement.isEnabled();
        } else if (state.equals("disabled")) {
            return !arrowElement.isEnabled();
        } else {
            throw new IllegalArgumentException(
                    "Unknown state: " + state
            );
        }
    }

    private WebElement getArrowElement(String arrow) {
        switch (arrow) {
            case "<"  : return previousPageIcon;
            case "<<" : return firstPageIcon;
            case ">"  : return nextPageIcon;
            case ">>" : return lastPageIcon;
            default   : throw new IllegalArgumentException(
                    "Unknown arrow symbol: " + arrow
            );
        }
    }
    public boolean isMyPatientsPageDisplayed() {
        pom.getCommonMethods().waitForVisibilityOfElement(myPatientsHeader);
        return myPatientsHeader.isDisplayed();
    }

    public boolean isFirstPageArrowDisabled() {
        pom.getCommonMethods().waitForVisibilityOfElement(firstPageIcon);
        return !firstPageIcon.isEnabled();
    }

    public boolean isPreviousPageArrowDisabled() {
        pom.getCommonMethods().waitForVisibilityOfElement(previousPageIcon);
        return !previousPageIcon.isEnabled();
    }
    public boolean isNextPageArrowDisabled() {
        pom.getCommonMethods().waitForVisibilityOfElement(nextPageIcon);
        return !nextPageIcon.isEnabled();
    }

    public boolean isLastPageArrowDisabled() {
        pom.getCommonMethods().waitForVisibilityOfElement(lastPageIcon);
        return !lastPageIcon.isEnabled();
    }
    public boolean isDashboardPageDisplayed() {
        pom.getCommonMethods().waitForVisibilityOfElement(dashboardHeader);
        return dashboardHeader.isDisplayed();
    }

    public void clickMyPatientsButton() {
        pom.getCommonMethods().clickWebElement(myPatientsButton);
    }
    public int getRecordsCountOnCurrentPage() {
        pom.getCommonMethods().waitForVisibilityOfElement(tableRows.get(0));
        int actualCount = tableRows.size();
        return actualCount;
    }

}

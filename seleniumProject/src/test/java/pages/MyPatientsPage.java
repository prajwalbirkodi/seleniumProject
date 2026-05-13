package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utilities.LoggerFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MyPatientsPage {
	//Web elements and methods of Page Header, search 
	    WebDriver driver;
	    LoggerFactory log;
	   
	    public MyPatientsPage(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }
	
	    // Page header for Test Reports
	    

	    @FindBy(xpath = "//h1[text()='My Patients']")
	    WebElement pageHeader;

	        
	    @FindBy(xpath = "//input[@id='search-bar']")
	    WebElement searchBar;

	    @FindBy(xpath = "//i[contains(@class,'search')]")
	    WebElement searchIcon;
	    
	    //Table

	    @FindBy(xpath = "//th")
	    List<WebElement> tableHeaders;
	    
	    @FindBy(xpath = "//table/tbody/tr")
	    List<WebElement> tableRows;
	    
	    @FindBy(xpath = "//table/tbody/tr/td")
        List<WebElement> tableCells;


	    @FindBy(xpath = "//th[contains(text(),'Patient Id')]//i[contains(@class,'sort')]")
	    List<WebElement> patientIdSortIcons;

	    @FindBy(xpath = "//th[contains(text(),'Name')]")
	    List<WebElement> nameSortIcons;
	    
	    // ACTIONS

        @FindBy(xpath = "//a[contains(text(),'View Previous Test Reports')]")
        List<WebElement> viewReportsLinks;

        @FindBy(xpath = "//a[contains(text(),'View Previous Diet Plans')]")
        List<WebElement> viewDietLinks;

        @FindBy(xpath = "//a[contains(text(),'Create New Report/plan')]")
        List<WebElement> createReportLinks;

        @FindBy(xpath = "//i[contains(@class,'edit')]")
        List<WebElement> editIcons;

        @FindBy(xpath = "//i[contains(@class,'delete')]")
        List<WebElement> deleteIcons;

	 // Pagination
	    @FindBy(id="firstPage") WebElement firstArrow;
	    @FindBy(id="previousPage") WebElement previousArrow;
	    @FindBy(id="nextPage") WebElement nextArrow;
	    @FindBy(id="lastPage") WebElement lastArrow;
	    @FindBy(id="paginationText") WebElement paginationText;
	    @FindBy(xpath = "//ul[contains(@class,'pagination')]/li/button[not(contains(@class,'first')) and not(contains(@class,'last'))]")
	    List<WebElement> pageButtons;

	    // Navigation to Test Reports
	    @FindBy(xpath = "//a[contains(text(),'View Previous Test Reports')]") List<WebElement> testReports;
	    
	    public void pageHeaderBtn() {
	    	pageHeader.click();
		}
	    
	    public String getPageHeader() {
	        return pageHeader.getText();
	    }

	    public boolean isSearchBarDisplayed() {
	        return searchBar.isDisplayed();
	    }

	    public boolean isSearchIconDisplayed() {
	        return searchIcon.isDisplayed();
	    }

	    public String getSearchPlaceholder() {
	        return searchBar.getAttribute("placeholder");
	    }

	    public boolean isColumnDisplayed(String columnName) {
	        for (WebElement col : tableHeaders) {
	            if (col.getText().trim().equalsIgnoreCase(columnName)) {
	                return true;
	            }
	        }
	        return false;
	    }
	    public boolean isPatientIdSortIconDisplayed() {
	        return patientIdSortIcons.size() > 0;
	    }

	    public boolean isNameSortIconDisplayed() {
	        return nameSortIcons.size() > 0;
	    }
	   
	 //Patient Table
	 
       
       

       

        // ================= METHODS =================

        // Check table empty
        public boolean isTableEmpty() {
            return tableRows.size() == 0;
        }

        // Check all cells filled
        public boolean areAllCellsFilled() {
            for (WebElement cell : tableCells) {
                if (cell.getText().trim().isEmpty()) {
                    return false;
                }
            }
            return true;
        }

        // Validate column presence
        public boolean isColumnPresent(String columnName) {
            for (WebElement header : tableHeaders) {
                if (header.getText().trim().equalsIgnoreCase(columnName)) {
                    return true;
                }
            }
            return false;
        }

        // ================= FORMAT VALIDATION =================

        public boolean isValidEmail(String value) {
            return value.matches("^[A-Za-z0-9+_.-]+@(.+)$");
        }

        public boolean isNumeric(String value) {
            return value.matches("\\d+");
        }

        public boolean isValidDate(String value) {
            return value.matches("\\d{2}-\\d{2}-\\d{4}");
        }

        
        public String getCellData(int row, int col) {
            return driver.findElement(
                    By.xpath("//table/tbody/tr[" + row + "]/td[" + col + "]")
            ).getText();
        }
        
        public boolean validateFieldFormat(String field, String value) {

            switch (field.toLowerCase()) {

                case "email":
                    return isValidEmail(value);

                case "phone number":
                    return isNumeric(value);

                case "date of birth":
                case "last visit date":
                    return isValidDate(value);

                default:
                    return false;
            }
        }
        // ================= ACTION VALIDATION =================

        public boolean areViewReportsLinksDisplayed() {
            return viewReportsLinks.size() > 0;
        }

        public boolean areViewDietPlansDisplayed() {
            return viewDietLinks.size() > 0;
        }

        public boolean areCreateReportsDisplayed() {
            return createReportLinks.size() > 0;
        }

        public boolean areEditIconsDisplayed() {
            return editIcons.size() > 0;
        }

        public boolean areDeleteIconsDisplayed() {
            return deleteIcons.size() > 0;
        }

        public boolean isActionDisplayed(String action) {

            switch (action.toLowerCase()) {

                case "view previous test reports":
                    return viewReportsLinks.size() > 0;

                case "view previous diet plans":
                    return viewDietLinks.size() > 0;

                case "create new report/plan":
                    return createReportLinks.size() > 0;

                default:
                    return false;
            }
        }
        
	//-------------------------------------------------------------  Patient Table Management----------------------------------------------------
        
        @FindBy(xpath = "//th[@id='patientId']//span[@class='asc']")
        WebElement patientIdAsc;

        @FindBy(xpath = "//th[@id='patientId']//span[@class='desc']")
        WebElement patientIdDesc;

        @FindBy(xpath = "//th[@id='name']//span[@class='asc']")
        WebElement nameAsc;

        @FindBy(xpath = "//th[@id='name']//span[@class='desc']")
        WebElement nameDesc;

        @FindBy(id = "search")
        WebElement searchBox;

        @FindBy(id = "clearSearch")
        WebElement clearBtn;

      
        // Navigation
        public void navigateToPatientsPage() {
            //driver.get("https://yourapp.com/patients");
        }

        // Sorting actions
        public void clickPatientIdAsc() { patientIdAsc.click(); }
        public void clickPatientIdDesc() { patientIdDesc.click(); }
        public void clickNameAsc() { nameAsc.click(); }
        public void clickNameDesc() { nameDesc.click(); }

        // Search
        public void enterSearch(String value) {
            searchBox.clear();
            searchBox.sendKeys(value);
        }

        public void clearSearch() { clearBtn.click(); }

        // Validations
        public void verifyPatientIdSorting(boolean asc) {

            List<Integer> actual = new ArrayList<>();
            for (WebElement row : tableRows) {
                actual.add(Integer.parseInt(row.findElement(By.xpath("td[1]")).getText()));
            }

            List<Integer> expected = new ArrayList<>(actual);
            Collections.sort(expected);
            if (!asc) Collections.reverse(expected);

            Assert.assertEquals(actual, expected);
        }

        public void verifyNameSorting(boolean asc) {

            List<String> actual = new ArrayList<>();
            for (WebElement row : tableRows) {
                actual.add(row.findElement(By.xpath("td[2]")).getText());
            }

            List<String> expected = new ArrayList<>(actual);
            Collections.sort(expected);
            if (!asc) Collections.reverse(expected);

            Assert.assertEquals(actual, expected);
        }

        public void verifySearchResults() {
            Assert.assertTrue(tableRows.size() > 0);
        }

        public void verifyAllRecordsVisible() {
            Assert.assertTrue(tableRows.size() > 1);
        }
   //------------------------------------------------------------------Pagination Mangemnet----------------------------------------------------------------
     

        public String getPaginationText() {
            return paginationText.getText().trim();
        }

        public boolean isFirstDisabled() {
            return !firstArrow.isEnabled();
        }

        public boolean isPreviousDisabled() {
            return !previousArrow.isEnabled();
        }

        public boolean isNextDisabled() {
            return !nextArrow.isEnabled();
        }

        public boolean isLastDisabled() {
            return !lastArrow.isEnabled();
        }

        public boolean isPaginationControlDisabled(String control) {

            switch (control.toLowerCase()) {

                case "first":
                    return !firstArrow.isEnabled();

                case "previous":
                    return !previousArrow.isEnabled();

                case "next":
                    return !nextArrow.isEnabled();

                case "last":
                    return !lastArrow.isEnabled();

                default:
                    throw new IllegalArgumentException("Invalid pagination control: " + control);
            }
        }
        public boolean isArrowEnabled(String arrowName) {
            WebElement arrow = getArrow(arrowName);
            boolean enabled = arrow.isEnabled();
                        return enabled;
        }
        public void clickArrow(String arrowName) {
            WebElement arrow = getArrow(arrowName);
                       arrow.click();
        }
        public void clickPageNumber(int pageNumber) {
           
            for (WebElement btn : pageButtons) {
                if (btn.getText().trim().equals(String.valueOf(pageNumber))) {
                    btn.click();
                    return;
                }
            }
           
        }
        private WebElement getArrow(String arrowName) {
            return switch (arrowName.toLowerCase()) {
                case "first" -> firstArrow;
                case "previous" -> previousArrow;
                case "next" -> nextArrow;
                case "last" -> lastArrow;
                default -> throw new IllegalArgumentException("Unknown arrow: " + arrowName);
            };
        }
        // ---------------------------------------- Navigation to Test Reports----------------------------------
        @FindBy(xpath = "//h1[text()='View Patient Test Reports']")
        WebElement testReportsPageHeader;
        public void clickViewPreviousTestReports() {
        	if (!testReports.isEmpty()) {
        		testReports.get(0).click();
            }
        }
        // Verify that Test Reports page is displayed
        public boolean isOnTestReportsPage() {
            return testReportsPageHeader.isDisplayed();
        }	   
        
        
    }
	


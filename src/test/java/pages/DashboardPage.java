package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DashboardPage {

    WebDriver driver;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".navbar a")
    List<WebElement> navbarLinks;

    @FindBy(linkText = "My Patients")
    WebElement myPatients;

    @FindBy(linkText = "New Patient")
    WebElement newPatient;

    @FindBy(linkText = "Logout")
    WebElement logout;

    @FindBy(css = ".home-icon")
    WebElement homeIcon;


    public boolean isDashboard() {
        return driver.getTitle().contains("Dashboard");
    }  
    
    public int getNavbarLinksCount() {
        return navbarLinks.size();
    }

    public void clickOnLink(String link) {
        switch (link) {
            case "My Patients":
                myPatients.click();
                break;
            case "New Patient":
                newPatient.click();
                break;
            case "Logout":
                logout.click();
                break;
            case "Home icon":
                homeIcon.click();
                break;
            default:
                throw new IllegalArgumentException("Invalid link: " + link);
        }
    }

    public String getPageTitle() {
        return driver.getTitle();
    }
}


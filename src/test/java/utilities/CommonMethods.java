package utilities;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



import java.time.Duration;
import java.util.List;

public class CommonMethods {

	private WebDriver driver;
	private WebDriverWait wait;

	public CommonMethods(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	}

	public WebElement clickWebElement(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element)).click();
		return element;
	}

	public WebElement waitForVisibility(By locator) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public WebElement waitForVisibilityOfElement(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
        return element;
    }

	public String getText(By locator) {
        return waitForVisibility(locator).getText().trim();
    }

    public void scrollWaitAndClick(WebElement element) {
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block:'center'});", element);
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void clickElementByText(String text) {
        By optionLocator = By.xpath("//mat-option//span[contains(text(),\"" + text + "\")]");
        try {
            WebElement option = wait.until(ExpectedConditions.elementToBeClickable(optionLocator));
            option.click();
        } catch (Exception e) {
            System.err.println("CRITICAL: Could not find or click the option: " + text);
            throw e;
        }
    }

    // This is the method from the Integration branch, corrected to handle a List
    public List<WebElement> waitForVisibilityOfAllElements(List<WebElement> elements) {
        return wait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }

	public boolean isElementPresentByText(List<WebElement> elements,
			String text) {

		if (elements == null || elements.isEmpty()) {
			return false;
		}
		for (WebElement element : elements) {
			if (element.getText() != null && element.getText().trim().equalsIgnoreCase(text.trim())) {
				return true;
			}
		}
		return false;
	}

	public boolean isElementTextEquals(WebElement element,
			String expectedText) {

		if (element == null || expectedText == null) {
			return false;
		}
		String actualText = element.getText().trim();
		return actualText.equalsIgnoreCase(expectedText.trim());
	}

		

		
	public WebElement waitForVisibilityOfElements(WebElement element) {
		wait.until(ExpectedConditions.visibilityOfAllElements(element));
		return element;
	}
  
	public String getText(WebElement element) {

		if (element != null) {
			return element.getText().trim();
		}
		return null;

	}

	public String getAlert() {

		try {
			Alert alert = driver.switchTo().alert();
			String alertMsg = alert.getText();
			alert.accept();
			System.out.println("alert is" + alertMsg);

			return (alertMsg);
		} catch (NoAlertPresentException e) {
			return null;
		}

	}
	public boolean isElementDisplayed(WebElement element) {
        try {
            
            return element.isDisplayed(); 
        } catch (NoSuchElementException | StaleElementReferenceException | NullPointerException e) {
         
            return false; 
        }
    }
public void sendKeys(WebElement element, String text) {
     try {
         
         if (element.isDisplayed() && element.isEnabled()) {
             element.clear(); 
             element.sendKeys(text);
         }
     } catch (Exception e) {
         System.out.println("Error sending keys to element: " + e.getMessage());
     }
 }


}

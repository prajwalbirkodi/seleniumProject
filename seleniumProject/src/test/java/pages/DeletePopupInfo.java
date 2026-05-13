package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import pageObjectManager.PageObjectManager;

public class DeletePopupInfo {

	WebDriver driver;
	private PageObjectManager pom;


	public DeletePopupInfo(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//button[@icon='pi pi-trash']")
	public WebElement deleteIcon;

	@FindBy(xpath = "//button[text() ='Yes']")
	WebElement yesButton;

	@FindBy(xpath = "//button[text() ='No']")
	WebElement noButton;

	@FindBy(xpath = "//*[text()='Are You Sure']")
	WebElement deleteAlertText;
	
	@FindBy(xpath = "//*[text()='Success Delete Msg']")
	WebElement deleteSuccessMesg;

	@FindBy(xpath = "//button[text() ='close']")
	WebElement deletePopupXButton;

	@FindBy(xpath = "//*[text()='Confirm']")
	WebElement confirmDeletePopupTitle;
	
	@FindBy(xpath ="//tabl[@id = 'patientTable']")
	 List<WebElement> patientNames;
	
	@FindBy(xpath = "//button[text() ='Delete']")
	List<WebElement> deleteButtons;
	
	public void clickDeleteIcon()
	{
		pom.getCommonMethods().clickWebElement(deleteIcon); //check this
	}

	public void clickDeleteIcon(String patientName)
	{
		for(int i =0;i<patientNames.size();i++) {
			if(patientNames.get(i).getText().equalsIgnoreCase(patientName))
			{
				deleteButtons.get(i).click();
				break;
			}
		}
	}
	public boolean isYesButtonDisplayed()
	{
		return pom.getCommonMethods().isElementDisplayed(yesButton);
	}
	
	public boolean isNoButtonDisplayed()
	{
		return pom.getCommonMethods().isElementDisplayed(noButton);
	}
	
	public String getAlertText() {
		return pom.getCommonMethods().getText(deleteAlertText);
	}
	
	public boolean isAlertTitleDisplayed()
	{
		return pom.getCommonMethods().isElementDisplayed(confirmDeletePopupTitle);
	}
	
	
}

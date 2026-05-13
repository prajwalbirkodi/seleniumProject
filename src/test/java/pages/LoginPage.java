package pages;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;
	import org.openqa.selenium.support.Color;

		public class LoginPage {

			WebDriver driver;

			public LoginPage(WebDriver driver) {
				this.driver = driver;
				PageFactory.initElements(driver, this);
			}
	
	//Fields			
			@FindBy(id="id_username")
			WebElement username;

			@FindBy(id="id_password")
			WebElement password;
	// buttons
			@FindBy(xpath="//input[@type='submit']")
			WebElement loginBtn;

			@FindBy(linkText ="Log out") 
			WebElement logoutButton;
	//Navigation Bar
			@FindBy(xpath ="//div[@class='bs-example']")
			WebElement navigationBar;
	//Navigation Bar title
			@FindBy(xpath ="//a[text() = \"NumpyNinja\"]")
			WebElement navBartitleText;
			
	//Home icon
			@FindBy(xpath ="//*[@class='navbar-brand']")
			WebElement homeIcon;
	//Login Card title
			@FindBy(css = ".login-title")
			WebElement logincardtitle;
	//Labels
			@FindBy(xpath = "//label[text() =\"Username:\"]")
			WebElement usernameLabel;
			
			@FindBy(xpath = "//label[text() =\"Password:\"]")
			WebElement passwordLabel;
			
			@FindBy(xpath="//div[contains(text(),'You are logged in')]") 
			WebElement loginalert;
	//DashboardPage
			@FindBy(xpath="//div[contains(text(),'You are logged in')]") 
			WebElement dashboard;

	//Messages		
			 @FindBy(css=".error-msg")
			    WebElement errorMsg;
	
			 @FindBy(xpath="//*[text()=\"Sign in\"]")
				WebElement logIn;
			 
	//UI Methods
			 
			    public String getNavTitleText() {
			        return navBartitleText.getText();
			    }

			    public boolean isHomeIconVisible() {
			        return homeIcon.isDisplayed();
			    }

			    public String isDashboardDisplayed() {
			    	
			    	return driver.getTitle();			    }
			    
			    public String getLoginCardHeading() {
			        return logincardtitle.getText();
			    }

			    public String getUsernameLabelText() {
			        return usernameLabel.getText();
			    }

			    public String getPasswordLabelText() {
			        return passwordLabel.getText();
			    }

			    public String getUsernameLabelAlignment() {
			        return usernameLabel.getCssValue("text-align");
			    }

			    public String getPasswordLabelAlignment() {
			        return passwordLabel.getCssValue("text-align");
			    }

			    public boolean isUsernameFieldVisible() {
			        return username.isDisplayed();
			    }

			    public boolean isPasswordFieldVisible() {
			        return password.isDisplayed();
			    }

			    public boolean isLoginButtonVisible() {
			        return loginBtn.isDisplayed();
			    }

			    public boolean isLoginButtonEnabled() {
			        return loginBtn.isEnabled();
			    }

			    public String getNavBarColor() {
			        return navigationBar.getCssValue("background-color");
			    }

			    private String getHexColor(String cssValue) {
			        return Color.fromString(cssValue).asHex();
			    }
			    public boolean isBluePurple(String cssValue)
			    {
			    	String hex = getHexColor(cssValue);
			        return hex.equalsIgnoreCase("##4b0082")||
			        	   hex.equalsIgnoreCase("#6a5acd");
			    }
			    public boolean isLoginButtonBgBluePurple() {
			        return isBluePurple(loginBtn.getCssValue("background-color"));
			    }
			    public boolean isWhite(String cssValue) {
			        String hex = getHexColor(cssValue);
			        return hex.equalsIgnoreCase("#ffffff");
			    }
			    public boolean isLoginButtonTextWhite() {
			        return isWhite(loginBtn.getCssValue("color"));
			    }
			    public String getLoginButtonBgColor() {
			        return loginBtn.getCssValue("background-color");
			    }

			    public void clicklogIn()
			    {
			    	logIn.click();
			    }
			    
			    
	//Functional Methods		   
			    public void enterUsername(String user) {
			        username.clear();
			        username.sendKeys(user);
			    }

			    public void enterPassword(String pass) {
			        password.clear();
			        password.sendKeys(pass);
			    }
		
			    public void validlogin(String user, String pasword)
			    {
			    	 username.clear();
				        username.sendKeys(user);
				        password.clear();
				        password.sendKeys(pasword);
				        loginBtn.click();
				        
			    }
			    public void clickLoginBtn()
			    {
			        loginBtn.click();

			    }
			    
			    public String getErrorMessage() {
			        return errorMsg.getText();
			    }
		
			   
			 /*   public void LoginwithvalidCred(String user, String pasword) {
			        username.sendKeys(user);
			        password.sendKeys(pasword);
			 	    loginBtn.click();
			    }
			    */
			        public void DietitianPageUrl() {
			    		String currenturl = driver.getCurrentUrl();
			    		System.out.println("The user is on the" + currenturl + " Page ");
			    	}
			    }

		
		
		
		
		
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		


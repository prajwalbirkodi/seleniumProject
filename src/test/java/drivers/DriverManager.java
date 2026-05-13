package drivers;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utilities.ConfigReader;
public class DriverManager {
    private static final ThreadLocal<WebDriver> testdriver = new ThreadLocal<>();
    private static final ThreadLocal<String> driverbrowser = new ThreadLocal<>();
    public static void initBrowser() {
        String browserType = driverbrowser.get();
        if (browserType == null) {
            browserType = ConfigReader.getProperty("browser");
        }
        BrowserOptions browserOptions = new BrowserOptions();
        switch (browserType.toLowerCase()) {
            case "chrome":
                testdriver.set(new ChromeDriver(browserOptions.chromeOption()));
                break;
            case "edge":
                testdriver.set(new EdgeDriver(browserOptions.edgeOption()));
                break;
            case "firefox":
                testdriver.set(new FirefoxDriver(browserOptions.firefoxOption()));
                break;
            default:
                throw new IllegalStateException("Invalid browser: " + browserType);
        }
        getDriver().get(ConfigReader.getProperty("url"));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        getDriver().manage().window().maximize();
    }
    public static WebDriver getDriver() {
        return testdriver.get();
    }
    public static void setBrowser(String browser) {
        driverbrowser.set(browser);
    }
    public static void quitDriver() {
        if (testdriver.get() != null) {
            testdriver.get().quit();
            testdriver.remove();
        }
    }
}
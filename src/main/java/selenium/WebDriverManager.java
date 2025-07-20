package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class WebDriverManager {

    private WebDriver driver;

    private static WebDriverManager webDriverManager = null;

    private WebDriverManager() {
    }

    public static WebDriverManager getInstance() {
        if (webDriverManager == null) {
            webDriverManager = new WebDriverManager();
        }
        return webDriverManager;
    }

    public void start() {
        if (driver == null) {
            FirefoxOptions options = new FirefoxOptions();
          //  options.addArguments("--headless");

            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
    }

    public void close() {
        driver.quit();
        driver=null;
    }

    public WebDriver getDriver() {
        if (driver != null) {
            return driver;
        }
        return null;

    }
}

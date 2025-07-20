package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--user-data-dir=/tmp/chrome-profile-" + System.currentTimeMillis());
            options.addArguments("--headless=new", "--disable-gpu", "--no-sandbox");
            //  options.addArguments("--headless");
            System.setProperty("webdriver.chrome.driver","/usr/bin/chromedriver");
            driver = new ChromeDriver(options);
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

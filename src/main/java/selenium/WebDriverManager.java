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
            options.addArguments("--headless=new");
            options.addArguments("--window-size=1920,1080");
            System.setProperty("webdriver.chrome.driver","/usr/bin/chromedriver");
            driver = new ChromeDriver(options);
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

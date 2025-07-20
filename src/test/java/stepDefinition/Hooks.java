package stepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import selenium.WebDriverManager;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Hooks {

    @Before
    public void init(){
        System.out.println("Browser: "+System.getProperty("browser"));
        String browser=System.getProperty("browser");
        if(browser.equals("chrome"))
        WebDriverManager.getInstance().start();
        else
            System.out.println("Browser is not provided");
    }
    @After(order = 0)
    public void close(){
        WebDriverManager.getInstance().close();
    }
    @After(order = 1)
    public void takeScreenShot(Scenario scenario) {

        if (scenario.isFailed()) {

            try {
                byte[] screenshot = ((TakesScreenshot) WebDriverManager.getInstance().getDriver()).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", "Failure Screenshot");

            } catch (Exception e) {
                System.out.println("Failed to save screenshot: " + e.getMessage());
            }
        }

    }
}

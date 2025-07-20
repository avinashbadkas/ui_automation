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
        WebDriverManager.getInstance().start();
    }
    @After(order = 0)
    public void close(){
        WebDriverManager.getInstance().close();
    }
    @After(order = 1)
    public void takeScraenshotOnFailure(Scenario scenario) {

        if (scenario.isFailed()) {

            try {
                // Take screenshot as a file
                File srcFile = ((TakesScreenshot) WebDriverManager.getInstance().getDriver()).getScreenshotAs(OutputType.FILE);

                // Timestamp for uniqueness
                String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));

                // Clean scenario name
                String name = scenario.getName().replaceAll("[^a-zA-Z0-9-_]", "_");

                // Destination path
                Path destPath = Path.of("target/screenshots", name + "_" + timestamp + ".png");

                // Ensure folder exists
                Files.createDirectories(destPath.getParent());

                // Copy file
                Files.copy(srcFile.toPath(), destPath, StandardCopyOption.REPLACE_EXISTING);

                // Attach to Cucumber report
                byte[] screenshot = Files.readAllBytes(destPath);
                scenario.attach(screenshot, "image/png", "Failure Screenshot");

            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Failed to save screenshot: " + e.getMessage());
            }
        }

    }
}

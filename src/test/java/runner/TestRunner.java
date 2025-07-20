package runner;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import selenium.WebDriverManager;

@CucumberOptions(glue = "stepDefinition",
        features = "src/test/resources/features",
        tags = "@regression",plugin = "html:target/reports.html",
        monochrome = true)

public class TestRunner extends AbstractTestNGCucumberTests {

   /* @Before
    public void init() {
       WebDriverManager.getInstance().start();
    }

    @After
    public void close() {
        WebDriverManager.getInstance().close();
    }*/

}

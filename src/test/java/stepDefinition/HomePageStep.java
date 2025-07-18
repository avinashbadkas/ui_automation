package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import pages.homepage.HomePage;
import selenium.WebDriverManager;
import utils.Property;

public class HomePageStep {
    private static final Logger log = LoggerFactory.getLogger(HomePageStep.class);
    Property pro = new Property();

    @Given("navigate to the application url")
    public void navigate_to_the_application_url() {
        WebDriverManager.getInstance().getDriver().get("https://insurity.com/");
    }

    @Then("user verify the {string}")
    public void user_verify_the(String string) {
        // Write code here that turns the phrase above into concrete actions
        HomePage homePage = new HomePage();
        System.out.println(String.valueOf(homePage.getTopTitleMenu()));
        System.out.println(pro.getPropertyAsList("toptitlemenu"));
        Assert.assertEquals(homePage.getTopTitleMenu(),pro.getPropertyAsList("toptitlemenu"));

    }


}

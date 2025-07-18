package pages.search;

import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v136.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.homepage.HomePage;
import selenium.WebDriverManager;

public class SearchPage {
    WebDriver driver = null;
    @FindBy(xpath = "//input[@data-drupal-selector='edit-search']")
    WebElement searchInput;
    @FindBy(xpath = "//input[@data-drupal-selector='edit-submit-search']")
    WebElement applyButton;
    //verifies the first search paragraph
    @FindBy(xpath = "//div[@class='views-row']")
    WebElement searchParagraph;

    public SearchPage() {
        this.driver = WebDriverManager.getInstance().getDriver();
        PageFactory.initElements(driver, this);
    }

    public void searchPageDisplayed() {
        Assert.assertTrue(searchInput.isDisplayed());
        Assert.assertTrue(applyButton.isDisplayed());
        Assert.assertTrue(searchParagraph.isDisplayed());
    }


    public void searchKeyword(String keyword) {

    }
}

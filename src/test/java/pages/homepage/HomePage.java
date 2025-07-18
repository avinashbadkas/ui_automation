package pages.homepage;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import selenium.WebDriverManager;

import java.util.List;
import java.util.stream.Collectors;

//This is page factory design pattern class
public class HomePage {
    WebDriver driver;

    @FindBy(xpath = "//ul[contains(@class,'coh-menu-list-container coh-unordered-list menu')]/li/a[not(contains(@class,'btnSearch link--hash'))]")
    public List<WebElement> topHeader;
    @FindBy(xpath = "//a[@class='btnSearch link--hash']")
    public WebElement searchIcon;
    @FindBy(xpath = "//input[@class='txtSearch']")
    public WebElement searchInput;

    public HomePage() {

        this.driver = WebDriverManager.getInstance().getDriver();
        PageFactory.initElements(driver, this);
    }

    public List<String> getTopTitleMenu() {

        return topHeader.stream().map(elem -> elem.getText()).
                map(elem -> elem.trim()).
                collect(Collectors.toList());
    }

    public void searchKeyword(String keyword)  {
        searchIcon.click();
        searchInput.sendKeys(keyword, Keys.ENTER);
        try{
            Thread.sleep(5000);
        }
        catch (Exception e){

        }

    }
}

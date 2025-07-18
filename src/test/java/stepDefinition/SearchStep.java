package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.homepage.HomePage;
import pages.search.SearchPage;

public class SearchStep {

    @Given("user search the {string} on the homepage")
    public void user_search_the_on_the_homepage(String string) {
        HomePage homePage=new HomePage();
        homePage.searchKeyword(string);
        // Write code here that turns the phrase above into concrete actions


    }
    @Then("user verify the search screen for the {string}")
    public void user_verfy_the_search_screen_for_the(String string) {
        SearchPage searchPage=new SearchPage();
        searchPage.searchPageDisplayed();
        // Write code here that turns the phrase above into concrete actions

    }
}

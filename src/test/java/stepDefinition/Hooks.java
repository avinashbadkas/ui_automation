package stepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import selenium.WebDriverManager;

public class Hooks {

    @Before
    public void init(){
        WebDriverManager.getInstance().start();
    }
    @After
    public void close(){
        WebDriverManager.getInstance().close();
    }
}

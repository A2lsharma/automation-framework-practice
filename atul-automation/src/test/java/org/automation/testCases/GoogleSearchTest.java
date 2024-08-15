package src.test.java.org.automation.testCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import src.test.java.org.automation.pages.BaseClass;
import src.test.java.org.automation.pages.GoogleSearchPage;

public class GoogleSearchTest extends BaseClass {
    GoogleSearchPage google;

    @Test
    public void search_on_google(){
        System.out.println(driver.getTitle());
        google = PageFactory.initElements(driver, GoogleSearchPage.class);
        google.searchText("Unacademy");
    }
}

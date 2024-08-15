package src.test.java.org.automation.testCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import src.test.java.org.automation.pages.BaseClass;
import src.test.java.org.automation.pages.GoogleSearchPage;
import src.test.java.org.automation.utility.ExcelDataProvider;

public class GoogleSearchTest extends BaseClass {
    GoogleSearchPage google;
    @Test
    public void search_on_google(){
        System.out.println(driver.getTitle());
        google = new GoogleSearchPage(driver);
        google.searchText(dataProvider.getStringData("Sheet1",0,0));
    }
}

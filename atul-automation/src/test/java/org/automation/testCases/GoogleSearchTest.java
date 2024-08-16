package src.test.java.org.automation.testCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import src.test.java.org.automation.pages.BaseClass;
import src.test.java.org.automation.pages.GoogleSearchPage;
import src.test.java.org.automation.utility.ExcelDataProvider;

public class GoogleSearchTest extends BaseClass {
    GoogleSearchPage google;
    @Test(priority = 1)
    public void search_on_google(){
        logger = reports.createTest("search_on_google");
        logger.info("Test Started");
        System.out.println(driver.getTitle());
        google = new GoogleSearchPage(driver);
        google.searchText(dataProvider.getStringData("Sheet1",0,0));
    }

    @Test(priority = 1)
    public void search_on_google_failed(){
        logger = reports.createTest("search_on_google_failed");
        logger.info("Test Started");
        google = new GoogleSearchPage(driver);
        google.searchTextBoxWrong(dataProvider.getStringData("Sheet1",0,0));
    }
}

package src.test.java.org.automation.pages;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import src.test.java.org.automation.utility.BrowserFactory;

public class BaseClass {
    public WebDriver driver;

    @BeforeClass
    public void setUpApplication(){
        driver = BrowserFactory.startApplication(driver, "CHROME", "https://www.google.com/");
    }

    @AfterClass
    public void tearDown(){
        BrowserFactory.quitApplication(driver);
    }
}

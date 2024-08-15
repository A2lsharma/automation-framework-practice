package src.test.java.org.automation.pages;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import src.test.java.org.automation.utility.BrowserFactory;
import src.test.java.org.automation.utility.ConfigDataProvider;
import src.test.java.org.automation.utility.ExcelDataProvider;
import src.test.java.org.automation.utility.Helper;

public class BaseClass {
    public WebDriver driver;
    public ExcelDataProvider dataProvider;
    public ConfigDataProvider config;

    @BeforeSuite
    public void setUpSuite(){
        dataProvider = new ExcelDataProvider();
        config = new ConfigDataProvider();
    }
    @BeforeClass
    public void setUpApplication(){
        driver = BrowserFactory.startApplication(driver, config.getBrowser(), config.getUrl());
    }

    @AfterMethod
    public void tearDownMethod(ITestResult result){
        if(result.getStatus() == ITestResult.FAILURE) {
            Helper.captureScreenshot(driver);
        }
    }

    @AfterClass
    public void tearDown(){
        BrowserFactory.quitApplication(driver);
    }
}

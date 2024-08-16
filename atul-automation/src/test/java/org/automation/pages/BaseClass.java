package src.test.java.org.automation.pages;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
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

import java.io.File;
import java.io.IOException;

public class BaseClass {
    public WebDriver driver;
    public ExcelDataProvider dataProvider;
    public ConfigDataProvider config;
    public ExtentReports reports;
    public ExtentTest logger;

    @BeforeSuite
    public void setUpSuite(){
        dataProvider = new ExcelDataProvider();
        config = new ConfigDataProvider();
        ExtentHtmlReporter extentHtmlReporter = new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/"+Helper.getCurrentDateTime()+".html"));
        reports = new ExtentReports();
        reports.attachReporter(extentHtmlReporter);
    }
    @BeforeClass
    public void setUpApplication(){
        driver = BrowserFactory.startApplication(driver, config.getBrowser(), config.getUrl());
    }

    @AfterMethod
    public void tearDownMethod(ITestResult result) throws IOException {
        String screenshot;
        if(result.getStatus() == ITestResult.FAILURE) {
            screenshot = Helper.captureScreenshot(driver);
            System.out.println(screenshot);
            logger.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(screenshot).build());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            screenshot = Helper.captureScreenshot(driver);
            System.out.println(screenshot);
            logger.pass("Test Passed", MediaEntityBuilder.createScreenCaptureFromPath(screenshot).build());
        }
        reports.flush();
    }

    @AfterClass
    public void tearDown(){
        BrowserFactory.quitApplication(driver);
    }
}

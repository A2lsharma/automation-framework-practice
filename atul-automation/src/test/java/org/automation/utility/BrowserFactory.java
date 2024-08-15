package src.test.java.org.automation.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.concurrent.TimeUnit;

public class BrowserFactory {
    static String browser;
    public static WebDriver startApplication(WebDriver driver, String browserName, String url) {
        browser = browserName;
        browser = browser.toLowerCase();
        if(browser.equals("chrome")){
            driver = new ChromeDriver();
        } else if (browser.equals("firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equals("edge")) {
            driver = new EdgeDriver();
        } else{
            System.out.println("Browser Not Supported");
        }
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return driver;
    }
    public static void quitApplication(WebDriver driver){
        driver.quit();
    }
}

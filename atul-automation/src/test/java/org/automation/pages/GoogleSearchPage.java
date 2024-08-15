package src.test.java.org.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import src.test.java.org.automation.utility.Wait;

public class GoogleSearchPage {
    WebDriver driver;
    Wait wait;
    public GoogleSearchPage(WebDriver driver){
        this.driver = driver;
    }
    @FindBy(name = "q") WebElement searchTextBox;

    public void searchText(String text){
        wait = new Wait();
        wait.wait(2000);
        searchTextBox.sendKeys(text);
        wait.wait(2000);
    }
}

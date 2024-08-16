package src.test.java.org.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import src.test.java.org.automation.utility.Wait;

public class GoogleSearchPage {
    Wait wait;
    public GoogleSearchPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(name = "q") WebElement searchTextBox;
    @FindBy(name = "e") WebElement searchTextBoxWrong;

    public void searchText(String text){
        wait = new Wait();
        wait.wait(2000);
        searchTextBox.sendKeys(text);
        wait.wait(2000);
    }

    public void searchTextBoxWrong(String text){
        wait = new Wait();
        wait.wait(2000);
        searchTextBox.clear();
        wait.wait(2000);
        searchTextBoxWrong.sendKeys(text);
        wait.wait(2000);
    }
}

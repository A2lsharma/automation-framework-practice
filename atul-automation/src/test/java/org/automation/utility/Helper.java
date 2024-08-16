package src.test.java.org.automation.utility;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Helper {

    // Handle Screenshots, Frames, Windows, Sync, issues, javascriptExecutor
    public static String captureScreenshot(WebDriver driver){
        File src  = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String screenShotPath = System.getProperty("user.dir")+"/Screenshots/"+getCurrentDateTime()+".png";
        try {
            FileHandler.copy(src, new File(screenShotPath));
            System.out.println("Screenshot Captured!!!");
        }catch (Exception e){
            System.out.println("Could not capture screenshot "+e.getMessage());
        }
        return screenShotPath;
    }
    public static String getCurrentDateTime(){
        SimpleDateFormat date = new SimpleDateFormat("MM_dd_yyyy_HH_mm:_s");
        Date currentDate = new Date();
        return date.format(currentDate);
    }
}

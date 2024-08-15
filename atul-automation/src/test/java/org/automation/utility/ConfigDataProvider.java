package src.test.java.org.automation.utility;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider {
    XSSFWorkbook wb;
    Properties pro;
    public ConfigDataProvider(){
        File fileSrc = new File("./Configuration/config.properties");
        try {
            FileInputStream fis = new FileInputStream(fileSrc);
            pro = new Properties();
            pro.load(fis);
        }catch (Exception e){
            System.out.println("Not able to load Config File"+e.getMessage());
        }
    }
    public String getDataFromConfig(String key){
        return pro.getProperty(key);
    }
    public String getBrowser(){
        return pro.getProperty("Browser");
    }
    public String getUrl(){
        return pro.getProperty("qaUrl");
    }
}

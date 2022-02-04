import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadProperties {
    public static void main(String args[]) throws IOException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        Properties prop=new Properties();
        FileInputStream fl=new FileInputStream("C:\\Users\\LUCKY\\IdeaProjects\\ExcelOperations\\src\\test\\java\\TestDataExcel.properties");
        prop.load(fl);

        System.out.println(prop.getProperty("url"));
        String vUrl=prop.getProperty("url");
        String vUsername=prop.getProperty("username");
        driver.get(vUrl);
        driver.findElement(By.name("email")).sendKeys(vUsername);

        FileOutputStream fo=new FileOutputStream("C:\\Users\\LUCKY\\IdeaProjects\\ExcelOperations\\src\\test\\java\\TestDataExcel.properties");
        prop.setProperty("Password","cwer");
        prop.store(fo,"Password is added by code in this file");
    }
}

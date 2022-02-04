import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class InvalidCredentials {
    public static void main(String args[]){
        Xls_Reader xr=new Xls_Reader(System.getProperty("user.dir")+"\\TestCaseData.xlsx");
        int rowcount=xr.getRowCount("Sheet1");
        for (int i=2;i<=rowcount;i++){
            String vTCName=xr.getCellData("Sheet1","TestCaseName",i);
            if (vTCName.equals("TC01_Invalid Cradential")){
                String url=xr.getCellData("Sheet1","URL",i);
                String uname=xr.getCellData("Sheet1","Username",i);
                String pwd=xr.getCellData("Sheet1","Password",i);
                WebDriverManager.chromedriver().setup();
                WebDriver driver=new ChromeDriver();
                driver.get(url);
                driver.findElement(By.name("email")).sendKeys(uname);
                driver.findElement(By.name("password")).sendKeys(pwd);
                driver.findElement(By.xpath("//input[@value='Login']")).click();
                Boolean Status=driver.findElement(By.xpath("/html/body/div[2]/div[1]")).isDisplayed();
                if (Status){
                    xr.setCellData("Sheet1","Status",2,"Login Functionality is not accepting invalid credentials ,Passed");
                }else {
                    xr.setCellData("Sheet1","Status",2,"Failed");
                }

            }else {
                System.out.println("Testcase doesn't found in the excel Sheet");
            }
        }

    }
}

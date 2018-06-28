package in.nseindia;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ProductBhavcopy {
    WebDriver driver;

    @BeforeMethod
    public void launchBrowser() {
        System.setProperty("webdriver.chrome.driver","F:\\software\\chrome driver setup\\chromedriver_win32 (2)\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.get("https://www.nseindia.com/products/content/equities/equities/archieve_eq.htm");
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }


    @Test
    public void dailyMonthlyReports() throws InterruptedException, IOException {
        Select bhave = new Select(driver.findElement(By.id("h_filetype")));
        bhave.selectByVisibleText("Bhavcopy ");
        Thread.sleep(10000);
        WebElement date = driver.findElement(By.id("date"));
        String datevalue = "15-06-2018";
        selectDateByJS(driver,date,datevalue);
        driver.findElement(By.xpath("//input[@type='image']")).click();
        //driver.findElement(By.className("getdata-button")).click();
        Thread.sleep(10000);
        driver.findElement(By.linkText("cm15JUN2018bhav.csv.zip")).click();
        Thread.sleep(20000);
        FileReader fr1 = new FileReader("C:\\Users\\akash mani\\Downloads\\cm15JUN2018bhav.csv.zip");
        FileReader fr2 = new FileReader("F:\\paisawale\\automation_project\\src\\test\\resources\\bhavCopy\\cm15JUN2018bhav.csv.zip");
        BufferedReader br1 = new BufferedReader(fr1);
        BufferedReader br2 = new BufferedReader(fr2);
        String line1 = br1.readLine();
        String line2 = br2.readLine();
        boolean areEqual = true;
        int linenum=1;
        while(line1 != null || line2 != null) {

            if(line1 == null || line2 == null) {
                areEqual = false;
                break;

            }

            else if (!line1.equalsIgnoreCase(line2)){
                areEqual = false;
                break;
            }

            line1 = br1.readLine();
            line2 = br2.readLine();
            linenum++;

        }

        if(areEqual == true) {
            System.out.println("Both file's contents matches");
        }

        else {
            System.out.println("Files content are diffrent at line number "+linenum);
        }

        br1.close();
        br2.close();




    }

    public static void selectDateByJS(WebDriver driver, WebElement element, String datevalue) {
        JavascriptExecutor js = ((JavascriptExecutor)driver);
        js.executeScript("arguments[0].setAttribute('value','"+datevalue+"');",element);
    }


    @AfterMethod
    public void terminateWindow() {

        driver.close();
    }


}

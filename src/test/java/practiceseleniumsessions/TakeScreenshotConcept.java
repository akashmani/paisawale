package practiceseleniumsessions;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TakeScreenshotConcept {
    static WebDriver driver;

    public static void main(String[] args) throws IOException{
        System.setProperty("webdriver.chrome.driver","F:\\software\\chrome driver setup\\chromedriver_win32 (2)\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.get("https://www.nseindia.com/products/content/equities/equities/archieve_eq.htm");
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); //Take screenshot and stored as a file format
        //now take the screenshot and copy to the desired location using copyFile methods
        FileUtils.copyFile(src, new File("F:\\paisawale\\automation_project\\src\\test\\java\\practiceseleniumsessions\\image2.jpeg"));

    }

}

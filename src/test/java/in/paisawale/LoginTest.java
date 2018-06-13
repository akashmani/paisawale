package in.paisawale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest {
    WebDriver driver;

    @BeforeTest
    public void launchBrowser() {
        System.setProperty("webdriver.chrome.driver","F:\\software\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");
        driver.manage().window().maximize();
    }



    @Test
    public void testInvalidPassword(){
        driver.findElement(By.id("email")).sendKeys("a@aw.com");
        driver.findElement(By.id("pass")).sendKeys("12345");
        driver.findElement(By.id("u_0_2")).click();
        WebElement LogIn = driver.findElement(By.className("Log in to Facebook"));
        String text = LogIn.getText();
        if(text.equals("Log in to Facebook"))
        {
            System.out.println("Invalid username or password");
        }
        else {
            System.out.println("Correct login");
        }
    }



  /*  @Test(priority = 2)
    public void testValidLogin() {
        driver.findElement(By.id("email")).sendKeys("a@aw.com");
        driver.findElement(By.id("pass")).sendKeys("123");
        driver.findElement(By.id("u_0_2")).click();
        WebElement SuccessfullLogin = driver.findElement(By.className("Akash"));
        String text = SuccessfullLogin.getText();
        if (text.equals("Akash")) {
            System.out.println("successfull login");
        }
        else {
            System.out.println("Wrong login");
        }
    }*/

    @AfterTest
    public void terminateWindow() {

        driver.close();
    }



}

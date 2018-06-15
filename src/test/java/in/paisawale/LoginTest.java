package in.paisawale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class LoginTest {
    WebDriver driver;

    @BeforeMethod
    public void launchBrowser() {
        System.setProperty("webdriver.chrome.driver","F:\\software\\chrome driver setup\\chromedriver_win32 (2)\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }



   @Test(priority =1)
    public void testInvalidPassword(){
        driver.findElement(By.id("email")).sendKeys("aw@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("12345");
        driver.findElement(By.id("u_0_2")).click();
        WebElement LogIn = driver.findElement(By.name("login"));
        String text = LogIn.getText();
        Assert.assertEquals(text,"Log In");
       // if(text.contains("The password that you've entered is incorrect."))

            System.out.println("Invalid username or password");
    }



    @Test(priority = 1)
    public void testValidLogin() {
        driver.findElement(By.id("email")).sendKeys("a@aw.com");
        driver.findElement(By.id("pass")).sendKeys("54321");
        driver.findElement(By.id("u_0_2")).click();
        WebElement SuccessfullLogin = driver.findElement(By.id("userNav"));
        String text = SuccessfullLogin.getText();
        Assert.assertEquals(text,"Akash Mani");
        System.out.println("successfull login");

    }

   @AfterMethod
    public void terminateWindow() {

       driver.close();
    }



}

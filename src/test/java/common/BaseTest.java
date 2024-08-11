package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {
   public static WebDriver driver;

   @BeforeMethod
   public void createDriver(){
       driver = new ChromeDriver();
       driver.manage().window().maximize();
       driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
   }

    @AfterMethod
   public static void closeDriver(){
       driver.quit();
   }


   public void sleep(double second){
       try {
           Thread.sleep((long) (1000 * second));
       } catch (InterruptedException e) {
           throw new RuntimeException(e);
       }
   }
}

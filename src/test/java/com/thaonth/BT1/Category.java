package com.thaonth.BT1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class Category {
   public static WebDriver driver;
    public static void createDriver() {
        driver = new ChromeDriver();
        driver.get("https://cms.anhtester.com/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
    }

    public static void closeDriver(){
        driver.quit();
    }
    public static void login(String email, String pass) throws InterruptedException {
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys(email);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(pass);
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
        Thread.sleep(1000);
    }

    public void createNewCategory() throws InterruptedException {

       //Click menu Product
        driver.findElement(By.xpath("//span[normalize-space()='Products']")).click();

        //Click menu Category
        driver.findElement(By.xpath("//span[normalize-space()='Category']")).click();

        //verify headerPage
        driver.findElement(By.xpath("//h1[normalize-space()='All categories']")).isDisplayed();

        //Click button Add New Category
        driver.findElement(By.xpath("//span[normalize-space()='Add New category']")).click();

        //Verify headerPage Add New Category
        driver.findElement(By.xpath( "//h5[normalize-space()='Category Information']")).isDisplayed();


        driver.findElement(By.xpath("//input[@id='name']")).sendKeys("[05082024] - Category");
        driver.findElement(By.xpath("//input[@id='order_level']")).sendKeys("1");
        Select select = new Select(driver.findElement(By.xpath("//select[@name='digital']")));
        select.selectByVisibleText("Physical");
        Thread.sleep(1000);

        driver.findElement(By.xpath("//label[contains(normalize-space(),'Banner')]//following-sibling::div/div[1]")).click();
        driver.findElement(By.xpath("//input[@placeholder='Search your files']")).sendKeys("WMNS_AIR_JORDAN_Gree_MID");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@title='WMNS_AIR_JORDAN_Gree_MID.png']")).click();

        driver.findElement(By.xpath("//button[normalize-space()='Add Files']")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath( "//label[contains(normalize-space(),'Icon')]//following-sibling::div/div[1]")).click();
        driver.findElement(By.xpath("//input[@placeholder='Search your files']")).sendKeys("niki");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@title='niki.png']")).click();
        driver.findElement(By.xpath("//button[normalize-space()='Add Files']")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//input[@name='meta_title']")).sendKeys("Meta Title");
        driver.findElement(By.xpath("//textarea[@name='meta_description']")).sendKeys("Meta Description");
        Thread.sleep(1000);

        driver.findElement(By.xpath("//button[@title='Nothing selected']")).click();
        driver.findElement(By.xpath("//div[@class='dropdown-menu show']//input[@aria-label='Search']")).sendKeys("Size");
        driver.findElement(By.xpath("//div[@class='dropdown-menu show']//input[@aria-label='Search']")).sendKeys(Keys.ENTER);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@title='Size']")).click();
        driver.findElement(By.xpath("//button[normalize-space()='Save']")).click();
        Thread.sleep(1000);

        //Search Category vua add
        driver.findElement(By.xpath("//input[@id='search']")).sendKeys("[05082024] - Category");
        driver.findElement(By.xpath("//input[@id='search']")).sendKeys(Keys.ENTER);
        Thread.sleep(1000);
        String nameCategory =  driver.findElement(By.xpath("//div[@class='card-body']//descendant::tbody/tr/td[2]")).getText();
        if(nameCategory.equals("[05082024] - Category")){
            System.out.println("Name Category is true");
        }
        else {
            System.out.println("Nage category is fail");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Category category = new Category();
        createDriver();

        login("admin@example.com", "123456");
        category.createNewCategory();
        closeDriver();
    }
}

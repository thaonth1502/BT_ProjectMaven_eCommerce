package com.thaonth.BT3;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class Category {

    WebDriver driver;

    public void sleep(double second){
        try {
            Thread.sleep((long) (1000 * second));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @BeforeSuite
    public void createDriver() {
        driver = new ChromeDriver();
        driver.get("https://cms.anhtester.com/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
    }

    @AfterSuite
    public void closeDriver(){
        driver.quit();
    }

    @BeforeMethod
    public void login() {

        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("admin@example.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123456");
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
        sleep(1);
    }

    @Test
    public void createNewCategory(){
        SoftAssert softAssert = new SoftAssert();
       //Click menu Product
        WebElement menuProducts = driver.findElement(By.xpath("//span[normalize-space()='Products']"));
        Assert.assertTrue(menuProducts.isDisplayed(), "Menu Products isn't display");
        menuProducts.click();
        sleep(1);

        //Click menu Category
        WebElement menuCategory = driver.findElement(By.xpath("//span[normalize-space()='Category']"));
        Assert.assertTrue(menuCategory.isDisplayed(), "Menu Category isn't display");
        menuCategory.click();
        sleep(1);

        //verify headerPage
        WebElement headerPage = driver.findElement(By.xpath("//h1[normalize-space()='All categories']"));
        softAssert.assertTrue(headerPage.isDisplayed(),"Header Page isn't right");
        softAssert.assertEquals(headerPage.getText(),"All categories", "Header page isn't right");

        //Click button Add New Category
        WebElement btn_AddNewCategory = driver.findElement(By.xpath("//span[normalize-space()='Add New category']"));
        Assert.assertTrue(btn_AddNewCategory.isDisplayed(), "Add new Category button isn't display");
        Assert.assertEquals(btn_AddNewCategory.getText(), "Add New category", " Add new category button's name isn't right");
        btn_AddNewCategory.click();

        //Verify headerPage Add New Category
        WebElement headerPageAddNewCategory = driver.findElement(By.xpath( "//h5[normalize-space()='Category Information']"));
        softAssert.assertTrue(headerPageAddNewCategory.isDisplayed(),"Header page add new category isn't display");
        softAssert.assertEquals(headerPageAddNewCategory.getText(), "Category Information", "Header Page Add new Category isn't right");

        driver.findElement(By.xpath("//input[@id='name']")).sendKeys("[05082024] - Category");
        driver.findElement(By.xpath("//input[@id='order_level']")).sendKeys("1");
        Select select = new Select(driver.findElement(By.xpath("//select[@name='digital']")));
        select.selectByVisibleText("Physical");
        sleep(1);

        driver.findElement(By.xpath("//label[contains(normalize-space(),'Banner')]//following-sibling::div/div[1]")).click();
        driver.findElement(By.xpath("//input[@placeholder='Search your files']")).sendKeys("WMNS_AIR_JORDAN_Gree_MID");
        sleep(1);
        driver.findElement(By.xpath("//div[@title='WMNS_AIR_JORDAN_Gree_MID.png']")).click();

        driver.findElement(By.xpath("//button[normalize-space()='Add Files']")).click();
        sleep(1);

        driver.findElement(By.xpath( "//label[contains(normalize-space(),'Icon')]//following-sibling::div/div[1]")).click();
        driver.findElement(By.xpath("//input[@placeholder='Search your files']")).sendKeys("niki");
        sleep(1);
        driver.findElement(By.xpath("//div[@title='niki.png']")).click();

        WebElement btn_AddFiles = driver.findElement(By.xpath("//button[normalize-space()='Add Files']"));
        Assert.assertTrue(btn_AddFiles.isDisplayed(),"Button isn't display");
        Assert.assertEquals(btn_AddFiles.getText(), "Add Files", "Button's name is not right");
        btn_AddFiles.click();
        sleep(1);

        driver.findElement(By.xpath("//input[@name='meta_title']")).sendKeys("Meta Title");
        driver.findElement(By.xpath("//textarea[@name='meta_description']")).sendKeys("Meta Description");
        sleep(1);

        driver.findElement(By.xpath("//button[@title='Nothing selected']")).click();
        driver.findElement(By.xpath("//div[@class='dropdown-menu show']//input[@aria-label='Search']")).sendKeys("Size");
        driver.findElement(By.xpath("//div[@class='dropdown-menu show']//input[@aria-label='Search']")).sendKeys(Keys.ENTER);
        sleep(1);
        driver.findElement(By.xpath("//button[@title='Size']")).click();

        WebElement btn_Save = driver.findElement(By.xpath("//button[normalize-space()='Save']"));
        Assert.assertTrue(btn_Save.isDisplayed(), "Save button is not display");
        Assert.assertEquals(btn_Save.getText(), "Save", "Button name is not right");
        btn_Save.click();
        sleep(1);

        //Verify message add successful
        WebElement messageSuccessful = driver.findElement(By.xpath("//span[@data-notify='message']"));
        String messageExpected = "Category has been inserted successfully";
        Assert.assertEquals(messageSuccessful.getText(), messageExpected, "Add new category successfully");

        //Search Category vua add
        driver.findElement(By.xpath("//input[@id='search']")).sendKeys("[05082024] - Category");
        driver.findElement(By.xpath("//input[@id='search']")).sendKeys(Keys.ENTER);
        sleep(1);
        String nameCategory =  driver.findElement(By.xpath("//div[@class='card-body']//descendant::tbody/tr/td[2]")).getText();

        Assert.assertEquals(nameCategory, "[05082024] - Category", "Category's name is not right" );
    }
}

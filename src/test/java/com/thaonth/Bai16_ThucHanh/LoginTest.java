package com.thaonth.Bai16_ThucHanh;

import com.thaont.constants.ConfigData;
import com.thaont.keywords.WebUI;
import common.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void testLoginSuccess(){
        driver.get(ConfigData.URL);
        WebUI.waitForPageLoaded(driver);

        WebUI.waitForElementVisible(driver, By.xpath("//input[@id='email']"), 5);
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys(ConfigData.EMAIL);
        WebUI.waitForElementVisible(driver, By.xpath("//input[@id='password']"), 5);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(ConfigData.PASSWORD);

        WebUI.waitForElementClickable(driver, By.xpath("//button[normalize-space()='Login']"), 5);
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
        WebUI.waitForPageLoaded(driver);
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='icon header-user-profile']")).isDisplayed());

    }

    @Test
    public void testLoginFailWithEmailInvalid(){
        driver.get(ConfigData.URL);
        WebUI.waitForPageLoaded(driver);

        WebUI.waitForElementVisible(driver, By.xpath("//input[@id='email']"), 5);
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("user1@gmai.com");
        WebUI.waitForElementVisible(driver, By.xpath("//input[@id='password']"), 5);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(ConfigData.PASSWORD);

        WebUI.waitForElementClickable(driver, By.xpath("//button[normalize-space()='Login']"), 5);

        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='text-center alert alert-danger']")).isDisplayed());
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='text-center alert alert-danger']")).getText(),"Invalid email or password", "The content of message is not map");

    }

    @Test
    public void testLoginFailWithPasswordInvalid(){
        driver.get(ConfigData.URL);
        WebUI.waitForPageLoaded(driver);

        WebUI.waitForElementVisible(driver, By.xpath("//input[@id='email']"), 5);
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys(ConfigData.EMAIL);
        WebUI.waitForElementVisible(driver, By.xpath("//input[@id='password']"), 5);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("1234566");

        WebUI.waitForElementClickable(driver, By.xpath("//button[normalize-space()='Login']"), 5);

        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='text-center alert alert-danger']")).isDisplayed());
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='text-center alert alert-danger']")).getText(),"Invalid email or password", "The content of message is not map");

    }
}

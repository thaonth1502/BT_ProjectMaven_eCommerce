package com.thaonth.BT4;

import com.thaont.constants.ConfigData;
import com.thaont.keywords.WebUI;
import common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Product extends BaseTest {

    public void login(String userName, String password){
        driver.get(ConfigData.URL);
        WebUI.waitForPageLoaded(driver);
        WebUI.waitForElementVisible(driver, By.xpath("//input[@id='email']"),5);
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys(userName);
        WebUI.waitForElementVisible(driver, By.xpath("//input[@id='password']"),5);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
        WebUI.waitForElementClickable(driver, By.xpath("//button[normalize-space()='Login']"), 5);
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
        WebUI.waitForPageLoaded(driver);
    }
public void clickMenuProduct(){
    //Click menu Product
    WebUI.waitForElementClickable(driver, By.xpath("//span[normalize-space()='Products']"), 5);
    WebElement menuProducts = driver.findElement(By.xpath("//span[normalize-space()='Products']"));
    menuProducts.click();
    WebUI.waitForPageLoaded(driver);
}
    public void clickMenuAddNewCategory(){
        WebUI.waitForElementClickable(driver, By.xpath("span[normalize-space()='Add New Product']"), 5);
        WebElement menuCategory = driver.findElement(By.xpath("span[normalize-space()='Add New Product']"));
        menuCategory.click();
        WebUI.waitForPageLoaded(driver);
    }

}

package com.thaonth.Locators;

import common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Category extends BaseTest{

    Login login = new Login();
    Menu menu = new Menu();


    public static String headerPage = "//h1[normalize-space()='All categories']";
    public static String headerPageAddNewCategory = "//h5[normalize-space()='Category Information']";
    public static String btn_AddNewCategory = "//span[normalize-space()='Add New category']";
    public static String inputSearch = "//input[@id='search']";
    public static String inputName = "//input[@id='name']";
    public static String dropdownParentCategory = "//button[@title='No Parent']";
    public static String inputParentCategory = "//button[@title='No Parent']//following-sibling::div//input";
    public static String inputOrderingNumber = "//input[@id='order_level']";
    public static String dropdownType = "//select[@name='digital']";
    public static String inputBanner = "//label[contains(normalize-space(),'Banner')]//following-sibling::div/div[1]";
    public static String inputSearchFile = "//input[@placeholder='Search your files']";
    public static String btn_AddFile = "//button[normalize-space()='Add Files']";

    public static String inputIcon = "//label[contains(normalize-space(),'Icon')]//following-sibling::div/div[1]";
    public static String inputMetaTitle = "//input[@name='meta_title']";
    public static String inputMeteDescription = "//textarea[@name='meta_description']";
    public static String dropdownFilteringAttributes = "//button[@title='Nothing selected']";
    public static String inputSearchFilteringAttributes = "//div[@class='dropdown-menu show']//input[@aria-label='Search']";
    public static String btn_Save = "//button[normalize-space()='Save']";


    @Test
    public void createNewCategory(){
        login.login("admin@example.com", "123456");
        menu.clickMenuCategory();
        driver.findElement(By.xpath(btn_AddNewCategory)).click();
        driver.findElement(By.xpath(inputName)).sendKeys("[04082024] - Category");
        driver.findElement(By.xpath(inputOrderingNumber)).sendKeys("1");
        Select select = new Select(driver.findElement(By.xpath(dropdownType)));
        select.selectByVisibleText("Physical");
        driver.findElement(By.xpath(inputBanner)).click();
        driver.findElement(By.xpath(inputSearchFile)).sendKeys("WMNS_AIR_JORDAN_Gree_MID");
        driver.findElement(By.xpath("//div[@title='WMNS_AIR_JORDAN_Gree_MID.png']")).click();
        driver.findElement(By.xpath(btn_AddFile)).click();

        driver.findElement(By.xpath(inputIcon)).click();
        driver.findElement(By.xpath(inputSearchFile)).sendKeys("niki");
        driver.findElement(By.xpath("//div[@title='niki.png']")).click();
        driver.findElement(By.xpath(btn_AddFile)).click();

        driver.findElement(By.xpath(inputMetaTitle)).sendKeys("Meta Title");
        driver.findElement(By.xpath(inputMeteDescription)).sendKeys("Meta Description");

        driver.findElement(By.xpath(dropdownFilteringAttributes)).click();
        driver.findElement(By.xpath(inputSearchFilteringAttributes)).sendKeys("Size");
        driver.findElement(By.xpath(inputSearchFilteringAttributes)).sendKeys(Keys.ENTER);
        driver.findElement(By.xpath(dropdownFilteringAttributes)).click();
        driver.findElement(By.xpath(btn_Save)).click();

        //Search Category vua add
        driver.findElement(By.xpath(inputSearch)).sendKeys("[04082024] - Category");
        driver.findElement(By.xpath(inputSearch)).sendKeys(Keys.ENTER);
        String nameCategory =  driver.findElement(By.xpath("//div[@class='card-body']//descendant::tbody/tr/td[2]")).getText();
        Assert.assertEquals(nameCategory, "[04082024] - Category", "Name Category is not right");
    }


}

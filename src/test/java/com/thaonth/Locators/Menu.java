package com.thaonth.Locators;

import common.BaseTest;
import org.openqa.selenium.By;

public class Menu extends BaseTest {
    public static String menuProducts = "//span[normalize-space()='Products']";
    public static String menuAddNewProduct  = "//span[normalize-space()='Add New Product']";
    public static String menuAllProducts = "//span[normalize-space()='All products']";
    public static String menuCategory = "//span[normalize-space()='Category']";

    public void clickMenuCategory (){
        driver.findElement(By.xpath(menuCategory)).click();
    }
}

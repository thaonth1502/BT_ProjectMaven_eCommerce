package com.thaonth.BT5.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class DashboardPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public DashboardPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }
   private By iconAvatar = By.xpath("//span[@class='avatar avatar-sm mr-md-2']");
   private By totalCustomer = By.xpath("(//span[normalize-space()='Total'])[1]/parent::div/following-sibling::div");
   private By totalOrder = By.xpath("(//span[normalize-space()='Total'])[2]/parent::div/following-sibling::div");
   private By totalProductCategory = By.xpath("(//span[normalize-space()='Total'])[3]/parent::div/following-sibling::div");
   private By totalProductBrand = By.xpath("(//span[normalize-space()='Total'])[4]/parent::div/following-sibling::div");
   private By sectionProducts = By.xpath("//h6[normalize-space()='Products']/ancestor::div[@class='card']");
   private By sectionSellers = By.xpath("//h6[normalize-space()='Sellers']/ancestor::div[@class='card']");
   private By sectionCategoryWiseProductSale = By.xpath("//h6[normalize-space()='Category wise product sale']/ancestor::div[@class='card']");
   private By sectionCategoryWiseProductStock = By.xpath("//h6[normalize-space()='Category wise product stock']/ancestor::div[@class='card']");
   private By menuProducts = By.xpath("//span[normalize-space()='Products']");
   private By menuCategory = By.xpath("//span[normalize-space()='Category']");
   private By menuAddNewProduct = By.xpath("//span[normalize-space()='Add New Product']");


    public void clickMenuCategory(){
        driver.findElement(menuProducts).click();
        wait.until(ExpectedConditions.elementToBeClickable(menuCategory));
        driver.findElement(menuCategory).click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://cms.anhtester.com/admin/categories", "FAIL !!! The current URL not match");
    }

    public void clickMenuAddNewProduct(){
        driver.findElement(menuProducts).click();
        wait.until(ExpectedConditions.elementToBeClickable(menuAddNewProduct));
        driver.findElement(menuAddNewProduct).click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://cms.anhtester.com/admin/products/create", "FAIL !!! The current URL not match");
    }

    public void verifyDashboard(){
        Assert.assertTrue(driver.findElement(iconAvatar).isDisplayed(), "FAIL! Login Fail. Icon avatar not display");
        Assert.assertTrue(driver.findElement(sectionProducts).isDisplayed(),"FAIL! Section Products not display");
        Assert.assertTrue(driver.findElement(sectionSellers).isDisplayed(),"FAIL! Section Sellers not display");
        Assert.assertTrue(driver.findElement(sectionCategoryWiseProductSale).isDisplayed(),"FAIL! Section Category Wise Product Sale not display");
        Assert.assertTrue(driver.findElement(sectionCategoryWiseProductStock).isDisplayed(),"FAIL! Section Category Wise Product Stock not display");
    }

    public void verifyTotalCustomer(String expectedTotal){
        wait.until(ExpectedConditions.visibilityOfElementLocated(totalCustomer));
        Assert.assertTrue(driver.findElement(totalCustomer).isDisplayed(), "FAIL!! The Total Customer not display");
        Assert.assertEquals(driver.findElement(totalCustomer).getText(), expectedTotal, "FAIL !!! The total Customer not match");
    }

    public void verifyTotalOrder(String expectedTotal){
        wait.until(ExpectedConditions.visibilityOfElementLocated(totalOrder));
        Assert.assertTrue(driver.findElement(totalOrder).isDisplayed(), "FAIL!! The Total Order not display");
        Assert.assertEquals(driver.findElement(totalOrder).getText(), expectedTotal, "FAIL !!! The total Order not match");
    }

    public void verifyTotalProductCategory(String expectedTotal){
        wait.until(ExpectedConditions.visibilityOfElementLocated(totalProductCategory));
        Assert.assertTrue(driver.findElement(totalProductCategory).isDisplayed(), "FAIL!! The Total Product Category not display");
        Assert.assertEquals(driver.findElement(totalProductCategory).getText(), expectedTotal, "FAIL !!! The total Total Product Category not match");
    }

    public void verifyTotalProductBrand(String expectedTotal){
        wait.until(ExpectedConditions.visibilityOfElementLocated(totalProductBrand));
        Assert.assertTrue(driver.findElement(totalProductBrand).isDisplayed(), "FAIL!! The Total Product Brand not display");
        Assert.assertEquals(driver.findElement(totalProductBrand).getText(), expectedTotal, "FAIL !!! The total Product Brand not match");
    }
}

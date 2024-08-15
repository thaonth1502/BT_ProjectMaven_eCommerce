package com.thaonth.BT5.pages;

import com.thaont.keywords.WebUI;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class CategoryPage {

    private WebDriver driver;
    private WebDriverWait wait;


    public CategoryPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    private By titleCategoryPage = By.xpath("//h1[normalize-space()='All categories']");
    private By btnAddNewCategory = By.xpath("//span[normalize-space()='Add New category']");
    private By inputSearchCategory = By.xpath("//input[@id='search']");
    private By iconDelete = By.xpath("(//a[@title='Delete'])[1]");
    private By iconEdit = By.xpath("(//a[@title='Edit'])[1]");
    private By btnDelete = By.xpath("//div[@class='modal-content']//a[@id='delete-link']");
    private By btnCancel = By.xpath("//div[@class='modal-content']//button[normalize-space()='Cancel']");
    private By contentDeleteConfirm = By.xpath("//div[@class='modal-content']//p");
    private By deleteConfirmDialog = By.xpath("//div[@class='modal-content']");
    private By successMessage = By.xpath("//span[@data-notify='message']");
    private By tableCategory = By.xpath("(//div[@class='card-body']/descendant::tbody)/tr");

    public void clickButtonAddNewCategory(){
        wait.until(ExpectedConditions.elementToBeClickable(btnAddNewCategory));
        driver.findElement(btnAddNewCategory).click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://cms.anhtester.com/admin/categories/create");
    }

    public void searchCategory(String categoryName){
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputSearchCategory));
        driver.findElement(inputSearchCategory).sendKeys(categoryName);
        driver.findElement(inputSearchCategory).sendKeys(Keys.ENTER);
    }

    public void deleteCategorySuccess(){
        wait.until(ExpectedConditions.elementToBeClickable(iconDelete));
        driver.findElement(iconDelete).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(deleteConfirmDialog));
        Assert.assertTrue(driver.findElement(deleteConfirmDialog).isDisplayed(), "FAIL!!! Delete Confirmation not display");
        Assert.assertEquals(driver.findElement(contentDeleteConfirm).getText(), "Are you sure to delete this?", "FAIL!! The content delete confirmation not correct");

        wait.until(ExpectedConditions.elementToBeClickable(btnDelete));
        driver.findElement(btnDelete).click();
    }

    public void deleteCategoryUnSuccess(){
        WebUI.sleep(1);
        int numberBefor = getTotalCategory();
        wait.until(ExpectedConditions.elementToBeClickable(iconDelete));
        driver.findElement(iconDelete).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(deleteConfirmDialog));
        Assert.assertTrue(driver.findElement(deleteConfirmDialog).isDisplayed(), "FAIL!!! Delete Confirmation not display");
        Assert.assertEquals(driver.findElement(contentDeleteConfirm).getText(), "Are you sure to delete this?", "FAIL!! The content delete confirmation not correct");
        wait.until(ExpectedConditions.elementToBeClickable(btnCancel));
        driver.findElement(btnCancel).click();
        WebUI.sleep(1);
        wait.until(ExpectedConditions.visibilityOfElementLocated(tableCategory));
        int numberAfter =  getTotalCategory();
        Assert.assertEquals(numberAfter, numberBefor, "FAIL!!! Number Category after delete unsuccessful not match before delete");
    }


    public void verifyDeleteCategorySuccess(String message){
        //"Category has been deleted successfully"
        wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage));
        Assert.assertTrue(driver.findElement(successMessage).isDisplayed(), "FAIL!!! Message delete success not display");
        Assert.assertEquals(driver.findElement(successMessage).getText(), message, "FAIL !!! The content message delete success not match");
    }

    public int getTotalCategory(){
        List<WebElement> elements = driver.findElements(tableCategory);
        return elements.size();
    }
}

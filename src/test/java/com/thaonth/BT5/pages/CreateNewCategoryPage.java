package com.thaonth.BT5.pages;

import com.thaont.keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import javax.swing.*;
import java.time.Duration;

public class CreateNewCategoryPage {

    WebDriver driver;
    WebDriverWait wait;
    Actions action;

    public CreateNewCategoryPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        this.action = new Actions(driver);
    }

   private By headerCreateNewCategory = By.xpath("//h5[normalize-space()='Category Information']");
   private By inputName = By.xpath("//input[@id='name']");
   private By btnSave = By.xpath("//button[normalize-space()='Save']");
   private By dropdownParentCategory = By.xpath("//label[normalize-space()='Parent Category']/following-sibling::div//button");
   private By inputOrderingNumber = By.xpath("//input[@id='order_level']");
   private By dropdownType = By.xpath("//select[@name='digital']");
   private By attachBanner = By.xpath("(//div[@class = 'input-group' and @data-type = 'image'])[1]");
   private By inputSearchFile = By.xpath("//input[@placeholder='Search your files']");
   private By btnAddFiles = By.xpath("//button[normalize-space()='Add Files']");
   private By attachIcon = By.xpath("(//div[@class = 'input-group' and @data-type = 'image'])[2]");
   private By inputMetaTitle = By.xpath("//input[@name='meta_title']");
   private By textAreaMetaDescription = By.xpath("//textarea[@name='meta_description']");
   private By dropdownFilteringAttributes = By.xpath("//label[normalize-space()='Filtering Attributes']/following-sibling::div//button");
   private By inputSearchDropdown = By.xpath("//div[@class='dropdown-menu show']//input[@aria-label='Search']");
   private By successMessage = By.xpath("//span[@data-notify='message']");





   public void inputDataToFieldsInAddNewCategory(String name, String parentCat, String orderingNo, String type, String metaTitle, String metaDescription, String attribute){
       wait.until(ExpectedConditions.visibilityOfElementLocated(inputName));
       driver.findElement(inputName).sendKeys(name);

       wait.until(ExpectedConditions.elementToBeClickable(dropdownParentCategory));
       driver.findElement(dropdownParentCategory).click();
       wait.until(ExpectedConditions.visibilityOfElementLocated(inputSearchDropdown));
       driver.findElement(inputSearchDropdown).sendKeys(parentCat);
       driver.findElement(inputSearchDropdown).sendKeys(Keys.ENTER);

       wait.until(ExpectedConditions.visibilityOfElementLocated(inputOrderingNumber));
       driver.findElement(inputOrderingNumber).sendKeys(orderingNo);

       Select select = new Select(driver.findElement(dropdownType));
       select.selectByVisibleText(type);

       wait.until(ExpectedConditions.visibilityOfElementLocated(inputMetaTitle));
       driver.findElement(inputMetaTitle).sendKeys(metaTitle);

       wait.until(ExpectedConditions.visibilityOfElementLocated(textAreaMetaDescription));
       driver.findElement(textAreaMetaDescription).sendKeys(metaDescription);

       wait.until(ExpectedConditions.elementToBeClickable(dropdownFilteringAttributes));
       driver.findElement(dropdownFilteringAttributes).click();
       wait.until(ExpectedConditions.visibilityOfElementLocated(inputSearchDropdown));
       driver.findElement(inputSearchDropdown).sendKeys(attribute);
       driver.findElement(inputSearchDropdown).sendKeys(Keys.ENTER);
   }

   public void attImageBanner(String bannerName){
       wait.until(ExpectedConditions.elementToBeClickable(attachBanner));
       driver.findElement(attachBanner).click();
       WebUI.sleep(1);
       wait.until(ExpectedConditions.visibilityOfElementLocated(inputSearchFile));
       driver.findElement(inputSearchFile).sendKeys(bannerName);
       WebUI.sleep(1);
       String image = "//div[contains(@title,'"+bannerName+"')]";
       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(image)));
       driver.findElement(By.xpath(image)).click();

       wait.until(ExpectedConditions.elementToBeClickable(btnAddFiles));
       driver.findElement(btnAddFiles).click();
   }

   public void attImageIcon(String iconName){
       wait.until(ExpectedConditions.elementToBeClickable(attachIcon));
       driver.findElement(attachIcon).click();
       WebUI.sleep(1);
       wait.until(ExpectedConditions.visibilityOfElementLocated(inputSearchFile));
       driver.findElement(inputSearchFile).sendKeys(iconName);
       WebUI.sleep(1);
       String image = "//div[contains(@title,'"+iconName+"')]";
       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(image)));

       driver.findElement(By.xpath(image)).click();

       wait.until(ExpectedConditions.elementToBeClickable(btnAddFiles));
       driver.findElement(btnAddFiles).click();
   }

   public void clickButtonSave(){
       action.moveToElement(driver.findElement(btnSave)).perform();
       wait.until(ExpectedConditions.elementToBeClickable(btnSave));
       driver.findElement(btnSave).click();
       WebUI.sleep(1);
   }

   public void verifyCreateCategorySuccess(String expectedMessage){
       wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage));
       Assert.assertTrue(driver.findElement(successMessage).isDisplayed(), "FAIL!!! The message success not display");
       Assert.assertEquals(driver.findElement(successMessage).getText(), expectedMessage, "FAIL !! The content message is match");
   }



}

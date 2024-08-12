package com.thaonth.BT3;

import com.thaont.constants.ConfigData;
import com.thaont.keywords.WebUI;
import common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;


public class Category extends BaseTest {
    SoftAssert softAssert = new SoftAssert();

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
    public void clickMenuCategory(){
        WebUI.waitForElementClickable(driver, By.xpath("//span[normalize-space()='Category']"), 5);
        WebElement menuCategory = driver.findElement(By.xpath("//span[normalize-space()='Category']"));
        menuCategory.click();
        WebUI.waitForPageLoaded(driver);
    }

    public void verifyHeardPageCategory(){
        //verify headerPage
        WebUI.waitForElementVisible(driver,By.xpath("//h1[normalize-space()='All categories']"), 5 );
        WebElement headerPage = driver.findElement(By.xpath("//h1[normalize-space()='All categories']"));
        softAssert.assertEquals(headerPage.getText(),"All categories", "Header page isn't right");
    }

    public void clickAddNewCategoryButton(){
        //Click button Add New Category
        WebUI.waitForElementClickable(driver, By.xpath("//span[normalize-space()='Add New category']"), 5);
        WebElement btn_AddNewCategory = driver.findElement(By.xpath("//span[normalize-space()='Add New category']"));
        Assert.assertEquals(btn_AddNewCategory.getText(), "Add New category", " Add new category button's name isn't right");
        btn_AddNewCategory.click();
        WebUI.waitForPageLoaded(driver);
    }

    public void verifyHeaderPageAddNewCategory(){
        //Verify headerPage Add New Category
        WebUI.waitForElementVisible(driver,By.xpath("//h5[normalize-space()='Category Information']"), 5 );
        WebElement headerPageAddNewCategory = driver.findElement(By.xpath( "//h5[normalize-space()='Category Information']"));
        softAssert.assertEquals(headerPageAddNewCategory.getText(), "Category Information", "Header Page Add new Category isn't right");
    }

    public void addBanner(){
        WebUI.waitForElementClickable(driver, By.xpath("//label[contains(normalize-space(),'Banner')]//following-sibling::div/div[1]"), 6);
        WebElement att_Banner = driver.findElement(By.xpath("//label[contains(normalize-space(),'Banner')]//following-sibling::div/div[1]"));

        //Add Banner
        att_Banner.click();
        WebUI.waitForPageLoaded(driver);
        WebUI.waitForElementVisible(driver, By.xpath("//input[@placeholder='Search your files']"), 5 );
        driver.findElement(By.xpath("//input[@placeholder='Search your files']")).sendKeys("WMNS_AIR_JORDAN_Gree_MID");

        WebUI.waitForElementVisible(driver, By.xpath("//div[@title='WMNS_AIR_JORDAN_Gree_MID.png']"), 5);
        driver.findElement(By.xpath("//div[@title='WMNS_AIR_JORDAN_Gree_MID.png']")).click();

        WebUI.waitForElementClickable(driver, By.xpath("//button[normalize-space()='Add Files']"), 5);
        WebElement btn_AddFilesBanner = driver.findElement(By.xpath("//button[normalize-space()='Add Files']"));
        Assert.assertEquals(btn_AddFilesBanner.getText(), "Add Files", "Button's name is not right");
        btn_AddFilesBanner.click();
        WebUI.waitForPageLoaded(driver);
        WebUI.sleep(2);

    }

    public void addIcon(){
        WebUI.waitForElementClickable(driver, By.xpath( "//label[contains(normalize-space(),'Icon')]//following-sibling::div/div[1]"), 6);
        WebElement att_icon = driver.findElement(By.xpath( "//label[contains(normalize-space(),'Icon')]//following-sibling::div/div[1]"));
        att_icon.click();
        WebUI.waitForPageLoaded(driver);

        WebUI.waitForElementVisible(driver, By.xpath("//input[@placeholder='Search your files']"), 5);
        driver.findElement(By.xpath("//input[@placeholder='Search your files']")).sendKeys("niki");

        WebUI.waitForElementVisible(driver, By.xpath("//div[@title='niki.png']"), 5);
        driver.findElement(By.xpath("//div[@title='niki.png']")).click();

        WebUI.waitForElementClickable(driver, By.xpath("//button[normalize-space()='Add Files']"), 5);
        WebElement btn_AddFilesIcon = driver.findElement(By.xpath("//button[normalize-space()='Add Files']"));
        Assert.assertEquals(btn_AddFilesIcon.getText(), "Add Files", "Button's name is not right");
        btn_AddFilesIcon.click();
        WebUI.sleep(2);
        //WebUI.waitForPageLoaded(driver);

    }
    public void inputDataAddNewCategory(String categoryName){
        WebUI.waitForElementVisible(driver, By.xpath("//input[@id='name']"), 5);
        WebElement input_name =  driver.findElement(By.xpath("//input[@id='name']"));

        WebUI.waitForElementVisible(driver, By.xpath("//input[@id='order_level']"), 5);
        WebElement dropdown_ParentCategory = driver.findElement(By.xpath("//input[@id='order_level']"));

        WebElement dropdown_Type = driver.findElement(By.xpath("//select[@name='digital']"));

        WebUI.waitForElementVisible(driver, By.xpath("//input[@id='order_level']"), 5);
        WebElement input_OrderingNumber = driver.findElement(By.xpath("//input[@id='order_level']"));

        WebUI.waitForElementVisible(driver, By.xpath("//input[@name='meta_title']"), 5);
        WebElement input_MetaTitle = driver.findElement(By.xpath("//input[@name='meta_title']"));

        WebUI.waitForElementVisible(driver, By.xpath("//textarea[@name='meta_description']"), 5);
        WebElement input_MetaDescription = driver.findElement(By.xpath("//textarea[@name='meta_description']"));

        WebElement dropdown_FilteringAttributes = driver.findElement(By.xpath("//label[normalize-space()='Filtering Attributes']//parent::div//child::button"));

        if (!input_name.getAttribute("value").isBlank()) {
            input_name.clear();
        }
        input_name.sendKeys(categoryName);
        WebUI.sleep(1);

        if(dropdown_ParentCategory.getAttribute("value").isBlank()){
            dropdown_ParentCategory.sendKeys("1");
            WebUI.sleep(1);
        }else {
            dropdown_ParentCategory.clear();
            dropdown_ParentCategory.sendKeys("2");
            WebUI.sleep(1);
        }

        if(input_OrderingNumber.getAttribute("value").isEmpty()){
            input_OrderingNumber.sendKeys("1");
            WebUI.sleep(1);
        }
        else {
            input_OrderingNumber.clear();
            input_OrderingNumber.sendKeys("2");
            WebUI.sleep(1);
        }

        //Select Type
            Select select = new Select(dropdown_Type);
            select.selectByVisibleText("Physical");
        WebUI.sleep(1);

        if (!input_MetaTitle.getAttribute("value").isBlank()) {
            input_MetaTitle.clear();
        }
        input_MetaTitle.sendKeys("Meta Title");
        WebUI.sleep(1);


        if (!input_MetaDescription.getAttribute("value").isBlank()) {
            input_MetaDescription.clear();
        }
        input_MetaDescription.sendKeys("Meta Description");
        WebUI.sleep(1);

        if(dropdown_FilteringAttributes.getAttribute("title").contains("Nothing selected")) {
            dropdown_FilteringAttributes.click();
            WebUI.waitForPageLoaded(driver);
            WebUI.waitForElementVisible(driver, By.xpath("//div[@class='dropdown-menu show']//input[@aria-label='Search']"), 5);
            driver.findElement(By.xpath("//div[@class='dropdown-menu show']//input[@aria-label='Search']")).sendKeys("Size");
            driver.findElement(By.xpath("//div[@class='dropdown-menu show']//input[@aria-label='Search']")).sendKeys(Keys.ENTER);
            WebUI.waitForElementClickable(driver, By.xpath("//button[@title='Size']"), 5 );
            driver.findElement(By.xpath("//button[@title='Size']")).click();
        }
    }

    public void clickSaveButton(){
        Assert.assertEquals(driver.findElement(By.xpath("//button[normalize-space()='Save']")).getText(), "Save", "Button name is not right");
         WebUI.waitForElementClickable(driver, By.xpath("//button[normalize-space()='Save']"), 5);
        driver.findElement(By.xpath("//button[normalize-space()='Save']")).click();
        WebUI.waitForPageLoaded(driver);
    }

    public void verifyMessageActionSuccessful(String expectedMessage){
        //Verify message add successful
        WebUI.waitForElementVisible(driver, By.xpath("//span[@data-notify='message']"), 5);
        WebElement messageSuccessful = driver.findElement(By.xpath("//span[@data-notify='message']"));
        Assert.assertEquals(messageSuccessful.getText(), expectedMessage, "Message isn't correct");
    }
    public void searchCategory(String categoryName){
//        Search Category vua add
        WebUI.waitForElementVisible(driver, By.xpath("//input[@id='search']"), 5);
        driver.findElement(By.xpath("//input[@id='search']")).sendKeys(categoryName);
        driver.findElement(By.xpath("//input[@id='search']")).sendKeys(Keys.ENTER);
        WebUI.waitForElementVisible(driver, By.xpath("//div[@class='card-body']//descendant::tbody/tr/td[2]"), 5);
        String nameCategory =  driver.findElement(By.xpath("//div[@class='card-body']//descendant::tbody/tr/td[2]")).getText();
        Assert.assertEquals(nameCategory, categoryName, "Category's name is not right" );
        WebUI.sleep(2);
    }

    public void clickIconEdit(){
        WebUI.waitForElementClickable(driver, By.xpath("(//div[@class='card-body']//descendant::tbody/tr/td[10])/a[@title= 'Edit']"), 5);
        WebElement icon_Edit = driver.findElement(By.xpath("(//div[@class='card-body']//descendant::tbody/tr/td[10])/a[@title= 'Edit']"));
        icon_Edit.click();
        WebUI.waitForPageLoaded(driver);
    }

    public void clickIconDelete(){
        WebUI.waitForElementClickable(driver, By.xpath("(//div[@class='card-body']//descendant::tbody/tr/td[10])/a[@title= 'Delete']"), 5);
        WebElement icon_Delete = driver.findElement(By.xpath("(//div[@class='card-body']//descendant::tbody/tr/td[10])/a[@title= 'Delete']"));
        icon_Delete.click();
        WebUI.waitForPageLoaded(driver);
    }

    public void clickDeleteButtonOnDeleteConfirmation(){
        WebUI.waitForPageLoaded(driver);
        WebUI.waitForElementVisible(driver, By.xpath("//div[@id='delete-modal']"), 5);
        WebElement modalDelete =  driver.findElement(By.xpath("//div[@id='delete-modal']"));
        WebElement modal_header = modalDelete.findElement(By.xpath(".//div[@class='modal-header']//h4[normalize-space()='Delete Confirmation']"));
        WebElement modal_content = modalDelete.findElement(By.xpath(".//div[contains(@class,'modal-body')]//p[@class='mt-1']"));
        WebElement bnt_Delete = modalDelete.findElement(By.xpath(".//div[contains(@class,'modal-body')]//a[@id='delete-link']"));
        Assert.assertEquals(modal_header.getText(),"Delete Confirmation", "Header Modal is not right");
        Assert.assertEquals(modal_content.getText(),"Are you sure to delete this?", "Message confirm is not right" );

        WebUI.waitForElementClickable(driver, By.xpath(".//div[contains(@class,'modal-body')]//a[@id='delete-link']"), 5);
        bnt_Delete.click();
        verifyMessageActionSuccessful("Category has been deleted successfully");
    }

    public void verifyItemDeleted(String text){
        WebUI.waitForElementVisible(driver, By.xpath("//input[@id='search']"), 5);
        driver.findElement(By.xpath("//input[@id='search']")).sendKeys(text);
        driver.findElement(By.xpath("//input[@id='search']")).sendKeys(Keys.ENTER);
        WebUI.waitForPageLoaded(driver);
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='card-body']//descendant::tbody//tr[@class='footable-empty']")).isDisplayed(), "Delete category unsuccessful");
    }

    @Test (priority = 1)
    public void createNewCategory(){
        login(ConfigData.EMAIL, ConfigData.PASSWORD);
        //click Menu Product
        clickMenuProduct();
        //Click menu category
        clickMenuCategory();
        //verify header page category
        verifyHeardPageCategory();
        //click add new category button
        clickAddNewCategoryButton();
        //Verify headerPage Add New Category
        verifyHeaderPageAddNewCategory();
        //input data into all required fields in add new category form
        inputDataAddNewCategory("[12082024] - Category");
        addBanner();
        addIcon();
        clickSaveButton();
        verifyMessageActionSuccessful("Category has been inserted successfully");
        searchCategory("[12082024] - Category");
    }
    @Test (description = "Edit a category", priority = 2)
    public void editCategory(){
        login(ConfigData.EMAIL, ConfigData.PASSWORD);
        clickMenuProduct();
        clickMenuCategory();
        verifyHeardPageCategory();
        searchCategory("[12082024] - Category");
        clickIconEdit();
        inputDataAddNewCategory("[12082024] - Category Update");
        clickSaveButton();
        verifyMessageActionSuccessful("Category has been updated successfully");
        clickMenuCategory();
        searchCategory("[12082024] - Category Update");
    }
    @Test (description = "Delete a category", priority = 3)
    public void deleteCategory(){
        login(ConfigData.EMAIL, ConfigData.PASSWORD);
        clickMenuProduct();
        clickMenuCategory();
        verifyHeardPageCategory();
        searchCategory("[12082024] - Category Update");
        clickIconDelete();
        clickDeleteButtonOnDeleteConfirmation();
        verifyItemDeleted("[12082024] - Category Update");

    }
}

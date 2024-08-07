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
    SoftAssert softAssert = new SoftAssert();

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
    public void clickMenuProduct(){
        //Click menu Product
        WebElement menuProducts = driver.findElement(By.xpath("//span[normalize-space()='Products']"));
        Assert.assertTrue(menuProducts.isDisplayed(), "Menu Products isn't display");
        menuProducts.click();
        sleep(1);
    }
    public void clickMenuCategory(){
        WebElement menuCategory = driver.findElement(By.xpath("//span[normalize-space()='Category']"));
        Assert.assertTrue(menuCategory.isDisplayed(), "Menu Category isn't display");
        menuCategory.click();
        sleep(1);
    }

    public void verifyHeardPageCategory(){
        //verify headerPage
        WebElement headerPage = driver.findElement(By.xpath("//h1[normalize-space()='All categories']"));
        softAssert.assertTrue(headerPage.isDisplayed(),"Header Page isn't right");
        softAssert.assertEquals(headerPage.getText(),"All categories", "Header page isn't right");
    }

    public void clickAddNewCategoryButton(){
        //Click button Add New Category
        WebElement btn_AddNewCategory = driver.findElement(By.xpath("//span[normalize-space()='Add New category']"));
        Assert.assertTrue(btn_AddNewCategory.isDisplayed(), "Add new Category button isn't display");
        Assert.assertEquals(btn_AddNewCategory.getText(), "Add New category", " Add new category button's name isn't right");
        btn_AddNewCategory.click();
    }

    public void verifyHeaderPageAddNewCategory(){
        //Verify headerPage Add New Category
        WebElement headerPageAddNewCategory = driver.findElement(By.xpath( "//h5[normalize-space()='Category Information']"));
        softAssert.assertTrue(headerPageAddNewCategory.isDisplayed(),"Header page add new category isn't display");
        softAssert.assertEquals(headerPageAddNewCategory.getText(), "Category Information", "Header Page Add new Category isn't right");
    }

    public void addBannerAndIcon(){
        WebElement att_Banner = driver.findElement(By.xpath("//label[contains(normalize-space(),'Banner')]//following-sibling::div/div[1]"));
        WebElement att_icon = driver.findElement(By.xpath( "//label[contains(normalize-space(),'Icon')]//following-sibling::div/div[1]"));

        //Add Banner
            att_Banner.click();
            sleep(1);
            driver.findElement(By.xpath("//input[@placeholder='Search your files']")).sendKeys("WMNS_AIR_JORDAN_Gree_MID");
            sleep(3);
            driver.findElement(By.xpath("//div[@title='WMNS_AIR_JORDAN_Gree_MID.png']")).click();
            sleep(2);
            WebElement btn_AddFilesBanner = driver.findElement(By.xpath("//button[normalize-space()='Add Files']"));
            Assert.assertTrue(btn_AddFilesBanner.isDisplayed(),"Button isn't display");
            Assert.assertEquals(btn_AddFilesBanner.getText(), "Add Files", "Button's name is not right");
            btn_AddFilesBanner.click();
            sleep(1);

            //Add icon
            att_icon.click();
            sleep(1);
            driver.findElement(By.xpath("//input[@placeholder='Search your files']")).sendKeys("niki");
            sleep(3);
            driver.findElement(By.xpath("//div[@title='niki.png']")).click();
            sleep(2);
            WebElement btn_AddFilesIcon = driver.findElement(By.xpath("//button[normalize-space()='Add Files']"));
            Assert.assertTrue(btn_AddFilesIcon.isDisplayed(),"Button isn't display");
            Assert.assertEquals(btn_AddFilesIcon.getText(), "Add Files", "Button's name is not right");
            btn_AddFilesIcon.click();
            sleep(1);
    }
    public void inputDataAddNewCategory(String categoryName){
        WebElement input_name =  driver.findElement(By.xpath("//input[@id='name']"));
        WebElement dropdown_ParentCategory = driver.findElement(By.xpath("//input[@id='order_level']"));
        WebElement dropdown_Type = driver.findElement(By.xpath("//select[@name='digital']"));
        WebElement input_OrderingNumber = driver.findElement(By.xpath("//input[@id='order_level']"));

        WebElement input_MetaTitle = driver.findElement(By.xpath("//input[@name='meta_title']"));
        WebElement input_MetaDescription = driver.findElement(By.xpath("//textarea[@name='meta_description']"));
        WebElement dropdown_FilteringAttributes = driver.findElement(By.xpath("//label[normalize-space()='Filtering Attributes']//parent::div//child::button"));

        if (input_name.getAttribute("value").isBlank()) {
            input_name.sendKeys(categoryName);
            sleep(1);
        } else {
            input_name.clear();
            input_name.sendKeys(categoryName);
            sleep(1);
        }

        if(dropdown_ParentCategory.getAttribute("value").isBlank()){
            dropdown_ParentCategory.sendKeys("1");
            sleep(1);
        }else {
            dropdown_ParentCategory.clear();
            dropdown_ParentCategory.sendKeys("1");
            sleep(1);
        }

        if(input_OrderingNumber.getAttribute("value").isBlank()){
            input_OrderingNumber.sendKeys("1");
            sleep(1);
        }
        else {
            input_OrderingNumber.clear();
            input_OrderingNumber.sendKeys("1");
            sleep(1);
        }

        //Select Type
            Select select = new Select(dropdown_Type);
            select.selectByVisibleText("Physical");
            sleep(1);

        if(input_MetaTitle.getAttribute("value").isBlank()){
            input_MetaTitle.sendKeys("Meta Title");
            sleep(1);
        } else {
            input_MetaTitle.clear();
            input_MetaTitle.sendKeys("Meta Title");
            sleep(1);
        }


        if(input_MetaDescription.getAttribute("value").isBlank()){
            input_MetaDescription.sendKeys("Meta Description");
            sleep(1);
        } else {
            input_MetaDescription.clear();
            input_MetaDescription.sendKeys("Meta Description");
            sleep(1);
        }

        if(dropdown_FilteringAttributes.getAttribute("title").contains("Nothing selected")) {
            dropdown_FilteringAttributes.click();
            driver.findElement(By.xpath("//div[@class='dropdown-menu show']//input[@aria-label='Search']")).sendKeys("Size");
            driver.findElement(By.xpath("//div[@class='dropdown-menu show']//input[@aria-label='Search']")).sendKeys(Keys.ENTER);
            sleep(1);
            driver.findElement(By.xpath("//button[@title='Size']")).click();
        }
    }

    public void clickSaveButton(){
        WebElement btn_Save = driver.findElement(By.xpath("//button[normalize-space()='Save']"));
        Assert.assertTrue(btn_Save.isDisplayed(), "Save button is not display");
        Assert.assertEquals(btn_Save.getText(), "Save", "Button name is not right");
        btn_Save.click();
        sleep(1);
    }

    public void verifyMessageActionSuccessful(String expectedMessage){
        //Verify message add successful
        WebElement messageSuccessful = driver.findElement(By.xpath("//span[@data-notify='message']"));
        Assert.assertEquals(messageSuccessful.getText(), expectedMessage, "Add new category successfully");
    }
    public void searchCategory(String categoryName){
//        Search Category vua add
        driver.findElement(By.xpath("//input[@id='search']")).sendKeys(categoryName);
        driver.findElement(By.xpath("//input[@id='search']")).sendKeys(Keys.ENTER);
        sleep(1);
        String nameCategory =  driver.findElement(By.xpath("//div[@class='card-body']//descendant::tbody/tr/td[2]")).getText();

        Assert.assertEquals(nameCategory, categoryName, "Category's name is not right" );
    }

    @Test
    public void createNewCategory(){
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
        inputDataAddNewCategory("[07082024] - Category");
        addBannerAndIcon();
        clickSaveButton();
        verifyMessageActionSuccessful("Category has been inserted successfully");
        searchCategory("[07082024] - Category");
    }
    @Test (description = "Edit a category")
    public void editCategory(){
        clickMenuProduct();
        clickMenuCategory();
        verifyHeardPageCategory();
        searchCategory("[07082024] - Category");
        WebElement icon_Edit = driver.findElement(By.xpath("(//div[@class='card-body']//descendant::tbody/tr/td[10])/a[@title= 'Edit']"));
        Assert.assertTrue(icon_Edit.isDisplayed(), "Icon Edit isn't display");
        icon_Edit.click();
        inputDataAddNewCategory("[07082024] - Category Update");
        clickSaveButton();
        verifyMessageActionSuccessful("Category has been updated successfully");
        clickMenuCategory();
        searchCategory("[07082024] - Category Update");
    }

    @Test (description = "Delete a category")
    public void deleteCategory(){
        clickMenuProduct();
        clickMenuCategory();
        verifyHeardPageCategory();
        searchCategory("[07082024] - Category Update");
        WebElement icon_Delete = driver.findElement(By.xpath("(//div[@class='card-body']//descendant::tbody/tr/td[10])/a[@title= 'Delete']"));
        Assert.assertTrue(icon_Delete.isDisplayed(), "Icon Delete isn't display");
        icon_Delete.click();
        WebElement modalDelete =  driver.findElement(By.xpath("//div[@id='delete-modal']"));
        sleep(1);
        WebElement modal_header = modalDelete.findElement(By.xpath(".//div[@class='modal-header']//h4[normalize-space()='Delete Confirmation']"));
        sleep(1);
        WebElement modal_content = modalDelete.findElement(By.xpath(".//div[contains(@class,'modal-body')]//p[@class='mt-1']"));
        sleep(1);
        WebElement bnt_Delete = modalDelete.findElement(By.xpath(".//div[contains(@class,'modal-body')]//a[@id='delete-link']"));
        sleep(1);
        Assert.assertEquals(modal_header.getText(),"Delete Confirmation", "Header Modal is not right");
        sleep(1);
        Assert.assertEquals(modal_content.getText(),"Are you sure to delete this?", "Message confirm is not right" );
        sleep(1);
        bnt_Delete.click();
        sleep(1);
        verifyMessageActionSuccessful("Category has been deleted successfully");
        sleep(1);
        driver.findElement(By.xpath("//input[@id='search']")).sendKeys("[07082024] - Category Update");
        sleep(1);
        driver.findElement(By.xpath("//input[@id='search']")).sendKeys(Keys.ENTER);
        sleep(1);
        String nameCategory =  driver.findElement(By.xpath("//td[normalize-space()='Nothing found']")).getText();
        sleep(1);
        Assert.assertEquals(nameCategory, "Nothing found", "Delete category unsuccessful");
    }

}

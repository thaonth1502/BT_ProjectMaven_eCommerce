package com.thaonth.BT5.pages;

import com.thaont.constants.ConfigData;
import com.thaont.keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

   private By headLoginPage = By.xpath("//h1[normalize-space()='Welcome to Active eCommerce CMS']");
   private By inputEmail = By.xpath("//input[@id='email']");
   private By inputPassword = By.xpath("//input[@id='password']");
   private By checkboxRememberMe = By.xpath("//input[@id='remember']");
   private By linkForgotPassword = By.xpath("//a[normalize-space()='Forgot password ?']");
   private By btnLogin = By.xpath("//button[normalize-space()='Login']");
   private By errorMessage = By.xpath("//div[@role='alert']");

    public void loginCMS(String email, String password){
        driver.get(ConfigData.URL);

        wait.until(ExpectedConditions.visibilityOfElementLocated(headLoginPage));
        Assert.assertTrue(driver.findElement(headLoginPage).isDisplayed(), "Welcome to Active eCommerce CMS not display");
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputEmail));
        driver.findElement(inputEmail).sendKeys(email);

        wait.until(ExpectedConditions.visibilityOfElementLocated(inputPassword));
        driver.findElement(inputPassword).sendKeys(password);

        wait.until(ExpectedConditions.elementToBeClickable(btnLogin));
        driver.findElement(btnLogin).click();
    }

    public void verifyLoginSuccess(){
        Assert.assertEquals(driver.getCurrentUrl(), "https://cms.anhtester.com/admin", "FAIL !!! The current page not match!");
    }

    public void verifyLoginFail(String expectedMessage){
        Assert.assertTrue(driver.findElement(errorMessage).isDisplayed(), "FAIL !!! The error message not display");
        Assert.assertEquals(driver.findElement(errorMessage).getText(), expectedMessage, "The content of error message not match");
    }
    public void verifyLoginWithEmailBlank(String expectedMessage){
        String validateMessage = driver.findElement(inputEmail).getAttribute("validationMessage");
        System.out.println(validateMessage);
        Assert.assertEquals(validateMessage, expectedMessage, "FAIL!!! The content message when field empty not match");
    }

    public void verifyLoginWithPassworkBlank(String expectedMessage){
        String validateMessage = driver.findElement(inputPassword).getAttribute("validationMessage");
        System.out.println(validateMessage);
        Assert.assertEquals(validateMessage, expectedMessage, "FAIL!!! The content message when field empty not match");
    }
}

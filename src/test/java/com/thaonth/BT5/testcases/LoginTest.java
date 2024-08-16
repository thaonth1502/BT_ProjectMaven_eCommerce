package com.thaonth.BT5.testcases;

import com.thaont.constants.ConfigData;
import com.thaont.keywords.WebUI;
import com.thaonth.BT5.pages.LoginPage;
import common.BaseTest;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    LoginPage loginPage;

    @Test
    public void loginSuccess(){
        loginPage = new LoginPage(driver);
        loginPage.loginCMS(ConfigData.EMAIL, ConfigData.PASSWORD);
        loginPage.verifyLoginSuccess();
    }

    @Test
    public void loginFailWithEmailInvalid(){
        loginPage = new LoginPage(driver);
        loginPage.loginCMS("admin111@example.com", ConfigData.PASSWORD);
        loginPage.verifyLoginFail("Invalid login credentials");
    }

    @Test
    public void loginFailWithPasswordInvalid(){
        loginPage = new LoginPage(driver);
        loginPage.loginCMS(ConfigData.EMAIL, "123");
        loginPage.verifyLoginFail("Invalid login credentials");
    }

    @Test
    public void loginFailWithPasswordBlank(){
        loginPage = new LoginPage(driver);
        loginPage.loginCMS(ConfigData.EMAIL,"" );
        loginPage.verifyLoginWithPassworkBlank("Please fill out this field.");
    }

    @Test
    public void loginFailWithEmailBlank(){
        loginPage = new LoginPage(driver);
        loginPage.loginCMS("", ConfigData.PASSWORD);
        WebUI.sleep(2);
        loginPage.verifyLoginWithEmailBlank("Please fill out this field.");
    }
}

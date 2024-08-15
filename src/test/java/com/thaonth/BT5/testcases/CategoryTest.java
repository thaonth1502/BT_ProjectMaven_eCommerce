package com.thaonth.BT5.testcases;

import com.thaont.constants.ConfigData;
import com.thaonth.BT5.pages.CategoryPage;
import com.thaonth.BT5.pages.DashboardPage;
import com.thaonth.BT5.pages.LoginPage;
import common.BaseTest;
import org.testng.annotations.Test;

public class CategoryTest extends BaseTest {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    CategoryPage categoryPage;

    @Test
    public void verifyCategoryPage(){
        loginPage = new LoginPage(driver);
        loginPage.loginCMS(ConfigData.EMAIL, ConfigData.PASSWORD);

        dashboardPage = new DashboardPage(driver);
        dashboardPage.clickMenuCategory();

        categoryPage = new CategoryPage(driver);
        categoryPage.clickButtonAddNewCategory();
    }
    @Test
    public void deleteCategorySuccess(){
        loginPage = new LoginPage(driver);
        loginPage.loginCMS(ConfigData.EMAIL, ConfigData.PASSWORD);
        dashboardPage = new DashboardPage(driver);
        dashboardPage.clickMenuCategory();
        categoryPage = new CategoryPage(driver);
        categoryPage.searchCategory("ThaoNTH");
        categoryPage.deleteCategorySuccess();
        categoryPage.verifyDeleteCategorySuccess("Category has been deleted successfully");
    }

    @Test
    public void deleteCategoryUnSuccess(){
        loginPage = new LoginPage(driver);
        loginPage.loginCMS(ConfigData.EMAIL, ConfigData.PASSWORD);

        dashboardPage = new DashboardPage(driver);
        dashboardPage.clickMenuCategory();
        categoryPage = new CategoryPage(driver);
        categoryPage.searchCategory("ThaoNTH");
        categoryPage.deleteCategoryUnSuccess();
    }
}

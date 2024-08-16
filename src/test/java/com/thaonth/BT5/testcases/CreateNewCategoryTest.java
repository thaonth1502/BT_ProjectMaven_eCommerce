package com.thaonth.BT5.testcases;

import com.thaont.constants.ConfigData;
import com.thaonth.BT5.pages.CategoryPage;
import com.thaonth.BT5.pages.CreateNewCategoryPage;
import com.thaonth.BT5.pages.DashboardPage;
import com.thaonth.BT5.pages.LoginPage;
import common.BaseTest;
import org.testng.annotations.Test;


public class CreateNewCategoryTest extends BaseTest {

    LoginPage loginPage;
    DashboardPage dashboardPage;
    CategoryPage categoryPage;
    CreateNewCategoryPage createNewCategoryPage;

    @Test (priority = 1)
    public void createParentCategorySuccess(){
        loginPage = new LoginPage(driver);
        loginPage.loginCMS(ConfigData.EMAIL, ConfigData.PASSWORD);

        dashboardPage = new DashboardPage(driver);
        dashboardPage.clickMenuCategory();

        categoryPage = new CategoryPage(driver);
        categoryPage.clickButtonAddNewCategory();

        createNewCategoryPage = new CreateNewCategoryPage(driver);
        createNewCategoryPage.inputDataToFieldsInAddNewCategory(
                "ThaoNTH",
                "No Parent",
                "1",
                "Digital",
                "ThaoNTH add Meta title",
                "ThaoNTH add Meta Description",
                "Quality");
        createNewCategoryPage.attImageBanner("JORDAN1");
        createNewCategoryPage.attImageIcon("jordanLogo");
        createNewCategoryPage.clickButtonSave();
        createNewCategoryPage.verifyCreateCategorySuccess("Category has been inserted successfully");
    }

    @Test (priority = 2)
    public void createChildCategorySuccess(){
        loginPage = new LoginPage(driver);
        loginPage.loginCMS(ConfigData.EMAIL, ConfigData.PASSWORD);

        dashboardPage = new DashboardPage(driver);
        dashboardPage.clickMenuCategory();

        categoryPage = new CategoryPage(driver);
        categoryPage.clickButtonAddNewCategory();

        createNewCategoryPage = new CreateNewCategoryPage(driver);
        createNewCategoryPage.inputDataToFieldsInAddNewCategory(
                "ThaoNTH Child",
                "ThaoNTH",
                "1",
                "Digital",
                "ThaoNTH Child add Meta title",
                "ThaoNTH Child add Meta Description",
                "Quality");
        createNewCategoryPage.attImageBanner("JORDAN1");
        createNewCategoryPage.attImageIcon("jordanLogo");
        createNewCategoryPage.clickButtonSave();
        createNewCategoryPage.verifyCreateCategorySuccess("Category has been inserted successfully");
    }

}

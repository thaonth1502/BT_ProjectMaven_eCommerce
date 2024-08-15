package com.thaonth.BT5.testcases;

import com.thaont.constants.ConfigData;
import com.thaonth.BT5.pages.DashboardPage;
import com.thaonth.BT5.pages.LoginPage;
import common.BaseTest;
import org.testng.annotations.Test;

public class DashboardTest extends BaseTest {
    LoginPage loginPage;
    DashboardPage dashboardPage;

    @Test
    public void verifyDashboardPage(){
        loginPage = new LoginPage(driver);
        loginPage.loginCMS(ConfigData.EMAIL, ConfigData.PASSWORD);

        dashboardPage = new DashboardPage(driver);
        dashboardPage.verifyDashboard();
    }

    @Test
    public void verifyTotallOfSectionDashboard(){
        loginPage = new LoginPage(driver);
        loginPage.loginCMS(ConfigData.EMAIL, ConfigData.PASSWORD);

        dashboardPage = new DashboardPage(driver);
        dashboardPage.verifyTotalCustomer("218");
        dashboardPage.verifyTotalOrder("753");
        dashboardPage.verifyTotalProductCategory("826");
        dashboardPage.verifyTotalProductBrand("89");
    }
}

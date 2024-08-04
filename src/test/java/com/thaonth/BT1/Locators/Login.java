package com.thaonth.BT1.Locators;


import common.BaseTest;
import org.openqa.selenium.By;

public class Login extends BaseTest {

  public static  String inputEmail = "//input[@id='email']";
  public static  String inputPassword = "//input[@id='password']";
  public static  String bnt_Login = "//button[normalize-space()='Login']";

  public void login(String email, String pass) {
    driver.findElement(By.xpath(Login.inputEmail)).sendKeys(email);
    driver.findElement(By.xpath(Login.inputPassword)).sendKeys(pass);
    driver.findElement(By.xpath(Login.bnt_Login)).click();
  }
}

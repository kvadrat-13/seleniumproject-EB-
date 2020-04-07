package com.cybertek.tests.day_16_page_object_model;

import com.cybertek.base.TestBase;
import com.cybertek.pages.LoginPage;
import com.cybertek.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NegativeLoginPage extends TestBase {
    LoginPage loginPage;

    @BeforeMethod
    public void setUpTests() {
        driver.get(ConfigurationReader.getProperty("vytruck_url"));
        loginPage = new LoginPage();
    }

    @Test
    public void wrongUsernameTest() {

        loginPage.username.sendKeys("user3000");
        loginPage.password.sendKeys("UserUser123");
        loginPage.login.click();

        String actual = loginPage.errorMessage.getText();

        Assert.assertTrue(loginPage.errorMessage.isDisplayed());
        Assert.assertEquals(actual, "Invalid user name or password.");
    }

    @Test
    public void wrongPasswordTest() {
        loginPage.username.sendKeys("SalesManager110");
        loginPage.password.sendKeys("LC");
        loginPage.login.click();

        String actual = loginPage.errorMessage.getText();

        Assert.assertEquals(actual, "Invalid user name or password.");
        Assert.assertTrue(loginPage.errorMessage.isDisplayed());
    }
}

package com.cybertek.tests.day_16_page_object_model;

import com.cybertek.base.TestBase;
import com.cybertek.pages.LoginPage;
import com.cybertek.utilities.ConfigurationReader;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class PositiveLoginPage extends TestBase {
    LoginPage loginPage;
    WebDriverWait wait;

    @BeforeMethod
    public void setUpTests() {
        driver.get(ConfigurationReader.getProperty("vytruck_url"));
        loginPage = new LoginPage();
        wait = new WebDriverWait(driver, 5);

    }

    @Test
    public void loginAsDrivers() {
        String username = ConfigurationReader.getProperty("driver_username");
        String password = ConfigurationReader.getProperty("driver_password");

//        loginPage.username.sendKeys(username);
//        loginPage.password.sendKeys(password);
//        loginPage.login.click();

        // we have replace above by this

        loginPage.login(username, password);

        wait.until(ExpectedConditions.titleIs("Dashboard"));

        String actualTitle = driver.getTitle();
        assertEquals(actualTitle, "Dashboard");
    }

    @Test
    public void loginAsSalasManager() {
        String username = ConfigurationReader.getProperty("sales_manager_username");
        String password = ConfigurationReader.getProperty("sales_manager_password");
        loginPage.login(username, password);

        wait.until(ExpectedConditions.titleIs("Dashboard"));
        String actualTitle = driver.getTitle();
        assertEquals(actualTitle, "Dashboard");
//        assertFalse(loginPage.errorMessage.isDisplayed());
    }

    @Test
    public void loginAsStoreManager() {
        String username = ConfigurationReader.getProperty("store_manager_username");
        String password = ConfigurationReader.getProperty("store_manager_password");
        loginPage.login(username, password);

        wait.until(ExpectedConditions.titleIs("Dashboard"));
        assertEquals(driver.getTitle(), "Dashboard");


    }
}

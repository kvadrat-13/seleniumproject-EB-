package com.cybertek.tests.day_13_waits_and_synchranization;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class VyTrackLoginTestWithWait {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("firefox");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


    @Test
    public void test1() {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("https://qa3.vytrack.com/");

        WebElement userName = driver.findElement(By.id("prependedInput"));
        userName.sendKeys("SalesManager110");

        WebElement password = driver.findElement(By.id("prependedInput2"));
        password.sendKeys("UserUser123");
        password.submit();

        WebElement pageName = driver.findElement(By.cssSelector(".oro-subtitle"));
        Assert.assertEquals(pageName.getText(), "Dashboard");

        Assert.assertEquals(driver.getTitle(), "Dashboard");
    }

    @Test
    public void test2() {
        driver.get("http://practice.cybertekschool.com/dynamic_loading/3");
//        driver.manage().timeouts().implicitlyWait()
        WebElement input = driver.findElement(By.tagName("input"));
        input.sendKeys("t shirt");
    }

}

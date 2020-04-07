package com.cybertek.tests.day_13_waits_and_synchranization;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ThreadSleepExample {
    /*
    Thread.sleep
    Implicit ways - neyavnye
    Explicit ways - yavnye
    Also known as unconditional waiting. they actualy from Java
     */
    WebDriver driver;

    @BeforeMethod
    public void setUp() throws Exception {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() throws Exception {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void classInc() throws Exception {
        driver.get("http://practice.cybertekschool.com/dynamic_loading/4");
        Thread.sleep(7000);
        WebElement message = driver.findElement(By.cssSelector("#finish>h4"));
        Assert.assertTrue(message.isDisplayed());
        System.out.println(message.getText());
    }
}

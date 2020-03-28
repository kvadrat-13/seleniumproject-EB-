package com.cybertek.tests.day_10_webelement;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RadioButtonsTest {

    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() throws InterruptedException {
        driver = WebDriverFactory.getDriver("chrome");

        driver.get("http://practice.cybertekschool.com/radio_buttons");

    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }

    @Test
    public void test1() {
        WebElement blue = driver.findElement(By.id("blue"));
        // is selected --> returns true if element is selected (does not work on inputs)
        System.out.println(blue.isSelected());
        // verifies us the radio button is selected
        Assert.assertTrue(blue.isSelected());


        WebElement red = driver.findElement(By.id("red"));
        // print red is not selected
        System.out.println(red.isSelected());
        //verifies statement for false. If it is false, it passes. If true it fails
        Assert.assertFalse(red.isSelected());
//        Assert.assertTrue(!red.isSelected());  --> or we can do it, this way
    }

    @Test
    public void test2() {
        WebElement red = driver.findElement(By.id("red"));
        WebElement blue = driver.findElement(By.id("blue"));
        red.click();
        Assert.assertFalse(blue.isSelected());
        Assert.assertFalse(red.isSelected());

    }


}


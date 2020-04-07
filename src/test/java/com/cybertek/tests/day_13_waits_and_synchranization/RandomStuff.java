package com.cybertek.tests.day_13_waits_and_synchranization;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RandomStuff {
    WebDriver driver;
    WebDriverWait wait;

    @Test
    public void test1() {

        wait.until(ExpectedConditions.titleContains("Steam"));

        Assert.assertTrue(driver.getTitle().contains("Steam"));

        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("id"))).isDisplayed());


    }
}

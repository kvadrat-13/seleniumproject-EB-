package com.cybertek.tests.day_12_pops_tabs_alerts_iframes;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IFrameExample {
    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        driver = WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }

    @Test
    public void test1() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/tinymce");
        Thread.sleep(3000);

        //we will switch to iframe
        //TODO switch by id/name

        driver.switchTo().frame("mce_0_ifr");

        WebElement textBox = driver.findElement(By.id("tinymce"));
        textBox.clear();
        textBox.sendKeys("great! Thanks");
        Thread.sleep(2000);

        // get out of the frame

        driver.switchTo().defaultContent();
        System.out.println(driver.findElement(By.tagName("h3")).getText());

        //TODO switch by webelement
        WebElement frame = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(frame);

        textBox.clear();
        textBox.sendKeys("great! Thanks one more time");
        Thread.sleep(2000);

        //TODO switch by index
        driver.switchTo().frame(0);
        textBox.clear();
        textBox.sendKeys("great! Thanks last time");
        Thread.sleep(2000);


    }
}

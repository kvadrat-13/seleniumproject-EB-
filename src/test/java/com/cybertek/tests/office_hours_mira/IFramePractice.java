package com.cybertek.tests.office_hours_mira;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class IFramePractice {
    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();


    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }

    @Test
    public void test1() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/nested_frames");
        Thread.sleep(2000);
        // we landed to red webdocument  --> default content (Whole frame)
        driver.switchTo().frame("frame-top");
        // we are landed to blue webdocument --> another frame
        List<WebElement> frameList = driver.findElements(By.xpath("//frame"));
        /*
        we have stored all frames webelements inside the list
            1. Loop through list
            2. switch to each frame
                a. get test from body
                b. switch to parent
         */

        for (int i = 0; i < frameList.size(); i++) {
//            driver.navigate().refresh();
            Thread.sleep(1000);
            driver.switchTo().frame(i);
            String bodyText = driver.findElement(By.tagName("body")).getText();
            System.out.println("Body text: " + bodyText);
            driver.switchTo().parentFrame();
        }

        driver.switchTo().defaultContent();

        driver.switchTo().frame("frame-bottom");
        String bodyText = driver.findElement(By.xpath("//body")).getText();
        System.out.println("bodyText = " + bodyText);

        driver.switchTo().defaultContent();
    }

}

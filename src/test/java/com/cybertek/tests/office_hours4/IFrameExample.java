package com.cybertek.tests.office_hours4;

import com.cybertek.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class IFrameExample extends TestBase {

    @Test
    public void test() {
        driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_iframe_height_width");

        // switched to iframe using id
        driver.switchTo().frame("iframeResult");

        // Here we are checking if we are in the right frame!
        // We just need to print some info from this iframe
        WebElement h2 = driver.findElement(By.tagName("h2"));
        System.out.println(h2.getText());

        // switched to iframe using webelement
        WebElement innerFrame = driver.findElement(By.cssSelector("iframe[src='demo_iframe.htm']"));
        driver.switchTo().frame(innerFrame);

        System.out.println(driver.findElement(By.tagName("h1")).getText());

        // switched to the parent frame (Default)
//        driver.switchTo().parentFrame();
//        driver.switchTo().parentFrame();

        // here it goes to the main frame
        driver.switchTo().defaultContent();
        System.out.println(driver.findElement(By.cssSelector("span[class='cm-m-xml cm-meta']")).getText());

    }
}

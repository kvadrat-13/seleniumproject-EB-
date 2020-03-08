package com.cybertek.tests.home_work;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class AmazonScreenShot {
    static WebDriver driver;

    static void takeScreeShot(String fileName) throws IOException, InterruptedException {
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("/Users/EdilbekBrowne/Desktop/screenJava" + fileName + ".png"));
        Thread.sleep(3000);
    }


    public static void main(String[] args) throws InterruptedException, IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().fullscreen();
        driver.get("https://www.amazon.com/");

        driver.navigate().to("https://www.ebay.com/");
        Thread.sleep(2000);

        WebElement send = driver.findElement(By.xpath("//*[@id=\"gh-ac\"]"));
        send.sendKeys("wooden spoon");
        Thread.sleep(2000);

        driver.findElement(By.id("gh-btn")).click();
        Thread.sleep(2000);

        String expectedTitle = "wooden spoon | eBay";
        String actualTitle = driver.getTitle();

        if (expectedTitle.equals(actualTitle)) {
            System.out.println("PASS for Title");
        } else {
            System.out.println("FAIL for Title");
        }

        String expectedURL = "https://www.ebay.com/sch/i.html?_from=R40&_trksid=p2380057.m570.l1313.TR12.TRC2.A0.H0.Xwooden+spoon.TRS0&_nkw=wooden+spoon&_sacat=0";
        String actualURL = driver.getCurrentUrl();

        if (expectedURL.equals(actualURL)) {
            System.out.println("PASS for URL");
        } else {
            System.out.println("FAIL for URL");
        }

        Thread.sleep(3000);

        takeScreeShot("MyfirstScreenshot");


        driver.close();

    }

}

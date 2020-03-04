package com.cybertek.tests.day_2_locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.swing.*;
import java.io.File;

public class Login {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://app.vytrack.com/user/login");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//*[@id=\"prependedInput\"]")).sendKeys("storemanager52");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"prependedInput2\"]")).sendKeys("UserUser123");
        Thread.sleep(2000);
        driver.findElement(By.id("_submit")).click();


        String expectedTitle = "Dashboard";
        String actualTitle = driver.getTitle();
        if (expectedTitle.equals(actualTitle)) {
            System.out.println("PASS");
            System.out.println("Both Titles are matching");
        } else {
            System.out.println("FAIL");
            System.out.println("Titles are not matching");
        }

        String expectedURL = "https://app.vytrack.com/";
        String actualURL = driver.getCurrentUrl();
        if (expectedTitle.equals(actualTitle)) {
            System.out.println("PASS");
            System.out.println("Both URL are matching");
        } else {
            System.out.println("FAIL");
            System.out.println("URLs are not matching");
        }
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"widget-content-dashboard-widget-1484236547-14\"]/ul/li[1]/a")).click();
        Thread.sleep(3000);
        // driver.close();


    }
}

package com.cybertek.tests.day_4_xpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetAttribute2 {
    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/dynamic_loading");
        Thread.sleep(2000);

        WebElement ex1 = driver.findElement(By.partialLinkText("Example 1: "));
        System.out.println(ex1.getAttribute("name")); // -> no data
        System.out.println(ex1.getAttribute("type")); // -> no data
        System.out.println(ex1.getAttribute("href")); // -> http://practice.cybertekschool.com/dynamic_loading/1


        //driver.close();

    }
}

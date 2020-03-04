package com.cybertek.tests.day_1_navigation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstClass {
    public static void main(String[] args) throws InterruptedException {


        // binary the driver and browsers
        WebDriverManager.chromedriver().setup();

        //WebDriver driver --> Interface
        // I have a driver

        WebDriver driver = new ChromeDriver();

        // I want to open Google home page

        // how do you launch / open a web page?
        // by using get() --> url as String
        //driver.get("https://www.google.com/");

        // NAvigations
        // navigate().to() --> open a webpage
        // driver.navigate().to("https://www.amazon.com/");

        // get() vs navigate().to()
        // get() -> it will wait to load page fully
        // navigate().to() -> does not wait

        // navigate().back() ->
        // 1. go to google
        // 2. go to cybertek practice website

        driver.get("https://www.google.com/");
        Thread.sleep(3000);
        driver.navigate().to("http://practice.cybertekschool.com/");
        Thread.sleep(3000);
        driver.navigate().to("https://www.google.com/");
        driver.navigate().forward();

        //navigate().forward()
        // go to practice -> go to google -> back to practice
        // -> forward to google



    }
}

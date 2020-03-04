package com.cybertek.tests.day_1_navigation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerifyTitleEtsy {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get(" http://practice.cybertekschool.com");
        String expectedTitle = "Practice";
        driver.manage().window().fullscreen();
        String actualTitle = driver.getTitle();
        if (expectedTitle.equals(actualTitle)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
            System.out.println("I expected " + expectedTitle);
            System.out.println("The actual title is " + actualTitle);
        }

        Thread.sleep(3000);
        driver.close();
    }
}





//driver.get("https://www.etsy.com");
//        String expectedResult = "Etsy - Shop for handmade, vintage, custom, and unique gifts for everyone";
//        actualTitle = driver.getTitle();
//        if (expectedResult.equals(actualTitle)) {
//            System.out.println("PASS");
//        } else {
//            System.out.println("FAIL");
//            System.out.println("I expected " + expectedTitle);
//            System.out.println("The acrual title is " + actualTitle);

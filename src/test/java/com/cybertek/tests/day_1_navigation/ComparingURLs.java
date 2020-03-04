package com.cybertek.tests.day_1_navigation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ComparingURLs {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.com/");
        //Thread.sleep(3000);
        String googleTitle = "Google";

        driver.navigate().to("https://www.etsy.com/");
        //Thread.sleep(3000);


        driver.navigate().back();
        //Thread.sleep(3000);

        if (driver.getTitle().equals(googleTitle)) {
            System.out.println("PASSED for Google");
        } else {
            System.out.println("FAIL for Google");
        }

        driver.navigate().forward();
       // Thread.sleep(3000);


        String expectedTitleEtsy = "Etsy - Shop for handmade, vintage, custom, and unique gifts for everyone";

        if (driver.getTitle().equals(expectedTitleEtsy)) {
            System.out.println("PASSED for ETSY");
        } else {
            System.out.println("FAILED for ETSY");
        }
        driver.close();

    }
}

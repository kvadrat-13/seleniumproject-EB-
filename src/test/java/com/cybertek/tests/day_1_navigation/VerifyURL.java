package com.cybertek.tests.day_1_navigation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerifyURL {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.etsy.com/");


        String expectedURL = "https://www.etsy.com/";
        String actualURL = driver.getCurrentUrl();
        System.out.println(driver.getCurrentUrl());

        if(expectedURL.equals(actualURL)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("I expected: "+ expectedURL);
            System.out.println("The actual URL is:  "+ actualURL);
        }

        Thread.sleep(3000);
        driver.close();




    }
}

package com.cybertek.tests.day_1_navigation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerifyCybertekURL {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/");

        String expectedURL = "http://practice.cybertekschool.com/";
        String actualURL = driver.getCurrentUrl();

        if (expectedURL.equals(actualURL)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
            System.out.println("Actual URL " + actualURL);
            System.out.println("Expected URL " + expectedURL);
        }
        Thread.sleep(3000);
        driver.close();
    }
}

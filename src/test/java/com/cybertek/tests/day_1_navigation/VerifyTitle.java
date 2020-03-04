package com.cybertek.tests.day_1_navigation;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerifyTitle {
    public static void main(String[] args) throws InterruptedException {

        /*
        1. Go to Cybertek Practice web site
        2. Verify Title -> expected title: Practice
        Actual title? -->
         */


        // Connect browser and your driver
        //set up browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://practice.cybertekschool.com/");
        driver.manage().window().maximize();

        String expectedTitle = "practice";
        String actualTitle = driver.getTitle();
        if(expectedTitle.equals(actualTitle)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("I expected " + expectedTitle);
            System.out.println("The actual title is " + actualTitle);
            Thread.sleep(3000);
        }

        driver.close();






    }
}

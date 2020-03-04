package com.cybertek.tests.day_1_navigation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BookItTitleVerify {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://cybertek-reservation-qa.herokuapp.com/sign-in");
        driver.manage().window().maximize();
        Thread.sleep(3000);

        String expectedTitle = "bookit";
        String actualResult = driver.getTitle();
        if (expectedTitle.equals(actualResult)) {
            System.out.println("PASS");
            System.out.println("The actual title is \"" + actualResult + "\" is matching the expected title \"" + expectedTitle + "\"");
        } else {
            System.out.println("FAIL");
            System.out.println("The actual title is not mactching \"" + actualResult + "\" the expected title \"" + expectedTitle + "\"");
        }

        String expectedURL = "https://cybertek-reservation-qa.herokuapp.com/sign-in";
        String actualURL = driver.getCurrentUrl();

        if (expectedURL.equals(actualURL)) {
            System.out.println("PASS");
            System.out.println("Actual URL and Expected URl is matching ");
        } else {
            System.out.println("FAIL");
            System.out.println("Actual URL and Expected URl is not matching");
        }

        driver.close();

    }
}

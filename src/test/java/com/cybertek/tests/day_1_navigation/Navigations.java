package com.cybertek.tests.day_1_navigation;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Navigations {
    public static void main(String[] args) throws InterruptedException {

        /*
        Navigations:
        driver.navigate().to("URL)
        driver.navigate().back
        driver.navigate().forward
        driver.navigate().refresh
         */


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        // I want to see the full window
        driver.manage().window().fullscreen();
        // driver.manage().window().maximize(); <-- we can use as a second option

        String practiceWebURL = "http://practice.cybertekschool.com/";
        driver.get(practiceWebURL);

        Thread.sleep(3000);

        //go to google
        String ggURL = "https://www.google.com/";
        driver.navigate().to(ggURL);

        // back to practice
        driver.navigate().back();
        Thread.sleep(3000);

        // forward to google
        driver.navigate().forward();
        Thread.sleep(3000);

        // refresh the google page
        driver.navigate().refresh();
        Thread.sleep(3000);

        // close driver
        //close the current web browser ONLY
        driver.close();
        Thread.sleep(3000);

        // quit -> close down all thge windows in a browser
        driver.quit();








    }
}

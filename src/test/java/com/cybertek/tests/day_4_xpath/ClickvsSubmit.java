package com.cybertek.tests.day_4_xpath;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClickvsSubmit {
    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        /*
        click();
        submit();
         */

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/forgot_password");
        driver.findElement(By.name("email")).sendKeys("ediil.browne@gmail.com"); // + Keys.ENTER)
        Thread.sleep(2000);
        driver.findElement(By.id("form_submit")).submit();

        // Verify  --> expected result vs Actual result
        String expectedURL = "http://practice.cybertekschool.com/email_sent";
        String actualURL = driver.getCurrentUrl();
        if (expectedURL.equals(actualURL)) {
            System.out.println("PASS for URl");
        } else {
            System.out.println("FAIL for URL");
        }

        // Ternary operation for Verify URl
        //System.out.println((expectedURL.equals(actualURL)) ? "PASS for URl" : "FAIL for URl");

        // Verify text message
        String expectedText = "Your e-mail's been sent!";
        String actualText = driver.findElement(By.name("confirmation_message")).getText();

        if (expectedText.equals(actualText)) {
            System.out.println("PASS for text (they are matching");
        } else {
            System.out.println("FAIL for text (they are not matching");
        }


        driver.close();
    }
}

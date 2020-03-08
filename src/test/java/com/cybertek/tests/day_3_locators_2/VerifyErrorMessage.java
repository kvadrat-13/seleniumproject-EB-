package com.cybertek.tests.day_3_locators_2;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerifyErrorMessage {
    public static void main(String[] args) throws InterruptedException {
        /*
            1.go to login page
            2.enter invalid username
            3.enter invalid password
            4.verify the error message
         */
        //testers will gather test data in excel sheet
        //generate data from dummy data website

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/login");

        Faker faker = new Faker();
        String username = faker.name().username();
        String password = faker.app().author();

        driver.findElement(By.name("username")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);

        driver.findElement(By.id("wooden_spoon")).click();

        Thread.sleep(3000);

        driver.close();


    }
}

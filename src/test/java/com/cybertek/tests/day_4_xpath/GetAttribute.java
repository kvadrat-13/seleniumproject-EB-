package com.cybertek.tests.day_4_xpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetAttribute {
    static WebDriver driver;

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/forgot_password");

        WebElement retreivePasswordBttn = driver.findElement(By.id("form_submit"));  //.getAttribute("type");
        System.out.println(retreivePasswordBttn.getAttribute("type"));      // submit
        System.out.println(retreivePasswordBttn.getAttribute("class"));     // radius
        System.out.println(retreivePasswordBttn.getAttribute("id"));        // form_submit


        driver.close();


    }
}

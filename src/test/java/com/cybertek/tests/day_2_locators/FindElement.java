package com.cybertek.tests.day_2_locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElement {

    //Locator 1. ID
    // go to cybertek okta login page
    // write email to the text box
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://cybertekschool.okta.com/");
        driver.manage().window().maximize();
        Thread.sleep(3000);

        driver.findElement(By.id("okta-signin-username")).sendKeys("edilbek.browne@gmail.com");
        Thread.sleep(2000);
        driver.findElement(By.id("okta-signin-password")).sendKeys("Panda1993");
        Thread.sleep(2000);
        driver.findElement(By.id("okta-signin-submit")).submit();
        Thread.sleep(2000);

        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div/div/form[1]/div[2]/input")).click();

        Thread.sleep(3000);


        //driver.findElement(By.xpath("//*[@id=\"form8\"]/div[2]/input")).click();


        //driver.findElement(By.)


        //driver.close();
    }
}

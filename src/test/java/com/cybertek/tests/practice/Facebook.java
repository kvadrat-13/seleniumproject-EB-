package com.cybertek.tests.practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

public class Facebook {
    //static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();    // This object is to block all pop up notifications on Chrome Browser
        options.addArguments("--disable-notifications");
        WebDriver driver = new ChromeDriver(options);

        driver.manage().window().maximize();

        driver.get("https://facebook.com/");

        driver.findElement(By.id("email")).sendKeys("edil.browne@gmail.com");
        Thread.sleep(8000);

        driver.findElement(By.id("pass")).sendKeys("bimerbenz" + Keys.ENTER);
        Thread.sleep(8000);

        driver.findElement(By.className("_1frb")).sendKeys("arman birmagambetov" + Keys.ENTER);
        Thread.sleep(8000);

        driver.findElement(By.linkText("Birmagambetov Arman")).click();
        Thread.sleep(8000);

        driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/div/div[2]/div[2]/div[1]/div/div[1]/div/div[3]/" +
                "div/div[2]/div[2]/div/div/div[2]/a")).click();

        Thread.sleep(8000);

        driver.findElement(By.xpath("/html/body/div[1]/div[7]/div[1]/div/div/div[4]/div/div[1]/div/div/div/div/div/div/" +
                "div/div[2]/div[4]/div/div/div/span/div/div/div[2]/" +
                "div/div/div/div")).sendKeys("Hello, Arman! I know your xpath!!! Dont worry!!! You are good");




        //driver.close();


    }
}

package com.cybertek.tests.practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;


public class NewTab {
    static WebDriver driver;
    private static Object Command;

    public static void main(String[] args) throws InterruptedException {

//        WebDriverManager.chromedriver().setup();
//         driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.manage().window().maximize();
//        driver.get("https://mail.google.com/");
//        String selectLinkOpeninNewTab = Keys.chord(Keys.COMMAND,Keys.RETURN);
//        driver.findElement(By.linkText("www.facebook.com")).sendKeys(selectLinkOpeninNewTab);


        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://google.com/");
        Thread.sleep(3000);

        driver.findElement(By.cssSelector("#gsr")).sendKeys(Keys.COMMAND + "t");
        driver.get("https://facebook.com/");

        // driver.switchTo().window("https://facebook.com/");
        Thread.sleep(2000);
        driver.close();

        //*[@id="content"]/div/h4
        //html/body/div/div[2]/div/div/h4

    }
}

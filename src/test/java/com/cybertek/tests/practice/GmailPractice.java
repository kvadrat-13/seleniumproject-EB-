package com.cybertek.tests.practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GmailPractice {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://facebook.com/");
        driver.manage().window().maximize();
//        Thread.sleep(4000);

        driver.findElement(By.id("email")).sendKeys("edil.browne@gmail.com");
        Thread.sleep(3000);

        driver.findElement(By.id("pass")).sendKeys("Gladiator1993");

        Thread.sleep(3000);

        driver.findElement(By.id("u_0_b")).click();
        Thread.sleep(3000);
        driver.close();

        driver.findElement(By.xpath("input[@name='q']")).click();
        driver.findElement(By.xpath("input[@name='q']")).sendKeys("Hello world");
       // driver.findElement(By.)



//
//        String eT = "Gmail";
//        String aT = driver.getTitle();
//
//        if(eT.equalsIgnoreCase(aT)){
//            System.out.println("PASSED for email credentials");
//
//        }else{
//            System.out.println("FAILED for email credentials");
//        }
//
//        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Gladiator1993");
//        Thread.sleep(5000);
//
//        driver.findElement(By.xpath("//span[.='Next']")).click();
//        Thread.sleep(9000);
//
//
//
//





        driver.close();
    }
}

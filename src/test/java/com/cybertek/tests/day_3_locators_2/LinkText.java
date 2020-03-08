package com.cybertek.tests.day_3_locators_2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinkText {
    static WebDriver driver;

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/dynamic_loading");

        driver.manage().window().maximize();

        // findElement  linkText();
        WebElement example3 = driver.findElement(By.linkText("Example 3: Element on page that is hidden and become visible after 5 seconds"));
        String textVersionOfExample3 = example3.getText();
        System.out.println("textVersionOfExample3 [linkText ] = " + textVersionOfExample3);

        // findElement  partialLinkText();
        WebElement example4 = driver.findElement(By.partialLinkText("Example 4:"));
        String textVersionOfExample4 = example4.getText();
        System.out.println("textVersionOfExample4 [partialLinkText] = " + textVersionOfExample4);


        // linkText();
        WebElement cybertekSchool = driver.findElement(By.linkText("Cybertek School"));
        String linkTextReference = cybertekSchool.getText();
        System.out.println("linkTextReference = " + linkTextReference);

        //partialLinkText();
        WebElement cybertek = driver.findElement(By.partialLinkText("Cybertek"));
        String partailLinkTextReference = cybertek.getText();
        System.out.println("partailLinkTextReference = " + partailLinkTextReference);


    }
}

package com.cybertek.tests.day_3_locators_2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetAttributeValue {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/login");

        driver.manage().window().maximize();

        // I want to get the value of type attribute
        // type ="text"  ->  getAttribute(attribute name")

        // locate username box
        WebElement username = driver.findElement(By.name("username"));
        //driver.findElement(By.name("username")).getAttribute("type");
        String valueOfTypeUserName = username.getAttribute("type");
        System.out.println("valueOfType = " + valueOfTypeUserName);


        // locate password box
        WebElement password = driver.findElement(By.name("password"));
        String valueOfTypePassword = password.getAttribute("type");
        System.out.println("valueOfType = " + valueOfTypePassword);

        WebElement loginBttn = driver.findElement(By.id("wooden_spoon"));

        // i want to print class attributes value
        String valueOfLoginBttn = loginBttn.getAttribute("class");
        System.out.println("valueOfLoginBttn = " + valueOfLoginBttn);

        WebElement getClassName = driver.findElement(By.className("subheader"));
        String getText = getClassName.getText();
        System.out.println("getText() = " + getText);

        //driver.close();

    }
}

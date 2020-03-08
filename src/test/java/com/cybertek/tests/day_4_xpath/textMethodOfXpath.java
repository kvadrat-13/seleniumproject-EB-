package com.cybertek.tests.day_4_xpath;

import com.cybertek.utilities.WebDriverFactory;
import com.sun.rowset.JdbcRowSetResourceBundle;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class textMethodOfXpath {
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/context_menu");
        // WebElement textContext = driver.findElement(By.xpath("//h3[text()='Context Menu']"));
        WebElement textContext = driver.findElement(By.xpath("//div[@class='example']/h3"));

        System.out.println(textContext.getText());

    }
}


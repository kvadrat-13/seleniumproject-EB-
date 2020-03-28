package com.cybertek.tests.day_7_review;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonTestWithText {
    /**
     *  1. Open browser
     *  2. go to amazon
     *  3. search foe selenium cookbook
     *  4. verify the ther eis result with text "Selenium Testing Tools CookBook"
     *
     */
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://amazon.com");

        String searchTerm = "Selenium Testing Tools Cookbook - Second Edition";
        WebElement searchInput = driver.findElement(By.xpath("/html/body/div/header/div/div/div[3]/div/form/div[3]/div/input"));
        searchInput.sendKeys(searchTerm + Keys.ENTER);

        Thread.sleep(2000);
        WebElement searchBook = driver.findElement(By.xpath("//span[.='Selenium Testing Tools Cookbook - Second Edition']"));
        System.out.println(searchBook.getText());
        searchBook.click();




    }
}

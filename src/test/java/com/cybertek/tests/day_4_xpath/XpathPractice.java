package com.cybertek.tests.day_4_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class XpathPractice {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        WebElement userNameBox = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/form/div[1]/div/input"));
        userNameBox.sendKeys("tom");

        //      //tag[@attribute='value']

        //      <input type="text" name="username"
        //*[@id="login"]/div[1]/div/input
        //*[@id="login"]/div[1]/div/input


    }
}

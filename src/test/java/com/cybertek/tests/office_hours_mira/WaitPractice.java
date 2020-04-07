package com.cybertek.tests.office_hours_mira;

import com.cybertek.base.TestBase;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class WaitPractice extends TestBase {

    @Test
    public void testWait() {

        driver.get("http://qa3.vytrack.com");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        webDriverWait.until(ExpectedConditions.titleIs("Login"));

        WebElement username = driver.findElement(By.name("_username"));
        username.sendKeys("salesmanager110");

        WebElement password = driver.findElement(By.name("_password"));
        password.sendKeys("UserUser123");

        WebElement submitBttn = driver.findElement(By.name("_submit"));
        submitBttn.click();

        WebElement account = driver.findElement(By.xpath("//span[.='Accounts']/following-sibling::span/following-sibling::a"));
        account.click();

    }

}

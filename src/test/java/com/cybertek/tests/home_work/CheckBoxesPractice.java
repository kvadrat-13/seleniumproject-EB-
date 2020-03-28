package com.cybertek.tests.home_work;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CheckBoxesPractice {
    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        driver = WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }

    @Test
    public void test1() throws InterruptedException {
        Random rand = new Random();
        driver.get("http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCheckBox");
        Thread.sleep(3000);
        List<WebElement> boxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
        List<WebElement> enabledBoxes = new ArrayList<>();
        for (WebElement each : boxes) {
            if (each.isEnabled()) {
                enabledBoxes.add(each);
            }
        }
        List<WebElement> days3 = driver.findElements(By.xpath("//input[@type='checkbox']/following-sibling::*"));
        List<String> days2 = new ArrayList<>();
        for (int i = 0; i < days3.size(); i++) {
            if (boxes.get(i).isEnabled()) {
                days2.add(days3.get(i).getText());
            }
        }
        System.out.println("Days are enabled: " + days2);
        int friday = 0;
        do {
            int number = rand.nextInt(5);
            for (int i = 0; i < 3; i++) {
                boxes.get(number).click();
                Thread.sleep(1000);
                System.out.println(days2.get(number));
                Assert.assertTrue(boxes.get(number).isSelected());
                if (boxes.get(4).isSelected()) {
                    friday++;
                }
                boxes.get(number).click();
                Assert.assertFalse(boxes.get(number).isSelected());
            }
        } while (friday < 3);
    }

    @Test
    public void test2() {
        driver.get("http://practice.cybertekschool.com/dropdown");
        //verify that dropdowns under Select your date of birth display current year, month,day

        Select year = new Select(driver.findElement(By.id("year")));
        String actualYear = year.getFirstSelectedOption().getText();
        System.out.println(year.getFirstSelectedOption().getText());

        Select month = new Select(driver.findElement(By.id("month")));
        String actualMonth = month.getFirstSelectedOption().getText();
        System.out.println(actualMonth);

        Select day = new Select(driver.findElement(By.id("day")));
        String actualDay = day.getFirstSelectedOption().getText();
        System.out.println(actualDay);

        String year2 = LocalDate.now().getYear() + "";
        System.out.println(year2);
        String month2 = LocalDate.now().getMonth().name();
        System.out.println(month2);
        String day2 = LocalDate.now().getDayOfMonth() + "";
        System.out.println(day2);

        Assert.assertEquals(actualYear, year2);
        Assert.assertEquals(actualMonth.toLowerCase(), month2.toLowerCase());
        Assert.assertEquals(actualDay, day2);
    }
}





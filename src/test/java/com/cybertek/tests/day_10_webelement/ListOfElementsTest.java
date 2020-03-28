package com.cybertek.tests.day_10_webelement;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;

public class ListOfElementsTest {
    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        driver = WebDriverFactory.getDriver("chrome");

    }

    @AfterMethod
    public void afterTest() {
//        driver.quit();
    }

    /*
    go to page radio buttons
    verify that none of the sports radio buttons are selected
     */
    @Test
    public void listOfRadioButtons() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/radio_buttons");

        //   driver.findElements --> returns a LIST of element
        // if the locator does not match anhytihg, it does not throw exception, it just returns empty list

        List<WebElement> sports = driver.findElements(By.name("sport"));

        System.out.println(sports.size());

        for (WebElement radioButton : sports) {
            Assert.assertFalse(radioButton.isSelected());
        }
    }

    @Test
    public void getAllLinkTest() {
        driver.get("http://practice.cybertekschool.com");

        //get all the links in a page
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println(links.size());
        // get the text of each link and print

        for (WebElement link : links) {
            System.out.println(link.getText());
        }
    }

    @Test
    public void amazonTest() throws InterruptedException {
        driver.get("https://amazon.com");
        WebElement input = driver.findElement(By.id("twotabsearchtextbox"));
        input.sendKeys("paper towels" + Keys.ENTER);
        Thread.sleep(4000);

        List<WebElement> allResults = driver.findElements(By.cssSelector("span.a-size-base-plus"));
        System.out.println("number of results = " + allResults.size());
        System.out.println("First result = " + allResults.get(0).getText());
        System.out.println("Second result = " + allResults.get(1).getText());
        System.out.println("Last result = " + allResults.get(allResults.size() - 1).getText());

    }

    @Test
    public void myTest() throws InterruptedException {

        driver.get("http://practice.cybertekschool.com/radio_buttons");

        List<WebElement> myElem = driver.findElements(By.name("sport"));
//        System.out.println("Verify none of them selected by default");
//        for(int i =0;i<myElem.size(); i++){
//            Assert.assertFalse(myElem.get(i).isSelected());
//        }

        Thread.sleep(2000);
        Random random = new Random();
        for (int outter = 0; outter < 5; outter++) {
            int num = random.nextInt(4);
            Thread.sleep(2000);
            myElem.get(num).click();
            for (int i = 0; i < myElem.size(); i++) {
                if (i == num) {
                    Assert.assertTrue(myElem.get(i).isSelected());
                    System.out.println(myElem.get(i).getAttribute("id") + " - " + myElem.get(i).isSelected());
                } else {
                    Assert.assertFalse(myElem.get(i).isSelected());
                    System.out.println(myElem.get(i).getAttribute("id") + " - " + myElem.get(i).isSelected());
                }
            }
            System.out.println("===============");
        }
    }
}

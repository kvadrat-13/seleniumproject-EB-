package com.cybertek.tests.day_8_review_2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VytrackTests {
    public static void main(String[] args) throws InterruptedException {
        //titleTest();
        shortCutTest();
    }

    /*
    1. Open browser
    2. Go to Vytrack login page
    3. Login as a sales manager
    4. Verify Dashboard page is open
    5. Click on Shortcuts icon
    6. Click on link See full list
    7. Click on link Opportunities
    8. Verify Open opportunities page is open
    9. Click on Shortcuts icon
    10. Click on link See full list
    11. Click on link Vehicle Service Logs
    12. Verify error message text is You do not have
    permission to perform this action.
    13. Verify Shortcut Actions List page is still open
    */
    private static void shortCutTest() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://qa3.vytrack.com/user/login");
        WebElement userName = driver.findElement(By.id("prependedInput"));
        userName.sendKeys("SalesManager110");
        WebElement password = driver.findElement(By.id("prependedInput2"));
        password.sendKeys("UserUser123");
        password.submit();
        Thread.sleep(3000);
        String expectedTitle = "Dashboard";
        String actualTitle = driver.getTitle();
        verifyStartsWith(expectedTitle, actualTitle);
        WebElement shortCut = driver.findElement(By.cssSelector("a[title='Shortcuts']"));
        shortCut.click();
        WebElement allLinks = driver.findElement(By.linkText("See full list"));
        allLinks.click();
        Thread.sleep(3000);
        WebElement opportunities = driver.findElement(By.linkText("Opportunities"));
        opportunities.click();
//        expectedTitle = "Open Opportunities";
//        actualTitle = driver.getTitle();
        Thread.sleep(3000);
        verifyStartsWith("Open Opportunities", driver.getTitle());
        shortCut.click();
        allLinks.click();
        Thread.sleep(3000);
        WebElement vehicleServiceLog = driver.findElement(By.linkText("Vehicle Services Logs"));
        vehicleServiceLog.click();
        Thread.sleep(3000);
        WebElement errorMessage = driver.findElement(By.cssSelector(".message"));
        Thread.sleep(2000);
        verifyStartsWith("You do not have permission to perform this action", errorMessage.getText());
        verifyStartsWith("Shortcut Actions List", driver.getTitle());
        driver.quit();
    }

    private static void verifyStartsWith(String expectedTitle, String actualTitle) {
        if (actualTitle.startsWith(expectedTitle)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
            System.out.println("expectedTitle = " + expectedTitle);
            System.out.println("actualResult = " + actualTitle);
        }
    }

    private static void titleTest() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://qa3.vytrack.com/user/login");
        WebElement userName = driver.findElement(By.id("prependedInput"));
        userName.sendKeys("SalesManager110");
        WebElement password = driver.findElement(By.id("prependedInput2"));
        password.sendKeys("UserUser123");
        WebElement login = driver.findElement(By.id("_submit"));
        login.click();
        WebElement profileName = driver.findElement(By.cssSelector("a[href='javascript: void(0);']"));
        Thread.sleep(2000);
        profileName.click();
        WebElement myConfiguration = driver.findElement(By.cssSelector("ul.dropdown-menu>li>a[href='/config/user/profile']"));
        Thread.sleep(2000);
        myConfiguration.click();
        Thread.sleep(3000);
        String expected = profileName.getText();
        String actual = driver.getTitle();
        if (actual.startsWith(expected)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
            System.out.println("expected = " + expected);
            System.out.println("actual = " + actual);
        }
//        SalesManager110
//        UserUser123
    }
}

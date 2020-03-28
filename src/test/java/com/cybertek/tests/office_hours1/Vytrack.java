package com.cybertek.tests.office_hours1;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;

public class Vytrack {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("https://qa3.vytrack.com/");

        WebElement userName = driver.findElement(By.id("prependedInput"));
        userName.sendKeys("SalesManager110");

        WebElement password = driver.findElement(By.id("prependedInput2"));
        password.sendKeys("UserUser123");
        password.submit();

        Thread.sleep(3000);

        WebElement contacts_link = driver.findElement(By.xpath("//span[.='Contacts']/following-sibling::a"));
        contacts_link.click();

        Thread.sleep(3000);

        WebElement create_contact = driver.findElement(By.linkText("Create Contact"));
        create_contact.click();

        Thread.sleep(2000);

        String currentTitle = driver.getTitle();
        ;
        if (currentTitle.equals("Create Contact - Contacts - Customers")) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }

        HashMap<String, String> contact1 = new HashMap<>();
        contact1.put("First Name", "John");
        contact1.put("Last Name", "Smith");
        contact1.put("Phone", "501-236-4545");
        contact1.put("Street address", "400 Main Street");
        contact1.put("City", "Tysons");
        contact1.put("State", "Va");
        contact1.put("Zip Code", "22102");
        contact1.put("Sales group", "true");
        contact1.put("Country", "UnitedStates");

        System.out.println("Contact 1: " + contact1);


    }
}

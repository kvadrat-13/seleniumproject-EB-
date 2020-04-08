package com.cybertek.tests.day_17_ddt_dataprovider_pom2;

import com.cybertek.base.VytrackTestBase;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;

public class MenuOptionTests extends VytrackTestBase {

    @Test
    public void test() {
        loginPage.login(ConfigurationReader.getProperty("driver_username"),
                ConfigurationReader.getProperty("driver_password"));


        dashboardPage.changeMenu("Fleet", "Vehicles");
        wait.until(ExpectedConditions.titleIs("Car - Entities - System - Car - Entities - System"));
        assertEquals(driver.getTitle(), "Car - Entities - System - Car - Entities - System");

        dashboardPage.changeMenu("Activities", "Calendar Events");
        wait.until(ExpectedConditions.titleIs("Calendar Events - Activities"));
        assertEquals(driver.getTitle(), "Calendar Events - Activities");
    }

    // DDT (Data Driven Test)
    @Test(dataProvider = "test-data")
    public void ddtTest(String menu1, String menu2, String expectedTitle) {
        loginPage.login(ConfigurationReader.getProperty("driver_username"),
                ConfigurationReader.getProperty("driver_password"));
        dashboardPage.changeMenu(menu1, menu2);
        wait.until(ExpectedConditions.titleContains(expectedTitle));
        assertTrue(driver.getTitle().contains(expectedTitle));

    }

    @DataProvider(name = "test-data")
    public Object[][] getData() {
        return new Object[][]{
                {"Fleet", "Vehicles", "Car"},
                {"Fleet", "Vehicle Costs", "Vehicle Costs"},
                {"Customers", "Contacts", "Contacts - Customers"},
                {"Activities", "Calendar Events", "Calendar Events - Activities"},
                {"System", "System Calendars", "System Calendars - System"}
        };
    }

    //login as Driver
    //verify that Driven can see menu options Fleet, Customers, Activities,System
    @Test
    public void testAllOptionsDriver() {
        loginPage.login(ConfigurationReader.getProperty("driver_username"),
                ConfigurationReader.getProperty("driver_password"));

        List<String> expectedList = Arrays.asList("Fleet", "Customers", "Activities", "System");
        List<String> actualList = BrowserUtils.getElementsText(dashboardPage.menu1Options);
        assertEquals(actualList, expectedList);

    }
}

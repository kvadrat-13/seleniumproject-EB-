package com.cybertek.tests.day_16_page_object_model;

import com.cybertek.base.VytrackTestBase;
import com.cybertek.pages.DashboardPage;
import com.cybertek.utilities.ConfigurationReader;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class PageHeadersTest extends VytrackTestBase {
    // go to vyrack
    // login as driver
    // verify  header is "Quick Launchpad"

    @Test
    public void dashboardPageTest() {

        test = report.createTest("Dashboard page title test");

        String username = ConfigurationReader.getProperty("driver_username");
        String password = ConfigurationReader.getProperty("driver_password");
        test.info("Logging in to application");
        loginPage.login(username, password);

        DashboardPage dashboardPage = new DashboardPage();
        wait.until(ExpectedConditions.textToBePresentInElement(dashboardPage.pageHeader, "Quick Launchpad"));
        String actual = dashboardPage.pageHeader.getText();
        test.info("Verfying page header text");
        assertEquals(actual, "Quick Launchpad");
        test.info("PASS: Dashboard page title test");


    }


    //    go to vyrack
    // go to Fleet vehicles
    // login as driver
    // verify  header is "All Cars"
    @Test
    public void fleetVehiclesTest() {
        test = report.createTest("Vehicles page title test");

        String username = ConfigurationReader.getProperty("driver_username");
        String password = ConfigurationReader.getProperty("driver_password");
        test.info("Logging in to application");

        loginPage.login(username, password);

        //open page

        test.info("Going to Fleet -> Vehicles");
        wait.until(ExpectedConditions.elementToBeClickable(dashboardPage.fleet));
        dashboardPage.fleet.click();
        wait.until(ExpectedConditions.elementToBeClickable(dashboardPage.vehicles));
        dashboardPage.vehicles.click();

        wait.until(ExpectedConditions.textToBePresentInElement(vehiclesPage.pageHeader, "Cars"));
        test.info("Verifying page header");
        String actual = vehiclesPage.pageHeader.getText();
        assertEquals(actual, "Cars");
        test.info("PASS: Vehicles page title test");

    }


}

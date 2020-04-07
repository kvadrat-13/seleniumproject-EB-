package com.cybertek.tests.day_16_page_object_model;

import com.cybertek.base.VytruckTestBase;
import com.cybertek.pages.DashboardPageBase;
import com.cybertek.utilities.ConfigurationReader;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class PageHeadersTest extends VytruckTestBase {
    // go to vyrack
    // login as driver
    // verify  header is "Quick Launchpad"

    @Test
    public void dashboardPageTest() {
        String username = ConfigurationReader.getProperty("driver_username");
        String password = ConfigurationReader.getProperty("driver_password");
        loginPage.login(username, password);

        DashboardPageBase dashboardPage = new DashboardPageBase();
        wait.until(ExpectedConditions.textToBePresentInElement(dashboardPage.pageHeader, "Quick Launchpad"));
        String actual = dashboardPage.pageHeader.getText();
        assertEquals(actual, "Quick Launchpad");




    }


    //    go to vyrack
    // go to Fleet vehicles
    // login as driver
    // verify  header is "All Cars"
    @Test
    public void flletVehiclesTest() throws InterruptedException {
        String username = ConfigurationReader.getProperty("driver_username");
        String password = ConfigurationReader.getProperty("driver_password");
        loginPage.login(username, password);

        //open page

        wait.until(ExpectedConditions.elementToBeClickable(dashboardPage.fleet));
        dashboardPage.fleet.click();
        wait.until(ExpectedConditions.elementToBeClickable(dashboardPage.vehicles));
        dashboardPage.vehicles.click();

        wait.until(ExpectedConditions.textToBePresentInElement(vehiclesPage.pageHeader, "Cars"));
        String actual = vehiclesPage.pageHeader.getText();
        assertEquals(actual, "Cars");
    }


}

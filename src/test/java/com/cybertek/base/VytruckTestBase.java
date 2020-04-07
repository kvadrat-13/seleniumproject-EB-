package com.cybertek.base;

import com.cybertek.pages.CreateCalendarEventPageBase;
import com.cybertek.pages.DashboardPageBase;
import com.cybertek.pages.LoginPage;
import com.cybertek.pages.VehiclesPageBase;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class VytruckTestBase {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected LoginPage loginPage;
    protected DashboardPageBase dashboardPage;
    protected VehiclesPageBase vehiclesPage;
    protected CreateCalendarEventPageBase createCalendarEventPage;

    @BeforeMethod
    public void setUpMethod() {
        driver = Driver.getDriver();
        wait = new WebDriverWait(driver, 10);
        driver.get(ConfigurationReader.getProperty("vytruck_url"));
        loginPage = new LoginPage();
        dashboardPage = new DashboardPageBase();
        vehiclesPage = new VehiclesPageBase();
        createCalendarEventPage = new CreateCalendarEventPageBase();


    }

    @AfterMethod
    public void tearDownMethod() throws InterruptedException {
//        Thread.sleep(5000);
        Driver.closeDriver();
    }
}

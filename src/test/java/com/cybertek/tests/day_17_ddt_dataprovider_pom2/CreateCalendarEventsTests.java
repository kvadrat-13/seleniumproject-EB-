package com.cybertek.tests.day_17_ddt_dataprovider_pom2;

import com.cybertek.base.VytruckTestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CreateCalendarEventsTests extends VytruckTestBase {

    @Test
    public void allDayEventRadioTest() {
        loginPage.login(ConfigurationReader.getProperty("driver_username"),
                ConfigurationReader.getProperty("driver_password"));

        driver.get("https://qa3.vytrack.com/calendar/event/create");

        assertFalse(createCalendarEventPage.allDayEventCheckBox.isSelected());
    }

    @Test
    public void repeatCheckBoxTest() {
        loginPage.login(ConfigurationReader.getProperty("driver_username"),
                ConfigurationReader.getProperty("driver_password"));

        driver.get("https://qa3.vytrack.com/calendar/event/create");
        wait.until(ExpectedConditions.elementToBeClickable(createCalendarEventPage.repeatedCheckBox));
        assertFalse(createCalendarEventPage.repeatedCheckBox.isSelected());
    }
}

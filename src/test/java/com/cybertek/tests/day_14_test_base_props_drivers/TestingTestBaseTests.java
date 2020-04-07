package com.cybertek.tests.day_14_test_base_props_drivers;

import com.cybertek.base.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestingTestBaseTests extends TestBase {


    @Test
    public void testTitle() {
        String url = ConfigurationReader.getProperty("url");
        driver.get(url);

        Assert.assertEquals(driver.getTitle(), "Practice");
    }
}

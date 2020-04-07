package com.cybertek.tests.day_14_test_base_props_drivers;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.Properties;

public class PropertiesExample {

    @Test
    public void test1() {
        System.out.println(System.getProperty("os.name"));
        System.out.println(System.getProperty("os.version"));
        System.out.println(System.getProperty("user.home"));
        System.out.println(System.getProperty("user.name"));

        //browser url
        // Properties --> class form java that saves key value combinations
        Properties properties = new Properties();
        properties.setProperty("browser", "chrome");
        properties.setProperty("url", "http://practice.cybertekschool.com");

        String browser = properties.getProperty("browser");
        System.out.println("browser name = " + browser);

        // i need read the browser/url from properties file

        String pBrowser = ConfigurationReader.getProperty("browser");
        System.out.println("pBrowser = " + pBrowser);

        String pURL = ConfigurationReader.getProperty("url");
        System.out.println("pURL = " + pURL);
    }

    @Test
    public void test2() {
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        //get the from props file
        String url = ConfigurationReader.getProperty("url");
        driver.get(url);
        driver.close();
    }

    @Test
    public void test3() {
        String str = Singleton.getInstance();
        System.out.println(str);
    }
}

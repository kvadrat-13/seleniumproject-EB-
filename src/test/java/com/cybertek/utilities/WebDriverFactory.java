package com.cybertek.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {


    public static WebDriver getDriver(String browserType) {
        // local variables

//        if (browserType.contains("ChromeDriver")) {
//            return new ChromeDriver();
//        } else {
//            return new FirefoxDriver();
//        }

        WebDriver driver = null;
        switch (browserType.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
               // driver.manage().window().maximize();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
        }
        return driver;
    }


    public static void main(String[] args) {

        // write a return static method which returns WebDriver
        // name: gerDriver
        // it takes a String as a parameter --> browser type
        // returns ChromeDriver and FirefoxDriver


    }
}

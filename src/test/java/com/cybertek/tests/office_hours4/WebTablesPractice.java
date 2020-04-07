package com.cybertek.tests.office_hours4;

import com.cybertek.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebTablesPractice extends TestBase {

    @BeforeMethod
    public void setUpTests() {
        driver.get("https://www.mockaroo.com/");

        WebElement inputBox = driver.findElement(By.id("num_rows"));
        inputBox.clear();
        inputBox.sendKeys("10");
        driver.findElement(By.id("preview")).click();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.switchTo().frame("preview_iframe");
    }

    @Test
    public void testHeaderCount() {
        WebElement table = driver.findElement(By.xpath("//table"));
        System.out.println(table.getText());

        //get all everything in the table
        List<WebElement> headers = driver.findElements(By.xpath("//table[@style]//th"));
        Assert.assertEquals(headers.size(), 6);

    }

    /*
      verify that value of each entry under gender column is equal to Male or Female
       */
    @Test
    public void verifyGender() {
        List<WebElement> allGenders = driver.findElements(By.xpath("//table[@style]/tbody/tr[1]/td[5]"));
        System.out.println(allGenders.size());

        // go through the list
        // verify that values is either Male or Female

        for (WebElement gender : allGenders) {
            String actual = gender.getText();
            Assert.assertTrue(actual.equals("Male") || actual.equals("Female"));
        }
    }

    // get cell in relation to another cell
    // Jason
    @Test
    public void verifyCellValueByOtherCell() {
        driver.get("http://practice.cybertekschool.com/tables");

        String firstName = "Jason";
        String xpath = "//table[@id='table1']//td[1][.='Doe']/../td[2][.='" + firstName + "']/../td[4]";
        WebElement amount = driver.findElement(By.xpath(xpath));
        Assert.assertEquals(amount.getText(), "$100.00");
    }

//    //Katerina Medvedieva
//    public String getXpathForValue(String value, String columnIdx){
//        ""
//
//    }

}

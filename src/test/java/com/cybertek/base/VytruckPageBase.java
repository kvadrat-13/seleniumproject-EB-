package com.cybertek.base;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public abstract class VytruckPageBase {
    public VytruckPageBase() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(className = "oro-subtitle")
    public WebElement pageHeader;

    @FindBy(xpath = "//span[contains(text(), 'Fleet')][@class='title title-level-1']")
    public WebElement fleet;

    @FindBy(xpath = "//span[.='Vehicles'][@class='title title-level-2']")
    public WebElement vehicles;

    @FindBy(xpath = "(//a[@class='dropdown-toggle'])[1]")
    public WebElement accountHolderName;

    @FindBy(css = ".title-level-1")
    public List<WebElement> menu1Options;

//    @FindAll
//    @FindBys()


    public void changeMenu(String menu1, String menu2) {
        //menu1 -> Fleet
        //menu1 -> Vehicles
        // locate the menu1

        String menu1Xpath = "//span[contains(text(), '" + menu1 + "')][@class='title title-level-1']";
        WebElement menu1Element = Driver.getDriver().findElement(By.xpath(menu1Xpath));

        String menu2Xpath = "//span[.='" + menu2 + "'][@class='title title-level-2']";
        WebElement menu2Element = Driver.getDriver().findElement(By.xpath(menu2Xpath));

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 5);
        wait.until(ExpectedConditions.elementToBeClickable(menu1Element));
        menu1Element.click();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        wait.until(ExpectedConditions.elementToBeClickable(menu2Element));
        menu2Element.click();
    }

}

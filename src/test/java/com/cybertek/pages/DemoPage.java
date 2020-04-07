package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DemoPage {

    public DemoPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "skdljfblkjsd")
    public WebElement username;


    @FindBy(xpath = "skdljfblkjsd")
    public WebElement password;

    public void login(String username, String password){
        this.username.sendKeys(username);
    }


}

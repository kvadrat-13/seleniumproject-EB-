package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage() {
        // page object classes needs contructor. here we have to call the PageFactory.initElements
        // from selenium and pass a webdriver object and this class as param
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(name = "_username")
    public WebElement username;

    @FindBy(name = "_password")
    public WebElement password;

    @FindBy(id = "_submit")
    public WebElement login;

    @FindBy(xpath = "//div[@class='alert alert-error']/div") // or css  .alert-error>div
    public WebElement errorMessage;


    public void login(String username, String password) {
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        login.click();
    }


}

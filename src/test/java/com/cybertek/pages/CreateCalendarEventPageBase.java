package com.cybertek.pages;

import com.cybertek.base.VytruckPageBase;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCalendarEventPageBase extends VytruckPageBase {
    public CreateCalendarEventPageBase() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(name = "oro_calendar_event_form[allDay]")
    public WebElement allDayEventCheckBox;

    @FindBy(css = "input[id^='recurrence-repeat']")
    public WebElement repeatedCheckBox;
}



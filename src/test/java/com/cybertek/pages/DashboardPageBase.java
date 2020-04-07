package com.cybertek.pages;

import com.cybertek.base.VytruckPageBase;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public class DashboardPageBase extends VytruckPageBase {
    public DashboardPageBase() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


}



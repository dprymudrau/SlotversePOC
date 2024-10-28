package com.sloverset.qa.mobile.gui.android;

import com.sloverset.qa.mobile.gui.common.HomeScreenBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = HomeScreenBase.class)
public class HomeScreen extends HomeScreenBase {

    public HomeScreen(WebDriver driver) {
        super(driver);
    }
}

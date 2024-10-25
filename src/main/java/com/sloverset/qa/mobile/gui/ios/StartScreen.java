package com.sloverset.qa.mobile.gui.ios;

import com.sloverset.qa.mobile.gui.common.StartScreenBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = StartScreenBase.class)
public class StartScreen extends StartScreenBase {

    protected StartScreen(WebDriver driver) {
        super(driver);
    }
}

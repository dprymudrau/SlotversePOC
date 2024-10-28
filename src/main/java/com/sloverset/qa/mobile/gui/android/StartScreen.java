package com.sloverset.qa.mobile.gui.android;

import com.sloverset.qa.mobile.gui.common.StartScreenBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = StartScreenBase.class)
public class StartScreen extends StartScreenBase {

    public StartScreen(WebDriver driver) {
        super(driver);
    }
}

package com.sloverset.qa.mobile.gui.android.components;

import com.sloverset.qa.mobile.gui.common.components.PopUpBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = PopUpBase.class)
public class PopUp extends PopUpBase {

    public PopUp(WebDriver driver) {
        super(driver);
    }
}

package com.sloverset.qa.mobile.gui.android.components;

import com.sloverset.qa.mobile.gui.common.components.FreedomStarsPopUpBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = FreedomStarsPopUpBase.class)
public class FreedomStarsPopUp extends FreedomStarsPopUpBase {

    public FreedomStarsPopUp(WebDriver driver) {
        super(driver);
    }
}

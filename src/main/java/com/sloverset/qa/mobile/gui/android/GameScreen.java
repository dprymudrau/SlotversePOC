package com.sloverset.qa.mobile.gui.android;

import com.sloverset.qa.mobile.gui.common.GameScreenBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = GameScreenBase.class)
public class GameScreen extends GameScreenBase {

    public GameScreen(WebDriver driver) {
        super(driver);
    }
}

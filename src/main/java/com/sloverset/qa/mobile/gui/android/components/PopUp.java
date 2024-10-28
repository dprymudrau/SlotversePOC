package com.sloverset.qa.mobile.gui.android.components;

import com.sloverset.qa.mobile.gui.common.components.PopUpBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = PopUpBase.class)
public class PopUp extends PopUpBase {

    @ExtendedFindBy(image = "elements/buttons/purple_close_a.png")
    private ExtendedWebElement purpleCloseBtn;

    public PopUp(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isAnyPopUpShow() {
        return purpleCloseBtn.isElementPresent(15);
    }

    @Override
    public void clickPurpleCloseBtn() {
        purpleCloseBtn.click();
    }
}

package com.sloverset.qa.mobile.gui.ios;

import com.sloverset.qa.mobile.gui.common.GameScreenBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = GameScreenBase.class)
public class GameScreen extends GameScreenBase {


    @FindBy(xpath = "elements/buttons/spin_btn.png")
    private ExtendedWebElement spinBtn;

    public GameScreen(WebDriver driver) {
        super(driver);
    }

    public boolean isGameScreenOpened() {
        return spinBtn.isElementPresent(5);
    }
}

package com.sloverset.qa.mobile.gui.common;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;

public class GameScreenBase extends BaseScreen {

    @ExtendedFindBy(image = "elements/buttons/spin_btn.png")
    private ExtendedWebElement spinButton;

    protected GameScreenBase(WebDriver driver) {
        super(driver);
    }

    public boolean isGameScreenOpened() {
        return spinButton.isElementPresent(5);
    }

    public void clickSpinBtn() {
        spinButton.click();
    }
}

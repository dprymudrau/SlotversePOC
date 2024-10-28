package com.sloverset.qa.mobile.gui.common.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;

public class FreedomStarsPopUpBase extends AbstractPage {

    @ExtendedFindBy(image = "elements/popup/freedom_stars_game_pop_up.png")
    private ExtendedWebElement freedomStarsGamePopUp;

    @ExtendedFindBy(image = "elements/buttons/bet_50_k.png")
    private ExtendedWebElement bet50kBtn;

    protected FreedomStarsPopUpBase(WebDriver driver) {
        super(driver);
    }

    public boolean isOpened() {
        return freedomStarsGamePopUp.isElementPresent(2);
    }

    public void clickBet50KButton() {
        bet50kBtn.click();
    }
}

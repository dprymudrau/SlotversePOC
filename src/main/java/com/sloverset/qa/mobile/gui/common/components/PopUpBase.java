package com.sloverset.qa.mobile.gui.common.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;

import java.util.stream.Stream;

public abstract class PopUpBase extends AbstractPage {

    @ExtendedFindBy(image = "elements/popup/first_time_deal_pop_up.png")
    private ExtendedWebElement offerImage;

    @ExtendedFindBy(image = "elements/popup/daily_treat_pop_up.png")
    private ExtendedWebElement dailyDealPopUp;

    @ExtendedFindBy(image = "elements/popup/coins_combo_pop_up.png")
    private ExtendedWebElement coinsComboPopUp;

    @ExtendedFindBy(image = "elements/buttons/purple_close_btn.png")
    private ExtendedWebElement purpleCloseBtn;

    @ExtendedFindBy(image = "elements/popup/freedom_stars_game_pop_up.png")
    private ExtendedWebElement freedomStarsGamePopUp;

    protected PopUpBase(WebDriver driver) {
        super(driver);
    }

    public boolean isAnyPopUpShow() {
        return purpleCloseBtn.isElementPresent(15);
    }

    public void clickPurpleCloseBtn() {
        purpleCloseBtn.click();
    }
}

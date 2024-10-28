package com.sloverset.qa.mobile.gui.common;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.listener.DriverListener;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.Setting;
import org.openqa.selenium.WebDriver;

public abstract class HomeScreenBase extends BaseScreen {

    @ExtendedFindBy(image = "elements/buttons/inbox_btn.png")
    private ExtendedWebElement inboxBtn;

    @ExtendedFindBy(image = "elements/gamecards/freedom_stars_card.png")
    private ExtendedWebElement freedomStarsGameCard;


    protected HomeScreenBase(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(inboxBtn);
    }

    public boolean isScreenOpened() {
        return inboxBtn.isElementPresent(5);
    }

    public void openFreedomStarsGame() {
        var screenSize = performIgnoreException(() -> getDriver().manage().window().getSize());
        var startX = screenSize.width - screenSize.width / 4;
        var y = screenSize.height / 2;
        var endX = screenSize.width / 3;
        getDriver().setSetting(Setting.IMAGE_MATCH_THRESHOLD, 0.4);
        for (int i = 0; i < 3; i++) {
            if (freedomStarsGameCard.isElementPresent(3)) {
                break;
            }
            swipe(startX, y, endX, y, 3000);
        }
        freedomStarsGameCard.click();
        getDriver().setSetting(Setting.IMAGE_MATCH_THRESHOLD, 0.3);
    }
}

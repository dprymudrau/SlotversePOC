package com.sloverset.qa;

import com.sloverset.qa.mobile.gui.common.GameScreenBase;
import com.sloverset.qa.mobile.gui.common.HomeScreenBase;
import com.sloverset.qa.mobile.gui.common.StartScreenBase;
import com.sloverset.qa.mobile.gui.common.components.FreedomStarsPopUpBase;
import com.sloverset.qa.mobile.gui.common.components.PopUpBase;
import com.zebrunner.carina.core.AbstractTest;
import com.zebrunner.carina.webdriver.listener.DriverListener;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.Setting;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class SlotVerseDemoTest extends AbstractTest {
    private final static Logger LOGGER = LogManager.getLogger(SlotVerseDemoTest.class);

    @Override
    public AppiumDriver getDriver() {
        return DriverListener.castDriver(super.getDriver(), AppiumDriver.class);
    }

    @Test(description = "Game access test using gui validations")
    public void testAccessToGame() {
        initImagePreferences();
        var startScreen = initPage(StartScreenBase.class);
        assertTrue(startScreen.isOpened(), "Start Screen is not opened");
        startScreen.clickLoginAsGuest();
        startScreen.waitForLoadingScreenToComplete();
        var popUp = initPage(PopUpBase.class);
        getDriver().setSetting(Setting.IMAGE_MATCH_THRESHOLD, 0.5);
        assertTrue(popUp.isAnyPopUpShow(), "Pop up is not shown");
        popUp.clickPurpleCloseBtn();
        getDriver().setSetting(Setting.IMAGE_MATCH_THRESHOLD, 0.3);
        var homeScreen = initPage(HomeScreenBase.class);
        assertTrue(homeScreen.isScreenOpened(), "Home screen is not opened");
        homeScreen.openFreedomStarsGame();
        var freedomStarsPopUp = initPage(FreedomStarsPopUpBase.class);
        assertTrue(freedomStarsPopUp.isOpened(), "Game pop up was not opened");
        freedomStarsPopUp.clickBet50KButton();
        var gameScreen = initPage(GameScreenBase.class);
        gameScreen.waitForLoadingScreenToComplete();
        assertTrue(gameScreen.isGameScreenOpened(), "Game screen was not opened");
    }


    private void initImagePreferences() {
        var driver = getDriver();
        driver.setSetting(Setting.IMAGE_MATCH_THRESHOLD, 0.3);
        driver.setSetting(Setting.FIX_IMAGE_TEMPLATE_SIZE, true);
        driver.setSetting(Setting.FIX_IMAGE_TEMPLATE_SCALE, true);
        driver.setSetting(Setting.FIX_IMAGE_FIND_SCREENSHOT_DIMENSIONS, true);
        driver.setSetting(Setting.CHECK_IMAGE_ELEMENT_STALENESS, false);
    }
}

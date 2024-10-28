package com.sloverset.qa.mobile.gui.common;

import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import com.zebrunner.carina.webdriver.listener.DriverListener;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BaseScreen extends AbstractPage implements IMobileUtils {

    @ExtendedFindBy(image = "elements/loading_screen.png")
    private ExtendedWebElement loadingScreenPart;


    protected BaseScreen(WebDriver driver) {
        super(driver);
    }

    public void waitForLoadingScreenToComplete() {
        waitUntil(ExpectedConditions.invisibilityOf(loadingScreenPart.getElement()), 20);
    }

    @Override
    public AppiumDriver getDriver() {
        return DriverListener.castDriver(super.getDriver(), AppiumDriver.class);
    }
}

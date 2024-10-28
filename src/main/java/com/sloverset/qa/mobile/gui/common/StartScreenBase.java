package com.sloverset.qa.mobile.gui.common;

import com.google.common.collect.ImmutableList;
import com.sloverset.qa.util.DriverHelper;
import com.sloverset.qa.util.ImageHelper;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import com.zebrunner.carina.webdriver.listener.DriverListener;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSTouchAction;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class StartScreenBase extends BaseScreen {

    private final By loginAsGuestBtnBy = AppiumBy
            .image(ImageHelper.getReferenceImageB64("elements/buttons/logins_as_guest_btn.png"));

    @ExtendedFindBy(image = "elements/buttons/logins_as_guest_btn.png")
    private ExtendedWebElement loginAsGuest;

    @ExtendedFindBy(image = "elements/buttons/sing_in_with_apple.png")
    private ExtendedWebElement signInWithAppleBtn;

    protected StartScreenBase(WebDriver driver) {
        super(driver);
    }

    public boolean isLoginAsGuestDisplayed() {
        return loginAsGuest.isElementPresent(1);
    }

    public boolean isSignInWhitAppleDisplayed() {
        return signInWithAppleBtn.isElementPresent(1);
    }

    public void clickLoginAsGuest() {
        loginAsGuest.click();
    }

    public boolean isOpened() {
        var by = AppiumBy.image(ImageHelper.getReferenceImageB64("start_screen.png"));
        return waitUntil(ExpectedConditions.presenceOfElementLocated(by), 60);
    }

    protected void tapAtPoint(Point point) {
        var d = DriverListener.castDriver(getDriver(), AppiumDriver.class);  // assuming here a getDriver method
        PointerInput input = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        Sequence tap = new Sequence(input, 0);
        tap.addAction(input.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), point.x, point.y));
        tap.addAction(input.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        tap.addAction(new Pause(input, Duration.ofMillis(1000)));
        tap.addAction(input.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        d.perform(ImmutableList.of(tap));
    }

    protected void tapElement(WebElement el) {
        Rectangle elRect = el.getRect();
        Point point = new Point(
                elRect.x + (int) (elRect.getWidth() / 2.0),
                elRect.y + (int) (elRect.getHeight() / 2.0)
        );
        tapAtPoint(point);
    }
}

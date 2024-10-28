package com.sloverset.qa.mobile.gui.common;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class GameScreenBase extends BaseScreen {

    @ExtendedFindBy(image = "elements/buttons/spin_btn.png")
    private ExtendedWebElement spinButton;

    @FindBy(xpath = "elements/buttons/start_btn.png")
    private ExtendedWebElement startBtn;

    @FindBy(xpath = "elements/buttons/home_btn.png")
    private ExtendedWebElement homeBtn;

    protected GameScreenBase(WebDriver driver) {
        super(driver);
    }

    public boolean isGameScreenOpened() {
        return spinButton.isElementPresent(5);
    }

    public void clickSpinBtn() {
        spinButton.click();
    }

    public void waitForSpinToFinish() {
        spinButton.isElementPresent(10);
    }

    public void clickStartBtn() {
        startBtn.click();
    }

    public void clickHomeBtn() {
        homeBtn.click();
    }
}

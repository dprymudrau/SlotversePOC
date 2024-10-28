package com.sloverset.qa.util;

import com.zebrunner.carina.webdriver.listener.DriverListener;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebDriver;

public class DriverHelper {
    public static AppiumDriver getAppiumDriver(WebDriver driver) {
        return DriverListener.castDriver(driver, AppiumDriver.class);
    }
}

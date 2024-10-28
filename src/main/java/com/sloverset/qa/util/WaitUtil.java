package com.sloverset.qa.util;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Optional;
import java.util.function.Function;

public class WaitUtil {
    private static final Function<Long, Long> WAIT_POLL_INTERVAL_MILLIS_RESOLVER =
            initialInterval -> initialInterval < 500 ? 500 : initialInterval;
    private static final Function<Duration, Duration> WAIT_POLL_INTERVAL_RESOLVER =
            initialInterval -> Duration.ofMillis(WAIT_POLL_INTERVAL_MILLIS_RESOLVER.apply(initialInterval.toMillis()));

    public static <V> Optional<V> waitUntil(WebDriver driver, Duration timeout, Duration interval, Function<WebDriver, V> isTrue) {
        V result;
        try {
            interval = WAIT_POLL_INTERVAL_RESOLVER.apply(interval);
            result = new WebDriverWait(driver, timeout)
                    .pollingEvery(interval)
                    .until(isTrue);
        } catch (TimeoutException e) {
            result = null;
        }
        return Optional.ofNullable(result);
    }

}

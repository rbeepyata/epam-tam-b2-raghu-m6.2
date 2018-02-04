package com.tam.singleton.webdriver;

import org.openqa.selenium.WebDriver;

import com.tam.factorymethod.drivers.BrowserType;
import com.tam.factorymethod.drivers.DriverFactory;

/**
 * Singleton
 * @author Raghunandan_Beepyata
 *
 */
public class Driver {

    private static WebDriver driver;

    private Driver() {}

    public static WebDriver getInstance() {
        if (null == driver) {
            driver = DriverFactory.getDriver(BrowserType.Chrome);
        }
        return driver;
    }
}

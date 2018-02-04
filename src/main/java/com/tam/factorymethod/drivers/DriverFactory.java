package com.tam.factorymethod.drivers;

import org.openqa.selenium.WebDriver;

public class DriverFactory {
	
	public static WebDriver getDriver(BrowserType browser){
		switch(browser){
		case Chrome:
			return new Chrome().initialize();
		case Firefox:
			return new Firefox().initialize();
		default:
			return new Chrome().initialize();
		}
	}
}

package com.tam.factorymethod.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Firefox extends AbstractDriver{

	@Override
	public WebDriver initialize() {
		System.setProperty("webdriver.gecko.driver", "lib//driver//geckodriver.exe");
		driver = new FirefoxDriver();
		return driver;
	}
}

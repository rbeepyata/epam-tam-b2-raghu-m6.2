package com.tam.factorymethod.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Chrome extends AbstractDriver{

	@Override
	public WebDriver initialize() {
		System.setProperty("webdriver.chrome.driver", "lib//driver//chromedriver.exe");
		driver = new ChromeDriver();
		return driver;
	}
	
}

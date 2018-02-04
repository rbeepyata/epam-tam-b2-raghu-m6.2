package com.ryanair.pages;

import org.openqa.selenium.WebDriver;

import com.tam.decorator.webelement.DecoratedElement;

public abstract class AbstractBasePage {
	
	protected static WebDriver driver;
	
	public static void initBasePage(WebDriver driver) {
		AbstractBasePage.driver = driver;
		DecoratedElement.setDriver(driver);
	}

}

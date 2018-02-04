package com.tam.factorymethod.drivers;

import org.openqa.selenium.WebDriver;

public abstract class AbstractDriver {
	
	protected WebDriver driver ;

	public abstract WebDriver initialize();
	
	
}

package com.tam.strategy;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptAction implements ActionStrategy{
	
	WebDriver driver;
	WebElement element;
	
	public JavaScriptAction(WebDriver driver, WebElement element) {
		this.driver = driver;
		this.element = element;
	}

	public void click() {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
		
	}


}

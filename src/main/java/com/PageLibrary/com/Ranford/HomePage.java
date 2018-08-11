package com.PageLibrary.com.Ranford;

import org.openqa.selenium.WebElement;

import testBase.BaseClass;

public class HomePage extends BaseClass {
	public static WebElement UserName_editbox()
	{
		return driver.findElement(getelement("username"));
		
	}
	public static WebElement Password_editbox()
	{
		return driver.findElement(getelement("password"));
		
	}
	
	public static WebElement Login_button()
	{
		return driver.findElement(getelement("login"));
		
	}

}

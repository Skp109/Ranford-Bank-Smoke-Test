package com.PageLibrary.com.Ranford;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class GenericLib {

	public static Select dropdownhandle(WebDriver driver,By prop)
	{
		Select sel=new Select(driver.findElement(prop));
		return sel;
	}
	public static Alert alertButton(WebDriver driver)
	{
		Alert alt=driver.switchTo().alert();
		return alt;
		
	}
}

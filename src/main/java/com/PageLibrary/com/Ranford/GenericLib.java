package com.PageLibrary.com.Ranford;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import testBase.BaseClass;

public class GenericLib extends BaseClass {

	public static Select dropdownhandle(By prop)
	{
		Select sel=new Select(driver.findElement(prop));
		return sel;
	}
	public static Alert alertButton()
	{
		Alert alt=driver.switchTo().alert();
		return alt;
		
	}
}

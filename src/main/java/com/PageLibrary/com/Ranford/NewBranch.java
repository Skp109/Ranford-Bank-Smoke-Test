package com.PageLibrary.com.Ranford;

import org.openqa.selenium.WebElement;

import testBase.BaseClass;

public class NewBranch extends BaseClass {

	public static WebElement Branch_Name()
	{
		return driver.findElement(getelement("newbranchname"));
	}
	
	public static WebElement Adress1()
	{
		return driver.findElement(getelement("newbranchadress1"));
	}
	
	public static WebElement Adress2()
	{
		return driver.findElement(getelement("newbranchadress2"));
	}
	
	public static WebElement Adress3()
	{
		return driver.findElement(getelement("newbranchadress3"));
	}
	
	public static WebElement Area_Name()
	{
		return driver.findElement(getelement("newbrancharea"));
	}
	
	public static WebElement Zip_Code()
	{
		return driver.findElement(getelement("newbranchzipcode"));
	}
	
	public static WebElement Country_Name() 
	{
		return driver.findElement(getelement("newbranchcountry"));
	}
	
	public static WebElement State_Name() 
	{
		return driver.findElement(getelement("newbranchstate"));
	}
	
	public static WebElement City_Name() 
	{
		return driver.findElement(getelement("newbranchcity"));
	}
	
	public static WebElement Submit_Button() 
	{
		return driver.findElement(getelement("newbranchsubmitbtn"));
	}
	
	public static WebElement Reset_Button() 
	{
		return driver.findElement(getelement("newbranchresetbtn"));
	}
	
	public static WebElement Cancel_Button()
	{
		return driver.findElement(getelement("newbranchcancelbtn"));
	}
}

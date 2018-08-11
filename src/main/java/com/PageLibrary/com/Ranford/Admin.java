package com.PageLibrary.com.Ranford;

import org.openqa.selenium.WebElement;

import testBase.BaseClass;

public class Admin extends BaseClass 
{
	
	public static WebElement Branches_Button()
	{
		return driver.findElement(getelement("branches"));	
	}
	
	public static WebElement Roles_Button()
	{
		return driver.findElement(getelement("roles"));	
	}
	
	public static WebElement User_Button()
	{
		return driver.findElement(getelement("users"));
	}
	
	public static WebElement Employee_Button()
	{
		return driver.findElement(getelement("employee"));	
	}
	
	public static WebElement Logout_Button()
	{
		return driver.findElement(getelement("logout"));	
	}
	
	public static WebElement Home_Button()
	{
		return driver.findElement(getelement("navigatehomepage"));	
	}
	

}

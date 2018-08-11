package com.PageLibrary.com.Ranford;

import org.openqa.selenium.WebElement;

import testBase.BaseClass;

public class NewRoles extends BaseClass
{

	public static WebElement roles_Name()
	{
		return driver.findElement(getelement("newrolesname"));
	}
	
	public static WebElement roles_Desc()
	{
		return driver.findElement(getelement("newrolesdesc"));
	}
	
	public static WebElement rloes_Type()
	{
		return driver.findElement(getelement("newrolestype"));
	}

	public static WebElement roles_SubmitBtn()
	{
		return driver.findElement(getelement("rolesSubmitButton"));
	}
	
	public static WebElement roles_CancelBtn()
	{
		return driver.findElement(getelement("rolesCancelButton"));
	}
	
	public static WebElement roles_ResetBtn()
	{
		return driver.findElement(getelement("rolesResetButton"));
	}
}


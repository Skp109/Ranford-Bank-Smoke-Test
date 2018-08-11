package com.PageLibrary.com.Ranford;

import org.openqa.selenium.WebElement;

import testBase.BaseClass;

public class Branches extends BaseClass {
	
	public static WebElement Search_Country()
	{
		return driver.findElement(getelement("branchessearchcountry"));	
	}
	
	 public static WebElement Search_State()
	 {
		return driver.findElement(getelement("branchessearchstate"));	 
	 }

	 public static WebElement Search_City()
	 {
		return driver.findElement(getelement("branchessearchcity")); 
	 }
	 
	 public static WebElement Search_Button()
	 {
		return driver.findElement(getelement("branchessearchsbtn"));
	 }
	 
	 public static WebElement Cancel_Button()
	 {
		 return driver.findElement(getelement("branchessearchclrbtn"));
	 }
	 
	 public static WebElement New_Branch()
	 {
		return driver.findElement(getelement("newbranch"));
		 
	 }

}

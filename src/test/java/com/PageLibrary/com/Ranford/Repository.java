package com.PageLibrary.com.Ranford;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.support.ui.Select;

import testBase.BaseClass;
import webTable.Table;



public class Repository extends BaseClass {
	
	public void launch()
	{
		System.setProperty(getconfig("geckodrivername"),getconfig("geckodriverpath"));
		driver=new FirefoxDriver();
		driver.get(getconfig("build1"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	
	public void login()
	{
		HomePage.UserName_editbox().sendKeys(getconfig("username"));;
		HomePage.Password_editbox().sendKeys(getconfig("password"));
		HomePage.Login_button().click();
	}
	
	
	public void roles()
	{
		Admin.Roles_Button().click();
	}
	
	
	public void newBranchOperation()
	{
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		NewBranch.Branch_Name().sendKeys(getconfig("newBranchName"));
		NewBranch.Adress1().sendKeys(getconfig("newBranchAd1"));
		NewBranch.Adress2().sendKeys(getconfig("newBranchAd2"));
		NewBranch.Adress3().sendKeys(getconfig("newBranchAd3"));
		NewBranch.Zip_Code().sendKeys(getconfig("newBrancZip"));
		NewBranch.Area_Name().sendKeys(getconfig("newBranchArea"));
		GenericLib.dropdownhandle(driver, getelement("newbranchcountry")).selectByVisibleText(getconfig("newBranchCountry"));
		GenericLib.dropdownhandle(driver, getelement("newbranchstate")).selectByVisibleText(getconfig("newBranchState"));
		GenericLib.dropdownhandle(driver, getelement("newbranchcity")).selectByVisibleText(getconfig("newBranchCity"));
		NewBranch.Submit_Button().click();
		GenericLib.alertButton(driver).accept();
		
	}
	
	public void branches()
	{
		Admin.Branches_Button().click();
	}
	
	public void clickNewBranch()
	{
		Branches.New_Branch().click();
	}
	
	public void branchSearch()
	{
		GenericLib.dropdownhandle(driver, getelement("branchessearchcountry")).selectByVisibleText(getconfig("branchSearchCountry"));
		GenericLib.dropdownhandle(driver, getelement("branchessearchstate")).selectByVisibleText(getconfig("branchSearchState"));
		GenericLib.dropdownhandle(driver, getelement("branchessearchcity")).selectByVisibleText(getconfig("branchSearchCity"));
		Branches.Search_Button().click();
		

	}
	
	public void branchHandle()
	{
		Table.tablehandle(driver ,By.id("DG_bankdetails"),"delete","190");
	}
	
	
	public void rolesHandle()
	{
		Table.tablehandle(driver, By.id("DGRoles"), "edit", "107");
	}
	
	public void clickNewRoles()
	{
		Roles.new_RolesBtn().click();
	}
	
	public void newRoles_Operations()
	{
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		NewRoles.roles_Name().sendKeys(getconfig("newRolesName"));
		NewRoles.roles_Desc().sendKeys(getconfig("newRolesDesc"));
		GenericLib.dropdownhandle(driver, getelement("newrolestype")).selectByVisibleText(getconfig("newRolesType"));
		NewRoles.roles_SubmitBtn().click();
	}
}



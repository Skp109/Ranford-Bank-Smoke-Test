package com.PageLibrary.com.Ranford;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
//import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import excel.Excel;
import testBase.BaseClass;
import utility.Library;
import utility.Validation;
import webTable.Table;



public class Repository extends BaseClass {
	public static ExtentReports extent;
	public static ExtentTest test;
	@BeforeSuite
	public static void extentset()
	{
		extent=new ExtentReports(".\\extentreport\\report.html",true);
	}
	@BeforeMethod
	public void beforemethod(Method method)
	{
		test=extent.startTest((this.getClass().getSimpleName()+"::"+method.getName()));
		test.assignAuthor("Author: Sankshipta");
		test.assignCategory("Category: Regression");
	}
	
	
	public void launch()
	{
		switch(getconfig("browsername"))
		{
		case "firefox":
			System.setProperty(getconfig("geckodrivername"),getconfig("geckodriverpath"));
		driver=new FirefoxDriver();
		break;
		
		case "chrome":
			System.setProperty(getconfig("chromedrivername"), getconfig("chromedriverpath"));
			driver=new ChromeDriver();
			break;
			}
		
		
		driver.get(getconfig("build1"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String actualurl=driver.getCurrentUrl();
		String exp=getconfig("build1");
		if(Validation.isTextPresent(driver, ""))
		{
			Reporter.log("Launched browser is passed");
			test.log(LogStatus.PASS,"actual url is: "+actualurl+" :is matching with exp"+exp);
			test.log(LogStatus.INFO, "Browser launch successfully");
		}
		else
		{
			Reporter.log("launched test is fail");
			test.log(LogStatus.FAIL, "actual url is "+actualurl+" : is not matching with "+exp+","+Library.takeScreenshot("launch"));
		}
	}
	
	
	public void login()
	{
		HomePage.UserName_editbox().sendKeys(getconfig("username"));;
		HomePage.Password_editbox().sendKeys(getconfig("password"));
		HomePage.Login_button().click();
		String text=driver.findElement(By.tagName("tbody")).getText();
		String exp="Welcome to Admin";
		if(text.contains(exp))
		{
			Reporter.log("Login test is passed");
			test.log(LogStatus.PASS, "actual test is: "+text+"is matching with exp"+exp);
			test.log(LogStatus.INFO, "Login is successful.");
		}
		else
		{
			Reporter.log("Login test is failed");
			test.log(LogStatus.FAIL, "actual result is: "+text+"is not matching with exp"+exp, Library.takeScreenshot("login"));
			test.log(LogStatus.INFO, "Login is successful.");
		}
	}
	
	
	
	
	
	public void newBranchOperation(String bname, String adress, String zipcode, String country, String state, String city )
	{
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		NewBranch.Branch_Name().sendKeys(bname);
		NewBranch.Adress1().sendKeys(adress);
		//NewBranch.Adress2().sendKeys(getconfig());
		//NewBranch.Adress3().sendKeys(getconfig());
		NewBranch.Zip_Code().sendKeys(zipcode);
		//NewBranch.Area_Name().sendKeys(getconfig());
		GenericLib.dropdownhandle(getelement("newbranchcountry")).selectByVisibleText(country);
		GenericLib.dropdownhandle(getelement("newbranchstate")).selectByVisibleText(state);
		GenericLib.dropdownhandle(getelement("newbranchcity")).selectByVisibleText(city);
		NewBranch.Submit_Button().click();
		GenericLib.alertButton().accept();
	}
	
	
	
	public void branches()
	{
		boolean b=driver.findElement(getelement("branches")).isDisplayed();
		if(b) {
			Admin.Branches_Button().click();
			Reporter.log("Branch click is passed");
			test.log(LogStatus.PASS, "Branch is displayed");
			test.log(LogStatus.INFO, "Branch is successfully clicked");
		}
		else
		{
			Reporter.log("Branch clicked is unsucessful");
			test.log(LogStatus.FAIL, "Branch click is failed", Library.takeScreenshot("branches"));
			test.log(LogStatus.INFO, "Branch click is unsuccessful");
		}
		
	}
	
	public void clickNewBranch()
	{
		Boolean b1=driver.findElement(getelement("newbranch")).isDisplayed();
		if(b1) {
		Branches.New_Branch().click();
		Reporter.log("New Branch click is passed");
		test.log(LogStatus.PASS, "New Branch is displayed");
		test.log(LogStatus.INFO, "New Branch is successfully clicked");
		}
		else
		{
			Reporter.log("New Branch clicking is failed");
			test.log(LogStatus.FAIL, "New Branch clicking is failed", Library.takeScreenshot("newbranch"));
			test.log(LogStatus.INFO,"New Branch is not clicked" );
		}
		
	}
	
	public void branchSearch()
	{
		GenericLib.dropdownhandle(getelement("branchessearchcountry")).selectByVisibleText(getconfig("branchSearchCountry"));
		GenericLib.dropdownhandle(getelement("branchessearchstate")).selectByVisibleText(getconfig("branchSearchState"));
		GenericLib.dropdownhandle(getelement("branchessearchcity")).selectByVisibleText(getconfig("branchSearchCity"));
		Branches.Search_Button().click();
		

	}
	
	public void branchHandle()
	{
		Table.tablehandle(driver ,By.id("DG_bankdetails"),"delete","190");
	}
	
	
	public void roles()
	{
		Boolean b2=driver.findElement(getelement("roles")).isDisplayed();
		if (b2)
		{
			Admin.Roles_Button().click();
			Reporter.log("Roles click is passed");
			test.log(LogStatus.PASS, "Roles is displayed");
			test.log(LogStatus.INFO, "Roles is successfully clicked");
		}
		else 
		{
			Reporter.log("Roles clicking is failed");
			test.log(LogStatus.FAIL, "Roles click is failed", Library.takeScreenshot("roles"));
			test.log(LogStatus.INFO, "Roles is not clicked");
		}
		
	}
	
	
	public void rolesHandle()
	{
		
		Table.tablehandle(driver, By.id("DGRoles"), "edit", "107");
	}
	
	public void clickNewRoles()
	{
		Boolean b3=driver.findElement(getelement("newrolesbutton")).isDisplayed();
		Roles.new_RolesBtn().click();
	}
	
	public void newRoles_Operations(String rolename,String roledesc,String roletype)
	{
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		NewRoles.roles_Name().sendKeys(rolename);
		NewRoles.roles_Desc().sendKeys(roledesc);
		GenericLib.dropdownhandle( getelement("newrolestype")).selectByVisibleText(roletype);
		NewRoles.roles_SubmitBtn().click();
		GenericLib.alertButton().accept();
	}
	@AfterSuite
	public void aftersuite()
	{
		extent.flush();
	}
	public Object[][] excelcontent(String filename,String sheet)
	{
		Excel.excelconnection(filename, sheet);
		int rc=Excel.rcount();
		int cc=Excel.ccount();
		String[][] data=new String[rc-1][cc];
		for(int r=1;r<rc;r++)
		{
			for(int c=0;c<cc;c++)
			{                       
				data[r-1][c]=Excel.readdata(c, r);
				
				
			}
		}
		return data;
		
	}
}



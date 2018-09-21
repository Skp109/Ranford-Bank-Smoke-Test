package com.PageLibrary.com.Ranford;

import org.testng.annotations.DataProvider;
//import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import excel.Excel;

public class TestExecution extends Repository {
	
	@Test(priority=0)
	public void launch_Browser()
	{
		launch();
	}
	@Test(priority=1)
	public void verify_login()
	{
		login();
	}
	
	@Test(priority=2)
	public void click_Branches()
	{
		branches();
	}
	
	
	
	
	
	@Test(priority=3)
	public void click_NewBranch()
	{
		clickNewBranch();
	}
	
	@Test(priority=4,dataProvider="branches")
public void newBranch_Operations(String bname,String adress,String zipcode,String country,String state,String city)
{
	newBranchOperation(bname,adress,zipcode,country,state,city); 
	}
	/**
	@Test(priority=4)
	public void branchSrarch_Operations()
	{
		branchSearch();
	}
	@Test(priority=2)
	public void branchHandle_Operations()
	{
		branchHandle();
	}**/
	
	
	/**@Test(priority=2)
	public void click_Roles()
	{
		roles();
	}
	
	@Test(priority=3)
	public void click_newRoles()
	{
		clickNewRoles();
	}
	@Test(priority=4,dataProvider="roles")
	public void newRoles_Operation(String rolename,String roledesc,String roletype)
	{
		newRoles_Operations(rolename, roledesc, roletype);
	}
	
	@DataProvider(name="roles")
	public Object[][] verify_excel()
	{
		return excelcontent("data.xls","Sheet2");
		
	}

}**/

@DataProvider(name="branches")
public Object[][] verify_excel3()
{
	return excelcontent("data.xls","Sheet1");
}

/*@Test(priority=5)
public void validate_excel()
{
	Excel.excelconnection("data.xls", "sheet1");
	Excel.outputExcelConnection("data.xls","sheet1", "output.xls");
	int c=Excel.ccount();
	for(int r=1;r<Excel.rcount();r++)
	{
		newBranchOperation(Excel.readdata(0, r),Excel.readdata(1, r),Excel.readdata(2, r),Excel.readdata(3, r),Excel.readdata(4, r),Excel.readdata(5, r));
		String actual=GenericLib.alertButton().getText();
		if(actual.contains("created successfully"))
		{
			Excel.writedata(c++, r, actual);
			c--;
		}
		else if(actual.contains("already exist"))
		{
			Excel.writedata(c++, r, "Test Failed");
			c--;
		}
		else
		{
			Excel.writedata(c++, r, "n/a");
			c--;
		}
	}
	Excel.saveworkbook();
}
*/





}
package com.PageLibrary.com.Ranford;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestExecution extends Repository {
	@BeforeTest
	public void launch_Browser()
	{
		launch();
	}
	@Test(priority=0)
	public void verify_login()
	{
		login();
	}
	
	/**@Test(priority=2)
	
	
	@Test(priority=1)
	public void click_Branches()
	{
		branches();
	}**/
	
	/**@Test(priority=2)
	public void click_NewBranch()
	{
		clickNewBranch();
	}
	
	@Test(priority=3)
	public void newBranch_Operations()
	{
		newBranchOperation();
	}
	
	@Test(priority=4)
	public void branchSrarch_Operations()
	{
		branchSearch();
	}
	@Test(priority=2)
	public void branchHandle_Operations()
	{
		branchHandle();
	}
	
	@Test(priority=3)
	public void click_roles()
	{
		clickRoles();
	}**/
	@Test(priority=1)
	public void click_Roles()
	{
		roles();
	}
	
	@Test(priority=2)
	public void click_newRoles()
	{
		clickNewRoles();
	}
	@Test(priority=3)
	public void newRoles_Operation()
	{
		newRoles_Operations();
	}

}

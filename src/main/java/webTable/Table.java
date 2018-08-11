package webTable;

//import java.awt.List;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import testBase.BaseClass;

public class Table extends BaseClass{
	static boolean status=false;
	
	public static void tablehandle(WebDriver driver,By prop,String operation,String id)
	{
		try {
			boolean flag=false;
			
			WebElement table=driver.findElement(prop);
			List<WebElement> rows= table.findElements(By.tagName("tr"));
			String[] pagelink=rows.get(rows.size()-1).getText().split(" ");
			for(int i=1;i<pagelink.length;i++)
			{
				
				try {
					if(pagelink[i].contains("...") && status==true)
					{
						driver.findElement(getelement("branchstablelinkXpath")).click();
					}
					else
					{
						table.findElement(By.linkText(pagelink[i])).click();
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(pagelink[i].contains("..."))
				{
					status=true;
					tablehandle(driver,prop, operation, id);
				}
				table=driver.findElement(prop);
				rows=table.findElements(By.tagName("tr"));
				for(WebElement r:rows)
				{
				List<WebElement> columns=r.findElements(By.tagName("td"));
				for(WebElement c:columns)
				{
					String text=c.getText();
					System.out.println(text);
					if(text.matches(id))
					{
						if(operation.equalsIgnoreCase("edit"))
						{
							columns.get(columns.size()-2).findElement(By.tagName("a")).click();
						}
						else if(operation.equalsIgnoreCase("delete"))
						{
							columns.get(columns.size()-1).findElement(By.tagName("a")).click();
							driver.switchTo().alert().accept();
							if(driver.switchTo().alert().getText().contains("its a shared record can not be deleted"))
							{
								Reporter.log("its a shared record can not be deleted");
								driver.switchTo().alert().accept();
							}
							else
							{
								Reporter.log("Deleted Successfully");
									driver.switchTo().alert().accept();
							}
						}
						else
						{
							System.out.println("Operation is failed");
						}
						 flag = true;
						break;
					}
				}
				if(flag==true)
				{
					break;
				}
			}
				if(flag==true)
				{
					break;
				}
}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	}

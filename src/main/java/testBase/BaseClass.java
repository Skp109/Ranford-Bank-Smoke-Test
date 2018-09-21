package testBase;

import java.io.File;
//import java.io.FileNotFoundException;
import java.io.FileReader;
//import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BaseClass {
	
	public static WebDriver driver;
	static Properties p;
	public static void loadProperty() {
		try {
			File f=new File(System.getProperty("user.dir")+"\\src\\main\\java\\configuration\\config.properties");
			FileReader fr=new FileReader(f);
			p=new Properties();
			p.load(fr);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	}
	
	public static String getconfig(String key)
	{
		loadProperty();
		String x=p.getProperty(key);
		return x;
	}
	
	public static void loadproperty1()
	{
		try {
			File f=new File(System.getProperty("user.dir")+"//src//main//java//configuration//objectRepository.properties");
			FileReader fr=new FileReader(f);
			p=new Properties();
			p.load(fr);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
		public static By getelement(String key)
		{
			By loc=null;
			loadproperty1();
			String value=p.getProperty(key);
			String loctype=value.split(":")[0];
			String locvalue=value.split(":")[1];
			
			switch(loctype)
			{
			case "id":
				loc=By.id(locvalue);
				break;
				
			case "name":
			loc=By.name(locvalue);
			break;
			
			case "classname":
				loc=By.className(locvalue);
				break;
				
			case "xpath":
				loc=By.xpath(locvalue);
				break;
				
			case "css":
			loc=By.cssSelector(locvalue);
			break;
				
			}
			return loc;	
		}
		
	}


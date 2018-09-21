package excel;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
//import jxl.read.biff.File;
import testBase.BaseClass;

public class Excel extends BaseClass{
	public static String folderpath=getconfig("folderpath");
	static Sheet sh;
	static Workbook wb;
	static WritableWorkbook wwb;
	static WritableSheet wsh;
	public static void excelconnection(String filename,String sheet)
	{
		try
		{
			File f=new File(folderpath+filename);
			wb=Workbook.getWorkbook(f);
			sh=wb.getSheet(sheet);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

		public static int rcount()
		{
			int i=sh.getRows();
			return i;
		}
	public static int ccount()
				{
					int i=sh.getColumns();
					return i;
				}
				public static String readdata(int col,int row)
				{
					String x=sh.getCell(col, row).getContents();
					return x;
					
				}
				
				public static void outputExcelConnection(String ifilename,String sheet,String ofilename)
				{
					try
					{
						FileInputStream fis=new FileInputStream(folderpath+ifilename);
						wb=Workbook.getWorkbook(fis);
						sh=wb.getSheet(sheet);
						FileOutputStream fos=new FileOutputStream(folderpath+ofilename);
						wwb=Workbook.createWorkbook(fos,wb);
						wsh=wwb.getSheet(sheet);
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
					
				}
				public static void writedata(int col,int row,String data)
				{
					try
					{
						Label l=new Label(col,row,data);
						wsh.addCell(l);
						
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
				public static void saveworkbook()
				{
					try {
						wwb.write();
						wwb.close();
						wb.close();
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
				
}























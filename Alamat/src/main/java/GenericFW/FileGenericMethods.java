package GenericFW;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileGenericMethods {
	
	public String getProValue(String propath,String key) throws Throwable {
		
		FileInputStream fis=new FileInputStream(propath);
		Properties pro=new Properties();
		pro.load(fis);
		
		return pro.getProperty(key, "invalid entry");
	}

	public String getCellData(String excellpath,String sheet,int r,int c) throws Throwable {
		
		FileInputStream fis=new FileInputStream(excellpath);
		Workbook wb=WorkbookFactory.create(fis);
		String excelldata = wb.getSheet(sheet).getRow(r).getCell(c).toString();
		return excelldata;
	}
	
	public int getRowCount(String excellpath,String sheet) throws Throwable {
		FileInputStream fis=new FileInputStream(excellpath);
		Workbook wb=WorkbookFactory.create(fis);
		int rowcount = wb.getSheet(sheet).getLastRowNum();
		return rowcount;
		
	}
	
	
	public void setCellData(String excellpath,String sheet,int r,int c,String data) throws Throwable {
		
		FileInputStream fis=new FileInputStream(excellpath);
		Workbook wb=WorkbookFactory.create(fis);
		wb.getSheet(sheet).getRow(r).createCell(c).setCellValue(data);
		
		FileOutputStream fos=new FileOutputStream(excellpath);
		wb.write(fos);
		wb.close();
		
	}
}

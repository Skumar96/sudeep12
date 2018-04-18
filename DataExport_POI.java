package abcpack;

import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class DataExport_POI {
	@Test
	public void dataExport() throws Exception
	{
		FileOutputStream fos=new FileOutputStream("E:\\Selenium_Scripts_Nov17\\Results\\DataExportPOI.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook();
		XSSFSheet s1=wb.createSheet("Results1");
		XSSFSheet s2=wb.createSheet("Results2");
		Row r=s1.createRow(0);
		r.createCell(0).setCellValue("Selenium");
		Row r1=s1.createRow(1);
		r1.createCell(0).setCellValue("Appium");
		wb.write(fos);
		fos.close();
	}

}

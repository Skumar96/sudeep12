package abcpack;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.testng.annotations.Test;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class DataExport_JXL {
	@Test
	public void dataExport() throws Exception
	{
		FileOutputStream fos=new FileOutputStream("E:\\Selenium_Scripts_Nov17\\Results\\DataExport.xls");
		WritableWorkbook wwb=Workbook.createWorkbook(fos);
		WritableSheet ws1=wwb.createSheet("Result1",0);
		WritableSheet ws2=wwb.createSheet("Result2",1);
		Label l1=new Label(0,0,"Selenium");
		Label l2=new Label(0,1,"Appium");
		ws1.addCell(l1);
		ws1.addCell(l2);
		wwb.write();
		wwb.close();
	}

}

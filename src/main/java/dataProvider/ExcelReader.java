package dataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	static XSSFWorkbook wb;
	
	public static Object[][] getdatafromsheet(String sheetname)
	{
		System.out.println("*****loading data from excel*****");
		Object[][] arr= null;
		try {
			wb = new XSSFWorkbook(new FileInputStream(new File(".\\test_data\\login.xlsx")));
			XSSFSheet sheet = wb.getSheet(sheetname);
			int row = sheet.getPhysicalNumberOfRows();
		    XSSFRow r = sheet.getRow(0);
		    int coloumn = r.getPhysicalNumberOfCells();
			arr= new Object[row-1][coloumn];
			for(int i=1;i<row;i++)
			{
				for(int j=0;j<coloumn;j++)
				{
					System.out.println(getdata(sheetname,i,j));
					arr[i-1][j]= getdata(sheetname,i,j);
				}
			}
			
    
	
		} catch (FileNotFoundException e) {
			System.out.println("couldnt find file"+e.getMessage());
		} catch (IOException e) {
			System.out.println("couldnot load the file"+e.getMessage());
		}
		return arr;
		
	}
	public static String getdata(String sheetname, int row,int coloumn)
	{
		XSSFCell cell =  wb.getSheet(sheetname).getRow(row).getCell(coloumn);
		String data= null;
		if(cell.getCellType()==CellType.STRING)
		{
			data = cell.getStringCellValue();
		}
		else if(cell.getCellType()==CellType.NUMERIC)
		{
			double d = cell.getNumericCellValue();
			data= String.valueOf(d);
			
		}
		else if(cell.getCellType()==CellType.BLANK)
		{
			data="";
		}
		return data;
	}

}

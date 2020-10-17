package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;

public class POIExcelDataReadUtility {
	/*
	 * First import poi-ooxml APIs v3.10 Final in POM.xml
	 * These are utilities files used to read data from Excel.
	 */	
	
	static XSSFSheet sheet;
	public static ArrayList<String> getdata(String testCaseName) throws IOException {
		
		ArrayList<String> a = new ArrayList<String>();
		FileInputStream fis= new FileInputStream("resources\\TestDataExcel.xlsx");
		
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		int sheets=workbook.getNumberOfSheets();
		
		for(int i=0; i<sheets; i++) 	//Iterate through each Sheets
		{
			if(workbook.getSheetName(i).equalsIgnoreCase("TestData"))
			{	
				sheet = workbook.getSheetAt(i);		//grab "TestData" sheet.
				Iterator<Row> rows = sheet.iterator();	//Iterate through each row
				Row firstrow = rows.next(); // Set to very first row.
				Iterator<Cell> ce =	firstrow.cellIterator(); //Iterate thorugh all cells of first row
				
				int k=0;
				int column = 0;
				while(ce.hasNext()) //looping till the time cell is present
				{
					Cell value = ce.next();	//In 1st loop we are in first cell of 1st row
											//In 2nd loop (if any), we move to 2nd cell of 1st row.
					if(value.getStringCellValue().equalsIgnoreCase("TestCases")) 
					{
						//grab desired column
						column=k;
					}
					k++;
				}
				//System.out.println(column);
				
				while(rows.hasNext()) {
					Row r = rows.next();	//Reading 1st row data of the column
					if(r.getCell(column).getStringCellValue().equalsIgnoreCase(testCaseName)) 
					{
						//after getting "TC3" test case row, we will grab all the cell content of that row.
						Iterator<Cell> cv =r.cellIterator();
						while(cv.hasNext()) 
						{
							//System.out.println(cv.next().getStringCellValue());
							//a.add(cv.next().getStringCellValue());
							
							//As ArrayList cant store numeric value so we need to convert it to String.
							Cell c = cv.next();
							if(c.getCellType() == XSSFCell.CELL_TYPE_STRING) {
								a.add(c.getStringCellValue());
							}
							else
							{
								a.add(NumberToTextConverter.toText(c.getNumericCellValue()));
							}
							
						}
					}
				}
			}
		}
		return a;
		
	}

}

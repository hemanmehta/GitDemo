package testcases;

import java.io.IOException;
import java.util.ArrayList;

import utilities.POIExcelDataReadUtility;

public class ExcelPOITest {

	public static void main(String[] args) throws IOException {
		POIExcelDataReadUtility ed = new POIExcelDataReadUtility();
		ArrayList data = ed.getdata("TC2");		
		
		System.out.println(data.get(0));
		System.out.println(data.get(1));
		System.out.println(data.get(2));

	}

}

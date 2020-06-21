package Exceldata;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {
//	To get the user data(city name) from the excel sheet
	public static String[] Cityname() throws IOException {
	
	String FilePath = ".//src//test//resources//hackathon user data.xlsx";
	FileInputStream fs = new FileInputStream(FilePath);
	XSSFWorkbook workbook=new XSSFWorkbook(fs);
	XSSFSheet sh = workbook.getSheetAt(0);
	int totalNoOfRows = sh.getLastRowNum();

	String[] city=new String[totalNoOfRows];
	String[] Emailid=new String[totalNoOfRows];
	int j=1;
	for(int i=0;i<totalNoOfRows;i++) {
	city[i]=String.valueOf(sh.getRow(j).getCell(0));
	j++;
	}
	
	return city;
	}

//	To get the user data(Email id) from the excel sheet
public static String[] EmailId() throws IOException {
	
	String FilePath = ".//src//test//resources//hackathon user data.xlsx";
	FileInputStream fs = new FileInputStream(FilePath);
	XSSFWorkbook workbook=new XSSFWorkbook(fs);
	XSSFSheet sh = workbook.getSheetAt(0);
	int totalNoOfRows = sh.getLastRowNum();
	
	String[] city=new String[totalNoOfRows];
	String[] Emailid=new String[totalNoOfRows];
	int j=1;
	for(int i=0;i<totalNoOfRows;i++) {
	Emailid[i]=String.valueOf(sh.getRow(j).getCell(1));
	j++;
	}
	
	return Emailid;
	}

}


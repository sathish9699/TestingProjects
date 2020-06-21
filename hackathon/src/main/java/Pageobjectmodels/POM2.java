package Pageobjectmodels;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class POM2 extends POM1 {
Properties prop = new Properties();
//To load the properties file and to click the filters button
public void filteringSearchSports() throws InterruptedException, FileNotFoundException {
	FileInputStream file = new FileInputStream(".\\src\\test\\resources\\objectRepository\\test.properties");
	try {
		prop.load(file);
	} catch (IOException e){
		e.printStackTrace();
	}
		JavascriptExecutor javascript = (JavascriptExecutor) driver;
		javascript.executeScript("arguments[0].click();", driver.findElement(By.xpath(prop.getProperty("weekendXpath"))));
		javascript.executeScript("arguments[0].click();",driver.findElement(By.xpath(prop.getProperty("pricedrpdwnXpath"))));
		javascript.executeScript("arguments[0].click();",driver.findElement(By.xpath(prop.getProperty("priceXpath"))));
	}
//To get the sports events details with their respective date
	public String[] eventsDetails() throws IOException {
		List<WebElement> elements = driver.findElements(By.xpath(prop.getProperty("totaleleXpath")));
		int j = elements.size();
		String name[]=new String[j];
		for (int i = 1; i <= j; i++) {
			name[i-1]= driver.findElement(By.xpath(prop.getProperty("eventnameXpath1") + i + prop.getProperty("eventnameXpath2"))).getText()
			+ "-"+ driver.findElement(By.xpath(prop.getProperty("dateXpath1") + i + prop.getProperty("dateXpath2"))).getText()
			+ " " + driver.findElement(By.xpath(prop.getProperty("monthXpath1") + i + prop.getProperty("monthXpath2"))).getText();
			}
		return name;
	}
//To get the output(sports events details with date) in the excel sheet
	public void outputdatasports() throws IOException { 
	List<WebElement> elements =driver.findElements(By.xpath(prop.getProperty("totaleleXpath"))); 
	int k=0;
	int n=0; 
	int j = elements.size(); 
	String city1[]=new String[j];
	  city1=eventsDetails();
	
	  XSSFWorkbook workbook=new XSSFWorkbook(); 
	  XSSFSheet sh= workbook.createSheet("Sports details"); 
	  for(int h=0;h<j;h++) {
	  sh.createRow(k).createCell(n).setCellValue(city1[h]);
	  k++;
	  } 
	  FileOutputStream fout=new FileOutputStream(new File(".//src//test//resources//outputexcel//sportsevents3.xlsx")); 
	  workbook.write(fout); 
	 
	  }
	 

}

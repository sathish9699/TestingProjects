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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class POM3 extends POM1  {
	Properties prop = new Properties();
//To click the movies button from home page	
	public void Eventsclick2() throws FileNotFoundException {
		FileInputStream file = new FileInputStream(".\\src\\test\\resources\\objectRepository\\test.properties");
		try {
			prop.load(file);
		} catch (IOException e){
			e.printStackTrace();
		}
		driver.findElement(By.linkText(prop.getProperty("eventName2"))).click();	
	}
//To apply the coming soon filter for movies
	public void filterclickMovies() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable((driver.findElement(By.xpath(prop.getProperty("MoviesfilterXpath"))))));
		driver.findElement(By.xpath(prop.getProperty("MoviesfilterXpath"))).click();
	}
//To get the output(different movie languages) in the excel sheet 
	public void MovieLanguages() throws IOException {
		XSSFWorkbook workbook=new XSSFWorkbook(); 
		XSSFSheet sh= workbook.createSheet("Movie languages2");
		int k=0;
		int n=0;
		List<WebElement> elements1 = driver.findElements(By.xpath("//*[@id='cs-lang']/div[2]/ul/li"));
		for (WebElement list : elements1) {
			for(int h=0;h<1;h++) {
				  sh.createRow(k).createCell(n).setCellValue(list.getText());
				  k++;
				  } 
			FileOutputStream fout=new FileOutputStream(new File(".//src//test//resources//outputexcel//movielanguages1.xlsx")); 
			workbook.write(fout); 
			}
		workbook.close();
		}
}

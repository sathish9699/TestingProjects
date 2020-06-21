package Pageobjectmodels;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Exceldata.Excel;

public class POM5 extends POM1 {
	Properties prop = new Properties();
	Excel excel=new Excel();
	public static String[] getemailData() throws Exception {        
	    
		  return Excel.EmailId();
		}

	/*
	 * To type the inappropriate email id driven from the excel sheet
	 * To clickthe next button
	 */
	public void SigninDetails()throws Exception {
		FileInputStream file = new FileInputStream(".\\src\\test\\resources\\objectRepository\\test.properties");
		try {
			prop.load(file);
		} catch (IOException e){
			e.printStackTrace();
		}
		String emailid[]=new String[1];
		emailid=getemailData();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf((driver.findElement(By.xpath(prop.getProperty("emailtextboxXpath"))))));
		driver.findElement(By.xpath(prop.getProperty("emailtextboxXpath"))).sendKeys(emailid[0]);
		wait.until(ExpectedConditions.elementToBeClickable((driver.findElement(By.xpath(prop.getProperty("Signinbtn2Xpath"))))));
		driver.findElement(By.xpath(prop.getProperty("Signinbtn2Xpath"))).click();
	}
	//To get the output(error message received when inappropriate email id is given) in the excel sheet	
	public void SigninErrormsg() throws IOException {
		XSSFWorkbook workbook=new XSSFWorkbook(); 
		XSSFSheet sh= workbook.createSheet("Sign in Error msg1");
		String errormsg=driver.findElement(By.xpath(prop.getProperty("ErrormsgXpath"))).getText().toString();
		sh.createRow(0).createCell(0).setCellValue(errormsg);
		FileOutputStream fout=new FileOutputStream(new File(".//src//test//resources//outputexcel//Sign in1.xlsx")); 
		workbook.write(fout); 
		workbook.close();
		
	}
	//To press escape button from keyboard
	public void clickEscape() {
		Actions actions = new Actions(driver);
		Action sendEsc = actions.sendKeys(Keys.ESCAPE).build();
		sendEsc.perform();
	}
	//To navigate to the home page
	public void navigatehomepage() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@id=\"navbar\"]/div[2]/div/div[1]/div/a"))));
		driver.findElement(By.xpath("//*[@id=\"navbar\"]/div[2]/div/div[1]/div/a")).click();
	}

}

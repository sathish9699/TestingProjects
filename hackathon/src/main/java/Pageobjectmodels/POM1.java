package Pageobjectmodels;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Browser.browserlaunch;
import Exceldata.Excel;

public class POM1 extends browserlaunch  {
	Excel excel=new Excel();
	Properties prop = new Properties();
	browserlaunch browser= new browserlaunch();
	public void navigateURL() throws FileNotFoundException, MalformedURLException {
		FileInputStream file = new FileInputStream(".\\src\\test\\resources\\objectRepository\\test.properties");
		try {
			prop.load(file);
		} catch (IOException e){
			e.printStackTrace();
		}
		browser.openBrowser(prop.getProperty("browsername"));
		driver.get(prop.getProperty("url"));
		
		
	}

	public Boolean verifyPage() {
		String actualTitle = driver.getTitle();
		return (actualTitle.equals(prop.getProperty("expectedTitle")));
	}
	public static String[] getcityData() throws Exception {        
	    
	  return Excel.Cityname();
	}
	public void selectcity() throws Exception {
		String city[]=new String[1];
		city=getcityData();
		
		driver.findElement(By.xpath(prop.getProperty("cityXpath"))).sendKeys(city[0]);
	}
	
	public void clickEnter(){
		Actions actions = new Actions(driver);
		Action sendEsc = actions.sendKeys(Keys.ENTER).build();
		sendEsc.perform();
	}

	
	public void allowingupdates() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable((driver.findElement(By.xpath(prop.getProperty("allowupdateXpath"))))));
		driver.findElement(By.xpath(prop.getProperty("allowupdateXpath"))).click();
	}

	public void cancelupdates() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable((driver.findElement(By.xpath(prop.getProperty("cancelupdateXpath"))))));
		driver.findElement(By.xpath(prop.getProperty("cancelupdateXpath"))).click();
	}
	public void Eventsclick() {
		driver.findElement(By.linkText(prop.getProperty("eventName1"))).click();	
	}

	public void closeBrowser() {
		driver.quit();
	}

}

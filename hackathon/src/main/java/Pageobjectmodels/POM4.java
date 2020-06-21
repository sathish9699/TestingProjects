package Pageobjectmodels;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class POM4 extends POM1 {
	Properties prop = new Properties();
	//To navigate to the home page
	public void navigatehomepage() throws FileNotFoundException {
		FileInputStream file = new FileInputStream(".\\src\\test\\resources\\objectRepository\\test.properties");
		try {
			prop.load(file);
		} catch (IOException e){
			e.printStackTrace();
		}
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@id=\"navbar\"]/div[2]/div/div[1]/div/a"))));
		driver.findElement(By.xpath("//*[@id=\"navbar\"]/div[2]/div/div[1]/div/a")).click();
	}
	//To click the sign in button
	public void Signin() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable((driver.findElement(By.xpath(prop.getProperty("Signinbtn1Xpath"))))));
		driver.findElement(By.xpath(prop.getProperty("Signinbtn1Xpath"))).click();
	}
	//To click the login via google button
	public void loginviagoogle() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(prop.getProperty("loginviagoogleXpath")))));
		driver.findElement(By.xpath(prop.getProperty("loginviagoogleXpath"))).click();
	}
}

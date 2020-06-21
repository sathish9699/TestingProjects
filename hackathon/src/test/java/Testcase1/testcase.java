package Testcase1;

import org.testng.annotations.Test;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Properties;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Browser.browserlaunch;
import Pageobjectmodels.POM1;
import Pageobjectmodels.POM2;
import Pageobjectmodels.POM3;
import Pageobjectmodels.POM4;
import Pageobjectmodels.POM5;

public class testcase extends POM1 {
	POM1 build= new POM1();
	POM2 build2= new POM2();
	POM3 build3= new POM3();
	POM4 build4= new POM4();
	POM5 build5= new POM5();
	browserlaunch browser= new browserlaunch();
	Properties prop = new Properties();
	ExtentReports report;
	ExtentTest test;
	
	@BeforeTest
	/*
	 * To generate extent reports 
	 * To launch the browser 
	 * To navigate to the url
	 */
	public void launchBrowserUrl() throws FileNotFoundException, MalformedURLException {
		ExtentHtmlReporter htmlReporter=new ExtentHtmlReporter(".\\src\\test\\resources\\Report\\Reporthack.html");
		report=new ExtentReports();
		report.attachReporter(htmlReporter);
		build.navigateURL();
	}
	@Test
	/*
	 * To verify the title 
	 * To select the city name 
	 * To navigate to the sports page 
	 * To apply the respective filters for the events to be displayed 
	 * To get the event details with date in the excel sheet
	 */
	public void Testcase1() throws Exception {
		test=report.createTest("sportsevents","To find the sports activities in your city for coming weekend, with lowest charges on top and to display the Name of the sports along with date");
		build.verifyPage();
		build.selectcity();
		build.clickEnter();
		Thread.sleep(7000);
		build.cancelupdates();
		build.Eventsclick();
		Thread.sleep(5000);
		build2.filteringSearchSports();
		Thread.sleep(10000);
		build2.outputdatasports();
		
		if(driver.getTitle().equals("Upcoming sports events in Chennai | Sporting Activities Near You - BookMyShow")) {
		test.log(Status.PASS,"sportsevents is passed and the details of the sports events is printed as per the filters applied");
		}else {
		test.log(Status.FAIL,"sportsevents is not passed and the details of the sports events is not printed as per the filters applied");
		}
		report.flush();
		System.out.println("*******************************************************************************************************");
	}
	@Test
	/*
	 * To navigate to the movies page 
	 * To apply the filters in the movies page 
	 * To get the different movie languages and print in the excel sheet
	 */
	public void Testcase2() throws IOException {
		test=report.createTest("Movielanguages","To extract all the languages for movies and store in a List and to display the same");
		build3.Eventsclick2();
		build3.filterclickMovies();
		build3.MovieLanguages();
		if(driver.getTitle().equals("Upcoming Movies 2020 | List of Movies Releasing This Week in Chennai - BookMyShow")) {
		test.log(Status.PASS,"Movielanguages is passed and all the languages for movies is stored in a List and displayed ");
		}else {
		test.log(Status.FAIL,"Movielanguages is not passed and all the languages for movies is not stored in a List and not displayed ");	
		}
		report.flush();
		System.out.println("*******************************************************************************************************");
	}
	@Test
	/*
	 * To click the sign in button and also to click the login via google buuton 
	 * To switch to the google sign in button 
	 * To give the inappropriate email id and to get the error msg displayed in the 
	 * excel sheet and also to navigate to the home page
	 */
	public void Testcase3() throws Exception {
		test=report.createTest("SignIn","To check whether the application is displaying error message when tried to sign in via google using invalid account details and also to print the error message");
		build4.navigatehomepage();
		Thread.sleep(3000);
		build4.Signin();
		String winHandle1 = driver.getWindowHandle();
		build4.loginviagoogle();
		for (String winhnd : driver.getWindowHandles()) {
			driver.switchTo().window(winhnd);
		}
		
		if (driver.getTitle().equals("Sign in – Google accounts")) {
			build5.SigninDetails();
			build5.SigninErrormsg();
		} else {
			driver.switchTo().window(winHandle1);
			build5.clickEscape();
			build4.Signin();
			build4.loginviagoogle();
			for (String winhnd : driver.getWindowHandles()) {
				driver.switchTo().window(winhnd);
			}
			build5.SigninDetails();
			build5.SigninErrormsg();
		}
		test.log(Status.PASS,"SignIn is passed and error message is printed when tried to login via google using invalid account details");
		report.flush();
		driver.switchTo().window(winHandle1);
		build5.clickEscape();
		build5.navigatehomepage();
	}

	@AfterTest
	//To quit all the browsers
	public void quitBrowser() {
		build.closeBrowser();
	}
}

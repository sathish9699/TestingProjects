package Browser;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class browserlaunch {
	public static WebDriver driver;

	public WebDriver openBrowser(String browsername) throws FileNotFoundException, MalformedURLException {

		if (browsername.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", ".//src//main//resources//Drivers//chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browsername.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver",".//src//main//resources//Drivers//geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browsername.equals("Microsoft Edge")) {
			System.setProperty("webdriver.edge.driver",".//src//main//resources//Drivers//msedgedriver.exe");
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
}


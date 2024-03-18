package config;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class AppUtil {
	public static Properties conpro;//static can be reused in another class
public static WebDriver driver;
@BeforeTest
public static void setup() throws Throwable
{
	conpro =new Properties();//calling property file
	conpro.load(new FileInputStream("./PropertyFiles/Environment.properties"));
	if(conpro.getProperty("Browser").equalsIgnoreCase("chrome"))
	{
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		
	}
	else if(conpro.getProperty("Browser").equalsIgnoreCase("firefox"))
	{
		driver= new FirefoxDriver();
	}
	else
	{
		Reporter.log("Browser value is not matching",true);
	}
}
	@AfterTest
	public static void tearDown()
	{
		driver.quit();
	}
}

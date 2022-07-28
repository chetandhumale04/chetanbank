package com.bankingproject.pageobjectclass;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.bankingproject.utilities.ReadConfig;

public class BaseClass {
	
	public static WebDriver driver;
	
	ReadConfig read = new ReadConfig();
	
    public String baseURL =read.getApplicationURL();
	public String username =read.getUserName();
	public String password =read.getUserPassword();
	
	public static ExtentSparkReporter sparkreporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	@BeforeSuite
    public void setReport()
   {
		Random random = new Random();
		int x = random.nextInt(100);
		
		sparkreporter = new ExtentSparkReporter("C:\\Users\\CHETAN\\eclipse-workspace\\chetanbank\\reports\\"+ x +".html");
	 extent = new	ExtentReports();	
	extent.attachReporter(sparkreporter);
		extent.setSystemInfo("Operating System", "windows");
		extent.setSystemInfo("Environment", "QC");
		sparkreporter.config().setReportName("Sytem and Fuctional testing");
		sparkreporter.config().setDocumentTitle("QC Automation test report");
		sparkreporter.config().setTheme(Theme.DARK);
    }
   
	@BeforeMethod
//	 @Parameters("browser")
	public void setup()
	{
		
//		if(src.equals("chrome")) {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\CHETAN\\eclipse-workspace\\chetanbank\\resourse\\chromedriver_win32 (2)\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(baseURL);
//		}
//		
//		else if(src.equals("edge")) {
//			
//			System.setProperty("webdriver.edge.driver","C:\\Users\\CHETAN\\eclipse-workspace\\chetanbank\\resourse\\edgedriver_win64\\msedgedriver.exe");
//			driver = new FirefoxDriver();
//			driver.get(baseURL);
			}
	public static String  captureScreen() throws IOException
	
	
	{
		Random random = new Random();
		int x = random.nextInt(100);
		
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		String dest = "C:\\Users\\CHETAN\\eclipse-workspace\\chetanbank\\Screenshots\\" + x +".png";
		FileUtils.copyFile(source, new File(dest));
		return dest;
	}
		

   
	

	@AfterMethod
	public void closeBrowser()
	{
		driver.quit();
	}
   @AfterSuite
   public void endReport()
  {
  	extent.flush();
   }
   
  
}

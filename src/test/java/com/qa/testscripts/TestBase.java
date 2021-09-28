package com.qa.testscripts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.qa.pages.W3SchoolPages;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase
{
	WebDriver driver;
	W3SchoolPages w3SchoolOR;
	JavascriptExecutor js;
	FileInputStream propFileLoc;
	Properties prop;
	@Parameters({"browser","url"})
	@BeforeClass
	public void setUp(String browser,String url) throws IOException
	{
		if(browser.equalsIgnoreCase("Chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("Firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("InternetExplorer"))
		{
			WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver();
		}
		else if(browser.equalsIgnoreCase("Edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		w3SchoolOR=new W3SchoolPages(driver);
		js=(JavascriptExecutor)driver;
		propFileLoc=new FileInputStream("C:\\Users\\KUNDAN KUMAR RAI\\Selenium\\W3SchoolDemo\\src\\test\\java\\com\\qa\\testdata\\TestData.properties");
		prop=new Properties();
		prop.load(propFileLoc);
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@AfterClass
	public void tearDown() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.quit();
	}
}

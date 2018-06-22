package com.clusters.generic.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateDriver 
{
	public static WebDriver getDriverInstance()
	{
		String browser_type = 
			DataHandlers.getDataFromProperties("config", "browser");
		String url = 
				DataHandlers.getDataFromProperties("config", "url");
			
		WebDriver driver = null;
		if(browser_type.toLowerCase().equals("ff"))
		{
			System.setProperty("webdriver.firefox.marionette", 
					"./browser-server/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(browser_type.toLowerCase().equals("gc"))
		{
			System.setProperty("webdriver.chrome.driver", 
					"./browser-server/chromedriver.exe");
			driver = new ChromeDriver();
		}
		else
		{
			System.err.println("-----Invalid browser selection -------");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(url);
		return driver;
	}
}

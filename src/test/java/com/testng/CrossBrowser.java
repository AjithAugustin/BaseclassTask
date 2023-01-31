package com.testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CrossBrowser {
	WebDriver driver;
	@Parameters("browser")
	@Test
	private void crossBrowserTest(String browser) {
	
		if (browser.equals("chrome")) {
			
			WebDriverManager.chromedriver().setup();
		    driver = new ChromeDriver();
		  
			driver.manage().window().maximize();
		}
		else if (browser.equals("edge")) {
			
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.manage().window().maximize();
		}
		  driver.get("https:\\www.facebook.com/");
	}

}

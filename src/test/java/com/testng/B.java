package com.testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.base.BaseClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class B extends BaseClass {
	
	WebDriver driver;
	@Parameters("browser")
	@Test
	public void cross(String browser) {
		
		switch (browser) {
		case "c":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			break;
			
		case "f":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			break;
			
		case "e":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			break;

		default:
			break;
		}
		
		driver.get("https://adactinhotelapp.com/");
	
	}
}

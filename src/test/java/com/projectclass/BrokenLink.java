package com.projectclass;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLink {

	public static void main(String[] args) throws IOException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.automationtesting.in/Register.html");
		driver.manage().window().maximize();
		
		List<WebElement> images = driver.findElements(By.tagName("img"));
		System.out.println(images.size());
		for (WebElement element : images) {
			
			String attribute = element.getAttribute("src");
			System.out.println(attribute);
		}
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		
		System.out.println(links.size());
		
		// Broken link
		
		int brLink =0; 
		for (WebElement element : links) {
			
			String attribute = element.getAttribute("href");
//			System.out.println(attribute);
			
			if (attribute!=null) {
				
				URL url = new URL(attribute);
				URLConnection openConnection = url.openConnection();
				HttpURLConnection connection = (HttpURLConnection) openConnection;
				int responseCode = connection.getResponseCode();
				
				if(responseCode>=400) {
					
					
					System.out.println("broken Link is:"+ attribute);
					
					brLink++;
				}
				
				
			}
		}
		
		
		System.out.println("BrokenLink count :"+brLink);
		driver.quit();
	}
	
	
}

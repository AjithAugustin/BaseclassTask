package com.projectclass;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.base.BaseClass;

public class ProjectClass extends BaseClass {
	
	
	public static void main(String[] args) {
		getDriver();
		getUrl("https://demo.wpjobboard.net/wp-login.php?redirect_to=https%3A%2F%2Fdemo.wpjobboard.net%2Fwp-admin%2F&reauth=1 ");
		maximizeWindow();
		
		driver.findElement(By.id("wp-submit")).click();
		WebElement job = driver.findElement(By.xpath("//div[text()='Job Board']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(job).perform();
	    driver.findElement(By.xpath("//a[text()='Applications ']")).click();
	    
	    List<WebElement> elements = driver.findElements(By.xpath("//a[text()='Front-End Web Developer']//parent::td//preceding::td"));
		
	    for (WebElement element : elements) {
			
	    	System.out.println(element.getText());
		}
	
	
	 List<WebElement> element1 = driver.findElements(By.xpath("//a[text()='Front-End Web Developer']//parent::td//following::td"));
		
	    for (WebElement element : element1) {
			
	    	System.out.println(element.getText());
		}
	    
 List<WebElement> element2 = driver.findElements(By.xpath("//a[text()='Front-End Web Developer']//ancestor::td//following::td"));
		
	    for (WebElement element : element2) {
			
	    	System.out.println(element.getText());
		}
	    
 List<WebElement> element3 = driver.findElements(By.xpath("//a[text()='Front-End Web Developer']//ancestor::td//preceding::td"));
		
	    for (WebElement element : element3) {
			
	    	System.out.println(element.getText());
		}
	}

	//a[text()='Front-End Web Developer']//parent::td//preceding::td
	
	//a[text()='Front-End Web Developer']//parent::td//following::td
	
	//a[text()='Front-End Web Developer']//ancestor::td//following::td
	
	//a[text()='Front-End Web Developer']//ancestor::td//preceding::td

}


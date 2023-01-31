package com.projectclass;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.base.BaseClass;

public class Exceptions extends BaseClass {
	
	public static void main(String[] args) {
		
		getDriver();
		getUrl("https://www.instagram.com/");
		maximizeWindow();
	
		WebElement element = driver.findElement(By.xpath("//button[@class='_acan _acap _acas _aj1-']"));
		
		System.out.println(element.isDisplayed());
//		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone",Keys.ENTER);
//		driver.findElement(By.xpath("//span[text()='Apple iPhone 13 (128GB) - (Product) RED'][@class='a-size-medium a-color-base a-text-normal']")).click();
//		String window = driver.getWindowHandle();
//		System.out.println(window);
//		
//		driver.switchTo().alert();
//		driver.switchTo().frame("one");
//		driver.switchTo().window("window");
//		
//		//driver.findElement(By.id("add-to-cart-button")).click();
	}
	
	
;
}

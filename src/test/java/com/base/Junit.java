package com.base;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Junit {
//	static WebDriver driver;
//	@BeforeClass
	public static void beforeClass() {
//	//System.out.println("beforeClass");
//	WebDriverManager.chromedriver().setup();
//	driver = new ChromeDriver();
//    driver.get("https://adactinhotelapp.com/");
	}
	@Before
	public void beforeTest() {
		//System.out.println("before");
		long time = System.currentTimeMillis();
		System.out.println(time);

	}
	@Test
	public void login() {
//		//System.out.println("login");	
//		WebElement txtUserName = driver.findElement(By.id("username"));
//		txtUserName.sendKeys("Greens8767");
//		String name = txtUserName.getAttribute("value");
//		System.out.println(name);
//		Assert.assertEquals("Verify username", "Greens8767", name);
//		
//		WebElement txtPassword = driver.findElement(By.id("password"));
//		txtPassword.sendKeys("L4R739");
//		String pass = txtPassword.getAttribute("value");
//		System.out.println(pass);
//		Assert.assertEquals("Verify password", "L4R739", pass);
//		
//		WebElement btnLogin = driver.findElement(By.id("login"));
//		btnLogin.click();
//		
//		String title = driver.getTitle();
//		System.out.println(title);
//		boolean b = title.startsWith("adactin");
//		Assert.assertTrue("verify title",b);
	}
	@Test
	public void test() {
		
		Result result = JUnitCore.runClasses(AdactinHotel.class,AdactinJUnit.class);
		int runCount = result.getRunCount();
		System.out.println(runCount);
		int failureCount = result.getFailureCount();
		System.out.println(failureCount);
		List<Failure> failures = result.getFailures();
		for (Failure failure : failures) {
			System.out.println(failure);
			System.out.println(failure.getMessage());
			}
		long runTime = result.getRunTime();
		System.out.println(runTime);
		int ignoreCount = result.getIgnoreCount();
		System.out.println(ignoreCount);
		boolean wasSuccessful = result.wasSuccessful();
		System.out.println(wasSuccessful);
	}
	
	@After
	public void afterTest() {
		//System.out.println("after");
		long time = System.currentTimeMillis();
		System.out.println(time);

	}
	
	@AfterClass
	public static void afterClass() {
//		//System.out.println("afterClass");
//		driver.quit();

	}
	

}

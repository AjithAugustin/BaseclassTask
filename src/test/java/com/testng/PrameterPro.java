package com.testng;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.base.BaseClass;

public class PrameterPro extends BaseClass {
	
	@Parameters({"user","pass"})
	@Test
	public void d(String username,String password) {
		getDriver();
		getUrl("https://www.facebook.com/");
		findElementById("email").sendKeys(username);
		findElementById("pass").sendKeys(password);
		closeAllWindow();

       }
	
	
}

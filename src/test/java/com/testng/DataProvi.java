package com.testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.base.BaseClass;

public class DataProvi extends BaseClass {
	@Test(dataProvider="test")
	public void d(String username,String password) {
		getDriver();
		getUrl("https://adactinhotelapp.com/");
		findElementById("username").sendKeys(username);
		findElementById("password").sendKeys(password);
		closeAllWindow();
	}
	@DataProvider(name="test")
	private Object[][] dataPro() {
		Object data [][] =new Object[3][2];
		data[0][0]="Cristiano17";
		data[0][1]="godson@17";
		
		data[1][0]="godson";
		data[1][1]="godson";
		
		data[2][0]="godson";
		data[2][1]="godson";
		
		return data;
		
	}

}

package com.testng;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HardAndSoftAssert {
	
	@Test
	private void t1() {
		
		System.out.println("t1");

	}
	@Test
	private void t2() {
		
		System.out.println(1);
		Assert.assertTrue(true);
		System.out.println(2);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(false);
        System.out.println(3);
        softAssert.assertAll();
        System.out.println(4);
        System.out.println("t2");
	}
	@Test
	private void t3() {
		
		System.out.println("t3");

	}

}

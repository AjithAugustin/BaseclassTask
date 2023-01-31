package com.testng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Rerun {
	@Test
	private void t1() {
		Assert.assertTrue(false);
		System.out.println("t1");

	}
	@Test
	private void t2() {
		
       System.out.println("t2");
	}
	@Test(retryAnalyzer=RerunFail.class)
	private void t3() {
		Assert.assertTrue(false);
		System.out.println("t3");

	}
	@Test
	private void t4() {
		
       System.out.println("t4");
	}

}

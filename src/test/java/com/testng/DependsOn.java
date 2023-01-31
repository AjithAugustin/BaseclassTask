package com.testng;

import org.testng.annotations.Test;

public class DependsOn {
	@Test(groups="Reg",dependsOnGroups="sanity")
	private void m1() {
		System.out.println("m1");

	}
	@Test(groups="sanity",dependsOnGroups="smoke")
    private void m2() {
		System.out.println("m2");

	}
	@Test(groups="smoke")
    private void m3() {
		System.out.println("m3");

   }

}
